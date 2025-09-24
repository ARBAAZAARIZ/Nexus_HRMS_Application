package controller.documentsController;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.documents.UploadDetails;
import services.DocumentsService.DpAdminDocumentsService;

import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class EmployeeDocumentsList
 */
@WebServlet("/UploadedAdminDocumentList")
public class UploadedAdminDocumentList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadedAdminDocumentList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  DpAdminDocumentsService ser=new DpAdminDocumentsService();
		 List<UploadDetails> li=ser.uploadedDetails();
		 request.setAttribute("adminList", li);
		 
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/documentsViews/uploadedAdminDocumentList.jsp");
		  dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
