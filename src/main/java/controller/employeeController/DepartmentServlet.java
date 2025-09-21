package controller.employeeController;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Departments;
import service.employeeService.DepartmentService;
import helper.employeeHelper.UserDetails;

import java.io.IOException;
import java.util.List;

@WebServlet("/DepartmentServlet")
public class DepartmentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private DepartmentService departmentService;

    public DepartmentServlet() {
        departmentService = new DepartmentService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            response.sendRedirect("DepartmentServlet?action=view");
            return;
        }

        switch (action) {
            case "view":{
                List<Departments> departments = departmentService.getAllDepartments();
                request.setAttribute("departments", departments);

               
                String message = request.getParameter("message");
                if (message != null) {
                    request.setAttribute("message", message);
                }

                request.getRequestDispatcher("WEB-INF/views/employeeViews/departmentView.jsp").forward(request, response);
                break;
            }

            case "edit":{
            	
            	List<Departments> departments = departmentService.getAllDepartments();
                request.setAttribute("departments", departments);
                
                int deptId = Integer.parseInt(request.getParameter("departmentId"));
                Departments dept = departmentService.getDepartmentById(deptId);

                request.setAttribute("department", dept);
                request.setAttribute("showUpdateModal", true); 
                request.getRequestDispatcher("WEB-INF/views/employeeViews/departmentView.jsp").forward(request, response);
                break;
            }
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            response.sendRedirect("DepartmentServlet?action=view&message=Invalid+action");
            return;
        }

        switch (action) {
            case "add": {
                String departmentName = request.getParameter("departmentName");
                String status = request.getParameter("status");

                UserDetails user = (UserDetails) request.getSession().getAttribute("employee");
                String createdBy = user.getFirstName() + " " + user.getLastName();

                Departments dept = new Departments();
                dept.setDepartmentName(departmentName);
                dept.setStatus(status);
                dept.setCreatedBy(createdBy);

                boolean success = departmentService.addDepartment(dept);

                if (success) {
                    response.sendRedirect("DepartmentServlet?action=view&message=Department+added+successfully!");
                } else {
                    response.sendRedirect("DepartmentServlet?action=view&message=Failed+to+add+department.");
                }
                break;
            }

            case "update": {
                int deptId = Integer.parseInt(request.getParameter("departmentId"));
                String name = request.getParameter("departmentName");
                String status = request.getParameter("status");

                UserDetails user = (UserDetails) request.getSession().getAttribute("employee");
                String modifiedBy = user.getFirstName() + " " + user.getLastName();

                Departments dept = new Departments();
                dept.setDepartmentId(deptId);
                dept.setDepartmentName(name);
                dept.setStatus(status);
                dept.setModifiedBy(modifiedBy);

                boolean updated = departmentService.updateDepartment(dept);

                if (updated) {
                    response.sendRedirect("DepartmentServlet?action=view&message=Department+updated+successfully!");
                } else {
                    response.sendRedirect("DepartmentServlet?action=view&message=Failed+to+update+department.");
                }
                break;
            }
        }
    }
}
