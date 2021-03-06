package ru.darvell.webstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.darvell.webstore.entity.DataType;
import ru.darvell.webstore.repository.DataTypeRepository;
import ru.darvell.webstore.service.DataTypeService;

import java.util.List;

@Service
public class DataTypeServiceImpl implements DataTypeService{

	@Autowired
	private DataTypeRepository dataTypeRepository;

	@Override
	public DataType addDataType(DataType dataType) {
		return dataTypeRepository.saveAndFlush(dataType);
	}

	@Override
	public DataType editDatType(DataType dataType) {
		return dataTypeRepository.saveAndFlush(dataType);
	}

	@Override
	public List<DataType> getAll() {
		return dataTypeRepository.findAll();
	}

	@Override
	public void deleteDataType(long id) {
		dataTypeRepository.delete(id);
	}

	@Override
	public DataType getDataTypeById(long id) {
		return dataTypeRepository.findOne(id);
	}
}
