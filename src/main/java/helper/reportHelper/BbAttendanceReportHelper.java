package helper.reportHelper;

import java.util.Date;

public class BbAttendanceReportHelper implements BbReportData
{
	 private int attendanceId;
	 private String employeeName;
	 private String profilePicture;
	 private Date date;
	 private String checkIn;
	 private String checkOut;
	 private String lunchIn;
	 private String lunchOut;
	 private String status;
	 private int workingHours;
	 private int productionHours;
	 private int breakHour;
	
	 public BbAttendanceReportHelper(int attendanceId, String employeeName, String profilePicture, Date date,
			String checkIn, String checkOut, String lunchIn, String lunchOut, String status, int workingHours,
			int productionHours, int breakHour) {
		super();
		this.attendanceId = attendanceId;
		this.employeeName = employeeName;
		this.profilePicture = profilePicture;
		this.date = date;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.lunchIn = lunchIn;
		this.lunchOut = lunchOut;
		this.status = status;
		this.workingHours = workingHours;
		this.productionHours = productionHours;
		this.breakHour = breakHour;
	 }

	 public int getAttendanceId() {
		 return attendanceId;
	 }

	 public void setAttendanceId(int attendanceId) {
		 this.attendanceId = attendanceId;
	 }

	 public String getEmployeeName() {
		 return employeeName;
	 }

	 public void setEmployeeName(String employeeName) {
		 this.employeeName = employeeName;
	 }

	 public String getProfilePicture() {
		 return profilePicture;
	 }

	 public void setProfilePicture(String profilePicture) {
		 this.profilePicture = profilePicture;
	 }

	 public Date getDate() {
		 return date;
	 }

	 public void setDate(Date date) {
		 this.date = date;
	 }

	 public String getCheckIn() {
		 return checkIn;
	 }

	 public void setCheckIn(String checkIn) {
		 this.checkIn = checkIn;
	 }

	 public String getCheckOut() {
		 return checkOut;
	 }

	 public void setCheckOut(String checkOut) {
		 this.checkOut = checkOut;
	 }

	 public String getLunchIn() {
		 return lunchIn;
	 }

	 public void setLunchIn(String lunchIn) {
		 this.lunchIn = lunchIn;
	 }

	 public String getLunchOut() {
		 return lunchOut;
	 }

	 public void setLunchOut(String lunchOut) {
		 this.lunchOut = lunchOut;
	 }

	 public String getStatus() {
		 return status;
	 }

	 public void setStatus(String status) {
		 this.status = status;
	 }

	 public int getWorkingHours() {
		 return workingHours;
	 }

	 public void setWorkingHours(int workingHours) {
		 this.workingHours = workingHours;
	 }

	 public int getProductionHours() {
		 return productionHours;
	 }

	 public void setProductionHours(int productionHours) {
		 this.productionHours = productionHours;
	 }

	 public int getBreakHour() {
		 return breakHour;
	 }

	 public void setBreakHour(int breakHour) {
		 this.breakHour = breakHour;
	 }

	 @Override
	 public String toString() {
		return "BbAttendanceReportHelper [attendanceId=" + attendanceId + ", employeeName=" + employeeName
				+ ", profilePicture=" + profilePicture + ", date=" + date + ", checkIn=" + checkIn + ", checkOut="
				+ checkOut + ", lunchIn=" + lunchIn + ", lunchOut=" + lunchOut + ", status=" + status
				+ ", workingHours=" + workingHours + ", productionHours=" + productionHours + ", breakHour=" + breakHour
				+ "]";
	 }
	 
	 @Override
	 public String[] getRowData() {
	     return new String[] {
	         String.valueOf(attendanceId),
	         employeeName,
	         profilePicture,
	         String.valueOf(date),
	         checkIn,
	         checkOut,
	         lunchIn,
	         lunchOut,
	         status,
	         String.valueOf(workingHours),
	         String.valueOf(productionHours),
	         String.valueOf(breakHour)
	     };
	 }
}
