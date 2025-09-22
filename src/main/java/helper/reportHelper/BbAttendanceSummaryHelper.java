package helper.reportHelper;

public class BbAttendanceSummaryHelper 
{
	private int totalEmployees;
    private int totalLeaves;
    private int totalHolidays;
    private int totalHalfdays;
	
    public BbAttendanceSummaryHelper(int totalEmployees, int totalLeaves, int totalHolidays, int totalHalfdays) {
		super();
		this.totalEmployees = totalEmployees;
		this.totalLeaves = totalLeaves;
		this.totalHolidays = totalHolidays;
		this.totalHalfdays = totalHalfdays;
	}

	public int getTotalEmployees() {
		return totalEmployees;
	}

	public void setTotalEmployees(int totalEmployees) {
		this.totalEmployees = totalEmployees;
	}

	public int getTotalLeaves() {
		return totalLeaves;
	}

	public void setTotalLeaves(int totalLeaves) {
		this.totalLeaves = totalLeaves;
	}

	public int getTotalHolidays() {
		return totalHolidays;
	}

	public void setTotalHolidays(int totalHolidays) {
		this.totalHolidays = totalHolidays;
	}

	public int getTotalHalfdays() {
		return totalHalfdays;
	}

	public void setTotalHalfdays(int totalHalfdays) {
		this.totalHalfdays = totalHalfdays;
	}
}
