package com.example.graduation.serviceImp;


import com.example.graduation.dao.PreMoneyItemDAO;
import com.example.graduation.model.PreMoneyItem;
import com.example.graduation.service.PreMoneyItemService;
import com.example.graduation.vo.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Service
public class PreMoneyItemServiceImp implements PreMoneyItemService {

	@Autowired
	private PreMoneyItemDAO preMoneyItemDAO;

	@Override
	public List<PreMoneyItem> getPreMoneyItemsByPrId(Integer prId) {
		return preMoneyItemDAO.getPreMoneyItemsByPrId(prId);
	}

	@Override
	public List<PreMoneyItem> getPreMoneyItemsByPrIdAndPage(Integer prId, Page page) {
		return preMoneyItemDAO.getPreMoneyItemsByPrIdAndPage(prId,page);
	}

	@Override
	public List<PreMoneyItem> getPreMoneyItemsByIds(Serializable... ids) {
		return preMoneyItemDAO.getPreMoneyItemsByIds(ids);
	}

	@Override
	public Integer getPreMoneyItemsCountByPrId(Integer prId) {
		return preMoneyItemDAO.getPreMoneyItemsCountByPrId(prId);
	}

	@Override
	public Double calculateSumMoneyByPrId(Integer prId) {
		return preMoneyItemDAO.calculateSumMoneyByPrId(prId);
	}

	@Override
	public Serializable add(PreMoneyItem moneyItem) {
		return preMoneyItemDAO.add( moneyItem);
	}

	@Override
	public void deleteById(Serializable id) {
		preMoneyItemDAO.deleteById( id);
	}

	@Override
	public void deleteByCollection(Collection<PreMoneyItem> collection) {
		preMoneyItemDAO.deleteByCollection(collection);
	}

	@Override
	public PreMoneyItem findById(Serializable id) {
		return preMoneyItemDAO.findById( id);
	}

	@Override
	public Collection<PreMoneyItem> findAllAndPage(int firstResult, int maxResults) {
		return preMoneyItemDAO.findAllAndPage( firstResult,  maxResults);
	}

	@Override
	public Collection<PreMoneyItem> findAll() {
		return preMoneyItemDAO.findAll();
	}

	@Override
	public void update(PreMoneyItem moneyItem) {
		preMoneyItemDAO.update( moneyItem);
	}

	@Override
	public Integer getCount(PreMoneyItem moneyItem) {
		return preMoneyItemDAO.getCount(moneyItem);
	}
}
