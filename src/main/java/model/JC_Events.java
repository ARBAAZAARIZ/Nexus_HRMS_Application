package model;

import java.sql.Date;
import java.sql.Timestamp;

public class JC_Events {
	
	private int id;
    private String title;
    private Date eventDate;
    private String status;
    private Timestamp createdAt;
    private Timestamp modifiedAt;
    private String createdBy;
    private String modifiedBy;
    private int eventTypeId;   
    private String eventTypeName;
    private String color;
    private String date;
    private String start;
    
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public JC_Events() {
//		super();
	}
	public JC_Events(int id, String title, Date eventDate, String status, Timestamp createdAt, Timestamp modifiedAt,
			String createdBy, String modifiedBy, int eventTypeId, String eventTypeName) {
//		super();
		this.id = id;
		this.title = title;
		this.eventDate = eventDate;
		this.status = status;
		this.createdAt = createdAt;
		this.modifiedAt = modifiedAt;
		this.createdBy = createdBy;
		this.modifiedBy = modifiedBy;
		this.eventTypeId = eventTypeId;
		this.eventTypeName = eventTypeName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getEventDate() {
		return eventDate;
	}
	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	public Timestamp getModifiedAt() {
		return modifiedAt;
	}
	public void setModifiedAt(Timestamp modifiedAt) {
		this.modifiedAt = modifiedAt;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public int getEventTypeId() {
		return eventTypeId;
	}
	public void setEventTypeId(int eventTypeId) {
		this.eventTypeId = eventTypeId;
	}
	public String getEventTypeName() {
		return eventTypeName;
	}
	public void setEventTypeName(String eventTypeName) {
		this.eventTypeName = eventTypeName;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	} 
		
    
    
    
    
    

}


