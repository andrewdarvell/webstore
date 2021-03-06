package ru.darvell.webstore.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "data_type")
public class DataType {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "id_data_type",nullable = false)
	private long idDataType;

	@Column(name = "type")
	private String type;

	@Column(name = "length")
	private int length;


	public DataType() {
	}

	public DataType(long idDataType, String type, int length) {
		this.idDataType = idDataType;
		this.type = type;
		this.length = length;
	}

	@Override
	public String toString() {
		return "DataType{" +
				"idDataType=" + idDataType +
				", type='" + type + '\'' +
				", length=" + length +
				'}';
	}

	public long getIdDataType() {
		return idDataType;
	}

	public void setIdDataType(long idDataType) {
		this.idDataType = idDataType;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
}
