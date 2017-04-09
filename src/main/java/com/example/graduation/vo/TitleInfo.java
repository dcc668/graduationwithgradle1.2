
package com.example.graduation.vo;


public class TitleInfo  {
	Integer titleId;
	String titleName;
	String titleProperty;//性质
	String titleType;//类型
	String titleSource;//来源
	String term;//学期
	Integer needStuNum;//需要的学生数
	Integer margin;//需要的学生余量
//	private TeacherInfo teacher;//立题教师
//	private MajorInfo major;//专业
	Integer tId;//立题教师编号
	Integer MajorId;//专业代号

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
	public String getTitleProperty() {
		return titleProperty;
	}
	public void setTitleProperty(String titleProperty) {
		this.titleProperty = titleProperty;
	}
	public String getTitleType() {
		return titleType;
	}
	public void setTitleType(String titleType) {
		this.titleType = titleType;
	}
	public String getTitleSource() {
		return titleSource;
	}
	public void setTitleSource(String titleSource) {
		this.titleSource = titleSource;
	}
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
	}
	public Integer gettId() {
		return tId;
	}
	public void settId(Integer tId) {
		this.tId = tId;
	}
	public Integer getMajorId() {
		return MajorId;
	}
	public void setMajorId(Integer majorId) {
		MajorId = majorId;
	}
	public Integer getNeedStuNum() {
		return needStuNum;
	}
	public void setNeedStuNum(Integer needStuNum) {
		this.needStuNum = needStuNum;
	}
	public Integer getMargin() {
		return margin;
	}
	public void setMargin(Integer margin) {
		this.margin = margin;
	}
	
	
}