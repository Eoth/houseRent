package Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Service.ProductService;
import Service.ReservationService;
import Service.UserService;
import estateProduct.Product;
import estateProduct.Reservation;
import estateProduct.User;

@Controller
public class ReservationController {
	@Autowired
    ReservationService reservationService;
	
	@Autowired
    ProductService productService;
	
	@Autowired
    UserService userService;
	
	/*
	 * LA reservation d'un logement
	 * */
	@GetMapping("/reservation")
    public String reservation(Model model,@RequestParam int id,@RequestParam int id1) {
		Reservation reservation = new Reservation();// création d'une réservation vide
		User user = userService.findByUserId(id);//L'utilisateur qui demande la réservation
		Product product = productService.findByProductId(id1);// le logement demandé
		List<Reservation> allRes = reservationService.findAllReservation();//liste de tous les logements présent dans la base de donnée
		List<User> liste = new ArrayList<User>();
		System.out.println(allRes.get(0).getResId());
		
		/* Parcours des listes des reservations pour voir si le logement n'est pas déja crée dans reservation*/
		for(Reservation res : allRes) {
			if(res.getRealEstate()==null) reservationService.deleteByReservationId(res.getRealEstate().getProductId());
			if((res.getRealEstate()!=null) && res.getRealEstate().getProductId() == product.getProductId() ) {// vérifie si le produit est déja dans la réservation
				
				liste=res.getRequester();//récupère la liste des utilisateurs qui ont demandé le même logement
				int i=0;	
				for(User use:liste) {
					if(use.getUserId()==user.getUserId()) {
						i++;// ajout à la liste
					}
				}
				if (i==0) liste.add(user);
				res.setRequester(liste);
		        reservationService.saveReservation(res);
		     // mise à jour dans user
		        user.setUserRes(res);
		        userService.saveUser(user);
	            return "index";
			}
		}
		liste.add(user);
	    reservation.setRealEstate(product);
	    reservation.setRequester(liste);
	    // enrégistrement de de la réservation
        reservationService.saveReservation(reservation);
        // mise à jour dans user
        user.setUserRes(reservation);
        userService.saveUser(user);
        // mise à jour dans produit
        product.setRes(reservation);
        productService.saveProduct(product);
        
        return "index";
    }
	
	/*
	 * Consulter mes demandes de logements
	 * */
	@GetMapping("/myHouseRenter")
	public String houseRenter(Model model,@RequestParam int id) {
		User user = userService.findByUserId(id);//l'utilisateur
		List<Reservation> res,res2 = new ArrayList<Reservation>();
		res = reservationService.findAllReservation();// La liste des reservations
		for(Reservation rese : res) {//parcours de chaque reservation
			for(User use : rese.getRequester()) {//Dans reservation, parcours de la liste des demandeurs
				if(user.getUserId()==use.getUserId())// Si l'utilisateur connecté se trouve dans la liste
				{
					res2.add(rese);//Ajouter la reservation qui me concerne
				}
			}	
		}
		model.addAttribute("reservations",res2);
		return "myhouseRenter";
	}
	
	/*
	 * Consulter la réservation sur mes logements
	 * */
	@GetMapping("/myHouseReq")
	public String houseRequester(Model model,@RequestParam int id) {
		User user = userService.findByUserId(id);
		List<Reservation> res = new ArrayList<Reservation>();
		for(Product produit : user.getMyProperty()) {
			if (produit.getRes()!=null){
				Reservation rese = reservationService.findByReservationId(produit.getRes().getResId());
			    if(rese.getRealEstate()==produit && produit.isAvailable()==true )
			     {
				   res.add(rese);
			      }	
		     }
		}
		model.addAttribute("reservations",res);
		return "myHouseReq";
	}
	
	/*
	 * Consulter la; réservation sur mes logements
	 * */
	@GetMapping("/louer")
	public String acceptRouter(Model model, @RequestParam int id,@RequestParam int id1) {
		User user = userService.findByUserId(id);
		Product produit = productService.findByProductId(id1);
		List<Product> monprod = user.getMyRentHouse();
		monprod.add(produit);
		user.setMyRentHouse(monprod);
		produit.setRenter(user);
		produit.setAvailable(false);
		 userService.saveUser(user);
	     productService.saveProduct(produit);
		return "index";
	}
	 
}
