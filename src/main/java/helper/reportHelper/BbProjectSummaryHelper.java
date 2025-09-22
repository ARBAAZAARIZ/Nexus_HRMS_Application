package helper.reportHelper;

public class BbProjectSummaryHelper 
{
	 private int total;
	 private int completed;
	 private int onhold;
	 private int overdue;
	 
	 public BbProjectSummaryHelper(int total, int completed, int onhold, int overdue) {
		//super();
		this.total = total;
		this.completed = completed;
		this.onhold = onhold;
		this.overdue = overdue;
	 }

	 public BbProjectSummaryHelper() {
		//super();
	 }

	 public int getTotal() {
		 return total;
	 }

	 public void setTotal(int total) {
		 this.total = total;
	 }

	 public int getCompleted() {
		 return completed;
	 }

	 public void setCompleted(int completed) {
		 this.completed = completed;
	 }

	 public int getOnhold() {
		 return onhold;
	 }

	 public void setOnhold(int onhold) {
		 this.onhold = onhold;
	 }

	 public int getOverdue() {
		 return overdue;
	 }

	 public void setOverdue(int overdue) {
		 this.overdue = overdue;
	 }

	 @Override
	 public String toString() {
		return "BbProjectSummaryHelper [total=" + total + ", completed=" + completed + ", onhold=" + onhold
				+ ", overdue=" + overdue + "]";
	 }
}
