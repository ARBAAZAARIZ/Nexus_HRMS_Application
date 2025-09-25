package model;

public class JC_EventType {
	private int id;
    private String name;
    private String color;
	public JC_EventType(int id, String name, String color) {
//		super();
		this.id = id;
		this.name = name;
		this.color = color;
	}
	public JC_EventType() {
//		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	
    
    

    

}
