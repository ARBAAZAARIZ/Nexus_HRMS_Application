package service.leaveservice;

import java.time.LocalDate;
import java.util.*;

import dao.leavesdao.HUserDAO;
import dao.leavesdao.LeaveRequestDAO;
import dao.leavesdao.MasterLeavesDAO;
import helper.leavehelper.LeaveBalanceHelper;
import helper.leavehelper.LeaveRequestHelper;
import model.LeaveRequests;

public class LeaveRequestService {
	private LeaveRequestDAO leaveRequestDAO = new LeaveRequestDAO();
	private HUserDAO userDAO = new HUserDAO();
	private MasterLeavesDAO leavesDAO = new MasterLeavesDAO();

	public List<LeaveRequestHelper> getPendingLeaveRequestDetailsByDepartment(int departmentId) {
		List<LeaveRequestHelper> helperList = new ArrayList<>();
		List<LeaveRequests> requests = leaveRequestDAO.getPendingLeaveRequestsByDepartment(departmentId);
		for (LeaveRequests req : requests) {
			String leaveTypeName = leavesDAO.getLeaveTypeNameById(req.getLeaveTypeId());
			String employeeFirstName = userDAO.getFirstNameByUserId(req.getUserId());
			LeaveRequestHelper helper = new LeaveRequestHelper(req.getLeaveRequestId(), leaveTypeName,
					employeeFirstName, req.getApprovedBy(), req.getStartDate(), req.getEndDate(), req.getReason(),
					req.getNumberOfDays(), req.getStatus());
			helperList.add(helper);
		}
		return helperList;
	}

	public boolean approveOrRejectLeave(int requestId, String status, String managerName) {
		return leaveRequestDAO.updateLeaveRequestStatus(requestId, status, managerName);
	}
	
	public List<LeaveRequests> getPendingLeaveRequestsByUser(int userId) {
        return leaveRequestDAO.getLeaveRequestsByUser(userId);
    }

	public boolean applyLeaveWithValidation(LeaveRequests lr) {
	    LeaveRequestDAO dao = new LeaveRequestDAO();

	    // Step 1: Fetch holidays between dates
	    Set<LocalDate> holidays = dao.getHolidaysBetween(lr.getStartDate(), lr.getEndDate());

	    // Step 2: Calculate effective leave days excluding holidays and weekends
	    int effectiveLeaveDays = calculateWorkingDays(lr.getStartDate().toLocalDate(), lr.getEndDate().toLocalDate(), holidays);
	    if (effectiveLeaveDays <= 0) {
	        System.out.println("No working days to apply leave.");
	        return false;
	    }
	    lr.setNumberOfDays(effectiveLeaveDays);

	    // Step 3: Fetch leave balance for user and leave type
	    LeaveBalanceHelper leaveBalance = dao.getLeaveBalanceForUserAndType(lr.getUserId(), lr.getLeaveTypeId());
	    if (leaveBalance == null) {
	        System.out.println("No leave balance found for user and type.");
	        return false;
	    }

	    // Step 4: Check if used + requested <= total
	    int totalLeaves = leaveBalance.getTotalLeaves();
	    int usedLeaves = leaveBalance.getUsedLeaves();

	    if (usedLeaves + effectiveLeaveDays > totalLeaves) {
	        System.out.println("Insufficient leave balance.");
	        return false;
	    }

	    // Step 5: Insert leave request
	    return dao.insertLeaveRequest(lr);
	}

    
    public List<LeaveRequestHelper> getLeaveRequestsByUser(int userId) {
        return leaveRequestDAO.getLeaveRequestsWithLeaveTypeName(userId);
    }
    
    public boolean approveLeave(int leaveRequestId, int leaveDays, String managerName) {
        int leaveBalanceId = leaveRequestDAO.getLeaveBalanceIdByLeaveRequestId(leaveRequestId);
        int usedLeaves = leaveRequestDAO.getUsedLeaves(leaveBalanceId);
        int newUsedLeaves = usedLeaves + leaveDays;

        boolean usedLeavesUpdated = leaveRequestDAO.updateUsedLeaves(leaveBalanceId, newUsedLeaves);
        boolean statusUpdated = false;
        if (usedLeavesUpdated) {
            statusUpdated = leaveRequestDAO.updateLeaveRequestStatus(leaveRequestId, "Approved", managerName);
        }
        return usedLeavesUpdated && statusUpdated;
    }

    public boolean rejectLeave(int leaveRequestId, String managerName) {
        
        return leaveRequestDAO.updateLeaveRequestStatus(leaveRequestId, "Rejected", managerName);
    }

    
    public boolean applyLeave(LeaveRequests leaveRequest) {
        int remainingLeaves = leaveRequestDAO.getRemainingLeaves(leaveRequest.getUserId(), leaveRequest.getLeaveTypeId());
        if (remainingLeaves < leaveRequest.getNumberOfDays()) {
           
            return false;
        }
        
        
        return leaveRequestDAO.insertLeaveRequest(leaveRequest);
    }
    
    private int calculateWorkingDays(LocalDate start, LocalDate end, Set<LocalDate> holidays) {
        int days = 0;
        for (LocalDate date = start; !date.isAfter(end); date = date.plusDays(1)) {
            
            if (!holidays.contains(date)) {
                days++;
            }
        }
        return days;
    }
    
 
    public List<LeaveRequestHelper> getNonPendingLeaveRequestsByDepartment(int departmentId) {
        return leaveRequestDAO.getNonPendingLeaveRequestsByDepartment(departmentId);
    }


}
