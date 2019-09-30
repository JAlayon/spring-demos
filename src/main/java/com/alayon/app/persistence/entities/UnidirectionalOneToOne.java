package com.alayon.app.persistence.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class UnidirectionalOneToOne {

	@Id
	@GeneratedValue
	private int id;
	
	@Column
	private String value;
	
	@OneToOne(cascade = CascadeType.ALL)
	private AnyEntity anyEntity;
	
	
	public UnidirectionalOneToOne() {}


	public UnidirectionalOneToOne(String value) {
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
