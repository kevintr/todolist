package interview.javaguides.todolist.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import interview.javaguides.todolist.controller.ItemController;
import interview.javaguides.todolist.entity.Item;
import interview.javaguides.todolist.repository.ItemRepository;
import interview.javaguides.todolist.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService{

	Logger logger = LoggerFactory.getLogger(ItemServiceImpl.class);
	
	
	private ItemRepository itemRepository;
	

	
	public ItemServiceImpl(ItemRepository itemRepository) {
		super();
		this.itemRepository = itemRepository;
	}

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