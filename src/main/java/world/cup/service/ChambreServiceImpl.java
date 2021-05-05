package world.cup.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import world.cup.models.Chambre;
import world.cup.repositories.ChambreRepository;


@Service
public class ChambreServiceImpl {
	
	@Autowired
	private ChambreRepository chambreRepository;
	
	public Chambre add_chambre(Chambre chamb) {
		Chambre chambre = new Chambre();
		chambre.setEtage(chamb.getEtage());
		chambre.setNumero(chamb.getNumero());
		return chambreRepository.save(chambre);
	}
	
	
	public String deleteById(long id) {
		chambreRepository.deleteById(id);
		return "200 ok";
	}
	
	
	public Chambre edit_chambre(Chambre chamb) {		
		Chambre chambre = chambreRepository.findById(chamb.getId()).get();	
		chambre.setEtage(chamb.getEtage());
		chambre.setNumero(chamb.getNumero());
		return chambreRepository.save(chambre);
	}
	
	
	public List<Chambre> findAll() {
		List<Chambre> list = new ArrayList<>();
		chambreRepository.findAll().iterator().forEachRemaining(list::add);
		return list;
	}
	
	
	public Chambre findById(Long id) {
		return chambreRepository.findById(id).get();
	}


}
