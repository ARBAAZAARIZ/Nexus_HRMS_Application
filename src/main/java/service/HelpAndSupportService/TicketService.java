package service.HelpAndSupportService;

import java.util.List;

import dao.HelpandSupportDao.TicketDAO;
import model.Ticket;

public class TicketService {

    private TicketDAO ticketDAO = new TicketDAO();

    public List<Ticket> getTicketsByUserId(int userId) {
        return ticketDAO.getTicketsByUserId(userId);
    }
    
   
   

    public boolean raiseTicket(Ticket ticket) {
        return ticketDAO.raiseTicket(ticket);
    }
}

