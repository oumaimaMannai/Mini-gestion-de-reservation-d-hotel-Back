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

import world.cup.models.Chambre;
import world.cup.service.ChambreServiceImpl;


@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api/chambre")
public class ChambreController {
	
	@Autowired
	private ChambreServiceImpl chambreServiceImpl;
	
	@GetMapping("/")
	public List<Chambre> getAllChambres() {
		List<Chambre> chambres = chambreServiceImpl.findAll();
        return chambres;	    
	}
	
	@GetMapping(value ="/chambre/{id}") //URL
	public Chambre afficherChambre(@PathVariable Long id){
		Chambre chambre = chambreServiceImpl.findById(id);
			return chambre;
	}
	
	@PostMapping("/addchambre")
	public Chambre createChambre( @RequestBody Chambre chambre) {
	    return chambreServiceImpl.add_chambre(chambre);
	}
	
	@DeleteMapping("/supprimechambre/{id}")
	public void deleteChambre(@PathVariable Long id) {
		chambreServiceImpl.deleteById(id);
	}
	
	@PutMapping("/updatechambre/{id}")
	public Chambre updateChambre(@PathVariable(value = "id") Long Id,@RequestBody Chambre chambre) {
	          return chambreServiceImpl.edit_chambre(chambre);
		
	}


}
