package model;

import java.sql.Date;

public class Resignation {
    private int resignation_id;
    private int department_id;
    private Date notice_date;
    private Date resign_date;
    private String reason;
    private String status;
    private int user_id;
    private String first_name;
    private String last_name;
    private String department;

    public Resignation() {
    }

    public Resignation(int resignation_id, int department_id, Date notice_date, Date resign_date, String reason, String status, int user_id, String first_name, String last_name, String department) {
        this.resignation_id = resignation_id;
        this.department_id = department_id;
        this.notice_date = notice_date;
        this.resign_date = resign_date;
        this.reason = reason;
        this.status = status;
        this.user_id = user_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.department = department;
    }

    public int getResignation_id() {
        return resignation_id;
    }

    public void setResignation_id(int resignation_id) {
        this.resignation_id = resignation_id;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public Date getNotice_date() {
        return notice_date;
    }

    public void setNotice_date(Date notice_date) {
        this.notice_date = notice_date;
    }

    public Date getResign_date() {
        return resign_date;
    }

    public void setResign_date(Date resign_date) {
        this.resign_date = resign_date;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
