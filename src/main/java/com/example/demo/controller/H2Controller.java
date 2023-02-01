package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entiry.TestUser;
import com.example.demo.repo.Repos;

@RestController
public class H2Controller {
	
	@Autowired
	private Repos repos;
	
	@GetMapping("/test")
	public String get() {
		return "Terst";
	}

	@PostMapping("/test")
	public TestUser post(@RequestBody TestUser user) {
		/*
		 * User user = new User(); user.setId(1); user.setName("Mahesh");
		 */
		TestUser user1 = repos.save(user);
		return user1;
	}
	
	@GetMapping("/test/{id}")
	public Optional<TestUser> getById(@PathVariable("id") Integer id) {
		Optional<TestUser> users = repos.findById(id);
		return users;
	}
}
