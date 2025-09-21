<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sidebar</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .sidebar {
            height: 100vh;
            width: 250px;
            
            top: 0;
            left: 0;
            background-color: #f8f9fa;
            padding-top: 20px;
            border-right: 1px solid #dee2e6;
        }
        .sidebar a {
            padding: 10px 20px;
            display: block;
            color: #333;
            text-decoration: none;
        }
        .sidebar a:hover {
            background-color: #e2e6ea;
            color: #000;
        }
    </style>
</head>
<body>
    <div class="sidebar">
        <h4 class="text-center">MyApp</h4>

        <a href="DepartmentServlet?action=view">add departments</a>
        <br>
         <a href="DesignationServlet?action=view">aad designation</a>

		<br>
         <a href="RoleServlet?action=view">add roles</a>
         
         <br>
         <a href="UserServlet?action=view">add Employees</a>
        
    </div>
</body>
</html>
