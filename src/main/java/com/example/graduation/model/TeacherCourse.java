
package com.example.graduation.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="t_Teacher_Course")
@SequenceGenerator(name = "TeacherCourseSequence", sequenceName = "SEQ_TEACHERCOURSE", allocationSize = 1)
public class TeacherCourse implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO,generator = "TeacherCourseSequence")
	private Integer tcId;
	//学期
	private String term;
	//任教类型
	private String type;
	//班级批次
	private int houseNum;
	//总人数
	private int stuNum;
	//未通过人数
	private int notPassNum;
	//备注信息
	private String mark;
	@ManyToOne(cascade= CascadeType.MERGE,fetch= FetchType.EAGER)
	@JoinColumn(name="teId")
	private Teacher teacher;
	@ManyToOne(cascade= CascadeType.MERGE,fetch= FetchType.EAGER)
	@JoinColumn(name="coNO")
	private Course course;

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

	public int getHouseNum() {
		return houseNum;
	}

	public void setHouseNum(int houseNum) {
		this.houseNum = houseNum;
	}

	public int getStuNum() {
		return stuNum;
	}

	public void setStuNum(int stuNum) {
		this.stuNum = stuNum;
	}

	public int getNotPassNum() {
		return notPassNum;
	}

	public void setNotPassNum(int notPassNum) {
		this.notPassNum = notPassNum;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}


	@Override
	public String toString() {
		return "com.example.graduation.model.TeacherCourse{" +
				"tcId=" + tcId +
				", term='" + term + '\'' +
				", type='" + type + '\'' +
				", houseNum=" + houseNum +
				", stuNum=" + stuNum +
				", notPassNum=" + notPassNum +
				", mark='" + mark + '\'' +
				", teacher=" + teacher +
				", course=" + course +
				'}';
	}
}