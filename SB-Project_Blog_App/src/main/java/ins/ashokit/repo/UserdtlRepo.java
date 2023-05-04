package ins.ashokit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import ins.ashokit.entity.User;

public interface UserdtlRepo extends JpaRepository<User, Integer>{
	
	public User findByEmail(String email);
	
	public User findByEmailAndPwd(String email,String pwd);

}
