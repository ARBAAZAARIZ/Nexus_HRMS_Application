package controller.leavecontroller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import dao.leavesdao.HEventDAO;
import helper.employeeHelper.UserDetails;
import helper.leavehelper.LeaveBalanceHelper;
import helper.leavehelper.LeaveRequestHelper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.LeaveRequests;
import model.MasterLeaves;
import service.leaveservice.LeaveBalanceService;
import service.leaveservice.LeaveRequestService;
import service.leaveservice.MasterLeavesService;

@WebServlet("/ApplyLeaveServlet")
public class ApplyLeaveServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LeaveBalanceService leaveBalanceService = new LeaveBalanceService();
    private LeaveRequestService leaveRequestService = new LeaveRequestService();
    private HEventDAO eventDAO = new HEventDAO();
    private MasterLeavesService masterLeavesService = new MasterLeavesService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	HttpSession session = req.getSession(false);
        if (session == null) {
            resp.sendRedirect("login.jsp");
            return;
        }

        Object userIdObj = session.getAttribute("userId");
        Object departmentIdObj = session.getAttribute("departmentId");

        if (userIdObj == null || departmentIdObj == null) {
            resp.sendRedirect("login.jsp");
            return;
        }

        int userId = (Integer) userIdObj;
        int departmentId = (Integer) departmentIdObj;
        
        System.out.println(userId+" "+departmentId);

        List<LeaveBalanceHelper> leaveBalances = leaveBalanceService.getLeaveBalancesByUser(userId);
        req.setAttribute("leaveBalances", leaveBalances);
        
        System.out.println("leaveBalances size in servlet: " + (leaveBalances == null ? "null" : leaveBalances.size()));

        List<MasterLeaves> leaveTypes = masterLeavesService.getLeaveTypesByDepartment(departmentId);
        req.setAttribute("leaveTypes", leaveTypes);


        List<Date> holidays = eventDAO.getHolidays();
        req.setAttribute("holidays", holidays);

        List<LeaveRequestHelper> leaveRequests = leaveRequestService.getLeaveRequestsByUser(userId);
        req.setAttribute("leaveRequests", leaveRequests);

        req.getRequestDispatcher("WEB-INF/views/leave_views/applyLeave.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("userId") == null) {
            resp.sendRedirect("login.jsp");
            return;
        }
        int userId = (Integer) session.getAttribute("userId");

        int leaveTypeId = Integer.parseInt(req.getParameter("leaveTypeId"));
        Date startDate = Date.valueOf(req.getParameter("startDate"));
        Date endDate = Date.valueOf(req.getParameter("endDate"));
        String reason = req.getParameter("reason");

        List<Date> holidays = eventDAO.getHolidays();

        int numberOfDays = 0;
        LocalDate currDate = startDate.toLocalDate();
        LocalDate lastDate = endDate.toLocalDate();
        while (!currDate.isAfter(lastDate)) {
            Date d = Date.valueOf(currDate);
            if (!holidays.contains(d)) {
                numberOfDays++;
            }
            currDate = currDate.plusDays(1);
        }

        if (numberOfDays == 0) {
            req.setAttribute("message", "Selected dates fall on holidays, please select other dates.");
            doGet(req, resp);
            return;
        }

        LeaveRequests leaveRequest = new LeaveRequests();
        leaveRequest.setLeaveTypeId(leaveTypeId);
        leaveRequest.setStartDate(startDate);
        leaveRequest.setEndDate(endDate);
        leaveRequest.setNumberOfDays(numberOfDays);
        leaveRequest.setReason(reason);
        leaveRequest.setUserId(userId);
        leaveRequest.setStatus("Pending");
        UserDetails employee = (UserDetails) session.getAttribute("employee");
        String createdBy = (employee != null) ? employee.getFirstName() : "Unknown";
        leaveRequest.setCreatedBy(createdBy);

        boolean inserted = leaveRequestService.applyLeaveWithValidation(leaveRequest);
        if (inserted) {
            session.setAttribute("msg", "Leave applied successfully.");
            resp.sendRedirect("ApplyLeaveServlet");  
        } else {
            req.setAttribute("leaveErrorMsg", "Insufficient leave balance or invalid days.");
            doGet(req, resp); 
             
            return;
        }

    }
}
