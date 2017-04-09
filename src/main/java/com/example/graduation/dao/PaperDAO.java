package com.example.graduation.dao;


import com.example.graduation.model.Paper;
import com.example.graduation.vo.Page;

import java.io.Serializable;
import java.util.List;


public interface PaperDAO extends IDAO<Paper>{
    public List<Paper> getPapersByTeId(Integer teId);
    public List<Paper> getPapersByTeIdAndPage(Integer teId,Page page);
    public List<Paper> getPapersByIds(Serializable...ids);
    public Integer getPapersCountByStateAndYear(String state,String year);
}
