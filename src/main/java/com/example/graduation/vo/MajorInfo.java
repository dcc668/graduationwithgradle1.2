
package com.example.graduation.vo;

import java.util.Set;


public class MajorInfo  {
	Integer majorId;
	String majorName;
	Set<StudentInfo> student;

	
	public Integer getMajorId() {
		return majorId;
	}
	
	public void setMajorId(Integer majorId) {
		this.majorId = majorId;
	}
	
	
	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}
	public String getMajorName() {
		return majorName;
	}
	public Set<StudentInfo> getStudent() {
		return student;
	}
	public void setStudent(Set<StudentInfo> student) {
		this.student = student;
	}





	
}