package com.tnr.scgcxx.shiro;

import java.text.MessageFormat;
import java.util.List;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.tnr.scgcxx.dto.CurrUser;
import com.tnr.scgcxx.model.Module;
import com.tnr.scgcxx.model.User;

@Configuration
public class ShiroConfign {
	
	private static final Logger LOG=LoggerFactory.getLogger(ShiroConfign.class);
			
	
	//注册跨域过滤器
	
	@Bean
    public FilterRegistrationBean<CorsFilter> corsFilter() {
        
    	final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        
    	final CorsConfiguration config = new CorsConfiguration();
    	
        // 允许cookies跨域
        config.setAllowCredentials(true);
        
        // 允许向该服务器提交请求的URI，*表示全部允许，在SpringMVC中，如果设成*，会自动转成当前请求头中的Origin
        config.addAllowedOrigin("*");
        
        // 允许访问的头信息,*表示全部
        config.addAllowedHeader("*");
        
        // 预检请求（options请求）的缓存时间（秒），即在这个时间段里，对于相同的跨域请求不会再预检了
        config.setMaxAge(1L);
        
        // 允许提交请求的方法，*表示全部允许
        config.addAllowedMethod("*");
        /*
        config.addAllowedMethod("OPTIONS");
        config.addAllowedMethod("HEAD");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("DELETE");
        config.addAllowedMethod("PATCH");
        */
        
        //设置允许跨域的路径
        source.registerCorsConfiguration("/**", config);

        FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<CorsFilter>(new CorsFilter(source));
        
        // 设过滤器的优先级
        bean.setOrder(0);

        return bean;
    }
	
	
	 /*
	    *   配置安全数据源Realm
	    *   此处必须要命名“authorizer”，
	    *   因为shiro会自动寻找名称为“authorizer”的、并实现接口Authorizer的对象,
	    *   而AuthorizingRealm正是接口Authorizer的实现类
	    */
	    @Bean("authorizer")
	    @Autowired
	    public AuthorizingRealm saftyRealm(ShiroService shiroService) {
	        
	        return new AuthorizingRealm() {

	            /**
	            * 获取当事人（当前用户）授权信息，shiro在检查访问是否经过授权时需要通过该方法获取授权信息。
	            * 参数PrincipalCollection 当事人集合
	            */	
	            @Override
	            protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

	                /*
	                * 获取登录用户帐号
	                */
	                CurrUser currUser = (CurrUser) principalCollection.getPrimaryPrincipal();// 获取首要（第一）当事人

	                /*
	                * 创建授权信息对象
	                */
	                SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

	                
	                        
	                /*
	                * 查询用户权限，并将权限放入授权信息对象中		 
	                */
	                List<Module> moduleList = shiroService.getModulesOfUser(currUser.getUserId());
	                for (Module module : moduleList) {
	                    simpleAuthorizationInfo.addStringPermission(String.valueOf(module.getM_id()));
	                }

	                // System.out.println(currUser.getUserId()+"->"+simpleAuthorizationInfo.getStringPermissions());

	                /*
	                * 返回授权信息
	                */
	                return simpleAuthorizationInfo;
	            }

	            /**
	            * 获取认证信息（即包含当前用户帐户和合法密码等信息）
	            * shiro在登录认证时需要通过该方法获取认证信息。
	            * 参数 AuthenticationToken 认证令牌（如：一组用户名和密码就是一个认证令牌）
	            */
	            @Override
	            protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)  {

	                String userId = (String) token.getPrincipal();// 获得当事人（当前用户账号）

	                User user = shiroService.getUser(userId);

	                /*
	              		如果不存在前用户信息，返回null
	                */
	                if (user == null) {
	                    return null;
	                }

	                /*
	                	创建当前用户
	                */
	                CurrUser currUser = new CurrUser();
	                currUser.setUserId(user.getU_id());
	                currUser.setUserName(user.getU_name());
	                
	                
	                /*
	                	创建认证信息，三个构造参数含义依次如下：
	                	参数1：principal当前用户 
	               		参数2：credentials认证凭证（如：口令、密码等）
	         			参数3：realm名称
	                */
	                SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(currUser, user.getU_pwd(), this.getName());

	                /*
	                	返回认证信息
	                */
	                return info;
	            }
	            
	        } ;
	    }
	    
	    
	    
	    @Bean @Autowired
	    public ShiroFilterChainDefinition shiroFilterChainDefinition(ShiroService shiroService) {
	        
	        DefaultShiroFilterChainDefinition chainDefinition = 
	                                                    new DefaultShiroFilterChainDefinition();
	        
	    
	        /*
	            可匿名访问资源
	        */
	        chainDefinition.addPathDefinition("/css/**", "anon");
	        chainDefinition.addPathDefinition("/elementui/**", "anon");
	        chainDefinition.addPathDefinition("/js/**", "anon");
	        chainDefinition.addPathDefinition("/safty/login/**", "anon");
	        
	        
	        //加载动态权限 
	        List<Module> moduleList = shiroService.getAllSubModules();
	        
	        String PREMISSION_FORMAT = "authc,perms[{0}]";
	        
	        //动态权限设置
	        for(Module module:moduleList) {
	            
	        	if(StringUtils.isEmpty(module.getM_url())) {
	                continue;
	            }
	            
	            
	            chainDefinition.addPathDefinition(module.getM_url().replace("index.html", "**"), MessageFormat.format(PREMISSION_FORMAT, String.valueOf(module.getM_id())));
	            
	            
	        }
	        
	        //其它资源必须经过认证
	        chainDefinition.addPathDefinition("/**", "authc");
	        
	        LOG.debug("=====Shiro安全规则=======================================================================");
	        LOG.debug(chainDefinition.getFilterChainMap().toString());
	        LOG.debug("=====Shiro安全规则=======================================================================");
	        
	        return chainDefinition;
	    }
	    
	
	

}
