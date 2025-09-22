package helper.reportHelper;

import java.util.List;

public class BbProjectReportHelper implements BbReportData 
{
    private int projectId;
    private String projectName;
    private String leaderName;
    private String deadline;
    private String priority;
    private String status;
    private List<MemberDTO> members; 
    
    public static class MemberDTO 
    {
        private String name;
        private String profilePicture;

        public MemberDTO(String name, String profilePicture)
        {
            this.name = name;
            this.profilePicture = profilePicture;
        }

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getProfilePicture() {
			return profilePicture;
		}

		public void setProfilePicture(String profilePicture) {
			this.profilePicture = profilePicture;
		}      
    }

	public BbProjectReportHelper(int projectId, String projectName, String leaderName, String deadline, String priority,
			String status, List<MemberDTO> members) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.leaderName = leaderName;
		this.deadline = deadline;
		this.priority = priority;
		this.status = status;
		this.members = members;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getLeaderName() {
		return leaderName;
	}

	public void setLeaderName(String leaderName) {
		this.leaderName = leaderName;
	}

	public String getDeadline() {
		return deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
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

	public List<MemberDTO> getMembers() {
		return members;
	}

	public void setMembers(List<MemberDTO> members) {
		this.members = members;
	}

	@Override
	public String toString() {
		return "BbProjectReportHelper [projectId=" + projectId + ", projectName=" + projectName + ", leaderName="
				+ leaderName + ", deadline=" + deadline + ", priority=" + priority + ", status=" + status + ", members="
				+ members + "]";
	}
    
	@Override
	public String[] getRowData() {
	    // Build member names string for export (line by line)
	    StringBuilder membersStr = new StringBuilder();
	    if (members != null) {
	        for (MemberDTO m : members) {
	            if (membersStr.length() > 0) membersStr.append("\n"); // new line instead of comma
	            membersStr.append(m.getName());
	        }
	    }

	    return new String[] {
		        String.valueOf(projectId),
		        projectName != null ? projectName : "",
		        leaderName != null ? leaderName : "",
		        membersStr.toString(),
		        deadline != null ? deadline : "",
		        priority != null ? priority : "",
		        status != null ? status : "" 
		    };
		}

}
