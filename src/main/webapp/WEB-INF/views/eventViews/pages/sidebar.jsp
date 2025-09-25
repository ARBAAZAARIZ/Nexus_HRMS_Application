<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="helper.employeeHelper.UserDetails" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
</head>
<body>
<!-- Main Sidebar Container -->
<%
    HttpSession session1 = request.getSession(false);
    UserDetails employee = (UserDetails) session1.getAttribute("employee");
%>
<aside class="main-sidebar sidebar-dark-primary elevation-4">
  <!-- Brand Logo -->
  <a href="index3.html" class="brand-link">
    <img src="dist/img/AdminLTELogo.png" alt="AdminLTE Logo" class="brand-image img-circle elevation-3" style="opacity: .8">
    <span class="brand-text font-weight-light">HRMS</span>
  </a>

  <!-- Sidebar -->
  <div class="sidebar">
    <nav class="mt-2">
      <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">

        <% if (employee != null && "admin".equalsIgnoreCase(employee.getRoleName())) { %>
        <!-- 🔐 Admin Sidebar -->
        <li class="nav-item menu-open">
          <a href="#" class="nav-link active bg-success">
            <i class="nav-icon fas fa-tachometer-alt"></i>
            <p>Admin Dashboard <span class="right badge badge-danger">New</span></p>
          </a>
        </li>
        <li class="nav-item">
          <a href="pages/widgets.html" class="nav-link">
            <i class="nav-icon fas fa-th"></i>
            <p> blank </p>
          </a>
        </li>
        <li class="nav-item">
          <a href="#" class="nav-link">
            <i class="fas fa-solid fa-user-tie"></i>
            <p>Employees <i class="fas fa-angle-left right"></i></p>
          </a>
          <ul class="nav nav-treeview">
            <li class="nav-item"><a href="DepartmentServlet?action=view" class="nav-link"><i class="far fa-circle nav-icon"></i><p>View Department's</p></a></li>
            <li class="nav-item"><a href="DesignationServlet?action=view" class="nav-link"><i class="far fa-circle nav-icon"></i><p>View Designation's</p></a></li>
            <li class="nav-item"><a href="RoleServlet?action=view" class="nav-link"><i class="far fa-circle nav-icon"></i><p>View Role's</p></a></li>
            <li class="nav-item"><a href="UserServlet?action=view" class="nav-link"><i class="far fa-circle nav-icon"></i><p>View Role's</p></a></li>
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
            <i class="fas fa-solid fa-user-tie"></i>
            <p>Event <i class="fas fa-angle-left right"></i></p>
          </a>
          <ul class="nav nav-treeview">
            <li class="nav-item"><a href="JC_EventServlet?action=view" class="nav-link"><i class="far fa-circle nav-icon"></i><p>Add Event</p></a></li>
            <li class="nav-item"><a href="event-types" class="nav-link"><i class="far fa-circle nav-icon"></i><p>Add Master Event</p></a></li>
            <li class="nav-item"><a href="EventServlets_1" class="nav-link"><i class="far fa-circle nav-icon"></i><p>Event List</p></a></li>
          </ul>
        </li>
        

        <% } else if (employee != null && "manager".equalsIgnoreCase(employee.getRoleName())) { %>
        <!-- 🎯 Manager Sidebar -->
        <li class="nav-item menu-open">
          <a href="#" class="nav-link active bg-warning">
            <i class="nav-icon fas fa-tachometer-alt"></i>
            <p>Manager Dashboard</p>
          </a>
        </li>
        <li class="nav-item">
          <a href="pages/widgets.html" class="nav-link">
            <i class="nav-icon fas fa-th"></i>
            <p>Widgets <span class="right badge badge-info">New</span></p>
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
        
        
        
        
        <li class="nav-item">
          <a href="#" class="nav-link">
            <i class="nav-icon fas fa-table"></i>
            <p>Training <i class="fas fa-angle-left right"></i></p>
          </a>
          <ul class="nav nav-treeview">
            <li class="nav-item"><a href="pages/tables/simple.html" class="nav-link"><i class="far fa-circle nav-icon"></i><p>Training Type</p></a></li>
            <li class="nav-item"><a href="pages/tables/data.html" class="nav-link"><i class="far fa-circle nav-icon"></i><p>Trainer List</p></a></li>
            <li class="nav-item"><a href="pages/tables/jsgrid.html" class="nav-link"><i class="far fa-circle nav-icon"></i><p>Training List</p></a></li>
          </ul>
        </li>
        
         
        

        <% } else if (employee != null) { %>
        <!-- 👤 Employee Sidebar -->
        <li class="nav-item menu-open">
          <a href="#" class="nav-link active bg-primary">
            <i class="nav-icon fas fa-tachometer-alt"></i>
            <p>Employee Dashboard</p>
          </a>
        </li>
        <li class="nav-item">
          <a href="pages/widgets.html" class="nav-link">
            <i class="nav-icon fas fa-th"></i>
            <p>Widgets <span class="right badge badge-success">New</span></p>
          </a>
        </li>
        
        <li class="nav-item">
          <a href="#" class="nav-link">
            <i class="nav-icon fas fa-table"></i>
            <p>Leave<i class="fas fa-angle-left right"></i></p>
          </a>
          <ul class="nav nav-treeview">
            <li class="nav-item"><a href="ApplyLeaveServlet" class="nav-link"><i class="far fa-circle nav-icon"></i><p>Apply Leave</p></a></li>
            <li class="nav-item"><a href="pages/tables/data.html" class="nav-link"><i class="far fa-circle nav-icon"></i><p>Leave Details</p></a></li>
          </ul>
        </li>
        
        <li class="nav-item">
          <a href="#" class="nav-link">
            <i class="nav-icon fas fa-table"></i>
            <p>Training <i class="fas fa-angle-left right"></i></p>
          </a>
          <ul class="nav nav-treeview">
            <li class="nav-item"><a href="pages/tables/simple.html" class="nav-link"><i class="far fa-circle nav-icon"></i><p>Training Type</p></a></li>
            <li class="nav-item"><a href="pages/tables/data.html" class="nav-link"><i class="far fa-circle nav-icon"></i><p>Trainer List</p></a></li>
            <li class="nav-item"><a href="pages/tables/jsgrid.html" class="nav-link"><i class="far fa-circle nav-icon"></i><p>Training List</p></a></li>
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
        
        <% } %>

      </ul>
    </nav>
  </div>
</aside>
</body>
</html>
