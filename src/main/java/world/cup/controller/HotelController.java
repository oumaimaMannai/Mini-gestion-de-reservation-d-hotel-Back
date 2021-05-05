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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import world.cup.models.Hotel;
import world.cup.service.HotelServiceImpl;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api/hotel")
public class HotelController {
	
	@Autowired
	private HotelServiceImpl hotelService;

	
	@GetMapping("/")
	public List<Hotel> getAllHotels() {
		List<Hotel> hotels = hotelService.findAll();
        return hotels;	    
	}
	
	@GetMapping(value ="/{id}") //URL
	public Hotel afficherHotel(@PathVariable Long id){
		Hotel hotel = hotelService.findById(id);
			return hotel;
	}
	
	@PostMapping("/add")
	public Hotel createHotel( @RequestBody Hotel hotel) {
	    return hotelService.add_hotel(hotel);
	}
	
	@DeleteMapping("/supprimere/{id}")
	public void deleteHotel(@PathVariable Long id) {
		hotelService.deleteById(id);
	}
	
	@PutMapping("/update/{id}")
	public Hotel updateHotel(@PathVariable(value = "id") Long Id,@RequestBody Hotel hotels) {
	          return hotelService.edit_hotel(hotels);
		
	}

}
