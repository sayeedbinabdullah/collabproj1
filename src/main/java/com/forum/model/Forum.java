package com.forum.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Forumtable",schema="sayeed")
public class Forum {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int qid;
	private String qTitle;
	private String qDescription;
	public int getQid() {
		return qid;
	}
	public void setQid(int qid) {
		this.qid = qid;
	}
	public String getqTitle() {
		return qTitle;
	}
	public void setqTitle(String qTitle) {
		this.qTitle = qTitle;
	}
	public String getqDescription() {
		return qDescription;
	}
	public void setqDescription(String qDescription) {
		this.qDescription = qDescription;
	}

	
}
