package controller.eventController;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

//import com.events.dao.JC_EventTypeDAO;
//import com.events.service.JC_EventsService;
//import com.events.service.JC_EventService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
import model.JC_Events;
import model.JC_EventType;
import model.JC_Event;
import dao.eventDao.*;
import helper.employeeHelper.UserDetails;
import service.eventService.*;



/**
 * Servlet implementation class JC_EventServlet
 */
@WebServlet("/JC_EventServlet")
public class JC_EventServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private JC_EventService eventService = new JC_EventService();
    private JC_EventTypeDAO eventTypeDAO = new JC_EventTypeDAO();
	private JC_EventsService eventService1;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JC_EventServlet() {
        super();
        // TODO Auto-generated constructor stub
        eventService1 = new JC_EventsService();
        eventTypeDAO = new JC_EventTypeDAO();



    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		 String action = request.getParameter("action");
	        if (action == null) action = "calendar";

	        try {
	            switch (action) {
	                case "new": {
	                    List<JC_EventType> types = eventTypeDAO.getAll();
	                    request.setAttribute("eventTypes", types);

	                    List<JC_Event> events = eventService.fetchAllEvents();
	                    request.setAttribute("events", events);

	                    request.getRequestDispatcher("WEB-INF/views/eventViews/pages/JC_Calendar.jsp").forward(request, response);
	                    
	                    break;
	                }
	                
	                case "view": {
	                    List<JC_EventType> types = eventTypeDAO.getAll();
	                    request.setAttribute("eventTypes", types);

	                    
	                    List<JC_Event> events = eventService.fetchAllEvents();
	                    request.setAttribute("events", events);

	                    request.getRequestDispatcher("WEB-INF/views/eventViews/pages/JC_Calendars.jsp").forward(request, response);
	                    
	                    break;

	                }
	               
	                case "calendar":
	                default: {
	                    List<JC_Event> events = eventService.fetchAllEvents();
	                    request.setAttribute("events", events);

	                    List<JC_EventType> types = eventTypeDAO.getAll();
	                    request.setAttribute("eventTypes", types);

	                    request.getRequestDispatcher("WEB-INF/views/eventViews/pages/JC_Calendar.jsp").forward(request, response);
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

        try {
            if ("insert".equals(action)) {
                 
                String title = request.getParameter("eventTitle");
                String dateStr = request.getParameter("eventDate");
                int typeId = Integer.parseInt(request.getParameter("eventType"));
//                HttpSession session=request.getSession();
                UserDetails user  = (UserDetails) request.getSession().getAttribute("employee");
               String createdBy=user.getFirstName() + " " + user.getLastName();
                JC_Events newEvent = new JC_Events();
                newEvent.setTitle(title);
                newEvent.setEventDate(Date.valueOf(dateStr));
                newEvent.setEventTypeId(typeId);
                newEvent.setCreatedBy(createdBy);
                eventService1.addEvent(newEvent);

                response.sendRedirect("JC_EventServlet?action=new");
            } else {
                doGet(request, response);
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }
	}

}
