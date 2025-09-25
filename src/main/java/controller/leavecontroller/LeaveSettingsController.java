package controller.leavecontroller;

import model.MasterLeaves;
import service.leaveservice.MasterLeavesService;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/LeaveSettingsServlet")
public class LeaveSettingsController extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MasterLeavesService service = new MasterLeavesService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<MasterLeaves> leaveTypes = service.getAllLeaveTypes();
        req.setAttribute("leaveTypes", leaveTypes);
        req.getRequestDispatcher("WEB-INF/views/leave_views/leaveSettings.jsp").forward(req, resp);
    }

    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int leaveTypeId = Integer.parseInt(req.getParameter("leaveTypeId"));
        String newStatus = req.getParameter("status"); // "ACTIVE" or "INACTIVE"

        boolean success = service.changeLeaveTypeStatus(leaveTypeId, newStatus);

        req.getSession().setAttribute("msg", success ? "Status updated successfully." : "Failed to update status.");
        resp.sendRedirect("LeaveSettingsServlet");
    }
}
