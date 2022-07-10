package interview.javaguides.todolist.controller;


import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import interview.javaguides.todolist.service.ItemService;

@Controller
public class UserController {
	
	
	Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping
    public Principal retrievePrincipal(Principal principal) {
        return principal;
    }
    
    @Autowired
	private ItemService itemService;
    
    @GetMapping("/login")
	public String login() {
    	logger.info("login--------------------------------------------");
		return "login";
	}
	
	// handler method to handle list items and return mode and view
	@GetMapping("/")
	public String listItems(Model model) {
		logger.info("START listItems" );
		model.addAttribute("items", itemService.getAllItems());
		logger.info("END listItems");
		return "items";
	}
	
//    
//	@PostMapping("/login")
//	public String login(@ModelAttribute("userdto") UserDto userdto) {
//		logger.info("START login" );
//		logger.info("userdto -----------------------------------------------------------------------------------{}",userdto );
//		
//		
//		logger.info("END login" );
//		return "redirect:/items";
//	}
	
	
}