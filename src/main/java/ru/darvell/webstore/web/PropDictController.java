package ru.darvell.webstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.darvell.webstore.service.PropDictService;

import java.util.Map;

@Controller
public class PropDictController {

	@Autowired
	private PropDictService propDictService;

	@RequestMapping("/propertys")
	public String getAllProperties(Map<String, Object> result){
		result.put("propDictList", propDictService.getAll());
		return "propdictlist";

	}



}
