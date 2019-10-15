package com.tnr.scgcxx.controller.pub;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tnr.scgc.base.StatusEnum;

@RestController
@RequestMapping("/pub")
public class PublicController {
	
	/*public StatusEnum[] status() {
		return StatusEnum.values();
	}*/
	@RequestMapping("/status")
	public List<Map<String,String>> status(){
		
		StatusEnum[] arr=StatusEnum.values();
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		
		for(StatusEnum se : arr) {
			Map<String,String> map = new HashMap<String,String>();
			map.put("code",se.getCode());
			map.put("name", se.getName());
			list.add(map);
		}
		return list;		
	}

}
