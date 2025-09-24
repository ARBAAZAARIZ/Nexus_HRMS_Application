<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="helper.employeeHelper.UserDetails" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>HRMS Navigation</title>
  <style>
    /* Modern Color Scheme */
    :root {
      --admin-primary: #2c3e50;
      --admin-secondary: #34495e;
      --admin-accent: #3498db;
      
      --manager-primary: #16a085;
      --manager-secondary: #1abc9c;
      --manager-accent: #27ae60;
      
       --employee-primary: #8e44ad;
      --employee-secondary: #9b59b6;
      --employee-accent: #2980b9;
      
      --text-light: #ecf0f1;
      --text-dark: #2c3e50;
      --hover-effect: rgba(255, 255, 255, 0.1);
      --shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
    }

    /* Sidebar Modernization */
    .main-sidebar {
      background: linear-gradient(135deg, var(--admin-primary), var(--admin-secondary)) !important;
    }

    /* Admin Theme */
    .admin-theme {
      background: linear-gradient(135deg, var(--admin-primary), var(--admin-secondary)) !important;
    }
    
    .admin-theme .brand-link {
      border-bottom: 2px solid var(--admin-accent);
    }
    
    .admin-theme .nav-item > .nav-link {
      color: var(--text-light) !important;
      border-left: 3px solid transparent;
      transition: all 0.3s ease;
    }
    
    .admin-theme .nav-item > .nav-link:hover {
      background: var(--hover-effect) !important;
      border-left-color: var(--admin-accent);
      transform: translateX(5px);
    }
    
    .admin-theme .nav-item > .nav-link.active {
      background: linear-gradient(135deg, var(--admin-accent), #2980b9) !important;
      border-left-color: #fff;
      box-shadow: var(--shadow);
    }

    /* Manager Theme */
    .manager-theme {
      background: linear-gradient(135deg, var(--manager-primary), var(--manager-secondary)) !important;
    }
    
    .manager-theme .brand-link {
      border-bottom: 2px solid var(--manager-accent);
    }
    
    .manager-theme .nav-item > .nav-link.active {
      background: linear-gradient(135deg, var(--manager-accent), #2ecc71) !important;
    }

   /* Employee Cards */
    .employee-cards {
      display: grid;
      grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));
      gap: 15px;
    }
    
    .employee-card {
      background: rgba(255, 255, 255, 0.1);
      border-radius: 8px;
      padding: 15px;
      text-align: center;
      transition: transform 0.3s;
    }
    
    .employee-card:hover {
      transform: translateY(-3px);
      background: rgba(255, 255, 255, 0.15);
    }
    
    .employee-avatar {
      width: 60px;
      height: 60px;
      border-radius: 50%;
      margin: 0 auto 10px;
      border: 2px solid white;
    }
    
    .employee-name {
      font-weight: bold;
      margin-bottom: 5px;
    }
    
    .employee-role {
      font-size: 12px;
      opacity: 0.8;
    }

    /* Common Modern Styles */
    .brand-link {
      padding: 15px 20px;
      transition: all 0.3s ease;
    }
    
    .brand-link:hover {
      transform: translateY(-2px);
    }
    
    .brand-image {
      box-shadow: 0 4px 8px rgba(0,0,0,0.2);
      transition: all 0.3s ease;
    }
    
    .brand-link:hover .brand-image {
      transform: rotate(10deg);
    }
    
    .nav-treeview {
      background: rgba(0, 0, 0, 0.1) !important;
      border-left: 3px solid var(--admin-accent);
      margin-left: 15px;
      border-radius: 0 0 8px 0;
    }
    
    .nav-treeview .nav-link {
      padding: 10px 15px 10px 30px !important;
      font-size: 14px;
      transition: all 0.2s ease;
    }
    
    .nav-treeview .nav-link:hover {
      background: rgba(255, 255, 255, 0.1) !important;
      padding-left: 35px !important;
    }
    
    .nav-icon {
      min-width: 25px;
      text-align: center;
      font-size: 18px;
      transition: all 0.3s ease;
    }
    
    .nav-link:hover .nav-icon {
      transform: scale(1.2);
    }
    
    .badge {
      font-weight: 500;
      padding: 4px 8px;
      border-radius: 12px;
    }
    
    /* Animation for menu items */
    @keyframes fadeIn {
      from { opacity: 0; transform: translateX(-20px); }
      to { opacity: 1; transform: translateX(0); }
    }
    
    .nav-item {
      animation: fadeIn 0.5s ease-out;
    }
    
    .nav-item:nth-child(1) { animation-delay: 0.1s; }
    .nav-item:nth-child(2) { animation-delay: 0.2s; }
    .nav-item:nth-child(3) { animation-delay: 0.3s; }
    .nav-item:nth-child(4) { animation-delay: 0.4s; }
    .nav-item:nth-child(5) { animation-delay: 0.5s; }
    
    /* Responsive adjustments */
    @media (max-width: 768px) {
      .brand-text {
        font-size: 16px;
      }
      
      .nav-link {
        padding: 12px 15px !important;
      }
      
      .nav-treeview .nav-link {
        padding: 8px 15px 8px 25px !important;
      }
    }
  </style>
</head>
<body>
<!-- Main Sidebar Container -->
<%
    HttpSession session1 = request.getSession(false);
    UserDetails employee = (UserDetails) session1.getAttribute("employee");
    String themeClass = "admin-theme";
    if (employee != null) {
        if ("manager".equalsIgnoreCase(employee.getRoleName())) {
            themeClass = "manager-theme";
        } else if (!"admin".equalsIgnoreCase(employee.getRoleName())) {
            themeClass = "employee-theme";
        }
    }
%>
<aside class="main-sidebar sidebar-dark-primary elevation-4 <%= themeClass %>">
  <!-- Brand Logo -->
  <a href="Home" class="brand-link">
    <img src="dist/img/AdminLTELogo.png" alt="HRMS Logo" class="brand-image img-circle elevation-3">
    <span class="brand-text font-weight-light">Nexus HRMS</span>
  </a>

  <!-- Sidebar -->
  <div class="sidebar">
    <nav class="mt-2">
      <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">

        <% if (employee != null && "admin".equalsIgnoreCase(employee.getRoleName())) { %>
        <!-- 🔐 Admin Sidebar -->
        <li class="nav-item">
          <a href="Home" class="nav-link active">
            <i class="nav-icon fas fa-tachometer-alt"></i>
            <p>Admin Dashboard <span class="right badge badge-light">Premium</span></p>
          </a>
        </li>
        
        <li class="nav-item">
          <a href="#" class="nav-link">
            <i class="nav-icon fas fa-users-cog"></i>
            <p>Employee Management <i class="fas fa-angle-left right"></i></p>
          </a>
          <ul class="nav nav-treeview">
            <li class="nav-item"><a href="DepartmentServlet?action=view" class="nav-link"><i class="fas fa-building nav-icon"></i><p>Departments</p></a></li>
            <li class="nav-item"><a href="DesignationServlet?action=view" class="nav-link"><i class="fas fa-briefcase nav-icon"></i><p>Designations</p></a></li>
            <li class="nav-item"><a href="RoleServlet?action=view" class="nav-link"><i class="fas fa-user-shield nav-icon"></i><p>Roles</p></a></li>
            <li class="nav-item"><a href="UserServlet?action=view" class="nav-link"><i class="fas fa-users nav-icon"></i><p>Employees</p></a></li>
            <li class="nav-item"><a href="UserDetailServlet" class="nav-link"><i class="fas fa-id-card nav-icon"></i><p>Employee Details</p></a></li>
          </ul>
        </li>
        
        <li class="nav-item">
          <a href="#" class="nav-link">
            <i class="nav-icon fas fa-graduation-cap"></i>
            <p>Training Management <i class="fas fa-angle-left right"></i></p>
          </a>
          <ul class="nav nav-treeview">
            <li class="nav-item"><a href="training" class="nav-link"><i class="fas fa-list nav-icon"></i><p>Training List</p></a></li>
            <li class="nav-item"><a href="trainer" class="nav-link"><i class="fas fa-chalkboard-teacher nav-icon"></i><p>Trainers</p></a></li>
            <li class="nav-item"><a href="training-type" class="nav-link"><i class="fas fa-tags nav-icon"></i><p>Training Types</p></a></li>
          </ul>
        </li>
        
         
        <li class="nav-item">
          <a href="#" class="nav-link">
            <i class="fas fa-solid fa-user-tie"></i>
            <p>Leaves <i class="fas fa-angle-left right"></i></p>
          </a>
          <ul class="nav nav-treeview">
            <li class="nav-item"><a href="MasterLeavesServlet?action=view" class="nav-link"><i class="far fa-circle nav-icon"></i><p>Add Leave Type</p></a></li>
            <li class="nav-item"><a href="DepartmentWiseLeaveServlet" class="nav-link"><i class="far fa-circle nav-icon"></i><p>Add Leaves</p></a></li>
            <li class="nav-item"><a href="DepartmentLeaveDetailsServlet" class="nav-link"><i class="far fa-circle nav-icon"></i><p>Department Leave Details</p></a></li>
            <li class="nav-item"><a href="LeaveSettingsServlet" class="nav-link"><i class="far fa-circle nav-icon"></i><p>Leave Settings</p></a></li>
          </ul>
          
        </li>
        
        <li class="nav-item">
          <a href="#" class="nav-link">
            <i class="fas fa-business-time"></i>
            <p>Payroll <i class="fas fa-angle-left right"></i></p>
          </a>
          <ul class="nav nav-treeview">
            <li class="nav-item"><a href="AddEmployeeSalary" class="nav-link"><i class="far fa-circle nav-icon"></i><p>Add Employee Salary</p></a></li>
            <li class="nav-item"><a href="salaryConfig" class="nav-link"><i class="far fa-circle nav-icon"></i><p>Master payroll</p></a></li>
            <li class="nav-item"><a href="EmployeeSalaryList" class="nav-link"><i class="far fa-circle nav-icon"></i><p>Employee Salary List</p></a></li>
            <li class="nav-item"><a href="GeneratePayslipPDFMonthly" class="nav-link"><i class="far fa-circle nav-icon"></i><p>Generate Payslip Monthly</p></a></li>
             <li class="nav-item"><a href="PayslipHistory" class="nav-link"><i class="far fa-circle nav-icon"></i><p>Transaction History</p></a></li>
          </ul>
        </li>
        
        <li class="nav-item">
          <a href="#" class="nav-link">
            <i class="nav-icon fas fa-chart-bar"></i>
            <p>
              Reports
              <i class="fas fa-angle-left right"></i>
            </p>
          </a>
          <ul class="nav nav-treeview">
            <li class="nav-item"><a href="BbEmployeeReportController" class="nav-link"><i class="far fa-circle nav-icon"></i><p>Employee Report</p></a></li>
            <li class="nav-item"><a href="BbAttendanceReportController" class="nav-link"><i class="far fa-circle nav-icon"></i><p>Attendance Report</p></a></li>
            <li class="nav-item"><a href="BbLeaveReportController" class="nav-link"><i class="far fa-circle nav-icon"></i><p>Leave Report</p></a></li>
            <li class="nav-item"><a href="BbPayslipReportServlet" class="nav-link"><i class="far fa-circle nav-icon"></i><p>Payslip Report</p></a></li>
            <li class="nav-item"><a href="BbProjectReportController" class="nav-link"><i class="far fa-circle nav-icon"></i><p>Project Report</p></a></li>
            <li class="nav-item"><a href="BbTaskReportController" class="nav-link"><i class="far fa-circle nav-icon"></i><p>Task Report</p></a></li>
          </ul>
        </li>
        
        
        
        <li class="nav-item">
          <a href="#" class="nav-link">
            <i class="nav-icon fas fa-chart-bar"></i>
            <p>
              Attendance
              <i class="fas fa-angle-left right"></i>
            </p>
          </a>
         <ul class="nav nav-treeview">
              <li class="nav-item"><a href="todaysAttendanceServlet" class="nav-link"><i class="fas fa-business-time nav-icon"></i><p>Attendance</p></a>
              </li>
          </ul>
        </li>
        
        
                <!-- Master Document -->
        <li class="nav-item">
          <a href="#" class="nav-link">
            <i class="nav-icon fas fa-file-alt"></i>
            <p>Master Document <i class="fas fa-angle-left right"></i></p>
          </a>
          <ul class="nav nav-treeview">

            <!-- Add Master Document -->
            <li class="nav-item">
              <a href="#" class="nav-link">
                <p>Add Master Document <i class="fas fa-angle-left right"></i></p>
              </a>
              <ul class="nav nav-treeview">
                <li class="nav-item">
                  <a href="AddAdminDocumentName" class="nav-link">
                    <p>Add Document Name (Admin)</p>
                  </a>
                </li>
                <li class="nav-item">
                  <a href="AddEmpDocumentName" class="nav-link">
                    <p>Add Document Name (Employee)</p>
                  </a>
                </li>
              </ul>
            </li>

            <!-- Master Document List -->
            <li class="nav-item">
              <a href="#" class="nav-link">
                <p>Master Document List <i class="fas fa-angle-left right"></i></p>
              </a>
              <ul class="nav nav-treeview">
                <li class="nav-item">
                  <a href="AdminDocumentsList" class="nav-link">
                    <p>Admin Document List</p>
                  </a>
                </li>
                <li class="nav-item">
                  <a href="EmployeeDocumentsList" class="nav-link">
                    <p>Employee Document List</p>
                  </a>
                </li>
              </ul>
            </li>

          </ul>
        </li>
        
                <li class="nav-item">
  <a href="#" class="nav-link">
    <i class="nav-icon fas fa-upload"></i>
    <p>Documents <i class="fas fa-angle-left right"></i></p>
  </a>
  <ul class="nav nav-treeview">

    <li class="nav-item">
      <a href="UploadDocumentsAdmin" class="nav-link">
        <p>Upload Document</p>
      </a>
    </li>

    <!-- Uploaded Document List (with Admin & Employee) -->
    <li class="nav-item">
      <a href="#" class="nav-link">
        <p>Uploaded Document List <i class="fas fa-angle-left right"></i></p>
      </a>
      <ul class="nav nav-treeview">
        <li class="nav-item">
          <a href="UploadedAdminDocumentList" class="nav-link">
            <p>Admin Document</p>
          </a>
        </li>
        <li class="nav-item">
          <a href="UploadedEmployeeDocumentList" class="nav-link">
            <p>Employee Document</p>
          </a>
        </li>
      </ul>
    </li>

  </ul>
</li>

<li class="nav-item">
  <a href="PromotionController?action=list" class="nav-link">
    <i class="nav-icon fas fa-arrow-up"></i>
    <p>Promotion</p>
  </a>
</li>
<li class="nav-item">
  <a href="ResignationController?action=list" class="nav-link">
    <i class="nav-icon fas fa-user-minus"></i>
    <p>Resignation</p>
  </a>
</li>


<li class="nav-item">
<a href="TerminationController?action=list" class="nav-link">

    <i class="nav-icon fas fa-user-slash"></i>
    <p>Termination</p>
  </a>
</li>


 <li class="nav-item">
          <a href="#" class="nav-link">
            <i class="fas fa-solid fa-user-tie"></i>
            <p>Event <i class="fas fa-angle-left right"></i></p>
          </a>
          <ul class="nav nav-treeview">
            <li class="nav-item"><a href="JC_EventServlet" class="nav-link"><i class="far fa-circle nav-icon"></i><p>Add Event</p></a></li>
            <li class="nav-item"><a href="event-types" class="nav-link"><i class="far fa-circle nav-icon"></i><p>Add Master Event</p></a></li>
            <li class="nav-item"><a href="EventServlets_1" class="nav-link"><i class="far fa-circle nav-icon"></i><p>Event List</p></a></li>
          </ul>
        </li>
        
        
        <li class="nav-item">
          <a href="${pageContext.request.contextPath}/Admin_AssignedTicket?action=view" class="nav-link">
            <i class="nav-icon fas fa-life-ring"></i>
            <p>Help & Support</p>
          </a>
        </li>

        <% } else if (employee != null && "manager".equalsIgnoreCase(employee.getRoleName())) { %>
        <!-- 🎯 Manager Sidebar -->
        <li class="nav-item">
          <a href="manager-dashboard.jsp" class="nav-link active">
            <i class="nav-icon fas fa-tachometer-alt"></i>
            <p>Manager Dashboard <span class="right badge badge-info">Pro</span></p>
          </a>
        </li>
        
        
         <li class="nav-item">
          <a href="#" class="nav-link">
            <i class="nav-icon fas fa-table"></i>
            <p>Leaves<i class="fas fa-angle-left right"></i></p>
          </a>
          <ul class="nav nav-treeview">
            <li class="nav-item"><a href="LeaveApprovalServlet" class="nav-link"><i class="far fa-circle nav-icon"></i><p>Leave Approvals</p></a></li>
            <li class="nav-item"><a href="LeaveAllocationServlet" class="nav-link"><i class="far fa-circle nav-icon"></i><p>Leave Allocations</p></a></li>
            <li class="nav-item"><a href="ManagerLeaveStatusServlet" class="nav-link"><i class="far fa-circle nav-icon"></i><p>Leave History</p></a></li>
          </ul>
        </li>
        
        <li class="nav-item">
          <a href="#" class="nav-link">
            <i class="nav-icon fas fa-users"></i>
            <p>Attendance <i class="fas fa-angle-left right"></i></p>
          </a>
          <ul class="nav nav-treeview">
            <li class="nav-item"><a href="managerTimeSheetServlet" class="nav-link"><i class="fas fa-user-friends nav-icon"></i><p>Attendance</p></a></li>
         
          </ul>
        </li>
        
        <li class="nav-item">
          <a href="#" class="nav-link">
            <i class="nav-icon fas fa-graduation-cap"></i>
            <p>Training <i class="fas fa-angle-left right"></i></p>
          </a>
          <ul class="nav nav-treeview">
            <li class="nav-item"><a href="training-type.jsp" class="nav-link"><i class="fas fa-tags nav-icon"></i><p>Training Types</p></a></li>
            <li class="nav-item"><a href="trainer-list.jsp" class="nav-link"><i class="fas fa-chalkboard-teacher nav-icon"></i><p>Trainers</p></a></li>
            <li class="nav-item"><a href="training-list.jsp" class="nav-link"><i class="fas fa-list nav-icon"></i><p>Training List</p></a></li>
          </ul>
        </li>
        
         <li class="nav-item">
          <a href="#" class="nav-link">
            <i class="fas fa-solid fa-user-tie"></i>
            <p>Event <i class="fas fa-angle-left right"></i></p>
          </a>
          <ul class="nav nav-treeview">
            <li class="nav-item"><a href="JC_EventServlet" class="nav-link"><i class="far fa-circle nav-icon"></i><p>Add Event</p></a></li>
            <li class="nav-item"><a href="event-types" class="nav-link"><i class="far fa-circle nav-icon"></i><p>Add Master Event</p></a></li>
            <li class="nav-item"><a href="EventServlets_1" class="nav-link"><i class="far fa-circle nav-icon"></i><p>Event List</p></a></li>
          </ul>
        </li>
        
        <!-- Help & Support -->
        <li class="nav-item">
          <a href="${pageContext.request.contextPath}/Manager_AssignTicket?action=view" class="nav-link">
            <i class="nav-icon fas fa-life-ring"></i>
            <p>Help & Support</p>
          </a>
        </li>

        <% } else if (employee != null) { %>
        <!-- 👤 Employee Sidebar -->
        <li class="nav-item">
          <a href="Home" class="nav-link active">
            <i class="nav-icon fas fa-tachometer-alt"></i>
            <p>My Dashboard <span class="right badge badge-success">You</span></p>
          </a>
        </li>
        
        <li class="nav-item">
          <a href="UserDetailServlet" class="nav-link">
            <i class="nav-icon fas fa-user"></i>
            <p>My Profile</p>
          </a>
        </li>
        
        <li class="nav-item">                                                     
          <a href="#" class="nav-link">
            <i class="nav-icon fas fa-graduation-cap"></i>
            <p>My Training <i class="fas fa-angle-left right"></i></p>
          </a>
          <ul class="nav nav-treeview">
            <li class="nav-item"><a href="EmployeeTrainingProgress" class="nav-link"><i class="fas fa-list nav-icon"></i><p> Training Progress</p></a></li>
          </ul>
        </li>
        
        
        
        
        <li class="nav-item">
          <a href="attendanceServlet" class="nav-link">
            <i class="nav-icon fas fa-calendar-check"></i>
            <p>Attendance</p>
          </a>
        </li>
        
        <li class="nav-item">
          <a href="#" class="nav-link">
            <i class="nav-icon fas fa-table"></i>
            <p>Leave<i class="fas fa-angle-left right"></i></p>
          </a>
          <ul class="nav nav-treeview">
            <li class="nav-item"><a href="ApplyLeaveServlet" class="nav-link"><i class="far fa-circle nav-icon"></i><p>Apply Leave</p></a></li>
            </ul>
        </li>
        
        <li class="nav-item">
          <a href="#" class="nav-link">
            <i class="nav-icon fas fa-file-alt"></i>
            <p>Documents <i class="fas fa-angle-left right"></i></p>
          </a>
          <ul class="nav nav-treeview">
            <li class="nav-item">
              <a href="CompanyLetters" class="nav-link">
                <p>Company Letters</p>
              </a>
            </li>
            <li class="nav-item">
              <a href="MyDocuments" class="nav-link">
                <p>My Documents</p>
              </a>
            </li>
            <li class="nav-item">
              <a href="UploadDocumentsEmp" class="nav-link">
                <p>Upload Documents</p>
              </a>
            </li>
          </ul>
        </li>
        
        
         <li class="nav-item">
          <a href="#" class="nav-link">
            <i class="fas fa-solid fa-user-tie"></i>
            <p>Event <i class="fas fa-angle-left right"></i></p>
          </a>
          <ul class="nav nav-treeview">
<li class="nav-item"><a href="${pageContext.request.contextPath}/JC_EventServlet?action=view" class="nav-link">
            <i class="far fa-circle nav-icon"></i><p>Calendar</p></a></li>          
            </ul>
        </li>
        
        
        <!-- Help & Support -->
        <li class="nav-item has-treeview">
          <a href="#" class="nav-link">
            <i class="nav-icon fas fa-life-ring"></i>
            <p>Help & Support<i class="right fas fa-angle-left"></i></p>
          </a>
          <ul class="nav nav-treeview">
            <li class="nav-item">
              <a href="${pageContext.request.contextPath}/RaisedTicket?action=view" class="nav-link">
                <i class="far fa-circle nav-icon"></i>
                <p>Raised New Tickets</p>
              </a>
            </li>
          </ul>
          <ul class="nav nav-treeview">
            <li class="nav-item">
              <a href="${pageContext.request.contextPath}/MyTickets?action=view" class="nav-link">
                <i class="far fa-circle nav-icon"></i>
                <p>My Tickets</p>
              </a>
            </li>
          </ul>
          <ul class="nav nav-treeview">
            <li class="nav-item">
              <a href="${pageContext.request.contextPath}/EmployeeTicketAction?action=view" class="nav-link">
                <i class="far fa-circle nav-icon"></i>
                <p>Employee Solution</p>
              </a>
            </li>
          </ul>
          
        </li>
        
        
        <% } %>

      </ul>
    </nav>
  </div>
</aside>
</body>
</html>