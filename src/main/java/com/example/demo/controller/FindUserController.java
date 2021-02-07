package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@RestController
@RequestMapping("/find")
public class FindUserController {
	
	@Autowired
	UserRepository userRepositry;
	
	@RequestMapping("all/{id}")
	public Optional<User> getAllUsers(@PathVariable int id)
	{
		return userRepositry.findById(id);
	}
}
