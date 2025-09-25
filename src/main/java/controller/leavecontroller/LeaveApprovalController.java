package controller.leavecontroller;

import java.io.IOException;
import java.util.List;

import helper.leavehelper.LeaveRequestHelper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.leaveservice.LeaveRequestService;

@WebServlet("/LeaveApprovalServlet")
public class LeaveApprovalController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LeaveRequestService service = new LeaveRequestService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer departmentId = (Integer) req.getSession().getAttribute("departmentId");
		if (departmentId == null) {
			resp.sendRedirect("login.jsp");  
			return;
		}
		List<LeaveRequestHelper> leaveRequests = service.getPendingLeaveRequestDetailsByDepartment(departmentId);
		req.setAttribute("leaveRequests", leaveRequests);
		req.getRequestDispatcher("WEB-INF/views/leave_views/leaveApproval.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String requestIdStr = req.getParameter("requestId");
		String leaveDaysStr = req.getParameter("leaveDays");
		String action = req.getParameter("action");
		String managerName = (String) req.getSession().getAttribute("managerName");

		if (requestIdStr == null || leaveDaysStr == null || action == null || managerName == null) {
			req.getSession().setAttribute("msg", "Missing required parameters.");
			resp.sendRedirect("LeaveApprovalServlet");
			return;
		}

		int requestId = Integer.parseInt(requestIdStr);
		int leaveDays = Integer.parseInt(leaveDaysStr);

		boolean success = false;
		if ("Approved".equalsIgnoreCase(action)) {
			success = service.approveLeave(requestId, leaveDays, managerName);
		} else if ("Rejected".equalsIgnoreCase(action)) {
			success = service.rejectLeave(requestId, managerName);
		}

		req.getSession().setAttribute("msg", success ? "Leave request updated." : "Failed to update leave status.");
		resp.sendRedirect("LeaveApprovalServlet");
	}

}
