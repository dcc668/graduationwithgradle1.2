package com.example.graduation.serviceImp;


import com.example.graduation.dao.ReviewerDAO;
import com.example.graduation.model.Reviewer;
import com.example.graduation.service.ReviewerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Service
public class ReviewerServiceImp implements ReviewerService {
	
	@Resource(name="reviewerDAOImp")
	ReviewerDAO reviewerDAO;
	
	public Reviewer  findById(Serializable id) {
		Reviewer t=(Reviewer)reviewerDAO.findById(id);
		return t;
	}

	@Override
	public void add(Reviewer t) {
		reviewerDAO.add(t);
	}

	@Override
	public void deleteById(Serializable id) {
		reviewerDAO.deleteById(id);
	}

	@Override
	public void deleteByCollection(Collection<Reviewer> collection) {
		reviewerDAO.deleteByCollection(collection);
	}

	@Override
	public Collection<Reviewer> findAllAndPage(int firstResult, int maxResults) {
		Collection<Reviewer> coll=reviewerDAO.findAllAndPage(firstResult, maxResults);
		return coll;
	}

	@Override
	public void update(Reviewer t) {
		reviewerDAO.update(t);
	}

	@Override
	public Integer getCount(Reviewer reviewer) {
		return reviewerDAO.getCount(reviewer);
	}

	@Override
	public Collection<Reviewer> findAll() {
		Collection<Reviewer>coll=reviewerDAO.findAll();
		return coll;
	}

	@Override
	public List<Reviewer> findByName(String name) {
		List<Reviewer>revs=reviewerDAO.findByName(name);
		return revs;
	}


}
