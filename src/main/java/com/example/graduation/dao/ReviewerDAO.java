package com.example.graduation.dao;


import com.example.graduation.model.Reviewer;

import java.util.List;


public interface ReviewerDAO  extends IDAO<Reviewer>{
	public List<Reviewer> findByName(String name);
}
