package service.reportService;

import java.util.List;
import java.util.Map;

import dao.reportDao.BbPayslipReportDAO;
import helper.reportHelper.BbPayslipReportHelper;
import util.BbExportUtility;
import util.BbPaginationHelper;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

public class BbPayslipReportService {

    private BbPayslipReportDAO dao = new BbPayslipReportDAO();

    public Map<String, Double> getCardStats() {
        return dao.getCardStats();
    }

    public Map<String, Double> getMonthlyStats() {
        return dao.getMonthlyStats();
    }

    public BbPaginationHelper<BbPayslipReportHelper> getPayslipReport(int page, int limit) {
        int offset = (page - 1) * limit;
        List<BbPayslipReportHelper> list = dao.getPayslipList(offset, limit);
        int totalRecords = dao.getTotalPayslipCount();

        return new BbPaginationHelper<>(list, totalRecords, limit, page);
    }
    
    public void exportToExcel(HttpServletResponse response) {
        try {
            List<BbPayslipReportHelper> list = dao.getPayslipList(0, dao.getTotalPayslipCount());
            String[] headers = {"Payslip ID", "Employee Name", "Paid Amount", "Month", "Year"};

            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.setHeader("Content-Disposition", "attachment; filename=payslip_report.xlsx");

            ServletOutputStream out = response.getOutputStream();
            BbExportUtility.exportToExcel("Payslip Report", headers, list, out);

            out.flush(); 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void exportToPDF(HttpServletResponse response) {
        try {
            List<BbPayslipReportHelper> list = dao.getPayslipList(0, dao.getTotalPayslipCount());
            String[] headers = {"Payslip ID", "Employee Name", "Paid Amount", "Month", "Year"};

            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "attachment; filename=payslip_report.pdf");

            BbExportUtility.exportToPDF("Payslip Report", headers, list, response.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
