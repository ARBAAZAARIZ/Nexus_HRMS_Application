package service.HelpAndSupportService;

import dao.HelpandSupportDao.M_AssignedDAO;
import model.Ticket;
import java.util.List;

public class M_AssignedTicketService {

    private M_AssignedDAO assignedDAO;

    public M_AssignedTicketService() {
        this.assignedDAO = new M_AssignedDAO(); 
    }

   
    public boolean assignTicket(int ticketId, int staffUserId) {
        return assignedDAO.assignTicket(ticketId, staffUserId);
    }

     
 

 
    public Ticket getTicketById(int ticketId) {
        return assignedDAO.getTicketById(ticketId);
    }

    
    public List<Ticket> getAllTickets() {
        return assignedDAO.getAllTickets();
    }
}
