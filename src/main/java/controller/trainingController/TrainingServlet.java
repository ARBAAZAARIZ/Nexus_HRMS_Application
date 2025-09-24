package controller.trainingController;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Training;
import model.TrainingType;
import model.Trainer;
import service.trainingService.TrainingService;
import service.trainingService.TrainingTypeService;
import service.trainingService.TrainerService;
import service.employeeService.UserService;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import helper.employeeHelper.UserDetails;
import helper.trainingHelper.TrainingHelper;

@WebServlet("/training")
public class TrainingServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private TrainingService trainingService;
    private TrainingTypeService trainingTypeService;
    private TrainerService trainerService;
    private UserService userService;
    
    public TrainingServlet() {
        trainingService = new TrainingService();
        trainingTypeService = new TrainingTypeService();
        trainerService = new TrainerService();
        userService = new UserService();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        
        if (action == null) {
            
            List<TrainingHelper> trainings = trainingService.getAllTrainingHelpers();
            request.setAttribute("trainings", trainings);
            loadDropdownData(request);
            request.getRequestDispatcher("/WEB-INF/views/trainingViews/trainingManagement.jsp").forward(request, response);
        } 
        else if ("edit".equals(action)) {
             
            int trainingId = Integer.parseInt(request.getParameter("id"));
            Training training = trainingService.getTrainingById(trainingId);
            
            List<TrainingHelper> trainings = trainingService.getAllTrainingHelpers();
            
            request.setAttribute("training", training);
            request.setAttribute("showUpdateModal", true);
            request.setAttribute("trainings", trainings);
            
            
            loadDropdownData(request);
            
            request.getRequestDispatcher("/WEB-INF/views/trainingViews/trainingManagement.jsp").forward(request, response);
        }
        else if ("new".equals(action)) {
             
            List<TrainingHelper> trainings = trainingService.getAllTrainingHelpers();
            request.setAttribute("trainings", trainings);
            
             
            loadDropdownData(request);
            
            request.getRequestDispatcher("/WEB-INF/views/trainingViews/trainingManagement.jsp").forward(request, response);
        }
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        
        if ("insert".equals(action)) {
             
            UserDetails employee = (UserDetails) session.getAttribute("employee");
            String createdBy = employee.getFirstName() + " " + employee.getLastName();
            
            int trainingTypeId = Integer.parseInt(request.getParameter("trainingTypeId"));
            int trainerId = Integer.parseInt(request.getParameter("trainerId"));
            int userId = Integer.parseInt(request.getParameter("userId"));
            double trainingCost = Double.parseDouble(request.getParameter("trainingCost"));
            String description = request.getParameter("description");
            Date startDate = Date.valueOf(request.getParameter("startDate"));
            
            Date endDate = null;
            String endDateStr = request.getParameter("endDate");
            if (endDateStr != null && !endDateStr.isEmpty()) {
                endDate = Date.valueOf(endDateStr);
            }
            
            String status = request.getParameter("status");
            
            Training newTraining = new Training();
            newTraining.setTrainingTypeId(trainingTypeId);
            newTraining.setTrainerId(trainerId);
            newTraining.setUserId(userId);
            newTraining.setTrainingCost(trainingCost);
            newTraining.setDescription(description);
            newTraining.setStartDate(startDate);
            newTraining.setEndDate(endDate);
            newTraining.setStatus(status);
            newTraining.setCreatedBy(createdBy);
            
            boolean insertSuccess = trainingService.addTraining(newTraining);
            
            if (insertSuccess) {
                session.setAttribute("message", "Training added successfully!");
            } else {
                session.setAttribute("message", "Failed to add training!");
            }
            
        } else if ("update".equals(action)) {
             
            UserDetails employee = (UserDetails) session.getAttribute("employee");
            String modifiedBy = employee.getFirstName() + " " + employee.getLastName();
            
            int trainingId = Integer.parseInt(request.getParameter("trainingId"));
            int trainingTypeId = Integer.parseInt(request.getParameter("trainingTypeId"));
            int trainerId = Integer.parseInt(request.getParameter("trainerId"));
            int userId = Integer.parseInt(request.getParameter("userId"));
            double trainingCost = Double.parseDouble(request.getParameter("trainingCost"));
            String description = request.getParameter("description");
            Date startDate = Date.valueOf(request.getParameter("startDate"));
            
            Date endDate = null;
            String endDateStr = request.getParameter("endDate");
            if (endDateStr != null && !endDateStr.isEmpty()) {
                endDate = Date.valueOf(endDateStr);
            }
            
            String status = request.getParameter("status");
            
            Training existingTraining = trainingService.getTrainingById(trainingId);
            existingTraining.setTrainingTypeId(trainingTypeId);
            existingTraining.setTrainerId(trainerId);
            existingTraining.setUserId(userId);
            existingTraining.setTrainingCost(trainingCost);
            existingTraining.setDescription(description);
            existingTraining.setStartDate(startDate);
            existingTraining.setEndDate(endDate);
            existingTraining.setStatus(status);
            existingTraining.setModifiedBy(modifiedBy);
            
            boolean updateSuccess = trainingService.updateTraining(existingTraining);
            
            if (updateSuccess) {
                session.setAttribute("message", "Training updated successfully!");
            } else {
                session.setAttribute("message", "Failed to update training!");
            }
            
        } else if ("delete".equals(action)) {
             
            int deleteTrainingId = Integer.parseInt(request.getParameter("id"));
            boolean deleteSuccess = trainingService.deleteTraining(deleteTrainingId);
            
            if (deleteSuccess) {
                session.setAttribute("message", "Training deleted successfully!");
            } else {
                session.setAttribute("message", "Failed to delete training!");
            }
        }
        
        response.sendRedirect("training");
    }
    
     
    private void loadDropdownData(HttpServletRequest request) {
         
        List<TrainingType> trainingTypes = trainingTypeService.getAllTrainingTypes();
        request.setAttribute("trainingTypes", trainingTypes);
        
      
        List<Trainer> trainers = trainerService.getAllTrainers();
        request.setAttribute("trainers", trainers);
        
         
        List<UserDetails> employees = userService.getAllUserDetails().stream()
                .filter(user -> "ACTIVE".equalsIgnoreCase(user.getStatus()))
                .toList();
        request.setAttribute("employees", employees);
    }
}