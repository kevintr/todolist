package interview.javaguides.todolist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;

import interview.javaguides.todolist.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long>{
	
	List<Item> findAllByUser(User user);
}
