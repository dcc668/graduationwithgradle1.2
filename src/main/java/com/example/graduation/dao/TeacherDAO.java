package com.example.graduation.dao;


import com.example.graduation.model.Teacher;

import java.util.List;


public interface TeacherDAO  extends IDAO<Teacher>{

	public List<Teacher> findByName(String name);
}
