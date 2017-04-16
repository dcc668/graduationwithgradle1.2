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
import java.util.List;

@Service
public class ProjectServiceImp extends IServiceImp<Project> implements ProjectService{
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

}
