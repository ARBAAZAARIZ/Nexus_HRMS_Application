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
import java.util.List;

import dao.payrollDAO.PayslipDAO;
import helper.payrollHelper.PayslipDetails;

/**
 * Servlet implementation class DownloadPayslip
 */
@WebServlet("/PayslipDownload")
public class PayslipDownload extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		  int payslipId = Integer.parseInt(request.getParameter("payslipId"));
	        PayslipDAO dao = new PayslipDAO();
	        try {
	            // Fetch single payslip
	            PayslipDetails payslip = dao.getPayslipById(payslipId);

	            if (payslip != null) {
	                File file = new File(payslip.getFilePath());
	                if (file.exists()) {
	                    response.setContentType("application/pdf");
	                    response.setHeader("Content-Disposition", "inline; filename=" + file.getName());
	                    Files.copy(file.toPath(), response.getOutputStream());
	                } else {
	                    response.getWriter().write("File not found!");
	                }
	            } else {
	                response.getWriter().write("Payslip not found!");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            response.getWriter().write("Error retrieving payslip!");
	        }
	    }
}
