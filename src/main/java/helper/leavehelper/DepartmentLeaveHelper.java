package helper.leavehelper;

public class DepartmentLeaveHelper {
	private int departmentLeaveId;
	private String departmentName;
	private String leaveTypeName;
	private int leaveCount;
	private String status;

	public DepartmentLeaveHelper() {
	}

	public DepartmentLeaveHelper(int departmentLeaveId, String departmentName, String leaveTypeName, int leaveCount,
			String status) {
		this.departmentLeaveId = departmentLeaveId;
		this.departmentName = departmentName;
		this.leaveTypeName = leaveTypeName;
		this.leaveCount = leaveCount;
		this.status = status;
	}

	public int getDepartmentLeaveId() {
		return departmentLeaveId;
	}

	public void setDepartmentLeaveId(int departmentLeaveId) {
		this.departmentLeaveId = departmentLeaveId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getLeaveTypeName() {
		return leaveTypeName;
	}

	public void setLeaveTypeName(String leaveTypeName) {
		this.leaveTypeName = leaveTypeName;
	}

	public int getLeaveCount() {
		return leaveCount;
	}

	public void setLeaveCount(int leaveCount) {
		this.leaveCount = leaveCount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
