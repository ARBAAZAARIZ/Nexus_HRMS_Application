package controller.employeeController;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;

import jakarta.servlet.http.*;

import java.io.File;

import java.sql.Date;
import java.util.Arrays;

import java.util.List;

import java.util.stream.Collectors;


import com.google.gson.Gson;

import helper.employeeHelper.DesignationHelper;
import helper.employeeHelper.UserDetails;
import model.Users;

import model.Roles;
import model.Departments;


import service.employeeService.UserService;
import service.employeeService.RoleService;
import service.employeeService.DepartmentService;
import service.employeeService.DesignationService;
import util.PasswordEncryptor;
import util.EmailSender;

import com.lowagie.text.*;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Image;
import java.awt.Color;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;

import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



@WebServlet("/UserServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 10,      // 10MB
maxRequestSize = 1024 * 1024 * 50)   // 50MB
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public UserServlet() {
        super();
        
    }

	
    private UserService userService;
    private RoleService roleService;
    private DepartmentService departmentService;
    private DesignationService designationService;

    public void init() {
        userService = new UserService();
        roleService = new RoleService();
        departmentService = new DepartmentService();
        designationService = new DesignationService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) action = "view";

        switch (action) {
            case "view": {
                List<UserDetails> users = userService.getAllUserDetails();
                List<Roles> roles = roleService.getAllRoles();
                List<Departments> departments = departmentService.getAllDepartments();
                List<DesignationHelper> designations = designationService.getAllDesignations();
                List<UserDetails> managers = userService.getAllManagers(); 

                request.setAttribute("users", users);
                request.setAttribute("roles", roles);
                request.setAttribute("departments", departments);
                request.setAttribute("designations", designations);
                request.setAttribute("managers", managers);

                request.getRequestDispatcher("WEB-INF/views/employeeViews/userView.jsp").forward(request, response);
                break;
            }
            
         
            case "getAllManagers": {
                try {
                    List<UserDetails> managers = userService.getAllManagers();
                    
                    System.out.println(managers);
                    
                    response.setContentType("application/json");
                    response.setCharacterEncoding("UTF-8");
                    
                    Gson gson = new Gson();
                    String json = gson.toJson(managers);
                    
                    PrintWriter out = response.getWriter();
                    out.print(json);
                    out.flush();
                } catch (Exception e) {
                    response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error fetching managers");
                    e.printStackTrace();
                }
                break;
            }

            // In doGet method, add this case for designations:
            case "getDesignations": {
                int deptId = Integer.parseInt(request.getParameter("deptId"));
                
                // Get designations based on department
                List<DesignationHelper> designations = designationService.getDesignationsByDepartment(deptId);
                
                // Convert to JSON and send response
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                
                Gson gson = new Gson();
                String json = gson.toJson(designations);
                
                PrintWriter out = response.getWriter();
                out.print(json);
                out.flush();
                break;
            }
            case "edit": {
                int userId = Integer.parseInt(request.getParameter("userId"));
                Users user = userService.getUserById(userId);
                UserDetails userDetails = userService.getUserDetailsById(userId);
                
                List<Roles> roles = roleService.getAllRoles();
                List<Departments> departments = departmentService.getAllDepartments();
                List<DesignationHelper> designations = designationService.getAllDesignations();
                List<UserDetails> managers = userService.getAllManagers();
                
                request.setAttribute("user", user);
                request.setAttribute("userDetails", userDetails);
                request.setAttribute("roles", roles);
                request.setAttribute("departments", departments);
                request.setAttribute("designations", designations);
                request.setAttribute("managers", managers);
                request.setAttribute("showUpdateModal", true);
                
                // Forward to the same page but with modal open
                List<UserDetails> users = userService.getAllUserDetails();
                request.setAttribute("users", users);
                
                request.getRequestDispatcher("WEB-INF/views/employeeViews/userView.jsp").forward(request, response);
                break;
            }

            case "viewDetails": {
                int userId = Integer.parseInt(request.getParameter("userId"));
                UserDetails userDetails = userService.getUserDetailsById(userId);
                
                request.setAttribute("userDetails", userDetails);
                request.getRequestDispatcher("WEB-INF/views/employeeViews/userDetails.jsp").forward(request, response);
                break;
            }

            
            
            	
            }
        }
    

	
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        switch (action) {
            case "add": {
                String firstName = request.getParameter("firstName");
                String lastName = request.getParameter("lastName");
                String email = request.getParameter("email");
                String plainPassword = request.getParameter("plainPassword");
                String contactNumber = request.getParameter("contactNumber");
                int roleId = Integer.parseInt(request.getParameter("roleId"));
                int departmentId = Integer.parseInt(request.getParameter("departmentId"));
                int designationId = Integer.parseInt(request.getParameter("designationId"));
                Date dateOfJoining = Date.valueOf(request.getParameter("dateOfJoining"));
                Date dateOfBirth = Date.valueOf(request.getParameter("dateOfBirth"));
                String address = request.getParameter("address");
                String aboutEmployee = request.getParameter("aboutEmployee");
                String status = request.getParameter("status");

	                int reportingManager = 0;
	                if (roleId != 1 && roleId != 2) {
	                    reportingManager = Integer.parseInt(request.getParameter("reportingManager"));
	                }

                Part filePart = request.getPart("profilePicture");
                String fileName = filePart.getSubmittedFileName();
                String uploadPath = getServletContext().getRealPath("") + File.separator + "images";
                File uploadDir = new File(uploadPath);
                if (!uploadDir.exists()) uploadDir.mkdir();
                filePart.write(uploadPath + File.separator + fileName);

                String hashedPassword = PasswordEncryptor.hashPassword(plainPassword);

                HttpSession session = request.getSession();
                UserDetails creator = (UserDetails) session.getAttribute("employee");
                String createdBy = creator.getFirstName() + " " + creator.getLastName();

                Users u = new Users();
                u.setFirstName(firstName);
                u.setLastName(lastName);
                u.setEmail(email);
                u.setHashPassword(hashedPassword);
                u.setContactNumber(contactNumber);
                u.setRoleId(roleId);
                u.setDepartmentId(departmentId);
                u.setDesignationId(designationId);
                u.setDateOfJoining(dateOfJoining);
                u.setDateOfBirth(dateOfBirth);
                u.setAddress(address);
                u.setProfilePicture(fileName);
                u.setReportingManager(reportingManager);
                u.setAboutEmployee(aboutEmployee);
                u.setCreatedBy(createdBy);
                u.setStatus(status);

                boolean success = userService.addUser(u);

                if (success) {
                    EmailSender.sendWelcomeEmail(email, plainPassword);
                    response.sendRedirect("UserServlet?action=view&message=User+created+successfully!");
                } else {
                    response.sendRedirect("UserServlet?action=view&message=Failed+to+create+user.");
                }
                break;
            }
            
            case "update": {
                try {
                    int userId = Integer.parseInt(request.getParameter("userId"));
                    String firstName = request.getParameter("firstName");
                    String lastName = request.getParameter("lastName");
                    String email = request.getParameter("email");
                    int roleId = Integer.parseInt(request.getParameter("roleId"));
                    int departmentId = Integer.parseInt(request.getParameter("departmentId"));
                    int designationId = Integer.parseInt(request.getParameter("designationId"));
                    String joiningDateStr = request.getParameter("dateOfJoining");
                    String birthDateStr = request.getParameter("dateOfBirth");

                    java.sql.Date sqlJoiningDate = java.sql.Date.valueOf(joiningDateStr);
                    java.sql.Date sqlBirthDate = java.sql.Date.valueOf(birthDateStr);

                    String contactNumber = request.getParameter("contactNumber");
                    String address = request.getParameter("address");
                    String aboutEmployee = request.getParameter("aboutEmployee");
                    String status = request.getParameter("status");

                    // Reporting Manager (optional)
                    String reportingManagerParam = request.getParameter("reportingManager");
                    int reportingManager = 0; // default to 0 if not provided

                    if (reportingManagerParam != null && !reportingManagerParam.isEmpty()) {
                        reportingManager = Integer.parseInt(reportingManagerParam);
                    }


                    // Audit info
                    UserDetails sessionUser = (UserDetails) request.getSession().getAttribute("employee");
                    String modifiedBy = sessionUser.getFirstName() + " " + sessionUser.getLastName();

                    // Profile picture upload
                    Part filePart = request.getPart("profilePicture");
                    String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
                    String uploadPath = getServletContext().getRealPath("/images/");
                    File uploadDir = new File(uploadPath);
                    if (!uploadDir.exists()) uploadDir.mkdirs();

                    String profilePicturePath = null;
                    if (fileName != null && !fileName.isEmpty()) {
                        String savedFilePath = uploadPath + userId + "_" + fileName;
                        filePart.write(savedFilePath);
                        profilePicturePath =  userId + "_" + fileName; // relative path for JSP
                    }


                    // Build updated user object
                    UserDetails updatedUser = new UserDetails();
                    updatedUser.setUserId(userId);
                    updatedUser.setFirstName(firstName);
                    updatedUser.setLastName(lastName);
                    updatedUser.setEmail(email);
                    updatedUser.setRoleId(roleId);
                    updatedUser.setDepartmentId(departmentId);
                    updatedUser.setDesignationId(designationId);
                    updatedUser.setDateOfJoining(sqlJoiningDate);
                    updatedUser.setDateOfBirth(sqlBirthDate);
                    updatedUser.setContactNumber(contactNumber);
                    updatedUser.setAddress(address);
                    updatedUser.setAboutEmployee(aboutEmployee);
                    updatedUser.setStatus(status);
                    updatedUser.setReportingManager(reportingManager);
                    updatedUser.setModifiedBy(modifiedBy);
                    updatedUser.setProfilePicture(profilePicturePath); // optional

                    boolean success = userService.updateUserDetails(updatedUser);

                    if (success) {
                        response.sendRedirect("UserServlet?action=view&message=User+updated+successfully");
                    } else {
                        response.sendRedirect("UserServlet?action=view&message=Failed+to+update+user");
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                    response.sendRedirect("UserServlet?action=view&message=Error+occurred+during+update");
                }
                break;
            }
        
            

            case "exportPdfSelected": {
                try {
                    String selectedIds = request.getParameter("selectedIds");
                    List<Integer> userIds = Arrays.stream(selectedIds.split(","))
                                                  .map(Integer::parseInt)
                                                  .collect(Collectors.toList());

                    List<UserDetails> selectedUsers = userService.getUsersByIds(userIds);

                    response.setContentType("application/pdf");
                    response.setHeader("Content-Disposition", "attachment; filename=selected_users.pdf");

                    Document document = new Document(PageSize.A4.rotate());
                    PdfWriter.getInstance(document, response.getOutputStream());
                    document.open();

                    // Title
                    Font titleFont = FontFactory.getFont(FontFactory.HELVETICA, 18, Font.BOLD, Color.BLUE);
                    Paragraph title = new Paragraph("Nexus HRMS – Selected Users Report", titleFont);
                    title.setAlignment(Element.ALIGN_CENTER);
                    document.add(title);
                    document.add(Chunk.NEWLINE);

                    // Table setup
                    String[] headers = { "Photo", "Name", "Email", "Role", "Department", "Designation", "Status" };
                    PdfPTable table = new PdfPTable(headers.length);
                    table.setWidthPercentage(100);
                    table.setSpacingBefore(10f);

                    // Header row
                    Font headerFont = FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD);
                    Color headerColor = new Color(230, 240, 255); // pastel blue

                    for (String header : headers) {
                        PdfPCell cell = new PdfPCell(new Phrase(header, headerFont));
                        cell.setBackgroundColor(headerColor);
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cell.setPadding(5f);
                        table.addCell(cell);
                    }

                    // Data rows
                    Font dataFont = FontFactory.getFont(FontFactory.HELVETICA, 11);
                    for (UserDetails user : selectedUsers) {
                        // Profile Image
                        String imagePath = getServletContext().getRealPath("/images/") + File.separator + user.getProfilePicture();
                        try {
                            Image profileImg = Image.getInstance(imagePath);
                            profileImg.scaleAbsolute(40f, 40f);
                            PdfPCell imgCell = new PdfPCell(profileImg);
                            imgCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                            imgCell.setPadding(5f);
                            table.addCell(imgCell);
                        } catch (Exception ex) {
                            PdfPCell placeholder = new PdfPCell(new Phrase("No Image", dataFont));
                            placeholder.setHorizontalAlignment(Element.ALIGN_CENTER);
                            placeholder.setPadding(5f);
                            table.addCell(placeholder);
                        }

                        // Text fields
                        table.addCell(new Phrase(user.getFirstName() + " " + user.getLastName(), dataFont));
                        table.addCell(new Phrase(user.getEmail(), dataFont));
                        table.addCell(new Phrase(user.getRoleName(), dataFont));
                        table.addCell(new Phrase(user.getDepartmentName(), dataFont));
                        table.addCell(new Phrase(user.getDesignationName(), dataFont));
                        table.addCell(new Phrase(user.getStatus(), dataFont));
                    }

                    document.add(table);
                    document.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            }




            case "exportExcelSelected": {
                try {
                    String selectedIds = request.getParameter("selectedIds");
                    List<Integer> userIds = Arrays.stream(selectedIds.split(","))
                                                  .map(Integer::parseInt)
                                                  .collect(Collectors.toList());

                    List<UserDetails> selectedUsers = userService.getUsersByIds(userIds);

                    response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
                    response.setHeader("Content-Disposition", "attachment; filename=selected_users.xlsx");

                    XSSFWorkbook workbook = new XSSFWorkbook();
                    XSSFSheet sheet = workbook.createSheet("Selected Users");

                    // Header style
                    CellStyle headerStyle = workbook.createCellStyle();
                    org.apache.poi.ss.usermodel.Font headerFont = workbook.createFont();
                    headerFont.setBold(true);
                    headerFont.setColor(IndexedColors.WHITE.getIndex());
                    headerStyle.setFont(headerFont);
                    headerStyle.setFillForegroundColor(IndexedColors.BLUE.getIndex());
                    headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

                    // Header row
                    String[] headers = { "Name", "Email", "Role", "Department", "Designation", "Status" };
                    Row headerRow = sheet.createRow(0);
                    for (int i = 0; i < headers.length; i++) {
                        Cell cell = headerRow.createCell(i);
                        cell.setCellValue(headers[i]);
                        cell.setCellStyle(headerStyle);
                    }

                    // Data rows
                    int rowNum = 1;
                    for (UserDetails user : selectedUsers) {
                        Row row = sheet.createRow(rowNum++);
                        row.createCell(0).setCellValue(user.getFirstName() + " " + user.getLastName());
                        row.createCell(1).setCellValue(user.getEmail());
                        row.createCell(2).setCellValue(user.getRoleName());
                        row.createCell(3).setCellValue(user.getDepartmentName());
                        row.createCell(4).setCellValue(user.getDesignationName());
                        row.createCell(5).setCellValue(user.getStatus());
                    }

                    // Auto-size columns
                    for (int i = 0; i < headers.length; i++) {
                        sheet.autoSizeColumn(i);
                    }

                    workbook.write(response.getOutputStream());
                    workbook.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            }


}
    }

}
