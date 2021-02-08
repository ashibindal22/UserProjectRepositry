package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.OrderBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.assembler.UserAssembler;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.response.dto.UserDto;

@RestController
@RequestMapping("/find")
public class FindUserController {
	
	@Autowired
	UserRepository userRepositry;
	
	@Autowired
	UserAssembler userAssembler;
	
	@GetMapping("allUsers")
	public List<User> getAllUsers(@RequestParam(value= "page", defaultValue="2")  int page,
			@RequestParam(value="orderBy",defaultValue ="ASC") String orderBy)
	{
		Page<User> user = userRepositry.findAll(PageRequest.of(0, page) ,Sort.by(Sort.Direction.DESC,"name"));
		
		return user.getContent();
		
	}
	
	@GetMapping("id/{id}")
	public UserDto getAllUsersById(@PathVariable int id)
	{
		Optional<User> usr = userRepositry.findById(id);
		UserDto userDto=  userAssembler.toModel(usr);
		return userDto;
	}
	
	@GetMapping("name/{name}")
	public List<User> getAllUsersByName(@PathVariable String name)
	{
		
		List<User> usr = userRepositry.findByNameIgnoreCase(name);
		//UserDto userDto=  userAssembler.toModel(usr);
		return usr;
	}
	
	@GetMapping("AccountStatus/{status}")
	public List<User> getAllUsersByAccountStatus(@PathVariable String status)
	{
		List<User> usr = userRepositry.findByAccountStateIgnoreCase(status);
		//UserDto userDto=  userAssembler.toModel(usr);
		return usr;
	}
	
	@GetMapping("nameAsc/{name}")
	public List<User> getAllUsersOrderByName(@PathVariable String name)
	{
		List<User> usr = userRepositry.findByNameOrderByName(name);
		//UserDto userDto=  userAssembler.toModel(usr);
		return usr;
	}
	
	@GetMapping("nameDesc/{name}")
	public List<User> getAllUsersOrderByNameDesc(@PathVariable String name)
	{
		List<User> usr = userRepositry.findByNameOrderByNameDesc(name);
		//UserDto userDto=  userAssembler.toModel(usr);
		return usr;
	}
	
}
