
package com.example.graduation.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

//@Entity
//@Table(name="t_TitleReviewInfor")
//@Cache(usage= CacheConcurrencyStrategy.READ_WRITE)
public class TitleReviewInfor  {
	@Id
	@GeneratedValue(generator = "titleReviewInforGenerator")
	@GenericGenerator(name = "titleReviewInforGenerator", strategy = "assigned")
	Integer trId;
	String term;
	String titleExamine;
	String reviewSuggestion;
	String reviewState;
	@ManyToOne(cascade= CascadeType.MERGE,fetch= FetchType.EAGER)
	@JoinColumn(name="revId")
	Reviewer reviewer;
	@OneToOne(cascade= CascadeType.MERGE,fetch= FetchType.EAGER)
	@JoinColumn(name="titleId")
	Title title;

	public Integer getTrId() {
		return trId;
	}

	public void setTrId(Integer trId) {
		this.trId = trId;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public String getTitleExamine() {
		return titleExamine;
	}

	public void setTitleExamine(String titleExamine) {
		this.titleExamine = titleExamine;
	}

	public String getReviewSuggestion() {
		return reviewSuggestion;
	}

	public void setReviewSuggestion(String reviewSuggestion) {
		this.reviewSuggestion = reviewSuggestion;
	}

	public String getReviewState() {
		return reviewState;
	}

	public void setReviewState(String reviewState) {
		this.reviewState = reviewState;
	}

	public Reviewer getReviewer() {
		return reviewer;
	}

	public void setReviewer(Reviewer reviewer) {
		this.reviewer = reviewer;
	}

	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}
}