package ru.darvell.webstore.entity;

import org.hibernate.annotations.GenericGenerator;
import sun.plugin2.message.Message;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "prop_dict")
public class PropDict {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "id_prop_dict",nullable = false)
	private long idPropDict;

	@NotNull(message = "Мнемоника должна быть указана")
	@Column(name = "name")
	private String name;

	@Column(name = "descr")
	private String descr;

	@NotNull(message = "Тип даннх должен быть заполнен")
	@ManyToOne
	@JoinColumn(name = "data_type_id")
	private DataType dataType;

	public PropDict() {
	}

	public PropDict(long idPropDict, String name, String descr, DataType dataType) {
		this.idPropDict = idPropDict;
		this.name = name;
		this.descr = descr;
		this.dataType = dataType;
	}

	@Override
	public String toString() {
		return "PropDict{" +
				"idPropDict=" + idPropDict +
				", name='" + name + '\'' +
				", descr='" + descr + '\'' +
				", dataType=" + dataType +
				'}';
	}

	public long getIdPropDict() {
		return idPropDict;
	}

	public void setIdPropDict(long idPropDict) {
		this.idPropDict = idPropDict;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public DataType getDataType() {
		return dataType;
	}

	public void setDataType(DataType dataType) {
		this.dataType = dataType;
	}
}
