package com.example.graduation.model;

import javax.persistence.*;

/**
 * Created by DongChenchen on 2017/4/10.
 * 预算明细
 */
@Entity
@Table(name="t_PreMoneyItem")
@SequenceGenerator(name = "PreMoneyItemSequence",sequenceName = "SEQ_PREMONEYITEM",allocationSize = 1)
public class PreMoneyItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "PreMoneyItemSequence")
    private Integer prId;
    //预算明细名称
    private String itemName;
    //金额
    private Double sumMoney;
    //用途说明
    private String mark;

    public Integer getPrId() {
        return prId;
    }

    public void setPrId(Integer prId) {
        this.prId = prId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public Double getSumMoney() {
        return sumMoney;
    }

    public void setSumMoney(Double sumMoney) {
        this.sumMoney = sumMoney;
    }
}
