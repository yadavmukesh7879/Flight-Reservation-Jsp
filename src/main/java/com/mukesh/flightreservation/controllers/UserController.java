package com.mukesh.flightreservation.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mukesh.flightreservation.entities.User;
import com.mukesh.flightreservation.repos.UserRepository;
import com.mukesh.flightreservation.services.SecurityService;

@Controller
public class UserController {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private SecurityService securityService;
	@Autowired
	private BCryptPasswordEncoder encoder;

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@RequestMapping("/showReg")
	public String showRegistrationPage() {
		LOGGER.info("Inside showRegistrationPage()");
		return ("login/registerUser");
	}

	@RequestMapping(value = "registerUser", method = RequestMethod.POST)
	public String register(@ModelAttribute("User") User user) {
		LOGGER.info("Inside register()" + user);
		user.setPassword(encoder.encode(user.getPassword()));
		userRepository.save(user);
		return "login/login";

	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(@RequestParam("email") String email, @RequestParam("password") String password,
			ModelMap modelmap) {
		LOGGER.info("Inside Login() and the email is: " + email);

		boolean loginResponse = securityService.login(email, password);
		if (loginResponse) {
			return "findFlights";
		} else {
			modelmap.addAttribute("msg", "Invalid username or password please try again");
		}

		return "login/login";

//		User user = this.userRepository.findByEmail(email);
//		if (user.getPassword().equals(password)) {
//			return "findFlights";
//		} else {
//			modelmap.addAttribute("msg", "Invalid username or password please try again");
//			return "login/login";
//		}

	}

	@RequestMapping("showLogin")
	public String showLogin() {
		LOGGER.info("Inside showLogin()");
		return "login/login";
	}
}
