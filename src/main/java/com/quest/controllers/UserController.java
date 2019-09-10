package com.quest.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.quest.model.User;
import com.quest.repositories.UserRepository;

@Controller
public class UserController {

	private UserRepository userRepository;

	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@GetMapping("/signup")
	public String showSignUpForm(User user) {
		return "add-user";
	}

	@PostMapping("/addUser")
	public String addUser(@Valid User user, BindingResult result, Model model, HttpSession session) {
		
		if (result.hasErrors()) {
			return "add-user";
		} else {
			User dummy = (User) userRepository.findByPpsNumber(user.getPpsNumber());
			
			if (null != dummy) {
				if (!(dummy.getPpsNumber().equals(user.getPpsNumber()))) {
					this.userRepository.save(user);
					model.addAttribute("users", userRepository.findAll());
					return "view-user";
				} else {
					model.addAttribute("errorMessage", "PPS Number is already registered in the system");
					return "add-user";
				}
			} else {
				this.userRepository.save(user);
				model.addAttribute("users", userRepository.findAll());
				return "view-user";
			}
		}
	}

	@GetMapping("/viewUsers")
	public String showUsers(Model model) {
		model.addAttribute("users", userRepository.findAllByOrderByCreatedDate());
		return "view-user";
	}

	@GetMapping("/")
	public String showHomePage() {
		return "index";
	}
}
