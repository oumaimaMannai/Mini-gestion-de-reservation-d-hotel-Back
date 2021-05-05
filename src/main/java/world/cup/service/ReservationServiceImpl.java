package world.cup.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import world.cup.models.Reservation;
import world.cup.repositories.ReservationRepository;


@Service
public class ReservationServiceImpl {
	
	@Autowired
	private ReservationRepository reservationRepository;
	
	public Reservation add_reservation(Reservation res) {
		Reservation reservation = new Reservation();
		reservation.setDate_debut(res.getDate_debut());
		reservation.setDate_fin(res.getDate_fin());
		return reservationRepository.save(reservation);
	}
	
	
	public String deleteById(long id) {
		reservationRepository.deleteById(id);
		return "200 ok";
	}
	
	
	public Reservation edit_reservation(Reservation res) {		
		Reservation reservation = reservationRepository.findById(res.getId()).get();	
		reservation.setDate_debut(res.getDate_debut());
		reservation.setDate_fin(res.getDate_fin());
		return reservationRepository.save(reservation);
	}
	
	
	public List<Reservation> findAll() {
		List<Reservation> list = new ArrayList<>();
		reservationRepository.findAll().iterator().forEachRemaining(list::add);
		return list;
	}
	
	
	public Reservation findById(Long id) {
		return reservationRepository.findById(id).get();
	}

}
