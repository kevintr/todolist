package interview.javaguides.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import interview.javaguides.todolist.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long>{

}
