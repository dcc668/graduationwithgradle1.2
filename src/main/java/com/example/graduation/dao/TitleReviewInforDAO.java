package com.example.graduation.dao;


import com.example.graduation.model.TitleReviewInfor;

import java.util.List;


public interface TitleReviewInforDAO  extends IDAO<TitleReviewInfor>{
		public List<TitleReviewInfor> findNotReview();
		public List<TitleReviewInfor> findDoneReview();
}
