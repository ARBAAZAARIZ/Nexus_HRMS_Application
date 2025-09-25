package dao.HelpandSupportDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import model.Ticket;
import util.DatabaseConnection;

public class TicketDAO {

    
    public boolean raiseTicket(Ticket ticket) {
         
        String sql = "INSERT INTO tickets (user_id, ticket_title, ticket_description, image_path, created_at, status) " +
                     "VALUES (?, ?, ?, ?, ?, 'Raised')";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, ticket.getUserId());
            ps.setString(2, ticket.getTitle());
            ps.setString(3, ticket.getDescription()); 
            
            
            ps.setString(4, ticket.getAttachment());
            ps.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
            
            System.out.println("DAO Insert: userId=" + ticket.getUserId() 
            + ", title=" + ticket.getTitle() 
            + ", desc=" + ticket.getDescription() 
            + ", attachment=" + ticket.getAttachment());

            int rows = ps.executeUpdate();
            return rows > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Ticket> getTicketsByUserId(int userId) {
        List<Ticket> tickets = new ArrayList<>();

        String sql = "SELECT t.ticket_id, t.ticket_title, t.ticket_description, t.image_path, " +
                     "t.created_at, t.assign_to AS assigned_user_id, u.first_name, u.last_name, " +
                     "t.resolve_date, t.status " +
                     "FROM tickets t " +
                     "LEFT JOIN users u ON t.assign_to = u.user_id " +
                     "WHERE t.user_id = ? " +
                     "ORDER BY t.created_at DESC";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Ticket ticket = new Ticket();
                ticket.setTicketId(rs.getInt("ticket_id"));
                ticket.setTitle(rs.getString("ticket_title"));
                ticket.setDescription(rs.getString("ticket_description"));
                ticket.setAttachment(rs.getString("image_path"));
                ticket.setCreatedAt(rs.getTimestamp("created_at"));

                 
                ticket.setAssignTo(rs.getInt("assigned_user_id"));
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String assignToName = (firstName != null) ? firstName + (lastName != null ? " " + lastName : "") : "-";
                ticket.setAssignToName(assignToName);

                ticket.setResolveDate(rs.getDate("resolve_date"));
                ticket.setStatus(rs.getString("status"));

                tickets.add(ticket);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tickets;
    }
}