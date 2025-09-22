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

@WebServlet("/MyTickets")
public class MyTickets extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public MyTickets() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

     
    	UserDetails user=(UserDetails)request.getSession().getAttribute("employee");
    	
    	
        Integer userId = user.getUserId();

       

        // Fetch tickets for this employee
        TicketService ticketService = new TicketService();
        List<Ticket> tickets = ticketService.getTicketsByUserId(userId);

        request.setAttribute("tickets", tickets);
        request.getRequestDispatcher("/WEB-INF/views/helpAndSupport/MyTickets.jsp")
               .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
