package ru.darvell.webstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.darvell.webstore.entity.DataType;
import ru.darvell.webstore.entity.PropDict;
import ru.darvell.webstore.service.DataTypeService;
import ru.darvell.webstore.service.PropDictService;

import java.util.Map;

@Controller
public class PropDictController {

	@Autowired
	private PropDictService propDictService;

	@Autowired
	private DataTypeService dataTypeService;

	@RequestMapping("/propertys")
	public String getAllProperties(Map<String, Object> map){
		map.put("propDict", new PropDict());
		map.put("propDictList", propDictService.getAll());
		map.put("dataTypeList",dataTypeService.getAll());
		return "propdictlist";
	}

	@RequestMapping(value = "/propertys/add", method = RequestMethod.POST)
	public String addDataType(
	//@ModelAttribute("propDict") PropDict propDict,
							//@RequestParam("idPropDict") Long idPropDict,
							//@RequestParam("name") String name,
							//@RequestParam("dataType") Long dataTypeId,
							//@RequestParamq("descr") String descr,
							BindingResult result) {
		//propDictService.addPropDict(propDict);
		/*PropDict propDict;
		if(idPropDict != 0){
			propDict = new PropDict();
		}else {
			propDict = new PropDict();
		}

		propDict.setName(name);
		propDict.setIdPropDict(idPropDict);
		propDict.setDescr(descr);
		propDict.setDataType(dataTypeService.getDataTypeById(dataTypeId));
		propDictService.editPropDict(propDict);
		*/
		//System.out.println(name);

		return "redirect:/propertys";
	}
}