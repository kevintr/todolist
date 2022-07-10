package interview.javaguides.todolist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import interview.javaguides.todolist.entity.User;
import interview.javaguides.todolist.repository.UserRepository;

@SpringBootApplication
public class TodoListManagementSystemApplication extends SpringBootServletInitializer implements CommandLineRunner  {

	public static void main(String[] args) {
		SpringApplication.run(TodoListManagementSystemApplication.class, args);
	}

	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		User user = new User("demo", "demo", "demo@demo.com", "$2a$12$6E2aX.XDYOraXtlR4F20TeQppuiedr0HOk8jANyclhwUtO7Xmefqy", null);
		userRepository.save(user);
		User user2 = new User("demo2", "demo2", "demo2@demo.com", "$2a$12$6E2aX.XDYOraXtlR4F20TeQppuiedr0HOk8jANyclhwUtO7Xmefqy", null);
		userRepository.save(user2);
	}


}
