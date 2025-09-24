package controller.documentsController;

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
import services.DocumentsService.DpEmployeeDocumentsService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

@WebServlet("/UploadDocumentsEmp")
@MultipartConfig
public class UploadDocumentsEmp extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public UploadDocumentsEmp() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        helper.employeeHelper.UserDetails employee =
                (helper.employeeHelper.UserDetails) request.getSession().getAttribute("employee");

        String uemail = employee.getEmail();
        request.setAttribute("email", uemail);

        DpEmployeeDocumentsService ser1 = new DpEmployeeDocumentsService();
        List<Documents> li = ser1.fetchEmpDoc();
        request.setAttribute("doc", li);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/documentsViews/employeeFileUpload.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userEmail = request.getParameter("userEmail");
        String[] documentNames = request.getParameterValues("documentName");
        String uploadPath = getServletContext().getRealPath("") + File.separator + "uploads";
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        DpEmployeeDocumentsService ser = new DpEmployeeDocumentsService();
        int userId = ser.dgetUserIdByEmail(userEmail);

        int index = 0;
        for (Part part : request.getParts()) {
            if (part.getName().equals("uploadFile") && part.getSize() > 0) {
                String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
                part.write(uploadPath + File.separator + fileName);

                String documentName = documentNames[index]; 
                int documentId = ser.dfetchDocumentId(documentName);

                Uploads upload = new Uploads();
                upload.setUploadName(documentName);
                upload.setUploadFile(fileName);
                upload.setDocumentId(documentId);
                upload.setUserId(userId);

                ser.addUploadDocuments(upload);
                index++;
            }
        }

        response.sendRedirect("UploadDocumentsEmp?success=true");

    }
}
