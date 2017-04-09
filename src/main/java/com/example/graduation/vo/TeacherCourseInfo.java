
package com.example.graduation.vo;

public class TeacherCourseInfo {
	private Integer tcId;
	//1学期
	private String term;
	//2任教类型
	private String type;
	//3课程名称
	private String coName;
	//4总人数
	private Integer stuNum;
	//5课程学时
	private Integer coTime;
	//6班级批次
	private Integer houseNum;

	//7.未通过人数
	private Integer notPassNum;
	//8.课程学分
	private Double coScore;
	//9.双语教学
	private Boolean co2Language;
	//10.备注信息
	private String mark;


	public Integer getTcId() {
		return tcId;
	}

	public void setTcId(Integer tcId) {
		this.tcId = tcId;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCoName() {
		return coName;
	}

	public void setCoName(String coName) {
		this.coName = coName;
	}

	public Integer getStuNum() {
		return stuNum;
	}

	public void setStuNum(Integer stuNum) {
		this.stuNum = stuNum;
	}

	public Integer getCoTime() {
		return coTime;
	}

	public void setCoTime(Integer coTime) {
		this.coTime = coTime;
	}

	public Integer getHouseNum() {
		return houseNum;
	}

	public void setHouseNum(Integer houseNum) {
		this.houseNum = houseNum;
	}

	public Integer getNotPassNum() {
		return notPassNum;
	}

	public void setNotPassNum(Integer notPassNum) {
		this.notPassNum = notPassNum;
	}

	public Double getCoScore() {
		return coScore;
	}

	public void setCoScore(Double coScore) {
		this.coScore = coScore;
	}

	public Boolean getCo2Language() {
		return co2Language;
	}

	public void setCo2Language(Boolean co2Language) {
		this.co2Language = co2Language;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	@Override
	public String toString() {
		return "com.example.graduation.vo.TeacherCourseInfo{" +
				"tcId=" + tcId +
				", term='" + term + '\'' +
				", type='" + type + '\'' +
				", coName='" + coName + '\'' +
				", stuNum=" + stuNum +
				", coTime=" + coTime +
				", houseNum=" + houseNum +
				", notPassNum=" + notPassNum +
				", coScore='" + coScore + '\'' +
				", co2Language=" + co2Language +
				", mark='" + mark + '\'' +
				'}';
	}
}