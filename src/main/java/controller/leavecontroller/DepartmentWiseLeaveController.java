package controller.leavecontroller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Departments;
import model.MasterLeaves;
import model.DepartmentWiseLeaves;
import service.employeeService.DepartmentService;
import service.leaveservice.DepartmentWiseLeaveService;
import service.leaveservice.MasterLeavesService;

import java.io.IOException;
import java.util.List;

@WebServlet("/DepartmentWiseLeaveServlet")
public class DepartmentWiseLeaveController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	DepartmentService departmentService = new DepartmentService();
	MasterLeavesService leaveTypeService = new MasterLeavesService();
	DepartmentWiseLeaveService departmentWiseLeaveService = new DepartmentWiseLeaveService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Departments> departments = departmentService.getAllDepartments();
		List<MasterLeaves> leaveTypes = leaveTypeService.getAllLeaveTypes();

		req.setAttribute("departments", departments);
		req.setAttribute("leaveTypes", leaveTypes);
		req.getRequestDispatcher("WEB-INF/views/leave_views/departmentWiseLeave.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int departmentId = Integer.parseInt(req.getParameter("departmentId"));
		int leaveTypeId = Integer.parseInt(req.getParameter("leaveTypeId"));
		int leaveCount = Integer.parseInt(req.getParameter("leaveCount"));

		DepartmentWiseLeaves dwl = new DepartmentWiseLeaves();
		dwl.setDepartmentId(departmentId);
		dwl.setLeaveTypeId(leaveTypeId);
		dwl.setLeaveCount(leaveCount);
		dwl.setStatus("ACTIVE");

		String message = departmentWiseLeaveService.validateAndAddLeave(dwl);
		req.getSession().setAttribute("msg", message);
		resp.sendRedirect("DepartmentWiseLeaveServlet");
	}
}
