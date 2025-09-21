package controller.employeeController;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Roles;

import java.io.IOException;
import java.util.List;

import helper.employeeHelper.UserDetails;
import service.employeeService.RoleService;
 
@WebServlet("/RoleServlet")
public class RoleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
     
	 private RoleService roleService;

	    public RoleServlet() {
	        roleService = new RoleService();
	    }

	 
	    @Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String action = request.getParameter("action");

	        if (action == null) {
	            response.sendRedirect("RoleServlet?action=view");
	            return;
	        }

	        switch (action) {
	            case "view": {
	                List<Roles> roles = roleService.getAllRoles();
	                request.setAttribute("roles", roles);

	                String message = request.getParameter("message");
	                if (message != null) {
	                    request.setAttribute("message", message);
	                }

	                request.getRequestDispatcher("WEB-INF/views/employeeViews/roleView.jsp").forward(request, response);
	                break;
	            }

	            case "edit": {
	                int roleId = Integer.parseInt(request.getParameter("roleId"));
	                Roles r = roleService.getRoleById(roleId);
	                List<Roles> roles = roleService.getAllRoles();

	                request.setAttribute("role", r);
	                request.setAttribute("roles", roles);
	                request.setAttribute("showUpdateModal", true);

	                request.getRequestDispatcher("WEB-INF/views/employeeViews/roleView.jsp").forward(request, response);
	                break;
	            }

	        }
	   }

	 
	    @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String action = request.getParameter("action");

	        switch (action) {
	            case "add": {
	                String roleName = request.getParameter("roleName");
	                String status = request.getParameter("status");

	                UserDetails user = (UserDetails) request.getSession().getAttribute("employee");
	                String createdBy = user.getFirstName() + " " + user.getLastName();

	                Roles r = new Roles();
	                r.setRoleName(roleName);
	                r.setStatus(status);
	                r.setCreatedBy(createdBy);

	                boolean success = roleService.addRole(r);

	                if (success) {
	                    response.sendRedirect("RoleServlet?action=view&message=Role+added+successfully!");
	                } else {
	                    response.sendRedirect("RoleServlet?action=view&message=Failed+to+add+role.");
	                }
	                break;
	            }

	            case "update": {
	                int roleId = Integer.parseInt(request.getParameter("roleId"));
	                String roleName = request.getParameter("roleName");
	                String status = request.getParameter("status");

	                UserDetails user = (UserDetails) request.getSession().getAttribute("employee");
	                String modifiedBy = user.getFirstName() + " " + user.getLastName();

	                Roles r = new Roles();
	                r.setRoleId(roleId);
	                r.setRoleName(roleName);
	                r.setStatus(status);
	                r.setModifiedBy(modifiedBy);

	                boolean success = roleService.updateRole(r);

	                if (success) {
	                    response.sendRedirect("RoleServlet?action=view&message=Role+updated+successfully!");
	                } else {
	                    response.sendRedirect("RoleServlet?action=view&message=Failed+to+update+role.");
	                }
	                break;
	            }

	        }
	    }
	

}
