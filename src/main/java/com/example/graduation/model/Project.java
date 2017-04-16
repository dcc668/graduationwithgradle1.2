
package com.example.graduation.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * 科研项目
 */
@Entity
@Table(name="t_Project")
@SequenceGenerator(name = "ProjectSequence", sequenceName = "SEQ_PROJECT", allocationSize = 1)
public class Project {
	//1项目ID
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO,generator = "ProjectSequence")
	private Integer prId;
	//2项目名称
	private String prName;
	//3项目来源
	private String prSource;
	//4负责人工号
	private Integer teId;
	//5立项时间
	@Column(columnDefinition="DATE")
	private Date prStartTime;
	//6实际完成时间
	@Column(columnDefinition="DATE")
	private Date prEndTime;
	//7拟定期限(天)
	private int prDate;
	//8课题总额(申请到的金额)
	private Double prUsefulMoney;
	//9预算金额
	private Double prPreMoney;
	//10经费金额
	private Double prMoney;
	//11成果简介
	private String prResultInfo;
	//12状态
	private String prState;
	//13预算明细
	@OneToMany(mappedBy = "project",fetch= FetchType.LAZY,cascade = CascadeType.ALL)
	private Set<PreMoneyItem> preItem;
	//14使用明细
	@OneToMany(mappedBy = "project",fetch= FetchType.LAZY,cascade = CascadeType.ALL)
	private Set<MoneyItem> item;


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

	public Date getPrStartTime() {
		return prStartTime;
	}

	public void setPrStartTime(Date prStartTime) {
		this.prStartTime = prStartTime;
	}

	public Date getPrEndTime() {
		return prEndTime;
	}

	public void setPrEndTime(Date prEndTime) {
		this.prEndTime = prEndTime;
	}

	public int getPrDate() {
		return prDate;
	}

	public void setPrDate(int prDate) {
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

	public Set<PreMoneyItem> getPreItem() {
		return preItem;
	}

	public void setPreItem(Set<PreMoneyItem> preItem) {
		this.preItem = preItem;
	}

	public Set<MoneyItem> getItem() {
		return item;
	}

	public void setItem(Set<MoneyItem> item) {
		this.item = item;
	}
}