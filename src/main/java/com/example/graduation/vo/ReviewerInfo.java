
package com.example.graduation.vo;

import java.util.Set;


public class ReviewerInfo  {
	Integer revId;			
	String revName;
	Set<TitleReviewInfo> titleReviewInfor;
	
	public Integer getRevId() {
		return revId;
	}
	public void setRevId(Integer revId) {
		this.revId = revId;
	}
	
	public String getRevName() {
		return revName;
	}
	public void setRevName(String revName) {
		this.revName = revName;
	}

	public Set<TitleReviewInfo> getTitleReviewInfor() {
		return titleReviewInfor;
	}
	public void setTitleReviewInfor(Set<TitleReviewInfo> titleReviewInfor) {
		this.titleReviewInfor = titleReviewInfor;
	}
	

	

	
}