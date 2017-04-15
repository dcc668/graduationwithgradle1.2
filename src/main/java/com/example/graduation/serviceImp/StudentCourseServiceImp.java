package com.example.graduation.serviceImp;


import com.example.graduation.dao.StudentCourseDAO;
import com.example.graduation.model.StudentCourse;
import com.example.graduation.service.StudentCourseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Collection;

@Service
public class StudentCourseServiceImp implements StudentCourseService {
	
	@Resource(name="studentCourseDAOImp")
	StudentCourseDAO studentCourseDAO;
	
	public StudentCourse findById(Serializable id) {
		StudentCourse t=(StudentCourse)studentCourseDAO.findById(id);
		return t;
	}

	@Override
	public Serializable add(StudentCourse t) {
		return studentCourseDAO.add(t);
	}

	@Override
	public void deleteById(Serializable id) {
		studentCourseDAO.deleteById(id);
	}

	@Override
	public void deleteByCollection(Collection<StudentCourse> collection) {
		studentCourseDAO.deleteByCollection(collection);
	}


	@Override
	public Collection<StudentCourse> findAllAndPage(int firstResult, int maxResults) {
		Collection<StudentCourse> coll=studentCourseDAO.findAllAndPage(firstResult, maxResults);
		return coll;
	}

	@Override
	public void update(StudentCourse t) {
		studentCourseDAO.update(t);
	}

	@Override
	public Integer getCount(StudentCourse studentCourse) {
		return studentCourseDAO.getCount(studentCourse);
	}

	@Override
	public Collection<StudentCourse> findAll() {
		Collection<StudentCourse>coll=studentCourseDAO.findAll();
		return coll;
	}



}
