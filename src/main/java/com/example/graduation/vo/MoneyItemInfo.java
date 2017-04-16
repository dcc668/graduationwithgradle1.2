package com.example.graduation.vo;

/**
 * Created by DongChenchen on 2017/4/10.
 * 经费使用明细
 */
public class MoneyItemInfo {
    private Integer moId;
    //明细项名称
    private String itemName;
    //金额
    private Double sumMoney;
    //支出时间
    private String time;
    //使用人工号
    private Integer teId;
    //用途说明
    private String mark;

    public Integer getMoId() {
        return moId;
    }

    public void setMoId(Integer moId) {
        this.moId = moId;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getTeId() {
        return teId;
    }

    public void setTeId(Integer teId) {
        this.teId = teId;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }
}
