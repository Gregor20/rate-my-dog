package com.Grigoriy.rate_my_dog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.Grigoriy.rate_my_dog.model.Dog;
import com.Grigoriy.rate_my_dog.service.DogService;

@Controller
public class DogController {
	
	@Autowired
	private DogService dogService;
	
	@GetMapping("/")
	public String index(Model model) {
		List<Dog> dogs = dogService.getAllDogs();
		model.addAttribute("dogs", dogs);
		return "index";
	}
}
// This class is a Spring MVC controller that handles HTTP GET requests to the root URL ("/").