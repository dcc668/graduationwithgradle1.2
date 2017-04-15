package com.example.graduation.serviceImp;


import com.example.graduation.dao.PaperDAO;
import com.example.graduation.model.Paper;
import com.example.graduation.service.PaperService;
import com.example.graduation.vo.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Service
public class PaperServiceImp implements PaperService{
	
	@Resource(name="paperDAOImp")
	PaperDAO paperDAO;
	
	public Paper  findById(Serializable id) {
		Paper t=(Paper) paperDAO.findById(id);
		return t;
	}

	@Override
	public Serializable add(Paper t) {
		return paperDAO.add(t);
	}

	@Override
	public void deleteById(Serializable id) {
		paperDAO.deleteById(id);
	}

	@Override
	public void deleteByCollection(Collection<Paper> collection) {
		paperDAO.deleteByCollection(collection);
	}


	@Override
	public Collection<Paper> findAllAndPage(int firstResult, int maxResults) {
		Collection<Paper> coll= paperDAO.findAllAndPage(firstResult, maxResults);
		return coll;
	}

	@Override
	public void update(Paper t) {
		paperDAO.update(t);
	}

	@Override
	public Integer getCount(Paper paper) {
		return paperDAO.getCount(paper);
	}

	@Override
	public Collection<Paper> findAll() {
		Collection<Paper>coll= paperDAO.findAll();
		return coll;
	}


	@Override
	public List<Paper> getPapersByTeId(Integer teId) {
		return paperDAO.getPapersByTeId(teId);
	}

	@Override
	public List<Paper> getPapersByTeIdAndPage(Integer teId, Page page) {
		return paperDAO.getPapersByTeIdAndPage(teId,page);
	}

	@Override
	public List<Paper> getPapersByIds(Serializable... ids) {
		return paperDAO.getPapersByIds(ids);
	}

	@Override
	public Integer getPapersCountByStateAndYear(String state,String year) {
		return paperDAO.getPapersCountByStateAndYear(state,year);
	}
}
