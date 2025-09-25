package controller.documentsController;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.DocumentsService.DpAdminDocumentsService;

import java.io.IOException;

@WebServlet("/deleteAdminDoc")
public class deleteAdminDoc extends HttpServlet {

    private DpAdminDocumentsService service = new DpAdminDocumentsService();

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
