package auth;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/ForgotPasswordOtp")
public class ForgotPasswordOtpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String enteredOtp = request.getParameter("otp");
        HttpSession session = request.getSession(false);
        String sessionOtp = (String) (session != null ? session.getAttribute("forgotPasswordOtp") : null);

        if (sessionOtp == null || !sessionOtp.equals(enteredOtp)) {
            request.setAttribute("otpError", "Invalid OTP. Please try again.");
            request.setAttribute("openOtpModal", true);
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }

        
        request.setAttribute("openChangePassModal", true);
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
}
