package auth;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Users;
import service.employeeService.EmployeeService;
import util.UserDetailsHelper;

import java.io.IOException;

import org.mindrot.jbcrypt.BCrypt;

import helper.employeeHelper.UserDetails;


@WebServlet("/ManualLogin")
public class ManualLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	EmployeeService employeeService;
    
    public ManualLoginServlet() {
    	employeeService = new EmployeeService();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			 String email = request.getParameter("email");
		     String password = request.getParameter("password");
		     
//		     UserDetails user = UserDetailsHelper.getUserDetailsByEmail(email);
		     
		     Users user =employeeService.getEmployeeByEmail(email);

		     
		     if (user == null) {
		            request.setAttribute("message", "No account found for this email.");
		            request.getRequestDispatcher("login.jsp").forward(request, response);
		            return;
		        }
		     
		     
		    
	     
		     if (!BCrypt.checkpw(password, user.getHashPassword())) {
		            request.setAttribute("message", "Incorrect password. Please try again.");
		            request.getRequestDispatcher("login.jsp").forward(request, response);
		            return;
		        }
		     
		     String status = user.getStatus(); 
		     
		     if ("inactive".equalsIgnoreCase(status)) {
		            request.setAttribute("message", "Your account is inactive. Contact HR.");
		            request.getRequestDispatcher("login.jsp").forward(request, response);
		            return;
		        } 
		     
		     UserDetails employee = UserDetailsHelper.getUserDetailsByEmail(email);
		     
		     System.out.println(employee);
		  
		     request.getSession().setAttribute("employee", employee);
		     request.setAttribute("message", "Login Successful !!!");
		     request.getRequestDispatcher("Home").forward(request, response);
		     
		     
			
		}catch (Exception e) {
			request.setAttribute("message", "Login failed due to system error.");
	        request.getRequestDispatcher("login.jsp").forward(request, response);
	        System.out.println("Manual login error: " + e.getMessage());
		}
	}

}
