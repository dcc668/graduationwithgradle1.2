package com.example.graduation.dao;


import com.example.graduation.model.Student;

import java.util.List;


public interface StudentDAO  extends IDAO<Student> {

	public List<Student> findByName(String name);
	
}
