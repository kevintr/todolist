package interview.javaguides.todolist.service;

import java.util.List;

import interview.javaguides.todolist.entity.Item;

public interface ItemService {
	List<Item> getAllItems();
	
	Item saveItem(Item student);
	
	Item getItemByIdAndLoggedUser(Long id);
	
	Item updateItem(Item student);
	
	void deleteItem(Item item);
}
