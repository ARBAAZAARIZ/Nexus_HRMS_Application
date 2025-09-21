package controller.employeeController;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.employeeService.UserService;
import helper.employeeHelper.UserDetails;

import java.io.IOException;
import java.util.List;

@WebServlet("/ExportServlet")
public class ExportServlet extends HttpServlet {
    private UserService userService;

    public void init() {
        userService = new UserService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String exportType = request.getParameter("exportType");
        String selectedUsers = request.getParameter("selectedUsers");
        
        List<UserDetails> users;
        
        if (selectedUsers != null && !selectedUsers.isEmpty()) {
            // Get selected users only
            String[] userIds = selectedUsers.split(",");
            users = userService.getUsersByIds(userIds);
        } else {
            // Get all users
            users = userService.getAllUserDetails();
        }
        
        if ("pdf".equals(exportType)) {
            exportToPdf(users, response);
        } else if ("excel".equals(exportType)) {
            exportToExcel(users, response);
        }
    }
    
    private void exportToPdf(List<UserDetails> users, HttpServletResponse response) {
        // Implement PDF export using iText or other PDF library
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=employees.pdf");
        
        // PDF generation logic here
    }
    
    private void exportToExcel(List<UserDetails> users, HttpServletResponse response) {
        // Implement Excel export using Apache POI or other Excel library
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=employees.xlsx");
        
        // Excel generation logic here
    }
}