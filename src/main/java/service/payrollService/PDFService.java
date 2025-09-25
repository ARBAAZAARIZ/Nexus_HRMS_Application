package service.payrollService;

import helper.employeeHelper.UserDetails;
import helper.payrollHelper.EarningHelper;
import helper.payrollHelper.DeductionHelper;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import java.io.FileOutputStream;
import java.util.List;

public class PDFService {

	

	

	    public String generatePayslipPDF(UserDetails emp,
	                                     double baseSalary,
	                                     List<EarningHelper> earnings,
	                                     List<DeductionHelper> deductions,
	                                     String pdfPath,
	                                     int month,
	                                     int year,
	                                     double netSalary,
	                                     double workedHours,
	                                     double expectedHours) throws Exception {

	        Document document = new Document();
	        PdfWriter.getInstance(document, new FileOutputStream(pdfPath));
	        document.open();

	       
	        Font titleFont = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD);
	        Paragraph title = new Paragraph("Monthly Payslip", titleFont);
	        title.setAlignment(Element.ALIGN_CENTER);
	        document.add(title);
	        document.add(new Paragraph("Month: " + month + " / " + year));
	        document.add(Chunk.NEWLINE);

	        
	        document.add(new Paragraph("Employee: " + emp.getFirstName() + " " + emp.getLastName()));
	        document.add(new Paragraph("Department: " + emp.getDepartmentName()));
	        document.add(new Paragraph("Designation: " + emp.getDesignationName()));
	        document.add(Chunk.NEWLINE);

	        
	        PdfPTable hoursTable = new PdfPTable(2);
	        hoursTable.setWidthPercentage(60);
	        hoursTable.setSpacingBefore(10f);
	        hoursTable.setSpacingAfter(10f);

	        hoursTable.addCell("Worked Hours");
	        hoursTable.addCell(String.format("%.2f", workedHours));

	        hoursTable.addCell("Expected Hours");
	        hoursTable.addCell(String.format("%.2f", expectedHours));

	        document.add(hoursTable);
	        document.add(Chunk.NEWLINE);

	       
	        PdfPTable earningTable = new PdfPTable(3);
	        earningTable.setWidthPercentage(80);
	        earningTable.setSpacingBefore(10f);

	        earningTable.addCell("Earning Type");
	        earningTable.addCell("Percentage");
	        earningTable.addCell("Amount");

	        double totalEarnings = 0;
	        for (EarningHelper e : earnings) {
	            earningTable.addCell(e.getEarningTypeName());
	            earningTable.addCell(e.getEarningPercentage() + "%");
	            earningTable.addCell(String.format("%.2f", e.getCalculatedAmount()));
	            totalEarnings += e.getCalculatedAmount();
	        }

	        earningTable.addCell("Total Earnings");
	        earningTable.addCell("");
	        earningTable.addCell(String.format("%.2f", totalEarnings));

	        document.add(earningTable);
	        document.add(Chunk.NEWLINE);

	        // Deductions Table
	        PdfPTable deductionTable = new PdfPTable(3);
	        deductionTable.setWidthPercentage(80);
	        deductionTable.setSpacingBefore(10f);

	        deductionTable.addCell("Deduction Type");
	        deductionTable.addCell("Percentage");
	        deductionTable.addCell("Amount");

	        double totalDeductions = 0;
	        for (DeductionHelper d : deductions) {
	            deductionTable.addCell(d.getDeductionTypeName());
	            deductionTable.addCell(d.getDeductionPercentage() + "%");
	            deductionTable.addCell(String.format("%.2f", d.getCalculatedAmount()));
	            totalDeductions += d.getCalculatedAmount();
	        }

	        deductionTable.addCell("Total Deductions");
	        deductionTable.addCell("");
	        deductionTable.addCell(String.format("%.2f", totalDeductions));

	        document.add(deductionTable);
	        document.add(Chunk.NEWLINE);

	       
	        PdfPTable summaryTable = new PdfPTable(2);
	        summaryTable.setWidthPercentage(60);
	        summaryTable.setSpacingBefore(15f);

	        summaryTable.addCell("Base Salary");
	        summaryTable.addCell(String.format("%.2f", baseSalary));

	        summaryTable.addCell("Net Salary");
	        summaryTable.addCell(String.format("%.2f", netSalary));

	        document.add(summaryTable);

	        document.close();
	        return pdfPath;
	    }
	}


