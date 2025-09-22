package controller.reportController;

import helper.reportHelper.BbTaskReportHelper;
import helper.reportHelper.BbTaskSummaryHelper;
import service.reportService.BbTaskReportService;
import util.BbExportUtility;
import util.BbPaginationHelper;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/BbTaskReportController")
public class BbTaskReportController extends HttpServlet {

    private final BbTaskReportService service = new BbTaskReportService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        
    	String type = request.getParameter("type");       
    	String filter = request.getParameter("filter");   
    	if (filter == null || filter.isEmpty()) filter = "all"; 

    	int page = parseIntOrDefault(request.getParameter("page"), 1);
    	int recordsPerPage = parseIntOrDefault(request.getParameter("recordsPerPage"), 10);

        try {
          
            BbTaskSummaryHelper taskSummary = service.getTaskSummary(filter);
            request.setAttribute("taskSummary", taskSummary);

           
            if ("excel".equalsIgnoreCase(type) || "pdf".equalsIgnoreCase(type)) {
                List<BbTaskReportHelper> tasks = service.fetchPaginatedTasks(1, 1000, filter).getData();
                String[] headers = {"ID", "Task Name", "Project", "Due Date", "Priority", "Status"};
                if ("excel".equalsIgnoreCase(type)) {
                    response.setContentType(
                        "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"
                    );
                    response.setHeader("Content-Disposition", "attachment; filename=task_report.xlsx");

                    try (ServletOutputStream out = response.getOutputStream()) {
                        BbExportUtility.exportToExcel("Tasks", headers, tasks, out);
                        out.flush();   
                    } catch (Exception e) {
                        e.printStackTrace(); 
                        throw new ServletException("Error generating Excel", e);
                    }

                    return;
                }
                if ("pdf".equalsIgnoreCase(type)) {
                    response.setContentType("application/pdf");
                    response.setHeader("Content-Disposition", "attachment; filename=task_report.pdf");
                    BbExportUtility.exportToPDF("Task Report", headers, tasks, response.getOutputStream());
                    return;
                }
            }

          
            BbPaginationHelper<BbTaskReportHelper> pagination =
                    service.fetchPaginatedTasks(page, recordsPerPage, filter);

        
            request.setAttribute("pagination", pagination);
            request.setAttribute("selectedFilter", filter);
            request.setAttribute("recordsPerPage", recordsPerPage);

            
            request.getRequestDispatcher("/WEB-INF/views/reports/taskReport.jsp")
                   .forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException("Error in Task Report Controller", e);
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
