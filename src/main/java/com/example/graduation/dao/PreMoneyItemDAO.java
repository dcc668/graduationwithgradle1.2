package com.example.graduation.dao;


import com.example.graduation.model.PreMoneyItem;
import com.example.graduation.vo.Page;

import java.io.Serializable;
import java.util.List;


public interface PreMoneyItemDAO extends IDAO<PreMoneyItem>{
    public List<PreMoneyItem> getPreMoneyItemsByPrId(Integer prId);
    public List<PreMoneyItem> getPreMoneyItemsByPrIdAndPage(Integer prId, Page page);
    public List<PreMoneyItem> getPreMoneyItemsByIds(Serializable... ids);
    public Integer getPreMoneyItemsCountByPrId(Integer prId);
    public Double calculateSumMoneyByPrId(Integer prId);

}
