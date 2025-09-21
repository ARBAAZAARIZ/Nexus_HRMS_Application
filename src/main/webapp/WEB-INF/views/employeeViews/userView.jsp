<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>User Management | Dashboard</title>

  <!-- Google Font: Source Sans Pro -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&amp;display=fallback">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="plugins/fontawesome-free/css/all.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="../../../code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
  <!-- Tempusdominus Bootstrap 4 -->
  <link rel="stylesheet" href="plugins/tempusdominus-bootstrap-4/css/tempusdominus-bootstrap-4.min.css">
  <!-- iCheck -->
  <link rel="stylesheet" href="plugins/icheck-bootstrap/icheck-bootstrap.min.css">
  <!-- JQVMap -->
  <link rel="stylesheet" href="plugins/jqvmap/jqvmap.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="dist/css/adminlte.min2167.css?v=3.2.0">
  <!-- overlayScrollbars -->
  <link rel="stylesheet" href="plugins/overlayScrollbars/css/OverlayScrollbars.min.css">
  <!-- Daterange picker -->
  <link rel="stylesheet" href="plugins/daterangepicker/daterangepicker.css">
  <!-- summernote -->
  
   <!-- DataTables -->
  <link rel="stylesheet" href="plugins/datatables-bs4/css/dataTables.bootstrap4.min.css">
  <link rel="stylesheet" href="plugins/datatables-responsive/css/responsive.bootstrap4.min.css">
  <link rel="stylesheet" href="plugins/datatables-buttons/css/buttons.bootstrap4.min.css">
  
  <link rel="stylesheet" href="plugins/summernote/summernote-bs4.min.css">
<script data-cfasync="false" nonce="06cb1374-3a81-4a88-aebe-16de25f6e552">try{(function(w,d){!function(j,k,l,m){if(j.zaraz)console.error("zaraz is loaded twice");else{j[l]=j[l]||{};j[l].executed=[];j.zaraz={deferred:[],listeners:[]};j.zaraz._v="5870";j.zaraz._n="06cb1374-3a81-4a88-aebe-16de25f6e552";j.zaraz.q=[];j.zaraz._f=function(n){return async function(){var o=Array.prototype.slice.call(arguments);j.zaraz.q.push({m:n,a:o})}};for(const p of["track","set","debug"])j.zaraz[p]=j.zaraz._f(p);j.zaraz.init=()=>{var q=k.getElementsByTagName(m)[0],r=k.createElement(m),s=k.getElementsByTagName("title")[0];s&&(j[l].t=k.getElementsByTagName("title")[0].text);j[l].x=Math.random();j[l].w=j.screen.width;j[l].h=j.screen.height;j[l].j=j.innerHeight;j[l].e=j.innerWidth;j[l].l=j.location.href;j[l].r=k.referrer;j[l].k=j.screen.colorDepth;j[l].n=k.characterSet;j[l].o=(new Date).getTimezoneOffset();if(j.dataLayer)for(const t of Object.entries(Object.entries(dataLayer).reduce((u,v)=>({...u[1],...v[1]}),{})))zaraz.set(t[0],t[1],{scope:"page"});j[l].q=[];for(;j.zaraz.q.length;){const w=j.zaraz.q.shift();j[l].q.push(w)}r.defer=!0;for(const x of[localStorage,sessionStorage])Object.keys(x||{}).filter(z=>z.startsWith("_zaraz_")).forEach(y=>{try{j[l]["z_"+y.slice(7)]=JSON.parse(x.getItem(y))}catch{j[l]["z_"+y.slice(7)]=x.getItem(y)}});r.referrerPolicy="origin";r.src="../../cdn-cgi/zaraz/sd0d9.js?z="+btoa(encodeURIComponent(JSON.stringify(j[l])));q.parentNode.insertBefore(r,q)};["complete","interactive"].includes(k.readyState)?zaraz.init():j.addEventListener("DOMContentLoaded",zaraz.init)}}(w,d,"zarazData","script");window.zaraz._p=async bs=>new Promise(bt=>{if(bs){bs.e&&bs.e.forEach(bu=>{try{const bv=d.querySelector("script[nonce]"),bw=bv?.nonce||bv?.getAttribute("nonce"),bx=d.createElement("script");bw&&(bx.nonce=bw);bx.innerHTML=bu;bx.onload=()=>{d.head.removeChild(bx)};d.head.appendChild(bx)}catch(by){console.error(`Error executing script: ${bu}\n`,by)}});Promise.allSettled((bs.f||[]).map(bz=>fetch(bz[0],bz[1])))}bt()});zaraz._p({"e":["(function(w,d){})(window,document)"]});})(window,document)}catch(e){throw fetch("/cdn-cgi/zaraz/t"),e;};</script>

<style>
    /* Custom Styles for Employee Management System */
    :root {
      --primary-color: #3c8dbc;
      --secondary-color: #6c757d;
      --success-color: #28a745;
      --danger-color: #dc3545;
      --warning-color: #ffc107;
      --info-color: #17a2b8;
      --light-color: #f8f9fa;
      --dark-color: #343a40;
    }
    
    body {
      font-family: 'Source Sans Pro', sans-serif;
      background-color: #f4f6f9;
      color: #333;
    }
    
    .main-container {
      min-height: 100vh;
    }
    
    /* Card Styling */
    .card {
      box-shadow: 0 4px 8px rgba(0,0,0,0.1);
      border: none;
      border-radius: 8px;
      margin-bottom: 20px;
    }
    
    .card-header {
      background: linear-gradient(135deg, var(--primary-color), #2d7ca9);
      color: white;
      border-radius: 8px 8px 0 0 !important;
      padding: 15px 20px;
    }
    
    .card-title {
      font-weight: 600;
      margin: 0;
    }
    
    /* Table Styling */
    .table {
      border-collapse: separate;
      border-spacing: 0;
      width: 100%;
    }
    
    .table th {
      background: linear-gradient(135deg, #f8f9fa, #e9ecef);
      color: var(--dark-color);
      font-weight: 600;
      padding: 12px 15px;
      border-bottom: 2px solid #dee2e6;
    }
    
    .table td {
      padding: 12px 15px;
      vertical-align: middle;
      border-bottom: 1px solid #eee;
    }
    
    .table tr:hover {
      background-color: rgba(60, 141, 188, 0.05);
      transition: background-color 0.2s ease;
    }
    
    /* Profile Picture */
    .profile-pic {
      width: 45px;
      height: 45px;
      object-fit: cover;
      border-radius: 50%;
      border: 2px solid #fff;
      box-shadow: 0 2px 4px rgba(0,0,0,0.1);
    }
    
    /* Badge Styling */
    .badge {
      font-size: 12px;
      padding: 6px 10px;
      border-radius: 20px;
      font-weight: 500;
    }
    
    .badge-success {
      background: linear-gradient(135deg, var(--success-color), #218838);
    }
    
    .badge-danger {
      background: linear-gradient(135deg, var(--danger-color), #c82333);
    }
    
    /* Button Styling */
    .btn {
      border-radius: 6px;
      font-weight: 500;
      padding: 8px 16px;
      transition: all 0.3s ease;
      border: none;
    }
    
    .btn-primary {
      background: linear-gradient(135deg, var(--primary-color), #2d7ca9);
      border: none;
    }
    
    .btn-primary:hover {
      transform: translateY(-2px);
      box-shadow: 0 4px 8px rgba(60, 141, 188, 0.3);
    }
    
    .btn-success {
      background: linear-gradient(135deg, var(--success-color), #218838);
      border: none;
    }
    
    .btn-danger {
      background: linear-gradient(135deg, var(--danger-color), #c82333);
      border: none;
    }
    
    .btn-warning {
      background: linear-gradient(135deg, var(--warning-color), #e0a800);
      border: none;
      color: #212529;
    }
    
    .btn-outline-primary {
      border: 2px solid var(--primary-color);
      color: var(--primary-color);
      background: transparent;
    }
    
    .btn-outline-primary:hover {
      background: var(--primary-color);
      color: white;
      transform: translateY(-2px);
    }
    
    /* Modal Styling */
    .modal-content {
      border-radius: 12px;
      border: none;
      box-shadow: 0 10px 30px rgba(0,0,0,0.2);
    }
    
    .modal-header {
      background: linear-gradient(135deg, var(--primary-color), #2d7ca9);
      color: white;
      border-radius: 12px 12px 0 0;
      padding: 20px;
    }
    
    .modal-title {
      font-weight: 600;
      margin: 0;
    }
    
    .modal-body {
      padding: 25px;
    }
    
    .modal-footer {
      padding: 20px;
      border-top: 1px solid #eee;
    }
    
    /* Form Styling */
    .form-control {
      border-radius: 6px;
      border: 2px solid #e9ecef;
      padding: 10px 15px;
      transition: all 0.3s ease;
    }
    
    .form-control:focus {
      border-color: var(--primary-color);
      box-shadow: 0 0 0 0.2rem rgba(60, 141, 188, 0.25);
    }
    
    .form-label {
      font-weight: 600;
      color: var(--dark-color);
      margin-bottom: 8px;
    }
    
    /* Action Buttons */
    .action-buttons {
      display: flex;
      gap: 8px;
      flex-wrap: nowrap;
    }
    
    .action-buttons .btn {
      padding: 6px 12px;
      font-size: 14px;
    }
    
    /* Breadcrumb Styling */
    .breadcrumb {
      background: transparent;
      padding: 0;
      margin: 0;
    }
    
    /* Alert Styling */
    .alert {
      border-radius: 8px;
      border: none;
      box-shadow: 0 2px 4px rgba(0,0,0,0.1);
    }
    
    /* Table Responsive */
    .table-responsive {
      border-radius: 8px;
      overflow: hidden;
    }
    
    /* Custom Scrollbar */
    ::-webkit-scrollbar {
      width: 8px;
      height: 8px;
    }
    
    ::-webkit-scrollbar-track {
      background: #f1f1f1;
      border-radius: 10px;
    }
    
    ::-webkit-scrollbar-thumb {
      background: var(--primary-color);
      border-radius: 10px;
    }
    
    ::-webkit-scrollbar-thumb:hover {
      background: #2d7ca9;
    }
    
    /* Hover Effects */
    .btn, .card, .table tr {
      transition: all 0.3s ease;
    }
    
    .btn:hover {
      transform: translateY(-1px);
    }
    
    .card:hover {
      box-shadow: 0 6px 15px rgba(0,0,0,0.15);
    }
    
    /* Loading Animation */
    @keyframes fadeIn {
      from { opacity: 0; transform: translateY(20px); }
      to { opacity: 1; transform: translateY(0); }
    }
    
    .card, .modal-content {
      animation: fadeIn 0.5s ease-out;
    }
    
    /* Status Indicators */
    .status-indicator {
      display: inline-block;
      width: 10px;
      height: 10px;
      border-radius: 50%;
      margin-right: 8px;
    }
    
    .status-active {
      background-color: var(--success-color);
    }
    
    .status-inactive {
      background-color: var(--danger-color);
    }
    
    /* Custom Utilities */
    .text-gradient {
      background: linear-gradient(135deg, var(--primary-color), #2d7ca9);
      -webkit-background-clip: text;
      -webkit-text-fill-color: transparent;
      background-clip: text;
    }
    
    .shadow-custom {
      box-shadow: 0 4px 15px rgba(0,0,0,0.1) !important;
    }
    
    /* Responsive Design */
    @media (max-width: 768px) {
      .card-header {
        padding: 12px 15px;
      }
      
      .table th, .table td {
        padding: 8px 10px;
        font-size: 14px;
      }
      
      .action-buttons {
        flex-direction: column;
        gap: 5px;
      }
      
      .modal-body {
        padding: 15px;
      }
      
      .profile-pic {
        width: 35px;
        height: 35px;
      }
    }
    
    @media (max-width: 576px) {
      .btn {
        padding: 6px 12px;
        font-size: 14px;
      }
      
      .modal-dialog {
        margin: 10px;
      }
    }
  /* Add these new styles to fix the overflow issue */
    .card-body {
      overflow-x: auto;
      max-height: 70vh;
    }
    
    .table {
      min-width: 100%;
      width: auto;
    }
    
    .card-body::-webkit-scrollbar {
      width: 8px;
      height: 8px;
    }
    
    .card-body::-webkit-scrollbar-track {
      background: #f1f1f1;
      border-radius: 10px;
    }
    
    .card-body::-webkit-scrollbar-thumb {
      background: var(--primary-color);
      border-radius: 10px;
    }
    
    .card-body::-webkit-scrollbar-thumb:hover {
      background: #2d7ca9;
    }
    
    @media (max-width: 768px) {
      .card-body {
        padding: 10px;
      }
      
      .table {
        font-size: 14px;
      }
      
      .action-buttons {
        flex-direction: column;
      }
    }
  </style>
  
  


  


</head>
<body class="hold-transition sidebar-mini layout-fixed">

<jsp:include page="../../../navbar.jsp"></jsp:include>

<jsp:include page="../../../sidebar.jsp"></jsp:include>



<div class="wrapper">
	<div class="content-wrapper">
		 <!-- Content Header (Page header) -->
    <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1>DataTables</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Home</a></li>
              <li class="breadcrumb-item active">DataTables</li>
            </ol>
          </div>
        </div>
      </div><!-- /.container-fluid -->
    </section>
    
    
    <!-- Main content -->
    <section class="content">
      <div class="container-fluid">
        <div class="row">
          <div class="col-12">
          
          <form method="post" action="UserServlet" id="exportForm">
  <input type="hidden" name="action" value="exportPdfSelected">
  <input type="hidden" name="selectedIds" id="selectedIdsField">
  <div class="d-flex justify-content-end mb-2">
    <button type="button" class="btn btn-sm btn-danger" onclick="submitSelected('pdf')">Export as PDF</button>
    <button type="button" class="btn btn-sm btn-success ml-2" onclick="submitSelected('excel')">Export as Excel</button>
  </div>
</form>
          
          
           <button type="button" class="btn btn-default btn-success text-light" data-toggle="modal" data-target="#modal-default">
                  + Add Employee
                </button>
                <br>
               <br>
          
         <div class="card">
  <div class="card-header">
    <h3 class="card-title">User Directory</h3>
  </div>

  <div class="card-body">
    <div class="table-responsive" style="overflow-x: auto; max-width: 100%;">
      <table id="example1" class="table table-bordered table-hover table-sm" style="table-layout: auto; font-size: 0.85rem; min-width: 1200px;">
        <thead class="thead-light">
          <tr>
            <th style="width: 50px;">
              <input type="checkbox" id="selectAll" onclick="toggleAllCheckboxes(this)">
            </th>
            <th style="width: 60px;">Profile</th>
            <th>Name</th>
            <th>Email</th>
            <th>Role</th>
            <th>Department</th>
            <th>Designation</th>
            <th style="width: 110px;">Date of Joining</th>
            <th style="width: 100px;">Contact</th>
            <th style="width: 80px;">Status</th>
            <th style="width: 120px;">Actions</th>
          </tr>
        </thead>

        <tbody>
          <c:forEach var="user" items="${users}">
            <tr>
              <td>
                <input type="checkbox" name="selectedUserIds" value="${user.userId}" class="userCheckbox">
              </td>
              <td>
                <img src="images/${user.profilePicture}" alt="Profile" style="width: 40px; height: 40px; border-radius: 50%; object-fit: cover;">
              </td>
              <td>${user.firstName} ${user.lastName}</td>
              <td>${user.email}</td>
              <td>${user.roleName}</td>
              <td>${user.departmentName}</td>
              <td>${user.designationName}</td>
              <td>${user.dateOfJoining}</td>
              <td>${user.contactNumber}</td>
              <td>
                <span class="badge badge-${user.status == 'ACTIVE' ? 'success' : 'danger'}">${user.status}</span>
              </td>
              <td style="white-space: nowrap;">
               <a href="UserServlet?action=edit&userId=${user.userId}" class="btn btn-sm "><button type="button" class="btn btn-primary " data-toggle="modal" data-target="#modal-warning"> <i class="fas fa-edit"></i>  </button></a>
                <button type="button" class="btn btn-sm btn-danger" onclick="showDeleteWarning()"><i class="fas fa-trash-alt"></i> </button>
              </td>
            </tr>
          </c:forEach>
        </tbody>

       
      </table>
    </div>
  </div>
</div>
           
            
            
<div class="modal fade" id="modal-default">
  <div class="modal-dialog" style="max-width: 700px;">
    <div class="modal-content" style="border-radius: 10px; box-shadow: 0 0 10px rgba(0,0,0,0.2);">
      <form method="post" action="UserServlet" enctype="multipart/form-data">

        <div class="modal-header" style="background-color: #f8f9fa; border-bottom: 1px solid #dee2e6;">
          <h5 class="modal-title" id="addUserModalLabel" style="font-weight: 600;">Add New User</h5>
          <button type="button" class="close" data-dismiss="modal" aria-label="Close" style="font-size: 1.5rem;">
            <span aria-hidden="true">&times;</span>
          </button>
        </div>

        <div class="modal-body" style="padding: 20px;">
          <input type="hidden" name="action" value="add">

          <!-- Name and Email -->
          <div class="row mb-3">
            <div class="col-md-6">
              <label class="form-label" style="font-weight: 500;">First Name</label>
              <input type="text" name="firstName" class="form-control" required>
            </div>
            <div class="col-md-6">
              <label class="form-label" style="font-weight: 500;">Last Name</label>
              <input type="text" name="lastName" class="form-control" required>
            </div>
          </div>

          <div class="row mb-3">
            <div class="col-md-6">
              <label class="form-label" style="font-weight: 500;">Email</label>
              <input type="email" name="email" class="form-control" required>
            </div>
            <div class="col-md-6">
              <label class="form-label" style="font-weight: 500;">Password</label>
              <input type="text" name="plainPassword" class="form-control" required>
            </div>
          </div>

          <!-- Role Selection -->
          <div class="mb-3">
            <label class="form-label" style="font-weight: 500;">Role</label>
            <select name="roleId" class="form-control" onchange="toggleReportingManager(this.value)" required>
              <c:forEach var="role" items="${roles}">
                <option value="${role.roleId}">${role.roleName}</option>
              </c:forEach>
            </select>
          </div>

          <!-- Reporting Manager -->
          <div class="mb-3" id="reportingManagerDiv">
            <label class="form-label" style="font-weight: 500;">Reporting Manager</label>
            <select name="reportingManager" class="form-select">
              <c:forEach var="mgr" items="${managers}">
                <option value="${mgr.userId}">${mgr.firstName} ${mgr.lastName}</option>
              </c:forEach>
            </select>
          </div>

          <!-- Department & Designation -->
          <div class="row mb-3">
            <div class="col-md-6">
              <label class="form-label" style="font-weight: 500;">Department</label>
              <select name="departmentId" class="form-select" onchange="fetchDesignations(this.value)" required>
                <c:forEach var="dept" items="${departments}">
                  <option value="${dept.departmentId}">${dept.departmentName}</option>
                </c:forEach>
              </select>
            </div>
            <div class="col-md-6">
              <label class="form-label" style="font-weight: 500;">Designation</label>
              <select name="designationId" id="designationDropdown" class="form-select" required>
                <!-- Options will be filled dynamically -->
              </select>
            </div>
          </div>

          <!-- Dates -->
          <div class="row mb-3">
            <div class="col-md-6">
              <label class="form-label" style="font-weight: 500;">Date of Joining</label>
              <input type="date" name="dateOfJoining" class="form-control" required>
            </div>
            <div class="col-md-6">
              <label class="form-label" style="font-weight: 500;">Date of Birth</label>
              <input type="date" name="dateOfBirth" class="form-control" required>
            </div>
          </div>

          <!-- Contact & Address -->
          <div class="mb-3">
            <label class="form-label" style="font-weight: 500;">Contact Number</label>
            <input type="text" name="contactNumber" class="form-control" required>
          </div>

          <div class="mb-3">
            <label class="form-label" style="font-weight: 500;">Address</label>
            <textarea name="address" class="form-control" rows="2" required></textarea>
          </div>

          <!-- Profile Picture -->
          <div class="mb-3">
            <label class="form-label" style="font-weight: 500;">Profile Picture</label>
            <input type="file" name="profilePicture" class="form-control" accept="image/*">
          </div>

          <!-- About -->
          <div class="mb-3">
            <label class="form-label" style="font-weight: 500;">About Employee</label>
            <textarea name="aboutEmployee" class="form-control" rows="2"></textarea>
          </div>

          <!-- Status -->
          <div class="mb-3">
            <label class="form-label" style="font-weight: 500;">Status</label>
            <select name="status" class="form-select">
              <option value="ACTIVE">ACTIVE</option>
              <option value="INACTIVE">INACTIVE</option>
            </select>
          </div>
        </div>

        <div class="modal-footer" style="padding: 15px; border-top: 1px solid #dee2e6;">
          <button type="button" class="btn btn-secondary" data-dismiss="modal" style="min-width: 100px;">Close</button>
          <button type="submit" class="btn btn-primary" style="min-width: 120px;">Create User</button>
        </div>

      </form>
    </div>
  </div>
</div>

      <!-- /.modal -->
      
      
      <!-- -=========================================================================  update part===================================== -->
      
<div class="modal fade" id="modal-warning">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
      <form method="post" action="UserServlet" enctype="multipart/form-data">
        <div class="modal-header">
          <h5 class="modal-title" id="addUserModalLabel">Update User</h5>
          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">&times;</span>
          </button>
        </div>

        <div class="modal-body">
          <!-- Profile Picture Preview -->
          <c:if test="${not empty userDetails.profilePicture}">
            <div class="text-center mb-3">
              <label>Current Profile Picture</label><br>
              <img src="images/${userDetails.profilePicture}" 
                   alt="Profile Picture" 
                   class="img-thumbnail" 
                   style="max-width: 150px; border-radius: 8px;">
            </div>
          </c:if>

          <input type="hidden" name="action" value="update">
          <input type="hidden" name="userId" value="${user.userId}">

          <!-- Name and Email -->
          <div class="form-row">
            <div class="form-group col-md-6">
              <label>First Name</label>
              <input type="text" name="firstName" class="form-control" value="${userDetails.firstName}" required>
            </div>
            <div class="form-group col-md-6">
              <label>Last Name</label>
              <input type="text" name="lastName" class="form-control" value="${userDetails.lastName}" required>
            </div>
          </div>

          <div class="form-group">
            <label>Email</label>
            <input type="email" name="email" class="form-control" value="${userDetails.email}">
          </div>

          <!-- Role Selection -->
          <div class="form-group">
            <label>Role</label>
            <select name="roleId" class="form-control" onchange="handleRoleChange(this.value)" required>
              <c:forEach var="role" items="${roles}">
                <option value="${role.roleId}" ${role.roleId == userDetails.roleId ? 'selected' : ''}>
                  ${role.roleName}
                </option>
              </c:forEach>
            </select>
          </div>

          <!-- Reporting Manager -->
          <div class="form-group" id="reportingManagerGroup">
            <label>Reporting Manager</label>
            <select name="reportingManager" id="reportingManagerSelect" class="form-control"></select>
          </div>

          <!-- Department & Designation -->
          <div class="form-row">
            <div class="form-group col-md-6">
              <label>Department</label>
              <select name="departmentId" class="form-control" onchange="handleDepartmentChange(this.value)" required>
                <c:forEach var="dept" items="${departments}">
                  <option value="${dept.departmentId}" ${dept.departmentId == userDetails.departmentId ? 'selected' : ''}>
                    ${dept.departmentName}
                  </option>
                </c:forEach>
              </select>
            </div>
            <div class="form-group col-md-6">
              <label>Designation</label>
              <select name="designationId" id="designationSelect" class="form-control" required></select>
            </div>
          </div>

          <!-- Dates -->
          <div class="form-row">
            <div class="form-group col-md-6">
              <label>Date of Joining</label>
              <input type="date" name="dateOfJoining" class="form-control" value="${userDetails.dateOfJoining}" required>
            </div>
            <div class="form-group col-md-6">
              <label>Date of Birth</label>
              <input type="date" name="dateOfBirth" class="form-control" value="${userDetails.dateOfBirth}" required>
            </div>
          </div>

          <!-- Contact & Address -->
          <div class="form-group">
            <label>Contact Number</label>
            <input type="text" name="contactNumber" class="form-control" value="${userDetails.contactNumber}" required>
          </div>

          <div class="form-group">
            <label>Address</label>
            <textarea name="address" class="form-control" rows="2" required>${userDetails.address}</textarea>
          </div>

          <!-- Profile Picture -->
          <div class="form-group">
            <label>Profile Picture</label>
            <input type="file" name="profilePicture" class="form-control-file" accept="image/*">
          </div>

          <!-- About -->
          <div class="form-group">
            <label>About Employee</label>
            <textarea name="aboutEmployee" class="form-control" rows="2">${userDetails.aboutEmployee}</textarea>
          </div>

          <!-- Status -->
          <div class="form-group">
            <label>Status</label>
            <select name="status" class="form-control">
              <option value="ACTIVE" ${userDetails.status == 'ACTIVE' ? 'selected' : ''}>ACTIVE</option>
              <option value="INACTIVE" ${userDetails.status == 'INACTIVE' ? 'selected' : ''}>INACTIVE</option>
            </select>
          </div>
        </div>

        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
          <button type="submit" class="btn btn-primary">Update User</button>
        </div>
      </form>
    </div>
  </div>
</div>


          
          
          
           </div>
          <!-- /.col -->
        </div>
        <!-- /.row -->
      </div>
      <!-- /.container-fluid -->
    </section>
    
    
		
	</div>
</div>



<!--  script for togling the manager -->

<script>
function toggleReportingManager(roleId) {
  const div = document.getElementById("reportingManagerDiv");
  const managerSelect = document.querySelector('select[name="reportingManager"]');

  // Hide for Admin or Manager roles
  if (roleId === '1' || roleId === '2') {
    div.style.display = "none";
    managerSelect.innerHTML = ""; // Clear options
    return;
  }

  // Show for other roles
  div.style.display = "block";

  // Fetch managers from backend
  fetch('UserServlet?action=getAllManagers')
    .then(response => {
      if (!response.ok) {
        throw new Error("Network response was not ok");
      }
      return response.json();
    })
    .then(data => {
      managerSelect.innerHTML = '<option disabled selected>Select a manager</option>';

      data.forEach(mgr => {
        const option = document.createElement("option");
        option.value = mgr.userId;
        option.text = mgr.firstName + " " + mgr.lastName;
        managerSelect.appendChild(option);
      });
    })
    .catch(error => {
      console.error("Error fetching managers:", error);
      managerSelect.innerHTML = '<option disabled>Error loading managers</option>';
    });
}
</script>

<!-- script for to fetch the desgination by id   -->

<script>
function fetchDesignations(deptId) {
  fetch('DesignationServlet?action=getByDepartment&deptId=' + deptId)
    .then(response => response.json())
    .then(data => {
      const designationSelect = document.getElementById("designationDropdown");
      designationSelect.innerHTML = ""; // Clear old options

      data.forEach(des => {
        const option = document.createElement("option");
        option.value = des.designationId;
        option.text = des.designationName;
        designationSelect.appendChild(option);
      });
    })
    .catch(error => console.error("Error fetching designations:", error));
    
  
    
    
}
</script>


<!-- script for the Update modal   -->

<script>
document.addEventListener("DOMContentLoaded", function () {
  // Initial triggers if values are pre-selected
  const roleDropdown = document.querySelector('select[name="roleId"]');
  const deptDropdown = document.querySelector('select[name="departmentId"]');

  if (roleDropdown) handleRoleChange(roleDropdown.value);
  if (deptDropdown) handleDepartmentChange(deptDropdown.value);
});

function handleRoleChange(roleId) {
  const managerGroup = document.getElementById("reportingManagerGroup");
  const managerSelect = document.getElementById("reportingManagerSelect");

  if (roleId === '1' || roleId === '2') {
    managerGroup.style.display = "none";
    managerSelect.innerHTML = "";
    return;
  }

  managerGroup.style.display = "block";

  fetch('UserServlet?action=getAllManagers')
    .then(response => response.json())
    .then(data => {
      managerSelect.innerHTML = '<option disabled selected>Select a manager</option>';
      data.forEach(mgr => {
        const option = document.createElement("option");
        option.value = mgr.userId;
        option.text = mgr.firstName + " " + mgr.lastName;
        managerSelect.appendChild(option);
      });
    })
    .catch(error => {
      console.error("Error fetching managers:", error);
      managerSelect.innerHTML = '<option disabled>Error loading managers</option>';
    });
}

function handleDepartmentChange(deptId) {
  const designationSelect = document.getElementById("designationSelect");

  fetch('DesignationServlet?action=getByDepartment&deptId=' + deptId)
    .then(response => response.json())
    .then(data => {
      designationSelect.innerHTML = '<option disabled selected>Select a designation</option>';
      data.forEach(des => {
        const option = document.createElement("option");
        option.value = des.designationId;
        option.text = des.designationName;
        designationSelect.appendChild(option);
      });
    })
    .catch(error => {
      console.error("Error fetching designations:", error);
      designationSelect.innerHTML = '<option disabled>Error loading designations</option>';
    });
}
</script>


<c:if test="${showUpdateModal}">
<script>
  document.addEventListener("DOMContentLoaded", function () {
    const updateModal = new bootstrap.Modal(document.getElementById('modal-warning'));
    updateModal.show();
  });
</script>
</c:if>

<script>
function toggleAllCheckboxes(masterCheckbox) {
  const checkboxes = document.querySelectorAll('.userCheckbox');
  checkboxes.forEach(cb => cb.checked = masterCheckbox.checked);
}

function submitSelected(format) {
  const selected = Array.from(document.querySelectorAll('.userCheckbox:checked'))
                        .map(cb => cb.value);
  if (selected.length === 0) {
    alert("Please select at least one user to export.");
    return;
  }

  document.getElementById("selectedIdsField").value = selected.join(",");
  document.getElementById("exportForm").action = "UserServlet?action=export" + (format === 'pdf' ? "PdfSelected" : "ExcelSelected");
  document.getElementById("exportForm").submit();
}
</script>



<jsp:include page="../../../footer.jsp"></jsp:include>


<!-- jQuery -->
<script src="plugins/jquery/jquery.min.js"></script>
<!-- jQuery UI 1.11.4 -->
<script src="plugins/jquery-ui/jquery-ui.min.js"></script>
<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
<script>
  $.widget.bridge('uibutton', $.ui.button)
</script>
<!-- Bootstrap 4 -->
<script src="plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- ChartJS -->
<script src="plugins/chart.js/Chart.min.js"></script>
<!-- Sparkline -->
<script src="plugins/sparklines/sparkline.js"></script>
<!-- JQVMap -->
<script src="plugins/jqvmap/jquery.vmap.min.js"></script>
<script src="plugins/jqvmap/maps/jquery.vmap.usa.js"></script>
<!-- jQuery Knob Chart -->
<script src="plugins/jquery-knob/jquery.knob.min.js"></script>
<!-- daterangepicker -->
<script src="plugins/moment/moment.min.js"></script>
<script src="plugins/daterangepicker/daterangepicker.js"></script>
<!-- Tempusdominus Bootstrap 4 -->
<script src="plugins/tempusdominus-bootstrap-4/js/tempusdominus-bootstrap-4.min.js"></script>
<!-- Summernote -->
<script src="plugins/summernote/summernote-bs4.min.js"></script>
<!-- overlayScrollbars -->
<script src="plugins/overlayScrollbars/js/jquery.overlayScrollbars.min.js"></script>
<!-- AdminLTE App -->
<script src="dist/js/adminlte2167.js?v=3.2.0"></script>
<!-- AdminLTE for demo purposes -->
<script src="dist/js/demo.js"></script>
<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
<script src="dist/js/pages/dashboard.js"></script>
<script defer src="https://static.cloudflareinsights.com/beacon.min.js/vcd15cbe7772f49c399c6a5babf22c1241717689176015" integrity="sha512-ZpsOmlRQV6y907TI0dKBHq9Md29nnaEIPlkf84rnaERnq6zvWvPUqr2ft8M1aS28oN72PdrCzSjY4U6VaAw1EQ==" data-cf-beacon='{"rayId":"97edd8cbed143e57","version":"2025.8.0","serverTiming":{"name":{"cfExtPri":true,"cfEdge":true,"cfOrigin":true,"cfL4":true,"cfSpeedBrain":true,"cfCacheStatus":true}},"token":"2437d112162f4ec4b63c3ca0eb38fb20","b":1}' crossorigin="anonymous"></script>


<!-- DataTables  & Plugins -->
<script src="plugins/datatables/jquery.dataTables.min.js"></script>
<script src="plugins/datatables-bs4/js/dataTables.bootstrap4.min.js"></script>
<script src="plugins/datatables-responsive/js/dataTables.responsive.min.js"></script>
<script src="plugins/datatables-responsive/js/responsive.bootstrap4.min.js"></script>
<script src="plugins/datatables-buttons/js/dataTables.buttons.min.js"></script>
<script src="plugins/datatables-buttons/js/buttons.bootstrap4.min.js"></script>
<script src="plugins/jszip/jszip.min.js"></script>
<script src="plugins/pdfmake/pdfmake.min.js"></script>
<script src="plugins/pdfmake/vfs_fonts.js"></script>
<script src="plugins/datatables-buttons/js/buttons.html5.min.js"></script>
<script src="plugins/datatables-buttons/js/buttons.print.min.js"></script>
<script src="plugins/datatables-buttons/js/buttons.colVis.min.js"></script>


<!-- Page specific script -->
<script>
  $(function () {
    $("#example1").DataTable({
      "responsive": true, "lengthChange": false, "autoWidth": false,
      "buttons": ["copy", "csv", "excel", "pdf", "print", "colvis"]
    }).buttons().container().appendTo('#example1_wrapper .col-md-6:eq(0)');
    $('#example2').DataTable({
      "paging": true,
      "lengthChange": false,
      "searching": false,
      "ordering": true,
      "info": true,
      "autoWidth": false,
      "responsive": true,
    });
  });
</script>	

</body>
</html>