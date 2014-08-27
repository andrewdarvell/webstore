package ru.darvell.webstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import ru.darvell.webstore.entity.PropDict;
import ru.darvell.webstore.repository.PropDictRepository;
import ru.darvell.webstore.service.PropDictService;

import java.util.List;

public class PropDictServiceImpl implements PropDictService{

	@Autowired
	private PropDictRepository propDictRepository;

	@Override
	public PropDict addPropDict(PropDict propDict) {
		return propDictRepository.saveAndFlush(propDict);
	}

	@Override
	public PropDict editPropDict(PropDict propDict) {
		return propDictRepository.saveAndFlush(propDict);
	}

	@Override
	public List<PropDict> getAll() {
		return propDictRepository.findAll();
	}

	@Override
	public void deletePropDict(long id) {
		propDictRepository.delete(id);
	}
}
