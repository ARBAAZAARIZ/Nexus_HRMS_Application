package controller.nexusController;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Resignation;
import model.JDesignation;
import model.Promotion;
import model.Users;
import service.nexusService.ResignationService;
import service.nexusService.JDesignationService;
import service.nexusService.PromotionService;
import service.nexusService.UserService;

import java.io.IOException;
import java.util.List;

@WebServlet("/PromotionController")
public class PromotionController extends HttpServlet {
    private static final long serialVersionUID = 1L;
  JDesignationService j=new JDesignationService();
    PromotionService promotionService = new PromotionService();
    ResignationService resignationService = new ResignationService();
    UserService userService = new UserService();
    

    private Integer parseIntSafe(String val) {
        try {
            if (val != null && !val.trim().isEmpty()) {
                return Integer.parseInt(val.trim());
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * GET Requests (list, delete)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null || action.trim().isEmpty()) {
            action = "list"; // default action
        }

        switch (action) {
            case "list":
                System.out.println("Fetching list of promotions...");

                List<JDesignation> desglist = j.fetchDesignations();
                List<Users> userlist = userService.fetchUsers();
                List<Promotion> prolist = promotionService.fetchPromotions();

                request.setAttribute("degnref", desglist);
                request.setAttribute("userref", userlist);
                request.setAttribute("promoref", prolist);

                RequestDispatcher dis1 = request.getRequestDispatcher("/WEB-INF/views/prtViews/data.jsp");
                dis1.forward(request, response);
                break;

            case "delete":
                Integer id = parseIntSafe(request.getParameter("promotion_id"));
                if (id != null) {
                    promotionService.delPromotion(id);
                }
                response.sendRedirect("PromotionController?action=list");
                break;

            default:
                response.sendRedirect("PromotionController?action=list");
                break;
        }
    }

    /**
     * POST Requests (add, update)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            response.sendRedirect("PromotionController?action=list");
            return;
        }

        switch (action) {
            case "add":
                try {
                    Integer userId = parseIntSafe(request.getParameter("user_id"));
                    String designation_from = request.getParameter("designation_from");
                    String designation_to = request.getParameter("designation_to");
                    String promotion_date = request.getParameter("promotion_date");

                    if (userId != null) {
                        Promotion p = new Promotion();
                        p.setUser_id(userId);
                        p.setDesignation_from(designation_from);
                        p.setDesignation_to(designation_to);
                        p.setPromotion_date(promotion_date);

                        promotionService.savePromotion(p);
                    }
                    response.sendRedirect("PromotionController?action=list");
                } catch (Exception e) {
                    e.printStackTrace();
                    request.setAttribute("error", "Failed to add promotion.");
                    RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/views/prtViews/data.jsp");
                    dis.forward(request, response);
                }
                break;

            case "update":
                try {
                    System.out.println("Updating promotion...");
                    Integer promotion_id = parseIntSafe(request.getParameter("promotion_id"));
                    Integer user_id = parseIntSafe(request.getParameter("user_id"));
                    String designation_from = request.getParameter("designation_from");
                    String designation_to = request.getParameter("designation_to");
                    String promotion_date = request.getParameter("promotion_date");

                    if (promotion_id == null || user_id == null) {
                        throw new IllegalArgumentException("Promotion ID or User ID missing!");
                    }

                    Promotion updatedPromo = new Promotion();
                    updatedPromo.setPromotion_id(promotion_id);
                    updatedPromo.setUser_id(user_id);
                    updatedPromo.setDesignation_from(designation_from);
                    updatedPromo.setDesignation_to(designation_to);
                    updatedPromo.setPromotion_date(promotion_date);

                    promotionService.UpdatePromotion(updatedPromo);
                    response.sendRedirect("PromotionController?action=list");
                } catch (Exception e) {
                    e.printStackTrace();
                    request.setAttribute("error", "Failed to update promotion.");
                    RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/views/prtViews/data.jsp");
                    dis.forward(request, response);
                }
                break;

            default:
                response.sendRedirect("PromotionController?action=list");
                break;
        }
    }
}
