package com.forum.dao;

import java.util.List;

import com.forum.model.Friend;

public interface FriendDAO {
	
	public void addFriend(Friend friend);
	public void updateFriend(Friend friend);
	public void deleteFriend(long id);
	public Friend getFriend(long userId, long friendId);
	public List<Friend> listMyFriends(long userId);
	public List<Friend> listNewFriendRequests(long userId);
	public void setOnline(long userId);
	public void setOffline(long userId);

}
