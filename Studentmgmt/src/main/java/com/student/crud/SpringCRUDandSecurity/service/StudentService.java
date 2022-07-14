package com.student.crud.SpringCRUDandSecurity.service;
import java.util.List;

import com.student.crud.SpringCRUDandSecurity.student.Student;


public interface StudentService {

	public List<Student> searchAll();
	
	public Student searchById(int Id);
	//public void save (Student student);
	public void deleteById (int id);

	public void save(Student student);
	
}
