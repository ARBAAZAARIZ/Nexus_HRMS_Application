package dao.leavesdao;

import java.sql.*;
import java.sql.Date;
import java.util.*;
import model.Event;
import util.DatabaseConnection;

public class HEventDAO {
	public List<Event> getActiveEventsByEventType(int eventTypeId) {
		List<Event> events = new ArrayList<>();
		String sql = "SELECT * FROM events WHERE event_type_id = ? AND status = 'ACTIVE'";
		try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, eventTypeId);
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					Event event = new Event();
					event.setEventId(rs.getInt("event_id"));
					event.setEventTitle(rs.getString("event_title"));
					event.setEventDate(rs.getDate("event_date"));
					event.setStatus(rs.getString("status"));
					event.setCreatedAt(rs.getTimestamp("created_at"));
					event.setModifiedAt(rs.getTimestamp("modified_at"));
					event.setCreatedBy(rs.getString("created_by"));
					event.setModifiedBy(rs.getString("modified_by"));
					event.setEventTypeId(rs.getInt("event_type_id"));
					events.add(event);
				}
			}
		} catch (Exception e) {
			System.out.println("Error fetching events by type: " + e.getMessage());
		}
		return events;
	}
	
	public List<Date> getHolidays() {
        List<Date> holidays = new ArrayList<>();
        String sql = "SELECT e.event_date FROM events e "
                   + "JOIN event_type et ON e.event_type_id = et.event_type_id "
                   + "WHERE et.event_type_name = 'Holiday' AND e.status = 'ACTIVE'";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                holidays.add(rs.getDate("event_date"));
            }
        } catch (Exception ex) {
            System.out.println("Error getting holidays: " + ex.getMessage());
        }
        return holidays;
    }
}
