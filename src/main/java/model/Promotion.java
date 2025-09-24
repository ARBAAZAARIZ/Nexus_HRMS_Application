package model;

public class Promotion {
    private int promotion_id;
    private String designation_from;
    private String designation_to;
    private String promotion_date; 
    private int user_id;
    //private String employee_name;
    //private String department_name;

    String first_name;
    String last_name;

    public Promotion() {
	
	}
    
    

	public Promotion(int promotion_id, String designation_from, String designation_to, String promotion_date,
			int user_id, String first_name, String last_name) {
		super();
		this.promotion_id = promotion_id;
		this.designation_from = designation_from;
		this.designation_to = designation_to;
		this.promotion_date = promotion_date;
		this.user_id = user_id;
		this.first_name = first_name;
		this.last_name = last_name;
	}



	public Promotion(int promotion_id, String designation_from, String designation_to,
			String promotion_date,int user_id) {
		this.promotion_id = promotion_id;
		this.designation_from = designation_from;
		this.designation_to = designation_to;
		this.promotion_date = promotion_date;
		this.user_id = user_id;
		//this.employee_name = employee_name;
		//this.department_name = department_name;
	}



	public int getPromotion_id() {
        return promotion_id;
    }

    public void setPromotion_id(int promotion_id) {
        this.promotion_id = promotion_id;
    }

    public String getDesignation_from() {
        return designation_from;
    }

    public void setDesignation_from(String designation_from) {
        this.designation_from = designation_from;
    }

    public String getDesignation_to() {
        return designation_to;
    }

    public void setDesignation_to(String designation_to) {
        this.designation_to = designation_to;
    }

    public String getPromotion_date() {
        return promotion_date;
    }

    public void setPromotion_date(String promotion_date) {
        this.promotion_date = promotion_date;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    
    
    
    

    



	public String getFirst_name() {
		return first_name;
	}



	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}



	public String getLast_name() {
		return last_name;
	}



	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}



	@Override
	public String toString() {
		return "Promotion [promotion_id=" + promotion_id + ", designation_from=" + designation_from
				+ ", designation_to=" + designation_to + ", promotion_date=" + promotion_date + ", user_id=" + user_id
				+  "]";
	}
    
    
}
