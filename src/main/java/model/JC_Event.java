package model;

import java.util.Date;

public class JC_Event 
{
	
	private int id;
    private String title;
    private Date date;
    private String color;
	public JC_Event() {
//		super();
	}
	public JC_Event(int id, String title, Date date, String color) {
		super();
		this.id = id;
		this.title = title;
		this.date = date;
		this.color = color;
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	
    
    

}
