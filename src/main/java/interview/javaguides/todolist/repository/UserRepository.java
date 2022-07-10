package interview.javaguides.todolist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import interview.javaguides.todolist.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	
	List<User> findByEmail(String email);
}
