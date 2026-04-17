package com.vcube.sbapp11.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Student Entity Model - Represents a student record in the database
 * 
 * This class maps to the "Student1" table in MySQL database and contains
 * all student-related fields and their getters/setters.
 * 
 * Database Table: Student1
 * Fields:
 *   - sid: Student ID (Primary Key, Auto-generated)
 *   - regdno: Registration number (unique identifier)
 *   - name: Student name
 *   - contact: Student contact number (phone)
 */

@Table(name="Student1")
@Entity
@Data
public class Student12 {
	/** 
	 * Student ID - Primary key with auto-increment strategy
	 * Automatically generated when a new student is created
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int sid;
	
	/** Registration number of the student */
	int regdno;
	
	/** Full name of the student */
	String name;
	
	/** Contact phone number of the student */
	long contact;
	
	/**
	 * Gets the student ID
	 * @return student ID
	 */
	public int getSid() {
		return sid;
	}
	
	/**
	 * Sets the student ID
	 * @param sid student ID to set
	 */
	public void setSid(int sid) {
		this.sid = sid;
	}
	

	/**
	 * Gets the registration number
	 * @return registration number
	 */
	public int getRegdno() {
		return regdno;
	}
	
	/**
	 * Sets the registration number
	 * @param regdno registration number to set
	 */
	public void setRegdno(int regdno) {
		this.regdno = regdno;
	}
	
	/**
	 * Gets the student name
	 * @return student name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the student name
	 * @param name student name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the contact number
	 * @return contact phone number
	 */
	public long getContact() {
		return contact;
	}
	
	/**
	 * Sets the contact number
	 * @param contact phone number to set
	 */
	public void setContact(long contact) {
		this.contact = contact;
	}

}
