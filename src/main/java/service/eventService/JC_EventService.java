package service.eventService;

import java.util.List;

import dao.eventDao.*;

import model.JC_Event;

public class JC_EventService {
	
	private JC_EventDAO eventDAO = new JC_EventDAO();

    public List<JC_Event> fetchAllEvents() {
        return eventDAO.getAllEvents();
    }

}
