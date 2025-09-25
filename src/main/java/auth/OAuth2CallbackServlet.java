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
import java.util.Collections;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;

import helper.employeeHelper.UserDetails;


@WebServlet("/oauth2callback")
public class OAuth2CallbackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	EmployeeService employeeService;
    public OAuth2CallbackServlet() {
    	employeeService =new EmployeeService();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String idTokenString = request.getParameter("idtoken");

			GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(
			        GoogleNetHttpTransport.newTrustedTransport(),
			        GsonFactory.getDefaultInstance())
			        .setAudience(Collections.singletonList("580884141285-alfgq2rbnk0fq1j6kst6epjt5ij71kfl.apps.googleusercontent.com"))
			        .build();

			GoogleIdToken idToken = verifier.verify(idTokenString);
			if (idToken != null) {
			    GoogleIdToken.Payload payload = idToken.getPayload();
			    String email = payload.getEmail();
			    

			    UserDetails employee= UserDetailsHelper.getUserDetailsByEmail(email);
			    
			    if (employee == null) {
	                // Email not found in DB
	                request.setAttribute("message", "No account found for this email. Please contact admin.");
	                request.getRequestDispatcher("login.jsp").forward(request, response);
	                return;
	            }
			    
			    String status = employee.getStatus(); 
			    
			    	System.out.println("inactive".equalsIgnoreCase(status));
			    
			    if ("inactive".equalsIgnoreCase(status)) {
	                request.setAttribute("message", "Your account is inactive. Please contact HR.");
	                request.getRequestDispatcher("login.jsp").forward(request, response);
	                return;
	            }else if (!"active".equalsIgnoreCase(status)) {
	                request.setAttribute("message", "Unknown account status. Please contact support.");
	                request.getRequestDispatcher("login.jsp").forward(request, response);
	                return;
	            }
			    
			    int departmentId = employee.getDepartmentId(); 
			     
		     	request.getSession().setAttribute("departmentId", departmentId);
			    
			    
			    
			    request.getSession().setAttribute("employee", employee);
			    
			    
			    
			    request.getSession().setAttribute("userId", employee.getUserId());
			    
			    
			    String managerName = employee.getFirstName(); 

			     request.getSession().setAttribute("managerName", managerName);
			    
			    request.setAttribute("message", "Login Successful !!!");
			    System.out.println();
			    request.getRequestDispatcher("Home").forward(request, response);

			    
			} else {
			    response.getWriter().println("Invalid ID token.");
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
