package com.forum.dao;

import com.forum.model.UploadFile;

public interface FileDAO {
public abstract void uploadFile(UploadFile file);
	
	public abstract UploadFile getFile(long userid);

}
