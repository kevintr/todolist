package interview.javaguides.todolist.controller;


import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
	
	
	Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping
    public Principal retrievePrincipal(Principal principal) {
        return principal;
    }
    
    @GetMapping("/login")
	public String login() {
    	logger.info("login--------------------------------------------");
		return "login";
	}
	
	@GetMapping("/")
	public String home() {
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