package interview.javaguides.todolist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import interview.javaguides.todolist.entity.Item;
import interview.javaguides.todolist.entity.User;

public interface ItemRepository extends JpaRepository<Item, Long>{
	
	List<Item> findAllByUser(User user);
}
