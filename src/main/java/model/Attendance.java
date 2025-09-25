package model;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

public class Attendance {
    
    private Time check_in;
    private Time lunch_out;
    private Time lunch_in;
    private Time check_out;   
    private Date date;
    private Double production_hours;
    private Double late_hour;
    private int user_id;
    private Double working_hours;
    private Double break_hours;
    public Attendance() {
        super();
    }

 
    public Attendance(Time check_in, Time lunch_out, Time lunch_in, Time check_out, Date date, Double production_hours,
			Double late_hour, int user_id, Double working_hours ,Double break_hours  ) {
		super();
		this.check_in = check_in;
		this.lunch_out = lunch_out;
		this.lunch_in = lunch_in;
		this.check_out = check_out;
		this.date = date;
		this.production_hours = production_hours;
		this.late_hour = late_hour;
		this.user_id = user_id;
		this.working_hours = working_hours;
		this.break_hours = break_hours ; 
	}


	public Double getWorking_hours() {
		return working_hours;
	}


	public void setWorking_hours(Double working_hours) {
		this.working_hours = working_hours;
	}

    public Double break_hours() {
    	 return break_hours ; 
    }
    public void setBreak_hours(Double break_hours){
    	 this.break_hours = break_hours ; 
    }
	public Time getCheck_in() {
        return check_in;
    }

    public void setCheck_in(Time check_in) {
        this.check_in = check_in;
    }

    public Time getLunch_out() {
        return lunch_out;
    }

    public void setLunch_out(Time lunch_out) {
        this.lunch_out = lunch_out;
    }

    public Time getLunch_in() {
        return lunch_in;
    }

    public void setLunch_in(Time lunch_in) {
        this.lunch_in = lunch_in;
    }

    public Time getCheck_out() {   
        return check_out;
    }

    public void setCheck_out(Time check_out) {  
        this.check_out = check_out;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getProduction_hours() {
        return production_hours;
    }

    public void setProduction_hours(Double timestamp) {
        this.production_hours = timestamp;
    }

    public Double getLate_hour() {
        return late_hour;
    }

    public void setLate_hour(Double late_hour) {
        this.late_hour = late_hour;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Attendance [check_in=" + check_in + ", lunch_out=" + lunch_out + ", lunch_in=" + lunch_in
                + ", check_out=" + check_out + ", date=" + date + ", production_hours=" + production_hours
                + ", late_hour=" + late_hour + ", user_id=" + user_id + "]";
    }
}
