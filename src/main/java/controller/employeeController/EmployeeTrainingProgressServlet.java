package controller.employeeController;

import helper.dashboardHelper.TrainingInfo;
import helper.employeeHelper.UserDetails;
import service.dashboard.EmployeeHomeService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet("/EmployeeTrainingProgress")
public class EmployeeTrainingProgressServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private EmployeeHomeService employeeHomeService = new EmployeeHomeService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        UserDetails user = (UserDetails) session.getAttribute("employee");
        int userId = 0;
        if (session != null) {
            
            userId=user.getUserId();
            
        }

        List<TrainingInfo> trainingList = employeeHomeService.employeeGetTrainingProgress(userId);
        request.setAttribute("trainingList", trainingList);
        request.getRequestDispatcher("WEB-INF/views/trainingViews/employeeTrainingProgress.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
