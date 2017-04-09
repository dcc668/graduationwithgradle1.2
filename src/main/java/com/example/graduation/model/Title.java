
package com.example.graduation.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

//@Entity
//@Table(name="t_Title")
//@Cache(usage= CacheConcurrencyStrategy.READ_WRITE)
public class Title  {
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "assigned")
	Integer titleId;
	String titleName;
	String titleProperty;
	String titleType;
	String titleSource;
	String term;
	Integer needStuNum;//需要的学生数
	Integer nowStuNum;//已经选的学生数
	@ManyToOne(cascade= CascadeType.MERGE,fetch= FetchType.EAGER)
	@JoinColumn(name="teId")
	private Teacher teacher;
	@ManyToOne(cascade= CascadeType.MERGE,fetch= FetchType.EAGER)
	@JoinColumn(name="majorId")
	private Major major;
	@OneToOne(mappedBy="title",fetch= FetchType.EAGER)
	private TitleReviewInfor titleReviewInfor;
	@OneToMany(mappedBy="title",fetch= FetchType.LAZY)
	private Set<Student> student;

	public Integer getTitleId() {
		return titleId;
	}

	public void setTitleId(Integer titleId) {
		this.titleId = titleId;
	}

	public String getTitleName() {
		return titleName;
	}

	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}

	public String getTitleProperty() {
		return titleProperty;
	}

	public void setTitleProperty(String titleProperty) {
		this.titleProperty = titleProperty;
	}

	public String getTitleType() {
		return titleType;
	}

	public void setTitleType(String titleType) {
		this.titleType = titleType;
	}

	public String getTitleSource() {
		return titleSource;
	}

	public void setTitleSource(String titleSource) {
		this.titleSource = titleSource;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public Integer getNeedStuNum() {
		return needStuNum;
	}

	public void setNeedStuNum(Integer needStuNum) {
		this.needStuNum = needStuNum;
	}

	public Integer getNowStuNum() {
		return nowStuNum;
	}

	public void setNowStuNum(Integer nowStuNum) {
		this.nowStuNum = nowStuNum;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Major getMajor() {
		return major;
	}

	public void setMajor(Major major) {
		this.major = major;
	}

	public TitleReviewInfor getTitleReviewInfor() {
		return titleReviewInfor;
	}

	public void setTitleReviewInfor(TitleReviewInfor titleReviewInfor) {
		this.titleReviewInfor = titleReviewInfor;
	}

	public Set<Student> getStudent() {
		return student;
	}

	public void setStudent(Set<Student> student) {
		this.student = student;
	}
}