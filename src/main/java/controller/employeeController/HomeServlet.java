package controller.employeeController;

import helper.dashboardHelper.AdminDashboardMetrics;
import helper.dashboardHelper.EmployeeDashboardMetrics;
import helper.employeeHelper.UserDetails;
import service.dashboard.AdminHomeService;
import service.dashboard.EmployeeHomeService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;

@WebServlet("/Home")
public class HomeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private AdminHomeService adminHomeService = new AdminHomeService();
    private EmployeeHomeService employeeHomeService = new EmployeeHomeService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	 UserDetails user = (UserDetails) request.getSession().getAttribute("employee");
        
        String role =  user.getRoleName();
        
        

        if(role != null && role.equalsIgnoreCase("ADMIN")) {
            AdminDashboardMetrics adminMetrics = adminHomeService.fetchAdminDashboardMetrics();
            
            
            Map<String, Integer> empCountByDept = adminHomeService.fetchEmployeeCountByDepartment();
            
            
            request.setAttribute("empCountByDept", empCountByDept);

            
            request.setAttribute("adminMetrics", adminMetrics);
        }else if ("Employee".equalsIgnoreCase(role)) {
        	
        	int userId=user.getUserId();
        	
            EmployeeDashboardMetrics employeeMetrics = employeeHomeService.employeeFetchDashboardMetrics(userId);
            request.setAttribute("employeeMetrics", employeeMetrics);
        }
        // Add similar section for manager/employee as you extend

        request.getRequestDispatcher("home.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
