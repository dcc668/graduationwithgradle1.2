
package com.example.graduation.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="t_Teacher")
@SequenceGenerator(name = "TeacherSequence", sequenceName = "SEQ_TEACHER", allocationSize = 1)
public class Teacher  {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO,generator = "TeacherSequence")
	private Integer teId;
	private	String teName;
	private	String tePassword;
	private	String teSex;
	private	String tePosition;
	private	String teTel;
	private	String teAddr;
	private	String teMail;
	private	String teQQ;

	/**
	 * 用于hibernate级联删除
	 * @return
	 */
	@OneToMany(targetEntity=TeacherStudent.class,orphanRemoval=true,mappedBy = "teacher")
	private Set<TeacherStudent> teaStu;
	@OneToMany(targetEntity=TeacherProject.class,orphanRemoval=true,mappedBy = "teacher")
	private Set<TeacherProject> teaPro;
	@OneToMany(targetEntity=TeacherCourse.class,orphanRemoval=true,mappedBy = "teacher")
	private Set<TeacherCourse> teaCou;
	@OneToMany(targetEntity=Paper.class,orphanRemoval=true,mappedBy = "teacher")
	private Set<Paper> papers;


	public Integer getTeId() {
		return teId;
	}

	public void setTeId(Integer teId) {
		this.teId = teId;
	}

	public String getTeName() {
		return teName;
	}

	public void setTeName(String teName) {
		this.teName = teName;
	}

	public String getTePassword() {
		return tePassword;
	}

	public void setTePassword(String tePassword) {
		this.tePassword = tePassword;
	}

	public String getTeSex() {
		return teSex;
	}

	public void setTeSex(String teSex) {
		this.teSex = teSex;
	}

	public String getTePosition() {
		return tePosition;
	}

	public void setTePosition(String tePosition) {
		this.tePosition = tePosition;
	}

	public String getTeTel() {
		return teTel;
	}

	public void setTeTel(String teTel) {
		this.teTel = teTel;
	}

	public String getTeAddr() {
		return teAddr;
	}

	public void setTeAddr(String teAddr) {
		this.teAddr = teAddr;
	}

	public String getTeMail() {
		return teMail;
	}

	public void setTeMail(String teMail) {
		this.teMail = teMail;
	}

	public String getTeQQ() {
		return teQQ;
	}

	public void setTeQQ(String teQQ) {
		this.teQQ = teQQ;
	}

	public Set<TeacherStudent> getTeaStu() {
		return teaStu;
	}

	public void setTeaStu(Set<TeacherStudent> teaStu) {
		this.teaStu = teaStu;
	}

	public Set<TeacherProject> getTeaPro() {
		return teaPro;
	}

	public void setTeaPro(Set<TeacherProject> teaPro) {
		this.teaPro = teaPro;
	}

	public Set<Paper> getPapers() {
		return papers;
	}

	public void setPapers(Set<Paper> papers) {
		this.papers = papers;
	}

	public Set<TeacherCourse> getTeaCou() {
		return teaCou;
	}

	public void setTeaCou(Set<TeacherCourse> teaCou) {
		this.teaCou = teaCou;
	}
}