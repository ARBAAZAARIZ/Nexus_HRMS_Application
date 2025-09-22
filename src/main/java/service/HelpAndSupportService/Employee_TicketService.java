package service.HelpAndSupportService;

import java.util.List;

import dao.HelpandSupportDao.Employee_TicketDAO;
import model.Ticket;

public class Employee_TicketService {

	private Employee_TicketDAO dao;

	public Employee_TicketService() {
		dao = new Employee_TicketDAO();
	}

	public List<Ticket> getAssignedTickets(int employeeId) {
		return dao.getAssignedTickets(employeeId);
	}

	public boolean addSolutionAndReply(int ticketId, int employeeId, String solution, String replyMessage) {
	    return dao.addSolutionAndReply(ticketId, employeeId, solution, replyMessage);
	}


	public boolean closeTicket(int ticketId) {
		return dao.closeTicket(ticketId);
	}
}