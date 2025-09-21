package controller.trainingController;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.TrainingType;
import service.trainingService.TrainingTypeService;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@WebServlet("/training-type")
public class TrainingTypeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private TrainingTypeService trainingTypeService;
    
    public TrainingTypeServlet() {
        trainingTypeService = new TrainingTypeService();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        
        if (action == null) {
            action = "list";
        }
        
        switch (action) {
            case "new":
                showNewForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                deleteTrainingType(request, response);
                break;
            default:
                listTrainingTypes(request, response);
                break;
        }
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        
        if (action == null) {
            action = "list";
        }
        
        switch (action) {
            case "insert":
                insertTrainingType(request, response);
                break;
            case "update":
                updateTrainingType(request, response);
                break;
            default:
                listTrainingTypes(request, response);
                break;
        }
    }
    
    private void listTrainingTypes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("trainingTypes", trainingTypeService.getAllTrainingTypes());
        request.getRequestDispatcher("/WEB-INF/views/trainingViews/trainingTypeList.jsp").forward(request, response);
    }
    
    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/trainingViews/trainingTypeForm.jsp").forward(request, response);
    }
    
    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int trainingTypeId = Integer.parseInt(request.getParameter("id"));
        TrainingType trainingType = trainingTypeService.getTrainingTypeById(trainingTypeId);
        request.setAttribute("trainingType", trainingType);
        request.getRequestDispatcher("/WEB-INF/views/trainingViews/trainingTypeForm.jsp").forward(request, response);
    }
    
    private void insertTrainingType(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        String createdBy = (String) session.getAttribute("userEmail"); // Or get user ID from session
        
        String trainingType = request.getParameter("trainingType");
        String description = request.getParameter("description");
        String status = request.getParameter("status");
        
        TrainingType newTrainingType = new TrainingType();
        newTrainingType.setTrainingType(trainingType);
        newTrainingType.setDescription(description);
        newTrainingType.setStatus(status);
        newTrainingType.setCreatedBy(createdBy);
        
        boolean success = trainingTypeService.addTrainingType(newTrainingType);
        
        if (success) {
            session.setAttribute("message", "Training type added successfully!");
        } else {
            session.setAttribute("message", "Failed to add training type!");
        }
        
        response.sendRedirect("training-type");
    }
    
    private void updateTrainingType(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        String modifiedBy = (String) session.getAttribute("userEmail"); // Or get user ID from session
        
        int trainingTypeId = Integer.parseInt(request.getParameter("trainingTypeId"));
        String trainingType = request.getParameter("trainingType");
        String description = request.getParameter("description");
        String status = request.getParameter("status");
        
        TrainingType existingTrainingType = trainingTypeService.getTrainingTypeById(trainingTypeId);
        existingTrainingType.setTrainingType(trainingType);
        existingTrainingType.setDescription(description);
        existingTrainingType.setStatus(status);
        existingTrainingType.setModifiedBy(modifiedBy);
        
        boolean success = trainingTypeService.updateTrainingType(existingTrainingType);
        
        if (success) {
            session.setAttribute("message", "Training type updated successfully!");
        } else {
            session.setAttribute("message", "Failed to update training type!");
        }
        
        response.sendRedirect("training-type");
    }
    
    private void deleteTrainingType(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        
        int trainingTypeId = Integer.parseInt(request.getParameter("id"));
        
        boolean success = trainingTypeService.deleteTrainingType(trainingTypeId);
        
        if (success) {
            session.setAttribute("message", "Training type deleted successfully!");
        } else {
            session.setAttribute("message", "Failed to delete training type!");
        }
        
        response.sendRedirect("training-type");
    }
}