package ru.darvell.webstore.service;

import ru.darvell.webstore.entity.PropDict;

import java.util.List;

public interface PropDictService {

	PropDict addPropDict(PropDict propDict);
	PropDict editPropDict(PropDict propDict);
	List<PropDict> getAll();
	void deletePropDict(long id);
}
