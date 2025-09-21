package model;

import java.sql.Timestamp;

public class Departments {

	public Departments() {
		// TODO Auto-generated constructor stub
	}
	
	 private int departmentId;
	    private String departmentName;
	    private String status;
	    private int numberOfEmployee;
	    private Timestamp createdAt;
	    private Timestamp modifiedAt;
	    private String createdBy;
	    private String modifiedBy;
	    
		public Departments(int departmentId, String departmentName, String status, int numberOfEmployee,
				Timestamp createdAt, Timestamp modifiedAt, String createdBy, String modifiedBy) {
			super();
			this.departmentId = departmentId;
			this.departmentName = departmentName;
			this.status = status;
			this.numberOfEmployee = numberOfEmployee;
			this.createdAt = createdAt;
			this.modifiedAt = modifiedAt;
			this.createdBy = createdBy;
			this.modifiedBy = modifiedBy;
		}

		public int getDepartmentId() {
			return departmentId;
		}

		public void setDepartmentId(int departmentId) {
			this.departmentId = departmentId;
		}

		public String getDepartmentName() {
			return departmentName;
		}

		public void setDepartmentName(String departmentName) {
			this.departmentName = departmentName;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public int getNumberOfEmployee() {
			return numberOfEmployee;
		}

		public void setNumberOfEmployee(int numberOfEmployee) {
			this.numberOfEmployee = numberOfEmployee;
		}

		public Timestamp getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(Timestamp createdAt) {
			this.createdAt = createdAt;
		}

		public Timestamp getModifiedAt() {
			return modifiedAt;
		}

		public void setModifiedAt(Timestamp modifiedAt) {
			this.modifiedAt = modifiedAt;
		}

		public String getCreatedBy() {
			return createdBy;
		}

		public void setCreatedBy(String createdBy) {
			this.createdBy = createdBy;
		}

		public String getModifiedBy() {
			return modifiedBy;
		}

		public void setModifiedBy(String modifiedBy) {
			this.modifiedBy = modifiedBy;
		}

		@Override
		public String toString() {
			return "Departments [departmentId=" + departmentId + ", departmentName=" + departmentName + ", status="
					+ status + ", numberOfEmployee=" + numberOfEmployee + ", createdAt=" + createdAt + ", modifiedAt="
					+ modifiedAt + ", createdBy=" + createdBy + ", modifiedBy=" + modifiedBy + "]";
		}
		
		
	    
	    

}
