package controller.payrollController;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Payslip;
import model.Users;
import service.employeeService.EmployeeService;
import service.payrollService.DeductionService;
import service.payrollService.EarningService;
import service.payrollService.MonthlyPayslipService;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;



/**
 * Servlet implementation class generatePayslip
 */
@WebServlet("/GeneratePayslipPDF")
public class generatePayslip extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int employeeId = Integer.parseInt(request.getParameter("employeeId"));
            int month = Integer.parseInt(request.getParameter("month"));
            int year = Integer.parseInt(request.getParameter("year"));
            
            System.out.println(employeeId);

            MonthlyPayslipService payslipService = new MonthlyPayslipService();
            String pdfPath = payslipService.generateMonthlyPayslip(employeeId, month, year);

            File pdfFile = new File(pdfPath);
            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "inline; filename=" + pdfFile.getName());

            try (FileInputStream fis = new FileInputStream(pdfFile)) {
                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = fis.read(buffer)) != -1) {
                    response.getOutputStream().write(buffer, 0, bytesRead);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error generating PDF");
        }
    }

}
