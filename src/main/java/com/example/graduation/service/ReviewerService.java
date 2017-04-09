package com.example.graduation.service;

import com.example.graduation.model.Reviewer;

import java.util.List;

public interface ReviewerService extends IService<Reviewer>{
	public List<Reviewer> findByName(String name);
}
