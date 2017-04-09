
package com.example.graduation.vo;

public class TitleReviewInfo  {
	Integer trId;
	Integer titleId;
	String titleName;
	String term;//学期
	String titleExamine;//题目相似度
	String reviewSuggestion;//评审意见
	String reviewState;//评审状态
	Integer needStuNum;//需要的学生数
	Integer nowStuNum;//已经选的学生数
	
	
	public Integer getTitleId() {
		return titleId;
	}
	public void setTitleId(Integer titleId) {
		this.titleId = titleId;
	}
	public String getTitleName() {
		return titleName;
	}
	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}
	public Integer getTrId() {
		return trId;
	}
	public void setTrId(Integer trId) {
		this.trId = trId;
	}
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
	}
	public String getTitleExamine() {
		return titleExamine;
	}
	public void setTitleExamine(String titleExamine) {
		this.titleExamine = titleExamine;
	}
	public String getReviewSuggestion() {
		return reviewSuggestion;
	}
	public void setReviewSuggestion(String reviewSuggestion) {
		this.reviewSuggestion = reviewSuggestion;
	}
	public String getReviewState() {
		return reviewState;
	}
	public void setReviewState(String reviewState) {
		this.reviewState = reviewState;
	}
	public Integer getNeedStuNum() {
		return needStuNum;
	}
	public void setNeedStuNum(Integer needStuNum) {
		this.needStuNum = needStuNum;
	}
	public Integer getNowStuNum() {
		return nowStuNum;
	}
	public void setNowStuNum(Integer nowStuNum) {
		this.nowStuNum = nowStuNum;
	}



	
}