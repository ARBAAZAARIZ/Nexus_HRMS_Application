package controller.payrollController;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Payslip;

import java.io.IOException;
import java.util.List;

import dao.payrollDAO.PayslipDAO;
import helper.employeeHelper.UserDetails;
import helper.payrollHelper.PayslipDetails;

/**
 * Servlet implementation class PayslipHistory
 */
@WebServlet("/PayslipHistory")
public class PayslipHistory extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PayslipDAO payslipDAO = new PayslipDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
           
            List<PayslipDetails> payslipList=payslipDAO.getAllPayslips();
            request.setAttribute("payslipList", payslipList);

//            HttpSession session1 = request.getSession(false);
//            UserDetails user = (UserDetails) session1.getAttribute("employee");
//            if (user.getRoleName().equalsIgnoreCase("admin")) {
               
                
                System.out.println(payslipList);
//            } else {
//                
//                payslipList = payslipDAO.getPayslipsByUser(user.getUserId());
////            }

            request.setAttribute("payslipList", payslipList);
            request.getRequestDispatcher("/WEB-INF/views/payroll/payslipHistory.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Error fetching payslip history: " + e.getMessage());
            request.getRequestDispatcher("/WEB-INF/views/payroll/error.jsp").forward(request, response);
        }
    }
}
