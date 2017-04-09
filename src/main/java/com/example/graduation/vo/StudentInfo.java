
package com.example.graduation.vo;


public class StudentInfo  {
	Integer id;
	String sName;
	String sPassword;
	String sSex;
	String sClass;
	String sTel;
	String sMail;
	String sQQ;
	String  majorName;
	Integer  majorId;//专业代号
	String   titleName;
	Integer score;
	
	
	public void setId(Integer id) {
		this.id = id;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getsSex() {
		return sSex;
	}

	public void setsSex(String sSex) {
		this.sSex = sSex;
	}
	


	public String getsClass() {
		return sClass;
	}


	public void setsClass(String sClass) {
		this.sClass = sClass;
	}

	public String getsTel() {
		return sTel;
	}

	public void setsTel(String sTel) {
		this.sTel = sTel;
	}

	public String getsMail() {
		return sMail;
	}

	public void setsMail(String sMail) {
		this.sMail = sMail;
	}

	public String getsQQ() {
		return sQQ;
	}

	public void setsQQ(String sQQ) {
		this.sQQ = sQQ;
	}

	public String getMajorName() {
		return majorName;
	}

	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}

	public String getTitleName() {
		return titleName;
	}

	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}

	public Integer getId() {
		return id;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getsPassword() {
		return sPassword;
	}

	public void setsPassword(String sPassword) {
		this.sPassword = sPassword;
	}

	public Integer getMajorId() {
		return majorId;
	}

	public void setMajorId(Integer majorId) {
		this.majorId = majorId;
	}






	
}