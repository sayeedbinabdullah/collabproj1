package com.forum.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class UploadFile {
	
	
	@Id
	@GeneratedValue
	@Column(name="FILE_ID")	
	private long id;
	
	@Column(name="FILE_NAME")
	private String filename;
	
	@Lob
	@Column(name="FILE_DATA")
	private byte[] data;
	
	private long userid;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public byte[] getData() {
		return data;
	}
	public void setData(byte[] data) {
		this.data = data;
	}
	public long getUserid() {
		return userid;
	}
	public void setUserid(long userid) {
		this.userid = userid;
	}
	
	
	
	

}



