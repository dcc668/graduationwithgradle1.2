
package com.example.graduation.vo;

public class ProjectInfo {
	private Integer prId;
	//项目名称
	private String prName;
	//项目来源
	private String prSource;
	//负责人工号
	private Integer teId;
	//成员（工号）
	private String members;
	//立项时间
	private String prStartTime;
	//实际完成时间
	private String prEndTime;
	//拟定期限(天)
	private Integer prDate;
	//课题总额(申请到的金额)
	private Double prUsefulMoney;
	//预算金额
	private Double prPreMoney;
	//经费金额
	private Double prMoney;
	//成果简介
	private String prResultInfo;
	//状态
	private String prState;

	public Integer getPrId() {
		return prId;
	}

	public void setPrId(Integer prId) {
		this.prId = prId;
	}

	public String getPrName() {
		return prName;
	}

	public void setPrName(String prName) {
		this.prName = prName;
	}

	public String getPrSource() {
		return prSource;
	}

	public void setPrSource(String prSource) {
		this.prSource = prSource;
	}

	public Integer getTeId() {
		return teId;
	}

	public void setTeId(Integer teId) {
		this.teId = teId;
	}

	public String getMembers() {
		return members;
	}

	public void setMembers(String members) {
		this.members = members;
	}

	public String getPrStartTime() {
		return prStartTime;
	}

	public void setPrStartTime(String prStartTime) {
		this.prStartTime = prStartTime;
	}

	public String getPrEndTime() {
		return prEndTime;
	}

	public void setPrEndTime(String prEndTime) {
		this.prEndTime = prEndTime;
	}

	public Integer getPrDate() {
		return prDate;
	}

	public void setPrDate(Integer prDate) {
		this.prDate = prDate;
	}

	public Double getPrUsefulMoney() {
		return prUsefulMoney;
	}

	public void setPrUsefulMoney(Double prUsefulMoney) {
		this.prUsefulMoney = prUsefulMoney;
	}

	public Double getPrPreMoney() {
		return prPreMoney;
	}

	public void setPrPreMoney(Double prPreMoney) {
		this.prPreMoney = prPreMoney;
	}

	public Double getPrMoney() {
		return prMoney;
	}

	public void setPrMoney(Double prMoney) {
		this.prMoney = prMoney;
	}

	public String getPrResultInfo() {
		return prResultInfo;
	}

	public void setPrResultInfo(String prResultInfo) {
		this.prResultInfo = prResultInfo;
	}

	public String getPrState() {
		return prState;
	}

	public void setPrState(String prState) {
		this.prState = prState;
	}
}