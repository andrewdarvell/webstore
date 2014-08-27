package ru.darvell.webstore.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.darvell.webstore.entity.DataType;

public interface DataTyeRepository extends JpaRepository<DataType, Long>{
}
