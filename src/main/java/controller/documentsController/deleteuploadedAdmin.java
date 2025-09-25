package controller.documentsController;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.DocumentsService.DpAdminDocumentsService;
import services.DocumentsService.DpEmployeeDocumentsService;

import java.io.IOException;

/**
 * Servlet implementation class deleteuploaded
 */
@WebServlet("/deleteuploadedAdmin")
public class deleteuploadedAdmin extends HttpServlet {
 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteuploadedAdmin() {
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
	    try {
	    	DpAdminDocumentsService service = new DpAdminDocumentsService();
            int uploaId= Integer.parseInt(request.getParameter("uploadId"));
            service.deleteUploaded(uploaId);

            response.setContentType("text/plain");
            response.getWriter().write("success");
        } catch (Exception e) {
            e.printStackTrace();
      
            response.getWriter().write("error");
        }
	}

}
