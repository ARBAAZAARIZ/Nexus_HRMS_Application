package dao.leavesdao;

import java.sql.*;
import model.EventType;
import util.DatabaseConnection;

public class HEventTypeDAO {
	public EventType getEventTypeByName(String name) {
		EventType eventType = null;
		String sql = "SELECT * FROM event_type WHERE event_type_name = ?";
		try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, name);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					eventType = new EventType();
					eventType.setEventTypeId(rs.getInt("event_type_id"));
					eventType.setEventTypeName(rs.getString("event_type_name"));
					eventType.setEventTypeColor(rs.getString("event_type_color"));
				}
			}
		} catch (Exception e) {
			System.out.println("Error fetching event type: " + e.getMessage());
		}
		return eventType;
	}
}
