
package com.example.graduation.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name="t_Course")
@SequenceGenerator(name = "CourseSequence", sequenceName = "SEQ_COURSE", allocationSize = 1)
public class Course implements Serializable{

	//课程编号
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "CourseSequence")
	private Integer coNO;
	//课程名称
	private String coName;
	//课程学分
	private Double coScore;
	//课程学时
	private Integer coTime;
	//课程类型 : 必修，选修
	private String coType;
	//双语教学
	private Boolean co2Language;
	//所属学院
	private String school;
	@OneToMany(mappedBy="course",fetch = FetchType.EAGER)
	private Set<StudentCourse> studentCourse;

	public Integer getCoNO() {
		return coNO;
	}

	public void setCoNO(Integer coNO) {
		this.coNO = coNO;
	}

	public String getCoName() {
		return coName;
	}

	public void setCoName(String coName) {
		this.coName = coName;
	}

	public Double getCoScore() {
		return coScore;
	}

	public void setCoScore(Double coScore) {
		this.coScore = coScore;
	}

	public Integer getCoTime() {
		return coTime;
	}

	public void setCoTime(Integer coTime) {
		this.coTime = coTime;
	}

	public String getCoType() {
		return coType;
	}

	public void setCoType(String coType) {
		this.coType = coType;
	}

	public Boolean getCo2Language() {
		return co2Language;
	}

	public void setCo2Language(Boolean co2Language) {
		this.co2Language = co2Language;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public Set<StudentCourse> getStudentCourse() {
		return studentCourse;
	}

	public void setStudentCourse(Set<StudentCourse> studentCourse) {
		this.studentCourse = studentCourse;
	}
}