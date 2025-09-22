package controller.reportController;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import service.reportService.BbLeaveReportService;
import helper.reportHelper.BbLeaveReportHelper;
import util.BbPaginationHelper;
import util.BbExportUtility;
import util.DatabaseConnection;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet("/BbLeaveReportController")
public class BbLeaveReportController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action"); 

        try (Connection conn = DatabaseConnection.getConnection()) {
            BbLeaveReportService service = new BbLeaveReportService(conn);

            /*
            if ("exportExcel".equalsIgnoreCase(action)) {
                exportExcel(response, service);
            } else if ("exportPDF".equalsIgnoreCase(action)) {
                exportPDF(response, service);
            } */
            
            if ("exportExcel".equalsIgnoreCase(action)) {
                exportExcel(response, service);
                return;  
            } else if ("exportPDF".equalsIgnoreCase(action)) {
                exportPDF(response, service);
                return;   
            }

            else {
                showLeaveReport(request, response, service);
            }

        } catch (Exception e) {
            throw new ServletException("Error in Leave Report Controller", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    
    private void showLeaveReport(HttpServletRequest request, HttpServletResponse response,
                                 BbLeaveReportService service) throws Exception {

    
        int page = parseIntOrDefault(request.getParameter("page"), 1);
        int pageSize = parseIntOrDefault(request.getParameter("pageSize"), 10);
        int year = parseIntOrDefault(request.getParameter("year"),
                                     java.time.Year.now().getValue());


        BbPaginationHelper<BbLeaveReportHelper> pagination = service.getLeaveList(page, pageSize);

        request.setAttribute("pagination", pagination); 
        request.setAttribute("year", year); 

    
        request.setAttribute("totalLeaves", service.getTotalLeaves(year));
        request.setAttribute("approvedLeaves", service.getApprovedLeaves(year));
        request.setAttribute("pendingLeaves", service.getPendingLeaves(year));
        request.setAttribute("rejectedLeaves", service.getRejectedLeaves(year));

     
        request.setAttribute("deptNames", new Gson().toJson(service.getDeptNames()));
        request.setAttribute("deptCounts", new Gson().toJson(service.getDeptCounts()));

        request.setAttribute("trends", new Gson().toJson(service.getMonthlyTrends(year)));

     
        request.getRequestDispatcher("/WEB-INF/views/reports/leaveReport.jsp").forward(request, response);
    }


    private void exportExcel(HttpServletResponse response, BbLeaveReportService service) throws Exception {
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=LeaveReport.xlsx");

        String[] headers = {
            "ID", "User", "Leave Type", "Start Date", "End Date",
            "Days", "Reason", "Approved By", "Status", "Status History", "Profile Picture"
        };

       
        List<BbLeaveReportHelper> list = service.getLeaveList(1, Integer.MAX_VALUE).getData();

        try (ServletOutputStream out = response.getOutputStream()) {
            BbExportUtility.exportToExcel("Leave Report", headers, list, out);
            out.flush();
        }
       
    }

    
    private void exportPDF(HttpServletResponse response, BbLeaveReportService service) throws Exception {
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=LeaveReport.pdf");

        String[] headers = {
            "ID", "User", "Leave Type", "Start Date", "End Date",
            "Days", "Reason", "Approved By", "Status"
        };

     
        List<BbLeaveReportHelper> list = service.getLeaveList(1, Integer.MAX_VALUE).getData();

        BbExportUtility.exportToPDF("Leave Report", headers, list, response.getOutputStream());
    }

    private int parseIntOrDefault(String param, int defaultValue) {
        try {
            return (param != null) ? Integer.parseInt(param) : defaultValue;
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }
}
