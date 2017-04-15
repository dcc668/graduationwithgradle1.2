package com.example.graduation.serviceImp;


import com.example.graduation.dao.TitleReviewInforDAO;
import com.example.graduation.model.TitleReviewInfor;
import com.example.graduation.service.TitleReviewInforService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;


@Service
public class TitleReviewInforServiceImp implements TitleReviewInforService {
	
	@Resource(name="titleReviewInforDAOImp")
	TitleReviewInforDAO titleReviewInforDAO;
	
	public TitleReviewInfor findById(Serializable id) {
		TitleReviewInfor t=(TitleReviewInfor)titleReviewInforDAO.findById(id);
		return t;
	}

	@Override
	public Serializable add(TitleReviewInfor t) {
		return titleReviewInforDAO.add(t);
	}

	@Override
	public void deleteById(Serializable id) {
		titleReviewInforDAO.deleteById(id);
	}

	@Override
	public void deleteByCollection(Collection<TitleReviewInfor> collection) {
		titleReviewInforDAO.deleteByCollection(collection);
	}


	@Override
	public Collection<TitleReviewInfor> findAllAndPage(int firstResult, int maxResults) {
		Collection<TitleReviewInfor> coll=titleReviewInforDAO.findAllAndPage(firstResult, maxResults);
		return coll;
	}

	@Override
	public void update(TitleReviewInfor t) {
		titleReviewInforDAO.update(t);
	}

	@Override
	public Integer getCount(TitleReviewInfor titleReviewInfor) {
		return titleReviewInforDAO.getCount(titleReviewInfor);
	}

	@Override
	public Collection<TitleReviewInfor> findAll() {
		Collection<TitleReviewInfor>coll=titleReviewInforDAO.findAll();
		return coll;
	}

	@Override
	public  List<TitleReviewInfor>findNotReview() {
		List<TitleReviewInfor>tri=titleReviewInforDAO.findNotReview();
		return tri;
	}

	@Override
	public List<TitleReviewInfor> findDoneReview() {
		List<TitleReviewInfor>tri=titleReviewInforDAO.findDoneReview();
		return tri;
	}


}
