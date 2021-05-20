package co.empresa.SegundoParcial.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.empresa.SegundoParcial.Modelo.Country;
import co.empresa.SegundoParcial.Util.Conexion;
import java.sql.PreparedStatement;

public class CountryDao {
	private Conexion conexion;
	private static final String INSERT_COUNTRY_SQL = "INSERT INTO country (name) VALUES (?)";
	private static final String DELETE_COUNTRY_ByID = "DELETE country WHERE id = ?";
	private static final String UPDATE_COUNTRY_SQL = "UPDATE country SET name = ?";
	private static final String SELECT_COUNTRY_ByID = "SELECT * FROM country WHERE id = ?";
	private static final String SELECT_ALL_COUNTRYS = "SELECT * FROM country";
	public CountryDao() {
		this.conexion = conexion.getConexion();
	}
	public void insertar(Country c) throws SQLException {
		try {
			PreparedStatement ps = conexion.setPreparedStatment(INSERT_COUNTRY_SQL);
			ps.setString(1, c.getName());
			conexion.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void delete(int id) throws SQLException {
		try {
			PreparedStatement ps = conexion.setPreparedStatment(DELETE_COUNTRY_ByID);
			ps.setInt(1, id);
			conexion.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void update(Country c) throws SQLException {
		try {
			PreparedStatement ps = conexion.setPreparedStatment(UPDATE_COUNTRY_SQL);
			ps.setString(1, c.getName());
			conexion.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public List<Country> selectAll() throws SQLException{
		List<Country> lista = new ArrayList<>();
		try {
			PreparedStatement ps = conexion.setPreparedStatment(SELECT_ALL_COUNTRYS);
			ResultSet rs = conexion.query();
			while(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				lista.add(new Country(id,name));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
	public Country selectCounttry(String id) throws SQLException{
		Country ans = null;
		try {
			PreparedStatement ps = conexion.setPreparedStatment(SELECT_COUNTRY_ByID);
			ps.setString(1, id);
			ResultSet rs = conexion.query();
			while(rs.next()) {
				String name = rs.getString("name");
				ans = new Country(id,name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ans;
	}
	
}