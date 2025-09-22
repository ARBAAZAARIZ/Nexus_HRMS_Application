package helper.reportHelper;

import java.util.Date;
import java.text.SimpleDateFormat;

public class BbEmployeeReportHelper implements BbReportData {

    private int userId;
    private String name;
    private String email;
    private String department;
    private String contactNumber;
    private Date dateOfJoining;   
    private String status;
    private String profilePicture;

	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    public BbEmployeeReportHelper(int userId, String name, String email, String department, String contactNumber,
			Date dateOfJoining, String status, String profilePicture) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.department = department;
		this.contactNumber = contactNumber;
		this.dateOfJoining = dateOfJoining;
		this.status = status;
		this.profilePicture = profilePicture;
	}

	public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public Date getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(Date dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}


    @Override
	public String toString() {
		return "BbEmployeeReportHelper [userId=" + userId + ", name=" + name + ", email=" + email + ", department="
				+ department + ", contactNumber=" + contactNumber + ", dateOfJoining=" + dateOfJoining + ", status="
				+ status + ", profilePicture=" + profilePicture + "]";
	}
    @Override
    public String[] getRowData() {
        return new String[]{
                String.valueOf(userId),
                name,
                email,
                department,
                contactNumber,
                (dateOfJoining != null ? sdf.format(dateOfJoining) : ""),
                status,
                profilePicture != null ? profilePicture : ""
        };
    }
}
