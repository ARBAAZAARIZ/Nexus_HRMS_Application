package dao.eventDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.JC_Events;
import util.DatabaseConnection;

public class JC_EventsDAO {
	
	
	public void insert(JC_Events event) throws SQLException {
        String sql = "INSERT INTO events (event_title, event_date, status, created_by, event_type_id) "
                   + "VALUES (?, ?, 'ACTIVE', ?, ?)";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, event.getTitle());
            ps.setDate(2, event.getEventDate());
            ps.setString(3, event.getCreatedBy());
            ps.setInt(4, event.getEventTypeId());
            ps.executeUpdate();
        }
    }

	
	
	public List<JC_Events> getAll() throws SQLException {
        List<JC_Events> list = new ArrayList<>();
        String sql = "SELECT e.*, t.event_type_name " +
                     "FROM events e " +
                     "JOIN event_type t ON e.event_type_id = t.event_type_id";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                JC_Events ev = new JC_Events();
                ev.setId(rs.getInt("event_id"));
                ev.setTitle(rs.getString("event_title"));
                ev.setEventDate(rs.getDate("event_date"));
                ev.setStatus(rs.getString("status"));
                ev.setCreatedAt(rs.getTimestamp("created_at"));
                ev.setModifiedAt(rs.getTimestamp("modified_at"));
                ev.setCreatedBy(rs.getString("created_by"));
                ev.setModifiedBy(rs.getString("modified_by"));
                ev.setEventTypeId(rs.getInt("event_type_id"));
                ev.setEventTypeName(rs.getString("event_type_name"));
                list.add(ev);
            }
        }
        return list;
    }
	
	public void delete(int id) throws SQLException {
        String sql = "DELETE FROM events WHERE event_id=?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
	
	 public void update(JC_Events event) throws SQLException {
	        String sql = "UPDATE events SET event_title=?, event_date=?, event_type_id=?, "
	                   + "status=?, modified_at=CURRENT_TIMESTAMP, modified_by=? "
	                   + "WHERE event_id=?";
	        try (Connection con = DatabaseConnection.getConnection();
	             PreparedStatement ps = con.prepareStatement(sql)) {
	            ps.setString(1, event.getTitle());
	            ps.setDate(2, event.getEventDate());
	            ps.setInt(3, event.getEventTypeId());
	            ps.setString(4, event.getStatus());
	            ps.setString(5, event.getModifiedBy());
	            ps.setInt(6, event.getId());
	            ps.executeUpdate();
	        }
	    }
	 
	 
	 public JC_Events getById(int id) throws SQLException {
	        JC_Events ev = null;
	        String sql = "SELECT * FROM events WHERE event_id=?";
	        try (Connection con = DatabaseConnection.getConnection();
	             PreparedStatement ps = con.prepareStatement(sql)) {
	            ps.setInt(1, id);
	            try (ResultSet rs = ps.executeQuery()) {
	                if (rs.next()) {
	                    ev = new JC_Events();
	                    ev.setId(rs.getInt("event_id"));
	                    ev.setTitle(rs.getString("event_title"));
	                    ev.setEventDate(rs.getDate("event_date"));
	                    ev.setStatus(rs.getString("status"));
	                    ev.setCreatedAt(rs.getTimestamp("created_at"));
	                    ev.setModifiedAt(rs.getTimestamp("modified_at"));
	                    ev.setCreatedBy(rs.getString("created_by"));
	                    ev.setModifiedBy(rs.getString("modified_by"));
	                    ev.setEventTypeId(rs.getInt("event_type_id"));
	                }
	            }
	        }
	        return ev;
	    }
	 
	 public List<JC_Events> getAllWithEventType() throws SQLException {
	        List<JC_Events> list = new ArrayList<>();

	        String sql = "SELECT e.event_id, e.event_title, e.event_date, " +
	                     "et.event_type_color " +
	                     "FROM events e " +
	                     "JOIN event_type et ON e.event_type_id = et.event_type_id " +
	                     "WHERE e.status = 'ACTIVE'";

	        try (Connection con = DatabaseConnection.getConnection();
	             PreparedStatement ps = con.prepareStatement(sql);
	             ResultSet rs = ps.executeQuery()) {

	            while (rs.next()) {
	                JC_Events ev = new JC_Events();
	                ev.setId(rs.getInt("event_id"));
	                ev.setTitle(rs.getString("event_title"));
	                ev.setDate(rs.getDate("event_date").toString());  
	                ev.setColor(rs.getString("event_type_color"));  
	                ev.setEventDate(rs.getDate("event_date"));
	               
	                
	                list.add(ev);
	            }
	        }

	        return list;
	    }
	 
	 public void updateStatus(int id, String status) throws SQLException {
		    String sql = "UPDATE events SET status=?, modified_at=CURRENT_TIMESTAMP, modified_by='Admin' WHERE event_id=?";
		    try (Connection con = DatabaseConnection.getConnection();
		         PreparedStatement ps = con.prepareStatement(sql)) {
		        ps.setString(1, status);
		        ps.setInt(2, id);
		        ps.executeUpdate();
		    }
		}

	 
}
