package world.cup.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "hotel")
public class Hotel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(max = 50)
	private String name_hotel;

	@Size(max = 50)
	private String photo;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName_hotel() {
		return name_hotel;
	}

	public String getPhoto() {
		return photo;
	}

	

	public void setName_hotel(String name_hotel) {
		this.name_hotel = name_hotel;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Hotel(Long id, @NotBlank @Size(max = 50) String name_hotel, @NotBlank @Size(max = 50) String photo) {
		super();
		this.id = id;
		this.name_hotel = name_hotel;
		this.photo = photo;
	}

	public Hotel() {
		super();
	}
	
	
}
