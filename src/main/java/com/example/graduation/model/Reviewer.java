
package com.example.graduation.model;

import javax.persistence.*;
import java.util.Set;

//@Entity
//@Table(name="t_Reviewer")
//@SequenceGenerator(name = "ReviewerSequence", sequenceName = "SEQ_REVIEWER", allocationSize = 1)
public class Reviewer  {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO,generator = "ReviewerSequence")
	Integer revId;
	String revName;
	String revPassword;
	@OneToMany(mappedBy="reviewer",fetch= FetchType.LAZY)
	Set<TitleReviewInfor> titleReviewInfor;

	public Integer getRevId() {
		return revId;
	}

	public void setRevId(Integer revId) {
		this.revId = revId;
	}

	public String getRevName() {
		return revName;
	}

	public void setRevName(String revName) {
		this.revName = revName;
	}

	public String getRevPassword() {
		return revPassword;
	}

	public void setRevPassword(String revPassword) {
		this.revPassword = revPassword;
	}

	public Set<TitleReviewInfor> getTitleReviewInfor() {
		return titleReviewInfor;
	}

	public void setTitleReviewInfor(Set<TitleReviewInfor> titleReviewInfor) {
		this.titleReviewInfor = titleReviewInfor;
	}
}