package com.tnr.scgcxx.controller.pub;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tnr.scgc.base.PlanStatusEnum;
import com.tnr.scgc.base.StatusEnum;
import com.tnr.scgc.base.TypeEnum;

@RestController
@RequestMapping("/process")
public class TypeController {
	
	/*public StatusEnum[] status() {
		return StatusEnum.values();
	}*/
	@RequestMapping("/type")
	public List<Map<String,String>> status(){
		
		
		TypeEnum[] arr = TypeEnum.values();
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		
		for(TypeEnum se : arr) {
			Map<String,String> map = new HashMap<String,String>();
			map.put("code",se.getCode());
			map.put("name", se.getName());
			list.add(map);
		}
		return list;		
	}

}
