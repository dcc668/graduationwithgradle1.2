package com.example.graduation.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DongChenchen on 2017/4/10.
 * 经费使用明细
 */
public class MoneyItemInfoList {
    private List<MoneyItemInfo> items=new ArrayList<>();

    public List<MoneyItemInfo> getItems() {
        return items;
    }

    public void setItems(List<MoneyItemInfo> items) {
        this.items = items;
    }
}
