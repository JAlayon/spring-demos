package com.alayon.app.persistence.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class AnyEntity {

	@Id
	@GeneratedValue
	private int id;
	
	
	@Column
	private String value;


	public AnyEntity(String value) {
		this.value = value;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getValue() {
		return value;
	}


	public void setValue(String value) {
		this.value = value;
	}
	
	
	
	
}
