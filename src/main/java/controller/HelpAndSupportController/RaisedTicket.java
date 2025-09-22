package controller.HelpAndSupportController;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Ticket;
import service.HelpAndSupportService.TicketService;

import java.io.IOException;

import helper.employeeHelper.UserDetails;

/**
 * Servlet implementation class RaisedTicket
 */
@WebServlet("/RaisedTicket")
public class RaisedTicket extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RaisedTicket() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String action = request.getParameter("action");

	        if ("view".equalsIgnoreCase(action)) {
	            // Forward to JSP form for raising ticket
	            request.getRequestDispatcher("/WEB-INF/views/helpAndSupport/RaisedTicket.jsp")
	                   .forward(request, response);
	        } else {
	            response.getWriter().append("Invalid action or no action provided.");
	        }
	    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String title = request.getParameter("ticket_title");
        String description = request.getParameter("ticket_description");
        String attachment = request.getParameter("attachment");

        System.out.println("Ticket Title: " + title);
        System.out.println("Description: " + description);
        System.out.println("Attachment: " + attachment);
        
        UserDetails user=(UserDetails)request.getSession().getAttribute("employee");
        
        

        int userId = user.getUserId(); 
        request.getSession().setAttribute("userId", userId);

        Ticket ticket = new Ticket();
        ticket.setUserId(userId);
        ticket.setTitle(title);
        ticket.setDescription(description);
        ticket.setAttachment(attachment);
        ticket.setStatus("Raised");

        TicketService service = new TicketService();
        boolean success = service.raiseTicket(ticket);

        if (success) {
            
            response.sendRedirect(request.getContextPath() + "/MyTickets");
        } else {
            response.getWriter().println("Error raising ticket.");
        }
    }
}