package ins.ashokit.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ins.ashokit.binding.LoginForm;
import ins.ashokit.binding.SignupForm;
import ins.ashokit.entity.User;
import ins.ashokit.repo.UserdtlRepo;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private HttpSession session;

	@Autowired
	private UserdtlRepo repo;

	@Override
	public String login(LoginForm form) {
		User status = repo.findByEmailAndPwd(form.getEmail(), form.getPwd());
		
		if(status==null) {
			return "invalid credentials";
		}
		session.setAttribute("userid", status.getId());
		return "success";
	}

	@Override
	public boolean signup(SignupForm form) {
		User user = new User();

		User findByEmail = repo.findByEmail(form.getEmail());

		if (findByEmail != null) {
			return false;
		}

		BeanUtils.copyProperties(form, user);

		repo.save(user);
		return true;

	}

}
