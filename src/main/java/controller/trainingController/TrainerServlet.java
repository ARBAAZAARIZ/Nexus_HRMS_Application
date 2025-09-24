package controller.trainingController;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import model.Trainer;
import service.employeeService.UserService;
import service.trainingService.TrainerService;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

import helper.employeeHelper.UserDetails;

@WebServlet("/trainer")
@MultipartConfig(
    fileSizeThreshold = 1024 * 1024, // 1MB
    maxFileSize = 1024 * 1024 * 5,   // 5MB
    maxRequestSize = 1024 * 1024 * 10 // 10MB
)
public class TrainerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private TrainerService trainerService;
    private UserService userService;
    
    public TrainerServlet() {
        trainerService = new TrainerService();
        userService = new UserService();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        if (action == null) {
            
            List<Trainer> trainers = trainerService.getAllTrainers();
            List<UserDetails> employees = userService.getAllUserDetails().stream()
                    .filter(user -> "ACTIVE".equalsIgnoreCase(user.getStatus()))
                    .toList();
            
            request.setAttribute("trainers", trainers);
            request.setAttribute("employees", employees);
            request.getRequestDispatcher("/WEB-INF/views/trainingViews/trainerManagement.jsp").forward(request, response);
        } 
        else if ("edit".equals(action)) {
           
            int trainerId = Integer.parseInt(request.getParameter("id"));
            Trainer trainer = trainerService.getTrainerById(trainerId);
            List<UserDetails> employees = userService.getAllUserDetails().stream()
                    .filter(user -> "ACTIVE".equalsIgnoreCase(user.getStatus()))
                    .toList();
            
            request.setAttribute("trainer", trainer);  
            request.setAttribute("employees", employees);
            request.setAttribute("showUpdateModal", true);  
            request.setAttribute("trainers", trainerService.getAllTrainers());  
            
            request.getRequestDispatcher("/WEB-INF/views/trainingViews/trainerManagement.jsp").forward(request, response);
        } else if ("delete".equals(action)) {
            int deleteTrainerId = Integer.parseInt(request.getParameter("id"));
            boolean deleteSuccess = trainerService.deleteTrainer(deleteTrainerId);
            
            if (deleteSuccess) {
                session.setAttribute("message", "Trainer deleted successfully!");
            } else {
                session.setAttribute("message", "Failed to delete trainer!");
            }
            
            response.sendRedirect("trainer");
        }
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        
        if ("insert".equals(action)) {
            
            UserDetails employee = (UserDetails) session.getAttribute("employee");
            String createdBy = employee.getFirstName() + employee.getLastName();
            
            String trainerType = request.getParameter("trainerType");
            boolean isInternal = "internal".equals(trainerType);
            
            Trainer newTrainer = new Trainer();
            newTrainer.setInternal(isInternal);
            newTrainer.setCreatedBy(createdBy);
            
            if (isInternal) {
                int userId = Integer.parseInt(request.getParameter("userId"));
                String description = request.getParameter("description");
                
                UserDetails user = userService.getUserDetailsById(userId);
                if (user != null) {
                    newTrainer.setFirstName(user.getFirstName());
                    newTrainer.setLastName(user.getLastName());
                    newTrainer.setEmail(user.getEmail());
                    newTrainer.setContactNo(user.getContactNumber());
                    newTrainer.setProfilePicture(user.getProfilePicture());
                    newTrainer.setUserId(userId);
                    newTrainer.setDescription(description);
                    newTrainer.setStatus("ACTIVE");
                }
            } else {
                String firstName = request.getParameter("firstName");
                String lastName = request.getParameter("lastName");
                String email = request.getParameter("email");
                String contactNo = request.getParameter("contactNo");
                String description = request.getParameter("description");
                String status = request.getParameter("status");
                
                Part filePart = request.getPart("profilePicture");
                String profilePicturePath = null;
                
                if (filePart != null && filePart.getSize() > 0) {
                    profilePicturePath = handleFileUpload(filePart, getServletContext());
                }
                
                newTrainer.setFirstName(firstName);
                newTrainer.setLastName(lastName);
                newTrainer.setEmail(email);
                newTrainer.setContactNo(contactNo);
                newTrainer.setProfilePicture(profilePicturePath);
                newTrainer.setDescription(description);
                newTrainer.setStatus(status);
                newTrainer.setUserId(null);
            }
            
            boolean insertSuccess = trainerService.addTrainer(newTrainer);
            
            if (insertSuccess) {
                session.setAttribute("message", "Trainer added successfully!");
            } else {
                session.setAttribute("message", "Failed to add trainer!");
            }
            
        } else if ("update".equals(action)) {
             
            UserDetails employee = (UserDetails) session.getAttribute("employee");
            String modifiedBy = employee.getFirstName() + employee.getLastName();
            
            int trainerId = Integer.parseInt(request.getParameter("trainerId"));
            String trainerType = request.getParameter("trainerType");
            boolean isInternal = "internal".equals(trainerType);
            
            Trainer existingTrainer = trainerService.getTrainerById(trainerId);
            existingTrainer.setInternal(isInternal);
            existingTrainer.setModifiedBy(modifiedBy);
            
            if (isInternal) {
                int userId = Integer.parseInt(request.getParameter("userId"));
                String description = request.getParameter("description");
                
                UserDetails user = userService.getUserDetailsById(userId);
                if (user != null) {
                    existingTrainer.setFirstName(user.getFirstName());
                    existingTrainer.setLastName(user.getLastName());
                    existingTrainer.setEmail(user.getEmail());
                    existingTrainer.setContactNo(user.getContactNumber());
                    existingTrainer.setProfilePicture(user.getProfilePicture());
                    existingTrainer.setUserId(userId);
                    existingTrainer.setDescription(description);
                }
            } else {
                String firstName = request.getParameter("firstName");
                String lastName = request.getParameter("lastName");
                String email = request.getParameter("email");
                String contactNo = request.getParameter("contactNo");
                String description = request.getParameter("description");
                String status = request.getParameter("status");
                
                Part filePart = request.getPart("profilePicture");
                if (filePart != null && filePart.getSize() > 0) {
                    String profilePicturePath = handleFileUpload(filePart, getServletContext());
                    existingTrainer.setProfilePicture(profilePicturePath);
                }
                
                existingTrainer.setFirstName(firstName);
                existingTrainer.setLastName(lastName);
                existingTrainer.setEmail(email);
                existingTrainer.setContactNo(contactNo);
                existingTrainer.setDescription(description);
                existingTrainer.setStatus(status);
                existingTrainer.setUserId(null);
            }
            
            boolean updateSuccess = trainerService.updateTrainer(existingTrainer);
            
            if (updateSuccess) {
                session.setAttribute("message", "Trainer updated successfully!");
            } else {
                session.setAttribute("message", "Failed to update trainer!");
            }
            
        }
        
        response.sendRedirect("trainer");
    }
    
    private String handleFileUpload(Part filePart, ServletContext servletContext) throws IOException {
        String appPath = servletContext.getRealPath("");
        String uploadPath = appPath + "images";
        
        Path uploadDir = Paths.get(uploadPath);
        if (!Files.exists(uploadDir)) {
            Files.createDirectories(uploadDir);
        }
        
        String originalFileName = getFileName(filePart);
        String fileExtension = "";
        if (originalFileName != null && originalFileName.contains(".")) {
            fileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
        }
        String fileName = UUID.randomUUID().toString() + fileExtension;
        Path filePath = uploadDir.resolve(fileName);
        
        try (InputStream input = filePart.getInputStream()) {
            Files.copy(input, filePath, StandardCopyOption.REPLACE_EXISTING);
        }
        
        return fileName;
    }
    
    private String getFileName(Part part) {
        String contentDisposition = part.getHeader("content-disposition");
        String[] tokens = contentDisposition.split(";");
        for (String token : tokens) {
            if (token.trim().startsWith("filename")) {
                return token.substring(token.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }
}