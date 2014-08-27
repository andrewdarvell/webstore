package ru.darvell.webstore.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.darvell.webstore.entity.DataType;

public interface DataTypeRepository extends JpaRepository<DataType, Long>{
}
