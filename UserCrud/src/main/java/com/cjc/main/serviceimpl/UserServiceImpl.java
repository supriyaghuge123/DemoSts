package com.cjc.main.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.cjc.main.entity.User;
import com.cjc.main.exception.UserNotFoundException;
import com.cjc.main.repo.UserRepository;
import com.cjc.main.service.ServieI;
@Service
public class UserServiceImpl implements ServieI  {

	@Autowired
	UserRepository userRepo;
	
	@Override
	public User saveUsers(User user) {
		// TODO Auto-generated method stub
		return userRepo.save(user);
	}

	@Override
	public Iterable<User> getUser(int pageNumber) {
		Sort sort=Sort.by("userName");
		Pageable pageable=PageRequest.of(pageNumber,3,sort);
		return userRepo.findAll(pageable);
	}

	@Override
	public User upadateUser(int userId,User user) throws UserNotFoundException {
		Optional<User> optionUser=userRepo.findById(userId);
		if(optionUser.isPresent())
		{
			User updatedUser=userRepo.save(user);
			return updatedUser;
		}
		else
		{
			// throw exception
			throw new UserNotFoundException("No User Find with Id :"+userId);

		}
		
	}

	@Override
	public void removeUser(int userId) throws UserNotFoundException {
		Optional<User> optionUser=userRepo.findById(userId);
		if(optionUser.isPresent())
		{
			userRepo.deleteById(userId);
		
		}
		else
		{
			// throw exception
			throw new UserNotFoundException("No User Find with Id :"+userId);
		}
		
	}

	@Override
	public List<User> findUserByName(String userName)throws UserNotFoundException{
		List<User> users=userRepo.findAllByUserName(userName);
		if(users.size()!=0)
		{
			return users;
		}
		else {
			throw new UserNotFoundException("No User Find with Name :"+userName);
		}
		
	}

}
