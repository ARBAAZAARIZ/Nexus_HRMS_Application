package controller.leavecontroller;

import java.io.IOException;
import java.util.List;

import helper.leavehelper.DepartmentLeaveHelper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.leaveservice.DepartmentWiseLeaveService;

@WebServlet("/LeaveAllocationServlet")
public class DepartmentLeaveAllocationServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DepartmentWiseLeaveService service = new DepartmentWiseLeaveService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("departmentId") == null) {
            resp.sendRedirect("login.jsp");
            return;
        }
        int departmentId = (Integer) session.getAttribute("departmentId");
        List<DepartmentLeaveHelper> leaves = service.getLeavesForDepartment(departmentId);
        req.setAttribute("departmentLeaves", leaves);
        req.getRequestDispatcher("WEB-INF/views/leave_views/leaveAllocation.jsp").forward(req, resp);
    }
}
