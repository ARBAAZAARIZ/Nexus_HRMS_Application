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
 * Servlet implementation class deleteEmpDoc
 */
@WebServlet("/deleteEmpDoc")
public class deleteEmpDoc extends HttpServlet {
    private DpEmployeeDocumentsService service = new DpEmployeeDocumentsService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int documentId = Integer.parseInt(request.getParameter("documentId"));
            service.deleteDoc(documentId);

            response.setContentType("text/plain");
            response.getWriter().write("success");
        } catch (Exception e) {
            e.printStackTrace();
      
            response.getWriter().write("error");
        }
    }

}
