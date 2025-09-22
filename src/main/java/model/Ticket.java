package model;

import java.sql.Date;
import java.sql.Timestamp;

public class Ticket {
	 private int userId; 
    private int ticketId;
    private String title;
    private String description;
	private String attachment;
    private Timestamp createdAt;
    private int assignTo;
   private String assignToName; 
	private Date resolveDate;
    private String status;
    private String solution; 
    private String replyMessage;
    
   

    public Ticket() {
        super();
    }
    
   
    


    public Ticket(int ticketId, String title, String attachment, Timestamp createdAt,
                  int assignTo, Date resolveDate, String status) {
        this.ticketId = ticketId;
        this.title = title;
        this.attachment = attachment;
        this.createdAt = createdAt;
        this.assignTo = assignTo;
        this.resolveDate = resolveDate;
        this.status = status;
        
        }
        
    
    public String getReplyMessage() {
            return replyMessage;
        }

        public void setReplyMessage(String replyMessage) {
            this.replyMessage = replyMessage;
        
   
    }
    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }
    
    public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}


	public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public int getAssignTo() {
        return assignTo;
    }

    public void setAssignTo(int i) {
        this.assignTo = i;
    }
    
    public String getAssignToName() {
		return assignToName;
	}

	public void setAssignToName(String assignToName) {
		this.assignToName = assignToName;
	}


    public Date getResolveDate() {
        return resolveDate;
    }

    public void setResolveDate(Date resolveDate) {
        this.resolveDate = resolveDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }





	@Override
	public String toString() {
		return "Ticket [userId=" + userId + ", ticketId=" + ticketId + ", title=" + title + ", description="
				+ description + ", attachment=" + attachment + ", createdAt=" + createdAt + ", assignTo=" + assignTo
				+ ", assignToName=" + assignToName + ", resolveDate=" + resolveDate + ", status=" + status
				+ ", solution=" + solution + "]";
	}





	public void setRaisedBy(String raisedBy) {
		// TODO Auto-generated method stub
		
	}







   
}
