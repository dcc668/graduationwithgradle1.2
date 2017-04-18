package com.example.graduation.dao;


import com.example.graduation.model.MoneyItem;
import com.example.graduation.vo.Page;

import java.io.Serializable;
import java.util.List;


public interface MoneyItemDAO extends IDAO<MoneyItem>{
    public List<MoneyItem> getMoneyItemsByPrId(Integer prId);
    public List<MoneyItem> getMoneyItemsByPrIdAndPage(Integer prId, Page page);
    public List<MoneyItem> getMoneyItemsByIds(Serializable... ids);
    public Integer getMoneyItemsCountByPrId(Integer prId);
    public Double calculateSumMoneyByPrId(Integer prId);

}
