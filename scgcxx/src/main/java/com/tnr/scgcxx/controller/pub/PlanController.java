package com.tnr.scgcxx.controller.pub;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tnr.scgc.base.PlanStatusEnum;
import com.tnr.scgc.base.StatusEnum;

@RestController
@RequestMapping("/plan")
public class PlanController {
	
	/*public StatusEnum[] status() {
		return StatusEnum.values();
	}*/
	@RequestMapping("/status")
	public List<Map<String,String>> status(){
		
		PlanStatusEnum[] arr=PlanStatusEnum.values();
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		
		for(PlanStatusEnum se : arr) {
			Map<String,String> map = new HashMap<String,String>();
			map.put("code",se.getCode());
			map.put("name", se.getName());
			list.add(map);
		}
		return list;		
	}

}
