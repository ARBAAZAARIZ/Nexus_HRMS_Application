package service.reportService;

import java.io.OutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import dao.reportDao.BbEmployeeReportDAO;
import helper.reportHelper.BbEmployeeReportHelper;
import util.BbPaginationHelper;
import util.BbExportUtility;

public class BbEmployeeReportService {
    private BbEmployeeReportDAO dao;

    public BbEmployeeReportService(Connection con) {
        this.dao = new BbEmployeeReportDAO(con);
    }

    public int getTotalEmployees() throws SQLException {
        return dao.getTotalEmployees();
    }

    public int getActiveEmployees() throws SQLException {
        return dao.getActiveEmployees();
    }

    public int getTotalDepartments() throws SQLException {
        return dao.getTotalDepartments();
    }

    public int getTotalRoles() throws SQLException {
        return dao.getTotalRoles();
    }

   
    public BbPaginationHelper<BbEmployeeReportHelper> getEmployees(int page, int recordsPerPage) throws SQLException {
        int totalRecords = dao.getTotalEmployees();
        int offset = (page - 1) * recordsPerPage;
        List<BbEmployeeReportHelper> list = dao.getEmployeesPaginated(offset, recordsPerPage);

        return new BbPaginationHelper<>(list, totalRecords, recordsPerPage, page);
    }

    public List<BbEmployeeReportHelper> exportEmployees(int page, int recordsPerPage) throws SQLException {
        int offset = (page - 1) * recordsPerPage;
        return dao.getEmployeesPaginated(offset, recordsPerPage);
    }

    public void exportEmployeesToExcel(String sheetName, String[] headers,
            int page, int recordsPerPage, OutputStream out) throws Exception {

        List<BbEmployeeReportHelper> employees = exportEmployees(page, recordsPerPage);
        if (employees == null) employees = new ArrayList<>(); // avoid NPE

        BbExportUtility.exportToExcel(sheetName, headers, employees, out);
    }


    public void exportEmployeesToPDF(String title, String[] headers,
            int page, int recordsPerPage, OutputStream out) throws Exception {
        List<BbEmployeeReportHelper> employees = exportEmployees(page, recordsPerPage);
        BbExportUtility.exportToPDF(title, headers, employees, out);
    }

    
    public Map<String, Integer> getMonthlyStats(String year) throws SQLException {
        return dao.getMonthlyActiveInactive(year);
    }
}
