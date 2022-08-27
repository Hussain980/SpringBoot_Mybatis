package com.hussain.SpringBootMybatis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hussain.SpringBootMybatis.entity.Users;
import com.hussain.SpringBootMybatis.repository.UserMapper;

@RestController
public class UserController {

	@Autowired
	UserMapper userMapper;

	@GetMapping("/users")
	public List<Users> getAllUsers() {
		return userMapper.findAll();
	}

	@PostMapping("/users")
	public Users createUsers(@RequestBody Users users) {
		int id = userMapper.create(users);
		return userMapper.findById(id);
	}

	@GetMapping("/user/{id}")
	public Users getUserById(@PathVariable("id") Integer id) {
		return userMapper.findById(id);
	}

}
