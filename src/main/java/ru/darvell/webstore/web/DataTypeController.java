package ru.darvell.webstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.darvell.webstore.entity.DataType;
import ru.darvell.webstore.service.DataTypeService;

import java.util.Map;

@Controller
public class DataTypeController {

	@Autowired
	private DataTypeService dataTypeService;


	@RequestMapping("/datatypes/index")
	public String home() {
		return "redirect:/datatypes";
	}

	@RequestMapping("/datatypes")
	public String listDataTypes(Map<String, Object> map) {

		map.put("dataType", new DataType());
		map.put("dataTypeList", dataTypeService.getAll());

		return "datatypes";
	}

	@RequestMapping("/datatypes/view&id={idDataType}")
	public String editDataType(@PathVariable("idDataType") Long id,
								Map<String, Object> map) {

		DataType dataType = dataTypeService.getDataTypeById(id);
		if(dataType != null){
			map.put("dataType", dataType);
			System.out.println("Edit data type request  "+dataType.toString());
		}else {
			map.put("dataType", new DataType());
		}
		map.put("dataTypeList", dataTypeService.getAll());
		return "datatypes";
	}

	@RequestMapping(value = "/datatypes/add", method = RequestMethod.POST)
	public String addDataType(@ModelAttribute("dataType") DataType dataType, BindingResult result) {

		System.out.println(dataType.toString());
		dataTypeService.addDataType(dataType);

		return "redirect:/datatypes";
	}

	@RequestMapping("/datatypes/delete&id={idDataType}")
	public String deleteDataType(@PathVariable("idDataType") Long id){
		dataTypeService.deleteDataType(id);
		return "redirect:/datatypes";
	}

}

