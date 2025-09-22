package controller.reportController;

import helper.reportHelper.BbAttendanceReportHelper;
import helper.reportHelper.BbAttendanceSummaryHelper;
import service.reportService.BbAttendanceReportService;
import util.BbPaginationHelper;
import util.DatabaseConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet("/BbAttendanceReportController")
public class BbAttendanceReportController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String type = request.getParameter("type");  
        int page = parseIntOrDefault(request.getParameter("page"), 1);
        int recordsPerPage = parseIntOrDefault(request.getParameter("recordsPerPage"), 10);

        try (Connection conn = DatabaseConnection.getConnection()) {
          
            BbAttendanceReportService service = new BbAttendanceReportService(conn);

           
            BbAttendanceSummaryHelper summary = service.getSummary();
            request.setAttribute("attendanceSummary", summary);

          
            if ("excel".equalsIgnoreCase(type)) {
                response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
                response.setHeader("Content-Disposition", "attachment; filename=attendance_report.xlsx");
                try (ServletOutputStream out = response.getOutputStream()) {
                    service.exportToExcel(out);
                }
                return;
            }

            if ("pdf".equalsIgnoreCase(type)) {
                response.setContentType("application/pdf");
                response.setHeader("Content-Disposition", "attachment; filename=attendance_report.pdf");
                service.exportToPDF(response.getOutputStream());
                return;
            }

            List<BbAttendanceReportHelper> allRecords = service.getAttendanceList();
            int totalRecords = allRecords.size();

            int fromIndex = Math.max((page - 1) * recordsPerPage, 0);
            int toIndex = Math.min(fromIndex + recordsPerPage, totalRecords);
            List<BbAttendanceReportHelper> paginatedList = allRecords.subList(fromIndex, toIndex);

            BbPaginationHelper<BbAttendanceReportHelper> pagination =
                    new BbPaginationHelper<>(paginatedList, totalRecords, recordsPerPage, page);

            request.setAttribute("pagination", pagination);
            request.setAttribute("recordsPerPage", recordsPerPage);

           
            request.getRequestDispatcher("/WEB-INF/views/reports/attendanceReport.jsp")
                   .forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException("Error in Attendance Report Controller", e);
        }
    }

   
    private int parseIntOrDefault(String value, int defaultVal) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return defaultVal;
        }
    }
}
