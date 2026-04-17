package com.vcube.sbapp11.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vcube.sbapp11.model.Student12;

/**
 * Student Repository Interface
 * 
 * Data Access Layer for Student12 entity
 * Extends JpaRepository to provide CRUD (Create, Read, Update, Delete) operations
 * 
 * JpaRepository<Student12, Integer>:
 *   - First parameter (Student12): Entity class this repository manages
 *   - Second parameter (Integer): Type of the entity's primary key (sid)
 * 
 * Inherited Methods from JpaRepository:
 *   - findAll() - Get all students
 *   - findById(int sid) - Get student by ID
 *   - save(Student12) - Insert or update student
 *   - delete(Student12) - Delete student
 *   - deleteById(int sid) - Delete student by ID
 *   - exists(int sid) - Check if student exists
 *   - count() - Get total number of students
 * 
 * Custom Methods:
 *   - findByname(String name) - Custom query to find student by name
 */

@Repository
public interface StudenRepo extends JpaRepository<Student12, Integer> {
	
	/**
	 * Custom method to find a student by name
	 * 
	 * Spring Data JPA automatically generates the SQL query based on method name.
	 * Equivalent SQL: SELECT * FROM Student1 WHERE name = ?
	 * 
	 * @param name Student name to search
	 * @return Optional containing Student12 if found, empty if not found
	 */
	Optional<Student12> findByname(String name);

}
