package dao.leavesdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import util.DatabaseConnection;

public class HUserDAO {

	public String getFirstNameByUserId(int userId) {
		String sql = "SELECT first_name FROM users WHERE user_id = ?";
		String firstName = "Unknown";
		try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, userId);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next())
					firstName = rs.getString("first_name");
			}
		} catch (Exception e) {
			System.out.println("Error fetching user first name: " + e.getMessage());
		}
		return firstName;
	}
}
