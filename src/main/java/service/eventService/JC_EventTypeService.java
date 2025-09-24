package service.eventService;

import java.sql.SQLException;
import java.util.List;

import dao.eventDao.*;

import model.JC_EventType;

public class JC_EventTypeService 
{
	
	private JC_EventTypeDAO dao = new JC_EventTypeDAO();

    public void addEventType(JC_EventType e) throws SQLException {
        dao.insert(e);
    }

    public List<JC_EventType> listEventTypes() throws SQLException {
        return dao.getAll();
    }

    public void deleteEventType(int id) throws SQLException {
        dao.delete(id);
    }

}
