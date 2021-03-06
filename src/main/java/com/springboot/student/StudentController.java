package com.springboot.student;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/students")
public class StudentController {

	private List<Student> STUDENTS = Arrays.asList(new Student(1, "Venkatesh"), new Student(2, "ashi"));

	@GetMapping("{studentId}")
	public Student getStudent(@PathVariable("studentId") Integer studentId) {
		return STUDENTS.stream()
				.filter(student -> studentId.equals(student.getId()))
				.findFirst()
				.orElseThrow(() ->new IllegalArgumentException("no such student"));
	}
	
	@PostMapping("{student}")
	public void postStudent(@PathVariable("student") Student student) {
		System.out.println("adding student");
	}
	
	@PutMapping("{student}")
	public void putStudent(@PathVariable("student") Student student) {
		System.out.println("updating student");
	}
	
	@PutMapping("{studentId}")
	public void deleteStudent(@PathVariable("studentId") Integer studentId) {
		System.out.println("deleting student");
	}
}
