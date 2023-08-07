package com.cjc.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.main.entity.User;
import com.cjc.main.exception.UserNotFoundException;
import com.cjc.main.service.ServieI;
@RequestMapping("/user")
@RestController
@CrossOrigin("*")
public class UserController {
	
	@Autowired 
	ServieI userservice;
	
	@PostMapping("/saveUser")
	public User saveUser(@RequestBody User user)
	{
		User users=userservice.saveUsers(user);
		return users;
	}
	
	@GetMapping("/getUser/{pageNumber}")
	public Iterable<User> getUser(@PathVariable int pageNumber)
	{
		Iterable<User> users=userservice.getUser(pageNumber);
		
		return users;
		
	}
	
	@PutMapping("/updateUser/{userId}")
	public User updateUser(@PathVariable int userId, @RequestBody User user) throws UserNotFoundException
	{
		User users=userservice.upadateUser(userId,user);
		return users;
		
	}
	
	@DeleteMapping("/deleteUser/{userId}")
	public void removeUser(@PathVariable int userId) throws UserNotFoundException
	{
		userservice.removeUser(userId);
	}
	
	@GetMapping("/searchUser/{userName}")
	public List<User> findUserByName(@PathVariable String userName)throws UserNotFoundException
	{
		List<User> usersname=userservice.findUserByName(userName);
		return usersname;
	}
	@GetMapping("/SaveAll")
	public List<User> saveAll(@PathVariable String userName)throws UserNotFoundException
	{
		List<User> usersname=userservice.saveAllMethod(userName);
		return usersname1;
	}
	
}
