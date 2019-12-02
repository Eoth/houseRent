package Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Repository.ReservationRepository;
import estateProduct.Reservation;

@Service
public class ReservationService implements ReservationServiceInterface {
	
	@Autowired  private ReservationRepository reservationRepository;

	@Override
	public List<Reservation> findAllReservation() {
		List<Reservation> reservations = (List<Reservation>) reservationRepository.findAll();
        return reservations;
	}

	@Override
	public Reservation findByReservationId(int id) {
		return reservationRepository.findById(id);
	}
	
	@Override
	public void deleteByReservationId(int id) {
		reservationRepository.deleteById(id);
	}
	
	@Override
	public void saveReservation(Reservation reservation) {
		reservationRepository.save(reservation);
		
	}
	

}
