package co.empresa.SegundoParcial.Dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.empresa.SegundoParcial.Modelo.Cyclist;
import co.empresa.SegundoParcial.Util.Conexion;
 
public class CyclistDao {
	private Conexion conexion;
	private static final String INSERT_CYCLIST_SQL = "INSERT INTO CYCLIST (name,email,fecha,country,team) VALUES (?,?,?,?,?)";
	private static final String DELETE_CYCLIST_ByID = "DELETE CYCLIST WHERE id = ?";
	private static final String UPDATE_CYCLIST_SQL = "UPDATE CYCLIST SET name = ?,email = ?, fecha = ?, country = ?, team = ?";
	private static final String SELECT_CYCLIST_ByID = "SELECT * FROM CYCLIST WHERE id = ? ";
	private static final String SELECT_ALL_CYCLISTS = "SELECT * FROM CYCLIST";
	public CyclistDao() {
		this.conexion = conexion.getConexion();
	}
	public void insertar(Cyclist c) throws SQLException {
		try {
			PreparedStatement ps = conexion.setPreparedStatment(INSERT_CYCLIST_SQL);
			ps.setString(1, c.getName());
			ps.setString(2, c.getEmail());
			ps.setDate(3, c.getFecha());
			ps.setString(4, c.getCountry());
			ps.setString(5, c.getTeam());
			conexion.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void delete(int id) throws SQLException {
		try {
			PreparedStatement ps = conexion.setPreparedStatment(DELETE_CYCLIST_ByID);
			ps.setInt(1, id);
			conexion.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void update(Cyclist c) throws SQLException {
		try {
			PreparedStatement ps = conexion.setPreparedStatment(UPDATE_CYCLIST_SQL);
			ps.setString(1, c.getName());
			ps.setString(2, c.getEmail());
			ps.setDate(3, c.getFecha());
			ps.setString(4, c.getCountry());
			ps.setString(5, c.getTeam());
			ps.setInt(6, c.getId());
			conexion.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public List<Cyclist> selectAll() throws SQLException{
		List<Cyclist> lista = new ArrayList<>();
		try {
			PreparedStatement ps = conexion.setPreparedStatment(SELECT_ALL_CYCLISTS);
			ResultSet rs = conexion.query();
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date fecha = rs.getDate("fecha");
				String contry = rs.getString("country");
				String team = rs.getString("team");
				lista.add(new Cyclist(id, name, email,fecha,contry,team));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
	public Cyclist selectCyclist(int id) throws SQLException{
		Cyclist ans = null;
		try {
			PreparedStatement ps = conexion.setPreparedStatment(SELECT_CYCLIST_ByID);
			ps.setInt(1, id);
			ResultSet rs = conexion.query();
			while(rs.next()) {
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date fecha = rs.getDate("fecha");
				String country = rs.getString("country");
				String team = rs.getString("team");
				ans = new Cyclist(id, name, email,fecha,country,team);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ans;
	}
}