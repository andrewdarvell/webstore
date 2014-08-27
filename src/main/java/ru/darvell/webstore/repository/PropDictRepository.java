package ru.darvell.webstore.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.darvell.webstore.entity.PropDict;

public interface PropDictRepository extends JpaRepository<PropDict, Long> {
}
