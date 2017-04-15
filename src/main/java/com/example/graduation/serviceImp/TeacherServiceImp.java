package com.example.graduation.serviceImp;


import com.example.graduation.dao.TeacherDAO;
import com.example.graduation.model.Teacher;
import com.example.graduation.service.TeacherService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Service
public class TeacherServiceImp implements TeacherService{
	
	@Resource(name="teacherDAOImp")
	TeacherDAO teacherDAO;
	
	public Teacher  findById(Serializable id) {
		Teacher t=(Teacher)teacherDAO.findById(id);
		return t;
	}

	@Override
	public Serializable add(Teacher t) {
		return teacherDAO.add(t);
	}

	@Override
	public void deleteById(Serializable id) {
		teacherDAO.deleteById(id);
	}

	@Override
	public void deleteByCollection(Collection<Teacher> collection) {
		teacherDAO.deleteByCollection(collection);
	}


	@Override
	public Collection<Teacher> findAllAndPage(int firstResult, int maxResults) {
		Collection<Teacher> coll=teacherDAO.findAllAndPage(firstResult, maxResults);
		return coll;
	}

	@Override
	public void update(Teacher t) {
		teacherDAO.update(t);
	}

	@Override
	public Integer getCount(Teacher teacher) {
		return teacherDAO.getCount(teacher);
	}

	@Override
	public Collection<Teacher> findAll() {
		Collection<Teacher>coll=teacherDAO.findAll();
		return coll;
	}

	@Override
	public List<Teacher> findByName(String name) {
			List<Teacher>teas=teacherDAO.findByName(name);
		return teas;
	}


}
