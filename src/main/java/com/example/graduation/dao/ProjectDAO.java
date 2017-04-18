package com.example.graduation.dao;


import com.example.graduation.model.Project;
import com.example.graduation.vo.Page;

import java.io.Serializable;
import java.util.List;


public interface ProjectDAO  extends IDAO<Project> {
    public List<Project> getProjectsByTeId(Integer teId);
    public List<Project> getProjectsByTeIdAndPage(Integer teId,Page page);
    public List<Project> getProjectsByIds(Serializable...ids);
    public Integer getProjectsCountByStateAndYear(String state,String year);
}
