package Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Service.UserService;
import estateProduct.User;

@Controller
public class UserController {
	@Autowired
    UserService userService;
	
		
//	@PostMapping("/menu")
//	public String firstPage(Model model, @ModelAttribute("user") @Valid User user)
//	{
//		if(user!=null) {
//			List<User> users = (List<User>) userService.findAllUser();
//			for(User use : users) {
//				if(use.getUsername().equals(user.getUsername()) && use.getPassword().equals(user.getPassword())) {
//					model.addAttribute("user",use);
//					return "index";
//			     }
//		     }
//	     }
//		return firstloginPage(model);
//	}
	
	@GetMapping("/menu")
	public String returnfirstPage(Model model,@RequestParam int id) {
		
		User user = userService.findByUserId(id);
		model.addAttribute("user",user);
		return "index";
	}
	
}
