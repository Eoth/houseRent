package Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import estateProduct.Reservation;

public interface ReservationRepository extends CrudRepository<Reservation, Integer>{
	
	@Query("SELECT r FROM Reservation r WHERE r.resId=?1")
	public Reservation findById(int id);
	
	
   
	
	

}
