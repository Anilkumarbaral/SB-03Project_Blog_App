package ins.ashokit.service;

import ins.ashokit.binding.LoginForm;
import ins.ashokit.binding.SignupForm;

public interface UserService {
	
	public String login(LoginForm form);
	
	public boolean  signup(SignupForm form);

}
