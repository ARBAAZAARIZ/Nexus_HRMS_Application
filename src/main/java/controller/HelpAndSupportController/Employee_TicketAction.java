package controller.HelpAndSupportController;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import service.HelpAndSupportService.Employee_TicketService;

import java.io.IOException;

import helper.employeeHelper.UserDetails;

@WebServlet("/EmployeeTicketAction")
public class Employee_TicketAction extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private Employee_TicketService service;

    @Override
    public void init() throws ServletException {
        super.init();
        service = new Employee_TicketService();
    }

    // Show all assigned tickets
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    	HttpSession session = request.getSession(false);
    	
    	UserDetails user=(UserDetails) session.getAttribute("employee");
    	
    	 int employeeId = user.getUserId();
         request.setAttribute("tickets", service.getAssignedTickets(employeeId));
         System.out.println();

         request.getRequestDispatcher("/WEB-INF/views/helpAndSupport/Employee_Solution1.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int employeeId = 1; 

        try {
            int ticketId = Integer.parseInt(request.getParameter("ticketId"));
            String action = request.getParameter("action");

            String solution = request.getParameter("solution");
            String replyMessage = request.getParameter("reply_message");

            if ("addSolution".equals(action) || "closeTicket".equals(action)) {
                service.addSolutionAndReply(ticketId, employeeId, solution, replyMessage);

                if ("closeTicket".equals(action)) {
                    service.closeTicket(ticketId);
                }
            }

        } catch (Exception e) {
            e.printStackTrace(); 
        }

   
        response.sendRedirect(request.getContextPath() + "/EmployeeTicketAction");
    }
}
