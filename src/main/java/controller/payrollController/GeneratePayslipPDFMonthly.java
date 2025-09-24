package controller.payrollController;

import service.employeeService.EmployeeService;
import service.employeeService.UserService;
import service.payrollService.MonthlyPayslipService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Users;

import java.io.IOException;
import java.util.List;

import dao.employeeDao.UserDAO;
import dao.payrollDAO.PayslipDAO;
import helper.employeeHelper.UserDetails;
import helper.payrollHelper.PayslipDetails;

@WebServlet("/GeneratePayslipPDFMonthly")
public class GeneratePayslipPDFMonthly extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private MonthlyPayslipService payslipService = new MonthlyPayslipService();
    private PayslipDAO payslipDAO = new PayslipDAO();
    EmployeeService employeeService = new EmployeeService();
    UserService userService=new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
        	List<UserDetails> employeeList = userService.getAllUserDetails();
            request.setAttribute("employeeList", employeeList);

           
            request.getRequestDispatcher("WEB-INF/views/payroll/generatePayslip.jsp")
                   .forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Error fetching employee list: " + e.getMessage());
            request.getRequestDispatcher("/views/payroll/error.jsp").forward(request, response);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int userId = Integer.parseInt(request.getParameter("employeeId"));
            int month = Integer.parseInt(request.getParameter("month"));
            int year = Integer.parseInt(request.getParameter("year"));

            
            String pdfPath = payslipService.generateMonthlyPayslip(userId, month, year);
            
            List<PayslipDetails> payslipList=payslipDAO.getAllPayslips();
            request.setAttribute("payslipList", payslipList);


            request.setAttribute("message", "Payslip generated successfully!");
            request.setAttribute("payslipPath", pdfPath);
            request.getRequestDispatcher("WEB-INF/views/payroll/payslipHistory.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Error generating payslip: " + e.getMessage());
            request.getRequestDispatcher("WEB-INF/views/payroll/generatePayslip.jsp").forward(request, response);
        }
    }

}
