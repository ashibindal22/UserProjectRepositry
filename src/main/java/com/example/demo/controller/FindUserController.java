package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@RestController
@RequestMapping("/find")
public class FindUserController {
	
	@Autowired
	UserRepository userRepositry;
	
	@RequestMapping("all")
	public List<User> getAllUsers()
	{
		return userRepositry.findAll();
	}
	
	
}
