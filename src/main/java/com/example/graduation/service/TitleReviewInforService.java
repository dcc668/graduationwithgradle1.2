package com.example.graduation.service;

import com.example.graduation.model.TitleReviewInfor;

import java.util.List;

public interface TitleReviewInforService extends IService<TitleReviewInfor> {

	public List<TitleReviewInfor> findNotReview();
	public List<TitleReviewInfor> findDoneReview();
}
