package controller.reportController;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import service.reportService.BbPayslipReportService;
import util.BbPaginationHelper;
import helper.reportHelper.BbPayslipReportHelper;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/BbPayslipReportController")
public class BbPayslipReportServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private BbPayslipReportService service = new BbPayslipReportService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {

        String action = req.getParameter("action");

        try {
           
            if ("exportExcel".equalsIgnoreCase(action)) {
                service.exportToExcel(resp);
                return; 
            }

           
            if ("exportPDF".equalsIgnoreCase(action)) {
                service.exportToPDF(resp);
                return; 
            }

            
            int page = 1;
            int recordsPerPage = 10;
            try {
                page = Integer.parseInt(req.getParameter("page"));
            } catch (Exception ignored) {}

            
            Map<String, Double> cardStats = service.getCardStats();
            req.setAttribute("cardStats", cardStats);

           
            Map<String, Double> monthlyStats = service.getMonthlyStats();
            req.setAttribute("monthlyStats", monthlyStats);

            
            BbPaginationHelper<BbPayslipReportHelper> pagination =
                    service.getPayslipReport(page, recordsPerPage);

            List<BbPayslipReportHelper> payslipList = pagination.getData();

            req.setAttribute("payslipData", payslipList);
            req.setAttribute("currentPage", pagination.getCurrentPage());
            req.setAttribute("totalPages", pagination.getTotalPages());
            req.setAttribute("recordsPerPage", recordsPerPage);

            
            req.getRequestDispatcher("/WEB-INF/views/reports/payslipReport.jsp")
               .forward(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
                    "Something went wrong in Payslip Report");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        
        doGet(req, resp);
    }
}
