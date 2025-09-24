package auth;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


@WebFilter("/*")
public class AuthFilter extends HttpFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        
        String path = req.getRequestURI();
        HttpSession session = req.getSession(false);

        boolean isLoggedIn = (session != null && session.getAttribute("employee") != null);
        boolean isLoginPage = path.endsWith("login.jsp") || path.contains("/ManualLogin") || path.contains("/oauth2callback");
        boolean isDoingForgetPassword = path.contains("/ForgotPasswordEmail") || path.contains("/ForgotPasswordOtp")  || path.contains("/ForgotPasswordChange") ;
        boolean isStaticResource = path.contains("/dist/") || path.contains("/documents/") || path.contains("/pages/") ||
                                   path.contains("/plugins/") || path.contains("/reports/") ||
                                   path.contains("/images/") || path.contains("/css/") || path.contains("/js/");

        if (isLoggedIn || isLoginPage || isStaticResource || isDoingForgetPassword) {
            chain.doFilter(request, response);
        } else {
            res.sendRedirect("login.jsp");
        }
    }
}

