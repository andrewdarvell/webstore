package ru.darvell.webstore.service;

import ru.darvell.webstore.entity.DataType;

import java.util.List;

public interface DataTypeService {

	DataType addDataType(DataType dataType);
	DataType editDatType(DataType dataType);
	List<DataType> getAll();
	void deleteDataType(long id);
	DataType getDataTypeById(long id);
}
