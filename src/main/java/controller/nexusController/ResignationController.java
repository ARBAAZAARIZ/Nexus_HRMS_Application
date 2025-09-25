package controller.nexusController;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

import model.JDesignation;
import model.Resignation;
import model.Users;
import service.nexusService.JDesignationService;
import service.nexusService.ResignationService;
import service.nexusService.UserService;

@WebServlet("/ResignationController")
public class ResignationController extends HttpServlet {
	JDesignationService j=new JDesignationService();
    ResignationService resignationService = new ResignationService();
    UserService userService = new UserService();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action==null) action="list";

        switch(action) {
            case "list":
            	 List<Users> userlist = userService.fetchUsers();
                 List<JDesignation> desglist = j.fetchDesignations();
                 
                List<Resignation> list = resignationService.fetchAll();
                request.setAttribute("resignationref", list);
                request.setAttribute("userref", userlist);
                request.setAttribute("degnref", desglist);
                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/prtViews/resignation.jsp");
                rd.forward(request,response);
                break;

            case "delete":
                int id = Integer.parseInt(request.getParameter("resignation_id"));
                resignationService.delete(id);
                response.sendRedirect("ResignationController?action=list");
                break;

            default:
                response.sendRedirect("ResignationController?action=list");
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action==null) action="add";

        String userIdStr = request.getParameter("user_id");
        String deptIdStr = request.getParameter("department_id");
        String notice = request.getParameter("notice_date");
        String resign = request.getParameter("resignation_date");
        String reason = request.getParameter("reason");
        String status = request.getParameter("status");

        if(userIdStr==null || deptIdStr==null || notice==null || resign==null || 
           userIdStr.isEmpty() || deptIdStr.isEmpty() || notice.isEmpty() || resign.isEmpty()) {
            response.sendRedirect("ResignationController?action=list");
            return;
        }

        Resignation r = new Resignation();
        r.setUser_id(Integer.parseInt(userIdStr));
        r.setDepartment_id(Integer.parseInt(deptIdStr));
        r.setNotice_date(Date.valueOf(notice));
        r.setResign_date(Date.valueOf(resign));
        r.setReason(reason);
        r.setStatus(status!=null?status:"ACTIVE");

        if("add".equalsIgnoreCase(action)) {
            resignationService.save(r);
        } else if("update".equalsIgnoreCase(action)) {
            r.setResignation_id(Integer.parseInt(request.getParameter("resignation_id")));
            resignationService.update(r);
        }

        response.sendRedirect("ResignationController?action=list");
    }
}
