package model;

import java.sql.Date;

public class JTermination {
    private int termination_id;
    private String termination_type;
    private Date notice_date;
    private Date resign_date;
    private String reason;
    private String status;
    private int user_id;
    private String user_name; // For displaying employee name in JSP

    public int getTermination_id() {
        return termination_id;
    }
    public void setTermination_id(int termination_id) {
        this.termination_id = termination_id;
    }

    public String getTermination_type() {
        return termination_type;
    }
    public void setTermination_type(String termination_type) {
        this.termination_type = termination_type;
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

    public String getUser_name() {
        return user_name;
    }
    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
}
