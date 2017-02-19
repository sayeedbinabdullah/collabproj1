package com.forum.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="JobRegtable",schema="sayeed")
public class JobRegistration {
	@Id
	@GeneratedValue
	private int count;
	private String name;
	private String mobile;
	private String email;
	private String address;
	private String qualif;
	private String passout;
	private String percentage;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="userId")
	private User user;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="jobId")
	private Jobs jobid;
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getQualif() {
		return qualif;
	}
	public void setQualif(String qualif) {
		this.qualif = qualif;
	}
	public String getPassout() {
		return passout;
	}
	public void setPassout(String passout) {
		this.passout = passout;
	}
	public String getPercentage() {
		return percentage;
	}
	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Jobs getJobid() {
		return jobid;
	}
	public void setJobid(Jobs jobid) {
		this.jobid = jobid;
	}
	
	

}
