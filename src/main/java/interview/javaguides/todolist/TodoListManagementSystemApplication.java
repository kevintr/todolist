package interview.javaguides.todolist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import interview.javaguides.todolist.entity.User;
import interview.javaguides.todolist.repository.UserRepository;

@SpringBootApplication
public class TodoListManagementSystemApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(TodoListManagementSystemApplication.class, args);
	}

	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		User user = new User("userdemo", "userdemo");
		userRepository.save(user);
	}


}
