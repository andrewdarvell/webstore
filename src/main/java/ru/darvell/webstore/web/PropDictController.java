package ru.darvell.webstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.darvell.webstore.entity.DataType;
import ru.darvell.webstore.entity.PropDict;
import ru.darvell.webstore.service.DataTypeService;
import ru.darvell.webstore.service.PropDictService;

import java.util.List;
import java.util.Map;

@Controller
public class PropDictController {

	@Autowired
	private PropDictService propDictService;

	@Autowired
	private DataTypeService dataTypeService;

	@RequestMapping(method=RequestMethod.GET, value ="/propertys")
	public ModelAndView getPropertys(){
		List<PropDict> propDicts = propDictService.getAll();

		return "propdictlist";
	}


}