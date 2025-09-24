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

/**
 * Servlet implementation class AddEmpDocumentName
 */
@WebServlet("/AddEmpDocumentName")
public class AddEmpDocumentName extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEmpDocumentName() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttspServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/documentsViews/addEmployeeDocumentName.jsp");
		  dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String eDocName=request.getParameter("documentName");
		DpEmployeeDocumentsService ser=new DpEmployeeDocumentsService();
		Documents doc=new Documents();
		doc.setDocumentName(eDocName);
		System.out.println(eDocName);
		ser.addDocuments(doc);
		 
		  response.sendRedirect(request.getContextPath()+"/EmployeeDocumentsList");
	}

}
