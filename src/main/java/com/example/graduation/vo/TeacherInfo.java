
package com.example.graduation.vo;

import com.example.graduation.model.Course;
import com.example.graduation.model.TeacherStudent;

import java.util.List;
import java.util.Set;

public class TeacherInfo  {
	private Integer teId;
	private	String teName;
	private	String tePassword;
	private	String teSex;
	private	String tePosition;
	private	String teTel;
	private	String teAddr;
	private	String teMail;
	private	String teQQ;
	private Set<TeacherStudent> teaStu;


	private List<Course> courses;


	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

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
	
}