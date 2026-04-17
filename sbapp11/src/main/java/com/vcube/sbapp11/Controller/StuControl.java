package com.vcube.sbapp11.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vcube.sbapp11.Repo.StudenRepo;
import com.vcube.sbapp11.model.Student12;

/**
 * Student Controller - REST API endpoints for CRUD operations
 * 
 * Handles all HTTP requests related to student management.
 * Base URL: http://localhost:4455/api/v1
 * 
 * Supported Operations:
 * - GET: Retrieve all students or specific student by ID/Name
 * - POST: Create new student or update existing student
 * - PATCH: Partially update student (specific fields)
 * - DELETE: Remove student record
 */

@RestController
@RequestMapping("api/v1")
public class StuControl {
	
	/** 
	 * Injected dependency for database operations
	 * Handles all JPA queries and database interactions
	 */
	@Autowired
	StudenRepo studentrepo;
	/**
	 * GET ALL STUDENTS
	 * Retrieves a list of all students from the database
	 * 
	 * HTTP Method: GET
	 * URL: http://localhost:4455/api/v1/getStudent12
	 * 
	 * @return List of all Student12 objects from database
	 */
	@GetMapping("getStudent12")
	List<Student12> getStudent12List() {

		List<Student12> studentlist = new ArrayList<>();
		studentlist = studentrepo.findAll();

		return studentlist;
	}
	
	
	/**
	 * GET STUDENT BY ID
	 * Retrieves a specific student record by student ID (sid)
	 * 
	 * HTTP Method: GET
	 * URL: http://localhost:4455/api/v1/getStud/{sid}
	 * Example: http://localhost:4455/api/v1/getStud/52
	 * 
	 * @param sid Student ID to search
	 * @return Optional containing Student12 if found, empty if not found
	 */
	@GetMapping("getStud/{sid}")
	Optional<Student12> getStudentByid(@PathVariable("sid") int sid){
		return studentrepo.findById(sid);
	}
	
	
	/**
	 * GET STUDENT BY NAME
	 * Retrieves a student record by student name
	 * 
	 * HTTP Method: GET
	 * URL: http://localhost:4455/api/v1/getst/{name}
	 * Example: http://localhost:4455/api/v1/getst/Ashish
	 * 
	 * @param name Student name to search
	 * @return Optional containing Student12 if found, empty if not found
	 */
	@GetMapping("getst/{name}")
	Optional<Student12> getStudentByName(@PathVariable("name") String name){
		return studentrepo.findByname(name);
	}
	
	/**
	 * DELETE STUDENT BY ID
	 * Removes a student record from the database
	 * 
	 * HTTP Method: DELETE
	 * URL: http://localhost:4455/api/v1/deleteStudent12/{sid}
	 * Example: http://localhost:4455/api/v1/deleteStudent12/4
	 * 
	 * @param sid Student ID to delete
	 * @return Success message with deleted student ID
	 */
	@DeleteMapping("deleteStudent12/{sid}")
	String deleteById(@PathVariable("sid") int sid) {
		studentrepo.deleteById(sid);
		return "Student details has been removed successsfully based on id "+sid;
	}
	
	
	/**
	 * CREATE NEW STUDENT
	 * Inserts a new student record into the database
	 * 
	 * HTTP Method: POST
	 * URL: http://localhost:4455/api/v1/insertStudent12
	 * 
	 * Request Body (JSON):
	 * {
	 *   "regdno": 123,
	 *   "name": "John Doe",
	 *   "contact": 9876543210
	 * }
	 * 
	 * @param student12 Student object received from request body
	 * @return Saved Student12 object with auto-generated sid
	 */
	@PostMapping("insertStudent12")
	Student12 insertStudent(@RequestBody Student12 student12) {
		return studentrepo.save(student12);

	}
	
	/**
	 * UPDATE STUDENT (Complete Update)
	 * Updates all fields of an existing student record
	 * 
	 * HTTP Method: POST
	 * URL: http://localhost:4455/api/v1/updateStudent12/{sid}
	 * Example: http://localhost:4455/api/v1/updateStudent12/52
	 * 
	 * Request Body (JSON):
	 * {
	 *   "regdno": 456,
	 *   "name": "Jane Doe",
	 *   "contact": 9876543211
	 * }
	 * 
	 * @param student Updated student data from request body
	 * @param sid Student ID to update
	 * @return Updated Student12 object
	 * @throws RuntimeException if student not found with given ID
	 */
	@PostMapping("updateStudent12/{sid}")
	Student12 updateStudent(@RequestBody Student12 student, @PathVariable("sid") int sid){
		
		Student12 stud=studentrepo.findById(sid).orElseThrow(()-> new RuntimeException("Student not fpund wit id"+sid));
		stud.setRegdno(student.getRegdno());
		stud.setContact(student.getContact());
		stud.setName(student.getName());
		return studentrepo.save(stud);
		
	}
	
	/**
	 * UPDATE STUDENT (Partial Update)
	 * Updates specific fields of an existing student record
	 * Uses PATCH for partial updates (only provided fields are updated)
	 * 
	 * HTTP Method: PATCH
	 * URL: http://localhost:4455/api/v1/patchStudent/{sid}
	 * Example: http://localhost:4455/api/v1/patchStudent/52
	 * 
	 * Request Body (JSON) - Only fields to update:
	 * {
	 *   "regdno": 789
	 * }
	 * 
	 * @param student Partial student data from request body
	 * @param sid Student ID to update
	 * @return Updated Student12 object
	 * @throws RuntimeException if student not found with given ID
	 */
	@PatchMapping("patchStudent/{sid}")
	Student12 updateBySid(@RequestBody Student12 student, @PathVariable("sid") int sid) {
		Student12 stud=studentrepo.findById(sid).orElseThrow(()-> new RuntimeException("Student not fpund wit id"+sid));
		
		stud.setRegdno(student.getRegdno());
		return studentrepo.save(stud);
	}
}
