package dao.HelpandSupportDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Ticket;
import util.DatabaseConnection;

public class Employee_TicketDAO {
	public List<Ticket> getAssignedTickets(int employeeId) {
	    List<Ticket> tickets = new ArrayList<>();

	    String sql = "SELECT t.ticket_id, t.ticket_title, t.ticket_description, t.image_path, t.created_at, t.status, "
	               + "r.solution, r.reply_message, u.first_name AS reply_by_name "
	               + "FROM tickets t "
	               + "LEFT JOIN ticket_replies r ON t.ticket_id = r.ticket_id "
	               + "AND r.reply_id = (SELECT MAX(reply_id) FROM ticket_replies WHERE ticket_id = t.ticket_id) "
	               + "LEFT JOIN users u ON r.reply_by = u.user_id "
	               + "WHERE t.assign_to = ? "
	               + "ORDER BY t.created_at DESC";

	    try (Connection conn = DatabaseConnection.getConnection();
	         PreparedStatement ps = conn.prepareStatement(sql)) {

	        ps.setInt(1, employeeId);

	        try (ResultSet rs = ps.executeQuery()) {
	            while (rs.next()) {
	                Ticket t = new Ticket();
	                t.setTicketId(rs.getInt("ticket_id"));
	                t.setTitle(rs.getString("ticket_title"));
	                t.setDescription(rs.getString("ticket_description"));
	                t.setAttachment(rs.getString("image_path"));
	                t.setCreatedAt(rs.getTimestamp("created_at"));
	                t.setStatus(rs.getString("status"));
	                t.setSolution(rs.getString("solution"));          // From ticket_replies
	                t.setReplyMessage(rs.getString("reply_message"));  // From ticket_replies
	                t.setAssignToName(rs.getString("reply_by_name"));  // Name of employee replying

	                tickets.add(t);
	            }
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return tickets;
	}

	public boolean closeTicket(int ticketId) {
		String sql = "UPDATE tickets SET status = 'Closed', resolve_date = NOW() WHERE ticket_id = ?";
		try (Connection conn = DatabaseConnection.getConnection(); 
				PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setInt(1, ticketId);
			return ps.executeUpdate() > 0;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean addSolutionAndReply(int ticketId, int replyBy, String solution, String replyMessage) {
	    String sql = "INSERT INTO ticket_replies(ticket_id, solution, reply_message, reply_by) "
	               + "VALUES (?, ?, ?, ?)";

	    try (Connection conn = DatabaseConnection.getConnection();
	         PreparedStatement ps = conn.prepareStatement(sql)) {

	        ps.setInt(1, ticketId);
	        ps.setString(2, solution);
	        ps.setString(3, replyMessage);
	        ps.setInt(4, replyBy); // logged-in employee

	        return ps.executeUpdate() > 0;

	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
	}
}