package interview.javaguides.todolist.servive.impl.utility;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import interview.javaguides.todolist.entity.User;
import interview.javaguides.todolist.repository.UserRepository;
import interview.javaguides.todolist.service.SessionUtilityService;


 @Service
public class SessionUtilityServiceImpl implements SessionUtilityService {
	
	Logger logger = LoggerFactory.getLogger(SessionUtilityServiceImpl.class);
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User getUserByMail() {
		String mail = SecurityContextHolder.getContext().getAuthentication().getName();
		
		List<User> userList = userRepository.findByEmail(mail);
		logger.info("-------------------------------------------------------------------------- {}",mail);
		return userList.get(0);
	}
}
