package com.se.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.se.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	@GetMapping("/students")
	public List<Student> getStudents(){
		List<Student> theStrudents = new ArrayList<Student>();
	
		theStrudents.add(new Student("Thuy", "Ho"));
		theStrudents.add(new Student("Msaty", "Ho"));
		theStrudents.add(new Student("John", "Ho"));
		return theStrudents;
	
	
	}
	
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId){
		List<Student> theStudents = new ArrayList<Student>();
	
		theStudents.add(new Student("Thuy", "Ho"));
		theStudents.add(new Student("Msaty", "Ho"));
		theStudents.add(new Student("John", "Ho"));
		return theStudents.get(studentId);
	
	
	}
	
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){
		StudentErrorResponse error = new StudentErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<StudentErrorResponse>(error, HttpStatus.NOT_FOUND);
	}
	
}
