package controller.reportController;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import service.reportService.BbEmployeeReportService;
import helper.reportHelper.BbEmployeeReportHelper;
import util.BbPaginationHelper;
import util.DatabaseConnection;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

@WebServlet("/BbEmployeeReportController")
public class BbEmployeeReportController extends HttpServlet {

    private static final int DEFAULT_PAGE_SIZE = 10;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int page = 1;
        int recordsPerPage = DEFAULT_PAGE_SIZE;

        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }
        if (request.getParameter("pageSize") != null) {
            recordsPerPage = Integer.parseInt(request.getParameter("pageSize"));
        }

        String year = request.getParameter("year");
        if (year == null || year.isEmpty()) {
            year = String.valueOf(java.time.Year.now().getValue());
        }

        try (Connection con = DatabaseConnection.getConnection()) {
            BbEmployeeReportService service = new BbEmployeeReportService(con);

            BbPaginationHelper<BbEmployeeReportHelper> pagination =
                    service.getEmployees(page, recordsPerPage);

            request.setAttribute("pagination", pagination);
            request.setAttribute("totalEmployee", service.getTotalEmployees());
            request.setAttribute("activeCount", service.getActiveEmployees());
            request.setAttribute("deptCount", service.getTotalDepartments());
            request.setAttribute("roleCount", service.getTotalRoles());
            request.setAttribute("pageSize", recordsPerPage);

           
            Map<String, Integer> monthlyStats = service.getMonthlyStats(year);
            List<Integer> activeList = new ArrayList<>();
            List<Integer> inactiveList = new ArrayList<>();
            for (int i = 1; i <= 12; i++) {
                activeList.add(monthlyStats.getOrDefault(i + "_ACTIVE", 0));
                inactiveList.add(monthlyStats.getOrDefault(i + "_INACTIVE", 0));
            }
            request.setAttribute("activeByMonth", activeList);
            request.setAttribute("inactiveByMonth", inactiveList);
            request.setAttribute("selectedYear", year);

            request.getRequestDispatcher("/WEB-INF/views/reports/employeeReport.jsp")
                   .forward(request, response);

        } catch (Exception e) {
            throw new ServletException("Error fetching employee report", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        int page = 1;
        int recordsPerPage = DEFAULT_PAGE_SIZE;
        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }
        if (request.getParameter("pageSize") != null) {
            recordsPerPage = Integer.parseInt(request.getParameter("pageSize"));
        }

        try (Connection con = DatabaseConnection.getConnection()) {
            BbEmployeeReportService service = new BbEmployeeReportService(con);

            String[] headers = {
                "Employee ID", "Name", "Email", "Department",
                "Contact Number", "Date of Joining", "Status", "Photo"
            };

            if ("exportExcel".equalsIgnoreCase(action)) {
                response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
                response.setHeader("Content-Disposition", "attachment; filename=employees.xlsx");

                try (ServletOutputStream out = response.getOutputStream()) {
                    service.exportEmployeesToExcel("Employees", headers, page, recordsPerPage, out);
                    out.flush(); 
                } catch (Exception e) {
                    e.printStackTrace(); 
                    throw new ServletException("Error exporting Excel", e);
                }

                return; 
            }
            else if ("exportPdf".equals(action)) {
                response.setContentType("application/pdf");
                response.setHeader("Content-Disposition", "attachment; filename=employees.pdf");

                service.exportEmployeesToPDF("Employee Report", headers, page, recordsPerPage,
                        response.getOutputStream());
                response.getOutputStream().flush();
                response.getOutputStream().close();
                return;

            } else {
                doGet(request, response);
            }

        } catch (Exception e) {
            throw new ServletException("Error exporting employee report", e);
        }
    }
}
