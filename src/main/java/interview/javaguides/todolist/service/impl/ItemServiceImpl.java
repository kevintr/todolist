package interview.javaguides.todolist.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import interview.javaguides.todolist.entity.Item;
import interview.javaguides.todolist.entity.User;
import interview.javaguides.todolist.repository.ItemRepository;
import interview.javaguides.todolist.repository.UserRepository;
import interview.javaguides.todolist.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService{

	Logger logger = LoggerFactory.getLogger(ItemServiceImpl.class);
	
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<Item> getAllItems() {
		List<Item> items = new ArrayList<>();
		items = itemRepository.findAll();
		if(!items.isEmpty()) {
			logger.info(items.toString());
		}
		return items;
	}

	@Override
	public Item saveItem(Item item) {
		String mail = SecurityContextHolder.getContext().getAuthentication().getName();
		
		List<User> userList = userRepository.findByEmail(mail);
		logger.info("-------------------------------------------------------------------------- {}",mail);
//		logger.info(user.toString());
		item.setUser(userList.get(0));
		return itemRepository.save(item);
	}

	@Override
	public Item getItemById(Long id) {
		return itemRepository.findById(id).get();
	}

	@Override
	public Item updateItem(Item student) {
		return itemRepository.save(student);
	}

	@Override
	public void deleteItemById(Long id) {
		itemRepository.deleteById(id);	
	}

}
