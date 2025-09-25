package controller.eventController;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import dao.eventDao.JC_EventTypeDAO;
//import model.JC_Event;
//import com.events.dao.JC_EventTypeDAO;
import helper.employeeHelper.UserDetails;
import service.eventService.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.JC_Events;
import model.JC_EventType;

/**
 * Servlet implementation class EventServlets_1
 */
@WebServlet("/EventServlets_1")
public class EventServlets_1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private JC_EventsService eventService;
    private JC_EventTypeDAO eventTypeDAO = new JC_EventTypeDAO();


       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EventServlets_1() {
        super();
        // TODO Auto-generated constructor stub
        eventService = new JC_EventsService();
        eventTypeDAO = new JC_EventTypeDAO();


    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		String action = request.getParameter("action");
		System.out.println(action);
        if (action == null) action = "list";

        try {
            switch (action) {
//                                }
                case "delete": {
                    int id = Integer.parseInt(request.getParameter("id"));
                    eventService.deleteEvent(id);
                    response.sendRedirect("EventServlets_1?action=list");
                    break;
                }
                
                case "toggleStatus": {
                    int id = Integer.parseInt(request.getParameter("id"));
                    String currentStatus = request.getParameter("currentStatus");

                    String newStatus = "ACTIVE".equalsIgnoreCase(currentStatus) ? "INACTIVE" : "ACTIVE";

                    eventService.updateStatus(id, newStatus);

                    response.sendRedirect("EventServlets_1?action=list");
                    break;
                }

                
                default: {
                    List<JC_Events> listEvents = eventService.getAllEvents();
                    
                    List<JC_EventType> types = eventTypeDAO.getAll();
                    request.setAttribute("eventTypes", types);
                    request.setAttribute("listEvents", listEvents);
                    request.getRequestDispatcher("WEB-INF/views/eventViews/event-list.jsp").forward(request, response);
                    break;
                }
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
	    String action = request.getParameter("action");
//	    String action = request.getParameter("action");
		System.out.println(action);
        
		
		try {
	        if ("insert".equals(action)) {
	            String title = request.getParameter("eventTitle");
	            Date eventDate = Date.valueOf(request.getParameter("eventDate"));
	            int eventTypeId = Integer.parseInt(request.getParameter("eventType"));

	            JC_Events newEvent = new JC_Events();
	            newEvent.setTitle(title);
	            newEvent.setEventDate(eventDate);
	            newEvent.setEventTypeId(eventTypeId);
	            newEvent.setStatus("ACTIVE");

	            eventService.addEvent(newEvent);
	            response.sendRedirect("EventServlets_1?action=list");
	        } 
	        else if ("update".equals(action)) {
	            int idUpdate = Integer.parseInt(request.getParameter("eventId"));
	            String titleUpdate = request.getParameter("eventTitle");
	            String dateUpdateStr = request.getParameter("eventDate");
	            int typeUpdateId = Integer.parseInt(request.getParameter("eventType"));
	            String status = request.getParameter("status");

	            UserDetails user  = (UserDetails) request.getSession().getAttribute("employee");
	            String modifiedBy = user.getFirstName() + " " + user.getLastName();

	            JC_Events updateEvent = new JC_Events();
	            updateEvent.setId(idUpdate);
	            updateEvent.setTitle(titleUpdate);
	            updateEvent.setEventDate(Date.valueOf(dateUpdateStr));
	            updateEvent.setModifiedBy(modifiedBy);
	            updateEvent.setEventTypeId(typeUpdateId);
	            updateEvent.setStatus(status != null ? status : "ACTIVE");

	            eventService.updateEvent(updateEvent);
	            response.sendRedirect("EventServlets_1?action=list");
	        } 
	        else {
	            
	            doGet(request, response);
	        }
	        
	    } catch (Exception e) {
	        throw new ServletException(e);
	    }
	}

}
