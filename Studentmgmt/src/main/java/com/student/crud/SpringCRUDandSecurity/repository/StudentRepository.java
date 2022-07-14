package com.student.crud.SpringCRUDandSecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.crud.SpringCRUDandSecurity.student.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	public Student findByFirstName(String name);

}
