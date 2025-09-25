package controller.payrollController;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;


import java.nio.file.Files;
import java.sql.SQLException;

import dao.payrollDAO.PayslipDAO;
import helper.payrollHelper.PayslipDetails;

/**
 * Servlet implementation class viewPayslip
 */
@WebServlet("/ViewPayslip")
public class ViewPayslip extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private PayslipDAO payslipDAO = new PayslipDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int payslipId = Integer.parseInt(request.getParameter("payslipId"));
        PayslipDetails payslip;
		try {
			payslip = payslipDAO.getPayslipById(payslipId);
			 if (payslip != null) {
		            File file = new File(payslip.getFilePath());
		            if (file.exists()) {
		                response.setContentType("application/pdf");
		                response.setHeader("Content-Disposition", "inline; filename=" + file.getName());
		                Files.copy(file.toPath(), response.getOutputStream());
		            }
		        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

       
    }
}
