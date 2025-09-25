package auth;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import util.EmailSender;

import java.io.IOException;

import dao.employeeDao.UserDAO;

@WebServlet("/ForgotPasswordEmail")
public class ForgotPasswordEmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        HttpSession session = request.getSession();

        
        UserDAO userDao = new UserDAO();
        boolean emailExists = userDao.isEmailExists(email);
        if (!emailExists) {
            request.setAttribute("emailError", "Email not found. Please try again.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }

       
        String otp = String.format("%06d", (int)(Math.random() * 999999));
        session.setAttribute("forgotPasswordEmail", email);
        session.setAttribute("forgotPasswordOtp", otp);

        
        EmailSender.sendOtpEmail(email,otp);

        
        request.setAttribute("openOtpModal", true);
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
}
