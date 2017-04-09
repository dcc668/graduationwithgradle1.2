package com.example.graduation.dao;


import com.example.graduation.model.TeacherStudent;

import java.util.List;


public interface TeacherStudentDAO  extends IDAO<TeacherStudent>{

	public List<TeacherStudent>queryScore(int sId);
	
	
}
