package com.tnr.scgcxx.controller.pub;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tnr.scgc.base.PlanStatusEnum;
import com.tnr.scgc.base.ProcessStatusEnum;
import com.tnr.scgc.base.StatusEnum;

@RestController
@RequestMapping("/process")
public class ProcessController {
	
	/*public StatusEnum[] status() {
		return StatusEnum.values();
	}*/
	@RequestMapping("/status")
	public List<Map<String,String>> status(){
		
		ProcessStatusEnum[] arr=ProcessStatusEnum.values();
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		
		for(ProcessStatusEnum se : arr) {
			Map<String,String> map = new HashMap<String,String>();
			map.put("code",se.getCode());
			map.put("name", se.getName());
			list.add(map);
		}
		return list;		
	}

}
