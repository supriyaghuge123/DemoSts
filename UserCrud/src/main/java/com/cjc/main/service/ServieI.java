package com.cjc.main.service;

import java.util.List;

import com.cjc.main.entity.User;
import com.cjc.main.exception.UserNotFoundException;

public interface ServieI {

	User saveUsers(User user);

	Iterable<User> getUser(int pageNumber);

	User upadateUser(int userId, User user)throws UserNotFoundException;

	void removeUser(int userId)throws UserNotFoundException;

	List<User> findUserByName(String userName)throws UserNotFoundException;

}
