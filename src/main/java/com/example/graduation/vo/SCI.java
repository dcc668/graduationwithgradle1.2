package com.example.graduation.vo;

import java.util.List;

/**
 * Created by DongChenchen on 2017/4/9.
 */
public class SCI {
    private String name; //SCI,EI,ISTP,SSCI,CSCD
    private List<Integer> data; //历年的数量

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getData() {
        return data;
    }

    public void setData(List<Integer> data) {
        this.data = data;
    }
}
