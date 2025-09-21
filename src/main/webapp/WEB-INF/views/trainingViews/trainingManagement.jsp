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
  <link rel="stylesheet" href="plugins/summernote/summernote-bs4.min.css">
<script data-cfasync="false" nonce="06cb1374-3a81-4a88-aebe-16de25f6e552">try{(function(w,d){!function(j,k,l,m){if(j.zaraz)console.error("zaraz is loaded twice");else{j[l]=j[l]||{};j[l].executed=[];j.zaraz={deferred:[],listeners:[]};j.zaraz._v="5870";j.zaraz._n="06cb1374-3a81-4a88-aebe-16de25f6e552";j.zaraz.q=[];j.zaraz._f=function(n){return async function(){var o=Array.prototype.slice.call(arguments);j.zaraz.q.push({m:n,a:o})}};for(const p of["track","set","debug"])j.zaraz[p]=j.zaraz._f(p);j.zaraz.init=()=>{var q=k.getElementsByTagName(m)[0],r=k.createElement(m),s=k.getElementsByTagName("title")[0];s&&(j[l].t=k.getElementsByTagName("title")[0].text);j[l].x=Math.random();j[l].w=j.screen.width;j[l].h=j.screen.height;j[l].j=j.innerHeight;j[l].e=j.innerWidth;j[l].l=j.location.href;j[l].r=k.referrer;j[l].k=j.screen.colorDepth;j[l].n=k.characterSet;j[l].o=(new Date).getTimezoneOffset();if(j.dataLayer)for(const t of Object.entries(Object.entries(dataLayer).reduce((u,v)=>({...u[1],...v[1]}),{})))zaraz.set(t[0],t[1],{scope:"page"});j[l].q=[];for(;j.zaraz.q.length;){const w=j.zaraz.q.shift();j[l].q.push(w)}r.defer=!0;for(const x of[localStorage,sessionStorage])Object.keys(x||{}).filter(z=>z.startsWith("_zaraz_")).forEach(y=>{try{j[l]["z_"+y.slice(7)]=JSON.parse(x.getItem(y))}catch{j[l]["z_"+y.slice(7)]=x.getItem(y)}});r.referrerPolicy="origin";r.src="../../cdn-cgi/zaraz/sd0d9.js?z="+btoa(encodeURIComponent(JSON.stringify(j[l])));q.parentNode.insertBefore(r,q)};["complete","interactive"].includes(k.readyState)?zaraz.init():j.addEventListener("DOMContentLoaded",zaraz.init)}}(w,d,"zarazData","script");window.zaraz._p=async bs=>new Promise(bt=>{if(bs){bs.e&&bs.e.forEach(bu=>{try{const bv=d.querySelector("script[nonce]"),bw=bv?.nonce||bv?.getAttribute("nonce"),bx=d.createElement("script");bw&&(bx.nonce=bw);bx.innerHTML=bu;bx.onload=()=>{d.head.removeChild(bx)};d.head.appendChild(bx)}catch(by){console.error(`Error executing script: ${bu}\n`,by)}});Promise.allSettled((bs.f||[]).map(bz=>fetch(bz[0],bz[1])))}bt()});zaraz._p({"e":["(function(w,d){})(window,document)"]});})(window,document)}catch(e){throw fetch("/cdn-cgi/zaraz/t"),e;};</script>

 <!-- DataTables -->
  <link rel="stylesheet" href="plugins/datatables-bs4/css/dataTables.bootstrap4.min.css">
  <link rel="stylesheet" href="plugins/datatables-responsive/css/responsive.bootstrap4.min.css">
  <link rel="stylesheet" href="plugins/datatables-buttons/css/buttons.bootstrap4.min.css">
  
  
   <style>
    .action-buttons .btn {
        margin-right: 5px;
    }
    .status-badge {
        font-size: 0.85rem;
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

            <div class="card">
              <div class="card-header bg-success text-white d-flex justify-content-between align-items-center">
                <h4 class="mb-0"><i class="fas fa-graduation-cap me-2"></i>Trainings Management</h4>
                <a href="training?action=new" class="btn bg-primary text-dark">
                  <i class="fas fa-plus me-1 "></i> Add New Training
                </a>
              </div>
              <div class="card-body">
                
                <!-- Success/Error Messages -->
                <c:if test="${not empty message}">
                  <div class="alert alert-info alert-dismissible fade show" role="alert">
                    ${message}
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                      <span aria-hidden="true">&times;</span>
                    </button>
                  </div>
                  <c:remove var="message" scope="session" />
                </c:if>
                
                <!-- Trainings Table -->
                <div class="table-responsive">
                   <table id="example1" class="table table-bordered table-striped">
                    <thead class="table-dark">
                      <tr>
                        <th>ID</th>
                        <th>Training Type</th>
                        <th>Trainer</th>
                        <th>Employee</th>
                        <th>Start Date</th>
                        <th>End Date</th>
                        <th>Cost</th>
                        <th>Status</th>
                        <th>Actions</th>
                      </tr>
                    </thead>
                    <tbody>
                      <c:forEach var="training" items="${trainings}">
                        <tr>
                          <td>${training.trainingId}</td>
                          <td>${training.trainingTypeName}</td>
                          <td>${training.trainerName}</td>
                          <td>${training.userName}</td>
                          <td>${training.startDate}</td>
                          <td>${training.endDate}</td>
                          <td>$${training.trainingCost}</td>
                          <td>
                            <span class="badge ${training.status == 'ACTIVE' ? 'bg-success' : 'bg-danger'} status-badge">
                              ${training.status}
                            </span>
                          </td>
                          <td class="action-buttons">
                            <a href="training?action=edit&id=${training.trainingId}" class="btn btn-sm btn-warning">
                              <i class="fas fa-edit"></i> 
                            </a>
                            <form method="post" action="training" style="display:inline;">
                              <input type="hidden" name="action" value="delete">
                              <input type="hidden" name="id" value="${training.trainingId}">
                              <button type="submit" class="btn btn-sm btn-danger" 
                                      onclick="return confirm('Are you sure you want to delete this training?')">
                                <i class="fas fa-trash"></i> 
                              </button>
                            </form>
                          </td>
                        </tr>
                      </c:forEach>
                      <c:if test="${empty trainings}">
                        <tr>
                          <td colspan="9" class="text-center text-muted">No trainings found. Add your first training!</td>
                        </tr>
                      </c:if>
                    </tbody>
                  </table>
                </div>
              </div>
            </div>

          </div>
        </div>
      </div>
    </section>

	</div>
</div>


<!-- Add Training Modal -->
<div class="modal fade" id="addTrainingModal">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
      <form method="post" action="training">
        <input type="hidden" name="action" value="insert">
        <div class="modal-header bg-success text-white">
          <h5 class="modal-title">Add New Training</h5>
          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">&times;</span>
          </button>
        </div>
        <div class="modal-body">
          <div class="row mb-3">
            <div class="col-md-6">
              <label class="form-label required-field">Training Type</label>
              <select class="form-select" name="trainingTypeId" required>
                <option value="">Select Training Type</option>
                <c:forEach var="trainingType" items="${trainingTypes}">
                  <c:if test="${trainingType.status == 'ACTIVE'}">
                    <option value="${trainingType.trainingTypeId}">${trainingType.trainingType}</option>
                  </c:if>
                </c:forEach>
              </select>
            </div>
            <div class="col-md-6">
              <label class="form-label required-field">Trainer</label>
              <select class="form-select" name="trainerId" required>
                <option value="">Select Trainer</option>
                <c:forEach var="trainer" items="${trainers}">
                  <c:if test="${trainer.status == 'ACTIVE'}">
                    <option value="${trainer.trainerId}">
                      ${trainer.firstName} ${trainer.lastName} 
                      (${trainer.internal ? 'Internal' : 'External'})
                    </option>
                  </c:if>
                </c:forEach>
              </select>
            </div>
          </div>
          
          <div class="row mb-3">
            <div class="col-md-6">
              <label class="form-label required-field">Employee</label>
              <select class="form-select" name="userId" required>
                <option value="">Select Employee</option>
                <c:forEach var="employee" items="${employees}">
                  <option value="${employee.userId}">
                    ${employee.firstName} ${employee.lastName} - 
                    ${employee.designationName} (${employee.departmentName})
                  </option>
                </c:forEach>
              </select>
            </div>
            <div class="col-md-6">
              <label class="form-label required-field">Training Cost ($)</label>
              <input type="number" class="form-control" name="trainingCost" step="0.01" min="0" required>
            </div>
          </div>
          
          <div class="row mb-3">
            <div class="col-md-6">
              <label class="form-label required-field">Start Date</label>
              <input type="date" class="form-control" name="startDate" required>
            </div>
            <div class="col-md-6">
              <label class="form-label">End Date</label>
              <input type="date" class="form-control" name="endDate">
            </div>
          </div>
          
          <div class="row mb-3">
            <div class="col-md-6">
              <label class="form-label required-field">Status</label>
              <select class="form-select" name="status" required>
                <option value="ACTIVE">ACTIVE</option>
                <option value="INACTIVE">INACTIVE</option>
                
              </select>
            </div>
          </div>
          
          <div class="mb-3">
            <label class="form-label">Description</label>
            <textarea class="form-control" name="description" rows="3" placeholder="Enter training description"></textarea>
          </div>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
          <button type="submit" class="btn btn-success">Add Training</button>
        </div>
      </form>
    </div>
  </div>
</div>

<!-- Edit Training Modal -->
<div class="modal fade" id="updateTrainingModal" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
      <form method="post" action="training">
        <input type="hidden" name="action" value="update">
        <input type="hidden" name="trainingId" value="${training.trainingId}">
        
        <div class="modal-header bg-warning text-dark">
          <h5 class="modal-title">Update Training</h5>
          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">&times;</span>
          </button>
        </div>
        <div class="modal-body">
          <div class="row mb-3">
            <div class="col-md-6">
              <label class="form-label required-field">Training Type</label>
              <select class="form-select" name="trainingTypeId" required>
                <option value="">Select Training Type</option>
                <c:forEach var="trainingType" items="${trainingTypes}">
                  <c:if test="${trainingType.status == 'ACTIVE'}">
                    <option value="${trainingType.trainingTypeId}" 
                            ${training.trainingTypeId == trainingType.trainingTypeId ? 'selected' : ''}>
                      ${trainingType.trainingType}
                    </option>
                  </c:if>
                </c:forEach>
              </select>
            </div>
            <div class="col-md-6">
              <label class="form-label required-field">Trainer</label>
              <select class="form-select" name="trainerId" required>
                <option value="">Select Trainer</option>
                <c:forEach var="trainer" items="${trainers}">
                  <c:if test="${trainer.status == 'ACTIVE'}">
                    <option value="${trainer.trainerId}" 
                            ${training.trainerId == trainer.trainerId ? 'selected' : ''}>
                      ${trainer.firstName} ${trainer.lastName} 
                      (${trainer.internal ? 'Internal' : 'External'})
                    </option>
                  </c:if>
                </c:forEach>
              </select>
            </div>
          </div>
          
          <div class="row mb-3">
            <div class="col-md-6">
              <label class="form-label required-field">Employee</label>
              <select class="form-select" name="userId" required>
                <option value="">Select Employee</option>
                <c:forEach var="employee" items="${employees}">
                  <option value="${employee.userId}" 
                          ${training.userId == employee.userId ? 'selected' : ''}>
                    ${employee.firstName} ${employee.lastName} - 
                    ${employee.designationName} (${employee.departmentName})
                  </option>
                </c:forEach>
              </select>
            </div>
            <div class="col-md-6">
              <label class="form-label required-field">Training Cost ($)</label>
              <input type="number" class="form-control" name="trainingCost" 
                     value="${training.trainingCost}" step="0.01" min="0" required>
            </div>
          </div>
          
          <div class="row mb-3">
            <div class="col-md-6">
              <label class="form-label required-field">Start Date</label>
              <input type="date" class="form-control" name="startDate" 
                     value="${training.startDate}" required>
            </div>
            <div class="col-md-6">
              <label class="form-label">End Date</label>
              <input type="date" class="form-control" name="endDate" 
                     value="${training.endDate}">
            </div>
          </div>
          
          <div class="row mb-3">
            <div class="col-md-6">
              <label class="form-label required-field">Status</label>
              <select class="form-select" name="status" required>
                <option value="ACTIVE" ${training.status == 'ACTIVE' ? 'selected' : ''}>ACTIVE</option>
                <option value="INACTIVE" ${training.status == 'INACTIVE' ? 'selected' : ''}>INACTIVE</option>
         
              </select>
            </div>
          </div>
          
          <div class="mb-3">
            <label class="form-label">Description</label>
            <textarea class="form-control" name="description" rows="3">${training.description}</textarea>
          </div>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
          <button type="submit" class="btn btn-warning">Update Training</button>
        </div>
      </form>
    </div>
  </div>
</div>

<!-- Auto-show modals when page loads -->
<c:if test="${not empty training}">
<script>
document.addEventListener("DOMContentLoaded", function() {
    $('#updateTrainingModal').modal('show');
});
</script>
</c:if>

<c:if test="${param.action == 'new'}">
<script>
document.addEventListener("DOMContentLoaded", function() {
    $('#addTrainingModal').modal('show');
});
</script>
</c:if>



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
      "responexample1sive": true,
    });
  });
</script>	
	
</body>
</html>