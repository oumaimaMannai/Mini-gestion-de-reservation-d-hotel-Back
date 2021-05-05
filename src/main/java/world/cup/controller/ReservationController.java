package world.cup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import world.cup.models.Reservation;
import world.cup.service.ReservationServiceImpl;


@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class ReservationController {
	
	@Autowired
	private ReservationServiceImpl reservationService;
	
	@GetMapping("/reservation")
	public List<Reservation> getAllReservations() {
		List<Reservation> reservations = reservationService.findAll();
        return reservations;	    
	}
	
	@GetMapping(value ="/reservation/{id}") //URL
	public Reservation afficherReservation(@PathVariable Long id){
		Reservation reservation = reservationService.findById(id);
			return reservation;
	}
	
	@PostMapping("/addreservation")
	public Reservation createReservation( @RequestBody Reservation reservation) {
	    return reservationService.add_reservation(reservation);
	}
	
	@DeleteMapping("/supprimereservation/{id}")
	public void deleteReservation(@PathVariable Long id) {
		reservationService.deleteById(id);
	}
	
	@PutMapping("/updatereservation/{id}")
	public Reservation updateChambre(@PathVariable(value = "id") Long Id,@RequestBody Reservation reservation) {
	          return reservationService.edit_reservation(reservation);
		
	}

}
