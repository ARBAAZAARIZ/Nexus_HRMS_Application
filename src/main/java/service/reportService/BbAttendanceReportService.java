package service.reportService;

import dao.reportDao.BbAttendanceReportDAO;
import helper.reportHelper.BbAttendanceReportHelper;
import helper.reportHelper.BbAttendanceSummaryHelper;
import util.BbExportUtility;

import java.io.OutputStream;
import java.sql.Connection;
import java.sql.Date;
import java.util.List;
import java.util.Map;

public class BbAttendanceReportService {

    private BbAttendanceReportDAO dao;

    public BbAttendanceReportService(Connection conn) {
        this.dao = new BbAttendanceReportDAO(conn);
    }

    public BbAttendanceSummaryHelper getSummary() throws Exception {
        return dao.getAttendanceSummary();
    }

    public List<BbAttendanceReportHelper> getAttendanceList() throws Exception {
        return dao.getAttendanceReport();
    }

    public Map<String, Map<String, Integer>> getAttendanceGraph(Date fromDate, Date toDate) throws Exception {
        return dao.getAttendanceGraphData(fromDate, toDate);
    }
    
    public void exportToExcel(OutputStream out) throws Exception {
        List<BbAttendanceReportHelper> list = dao.getAttendanceReport();
        String[] headers = {
            "ID","Name","Profile","Date","Check In","Check Out",
            "Lunch In","Lunch Out","Status","Working Hours",
            "Production Hours","Break Hour"
        };
        BbExportUtility.exportToExcel("Attendance", headers, list, out);
    }

    public void exportToPDF(OutputStream out) throws Exception {
        List<BbAttendanceReportHelper> list = dao.getAttendanceReport();
        String[] headers = {
            "ID","Name","Profile","Date","Check In","Check Out",
            "Lunch In","Lunch Out","Status","Working Hours",
            "Production Hours","Break Hour"
        };
        BbExportUtility.exportToPDF("Attendance Report", headers, list, out);
    }
}
