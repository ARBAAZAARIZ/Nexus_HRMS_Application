package controller.leavecontroller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.leaveservice.LeaveRequestService;

import java.io.IOException;
import java.util.List;

import helper.leavehelper.LeaveRequestHelper;

/**
 * Servlet implementation class ManagerLeaveStatusServlet
 */
@WebServlet("/ManagerLeaveStatusServlet")
public class ManagerLeaveStatusServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LeaveRequestService leaveRequestService = new LeaveRequestService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("departmentId") == null) {
            resp.sendRedirect("login.jsp");
            return;
        }
        int departmentId = (Integer) session.getAttribute("departmentId");
        List<LeaveRequestHelper> leaveRequests = leaveRequestService.getNonPendingLeaveRequestsByDepartment(departmentId);
        req.setAttribute("leaveRequests", leaveRequests);
        req.getRequestDispatcher("WEB-INF/views/leave_views/manager_leave_status.jsp").forward(req, resp);
    }
}

