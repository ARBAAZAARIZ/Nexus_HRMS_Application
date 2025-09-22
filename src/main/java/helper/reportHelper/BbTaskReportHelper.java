package helper.reportHelper;

public class BbTaskReportHelper implements BbReportData
{
	 private int taskId;
	 private String taskName;
	 private String projectName;
	 private String dueDate;
	 private String priority;
	 private String status;
	
	 public BbTaskReportHelper(int taskId, String taskName, String projectName, String dueDate, String priority,
			String status) {
		super();
		this.taskId = taskId;
		this.taskName = taskName;
		this.projectName = projectName;
		this.dueDate = dueDate;
		this.priority = priority;
		this.status = status;
	 }

	 @Override
	public String toString() {
		return "BbTaskReportHelper [taskId=" + taskId + ", taskName=" + taskName + ", projectName=" + projectName
				+ ", dueDate=" + dueDate + ", priority=" + priority + ", status=" + status + "]";
	}

	 public int getTaskId() {
		 return taskId;
	 }

	 public void setTaskId(int taskId) {
		 this.taskId = taskId;
	 }

	 public String getTaskName() {
		 return taskName;
	 }

	 public void setTaskName(String taskName) {
		 this.taskName = taskName;
	 }

	 public String getProjectName() {
		 return projectName;
	 }

	 public void setProjectName(String projectName) {
		 this.projectName = projectName;
	 }

	 public String getDueDate() {
		 return dueDate;
	 }

	 public void setDueDate(String dueDate) {
		 this.dueDate = dueDate;
	 }

	 public String getPriority() {
		 return priority;
	 }

	 public void setPriority(String priority) {
		 this.priority = priority;
	 }

	 public String getStatus() {
		 return status;
	 }

	 public void setStatus(String status) {
		 this.status = status;
	 }
	 
	 @Override
	    public String[] getRowData() 
	 {
	        return new String[]{String.valueOf(taskId), taskName, projectName, dueDate, priority, status};
	 }

}
