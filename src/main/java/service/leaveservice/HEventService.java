package service.leaveservice;

import model.Event;
import model.EventType;

import java.util.List;

import dao.leavesdao.HEventDAO;
import dao.leavesdao.HEventTypeDAO;

public class HEventService {
	private HEventTypeDAO eventTypeDAO = new HEventTypeDAO();
	private HEventDAO eventDAO = new HEventDAO();

	public List<Event> getHolidays() {
		EventType holidayType = eventTypeDAO.getEventTypeByName("Holiday");
		if (holidayType == null)
			return List.of();
		return eventDAO.getActiveEventsByEventType(holidayType.getEventTypeId());
	}
}
