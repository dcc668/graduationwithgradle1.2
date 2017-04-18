package com.example.graduation.vo;

/**
 * Created by DongChenchen on 2017/4/10.
 * 预算明细
 */
public class PreMoneyItemInfo{
    private Integer preId;
    //预算明细名称
    private String itemName;
    //金额
    private Double sumMoney;
    //用途说明
    private String mark;

    //科研项目
    private Integer prId;

    public Integer getPreId() {
        return preId;
    }

    public void setPreId(Integer preId) {
        this.preId = preId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Double getSumMoney() {
        return sumMoney;
    }

    public void setSumMoney(Double sumMoney) {
        this.sumMoney = sumMoney;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public Integer getPrId() {
        return prId;
    }

    public void setPrId(Integer prId) {
        this.prId = prId;
    }
}
