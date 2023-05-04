package ins.ashokit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ins.ashokit.binding.LoginForm;
import ins.ashokit.binding.SignupForm;
import ins.ashokit.entity.User;
import ins.ashokit.service.UserService;

@Controller
public class BlogUserDtlController {
	
	@Autowired
	private UserService service;
	
	@GetMapping("/signup")
	public String signupPage(Model model) {
		
		model.addAttribute("user",new SignupForm());
		
		return "signup";
		
	}
	@PostMapping("/signup")
	public String hanleSignUpPage(@ModelAttribute("user")SignupForm form,Model model) {
		
		 boolean status = service.signup(form);
		 
		 if(status) {
			 model.addAttribute("succMsg","Successfully Registred");
		 }
		 else {
		 model.addAttribute("errMsg","Email id already registered,Give the new email id");
		 }
		 return "signup";
		
	}
	@GetMapping("/login")
	public String login(Model model) {
		
		model.addAttribute("loginForm",new LoginForm());
		return "login";
		
	}

	@PostMapping("/login")
	public String handleLogin(@ModelAttribute(name="loginForm")LoginForm form,Model model) {
		
		String status = service.login(form);
		
		if(status.contains("success")) {
			return "redirect:/dashboard";
		}
		model.addAttribute("errMsg","Invalid credentials");
		return "login";
		
	}
	
	
	
	
	
	
	
	
	
}
