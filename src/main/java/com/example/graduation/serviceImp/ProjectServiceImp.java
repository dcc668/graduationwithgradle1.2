package com.example.graduation.serviceImp;


import com.example.graduation.dao.ProjectDAO;
import com.example.graduation.model.Project;
import com.example.graduation.service.ProjectService;
import com.example.graduation.vo.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Service
public class ProjectServiceImp implements ProjectService{
	@Resource(name="projectDAOImp")
	ProjectDAO projectDAO;
	@Autowired
	HibernateTemplate hibernateTemplate;

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

	@Override
	public void deleteProjectById(Serializable id) {
		Project pro = projectDAO.findById(id);
		hibernateTemplate.delete(pro);
	}

	@Override
	public Serializable add(Project project) {
		return projectDAO.add( project);
	}

	@Override
	public void deleteById(Serializable id) {
		projectDAO.deleteById( id);
	}

	@Override
	public void deleteByCollection(Collection<Project> collection) {
		projectDAO.deleteByCollection( collection);
	}

	@Override
	public Project findById(Serializable id) {
		return projectDAO.findById( id);
	}

	@Override
	public Collection<Project> findAllAndPage(int firstResult, int maxResults) {
		return projectDAO.findAllAndPage( firstResult,  maxResults);
	}

	@Override
	public Collection<Project> findAll() {
		return projectDAO.findAll();
	}

	@Override
	public void update(Project project) {
		projectDAO.update(project);
	}

	@Override
	public Integer getCount(Project project) {
		return projectDAO.getCount(project);
	}
}
