package controller.employeeController;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Departments;
import model.Designations;

import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;

import java.io.PrintWriter;


import helper.employeeHelper.DesignationHelper;
import helper.employeeHelper.UserDetails;
import service.employeeService.DepartmentService;
import service.employeeService.DesignationService;



@WebServlet("/DesignationServlet")
public class DesignationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private DesignationService designationService;
    public DesignationServlet() {
    	designationService = new DesignationService();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		 if (action == null) {
	            response.sendRedirect("DesignationServlet?action=view");
	            return;
	        }
		 
		 
		 switch (action) {
		 
		 
		 case "view": {
			    List<DesignationHelper> designations = designationService.getAllDesignations();
			    List<Departments> departments = new DepartmentService().getAllDepartments();

			    request.setAttribute("designations", designations);
			    request.setAttribute("departments", departments);

			    String message = request.getParameter("message");
			    if (message != null) {
			        request.setAttribute("message", message);
			    }

			    request.getRequestDispatcher("WEB-INF/views/employeeViews/designationView.jsp").forward(request, response);
			    break;
			}
		 
		 case "edit": {
			    int designationId = Integer.parseInt(request.getParameter("designationId"));
			    Designations d = designationService.getDesignationById(designationId);
			    List<DesignationHelper> designations = designationService.getAllDesignations();
			    List<Departments> departments = new DepartmentService().getAllDepartments();

			    request.setAttribute("designation", d);
			    request.setAttribute("designations", designations);
			    request.setAttribute("departments", departments);
			    request.setAttribute("showUpdateModal", true);


			    request.getRequestDispatcher("WEB-INF/views/employeeViews/designationView.jsp").forward(request, response);
			    break;
			}
		 case "getByDepartment": {
			    try {
			        int deptId = Integer.parseInt(request.getParameter("deptId"));
			        List<DesignationHelper> designations = designationService.getDesignationsByDepartment(deptId);
			        
			        response.setContentType("application/json");
			        response.setCharacterEncoding("UTF-8");
			        
			        Gson gson = new Gson();
			        String json = gson.toJson(designations);
			        
			        PrintWriter out = response.getWriter();
			        out.print(json);
			        out.flush();
			    } catch (NumberFormatException e) {
			        response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid department ID");
			    } catch (Exception e) {
			        response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error fetching designations");
			        e.printStackTrace();
			    }
			    break;
			}


		 
		 }
	}

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String action = request.getParameter("action");

	    switch (action) {
	        case "add": {
	            String designationName = request.getParameter("designationName");
	            int departmentId = Integer.parseInt(request.getParameter("departmentId"));
	            String status = request.getParameter("status");

	            UserDetails user = (UserDetails) request.getSession().getAttribute("employee");
	            String createdBy = user.getFirstName() + " " + user.getLastName();

	            Designations d = new Designations();
	            d.setDesignationName(designationName);
	            d.setDepartmentId(departmentId);
	            d.setStatus(status);
	            d.setCreatedBy(createdBy);
	            d.setNumberOfEmployee(0); // default on creation

	            boolean success = designationService.addDesignation(d);

	            if (success) {
	                response.sendRedirect("DesignationServlet?action=view&message=Designation+added+successfully!");
	            } else {
	                response.sendRedirect("DesignationServlet?action=view&message=Failed+to+add+designation.");
	            }
	            break;
	        }

	        case "update": {
	            int designationId = Integer.parseInt(request.getParameter("designationId"));
	            String designationName = request.getParameter("designationName");
	            int departmentId = Integer.parseInt(request.getParameter("departmentId"));
	            String status = request.getParameter("status");

	            UserDetails user = (UserDetails) request.getSession().getAttribute("employee");
	            String modifiedBy = user.getFirstName() + " " + user.getLastName();

	            Designations d = new Designations();
	            d.setDesignationId(designationId);
	            d.setDesignationName(designationName);
	            d.setDepartmentId(departmentId);
	            d.setStatus(status);
	            d.setModifiedBy(modifiedBy);

	            boolean success = designationService.updateDesignation(d);

	            if (success) {
	                response.sendRedirect("DesignationServlet?action=view&message=Designation+updated+successfully!");
	            } else {
	                response.sendRedirect("DesignationServlet?action=view&message=Failed+to+update+designation.");
	            }
	            break;
	        }

	    }
	}


}
