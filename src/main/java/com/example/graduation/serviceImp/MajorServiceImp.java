package com.example.graduation.serviceImp;


import com.example.graduation.dao.MajorDAO;
import com.example.graduation.model.Major;
import com.example.graduation.service.MajorService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Collection;

@Service
public class MajorServiceImp implements  MajorService{
	
	@Resource(name="majorDAOImp")
	 MajorDAO  majorDAO;
	
	public  Major  findById(Serializable id) {
		 Major t=( Major) majorDAO.findById(id);
		return t;
	}

	@Override
	public Serializable add( Major t) {
		 return majorDAO.add(t);
	}

	@Override
	public void deleteById(Serializable id) {
		 majorDAO.deleteById(id);
	}

	@Override
	public void deleteByCollection(Collection< Major> collection) {
		 majorDAO.deleteByCollection(collection);
	}


	@Override
	public Collection< Major> findAllAndPage(int firstResult, int maxResults) {
		Collection< Major> coll= majorDAO.findAllAndPage(firstResult, maxResults);
		return coll;
	}

	@Override
	public void update( Major t) {
		
		 majorDAO.update(t);
	}

	@Override
	public Integer getCount(Major major) {
		return  majorDAO.getCount(major);
	}

	@Override
	public Collection< Major> findAll() {
		Collection< Major>coll= majorDAO.findAll();
		return coll;
	}


}
