package interview.javaguides.todolist.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import interview.javaguides.todolist.entity.Item;
import interview.javaguides.todolist.entity.User;
import interview.javaguides.todolist.repository.ItemRepository;
import interview.javaguides.todolist.service.ItemService;
import interview.javaguides.todolist.service.SessionUtilityService;

@Service
public class ItemServiceImpl implements ItemService{

	Logger logger = LoggerFactory.getLogger(ItemServiceImpl.class);
	
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private SessionUtilityService session;
	
	@Override
	public List<Item> getAllItems() {
		List<Item> items = new ArrayList<>();
		items = itemRepository.findAllByUser(session.getUserByMail());
		if(!items.isEmpty()) {
			logger.info(items.toString());
		}
		return items;
	}

	@Override
	public Item saveItem(Item item) {
		item.setUser(session.getUserByMail());
		return itemRepository.save(item);
	}

	@Override
	public Item getItemByIdAndLoggedUser(Long id) {
		User user = session.getUserByMail();

		Optional<Item> oItem = itemRepository.findAllByUserAndId(session.getUserByMail(), id);
		if (oItem.isPresent()) {
			return oItem.get();
		} else {
			logger.info("not found item for user : {} and id: {}",user.getFirstName(),id);
			//TODO: handle nullpointer exeption
			return null;
		}

	}

	@Override
	public Item updateItem(Item item) {
		return itemRepository.save(item);
	}

	@Override
	public void deleteItem(Item item) {
		itemRepository.deleteById(item.getId());	
	}

}
