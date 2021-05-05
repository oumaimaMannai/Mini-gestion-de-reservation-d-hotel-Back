package world.cup.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "reservation")
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(max = 20)
	private String date_debut;

	@NotBlank
	@Size(max = 20)
	private String date_fin;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "reservation_chambre", 
				joinColumns = @JoinColumn(name = "reservation_id"), 
				inverseJoinColumns = @JoinColumn(name = "chambre_id"))
	private Set<Chambre> chambres = new HashSet<>();	
	
	
	public Set<Chambre> getChambres() {
		return chambres;
	}

	public void setChambres(Set<Chambre> chambres) {
		this.chambres = chambres;
	}

	public Long getId() {
		return id;
	}

	public String getDate_debut() {
		return date_debut;
	}

	public String getDate_fin() {
		return date_fin;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setDate_debut(String date_debut) {
		this.date_debut = date_debut;
	}

	public void setDate_fin(String date_fin) {
		this.date_fin = date_fin;
	}

	public Reservation(@NotBlank @Size(max = 20) String date_debut, @NotBlank @Size(max = 20) String date_fin) {
		super();
		this.date_debut = date_debut;
		this.date_fin = date_fin;
	}

	public Reservation(Long id, @NotBlank @Size(max = 20) String date_debut,
			@NotBlank @Size(max = 20) String date_fin) {
		super();
		this.id = id;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
	}

	public Reservation() {
		super();
	}
	
	
}
