
package com.example.graduation.model;

import javax.persistence.*;

@Entity
@Table(name="t_Teacher_Student")
@SequenceGenerator(name = "TeacherStudentSequence", sequenceName = "SEQ_TEACHERSTUDENT", allocationSize = 1)
public class TeacherStudent  {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO,generator = "TeacherStudentSequence")
	Integer tsId;
	Integer score;
	@ManyToOne(cascade= CascadeType.MERGE,fetch= FetchType.EAGER)
	@JoinColumn(name="teId")
	private Teacher teacher;
	@ManyToOne(cascade= CascadeType.MERGE,fetch= FetchType.EAGER)
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

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
}