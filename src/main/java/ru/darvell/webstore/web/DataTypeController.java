package ru.darvell.webstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.darvell.webstore.entity.DataType;
import ru.darvell.webstore.service.DataTypeService;

import java.util.Map;

@Controller
public class DataTypeController {

	@Autowired
	private DataTypeService dataTypeService;


	@RequestMapping("/")
	public String home() {
		return "redirect:/index";
	}

	@RequestMapping("/index")
	public String listDataTypes(Map<String, Object> map) {

		map.put("dataType", new DataType());
		map.put("dataTypeList", dataTypeService.getAll());

		return "datatypes";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addContact(@ModelAttribute("dataType") DataType dataType,BindingResult result) {

		dataTypeService.addDataType(dataType);

		return "redirect:/datatypes/index";
	}


}

