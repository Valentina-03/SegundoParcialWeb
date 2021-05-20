package co.empresa.SegundoParcial.Modelo;

import java.io.Serializable;
import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Cyclist implements Serializable {
	private int id;
	private String name;
	private String email;
	private Date fecha;
	private String country;
	private String team;
	public Cyclist(int id, String name, String email, Date fecha, String country, String team) {
		this.id = id;
		this.name = name;
		this.fecha = fecha;
		this.email = email;
		this.country = country;
		this.team = team;
	}
	public int getId() {
		return this.id;
	}
	public String getName() {
		return this.name;
	}
	public Date getFecha() {
		return this.fecha;
	}
	public String getEmail() {
		return this.email;
	}
	public String getCountry() {
		return this.country;
	}
	public String getTeam() {
		return this.team;
	}
}