package controller.documentsController;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.documents.Documents;
import services.DocumentsService.DpAdminDocumentsService;
import services.DocumentsService.DpEmployeeDocumentsService;

import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class AdminDocumentsList
 */
@WebServlet("/AdminDocumentsList")
public class AdminDocumentsList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminDocumentsList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DpAdminDocumentsService ser=new DpAdminDocumentsService();
		 List<Documents> li= ser.fetchAdminDoc();
		 request.setAttribute("adminlist", li);
		 RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/documentsViews/adminDocumentList.jsp");
		  dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
		
	}

}
