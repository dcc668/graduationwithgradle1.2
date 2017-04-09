
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
	//项目ID
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO,generator = "ProjectSequence")
	private Integer prId;
	//项目名称
	private String prName;
	//项目来源
	private String prSource;
	//立项时间
	private Date prStartTime;
	//拟定期限(天)
	private int prDate;
	//经费金额
	private Double prMoney;
	//状态
	private String prState;
	@OneToMany(mappedBy = "project",fetch= FetchType.LAZY)
	private Set<TeacherProject> teaPro;


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

	public Date getPrStartTime() {
		return prStartTime;
	}

	public void setPrStartTime(Date prStartTime) {
		this.prStartTime = prStartTime;
	}

	public int getPrDate() {
		return prDate;
	}

	public void setPrDate(int prDate) {
		this.prDate = prDate;
	}

	public Double getPrMoney() {
		return prMoney;
	}

	public void setPrMoney(Double prMoney) {
		this.prMoney = prMoney;
	}

	public String getPrState() {
		return prState;
	}

	public void setPrState(String prState) {
		this.prState = prState;
	}

	public Set<TeacherProject> getTeaPro() {
		return teaPro;
	}

	public void setTeaPro(Set<TeacherProject> teaPro) {
		this.teaPro = teaPro;
	}
}