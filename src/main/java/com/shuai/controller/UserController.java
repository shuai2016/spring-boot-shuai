package com.shuai.controller;

import com.shuai.entity.User;
import com.shuai.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * UserController
 *
 * @author shuai
 * @date 2018/12/3
 */
@RestController
public class UserController {

	@Autowired
	UserRepository userRepository;

	@GetMapping("/user/{id}")
	public User getUser(@PathVariable("id") Integer id){
		User user = userRepository.findOne(id);
		return user;
	}

	@GetMapping("/user")
	public User insertUser(User user){
		User save = userRepository.save(user);
		return save;
	}


}
