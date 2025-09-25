package controller.employeeController;

import helper.employeeHelper.UserDetails;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import dao.employeeDao.UserDAO;
import model.BankDetails;
import model.EducationDetails;
import model.ExperienceDetails;
import model.FamilyDetails;
import service.employeeService.BankDetailsService;
import service.employeeService.EducationDetailsService;
import service.employeeService.ExperienceDetailsService;
import service.employeeService.FamilyDetailsService;


import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import jakarta.servlet.http.Part;

@WebServlet("/UserDetailServlet")
@MultipartConfig(
	    fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
	    maxFileSize = 1024 * 1024 * 10,      // 10 MB
	    maxRequestSize = 1024 * 1024 * 100   // 100 MB
	)
public class UserDetailServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private EducationDetailsService educationService;
    private BankDetailsService bankService;
    private FamilyDetailsService familyService;
    private ExperienceDetailsService experienceService;
    private UserDAO userDAO;
    
    public UserDetailServlet() {
        educationService = new EducationDetailsService();
        bankService = new BankDetailsService();
        familyService = new FamilyDetailsService();
        experienceService = new ExperienceDetailsService();
        userDAO = new UserDAO();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        UserDetails employee = (UserDetails) session.getAttribute("employee");
        
        Integer userId = employee.getUserId();
       

        
        UserDetails userDetails = UserDAO.getUserDetailsById(userId);
        
         
        List<EducationDetails> educationDetails = educationService.getEducationDetailsByUserId(userId);
        List<BankDetails> bankDetails = bankService.getBankDetailsByUserId(userId);
        List<FamilyDetails> familyDetails = familyService.getFamilyDetailsByUserId(userId);
        List<ExperienceDetails> experienceDetails = experienceService.getExperienceDetailsByUserId(userId);

        // Set attributes
        request.setAttribute("userDetails", userDetails);
        request.setAttribute("educationDetails", educationDetails);
        request.setAttribute("bankDetails", bankDetails);
        request.setAttribute("familyDetails", familyDetails);
        request.setAttribute("experienceDetails", experienceDetails);
        
        request.getRequestDispatcher("WEB-INF/views/employeeViews/employeeDetail.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        UserDetails employee = (UserDetails) session.getAttribute("employee");
        int userId = employee.getUserId();
        
        String action = request.getParameter("action");
        String type = request.getParameter("type");
        
       
                            
        try {
            if ("add".equals(action)) {
                if ("education".equals(type)) {
                    EducationDetails education = new EducationDetails();
                    education.setEducationName(request.getParameter("educationName"));
                    education.setUniversityName(request.getParameter("universityName"));
                    education.setStartDate(Date.valueOf(request.getParameter("startDate")));
                    education.setEndDate(Date.valueOf(request.getParameter("endDate")));
                    education.setUserId(userId);
                    
                    boolean success = educationService.addEducationDetail(education);
                    if (!success) {
                        session.setAttribute("errorMessage", "Failed to add education details.");
                    }
                }
                else if ("bank".equals(type)) {
                    BankDetails bank = new BankDetails();
                    bank.setBankName(request.getParameter("bankName"));
                    bank.setAccountNumber(request.getParameter("accountNumber"));
                    bank.setIfscCode(request.getParameter("ifscCode"));
                    bank.setUserId(userId);
                    
                    boolean success = bankService.addBankDetail(bank);
                    if (!success) {
                        session.setAttribute("errorMessage", "Failed to add bank details. Account number may already exist.");
                    }
                }
                else if ("family".equals(type)) {
                    FamilyDetails family = new FamilyDetails();
                    family.setName(request.getParameter("name"));
                    family.setRelation(request.getParameter("relation"));
                    family.setDateOfBirth(Date.valueOf(request.getParameter("dateOfBirth")));
                    family.setContactNumber(request.getParameter("contactNumber"));
                    family.setUserId(userId);
                    
                    boolean success = familyService.addFamilyDetail(family);
                    if (!success) {
                        session.setAttribute("errorMessage", "Failed to add family details.");
                    }
                }
                else if ("experience".equals(type)) {
                    ExperienceDetails experience = new ExperienceDetails();
                    experience.setDesignationName(request.getParameter("designationName"));
                    experience.setFromDate(Date.valueOf(request.getParameter("fromDate")));
                    experience.setToDate(Date.valueOf(request.getParameter("toDate")));
                    experience.setCompanyName(request.getParameter("companyName"));
                    experience.setUserId(userId);
                    
                    boolean success = experienceService.addExperienceDetail(experience);
                    if (!success) {
                        session.setAttribute("errorMessage", "Failed to add experience details.");
                    }
                }
                else if ("about".equals(type)) {
                    // Update about employee
                    UserDetails userDetails = UserDAO.getUserDetailsById(userId);
                    userDetails.setAboutEmployee(request.getParameter("aboutEmployee"));
                    userDetails.setModifiedBy(employee.getFirstName() + " " + employee.getLastName());
                    
                    boolean success = userDAO.updateUserDetails(userDetails);
                    if (!success) {
                        session.setAttribute("errorMessage", "Failed to update about information.");
                    } else {
                        session.setAttribute("successMessage", "About information updated successfully.");
                    }
                }
            }
            
            else if ("update".equals(action)) {
            	
            	
            	Integer id =0;
            	
            	try {
            		  id = Integer.parseInt(request.getParameter("id"));
            	}catch(Exception e) {
            		System.out.println(e.getMessage());
            		 id=0;
            	}
            	
               
                
                
                System.out.println(type);
                if ("education".equals(type)) {
                    EducationDetails education = new EducationDetails();
                    education.setEducationDetailId(id);
                    education.setEducationName(request.getParameter("educationName"));
                    education.setUniversityName(request.getParameter("universityName"));
                    education.setStartDate(Date.valueOf(request.getParameter("startDate")));
                    education.setEndDate(Date.valueOf(request.getParameter("endDate")));
                    education.setUserId(userId);
                    
                    boolean success = educationService.updateEducationDetail(education);
                    if (!success) {
                        session.setAttribute("errorMessage", "Failed to update education details.");
                    }
                }
                else if ("bank".equals(type)) {
                    BankDetails bank = new BankDetails();
                    bank.setBankDetailId(id);
                    bank.setBankName(request.getParameter("bankName"));
                    bank.setAccountNumber(request.getParameter("accountNumber"));
                    bank.setIfscCode(request.getParameter("ifscCode"));
                    bank.setUserId(userId);
                    
                    boolean success = bankService.updateBankDetail(bank);
                    if (!success) {
                        session.setAttribute("errorMessage", "Failed to update bank details. Account number may already exist.");
                    }
                }
                else if ("family".equals(type)) {
                    FamilyDetails family = new FamilyDetails();
                    family.setFamilyDetailsId(id);
                    family.setName(request.getParameter("name"));
                    family.setRelation(request.getParameter("relation"));
                    family.setDateOfBirth(Date.valueOf(request.getParameter("dateOfBirth")));
                    family.setContactNumber(request.getParameter("contactNumber"));
                    family.setUserId(userId);
                    
                    boolean success = familyService.updateFamilyDetail(family);
                    if (!success) {
                        session.setAttribute("errorMessage", "Failed to update family details.");
                    }
                }
                else if ("experience".equals(type)) {
                    ExperienceDetails experience = new ExperienceDetails();
                    experience.setExperienceDetailId(id);
                    experience.setDesignationName(request.getParameter("designationName"));
                    experience.setFromDate(Date.valueOf(request.getParameter("fromDate")));
                    experience.setToDate(Date.valueOf(request.getParameter("toDate")));
                    experience.setCompanyName(request.getParameter("companyName"));
                    experience.setUserId(userId);
                    
                    boolean success = experienceService.updateExperienceDetail(experience);
                    if (!success) {
                        session.setAttribute("errorMessage", "Failed to update experience details.");
                    }
                }else if ("basic".equals(type)) {
                	
                	
                     
                    UserDetails userDetails = UserDAO.getUserDetailsById(userId);
                    
                    
                    
                     
                    userDetails.setFirstName(request.getParameter("firstName"));
                    userDetails.setLastName(request.getParameter("lastName"));
                    userDetails.setEmail(request.getParameter("email"));
                    userDetails.setContactNumber(request.getParameter("contactNumber"));
                    userDetails.setDateOfBirth(Date.valueOf(request.getParameter("dateOfBirth")));
                    userDetails.setAddress(request.getParameter("address"));
                    userDetails.setAboutEmployee(request.getParameter("aboutEmployee"));
                    userDetails.setModifiedBy(employee.getFirstName() + " " + employee.getLastName());
                    
                   
                    
                    
                    Part filePart = request.getPart("profilePicture");
                    if (filePart != null && filePart.getSize() > 0) {
                        String fileName = getFileName(filePart);
                        String uploadPath = getServletContext().getRealPath("") + File.separator + "images";
                        File uploadDir = new File(uploadPath);
                        if (!uploadDir.exists()) uploadDir.mkdir();
                        
                        String fileExtension = fileName.substring(fileName.lastIndexOf("."));
                        String newFileName = "profile_" + userId + "_" + System.currentTimeMillis() + fileExtension;
                        String filePath = uploadPath + File.separator + newFileName;
                        
                        // Save the file
                        try (InputStream fileContent = filePart.getInputStream()) {
                            Files.copy(fileContent, Paths.get(filePath), StandardCopyOption.REPLACE_EXISTING);
                        }
                        
                        userDetails.setProfilePicture(newFileName);
                    }
                    
                  
                    
                    boolean success = userDAO.updateUserDetailsForSingleEmployee(userDetails);
                    if (success) {
                        session.setAttribute("successMessage", "Basic information updated successfully.");
                         
                        session.setAttribute("employee", userDetails);
                    } else {
                        session.setAttribute("errorMessage", "Failed to update basic information.");
                    }
                }
                
            }
            else if ("delete".equals(action)) {
                int id = Integer.parseInt(request.getParameter("id"));
                
                if ("education".equals(type)) {
                    boolean success = educationService.deleteEducationDetail(id, userId);
                    if (!success) {
                        session.setAttribute("errorMessage", "Failed to delete education details.");
                    }
                }
                else if ("bank".equals(type)) {
                    boolean success = bankService.deleteBankDetail(id, userId);
                    if (!success) {
                        session.setAttribute("errorMessage", "Failed to delete bank details.");
                    }
                }
                else if ("family".equals(type)) {
                    boolean success = familyService.deleteFamilyDetail(id, userId);
                    if (!success) {
                        session.setAttribute("errorMessage", "Failed to delete family details.");
                    }
                }
                else if ("experience".equals(type)) {
                    boolean success = experienceService.deleteExperienceDetail(id, userId);
                    if (!success) {
                        session.setAttribute("errorMessage", "Failed to delete experience details.");
                    }
                }
            }
            
           
            
            session.removeAttribute("successMessage");
            session.removeAttribute("errorMessage");
            
            response.sendRedirect(request.getContextPath() + "/UserDetailServlet");
            
        } catch (IllegalArgumentException e) {
            session.setAttribute("errorMessage", e.getMessage());
            response.sendRedirect(request.getContextPath() + "/UserDetailServlet");
        } catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("errorMessage", "An unexpected error occurred: " + e.getMessage());
            response.sendRedirect(request.getContextPath() + "/UserDetailServlet");
        }
    }
    
    
 
    private String getFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] tokens = contentDisp.split(";");
        for (String token : tokens) {
            if (token.trim().startsWith("filename")) {
                return token.substring(token.indexOf("=") + 2, token.length() - 1);
            }
        }
        return "";
    }
    
    
}