package dao.HelpandSupportDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import util.DatabaseConnection;
import model.Ticket;

public class M_AssignedDAO {

    public boolean assignTicket(int ticketId, int staffUserId) {
        String sql = "UPDATE tickets SET assign_to = ?, status = 'In Progress' WHERE ticket_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, staffUserId);
            ps.setInt(2, ticketId);
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

  
    public Ticket getTicketById(int ticketId) {
        String sql = "SELECT t.ticket_id, t.title, t.description, t.attachment, " +
                     "t.created_at, t.assign_to, t.resolve_date, t.status, " +
                     "u.name AS assign_name " +
                     "FROM tickets t " +
                     "LEFT JOIN users u ON t.assign_to = u.user_id " +
                     "WHERE t.ticket_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, ticketId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Ticket t = new Ticket();
                    t.setTicketId(rs.getInt("ticket_id"));
                    t.setTitle(rs.getString("title"));
                    t.setDescription(rs.getString("description"));
                    t.setAttachment(rs.getString("attachment"));
                    t.setCreatedAt(rs.getTimestamp("created_at"));
                    t.setStatus(rs.getString("status"));
                    t.setResolveDate(rs.getDate("resolve_date"));

                    int assignTo = rs.getInt("assign_to");
                    if (rs.wasNull()) {
                        t.setAssignTo(0); 
                    } else {
                        t.setAssignTo(assignTo);
                    }

                    t.setAssignToName(rs.getString("assign_name"));  
                    return t;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Ticket> getAllTickets() {
        String sql = "SELECT t.ticket_id, t.ticket_title, t.ticket_description, t.image_path, " +
                     "t.created_at, t.assign_to, t.resolve_date, t.status, " +
                     "u.first_name AS assign_name " +
                     "FROM tickets t " +
                     "LEFT JOIN users u ON t.assign_to = u.user_id " +
                     "ORDER BY t.created_at DESC";

        List<Ticket> list = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Ticket t = new Ticket();
                t.setTicketId(rs.getInt("ticket_id"));
                t.setTitle(rs.getString("ticket_title"));
                t.setDescription(rs.getString("ticket_description"));
                t.setAttachment(rs.getString("image_path"));
                t.setCreatedAt(rs.getTimestamp("created_at"));
                t.setStatus(rs.getString("status"));
                t.setResolveDate(rs.getDate("resolve_date"));

                int assignTo = rs.getInt("assign_to");
                if (rs.wasNull()) {
                    t.setAssignTo(0);
                } else {
                    t.setAssignTo(assignTo);
                }

                t.setAssignToName(rs.getString("assign_name"));
                list.add(t);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    
    
    public List<Ticket> getAllStaff() {
        List<Ticket> staffList = new ArrayList<>();
        String sql = "SELECT user_id, name FROM users WHERE role='staff'";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Ticket staff = new Ticket();
                staff.setAssignTo(rs.getInt("user_id"));  
                staff.setAssignToName(rs.getString("name"));  
                staffList.add(staff);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return staffList;
    }
}
