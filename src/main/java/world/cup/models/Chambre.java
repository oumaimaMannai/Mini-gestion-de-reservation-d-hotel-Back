package world.cup.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "chambre")
public class Chambre {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private int etage;

	@NotBlank
	private int numero;

	public Chambre(Long id, @NotBlank int etage, @NotBlank int numero) {
		super();
		this.id = id;
		this.etage = etage;
		this.numero = numero;
	}

	public Chambre(@NotBlank int etage, @NotBlank int numero) {
		super();
		this.etage = etage;
		this.numero = numero;
	}

	public Chambre() {
		super();
	}

	public Long getId() {
		return id;
	}

	public int getEtage() {
		return etage;
	}

	public int getNumero() {
		return numero;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setEtage(int etage) {
		this.etage = etage;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	
}
