
package com.example.graduation.model;

import javax.persistence.*;
import java.util.Set;

/**
 * 专业
 */
@Entity
@Table(name="t_Major")
@SequenceGenerator(name = "MajorSequence",sequenceName = "SEQ_MAJOR",allocationSize = 1)
public class Major  {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO,generator = "MajorSequence")
	private Integer majorId;
	private String majorName;
	@OneToMany(mappedBy="major",fetch = FetchType.EAGER,targetEntity=Student.class,orphanRemoval=true)
	private Set<Student> student;

	public Integer getMajorId() {
		return majorId;
	}

	public void setMajorId(Integer majorId) {
		this.majorId = majorId;
	}

	public String getMajorName() {
		return majorName;
	}

	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}

	public Set<Student> getStudent() {
		return student;
	}

	public void setStudent(Set<Student> student) {
		this.student = student;
	}
}