package dao.eventDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.JC_EventType;
import util.DatabaseConnection;

public class JC_EventTypeDAO {
	
	public void insert(JC_EventType event) throws SQLException {
        String sql = "INSERT INTO event_type(event_type_name, event_type_color) VALUES(?, ?)";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, event.getName());
            ps.setString(2, event.getColor());
            ps.executeUpdate();
        }
    }

    public List<JC_EventType> getAll() throws SQLException {
        List<JC_EventType> list = new ArrayList<>();
        String sql = "SELECT * FROM event_type";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                JC_EventType e = new JC_EventType();
                e.setId(rs.getInt("event_type_id"));
                e.setName(rs.getString("event_type_name"));
                e.setColor(rs.getString("event_type_color"));
                list.add(e);
            }
        }
        return list;
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM event_type WHERE event_type_id=?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

}
