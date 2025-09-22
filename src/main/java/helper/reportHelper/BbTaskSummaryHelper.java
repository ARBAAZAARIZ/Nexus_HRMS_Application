package helper.reportHelper;

public class BbTaskSummaryHelper 
{
	 private int total;
	 private int completed;
	 private int onhold;
	 private int overdue;
	 
	 public BbTaskSummaryHelper(int total, int completed, int onhold, int overdue) {
		//super();
		this.total = total;
		this.completed = completed;
		this.onhold = onhold;
		this.overdue = overdue;
	 }
	 
	 public BbTaskSummaryHelper() {
		//super();
	}

	 @Override
	public String toString() {
		return "BbTaskSummaryHelper [total=" + total + ", completed=" + completed + ", onhold=" + onhold + ", overdue="
				+ overdue + "]";
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
}
