package model;

import java.sql.Date;
import java.sql.Timestamp;

public class TimeSheet {
    private int time_sheet_id;
    private int user_id;
    private String username; 
    private Date date;
    private double working_hours;
    private String status;
    private Timestamp approved_at;

    
    public int getTime_sheet_id() {
        return time_sheet_id;
    }

    public void setTime_sheet_id(int time_sheet_id) {
        this.time_sheet_id = time_sheet_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getWorking_hours() {
        return working_hours;
    }

    public void setWorking_hours(double working_hours) {
        this.working_hours = working_hours;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getApproved_at() {
        return approved_at;
    }

    public void setApproved_at(Timestamp approved_at) {
        this.approved_at = approved_at;
    }
}
