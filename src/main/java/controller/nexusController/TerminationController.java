package controller.nexusController;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

import model.JTermination;
import model.Users;
import service.nexusService.JTerminationService;
import service.nexusService.UserService;

@WebServlet("/TerminationController")
public class TerminationController extends HttpServlet {
    private final JTerminationService terminationService = new JTerminationService();
    private final UserService userService = new UserService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null) action = "list";

        switch(action) {
            case "list":
                List<JTermination> list = terminationService.fetchAll();
                List<Users> userlist = userService.fetchUsers();
                
                request.setAttribute("terminationref", list);
                request.setAttribute("userref", userlist);
                request.getRequestDispatcher("/WEB-INF/views/prtViews/Termination.jsp").forward(request, response);
                break;

            case "delete":
                try {
                    int id = Integer.parseInt(request.getParameter("termination_id"));
                    terminationService.delete(id);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                response.sendRedirect("TerminationController?action=list");
                break;

            default:
                response.sendRedirect("TerminationController?action=list");
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null) action = "add";
System.out.println("addidng>>>>>>>..");
        try {
            String userIdStr = request.getParameter("user_id");
            String type = request.getParameter("termination_type");
            String notice = request.getParameter("notice_date");
            String resign = request.getParameter("resign_date"); 
            String reason = request.getParameter("reason");
System.out.println(userIdStr);
System.out.println(type);
System.out.println(notice);
System.out.println(resign);
System.out.println(reason);
            if(userIdStr == null || type == null || notice == null || resign == null || reason == null ||
               userIdStr.isEmpty() || type.isEmpty() || notice.isEmpty() || resign.isEmpty() || reason.isEmpty()) {
                response.sendRedirect("TerminationController?action=list");
                return;
            }

            JTermination t = new JTermination();
            t.setUser_id(Integer.parseInt(userIdStr));
            t.setTermination_type(type);
            t.setNotice_date(Date.valueOf(notice));
            t.setResign_date(Date.valueOf(resign));
            t.setReason(reason);
            t.setStatus("ACTIVE");

            if("add".equalsIgnoreCase(action)) {
                terminationService.save(t);
            } else if("update".equalsIgnoreCase(action)) {
                t.setTermination_id(Integer.parseInt(request.getParameter("termination_id")));
                terminationService.update(t);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect("TerminationController?action=list");
    }
}
