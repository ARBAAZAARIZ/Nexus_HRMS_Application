package controller.documentsController;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.documents.UploadDetails;
import services.DocumentsService.DpAdminDocumentsService;
import services.DocumentsService.DpEmployeeDocumentsService;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Servlet implementation class downloadEmployeeDoc
 */
@WebServlet("/downloadEmployeeDoc")
public class downloadEmployeeDoc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public downloadEmployeeDoc() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 int uploadId = Integer.parseInt(request.getParameter("uploadId"));

	        DpEmployeeDocumentsService service = new DpEmployeeDocumentsService();
	        UploadDetails doc = service.getUploadDetailsByUploadId(uploadId);

	        if(doc == null) {
	            response.getWriter().println("Document not found!");
	            return;
	        }

	        String uploadDir = getServletContext().getRealPath("") + File.separator + "uploads";
	        String filePath = uploadDir + File.separator + doc.getUploadFile();
	        File file = new File(filePath);

	        if(!file.exists()) {
	            response.getWriter().println("File not found on server!");
	            return;
	        }

	        
	        response.setContentType("application/octet-stream");
	        response.setHeader("Content-Disposition", "attachment; filename=\"" + doc.getUploadFile() + "\"");

	        try (FileInputStream fis = new FileInputStream(file);
	             OutputStream out = response.getOutputStream()) {

	            byte[] buffer = new byte[4096];
	            int bytesRead;
	            while ((bytesRead = fis.read(buffer)) != -1) {
	                out.write(buffer, 0, bytesRead);
	            }
	        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
