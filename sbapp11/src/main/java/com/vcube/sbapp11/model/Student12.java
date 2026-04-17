package com.vcube.sbapp11.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name="Student1")
@Entity
@Data
public class Student12 {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int sid;
	int regdno;
	String name;
	long contact;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public int getRegdno() {
		return regdno;
	}
	public void setRegdno(int regdno) {
		this.regdno = regdno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getContact() {
		return contact;
	}
	public void setContact(long contact) {
		this.contact = contact;
	}

}
