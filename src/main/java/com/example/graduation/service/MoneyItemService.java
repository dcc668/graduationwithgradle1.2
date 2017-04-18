package com.example.graduation.service;

import com.example.graduation.model.MoneyItem;
import com.example.graduation.vo.Page;

import java.io.Serializable;
import java.util.List;

/**
 * Created by DongChenchen on 2017/4/16.
 */
public interface MoneyItemService extends IService<MoneyItem>{
    public List<MoneyItem> getMoneyItemsByPrId(Integer prId);
    public List<MoneyItem> getMoneyItemsByPrIdAndPage(Integer prId, Page page);
    public List<MoneyItem> getMoneyItemsByIds(Serializable... ids);
    public Integer getMoneyItemsCountByPrId(Integer prId);
    public Double calculateSumMoneyByPrId(Integer prId);

}
