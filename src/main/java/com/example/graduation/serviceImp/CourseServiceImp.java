package com.example.graduation.serviceImp;


import com.example.graduation.dao.CourseDAO;
import com.example.graduation.model.Course;
import com.example.graduation.service.CourseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Service
public class CourseServiceImp implements CourseService {
	
	@Resource(name="courseDAOImp")
	CourseDAO courseDAO;
	
	public Course findById(Serializable id) {
		Course t=(Course)courseDAO.findById(id);
		return t;
	}

	@Override
	public void add(Course t) {
		courseDAO.add(t);
	}

	@Override
	public void deleteById(Serializable id) {
		courseDAO.deleteById(id);
	}

	@Override
	public void deleteByCollection(Collection<Course> collection) {
		courseDAO.deleteByCollection(collection);
	}


	@Override
	public Collection<Course> findAllAndPage(int firstResult, int maxResults) {
		return courseDAO.findAllAndPage(firstResult, maxResults);
	}

	@Override
	public void update(Course t) {
		courseDAO.update(t);
	}

	@Override
	public Integer getCount(Course course) {
		return courseDAO.getCount(course);
	}

	@Override
	public Collection<Course> findAll() {
		return courseDAO.findAll();
	}


	@Override
	public List<Course> findBySchool(String school) {
		return courseDAO.findBySchool(school);
	}
}
