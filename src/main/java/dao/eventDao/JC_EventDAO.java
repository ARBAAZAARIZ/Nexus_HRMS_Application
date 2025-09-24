package dao.eventDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.JC_Event;
import util.DatabaseConnection;

public class JC_EventDAO {
	
	public List<JC_Event> getAllEvents() {
        List<JC_Event> events = new ArrayList<>();
        String query = "SELECT e.event_id, e.event_title, e.event_date, et.event_type_color " +
                       "FROM events e " +
                       "JOIN event_type et ON e.event_type_id = et.event_type_id " +
                       "WHERE e.status = 'ACTIVE'";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                JC_Event event = new JC_Event();
                event.setId(rs.getInt("event_id"));
                event.setTitle(rs.getString("event_title"));
                event.setDate(rs.getDate("event_date"));
                event.setColor(rs.getString("event_type_color"));
                events.add(event);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return events;
    }

}
