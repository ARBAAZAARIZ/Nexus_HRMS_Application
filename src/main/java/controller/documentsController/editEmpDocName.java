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
 * Servlet implementation class editAdminDocName
 */
@WebServlet("/editEmpDocName")
public class editEmpDocName extends HttpServlet {
	 private DpEmployeeDocumentsService service = new DpEmployeeDocumentsService();

	    @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	        try {
	            int documentId = Integer.parseInt(request.getParameter("documentId"));
	            String documentName = request.getParameter("documentName");

	            
	            service.updateDocument(documentId, documentName);

	          
	            response.setContentType("text/plain");
	            response.getWriter().write("success");

	        } catch (Exception e) {
	            e.printStackTrace();
	            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
	            response.getWriter().write("error");
	        }
	    }
}
