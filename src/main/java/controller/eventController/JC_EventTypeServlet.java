package controller.eventController;

import java.io.IOException;
import java.sql.SQLException;

//import com.events.service.JC_EventTypeService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.JC_EventType;
import service.eventService.*;

/**
 * Servlet implementation class EventTypeServlet
 */
@WebServlet("/event-types")
public class JC_EventTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private JC_EventTypeService service = new JC_EventTypeService();

	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JC_EventTypeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		try {
            req.setAttribute("eventTypes", service.listEventTypes());
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
        req.getRequestDispatcher("WEB-INF/views/eventViews/addevent.jsp").forward(req, resp);
    }	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		 String action = req.getParameter("action");
	        try {
	            if ("add".equals(action)) {
	                JC_EventType e = new JC_EventType();
	                e.setName(req.getParameter("name"));
	                e.setColor(req.getParameter("color"));
	                service.addEventType(e);
	            } else if ("delete".equals(action)) {
	                int id = Integer.parseInt(req.getParameter("id"));
	                service.deleteEventType(id);
	            }
	        } catch (SQLException ex) {
	            throw new ServletException(ex);
	        }
	        resp.sendRedirect("event-types");

	}

}
