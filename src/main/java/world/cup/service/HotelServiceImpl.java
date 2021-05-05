package world.cup.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import world.cup.models.Hotel;
import world.cup.repositories.HotelRepository;

@Service
public class HotelServiceImpl {
	
	@Autowired
	private HotelRepository hotelRepository;
	
	public Hotel add_hotel(Hotel hotels) {
		Hotel hotel = new Hotel();
		hotel.setName_hotel(hotels.getName_hotel());
		hotel.setPhoto(hotels.getPhoto());
		return hotelRepository.save(hotel);
	}
	
	
	public String deleteById(long id) {
		hotelRepository.deleteById(id);
		return "200 ok";
	}
	
	
	public Hotel edit_hotel(Hotel hotels) {		
		Hotel hotel = hotelRepository.findById(hotels.getId()).get();	
		hotel.setName_hotel(hotels.getName_hotel());
		return hotelRepository.save(hotel);
	}
	
	
	public List<Hotel> findAll() {
		List<Hotel> list = new ArrayList<>();
		hotelRepository.findAll().iterator().forEachRemaining(list::add);
		return list;
	}
	
	
	public Hotel findById(Long id) {
		return hotelRepository.findById(id).get();
	}

}
