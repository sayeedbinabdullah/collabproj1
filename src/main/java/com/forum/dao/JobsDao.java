package com.forum.dao;

import java.util.List;

import com.forum.model.JobRegistration;
import com.forum.model.Jobs;

public interface JobsDao {

	void addJob(Jobs job);
	List<Jobs> viewJobs();
	void deleteJob(int id);
	void updateJob(Jobs job);
	Jobs viewJob(int id);
	void registerJob(JobRegistration jobregistration);
	
}
