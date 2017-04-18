package com.example.graduation.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by DongChenchen on 2017/4/10.
 * 经费使用明细
 */
@Entity
@Table(name="t_MoneyItem")
@SequenceGenerator(name = "MoneyItemSequence",sequenceName = "SEQ_MONEYITEM",allocationSize = 1)
public class MoneyItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "MoneyItemSequence")
    private Integer moId;
    //明细项名称
    private String itemName;
    //金额
    private Double sumMoney;
    //支出时间
    @Column(columnDefinition="DATE")
    private Date time;
    //使用人工号
    private Integer teId;
    //用途说明
    private String mark;

    //科研项目
    @ManyToOne(cascade= CascadeType.MERGE,fetch= FetchType.EAGER)
    @JoinColumn(name="prId")
    private Project project;


    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

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

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
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
