package controller.documentsController;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.documents.Documents;
import services.DocumentsService.DpAdminDocumentsService;

import java.io.IOException;


@WebServlet("/AddAdminDocumentName")
public class AddAdminDocumentName extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAdminDocumentName() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  System.out.println("hello world");
		  RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/documentsViews/addAdminDocumentName.jsp");
		  dispatcher.forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String aDocName=request.getParameter("documentName");
	DpAdminDocumentsService ser=new DpAdminDocumentsService();
	Documents doc=new Documents();
	doc.setDocumentName(aDocName);
	ser.addDocuments(doc);
	  //response.sendRedirect("/WEB-INF/views/documentsViews.jsp/addAdminDocumentsList.jsp");
	  response.sendRedirect(request.getContextPath()+"/AdminDocumentsList");
	}

}
