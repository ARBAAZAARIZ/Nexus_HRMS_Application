<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>AdminLTE 3 | Dashboard</title>

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


<!-- Custom CSS -->
    <style>
        .action-buttons .btn {
            margin-right: 5px;
        }
        .status-badge {
            font-size: 0.85rem;
        }
        .table th {
            background-color: #f8f9fa;
        }
        .trainer-type-badge {
            font-size: 0.8rem;
        }
        .section-title {
            border-bottom: 2px solid #0d6efd;
            padding-bottom: 10px;
            margin-bottom: 20px;
        }
        .required-field::after {
            content: " *";
            color: red;
        }
        .profile-image-preview {
            width: 100px;
            height: 100px;
            border-radius: 50%;
            object-fit: cover;
            border: 3px solid #dee2e6;
            margin-bottom: 10px;
        }
        .employee-card {
            cursor: pointer;
            transition: all 0.3s ease;
        }
        .employee-card:hover {
            transform: translateY(-2px);
            box-shadow: 0 4px 8px rgba(0,0,0,0.1);
        }
        .employee-card.selected {
            border: 2px solid #0d6efd;
            background-color: #f0f8ff;
        }
    </style>

</head>
<body class="hold-transition sidebar-mini layout-fixed">

<jsp:include page="../../../navbar.jsp"></jsp:include>

<jsp:include page="../../../sidebar.jsp"></jsp:include>



<div class="wrapper">
	<div class="content-wrapper">
		<div class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1 class="m-0">Dashboard</h1>
          </div><!-- /.col -->
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Home</a></li>
              <li class="breadcrumb-item active">Dashboard v1</li>
            </ol>
          </div><!-- /.col -->
        </div><!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>
		<section class="content">
		
		 <div class="container-fluid">
        <div class="row">
          <div class="col-12">
          
        
<div class="container-fluid px-4 py-4">
        <div class="card shadow-sm">
            <div class="card-header bg-success text-white d-flex justify-content-between align-items-center">
                <h4 class="mb-0"><i class="fas fa-chalkboard-teacher me-2"></i>Trainers Management</h4>
                <button type="button" class="btn btn-light" data-toggle="modal" data-target="#trainerTypeModal">
                    <i class="fas fa-plus me-1"></i> Add New Trainer
                </button>
            </div>
            <div class="card-body">
                
                <!-- Success/Error Messages -->
                <c:if test="${not empty message}">
                    <div class="alert alert-info alert-dismissible fade show" role="alert">
                        ${message}
                        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                    </div>
                    <c:remove var="message" scope="session" />
                </c:if>
                
                <!-- Trainers Table -->
                <div class="table-responsive">
                    <!-- <table class="table table-striped table-hover table-bordered" id="trainersTable"> -->
                    <table id="example1" class="table table-striped table-hover table-bordered">
                        <thead class="table-dark text-dark">
                            <tr>
                                <th>ID</th>
                                <th>Name</th>
                                <th>Email</th>
                                <th>Contact</th>
                                <th>Type</th>
                                <th>Status</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="trainer" items="${trainers}">
                                <tr>
                                    <td>${trainer.trainerId}</td>
                                    <td>
                                        <c:if test="${not empty trainer.profilePicture}">
                                            <img src="images/${trainer.profilePicture}" 
                                                 class="rounded-circle me-2" width="30" height="30" alt="Profile">
                                        </c:if>
                                        ${trainer.firstName} ${trainer.lastName}
                                    </td>
                                    <td>${trainer.email}</td>
                                    <td>${trainer.contactNo}</td>
                                    <td>
                                        <span class="badge ${trainer.internal ? 'bg-info' : 'bg-warning'} trainer-type-badge">
                                            ${trainer.internal ? 'Internal' : 'External'}
                                        </span>
                                    </td>
                                    <td>
                                        <span class="badge ${trainer.status == 'ACTIVE' ? 'bg-success' : 'bg-danger'} status-badge">
                                            ${trainer.status}
                                        </span>
                                    </td>
                                   <td class="action-buttons">
    <a href="trainer?action=edit&id=${trainer.trainerId}" class="btn btn-sm btn-warning">
        <i class="fas fa-edit"></i> 
    </a>
    <a href="trainer?action=delete&id=${trainer.trainerId}" 
       class="btn btn-sm btn-danger" 
       onclick="return confirm('Are you sure you want to delete this trainer?')">
        <i class="fas fa-trash"></i> 
    </a>
</td>
                                </tr>
                            </c:forEach>
                            <c:if test="${empty trainers}">
                                <tr>
                                    <td colspan="7" class="text-center text-muted">No trainers found. Add your first trainer!</td>
                                </tr>
                            </c:if>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>

    <!-- Add Trainer Type Selection Modal -->
    <div class="modal fade" id="trainerTypeModal" tabindex="-1" aria-labelledby="trainerTypeModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header bg-primary text-white">
                    <h5 class="modal-title" id="trainerTypeModalLabel">
                        <i class="fas fa-user-plus me-2"></i>Select Trainer Type
                    </h5>
                    <button type="button" class="close btn-close-white " data-dismiss="modal" aria-label="Close" style="font-size: 1.5rem;">=</button>
                    
                </div>
                <div class="modal-body text-center">
                    <div class="row">
                        <div class="col-md-6 mb-3">
                            <div class="card h-100 employee-card" onclick="selectTrainerType('internal', 'add')">
                                <div class="card-body">
                                    <i class="fas fa-user-tie fa-3x text-primary mb-3"></i>
                                    <h5>Internal Trainer</h5>
                                    <p class="text-muted">Select from existing employees</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6 mb-3">
                            <div class="card h-100 employee-card" onclick="selectTrainerType('external', 'add')">
                                <div class="card-body">
                                    <i class="fas fa-user-plus fa-3x text-warning mb-3"></i>
                                    <h5>External Trainer</h5>
                                    <p class="text-muted">Add new external trainer</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Edit Trainer Type Selection Modal -->
    <div class="modal fade" id="editTrainerTypeModal" tabindex="-1" aria-labelledby="editTrainerTypeModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header bg-primary text-white">
                    <h5 class="modal-title" id="editTrainerTypeModalLabel">
                        <i class="fas fa-edit me-2"></i>Select Trainer Type
                    </h5>
                    <button type="button" class="close btn-close-white " data-dismiss="modal" aria-label="Close" style="font-size: 1.5rem;">=</button>
                </div>
                <div class="modal-body text-center">
                    <div class="row">
                        <div class="col-md-6 mb-3">
                            <div class="card h-100 employee-card" onclick="selectTrainerType('internal', 'edit')">
                                <div class="card-body">
                                    <i class="fas fa-user-tie fa-3x text-primary mb-3"></i>
                                    <h5>Internal Trainer</h5>
                                    <p class="text-muted">Select from existing employees</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6 mb-3">
                            <div class="card h-100 employee-card" onclick="selectTrainerType('external', 'edit')">
                                <div class="card-body">
                                    <i class="fas fa-user-plus fa-3x text-warning mb-3"></i>
                                    <h5>External Trainer</h5>
                                    <p class="text-muted">Edit external trainer</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Internal Trainer Modal (Add) -->
    <div class="modal fade" id="internalTrainerModal" tabindex="-1" aria-labelledby="internalTrainerModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header bg-info text-white">
                    <h5 class="modal-title" id="internalTrainerModalLabel">
                        <i class="fas fa-user-tie me-2"></i>Add Internal Trainer
                    </h5>
                   <button type="button" class="close btn-close-white " data-dismiss="modal" aria-label="Close" style="font-size: 1.5rem;">=</button>
                </div>
                <form action="trainer?action=insert" method="post">
                    <input type="hidden" name="trainerType" value="internal">
                    <div class="modal-body">
                        <div class="mb-3">
                            <label class="form-label required-field">Select Employee</label>
                            <div class="row" id="employeeSelection">
                                <c:forEach var="employee" items="${employees}">
                                    <div class="col-md-6 mb-3">
                                        <div class="card employee-card" onclick="selectEmployee(this, ${employee.userId})">
                                            <div class="card-body">
                                                <div class="d-flex align-items-center">
                                                    <c:choose>
                                                        <c:when test="${not empty employee.profilePicture}">
                                                            <img src="images/${employee.profilePicture}" class="rounded-circle me-3" width="50" height="50" alt="Profile">
                                                        </c:when>
                                                        <c:otherwise>
                                                            <div class="rounded-circle bg-secondary me-3 d-flex align-items-center justify-content-center" style="width: 50px; height: 50px;">
                                                                <i class="fas fa-user text-white"></i>
                                                            </div>
                                                        </c:otherwise>
                                                    </c:choose>
                                                    <div>
                                                        <h6 class="mb-0">${employee.firstName} ${employee.lastName}</h6>
                                                        <small class="text-muted">${employee.designationName}</small><br>
                                                        <small class="text-muted">${employee.departmentName} • ${employee.roleName}</small><br>
                                                        <small class="text-muted">${employee.email}</small>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                            <input type="hidden" id="selectedUserId" name="userId" required>
                        </div>
                        <div class="mb-3">
                            <label for="internalDescription" class="form-label">Training Description/Expertise</label>
                            <textarea class="form-control" id="internalDescription" name="description" rows="3" placeholder="Enter training expertise description"></textarea>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="close text-dark " data-dismiss="modal" aria-label="Close" style="font-size: 1.5rem;">Cancle</button>
                        <button type="submit" class="btn btn-info">Add Internal Trainer</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <!-- External Trainer Modal (Add) -->
    <div class="modal fade" id="externalTrainerModal" tabindex="-1" aria-labelledby="externalTrainerModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header bg-warning text-dark">
                    <h5 class="modal-title" id="externalTrainerModalLabel">
                        <i class="fas fa-user-plus me-2"></i>Add External Trainer
                    </h5>
                    <button type="button" class="close btn-close-white text-white " data-dismiss="modal" aria-label="Close" style="font-size: 1.5rem;">=</button>
                </div>
                <form action="trainer?action=insert" method="post" enctype="multipart/form-data">
                    <input type="hidden" name="trainerType" value="external">
                    <div class="modal-body">
                        <div class="row mb-3">
                            <div class="col-md-6">
                                <label for="firstName" class="form-label required-field">First Name</label>
                                <input type="text" class="form-control" id="firstName" name="firstName" required>
                            </div>
                            <div class="col-md-6">
                                <label for="lastName" class="form-label required-field">Last Name</label>
                                <input type="text" class="form-control" id="lastName" name="lastName" required>
                            </div>
                        </div>
                        <div class="row mb-3">
                            <div class="col-md-6">
                                <label for="email" class="form-label required-field">Email</label>
                                <input type="email" class="form-control" id="email" name="email" required>
                            </div>
                            <div class="col-md-6">
                                <label for="contactNo" class="form-label">Contact Number</label>
                                <input type="tel" class="form-control" id="contactNo" name="contactNo">
                            </div>
                        </div>
                        <div class="row mb-3">
                            <div class="col-md-6">
                                <label for="profilePicture" class="form-label">Profile Picture</label>
                                <input type="file" class="form-control" id="profilePicture" name="profilePicture" 
                                       accept="image/*" onchange="updateImagePreview(this, 'addImagePreview')" style="display: none;">
                                <label for="profilePicture" class="file-input-label">
                                    <i class="fas fa-upload me-2"></i>Choose Image
                                </label>
                                <div class="mt-2 text-center">
                                    <img id="addImagePreview" class="profile-image-preview" src="" alt="Preview" style="display: none;">
                                </div>
                            </div>
                            <div class="col-md-6">
                                <label for="status" class="form-label required-field">Status</label>
                                <select class="form-select" id="status" name="status" required>
                                    <option value="ACTIVE" selected>ACTIVE</option>
                                    <option value="INACTIVE">INACTIVE</option>
                                </select>
                            </div>
                        </div>
                        <div class="mb-3">
                            <label for="externalDescription" class="form-label">Description/Expertise</label>
                            <textarea class="form-control" id="externalDescription" name="description" rows="3"></textarea>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="close btn-close-white text-white " data-dismiss="modal" aria-label="Close" style="font-size: 1.5rem;">Cancle</button>
                        <button type="submit" class="btn btn-warning">Add External Trainer</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

    


    
    <!-- Update Modal for Internal Trainer -->
<div class="modal fade" id="updateInternalModal" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <form method="post" action="trainer" enctype="multipart/form-data">
                <div class="modal-header bg-info text-white">
                    <h5 class="modal-title">Update Internal Trainer</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <input type="hidden" name="action" value="update">
                    <input type="hidden" name="trainerType" value="internal">
                    <input type="hidden" name="trainerId" value="${trainer.trainerId}">
                    
                    <div class="mb-3">
                        <label class="form-label required-field">Select Employee</label>
                        <div class="row">
                            <c:forEach var="employee" items="${employees}">
                                <div class="col-md-6 mb-3">
                                    <div class="card employee-card ${employee.userId == trainer.userId ? 'selected' : ''}" 
                                         onclick="selectEmployeeForUpdate(this, ${employee.userId})">
                                        <div class="card-body">
                                            <div class="d-flex align-items-center">
                                                <c:choose>
                                                    <c:when test="${not empty employee.profilePicture}">
                                                        <img src="images/${employee.profilePicture}" class="rounded-circle me-3" width="50" height="50" alt="Profile">
                                                    </c:when>
                                                    <c:otherwise>
                                                        <div class="rounded-circle bg-secondary me-3 d-flex align-items-center justify-content-center" style="width: 50px; height: 50px;">
                                                            <i class="fas fa-user text-white"></i>
                                                        </div>
                                                    </c:otherwise>
                                                </c:choose>
                                                <div>
                                                    <h6 class="mb-0">${employee.firstName} ${employee.lastName}</h6>
                                                    <small class="text-muted">${employee.designationName}</small><br>
                                                    <small class="text-muted">${employee.departmentName} • ${employee.roleName}</small><br>
                                                    <small class="text-muted">${employee.email}</small>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                        <input type="hidden" id="updateUserId" name="userId" value="${trainer.userId}" required>
                    </div>
                    
                    <div class="mb-3">
                        <label for="updateInternalDescription" class="form-label">Training Description/Expertise</label>
                        <textarea class="form-control" id="updateInternalDescription" name="description" rows="3">${trainer.description}</textarea>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-info">Update Internal Trainer</button>
                </div>
            </form>
        </div>
    </div>
</div>

<!-- Update Modal for External Trainer -->
<div class="modal fade" id="updateExternalModal" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <form method="post" action="trainer" enctype="multipart/form-data">
                <div class="modal-header bg-warning text-dark">
                    <h5 class="modal-title">Update External Trainer</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <input type="hidden" name="action" value="update">
                    <input type="hidden" name="trainerType" value="external">
                    <input type="hidden" name="trainerId" value="${trainer.trainerId}">
                    
                    <div class="row mb-3">
                        <div class="col-md-6">
                            <label for="updateFirstName" class="form-label required-field">First Name</label>
                            <input type="text" class="form-control" id="updateFirstName" name="firstName" value="${trainer.firstName}" required>
                        </div>
                        <div class="col-md-6">
                            <label for="updateLastName" class="form-label required-field">Last Name</label>
                            <input type="text" class="form-control" id="updateLastName" name="lastName" value="${trainer.lastName}" required>
                        </div>
                    </div>
                    
                    <div class="row mb-3">
                        <div class="col-md-6">
                            <label for="updateEmail" class="form-label required-field">Email</label>
                            <input type="email" class="form-control" id="updateEmail" name="email" value="${trainer.email}" required>
                        </div>
                        <div class="col-md-6">
                            <label for="updateContactNo" class="form-label">Contact Number</label>
                            <input type="tel" class="form-control" id="updateContactNo" name="contactNo" value="${trainer.contactNo}">
                        </div>
                    </div>
                    
                    <div class="row mb-3">
                        <div class="col-md-6">
                            <label for="updateProfilePicture" class="form-label">Profile Picture</label>
                            <input type="file" class="form-control" id="updateProfilePicture" name="profilePicture" accept="image/*">
                            <c:if test="${not empty trainer.profilePicture}">
                                <div class="mt-2">
                                    <small class="text-muted">Current: ${trainer.profilePicture}</small>
                                    <img src="images/${trainer.profilePicture}" class="img-thumbnail mt-2" width="100" alt="Current Profile">
                                </div>
                            </c:if>
                        </div>
                        <div class="col-md-6">
                            <label for="updateStatus" class="form-label required-field">Status</label>
                            <select class="form-select" id="updateStatus" name="status" required>
                                <option value="ACTIVE" ${trainer.status == 'ACTIVE' ? 'selected' : ''}>ACTIVE</option>
                                <option value="INACTIVE" ${trainer.status == 'INACTIVE' ? 'selected' : ''}>INACTIVE</option>
                            </select>
                        </div>
                    </div>
                    
                    <div class="mb-3">
                        <label for="updateDescription" class="form-label">Description/Expertise</label>
                        <textarea class="form-control" id="updateDescription" name="description" rows="3">${trainer.description}</textarea>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-warning">Update External Trainer</button>
                </div>
            </form>
        </div>
    </div>
</div>
    
    
    




          
          
          
          
          </div>
          </div>
          </div>
		
		
		
		
		</section>
	</div>
</div>



<!-- Auto-show update modal when page loads with trainer data -->
<c:if test="${showUpdateModal}">
<script>
document.addEventListener("DOMContentLoaded", function() {
    <c:choose>
        <c:when test="${trainer.internal}">
            $('#updateInternalModal').modal('show');
        </c:when>
        <c:otherwise>
            $('#updateExternalModal').modal('show');
        </c:otherwise>
    </c:choose>
});
</script>
</c:if>

<!-- Simple JavaScript for employee selection -->
<script>
function selectEmployeeForUpdate(cardElement, userId) {
    // Remove selected class from all cards
    document.querySelectorAll('.employee-card').forEach(card => {
        card.classList.remove('selected');
    });
    
    // Add selected class to clicked card
    cardElement.classList.add('selected');
    
    // Set the selected user ID
    document.getElementById('updateUserId').value = userId;
}
</script>




  <!-- Custom Script -->
    <!-- Custom Script -->
    <script>
        // Function to select trainer type and show appropriate modal
        function selectTrainerType(type) {
            $('#trainerTypeModal').modal('hide');
            
            if (type === 'internal') {
                setTimeout(() => {
                    $('#internalTrainerModal').modal('show');
                }, 300);
            } else {
                setTimeout(() => {
                    $('#externalTrainerModal').modal('show');
                }, 300);
            }
        }
        
        // Function to select an employee for internal trainer
        function selectEmployee(cardElement, userId) {
            // Remove selected class from all cards
            document.querySelectorAll('.employee-card').forEach(card => {
                card.classList.remove('selected');
            });
            
            // Add selected class to clicked card
            cardElement.classList.add('selected');
            
            // Set the selected user ID
            document.getElementById('selectedUserId').value = userId;
        }
        
        // Function to update image preview
        function updateImagePreview() {
            const imageUrl = document.getElementById('profilePicture').value;
            const preview = document.getElementById('imagePreview');
            
            if (imageUrl) {
                preview.src = imageUrl;
                preview.style.display = 'block';
            } else {
                preview.style.display = 'none';
            }
        }
        
        // Event listener for edit buttons
        document.addEventListener('DOMContentLoaded', function() {
            // Auto-hide alerts after 5 seconds
            const alerts = document.querySelectorAll('.alert');
            alerts.forEach(alert => {
                setTimeout(() => {
                    const bsAlert = new bootstrap.Alert(alert);
                    bsAlert.close();
                }, 5000);
            });
        });
        
        
        // Global variables to store current trainer data
let currentTrainerId = null;
let currentTrainerData = null;

// Function to open edit modal with trainer data
function openEditModal(trainerId, isInternal) {
    currentTrainerId = trainerId;
    
    // Fetch trainer data via AJAX
    fetch(`trainer?action=getTrainer&id=${trainerId}`)
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(data => {
            currentTrainerData = data;
            
            if (isInternal) {
                // Open internal trainer edit modal
                populateInternalEditModal(data);
                $('#editInternalTrainerModal').modal('show');
            } else {
                // Open external trainer edit modal
                populateExternalEditModal(data);
                $('#editExternalTrainerModal').modal('show');
            }
        })
        .catch(error => {
            console.error('Error fetching trainer data:', error);
            alert('Error loading trainer data. Please try again.');
        });
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
<!-- AdminLTE App -->
	
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