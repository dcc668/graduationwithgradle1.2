
package com.example.graduation.model;

import javax.persistence.*;

@Entity
@Table(name="t_Teacher_Project")
@SequenceGenerator(name = "TeacherProjectSequence", sequenceName = "SEQ_TEACHERPROJECT", allocationSize = 1)
public class TeacherProject {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO,generator = "TeacherProjectSequence")
	private Integer tpId;
	@ManyToOne(cascade= CascadeType.MERGE,fetch= FetchType.EAGER)
	@JoinColumn(name="teId")
	private Teacher teacher;
	@ManyToOne(cascade= CascadeType.MERGE,fetch= FetchType.EAGER)
	@JoinColumn(name="prId")
	private Project project;

	public Integer getTpId() {
		return tpId;
	}

	public void setTpId(Integer tpId) {
		this.tpId = tpId;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}
}