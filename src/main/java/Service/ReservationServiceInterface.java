package Service;

import java.util.List;

import estateProduct.Reservation;

public interface ReservationServiceInterface {
	public List<Reservation> findAllReservation();
	public Reservation findByReservationId(int id);
	public void deleteByReservationId(int id);
	public void saveReservation(Reservation reservation);
	

}
