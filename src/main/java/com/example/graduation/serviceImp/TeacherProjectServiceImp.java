package com.example.graduation.serviceImp;


import com.example.graduation.dao.TeacherProjectDAO;
import com.example.graduation.model.TeacherProject;
import com.example.graduation.service.TeacherProjectService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Collection;

@Service
public class TeacherProjectServiceImp implements TeacherProjectService {
	
	@Resource(name = "teacherProjectDAOImp")
	TeacherProjectDAO teacherProjectDAO;
	
	public TeacherProject  findById(Serializable id) {
		TeacherProject t=(TeacherProject) teacherProjectDAO.findById(id);
		return t;
	}

	@Override
	public void add(TeacherProject t) {
		teacherProjectDAO.add(t);
	}

	@Override
	public void deleteById(Serializable id) {
		teacherProjectDAO.deleteById(id);
	}

	@Override
	public void deleteByCollection(Collection<TeacherProject> collection) {
		teacherProjectDAO.deleteByCollection(collection);
	}


	@Override
	public Collection<TeacherProject> findAllAndPage(int firstResult, int maxResults) {
		Collection<TeacherProject> coll= teacherProjectDAO.findAllAndPage(firstResult, maxResults);
		return coll;
	}

	@Override
	public void update(TeacherProject t) {
		teacherProjectDAO.update(t);
	}

	@Override
	public Integer getCount(TeacherProject teacherProject) {
		return teacherProjectDAO.getCount(teacherProject);
	}

	@Override
	public Collection<TeacherProject> findAll() {
		Collection<TeacherProject>coll= teacherProjectDAO.findAll();
		return coll;
	}

}
