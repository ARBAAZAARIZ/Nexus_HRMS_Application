package controller.documentsController;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.documents.UploadDetails;
import services.DocumentsService.DpAdminDocumentsService;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet("/viewAdminDoc")
public class viewAdminDoc extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int uploadId = Integer.parseInt(request.getParameter("uploadId"));

        DpAdminDocumentsService service = new DpAdminDocumentsService();
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

         
        String fileName = doc.getUploadFile().toLowerCase();
        if(fileName.endsWith(".pdf")) {
            response.setContentType("application/pdf");
        } else if(fileName.endsWith(".jpg") || fileName.endsWith(".jpeg")) {
            response.setContentType("image/jpeg");
        } else if(fileName.endsWith(".png")) {
            response.setContentType("image/png");
        } else if(fileName.endsWith(".txt")) {
            response.setContentType("text/plain");
        } else {
            response.setContentType("application/octet-stream");  
        }

         
        response.setHeader("Content-Disposition", "inline; filename=\"" + doc.getUploadFile() + "\"");

        try (FileInputStream fis = new FileInputStream(file);
             OutputStream out = response.getOutputStream()) {

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
        }
    }
}
