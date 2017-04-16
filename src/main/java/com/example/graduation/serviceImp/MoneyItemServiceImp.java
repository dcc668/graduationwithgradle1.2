package com.example.graduation.serviceImp;


import com.example.graduation.dao.MoneyItemDAO;
import com.example.graduation.model.MoneyItem;
import com.example.graduation.service.MoneyItemService;
import com.example.graduation.vo.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class MoneyItemServiceImp extends IServiceImp<MoneyItem> implements MoneyItemService {

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
	public Integer getCount(MoneyItem moneyItem) {
		return moneyItemDAO.getCount(moneyItem);
	}
}
