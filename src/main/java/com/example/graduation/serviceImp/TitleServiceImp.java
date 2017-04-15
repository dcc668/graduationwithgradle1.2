package com.example.graduation.serviceImp;


import com.example.graduation.dao.TitleDAO;
import com.example.graduation.model.Title;
import com.example.graduation.service.TitleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Collection;

@Service
public class TitleServiceImp implements  TitleService{
	
	@Resource(name="titleDAOImp")
	TitleDAO titleDAO;
	
	public Title findById(Serializable id) {
		 Title t=(Title) titleDAO.findById(id);
		return t;
	}

	@Override
	public Serializable add( Title t) {
		 return titleDAO.add(t);
	}

	@Override
	public void deleteById(Serializable id) {
		 titleDAO.deleteById(id);
	}

	@Override
	public void deleteByCollection(Collection<Title> collection) {
		 titleDAO.deleteByCollection(collection);
	}


	@Override
	public Collection<Title> findAllAndPage(int firstResult, int maxResults) {
		Collection<Title> coll= titleDAO.findAllAndPage(firstResult, maxResults);
		return coll;
	}

	@Override
	public void update( Title t) {
		 titleDAO.update(t);
	}

	@Override
	public Integer getCount(Title title) {
		return titleDAO.getCount(title);
	}

	@Override
	public Collection<Title> findAll() {
		Collection<Title>coll= titleDAO.findAll();
		return coll;
	}


}
