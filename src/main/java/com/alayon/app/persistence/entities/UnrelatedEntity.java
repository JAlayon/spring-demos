package com.alayon.app.persistence.entities;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.GenerationType;


@Entity(name="un_related")
public class UnrelatedEntity implements Serializable{

	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	//nombre por defecto de la columna
	@Column(name="nickname", unique=true, nullable=false, length = 30)
	private String nickname;
	
	@Enumerated(EnumType.STRING)
	@Column(length=20)
	private Gender gender;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	private Calendar bornDate;
	
	//String largo
	@Lob
	@Column
	private String text;
	
	
	//ArrayList se comporta de igual forma. Se almacenan embebidos
	@Column
	private String strings[];
	
	
	//Se almacena en otra tabla
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="un_related_list")
	private List<String> list;
	
	
	@Transient
	private String noPersistent;
	
	
	public UnrelatedEntity() {
	}


	public UnrelatedEntity(String nickname, Gender gender, Calendar bornDate, String text, String[] strings,
			List<String> list, String noPersistent) {
		super();
		this.nickname = nickname;
		this.gender = gender;
		this.bornDate = bornDate;
		this.text = text;
		this.strings = strings;
		this.list = list;
		this.noPersistent = noPersistent;
	}


	public int getId() {
		return id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Gender getGender() {
		return gender;
	}


	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Calendar getBornDate() {
		return bornDate;
	}

	public void setBornDate(Calendar bornDate) {
		this.bornDate = bornDate;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String[] getStrings() {
		return strings;
	}

	public void setStrings(String[] strings) {
		this.strings = strings;
	}


	public List<String> getList() {
		return list;
	}


	public void setList(List<String> list) {
		this.list = list;
	}


	public String getNoPersistent() {
		return noPersistent;
	}


	public void setNoPersistent(String noPersistent) {
		this.noPersistent = noPersistent;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bornDate == null) ? 0 : bornDate.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + id;
		result = prime * result + ((list == null) ? 0 : list.hashCode());
		result = prime * result + ((nickname == null) ? 0 : nickname.hashCode());
		result = prime * result + ((noPersistent == null) ? 0 : noPersistent.hashCode());
		result = prime * result + Arrays.hashCode(strings);
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UnrelatedEntity other = (UnrelatedEntity) obj;
		if (bornDate == null) {
			if (other.bornDate != null)
				return false;
		} else if (!bornDate.equals(other.bornDate))
			return false;
		if (gender != other.gender)
			return false;
		if (id != other.id)
			return false;
		if (list == null) {
			if (other.list != null)
				return false;
		} else if (!list.equals(other.list))
			return false;
		if (nickname == null) {
			if (other.nickname != null)
				return false;
		} else if (!nickname.equals(other.nickname))
			return false;
		if (noPersistent == null) {
			if (other.noPersistent != null)
				return false;
		} else if (!noPersistent.equals(other.noPersistent))
			return false;
		if (!Arrays.equals(strings, other.strings))
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		return true;
	}
	
	
	
}
