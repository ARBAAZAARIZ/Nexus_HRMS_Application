package controller.documentsController;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.DocumentsService.DpAdminDocumentsService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import model.documents.Documents;
import model.documents.Uploads;
import services.DocumentsService.DpAdminDocumentsService;

import java.io.File;
import java.io.IOException;
import java.util.List;

@WebServlet("/UploadDocumentsAdmin")
@MultipartConfig
public class UploadDocumentsAdmin extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DpAdminDocumentsService ser = new DpAdminDocumentsService();
	      List<String> emails= ser.dfetchAllEmployeeEmails();
	      request.setAttribute("emails", emails);
    	DpAdminDocumentsService ser1=new DpAdminDocumentsService();
		 List<Documents> li= ser1.fetchAdminDoc();
		 request.setAttribute("doc", li);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/documentsViews/adminFileUpload.jsp");
        dispatcher.forward(request, response);
    }

  
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userEmail = request.getParameter("userEmail");

        DpAdminDocumentsService ser = new DpAdminDocumentsService();
        int userId = ser.dgetUserIdByEmail(userEmail);

        
        String[] documentNames = request.getParameterValues("documentName");

       
        List<Part> fileParts = new ArrayList<>();
        for (Part part : request.getParts()) {
            if (part.getName().equals("uploadFile")) {
                fileParts.add(part);
            }
        }

        String uploadPath = getServletContext().getRealPath("") + File.separator + "uploads";
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        
        for (int i = 0; i < documentNames.length; i++) {
            String documentName = documentNames[i];
            Part filePart = fileParts.get(i);
            String fileName = filePart.getSubmittedFileName();

            filePart.write(uploadPath + File.separator + fileName);

            int documentId = ser.dfetchDocumentId(documentName);

            Uploads upload = new Uploads();
            upload.setUploadName(documentName);
            upload.setUploadFile(fileName);
            upload.setDocumentId(documentId);
            upload.setUserId(userId);

            ser.addUploadDocuments(upload);
        }

        response.sendRedirect("UploadDocumentsAdmin?success=true");
    }

    
}
