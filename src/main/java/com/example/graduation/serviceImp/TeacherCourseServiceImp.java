package com.example.graduation.serviceImp;


import com.example.graduation.dao.TeacherCourseDAO;
import com.example.graduation.model.TeacherCourse;
import com.example.graduation.service.TeacherCourseService;
import com.example.graduation.vo.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Service
public class TeacherCourseServiceImp implements TeacherCourseService {
	
	@Resource(name="teacherCourseDAOImp")
	TeacherCourseDAO teacherCourseDAO;
	
	public TeacherCourse  findById(Serializable id) {
		TeacherCourse t=(TeacherCourse) teacherCourseDAO.findById(id);
		return t;
	}

	@Override
	public Serializable add(TeacherCourse t) {
		return teacherCourseDAO.add(t);
	}

	@Override
	public void deleteById(Serializable id) {
		teacherCourseDAO.deleteById(id);
	}

	@Override
	public void deleteByCollection(Collection<TeacherCourse> collection) {
		teacherCourseDAO.deleteByCollection(collection);
	}


	@Override
	public Collection<TeacherCourse> findAllAndPage(int firstResult, int maxResults) {
		Collection<TeacherCourse> coll= teacherCourseDAO.findAllAndPage(firstResult, maxResults);
		return coll;
	}

	@Override
	public void update(TeacherCourse t) {
		teacherCourseDAO.update(t);
	}

	@Override
	public Integer getCount(TeacherCourse teacherCourse) {
		return teacherCourseDAO.getCount(teacherCourse);
	}

	@Override
	public Collection<TeacherCourse> findAll() {
		Collection<TeacherCourse>coll= teacherCourseDAO.findAll();
		return coll;
	}

	@Override
	public List<TeacherCourse> findByTeacherId(Serializable id) {
		return teacherCourseDAO.findByTeacherId(id);
	}

	@Override
	public List<TeacherCourse> findByTeacherIdAndPage(Serializable id,Page page) {
		return teacherCourseDAO.findByTeacherIdAndPage(id,page);
	}

	@Override
	public List<TeacherCourse> findByCourseId(Serializable id) {
		return teacherCourseDAO.findByCourseId(id);
	}
}
