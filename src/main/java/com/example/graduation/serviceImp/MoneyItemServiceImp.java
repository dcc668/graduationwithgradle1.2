package com.example.graduation.serviceImp;


import com.example.graduation.dao.MoneyItemDAO;
import com.example.graduation.model.MoneyItem;
import com.example.graduation.service.MoneyItemService;
import com.example.graduation.vo.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Service
public class MoneyItemServiceImp implements MoneyItemService {

	@Autowired
	private MoneyItemDAO moneyItemDAO;

	@Override
	public List<MoneyItem> getMoneyItemsByPrId(Integer prId) {
		return moneyItemDAO.getMoneyItemsByPrId(prId);
	}

	@Override
	public List<MoneyItem> getMoneyItemsByPrIdAndPage(Integer prId, Page page) {
		return moneyItemDAO.getMoneyItemsByPrIdAndPage(prId,page);
	}

	@Override
	public List<MoneyItem> getMoneyItemsByIds(Serializable... ids) {
		return moneyItemDAO.getMoneyItemsByIds(ids);
	}

	@Override
	public Integer getMoneyItemsCountByPrId(Integer prId) {
		return moneyItemDAO.getMoneyItemsCountByPrId(prId);
	}

	@Override
	public Double calculateSumMoneyByPrId(Integer prId) {
		return moneyItemDAO.calculateSumMoneyByPrId(prId);
	}

	@Override
	public Serializable add(MoneyItem moneyItem) {
		return moneyItemDAO.add( moneyItem);
	}

	@Override
	public void deleteById(Serializable id) {
		moneyItemDAO.deleteById( id);
	}

	@Override
	public void deleteByCollection(Collection<MoneyItem> collection) {
		moneyItemDAO.deleteByCollection(collection);
	}

	@Override
	public MoneyItem findById(Serializable id) {
		return moneyItemDAO.findById( id);
	}

	@Override
	public Collection<MoneyItem> findAllAndPage(int firstResult, int maxResults) {
		return moneyItemDAO.findAllAndPage( firstResult,  maxResults);
	}

	@Override
	public Collection<MoneyItem> findAll() {
		return moneyItemDAO.findAll();
	}

	@Override
	public void update(MoneyItem moneyItem) {
		moneyItemDAO.update( moneyItem);
	}

	@Override
	public Integer getCount(MoneyItem moneyItem) {
		return moneyItemDAO.getCount(moneyItem);
	}
}
