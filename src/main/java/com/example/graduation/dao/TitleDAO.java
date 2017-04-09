package com.example.graduation.dao;


import com.example.graduation.daoImp.SubTitle;
import com.example.graduation.model.Title;


public interface TitleDAO  extends IDAO<Title>{
    public Title getTitleById(Integer id);
    public SubTitle getSubTitleId(Integer id);
}