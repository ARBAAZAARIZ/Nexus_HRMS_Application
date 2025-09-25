package service.eventService;

import java.sql.SQLException;
import java.util.List;
import dao.eventDao.*;



import model.JC_Events;

public class JC_EventsService {

	private JC_EventsDAO eventDAO;
	
	public JC_EventsService() {
        this.eventDAO = new JC_EventsDAO();
    }

    
    public void addEvent(JC_Events event) throws SQLException {
        eventDAO.insert(event);
    }

  
    public List<JC_Events> getAllEvents() throws SQLException {
        return eventDAO.getAll();
    }

    
    public void deleteEvent(int id) throws SQLException {
        eventDAO.delete(id);
    }

    
    public void updateEvent(JC_Events event) throws SQLException {
        eventDAO.update(event);
    }

    
    public JC_Events getEventById(int id) throws SQLException {
        return eventDAO.getById(id);
    }
    
    public List<JC_Events> getAllEventsForCalendar() throws SQLException {
        return eventDAO.getAllWithEventType();
    }

    public void updateStatus(int id, String status) throws SQLException {
        eventDAO.updateStatus(id, status);
    }

}
