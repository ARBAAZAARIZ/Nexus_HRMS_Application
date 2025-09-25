package controller.leavecontroller;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import dao.leavesdao.MasterLeavesDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.MasterLeaves;
import service.leaveservice.MasterLeavesService;
import util.DatabaseConnection;

@WebServlet("/MasterLeavesServlet")
public class MasterLeavesController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action == null || "view".equals(action)) {
			try (Connection conn = DatabaseConnection.getConnection()) {
				MasterLeavesDAO dao = new MasterLeavesDAO();
				MasterLeavesService service = new MasterLeavesService(dao);
				List<MasterLeaves> leaveTypes = service.getAllLeaveTypes();
				request.setAttribute("leaveTypes", leaveTypes);
				request.getRequestDispatcher("WEB-INF/views/leave_views/leavetypes.jsp").forward(request, response);
			} catch (Exception e) {
				throw new ServletException(e);
			}
		} else {
			response.sendRedirect("MasterLeavesServlet?action=view");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		MasterLeavesDAO dao = new MasterLeavesDAO();
		MasterLeavesService service = new MasterLeavesService(dao);

		if ("add".equals(action)) {
			String name = request.getParameter("leaveTypeName");
			MasterLeaves leave = new MasterLeaves(0, name, "ACTIVE");
			boolean success = service.addLeaveType(leave);
			if (success) {
				session.setAttribute("msg", "Leave type added successfully.");
			} else {
				session.setAttribute("msg", "Failed to add leave type.");
			}
		} else if ("delete".equals(action)) {
			int id = Integer.parseInt(request.getParameter("id"));
			boolean success = service.deleteLeaveType(id);
			if (success) {
				session.setAttribute("msg", "Leave type deleted successfully.");
			} else {
				session.setAttribute("msg", "Failed to delete leave type.");
			}
		}
		response.sendRedirect("MasterLeavesServlet?action=view");
	}
}
