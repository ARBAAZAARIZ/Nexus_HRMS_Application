package auth;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import util.PasswordEncryptor;

import java.io.IOException;


import dao.employeeDao.UserDAO;

@WebServlet("/ForgotPasswordChange")
public class ForgotPasswordChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String newPass = request.getParameter("newPassword");
        String confirmPass = request.getParameter("confirmPassword");

        if (newPass == null || !newPass.equals(confirmPass) || newPass.length() < 6) {
            request.setAttribute("changePassError", "Passwords do not match or are too short.");
            request.setAttribute("openChangePassModal", true);
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }

        HttpSession session = request.getSession(false);
        if (session == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        String email = (String) session.getAttribute("forgotPasswordEmail");
        if (email == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        // Hash password using jBCrypt 
        String hashed = PasswordEncryptor.hashPassword(newPass);

        // Update password in DB
        UserDAO userDao = new UserDAO();
        userDao.updatePasswordByEmail(email, hashed);

        // Clear session attributes
        session.removeAttribute("forgotPasswordEmail");
        session.removeAttribute("forgotPasswordOtp");

        // Redirect to login page with success message
        response.sendRedirect("login.jsp?msg=Password+changed+successfully");
    }
}
