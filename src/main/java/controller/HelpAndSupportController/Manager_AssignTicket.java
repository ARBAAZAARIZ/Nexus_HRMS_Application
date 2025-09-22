package controller.HelpAndSupportController;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import model.Ticket;
import service.HelpAndSupportService.M_AssignedTicketService;

import java.io.IOException;
import java.util.List;

@WebServlet("/Manager_AssignTicket")
public class Manager_AssignTicket extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private M_AssignedTicketService service;

    @Override
    public void init() throws ServletException {
        super.init();
        service = new M_AssignedTicketService();
    }

    // Not used for now, could be used to show assign form
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	List<Ticket> tickets = service.getAllTickets();
        request.setAttribute("tickets", tickets);

        request.getRequestDispatcher("/WEB-INF/views/helpAndSupport/ManagerAssignedTicket.jsp")
               .forward(request, response);
    }
    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int ticketId = Integer.parseInt(request.getParameter("ticketId"));
            int staffUserId = Integer.parseInt(request.getParameter("staffUserId"));

            boolean assigned = service.assignTicket(ticketId, staffUserId);

            if (assigned) {
                request.getSession().setAttribute("successMsg", "Ticket assigned successfully!");
            } else {
                request.getSession().setAttribute("errorMsg", "Failed to assign ticket!");
            }

        } catch (Exception e) {
            e.printStackTrace();
            request.getSession().setAttribute("errorMsg", "Invalid input data!");
        }

        // Redirect back to the manager ticket list page
        response.sendRedirect(request.getContextPath() + "/Manager_AssignTicket");
        }
}
