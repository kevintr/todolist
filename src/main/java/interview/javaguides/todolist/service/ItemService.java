package interview.javaguides.todolist.service;

import java.util.List;

import interview.javaguides.todolist.entity.Item;

public interface ItemService {
	List<Item> getAllItems();
	
	Item saveItem(Item student);
	
	Item getItemById(Long id);
	
	Item updateItem(Item student);
	
	void deleteItemById(Long id);
}
