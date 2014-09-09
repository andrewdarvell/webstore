package ru.darvell.webstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.darvell.webstore.entity.DataType;
import ru.darvell.webstore.entity.PropDict;
import ru.darvell.webstore.service.DataTypeService;
import ru.darvell.webstore.service.PropDictService;

import java.util.List;

@Controller
public class PropDictController {

	@Autowired
	private PropDictService propDictService;

	@Autowired
	private DataTypeService dataTypeService;

	@RequestMapping(method=RequestMethod.GET, value ="/propertys")
	public String getPropertys(Model model){
		model.addAttribute("propDictList", propDictService.getAll());
		model.addAttribute("dataTypeList", dataTypeService.getAll());
		model.addAttribute("propDict",new PropDict());
		return "propdictlist";
	}

	@RequestMapping(value = "/propertys/add", method = RequestMethod.POST)
	public String addProperty(@ModelAttribute("propDict") PropDict propDict,
							  BindingResult result){
		System.out.println(propDict.toString());
		propDictService.addPropDict(propDict);

		return "redirect:/propertys";
	}

	@RequestMapping("/propertys/view&id={idPropDict}")
	public String editProperty(@PathVariable("idPropDict") long idPropDict,
							   Model model){

		PropDict propDict = propDictService.getPropDictById(idPropDict);
		if(propDict != null){
			model.addAttribute("propDict", propDict);
			model.addAttribute("propDictList", propDictService.getAll());
			model.addAttribute("dataTypeList", dataTypeService.getAll());
			return "propdictlist";
		}else {
			return "redirect:/propertys";
		}
	}

	@RequestMapping("/propertys/delete&id={idPropDict}")
	public String deleteDataType(@PathVariable("idPropDict") Long id){
		propDictService.deletePropDict(id);
		return "redirect:/propertys";
	}
}