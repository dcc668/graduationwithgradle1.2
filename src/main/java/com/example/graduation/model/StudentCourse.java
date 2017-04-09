
package com.example.graduation.model;

import javax.persistence.*;

@Entity
@Table(name="t_stu_course")
@SequenceGenerator(name = "StudentCourseSequence", sequenceName = "SEQ_STUDENTCOURSE", allocationSize = 1)
public class StudentCourse {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO,generator = "StudentCourseSequence")
	private Integer tsId;
	private Integer score;
	@ManyToOne(cascade= CascadeType.MERGE,fetch = FetchType.EAGER)
	@JoinColumn(name="coNO")
	private Course course;
	@ManyToOne(cascade= CascadeType.MERGE,fetch = FetchType.EAGER)
	@JoinColumn(name="sId")
	private Student student;

	public Integer getTsId() {
		return tsId;
	}

	public void setTsId(Integer tsId) {
		this.tsId = tsId;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
}