package controller.reportController;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

import service.reportService.BbProjectReportService;
import helper.reportHelper.BbProjectReportHelper;
import helper.reportHelper.BbProjectSummaryHelper;
import util.BbPaginationHelper;
import util.BbExportUtility;

@WebServlet("/BbProjectReportController")
public class BbProjectReportController extends HttpServlet {

    private BbProjectReportService service;

    @Override
    public void init() {
        service = new BbProjectReportService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");  
        try {
            if ("exportExcel".equalsIgnoreCase(action)) {
                handleExportExcel(response);
            } else if ("exportPDF".equalsIgnoreCase(action)) {
                handleExportPDF(response);
            } else {
                handleShowReport(request, response);
            }
        } catch (Exception e) {
            throw new ServletException("Error in Project Report Controller", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

   
    private void handleShowReport(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        int page = parseIntOrDefault(request.getParameter("page"), 1);
        int pageSize = parseIntOrDefault(request.getParameter("pageSize"), 10);

        BbProjectSummaryHelper summary = service.getProjectSummary();
        BbPaginationHelper<BbProjectReportHelper> pagination = service.getProjectList(page, pageSize);

        request.setAttribute("summary", summary);
        request.setAttribute("pagination", pagination);
        request.setAttribute("pageSize", pageSize);

        request.getRequestDispatcher("/WEB-INF/views/reports/projectReport.jsp")
               .forward(request, response);
    }

   
    private void handleExportExcel(HttpServletResponse response) throws Exception {
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=ProjectReport.xlsx");

        
        String[] headers = {"Project ID", "Project Name", "Leader", "Members", "Deadline", "Priority", "Status"};
        List<BbProjectReportHelper> list = service.getAllProjects();

        BbExportUtility.exportToExcel("Project Report", headers, list, response.getOutputStream());
    }

    
    private void handleExportPDF(HttpServletResponse response) throws Exception {
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=ProjectReport.pdf");

       
        String[] headers = {"Project ID", "Project Name", "Leader", "Members", "Deadline", "Priority", "Status"};
        List<BbProjectReportHelper> list = service.getAllProjects();

        BbExportUtility.exportToPDF("Project Report", headers, list, response.getOutputStream());
    }

    
    private int parseIntOrDefault(String param, int defaultValue) {
        try {
            return (param != null) ? Integer.parseInt(param) : defaultValue;
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }
}
