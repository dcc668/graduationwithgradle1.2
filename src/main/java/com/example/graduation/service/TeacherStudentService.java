package com.example.graduation.service;

import com.example.graduation.model.TeacherStudent;

import java.util.List;

public interface TeacherStudentService extends IService<TeacherStudent>{
	public List<Integer>queryScore(int sId);
}
