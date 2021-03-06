
package com.example.graduation.vo;

public class PaperInfo {
	//论文ID
	private Integer paId;
	//论文名称
	private String paName;
	//刊物名称
	private String paPublicationName;
	//刊号
	private String paPublicationNO;
	//页码数
	private Integer paPageNum;
	//主办单位
	private String paHostUnit;
	//发表时间
	private String paStartTime;
	//状态
	private String paState;
	//附件路径
	private String filePath;
	//备注
	private String mark;
	//发表人
	private Integer teId;


	public Integer getPaId() {
		return paId;
	}

	public void setPaId(Integer paId) {
		this.paId = paId;
	}

	public String getPaName() {
		return paName;
	}

	public void setPaName(String paName) {
		this.paName = paName;
	}

	public String getPaPublicationName() {
		return paPublicationName;
	}

	public void setPaPublicationName(String paPublicationName) {
		this.paPublicationName = paPublicationName;
	}

	public String getPaPublicationNO() {
		return paPublicationNO;
	}

	public void setPaPublicationNO(String paPublicationNO) {
		this.paPublicationNO = paPublicationNO;
	}

	public Integer getPaPageNum() {
		return paPageNum;
	}

	public void setPaPageNum(Integer paPageNum) {
		this.paPageNum = paPageNum;
	}

	public String getPaHostUnit() {
		return paHostUnit;
	}

	public void setPaHostUnit(String paHostUnit) {
		this.paHostUnit = paHostUnit;
	}

	public String getPaStartTime() {
		return paStartTime;
	}

	public void setPaStartTime(String paStartTime) {
		this.paStartTime = paStartTime;
	}

	public String getPaState() {
		return paState;
	}

	public void setPaState(String paState) {
		this.paState = paState;
	}

	public Integer getTeId() {
		return teId;
	}

	public void setTeId(Integer teId) {
		this.teId = teId;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}
}