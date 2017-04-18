package com.example.graduation.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DongChenchen on 2017/4/10.
 * 经费使用明细
 */
public class PreMoneyItemInfoList {
    public List<PreMoneyItemInfo> items=new ArrayList<>();

    public List<PreMoneyItemInfo> getItems() {
        return items;
    }

    public void setItems(List<PreMoneyItemInfo> items) {
        this.items = items;
    }

}
