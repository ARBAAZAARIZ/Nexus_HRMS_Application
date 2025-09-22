package service.HelpAndSupportService;

import dao.HelpandSupportDao.M_AssignedDAO;
import model.Ticket;
import java.util.List;

public class M_AssignedTicketService {

    private M_AssignedDAO assignedDAO;

    public M_AssignedTicketService() {
        this.assignedDAO = new M_AssignedDAO();  // initialize DAO
    }

    // Assign ticket to staff
    public boolean assignTicket(int ticketId, int staffUserId) {
        return assignedDAO.assignTicket(ticketId, staffUserId);
    }

    // Close ticket (for staff)
 

    // Fetch single ticket by ID
    public Ticket getTicketById(int ticketId) {
        return assignedDAO.getTicketById(ticketId);
    }

    // Fetch all tickets (for manager listing)
    public List<Ticket> getAllTickets() {
        return assignedDAO.getAllTickets();
    }
}
