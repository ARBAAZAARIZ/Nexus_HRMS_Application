package controller.attendanceController;

import dao.attendanceDao.ManagerDao;
import model.TimeSheet;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

import java.util.*;


@WebServlet("/managerTimeSheetServlet")
public class ManagerTimeSheetServlet extends HttpServlet {


    private final ManagerDao dao = new ManagerDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<TimeSheet> timesheets = dao.getAllTimeSheets();
            request.setAttribute("timesheets", timesheets);
            System.out.println(timesheets);
            
            request.getRequestDispatcher("WEB-INF/views/attendanceVeiw/AdminView.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(500, "Error fetching timesheets");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action"); 
        String[] selectedIds = request.getParameterValues("selectedIds");
         System.out.println(action);
         System.out.println(selectedIds);
    
        if (action != null && selectedIds != null) {
            List<Integer> ids = new ArrayList<>();
            for (String id : selectedIds) {
                ids.add(Integer.parseInt(id));
            }

            try {
                dao.updateStatusBulk(ids, action.equalsIgnoreCase("Approved") ? "Approved" : "Rejected");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        response.sendRedirect("managerTimeSheetServlet");
    }
}
