package com.example.graduation.serviceImp;


import com.example.graduation.dao.ProjectDAO;
import com.example.graduation.model.Project;
import com.example.graduation.service.ProjectService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Collection;

@Service
public class ProjectServiceImp implements ProjectService{
	
	@Resource(name="projectDAOImp")
	ProjectDAO projectDAO;
	
	public Project  findById(Serializable id) {
		Project t=(Project) projectDAO.findById(id);
		return t;
	}

	@Override
	public void add(Project t) {
		projectDAO.add(t);
	}

	@Override
	public void deleteById(Serializable id) {
		projectDAO.deleteById(id);
	}

	@Override
	public void deleteByCollection(Collection<Project> collection) {
		projectDAO.deleteByCollection(collection);
	}


	@Override
	public Collection<Project> findAllAndPage(int firstResult, int maxResults) {
		Collection<Project> coll= projectDAO.findAllAndPage(firstResult, maxResults);
		return coll;
	}

	@Override
	public void update(Project t) {
		projectDAO.update(t);
	}

	@Override
	public Integer getCount(Project project) {
		return projectDAO.getCount(project);
	}

	@Override
	public Collection<Project> findAll() {
		Collection<Project>coll= projectDAO.findAll();
		return coll;
	}


}
