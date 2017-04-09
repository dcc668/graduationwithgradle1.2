
package com.example.graduation.vo;

import com.example.graduation.model.Teacher;

import java.util.Date;
import java.util.List;

public class ProjectInfo {
	//项目ID
	private Integer pr_id;
	//项目名称
	private String pr_name;
	//项目来源
	private String pr_source;
	//负责人
	private Integer te_id;
	//项目成员
	private List<Teacher> memos;
	//立项时间
	private Date pr_startTime;
	//拟定期限
	private Date date;
	//经费金额
	private Double pr_money;
	//状态
	private String pr_state;


	public Integer getPr_id() {
		return pr_id;
	}

	public void setPr_id(Integer pr_id) {
		this.pr_id = pr_id;
	}

	public String getPr_name() {
		return pr_name;
	}

	public void setPr_name(String pr_name) {
		this.pr_name = pr_name;
	}

	public String getPr_source() {
		return pr_source;
	}

	public void setPr_source(String pr_source) {
		this.pr_source = pr_source;
	}

	public Integer getTe_id() {
		return te_id;
	}

	public void setTe_id(Integer te_id) {
		this.te_id = te_id;
	}

	public Date getPr_startTime() {
		return pr_startTime;
	}

	public void setPr_startTime(Date pr_startTime) {
		this.pr_startTime = pr_startTime;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getPr_money() {
		return pr_money;
	}

	public void setPr_money(Double pr_money) {
		this.pr_money = pr_money;
	}

	public String getPr_state() {
		return pr_state;
	}

	public void setPr_state(String pr_state) {
		this.pr_state = pr_state;
	}

	public List<Teacher> getMemos() {
		return memos;
	}

	public void setMemos(List<Teacher> memos) {
		this.memos = memos;
	}
}