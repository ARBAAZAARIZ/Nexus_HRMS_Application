<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Employee Details</title>

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
  <link rel="stylesheet" href="plugins/summernote/summernote-bs4.min.css">
<script data-cfasync="false" nonce="06cb1374-3a81-4a88-aebe-16de25f6e552">try{(function(w,d){!function(j,k,l,m){if(j.zaraz)console.error("zaraz is loaded twice");else{j[l]=j[l]||{};j[l].executed=[];j.zaraz={deferred:[],listeners:[]};j.zaraz._v="5870";j.zaraz._n="06cb1374-3a81-4a88-aebe-16de25f6e552";j.zaraz.q=[];j.zaraz._f=function(n){return async function(){var o=Array.prototype.slice.call(arguments);j.zaraz.q.push({m:n,a:o})}};for(const p of["track","set","debug"])j.zaraz[p]=j.zaraz._f(p);j.zaraz.init=()=>{var q=k.getElementsByTagName(m)[0],r=k.createElement(m),s=k.getElementsByTagName("title")[0];s&&(j[l].t=k.getElementsByTagName("title")[0].text);j[l].x=Math.random();j[l].w=j.screen.width;j[l].h=j.screen.height;j[l].j=j.innerHeight;j[l].e=j.innerWidth;j[l].l=j.location.href;j[l].r=k.referrer;j[l].k=j.screen.colorDepth;j[l].n=k.characterSet;j[l].o=(new Date).getTimezoneOffset();if(j.dataLayer)for(const t of Object.entries(Object.entries(dataLayer).reduce((u,v)=>({...u[1],...v[1]}),{})))zaraz.set(t[0],t[1],{scope:"page"});j[l].q=[];for(;j.zaraz.q.length;){const w=j.zaraz.q.shift();j[l].q.push(w)}r.defer=!0;for(const x of[localStorage,sessionStorage])Object.keys(x||{}).filter(z=>z.startsWith("_zaraz_")).forEach(y=>{try{j[l]["z_"+y.slice(7)]=JSON.parse(x.getItem(y))}catch{j[l]["z_"+y.slice(7)]=x.getItem(y)}});r.referrerPolicy="origin";r.src="../../cdn-cgi/zaraz/sd0d9.js?z="+btoa(encodeURIComponent(JSON.stringify(j[l])));q.parentNode.insertBefore(r,q)};["complete","interactive"].includes(k.readyState)?zaraz.init():j.addEventListener("DOMContentLoaded",zaraz.init)}}(w,d,"zarazData","script");window.zaraz._p=async bs=>new Promise(bt=>{if(bs){bs.e&&bs.e.forEach(bu=>{try{const bv=d.querySelector("script[nonce]"),bw=bv?.nonce||bv?.getAttribute("nonce"),bx=d.createElement("script");bw&&(bx.nonce=bw);bx.innerHTML=bu;bx.onload=()=>{d.head.removeChild(bx)};d.head.appendChild(bx)}catch(by){console.error(`Error executing script: ${bu}\n`,by)}});Promise.allSettled((bs.f||[]).map(bz=>fetch(bz[0],bz[1])))}bt()});zaraz._p({"e":["(function(w,d){})(window,document)"]});})(window,document)}catch(e){throw fetch("/cdn-cgi/zaraz/t"),e;};</script>

<script src="https://cdn.jsdelivr.net/npm/bs-custom-file-input@1.3.4/dist/bs-custom-file-input.min.js"></script>

  <style>
    :root {
      --primary-color: #3c8dbc;
      --secondary-color: #6c757d;
      --success-color: #28a745;
      --danger-color: #dc3545;
    }
    
    body {
      font-family: 'Source Sans Pro', sans-serif;
      background-color: #f4f6f9;
    }
    
    .employee-details-container {
      max-width: 1200px;
      margin: 0 auto;
      padding: 20px;
    }
    
    .profile-card {
      background: white;
      border-radius: 10px;
      padding: 25px;
      box-shadow: 0 4px 8px rgba(0,0,0,0.1);
      text-align: center;
      margin-bottom: 25px;
    }
    
    .profile-pic {
      width: 120px;
      height: 120px;
      border-radius: 50%;
      object-fit: cover;
      border: 4px solid var(--primary-color);
      margin-bottom: 15px;
    }
    
    .info-section {
      background: white;
      border-radius: 10px;
      padding: 25px;
      box-shadow: 0 4px 8px rgba(0,0,0,0.1);
      margin-bottom: 25px;
      position: relative;
    }
    
    .section-header {
      display: flex;
      justify-content: space-between;
      align-items: center;
      margin-bottom: 20px;
      padding-bottom: 10px;
      border-bottom: 2px solid #eee;
    }
    
    .add-btn {
      background: var(--success-color);
      color: white;
      border: none;
      border-radius: 50%;
      width: 40px;
      height: 40px;
      font-size: 20px;
      display: flex;
      align-items: center;
      justify-content: center;
      cursor: pointer;
    }
    
    .detail-item {
      padding: 15px;
      border: 1px solid #eee;
      border-radius: 8px;
      margin-bottom: 15px;
      background: #f9f9f9;
    }
    
    .action-buttons {
      display: flex;
      gap: 10px;
      margin-top: 10px;
    }
    
    .btn-sm {
      padding: 5px 10px;
      font-size: 12px;
    }
    
    .modal-content {
      border-radius: 15px;
    }
    
    .modal-header {
      background: var(--primary-color);
      color: white;
      border-radius: 15px 15px 0 0;
    }
  </style>

</head>
<body class="hold-transition sidebar-mini layout-fixed">

<jsp:include page="../../../navbar.jsp"></jsp:include>

<jsp:include page="../../../sidebar.jsp"></jsp:include>




<!-- Alert Container for Messages -->
<div class="alert-container">
  <c:if test="${not empty successMessage}">
    <div class="alert alert-success alert-dismissible fade show" role="alert">
      ${successMessage}
      <button type="button" class="close" data-dismiss="alert" aria-label="Close">
        <span aria-hidden="true">&times;</span>
      </button>
    </div>
  </c:if>
  <c:if test="${not empty errorMessage}">
    <div class="alert alert-danger alert-dismissible fade show text-light" role="alert">
      ${errorMessage}
      <button type="button" class="close" data-dismiss="alert" aria-label="Close">
        <span aria-hidden="true">&times;</span>
      </button>
    </div>
  </c:if>
</div>

<div class="wrapper">
  <div class="content-wrapper">
    <div class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1 class="m-0">Employee Details</h1>
          </div>
        </div>
      </div>
    </div>
    
    <section class="content">
      <div class="container-fluid">
        <div class="employee-details-container">
          
          <div class="profile-card">
            <img src="images/${userDetails.profilePicture}" alt="Profile" class="profile-pic"/>
            <h2>${userDetails.firstName} ${userDetails.lastName}</h2>
            <h4>${userDetails.designationName}</h4>
            <p class="text-muted">${userDetails.departmentName} Department</p>
          </div>
          
          <div class="row">
            
            <div class="col-md-6">
              
              <div class="info-section">
                <div class="section-header">
                  <h4>Basic Information</h4>
                  <button class="add-btn" data-toggle="modal" data-target="#editBasicInfoModal">
                    <i class="fas fa-edit"></i>
                  </button>
                </div>
                <div class="row">
                  <div class="col-md-6">
                    <p><strong>Phone:</strong> ${userDetails.contactNumber}</p>
                    <p><strong>Email:</strong> ${userDetails.email}</p>
                    <p><strong>Gender:</strong> Male</p>
                  </div>
                  <div class="col-md-6">
                    <p><strong>Birthday:</strong> ${userDetails.dateOfBirth}</p>
                    <p><strong>Address:</strong> ${userDetails.address}</p>
                    <p><strong>Status:</strong> <span class="badge badge-success">${userDetails.status}</span></p>
                  </div>
                </div>
              </div>
              
              <div class="info-section">
                <div class="section-header">
                  <h4>Work Information</h4>
                </div>
                <p><strong>Role:</strong> ${userDetails.roleName}</p>
                <p><strong>Department:</strong> ${userDetails.departmentName}</p>
                <p><strong>Designation:</strong> ${userDetails.designationName}</p>
                <p><strong>Date of Joining:</strong> ${userDetails.dateOfJoining}</p>
                <p><strong>Reporting Manager:</strong> 
                  <c:if test="${userDetails.reportingManager > 0}">
                    Manager Name
                  </c:if>
                  <c:if test="${userDetails.reportingManager <= 0}">
                    Not Assigned
                  </c:if>
                </p>
              </div>
              
              <div class="info-section">
                <div class="section-header">
                  <h4>Bank Information</h4>
                  <button class="add-btn" data-toggle="modal" data-target="#addBankModal">
                    <i class="fas fa-plus"></i>
                  </button>
                </div>
                <c:forEach var="bank" items="${bankDetails}">
                  <div class="detail-item">
                    <p><strong>Bank:</strong> ${bank.bankName}</p>
                    <p><strong>Account:</strong> ${bank.accountNumber}</p>
                    <p><strong>IFSC:</strong> ${bank.ifscCode}</p>
                    <div class="action-buttons">
                      <button class="btn btn-primary btn-sm" 
                              data-toggle="modal" 
                              data-target="#editBankModal"
                              data-bankid="${bank.bankDetailId}"
                              data-bankname="${bank.bankName}"
                              data-accountnumber="${bank.accountNumber}"
                              data-ifsccode="${bank.ifscCode}">
                        Edit
                      </button>
                      <form action="UserDetailServlet" method="post" style="display:inline;">
                        <input type="hidden" name="action" value="delete">
                        <input type="hidden" name="type" value="bank">
                        <input type="hidden" name="id" value="${bank.bankDetailId}">
                        <button type="submit" class="btn btn-danger btn-sm" 
                                onclick="return confirm('Are you sure you want to delete this bank account?')">
                          Delete
                        </button>
                      </form>
                    </div>
                  </div>
                </c:forEach>
                <c:if test="${empty bankDetails}">
                  <p class="text-muted">No bank information added yet.</p>
                </c:if>
              </div>
            </div>
            
            <div class="col-md-6">
              
              <div class="info-section">
                <div class="section-header">
                  <h4>About Employee</h4>
                  <button class="add-btn" data-toggle="modal" data-target="#editAboutModal">
                    <i class="fas fa-edit"></i>
                  </button>
                </div>
                <p>${not empty userDetails.aboutEmployee ? userDetails.aboutEmployee : 'No information provided yet.'}</p>
              </div>
              
              <div class="info-section">
                <div class="section-header">
                  <h4>Family Information</h4>
                  <button class="add-btn" data-toggle="modal" data-target="#addFamilyModal">
                    <i class="fas fa-plus"></i>
                  </button>
                </div>
                <c:forEach var="family" items="${familyDetails}">
                  <div class="detail-item">
                    <p><strong>Name:</strong> ${family.name}</p>
                    <p><strong>Relation:</strong> ${family.relation}</p>
                    <p><strong>DOB:</strong> ${family.dateOfBirth}</p>
                    <p><strong>Contact:</strong> ${family.contactNumber}</p>
                    <div class="action-buttons">
                      <button class="btn btn-primary btn-sm" 
                              data-toggle="modal" 
                              data-target="#editFamilyModal"
                              data-familyid="${family.familyDetailsId}"
                              data-name="${family.name}"
                              data-relation="${family.relation}"
                              data-dob="${family.dateOfBirth}"
                              data-contact="${family.contactNumber}">
                        Edit
                      </button>
                      <form action="UserDetailServlet" method="post" style="display:inline;">
                        <input type="hidden" name="action" value="delete">
                        <input type="hidden" name="type" value="family">
                        <input type="hidden" name="id" value="${family.familyDetailsId}">
                        <button type="submit" class="btn btn-danger btn-sm" 
                                onclick="return confirm('Are you sure you want to delete this family member?')">
                          Delete
                        </button>
                      </form>
                    </div>
                  </div>
                </c:forEach>
                <c:if test="${empty familyDetails}">
                  <p class="text-muted">No family information added yet.</p>
                </c:if>
              </div>
              
              <div class="info-section">
                <div class="section-header">
                  <h4>Education Details</h4>
                  <button class="add-btn" data-toggle="modal" data-target="#addEducationModal">
                    <i class="fas fa-plus"></i>
                  </button>
                </div>
                <c:forEach var="education" items="${educationDetails}">
                  <div class="detail-item">
                    <p><strong>Degree:</strong> ${education.educationName}</p>
                    <p><strong>University:</strong> ${education.universityName}</p>
                    <p><strong>Period:</strong> ${education.startDate} to ${education.endDate}</p>
                    <div class="action-buttons">
                      <button class="btn btn-primary btn-sm" 
                              data-toggle="modal" 
                              data-target="#editEducationModal"
                              data-educationid="${education.educationDetailId}"
                              data-educationname="${education.educationName}"
                              data-universityname="${education.universityName}"
                              data-startdate="${education.startDate}"
                              data-enddate="${education.endDate}">
                        Edit
                      </button>
                      <form action="UserDetailServlet" method="post" style="display:inline;">
                        <input type="hidden" name="action" value="delete">
                        <input type="hidden" name="type" value="education">
                        <input type="hidden" name="id" value="${education.educationDetailId}">
                        <button type="submit" class="btn btn-danger btn-sm" 
                                onclick="return confirm('Are you sure you want to delete this education detail?')">
                          Delete
                        </button>
                      </form>
                    </div>
                  </div>
                </c:forEach>
                <c:if test="${empty educationDetails}">
                  <p class="text-muted">No education information added yet.</p>
                </c:if>
              </div>
              
              <div class="info-section">
                <div class="section-header">
                  <h4>Experience</h4>
                  <button class="add-btn" data-toggle="modal" data-target="#addExperienceModal">
                    <i class="fas fa-plus"></i>
                  </button>
                </div>
                <c:forEach var="experience" items="${experienceDetails}">
                  <div class="detail-item">
                    <p><strong>Company:</strong> ${experience.companyName}</p>
                    <p><strong>Position:</strong> ${experience.designationName}</p>
                    <p><strong>Period:</strong> ${experience.fromDate} to ${experience.toDate}</p>
                    <div class="action-buttons">
                      <button class="btn btn-primary btn-sm" 
                              data-toggle="modal" 
                              data-target="#editExperienceModal"
                              data-experienceid="${experience.experienceDetailId}"
                              data-companyname="${experience.companyName}"
                              data-designationname="${experience.designationName}"
                              data-fromdate="${experience.fromDate}"
                              data-todate="${experience.toDate}">
                        Edit
                      </button>
                      <form action="UserDetailServlet" method="post" style="display:inline;">
                        <input type="hidden" name="action" value="delete">
                        <input type="hidden" name="type" value="experience">
                        <input type="hidden" name="id" value="${experience.experienceDetailId}">
                        <button type="submit" class="btn btn-danger btn-sm" 
                                onclick="return confirm('Are you sure you want to delete this experience?')">
                          Delete
                        </button>
                      </form>
                    </div>
                  </div>
                </c:forEach>
                <c:if test="${empty experienceDetails}">
                  <p class="text-muted">No experience information added yet.</p>
                </c:if>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
  </div>
</div>

<!-- ========== MODALS ========== -->

<!-- Add Bank Modal -->
<div class="modal fade" id="addBankModal" tabindex="-1" role="dialog" aria-labelledby="addBankModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="addBankModalLabel">Add Bank Information</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <form action="UserDetailServlet" method="post">
        <div class="modal-body">
          <input type="hidden" name="action" value="add">
          <input type="hidden" name="type" value="bank">
          <div class="form-group">
            <label>Bank Name *</label>
            <input type="text" name="bankName" class="form-control" required>
          </div>
          <div class="form-group">
            <label>Account Number *</label>
            <input type="text" name="accountNumber" class="form-control" required 
                   pattern="[0-9]{9,18}" title="Account number should be 9-18 digits">
          </div>
          <div class="form-group">
            <label>IFSC Code *</label>
            <input type="text" name="ifscCode" class="form-control" required >
          </div>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
          <button type="submit" class="btn btn-primary">Save</button>
        </div>
      </form>
    </div>
  </div>
</div>

<!-- Edit Bank Modal -->
<div class="modal fade" id="editBankModal" tabindex="-1" role="dialog" aria-labelledby="editBankModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="editBankModalLabel">Edit Bank Information</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <form action="UserDetailServlet" method="post">
        <div class="modal-body">
          <input type="hidden" name="action" value="update">
          <input type="hidden" name="type" value="bank">
          <input type="hidden" name="id" id="editBankId">
          <div class="form-group">
            <label>Bank Name *</label>
            <input type="text" name="bankName" id="editBankName" class="form-control" required>
          </div>
          <div class="form-group">
            <label>Account Number *</label>
            <input type="text" name="accountNumber" id="editAccountNumber" class="form-control" required 
                   pattern="[0-9]{9,18}" title="Account number should be 9-18 digits">
          </div>
          <div class="form-group">
            <label>IFSC Code *</label>
            <input type="text" name="ifscCode" id="editIfscCode" class="form-control" required 
                   >
          </div>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
          <button type="submit" class="btn btn-primary">Update</button>
        </div>
      </form>
    </div>
  </div>
</div>

<!-- Add Family Modal -->
<div class="modal fade" id="addFamilyModal" tabindex="-1" role="dialog" aria-labelledby="addFamilyModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="addFamilyModalLabel">Add Family Member</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <form action="UserDetailServlet" method="post">
        <div class="modal-body">
          <input type="hidden" name="action" value="add">
          <input type="hidden" name="type" value="family">
          <div class="form-group">
            <label>Name *</label>
            <input type="text" name="name" class="form-control" required>
          </div>
          <div class="form-group">
            <label>Relation *</label>
            <select name="relation" class="form-control" required>
              <option value="">Select Relation</option>
              <option value="Father">Father</option>
              <option value="Mother">Mother</option>
              <option value="Spouse">Spouse</option>
              <option value="Son">Son</option>
              <option value="Daughter">Daughter</option>
              <option value="Brother">Brother</option>
              <option value="Sister">Sister</option>
              <option value="Grandfather">Grandfather</option>
              <option value="Grandmother">Grandmother</option>
              <option value="Other">Other</option>
            </select>
          </div>
          <div class="form-group">
            <label>Date of Birth</label>
            <input type="date" name="dateOfBirth" class="form-control">
          </div>
          <div class="form-group">
            <label>Contact Number</label>
            <input type="text" name="contactNumber" class="form-control" 
                   pattern="[0-9]{10}" title="10 digit phone number">
          </div>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
          <button type="submit" class="btn btn-primary">Save</button>
        </div>
      </form>
    </div>
  </div>
</div>

<!-- Edit Family Modal -->
<div class="modal fade" id="editFamilyModal" tabindex="-1" role="dialog" aria-labelledby="editFamilyModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="editFamilyModalLabel">Edit Family Member</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <form action="UserDetailServlet" method="post">
        <div class="modal-body">
          <input type="hidden" name="action" value="update">
          <input type="hidden" name="type" value="family">
          <input type="hidden" name="id" id="editFamilyId">
          <div class="form-group">
            <label>Name *</label>
            <input type="text" name="name" id="editFamilyName" class="form-control" required>
          </div>
          <div class="form-group">
            <label>Relation *</label>
            <select name="relation" id="editFamilyRelation" class="form-control" required>
              <option value="">Select Relation</option>
              <option value="Father">Father</option>
              <option value="Mother">Mother</option>
              <option value="Spouse">Spouse</option>
              <option value="Son">Son</option>
              <option value="Daughter">Daughter</option>
              <option value="Brother">Brother</option>
              <option value="Sister">Sister</option>
              <option value="Grandfather">Grandfather</option>
              <option value="Grandmother">Grandmother</option>
              <option value="Other">Other</option>
            </select>
          </div>
          <div class="form-group">
            <label>Date of Birth</label>
            <input type="date" name="dateOfBirth" id="editFamilyDob" class="form-control">
          </div>
          <div class="form-group">
            <label>Contact Number</label>
            <input type="text" name="contactNumber" id="editFamilyContact" class="form-control" 
                   pattern="[0-9]{10}" title="10 digit phone number">
          </div>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
          <button type="submit" class="btn btn-primary">Update</button>
        </div>
      </form>
    </div>
  </div>
</div>

<!-- Add Education Modal -->
<div class="modal fade" id="addEducationModal" tabindex="-1" role="dialog" aria-labelledby="addEducationModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="addEducationModalLabel">Add Education</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <form action="UserDetailServlet" method="post">
        <div class="modal-body">
          <input type="hidden" name="action" value="add">
          <input type="hidden" name="type" value="education">
          <div class="form-group">
            <label>Education Name *</label>
            <input type="text" name="educationName" class="form-control" required>
          </div>
          <div class="form-group">
            <label>University Name *</label>
            <input type="text" name="universityName" class="form-control" required>
          </div>
          <div class="form-group">
            <label>Start Date *</label>
            <input type="date" name="startDate" class="form-control" required>
          </div>
          <div class="form-group">
            <label>End Date</label>
            <input type="date" name="endDate" class="form-control">
          </div>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
          <button type="submit" class="btn btn-primary">Save</button>
        </div>
      </form>
    </div>
  </div>
</div>

<!-- Edit Education Modal -->
<div class="modal fade" id="editEducationModal" tabindex="-1" role="dialog" aria-labelledby="editEducationModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="editEducationModalLabel">Edit Education</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <form action="UserDetailServlet" method="post">
        <div class="modal-body">
          <input type="hidden" name="action" value="update">
          <input type="hidden" name="type" value="education">
          <input type="hidden" name="id" id="editEducationId">
          <div class="form-group">
            <label>Education Name *</label>
            <input type="text" name="educationName" id="editEducationName" class="form-control" required>
          </div>
          <div class="form-group">
            <label>University Name *</label>
            <input type="text" name="universityName" id="editUniversityName" class="form-control" required>
          </div>
          <div class="form-group">
            <label>Start Date *</label>
            <input type="date" name="startDate" id="editStartDate" class="form-control" required>
          </div>
          <div class="form-group">
            <label>End Date</label>
            <input type="date" name="endDate" id="editEndDate" class="form-control">
          </div>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
          <button type="submit" class="btn btn-primary">Update</button>
        </div>
      </form>
    </div>
  </div>
</div>

<!-- Add Experience Modal -->
<div class="modal fade" id="addExperienceModal" tabindex="-1" role="dialog" aria-labelledby="addExperienceModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="addExperienceModalLabel">Add Experience</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <form action="UserDetailServlet" method="post">
        <div class="modal-body">
          <input type="hidden" name="action" value="add">
          <input type="hidden" name="type" value="experience">
          <div class="form-group">
            <label>Company Name *</label>
            <input type="text" name="companyName" class="form-control" required>
          </div>
          <div class="form-group">
            <label>Designation *</label>
            <input type="text" name="designationName" class="form-control" required>
          </div>
          <div class="form-group">
            <label>From Date *</label>
            <input type="date" name="fromDate" class="form-control" required>
          </div>
          <div class="form-group">
            <label>To Date</label>
            <input type="date" name="toDate" class="form-control">
            <small class="form-text text-muted">Leave empty if current job</small>
          </div>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
          <button type="submit" class="btn btn-primary">Save</button>
        </div>
      </form>
    </div>
  </div>
</div>

<!-- Edit Experience Modal -->
<div class="modal fade" id="editExperienceModal" tabindex="-1" role="dialog" aria-labelledby="editExperienceModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="editExperienceModalLabel">Edit Experience</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <form action="UserDetailServlet" method="post">
        <div class="modal-body">
          <input type="hidden" name="action" value="update">
          <input type="hidden" name="type" value="experience">
          <input type="hidden" name="id" id="editExperienceId">
          <div class="form-group">
            <label>Company Name *</label>
            <input type="text" name="companyName" id="editCompanyName" class="form-control" required>
          </div>
          <div class="form-group">
            <label>Designation *</label>
            <input type="text" name="designationName" id="editDesignationName" class="form-control" required>
          </div>
          <div class="form-group">
            <label>From Date *</label>
            <input type="date" name="fromDate" id="editFromDate" class="form-control" required>
          </div>
          <div class="form-group">
            <label>To Date</label>
            <input type="date" name="toDate" id="editToDate" class="form-control">
            <small class="form-text text-muted">Leave empty if current job</small>
          </div>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
          <button type="submit" class="btn btn-primary">Update</button>
        </div>
      </form>
    </div>
  </div>
</div>

<!-- Edit About Modal -->
<div class="modal fade" id="editAboutModal" tabindex="-1" role="dialog" aria-labelledby="editAboutModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="editAboutModalLabel">Edit About Information</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <form action="UserDetailServlet" method="post">
        <div class="modal-body">
          <input type="hidden" name="action" value="add">
          <input type="hidden" name="type" value="about">
          <div class="form-group">
            <label>About Employee</label>
            <textarea name="aboutEmployee" class="form-control" rows="5">${userDetails.aboutEmployee}</textarea>
          </div>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
          <button type="submit" class="btn btn-primary">Save</button>
        </div>
      </form>
    </div>
  </div>
</div>

<!-- Edit Basic Information Modal -->
<div class="modal fade" id="editBasicInfoModal" tabindex="-1" role="dialog" aria-labelledby="editBasicInfoModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="editBasicInfoModalLabel">Edit Basic Information</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <form action="UserDetailServlet" method="post" enctype="multipart/form-data">
        <div class="modal-body">
          <input type="hidden" name="action" value="update">
          <input type="hidden" name="type" value="basic">
          <input type="hidden" name="userId" value="${userDetails.userId}">
          
          <div class="row">
            <!-- Profile Picture Section -->
            <div class="col-md-4 text-center">
              <div class="form-group">
                <label>Current Profile Picture</label>
                <div class="text-center mb-3">
                  <img src="images/${userDetails.profilePicture}" alt="Profile" class="profile-pic" id="currentProfilePic" 
                       style="width: 150px; height: 150px; border-radius: 50%; object-fit: cover; border: 3px solid #3c8dbc;">
                </div>
                <div class="custom-file">
                  <input type="file" class="custom-file-input" id="profilePicture" name="profilePicture" accept="image/*" 
                         onchange="previewImage(this)">
                  <label class="custom-file-label" for="profilePicture">Choose new image</label>
                </div>
                <small class="form-text text-muted">Recommended: 150x150 px, JPG/PNG format</small>
              </div>
            </div>
            
            <!-- Personal Information Section -->
            <div class="col-md-8">
              <div class="row">
                <div class="col-md-6">
                  <div class="form-group">
                    <label>First Name *</label>
                    <input type="text" name="firstName" class="form-control" value="${userDetails.firstName}" required>
                  </div>
                </div>
                <div class="col-md-6">
                  <div class="form-group">
                    <label>Last Name *</label>
                    <input type="text" name="lastName" class="form-control" value="${userDetails.lastName}" required>
                  </div>
                </div>
              </div>
              
              <div class="row">
                <div class="col-md-6">
                  <div class="form-group">
                    <label>Email *</label>
                    <input type="email" name="email" class="form-control" value="${userDetails.email}" required>
                  </div>
                </div>
                <div class="col-md-6">
                  <div class="form-group">
                    <label>Phone Number *</label>
                    <input type="tel" name="contactNumber" class="form-control" value="${userDetails.contactNumber}" 
                           pattern="[0-9]{10}" title="10 digit phone number" required>
                  </div>
                </div>
              </div>
              
              <div class="row">
                <div class="col-md-6">
                  <div class="form-group">
                    <label>Date of Birth *</label>
                    <input type="date" name="dateOfBirth" class="form-control" value="${userDetails.dateOfBirth}" required>
                  </div>
                </div>
                
              </div>
            </div>
          </div>
          
          <div class="form-group">
            <label>Address *</label>
            <textarea name="address" class="form-control" rows="3" required>${userDetails.address}</textarea>
          </div>
          
          <div class="row">
            <div class="col-md-6">
              <div class="form-group">
                <label>About Employee</label>
                <textarea name="aboutEmployee" class="form-control" rows="2">${userDetails.aboutEmployee}</textarea>
              </div>
            </div>
          </div>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
          <button type="submit" class="btn btn-primary">Update Information</button>
        </div>
      </form>
    </div>
  </div>
</div>




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
	
	
<script src="https://cdn.jsdelivr.net/npm/bs-custom-file-input@1.3.4/dist/bs-custom-file-input.min.js"></script>

<script>
  $(document).ready(function() {
    // Initialize Bootstrap custom file input
    bsCustomFileInput.init();
    
    // Auto-dismiss alerts after 5 seconds
    setTimeout(function() {
      $('.alert').alert('close');
    }, 5000);

    // Bank modal handler
    $('#editBankModal').on('show.bs.modal', function (event) {
      var button = $(event.relatedTarget);
      var bankId = button.data('bankid');
      var bankName = button.data('bankname');
      var accountNumber = button.data('accountnumber');
      var ifscCode = button.data('ifsccode');
      
      var modal = $(this);
      modal.find('#editBankId').val(bankId);
      modal.find('#editBankName').val(bankName);
      modal.find('#editAccountNumber').val(accountNumber);
      modal.find('#editIfscCode').val(ifscCode);
    });

    // Family modal handler
    $('#editFamilyModal').on('show.bs.modal', function (event) {
      var button = $(event.relatedTarget);
      var familyId = button.data('familyid');
      var name = button.data('name');
      var relation = button.data('relation');
      var dob = button.data('dob');
      var contact = button.data('contact');
      
      var modal = $(this);
      modal.find('#editFamilyId').val(familyId);
      modal.find('#editFamilyName').val(name);
      modal.find('#editFamilyRelation').val(relation);
      modal.find('#editFamilyDob').val(dob);
      modal.find('#editFamilyContact').val(contact);
    });

    // Education modal handler
    $('#editEducationModal').on('show.bs.modal', function (event) {
      var button = $(event.relatedTarget);
      var educationId = button.data('educationid');
      var educationName = button.data('educationname');
      var universityName = button.data('universityname');
      var startDate = button.data('startdate');
      var endDate = button.data('enddate');
      
      var modal = $(this);
      modal.find('#editEducationId').val(educationId);
      modal.find('#editEducationName').val(educationName);
      modal.find('#editUniversityName').val(universityName);
      modal.find('#editStartDate').val(startDate);
      modal.find('#editEndDate').val(endDate);
    });

    // Experience modal handler
    $('#editExperienceModal').on('show.bs.modal', function (event) {
      var button = $(event.relatedTarget);
      var experienceId = button.data('experienceid');
      var companyName = button.data('companyname');
      var designationName = button.data('designationname');
      var fromDate = button.data('fromdate');
      var toDate = button.data('todate');
      
      var modal = $(this);
      modal.find('#editExperienceId').val(experienceId);
      modal.find('#editCompanyName').val(companyName);
      modal.find('#editDesignationName').val(designationName);
      modal.find('#editFromDate').val(fromDate);
      modal.find('#editToDate').val(toDate);
    });

    // Basic Info modal handler
    $('#editBasicInfoModal').on('show.bs.modal', function() {
      // Reset file input
      $('#profilePicture').val('');
      $('.custom-file-label').html('Choose new image');
      
      // Reset image preview to original
      var currentProfilePic = document.getElementById('currentProfilePic');
      if (currentProfilePic) {
        currentProfilePic.src = 'images/${userDetails.profilePicture}';
      }
    });

    // Form validation
    $('form').on('submit', function() {
      // Add any additional form validation here
      var form = $(this);
      
      // Basic required field validation
      var isValid = true;
      form.find('[required]').each(function() {
        if ($(this).val() === '') {
          isValid = false;
          $(this).addClass('is-invalid');
        } else {
          $(this).removeClass('is-invalid');
        }
      });
      
      return isValid;
    });

    // Clear validation errors when modal is hidden
    $('.modal').on('hidden.bs.modal', function() {
      $(this).find('.is-invalid').removeClass('is-invalid');
    });
  });

  // Function to preview selected image
  function previewImage(input) {
    if (input.files && input.files[0]) {
      var reader = new FileReader();
      
      reader.onload = function(e) {
        var previewElement = document.getElementById('currentProfilePic');
        if (previewElement) {
          previewElement.src = e.target.result;
        }
      }
      
      reader.readAsDataURL(input.files[0]);
      
      // Update the file input label
      var fileName = input.files[0].name;
      $(input).next('.custom-file-label').html(fileName);
    }
  }

  // Enhanced file input validation
  function validateFile(input) {
    const file = input.files[0];
    if (!file) return true;
    
    const validImageTypes = ['image/jpeg', 'image/png', 'image/gif', 'image/jpg'];
    const maxSize = 5 * 1024 * 1024; // 5MB
    
    if (!validImageTypes.includes(file.type)) {
      alert('Please select a valid image file (JPEG, PNG, GIF)');
      input.value = '';
      return false;
    }
    
    if (file.size > maxSize) {
      alert('File size must be less than 5MB');
      input.value = '';
      return false;
    }
    
    return true;
  }

  // Enhanced form submission with confirmation
  function confirmSubmit(form, message) {
    if (confirm(message || 'Are you sure you want to proceed?')) {
      form.submit();
    }
    return false;
  }

  // Delete confirmation for all delete buttons
  $(document).on('click', 'form[action*="UserDetailServlet"] button[type="submit"]', function(e) {
    var form = $(this).closest('form');
    var action = form.find('input[name="action"]').val();
    var type = form.find('input[name="type"]').val();
    
    if (action === 'delete') {
      e.preventDefault();
      var message = 'Are you sure you want to delete this ' + type + '?';
      if (confirm(message)) {
        form.submit();
      }
    }
  });
</script>

<style>
  .custom-file-input:focus ~ .custom-file-label {
    border-color: #3c8dbc;
    box-shadow: 0 0 0 0.2rem rgba(60, 141, 188, 0.25);
  }
  
  .custom-file-label::after {
    content: "Browse";
    background-color: #3c8dbc;
    color: white;
    border-left: 1px solid #2d7ca9;
  }
  
  .custom-file-label {
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
  }
  
  .is-invalid {
    border-color: #dc3545 !important;
  }
  
  .invalid-feedback {
    display: none;
    width: 100%;
    margin-top: 0.25rem;
    font-size: 80%;
    color: #dc3545;
  }
  
  .is-invalid ~ .invalid-feedback {
    display: block;
  }
  
  /* Smooth transitions for modals */
  .modal-content {
    transition: all 0.3s ease;
  }
  
  /* Loading indicator for form submissions */
  .btn-loading {
    position: relative;
    color: transparent !important;
  }
  
  .btn-loading:after {
    content: '';
    position: absolute;
    left: 50%;
    top: 50%;
    width: 20px;
    height: 20px;
    margin: -10px 0 0 -10px;
    border: 2px solid #ffffff;
    border-radius: 50%;
    border-top-color: transparent;
    animation: spin 1s linear infinite;
  }
  
  @keyframes spin {
    to { transform: rotate(360deg); }
  }
</style>
	
	
</body>
</html>