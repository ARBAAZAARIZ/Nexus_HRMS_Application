package helper.dashboardHelper;

public class AdminDashboardMetrics {
    private int totalEmployees;
    private int activeEmployees;
    private int inactiveEmployees;
    private int activeDepartments;
    private int activeRoles;
    private int activeDesignations;
    private int activeTrainers;
    private int upcomingTrainings;
    private int completedTrainings;
    private int totalTrainings;
    
    public AdminDashboardMetrics() {
    	
    }
    
    
	public AdminDashboardMetrics(int totalEmployees, int activeEmployees, int inactiveEmployees, int activeDepartments,
			int activeRoles, int activeDesignations, int activeTrainers, int upcomingTrainings, int completedTrainings,
			int totalTrainings) {
		super();
		this.totalEmployees = totalEmployees;
		this.activeEmployees = activeEmployees;
		this.inactiveEmployees = inactiveEmployees;
		this.activeDepartments = activeDepartments;
		this.activeRoles = activeRoles;
		this.activeDesignations = activeDesignations;
		this.activeTrainers = activeTrainers;
		this.upcomingTrainings = upcomingTrainings;
		this.completedTrainings = completedTrainings;
		this.totalTrainings = totalTrainings;
	}
	public int getTotalEmployees() {
		return totalEmployees;
	}
	public void setTotalEmployees(int totalEmployees) {
		this.totalEmployees = totalEmployees;
	}
	public int getActiveEmployees() {
		return activeEmployees;
	}
	public void setActiveEmployees(int activeEmployees) {
		this.activeEmployees = activeEmployees;
	}
	public int getInactiveEmployees() {
		return inactiveEmployees;
	}
	public void setInactiveEmployees(int inactiveEmployees) {
		this.inactiveEmployees = inactiveEmployees;
	}
	public int getActiveDepartments() {
		return activeDepartments;
	}
	public void setActiveDepartments(int activeDepartments) {
		this.activeDepartments = activeDepartments;
	}
	public int getActiveRoles() {
		return activeRoles;
	}
	public void setActiveRoles(int activeRoles) {
		this.activeRoles = activeRoles;
	}
	public int getActiveDesignations() {
		return activeDesignations;
	}
	public void setActiveDesignations(int activeDesignations) {
		this.activeDesignations = activeDesignations;
	}
	public int getActiveTrainers() {
		return activeTrainers;
	}
	public void setActiveTrainers(int activeTrainers) {
		this.activeTrainers = activeTrainers;
	}
	public int getUpcomingTrainings() {
		return upcomingTrainings;
	}
	public void setUpcomingTrainings(int upcomingTrainings) {
		this.upcomingTrainings = upcomingTrainings;
	}
	public int getCompletedTrainings() {
		return completedTrainings;
	}
	public void setCompletedTrainings(int completedTrainings) {
		this.completedTrainings = completedTrainings;
	}
	public int getTotalTrainings() {
		return totalTrainings;
	}
	public void setTotalTrainings(int totalTrainings) {
		this.totalTrainings = totalTrainings;
	}
	@Override
	public String toString() {
		return "AdminDashboardMetrics [totalEmployees=" + totalEmployees + ", activeEmployees=" + activeEmployees
				+ ", inactiveEmployees=" + inactiveEmployees + ", activeDepartments=" + activeDepartments
				+ ", activeRoles=" + activeRoles + ", activeDesignations=" + activeDesignations + ", activeTrainers="
				+ activeTrainers + ", upcomingTrainings=" + upcomingTrainings + ", completedTrainings="
				+ completedTrainings + ", totalTrainings=" + totalTrainings + "]";
	}

    

    
    
    
}
