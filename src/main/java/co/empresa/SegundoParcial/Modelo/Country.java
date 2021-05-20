package co.empresa.SegundoParcial.Modelo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Country implements Serializable {
	private String id;
	private String name;
	public Country(String id, String name) {
		this.id = id;
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	public String getId() {
		return this.id;
	}

}
