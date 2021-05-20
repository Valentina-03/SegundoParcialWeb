package co.empresa.SegundoParcial.Modelo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Team implements Serializable {
	private String id;
	private String name;
	private String country;
	public Team(String id, String name, String country) {
		this.id = id;
		this.name = name;
		this.country = country;
	}
	public String getId() {
		return this.id;
	}
	public String getName() {
		return this.name;
	}
	public String getCountry() {
		return this.country;
	}
	
}