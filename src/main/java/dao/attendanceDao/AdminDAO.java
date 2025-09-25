package dao.attendanceDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import util.DatabaseConnection;

public class AdminDAO {
	
	public List<Integer> getPresentEmployees() throws SQLException {
	    List<Integer> presentEmployees = new ArrayList<>();
	    String sql = "SELECT DISTINCT user_id FROM attendance WHERE date = CURDATE()";

	    try (Connection conn = DatabaseConnection.getConnection();
	         PreparedStatement ps = conn.prepareStatement(sql);
	         ResultSet rs = ps.executeQuery()) {
	        while (rs.next()) {
	            presentEmployees.add(rs.getInt("user_id"));
	        }
	    }
	    return presentEmployees;
	}

	
	public List<Integer> getAbsentEmployees() throws SQLException {
	    List<Integer> absentEmployees = new ArrayList<>();
	    String sql = "SELECT user_id FROM users WHERE user_id NOT IN (SELECT user_id FROM attendance WHERE date = CURDATE())";

	    try (Connection conn = DatabaseConnection.getConnection();
	         PreparedStatement ps = conn.prepareStatement(sql);
	         ResultSet rs = ps.executeQuery()) {
	        while (rs.next()) {
	            absentEmployees.add(rs.getInt("user_id"));
	        }
	    }
	    return absentEmployees;
	}

}
