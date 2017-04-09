package com.example.graduation.service;

import com.example.graduation.model.Teacher;

import java.util.List;

public interface TeacherService extends IService<Teacher> {
	public List<Teacher> findByName(String name);
}
