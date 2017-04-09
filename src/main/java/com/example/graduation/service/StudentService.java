package com.example.graduation.service;

import com.example.graduation.model.Student;

import java.util.List;

public interface StudentService extends IService<Student> {
	public List<Student> findByName(String name);
}
