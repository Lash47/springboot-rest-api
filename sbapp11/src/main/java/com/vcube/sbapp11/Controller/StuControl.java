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

@RestController
@RequestMapping("api/v1")
public class StuControl {

	@Autowired
	StudenRepo studentrepo;
//	http://localhost:4455/api/v1/getStudent12
	@GetMapping("getStudent12")
	List<Student12> getStudent12List() {

		List<Student12> studentlist = new ArrayList<>();
		studentlist = studentrepo.findAll();

		return studentlist;
	}
//	http://localhost:4455/api/v1/getStud/52
	@GetMapping("getStud/{sid}")
	Optional<Student12> getStudentByid(@PathVariable("sid") int sid){
		return studentrepo.findById(sid);
	}
//	http://localhost:4455/api/v1/getst/Ashish
	@GetMapping("getst/{name}")
	Optional<Student12> getStudentByName(@PathVariable("name") String name){
		return studentrepo.findByname(name);
	}
//	http://localhost:4455/api/v1/deleteStudent12/4
	@DeleteMapping("deleteStudent12/{sid}")
	String deleteById(@PathVariable("sid") int sid) {
		studentrepo.deleteById(sid);
		return "Student details has been removed successsfully based on id "+sid;
	}
//	http://localhost:4455/api/v1/insertStudent12
	@PostMapping("insertStudent12")
	Student12 insertStudent(@RequestBody Student12 student12) {
		return studentrepo.save(student12);

	}
//	http://localhost:4455/api/v1/updateStudent12/52
	@PostMapping("updateStudent12/{sid}")
	Student12 updateStudent(@RequestBody Student12 student, @PathVariable("sid") int sid){
		
		Student12 stud=studentrepo.findById(sid).orElseThrow(()-> new RuntimeException("Student not fpund wit id"+sid));
		stud.setRegdno(student.getRegdno());
		stud.setContact(student.getContact());
		stud.setName(student.getName());
		return studentrepo.save(stud);
		
	}
//	http://localhost:4455/api/v1/patchStudent/52
	@PatchMapping("patchStudent/{sid}")
	Student12 updateBySid(@RequestBody Student12 student, @PathVariable("sid") int sid) {
		Student12 stud=studentrepo.findById(sid).orElseThrow(()-> new RuntimeException("Student not fpund wit id"+sid));
		
		stud.setRegdno(student.getRegdno());
		return studentrepo.save(stud);
	}
}
