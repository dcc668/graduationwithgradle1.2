package com.example.graduation.serviceImp;


import com.example.graduation.dao.ProjectDAO;
import com.example.graduation.model.Project;
import com.example.graduation.service.ProjectService;
import com.example.graduation.vo.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Service
public class ProjectServiceImp implements ProjectService{
	@Resource(name="projectDAOImp")
	ProjectDAO projectDAO;

	@Override
	public Project findById(Serializable id) {
		Project t=(Project) projectDAO.findById(id);
		return t;
	}

	@Override
	public Serializable add(Project t) {
		return projectDAO.add(t);
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
	public Integer getCount(Project paper) {
		return projectDAO.getCount(paper);
	}

	@Override
	public Collection<Project> findAll() {
		Collection<Project>coll= projectDAO.findAll();
		return coll;
	}


	@Override
	public List<Project> getProjectsByTeId(Integer teId) {
		return projectDAO.getProjectsByTeId(teId);
	}

	@Override
	public List<Project> getProjectsByTeIdAndPage(Integer teId, Page page) {
		return projectDAO.getProjectsByTeIdAndPage(teId,page);
	}

	@Override
	public List<Project> getProjectsByIds(Serializable... ids) {
		return projectDAO.getProjectsByIds(ids);
	}

	@Override
	public Integer getProjectsCountByStateAndYear(String state,String year) {
		return projectDAO.getProjectsCountByStateAndYear(state,year);
	}

}
