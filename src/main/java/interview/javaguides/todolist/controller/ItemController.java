package interview.javaguides.todolist.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import interview.javaguides.todolist.entity.Item;
import interview.javaguides.todolist.service.ItemService;

@Controller
public class ItemController {
	
	Logger logger = LoggerFactory.getLogger(ItemController.class);
	
	private ItemService itemService;

	public ItemController(ItemService itemService) {
		super();
		this.itemService = itemService;
	}
	
	// handler method to handle list items and return mode and view
	@GetMapping("/items")
	public String listItems(Model model) {
		logger.info("START listItems" );
		model.addAttribute("items", itemService.getAllItems());
		logger.info("END listItems");
		return "items";
	}
	
	@GetMapping("/items/new")
	public String createItemForm(Model model) {
		logger.info("START createItemForm" );
		// create item object to hold item form data
		Item item = new Item();
		model.addAttribute("item", item);
		logger.info("END createItemForm" );
		return "create_item";
		
	}
	
	@PostMapping("/items")
	public String saveItem(@ModelAttribute("item") Item item) {
		logger.info("START saveItem" );
		itemService.saveItem(item);
		logger.info("END saveItem" );
		return "redirect:/items";
	}
	
	@GetMapping("/items/edit/{id}")
	public String editItemForm(@PathVariable Long id, Model model) {
		logger.info("START editItemForm" );

		model.addAttribute("item", itemService.getItemById(id));
		
		logger.info("END editItemForm" );
		return "edit_item";
	}

	@PostMapping("/items/{id}")
	public String updateItem(@PathVariable Long id,
			@ModelAttribute("item") Item item,
			Model model) {
		
		logger.info("START updateItem" );
		// get item from database by id
		Item existingItem = itemService.getItemById(id);
		existingItem.setId(id);
		existingItem.setDescription(item.getDescription());
//		existingItem.setLastName(item.getLastName());
//		existingItem.setEmail(item.getEmail());
		
		// save updated item object
		itemService.updateItem(existingItem);
		logger.info("END updateItem" );
		return "redirect:/items";		
	}
	
	// handler method to handle delete item request
	
	@GetMapping("/items/{id}")
	public String deleteItem(@PathVariable Long id) {
		logger.info("START deleteItem" );
		itemService.deleteItemById(id);
		logger.info("END deleteItem" );
		return "redirect:/items";
	}
	
}
