package com.forum.dao;

import java.util.List;

import com.forum.model.Forum;

public interface ForumDao {
	
	void addQuestion(Forum forum);
	List<Forum> viewQuestions();
	void updateQuestion(Forum forum);
	void deleteQuestion(int qid);
	Forum getQuestion(int qid);
	

}
