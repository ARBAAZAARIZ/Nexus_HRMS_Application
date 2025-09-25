package service.payrollService;

import dao.attendanceDao.AttendanceDAO;
import dao.payrollDAO.DeductionDAO;
import dao.payrollDAO.EarningDAO;
import dao.payrollDAO.PayslipDAO;
import helper.employeeHelper.UserDetails;
import helper.payrollHelper.DeductionHelper;
import helper.payrollHelper.EarningHelper;
import model.EmpSalary;
import util.DatabaseConnection;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.util.List;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

public class MonthlyPayslipService {
	private Connection conn = DatabaseConnection.getConnection();
	private EarningDAO earningDAO = new EarningDAO();
	private DeductionDAO deductionDAO = new DeductionDAO();
	private PayslipDAO payslipDAO = new PayslipDAO();
	private AttendanceDAO attendanceDAO = new AttendanceDAO(); 

	public MonthlyPayslipService() {
	}

	public String generateMonthlyPayslip(int userId, int month, int year) throws Exception {

		EmpSalary salary = payslipDAO.getLastInsertedSalaryByUserAndMonth(userId, month, year);
		if (salary == null)
			System.out.println("No salary found for userId=" + userId + " in " + month + "/" + year);

		int salaryId = salary.getSalaryId();
		System.out.println(salaryId);
		double baseSalary = salary.getTotalSalary();
		
		List<EarningHelper> earnings = earningDAO.getEarningsByEmployee(userId, salaryId);
		System.out.println(earnings);
		List<DeductionHelper> deductions = deductionDAO.getDeductionsByEmployee(userId, salaryId);
		System.out.println(deductions);
		
		double totalEarnings = 0;
		for (EarningHelper e : earnings) {
			double amt = e.getCalculatedAmount();
			totalEarnings += amt;
		}

		double totalDeductions = 0;
		for (DeductionHelper d : deductions) {
			double amt = d.getCalculatedAmount();
			totalDeductions += amt;
		}
		
		baseSalary=baseSalary+ totalEarnings - totalDeductions;
		double totalHoursWorked = attendanceDAO.getTotalHoursWorked(userId, month, year);
		System.out.println(totalHoursWorked + "totalHoursWorked");
		double standardHours = 270;
		double calculatedSalary = (baseSalary/standardHours)*totalHoursWorked;
		System.out.println(calculatedSalary + "calculatedSalary");

		double netSalary= calculatedSalary ;
		System.out.println(netSalary);
		System.out.println(calculatedSalary);
		System.out.println(totalEarnings);
		System.out.println(totalDeductions);

		payslipDAO.updateNetSalary(salaryId, netSalary);

		String folderPath = "C:/Payslips";
		File folder = new File(folderPath);
		if (!folder.exists())
			folder.mkdirs();

		String fileName = folderPath + File.separator + salary.getUserName() + "_Payslip_" + month + "_" + year
				+ ".pdf";

		Document document = new Document(PageSize.A4, 36, 36, 50, 50);
		PdfWriter.getInstance(document, new FileOutputStream(fileName));
		document.open();

		
		Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18, BaseColor.BLUE);
		Font headerFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, BaseColor.WHITE);
		Font normalFont = FontFactory.getFont(FontFactory.HELVETICA, 11, BaseColor.BLACK);

		
		Paragraph title = new Paragraph("Payslip", titleFont);
		title.setAlignment(Element.ALIGN_CENTER);
		document.add(title);
		document.add(new Paragraph(" "));

		
		PdfPTable empTable = new PdfPTable(2);
		empTable.setWidthPercentage(100);
		empTable.setSpacingBefore(10f);
		empTable.setSpacingAfter(10f);
		empTable.setWidths(new int[] { 1, 2 });

		empTable.addCell(createCell("Employee Name:", headerFont, BaseColor.GRAY));
		empTable.addCell(createCell(salary.getUserName(), normalFont, BaseColor.LIGHT_GRAY));
		empTable.addCell(createCell("Month / Year:", headerFont, BaseColor.GRAY));
		empTable.addCell(createCell(month + " / " + year, normalFont, BaseColor.LIGHT_GRAY));
		empTable.addCell(createCell("Hours Worked:", headerFont, BaseColor.GRAY));
		empTable.addCell(createCell(String.valueOf(totalHoursWorked), normalFont, BaseColor.LIGHT_GRAY));
		empTable.addCell(createCell("Base Salary:", headerFont, BaseColor.GRAY));
		empTable.addCell(createCell(String.valueOf(salary.getTotalSalary()), normalFont, BaseColor.LIGHT_GRAY));

		document.add(empTable);

	
		Paragraph earningTitle = new Paragraph("Earnings", headerFont);
		earningTitle.setAlignment(Element.ALIGN_LEFT);
		document.add(earningTitle);

		PdfPTable earningTable = new PdfPTable(2);
		earningTable.setWidthPercentage(100);
		earningTable.setSpacingBefore(5f);
		earningTable.setWidths(new int[] { 3, 1 });
		earningTable.addCell(createCell("Earning Type", headerFont, BaseColor.DARK_GRAY));
		earningTable.addCell(createCell("Amount", headerFont, BaseColor.DARK_GRAY));
		for (EarningHelper e : earnings) {
			earningTable.addCell(createCell(e.getEarningTypeName(), normalFont, BaseColor.WHITE));
			earningTable.addCell(createCell(String.valueOf(e.getCalculatedAmount()), normalFont, BaseColor.WHITE));
		}
		earningTable.addCell(createCell("Total Earnings", headerFont, BaseColor.GRAY));
		earningTable.addCell(createCell(String.valueOf(totalEarnings), headerFont, BaseColor.GRAY));
		document.add(earningTable);

		
		Paragraph deductionTitle = new Paragraph("Deductions", headerFont);
		deductionTitle.setAlignment(Element.ALIGN_LEFT);
		deductionTitle.setSpacingBefore(10f);
		document.add(deductionTitle);

		PdfPTable deductionTable = new PdfPTable(2);
		deductionTable.setWidthPercentage(100);
		deductionTable.setSpacingBefore(5f);
		deductionTable.setWidths(new int[] { 3, 1 });
		deductionTable.addCell(createCell("Deduction Type", headerFont, BaseColor.DARK_GRAY));
		deductionTable.addCell(createCell("Amount", headerFont, BaseColor.DARK_GRAY));
		for (DeductionHelper d : deductions) {
			deductionTable.addCell(createCell(d.getDeductionTypeName(), normalFont, BaseColor.WHITE));
			deductionTable.addCell(createCell(String.valueOf(d.getCalculatedAmount()), normalFont, BaseColor.WHITE));
		}
		deductionTable.addCell(createCell("Total Deductions", headerFont, BaseColor.GRAY));
		deductionTable.addCell(createCell(String.valueOf(totalDeductions), headerFont, BaseColor.GRAY));
		document.add(deductionTable);

	
		Paragraph netSalaryPara = new Paragraph("Net Salary: " + netSalary, titleFont);
		netSalaryPara.setAlignment(Element.ALIGN_RIGHT);
		netSalaryPara.setSpacingBefore(15f);
		document.add(netSalaryPara);

		document.close();

		
		payslipDAO.insertPayslip(userId, month, year, fileName);

		return fileName;
	}

	private PdfPCell createCell(String text, Font font, BaseColor bgColor) {
		PdfPCell cell = new PdfPCell(new Phrase(text, font));
		cell.setBackgroundColor(bgColor);
		cell.setPadding(5);
		return cell;
	}
}
