package com.student.crud.SpringCRUDandSecurity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestController;

import com.student.crud.SpringCRUDandSecurity.student.Student;
import com.student.crud.SpringCRUDandSecurity.service.StudentService;


@Controller
public class StudentController {

	@Autowired
	StudentService studentService;
	
	@RequestMapping(value = "/students", method = RequestMethod.GET)
	public String printStudents(Model theModel){
		List<Student> students = studentService.searchAll();
		theModel.addAttribute(students);
		return "list-Student";
	}
	@PostMapping("/saveForm")
	public String saveStudent(@RequestParam("firstName") String fname,  @RequestParam("lastName") String lname,
			@RequestParam("course") String course, @RequestParam("country") String country){
		//save the record into DB
		Student studentOBJ = new Student();
		studentOBJ.setFirstName(fname);
		studentOBJ.setLastName(lname);
		studentOBJ.setCourse(course);
		studentOBJ.setCountry(country);
		studentService.save(studentOBJ);
		//return to the list page
		return "redirect:/printstudents";
	}
//	@PostMapping	
//	public String updateStudent(@RequestParam("firstName") String fname,  @RequestParam("lastName") String lname,
//			@RequestParam("course") String course, @RequestParam("country") String country) {
//		return "redirect/printstudents";
//	}
}
