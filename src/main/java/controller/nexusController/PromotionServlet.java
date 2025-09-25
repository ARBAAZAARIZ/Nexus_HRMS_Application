package controller.nexusController;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Promotion;
import service.nexusService.PromotionService;

import java.io.IOException;
import java.util.Date;

/**
 * Servlet implementation class PromotionServlet
 */
@WebServlet("/PromotionServlet")
public class PromotionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  PromotionService serve=new PromotionService(); 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PromotionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

	}

}
