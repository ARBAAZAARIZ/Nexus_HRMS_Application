package model;

import java.sql.Timestamp;

public class Designations {

	public Designations() {
		// TODO Auto-generated constructor stub
	}
	
	 private int designationId;
	    private String designationName;
	    private int departmentId;
	    private int numberOfEmployee;
	    private String status;
	    private String createdBy;
	    private String modifiedBy;
	    private Timestamp createdAt;
	    private Timestamp modifiedAt;
		public Designations(int designationId, String designationName, int departmentId, int numberOfEmployee,
				String status, String createdBy, String modifiedBy, Timestamp createdAt, Timestamp modifiedAt) {
			super();
			this.designationId = designationId;
			this.designationName = designationName;
			this.departmentId = departmentId;
			this.numberOfEmployee = numberOfEmployee;
			this.status = status;
			this.createdBy = createdBy;
			this.modifiedBy = modifiedBy;
			this.createdAt = createdAt;
			this.modifiedAt = modifiedAt;
		}
		public int getDesignationId() {
			return designationId;
		}
		public void setDesignationId(int designationId) {
			this.designationId = designationId;
		}
		public String getDesignationName() {
			return designationName;
		}
		public void setDesignationName(String designationName) {
			this.designationName = designationName;
		}
		public int getDepartmentId() {
			return departmentId;
		}
		public void setDepartmentId(int departmentId) {
			this.departmentId = departmentId;
		}
		public int getNumberOfEmployee() {
			return numberOfEmployee;
		}
		public void setNumberOfEmployee(int numberOfEmployee) {
			this.numberOfEmployee = numberOfEmployee;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
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
		@Override
		public String toString() {
			return "Designation [designationId=" + designationId + ", designationName=" + designationName
					+ ", departmentId=" + departmentId + ", numberOfEmployee=" + numberOfEmployee + ", status=" + status
					+ ", createdBy=" + createdBy + ", modifiedBy=" + modifiedBy + ", createdAt=" + createdAt
					+ ", modifiedAt=" + modifiedAt + "]";
		}
	    
	    

}
