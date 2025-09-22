package controller.HelpAndSupportController;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Ticket;
import service.HelpAndSupportService.TicketService;

import java.io.IOException;
import java.util.List;

import helper.employeeHelper.UserDetails;

/**
 * Servlet implementation class ViewTicketDetails
 */
@WebServlet("/ViewTicketDetails")
public class ViewTicketDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewTicketDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    private TicketService ticketService = new TicketService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String ticketIdParam = request.getParameter("ticketId");
        if (ticketIdParam == null) {
            response.getWriter().println("❌ Ticket ID missing!");
            return;
        }

        int ticketId = Integer.parseInt(ticketIdParam);

UserDetails user=(UserDetails)request.getSession().getAttribute("employee");
    	
    	
        Integer userId = user.getUserId();
        

        List<Ticket> tickets = ticketService.getTicketsByUserId(userId);
        Ticket selectedTicket = tickets.stream()
                .filter(t -> t.getTicketId() == ticketId)
                .findFirst()
                .orElse(null);

        if (selectedTicket == null) {
            response.getWriter().println("❌ Ticket not found!");
            return;
        }

        request.setAttribute("ticket", selectedTicket);
        request.getRequestDispatcher("/WEB-INF/views/helpAndSupport/ViewTicketDetails.jsp")
                .forward(request, response);
    }
}