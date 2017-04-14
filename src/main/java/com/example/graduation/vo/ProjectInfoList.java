package com.example.graduation.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DongChenchen on 2017/4/10.
 * 经费使用明细
 */
public class ProjectInfoList {
    public List<ProjectInfo> tc=new ArrayList<>();

    public List<ProjectInfo> getTc() {
        return tc;
    }

    public void setTc(List<ProjectInfo> tc) {
        this.tc = tc;
    }
}
