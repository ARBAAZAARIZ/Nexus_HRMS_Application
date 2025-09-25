package controller.leavecontroller;

import java.io.IOException;
import java.util.List;

import helper.leavehelper.DepartmentLeaveHelper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.leaveservice.DepartmentWiseLeaveService;

@WebServlet("/DepartmentLeaveDetailsServlet")
public class DepartmentLeaveDetailsServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DepartmentWiseLeaveService service = new DepartmentWiseLeaveService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<DepartmentLeaveHelper> detailsList = service.getAllDepartmentLeaveDetails();
        req.setAttribute("detailsList", detailsList);
        req.getRequestDispatcher("WEB-INF/views/leave_views/departmentLeaveDetails.jsp").forward(req, resp);
    }
}
