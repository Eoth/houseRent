package Controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Service.ProductService;
import Service.ReservationService;
import Service.UserService;
import estateProduct.Product;
import estateProduct.User;



@Controller
public class ProductController {
	
	@Autowired
    ProductService productService;
	
	@Autowired
    ReservationService resService;
	
	@Autowired
    UserService userService;
	
	
	/* 
	 * affichage des logements disponible
	 * */
	@GetMapping("/showproduct")
    public String findProducts(Model model) {

		List<Product> produits = (List<Product>) productService.findAllProduct();
		List<Product> produitsDispo = new ArrayList<>();
		
        // Il affiche unquement les biens immobiliers diponibles
		for(Product produit : produits) {
			if (produit.isAvailable()==true) produitsDispo.add(produit);	
		}
		
        model.addAttribute("produits", produitsDispo);

        return "showProducts";
    }	
	
	/* 
	 * ajouter un logement
	 * */
	@GetMapping("/formAddProduct")
    public String formOfProduct(Model model) {
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(user.getUsername()!=null) {
			Product initProd =  new Product();
			model.addAttribute("produit",initProd);
			return "form";
		}
		return "/";
    }	
	
	@PostMapping("/showproduct")
    public String productSubmit(Model model, @ModelAttribute("produit") @Valid Product produit, @RequestParam int id) {
		User user = userService.findByUserId(id);
		
		produit.setAvailable(true);
		produit.setOwner(user);
		productService.saveProduct(produit);
        return findProducts(model);
		    
    }
	
	@GetMapping("/showOne")
    public String oneProduct(Model model, @RequestParam int id) {
		model.addAttribute("product", productService.findByProductId(id));
        return "showOneProducts";
    }
	
	@GetMapping("/myProperty")
    public String findmyProduct(Model model) {
		
		return "myProperty";
    }
	
	@GetMapping("/myRentHouse")
    public String findmyREntProduct(Model model) {
		
		return "myRentHouse";
    }
	
//	@GetMapping("/deleteOne")
//    public String deleteProduct(Model model, @RequestParam int id) {
//		 productService.deleteByProductId(id);
//		 return findProducts(model);
//    }
		
	
	
}