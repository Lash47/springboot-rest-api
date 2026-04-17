package com.vcube.sbapp11;
//Student managment system using CRUD operations using postman and mysql
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * Main entry point for the Student Management System REST API
 * 
 * This Spring Boot application implements CRUD operations for student records
 * using JPA/Hibernate with MySQL database.
 * 
 * Features:
 * - Get all students
 * - Get student by ID or Name
 * - Create new student record
 * - Update student details
 * - Delete student record
 * 
 * API Base URL: http://localhost:4455/api/v1
 * Database: MySQL (Batch61)
 */
@SpringBootApplication
public class Sbapp11Application {
	
	/**
	 * Starts the Spring Boot application
	 * @param args command line arguments
	 */
	
	public static void main(String[] args) {
		SpringApplication.run(Sbapp11Application.class, args);
	}

}
