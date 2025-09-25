<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Department</title>

  <!-- Google Font: Source Sans Pro -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&amp;display=fallback">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="plugins/fontawesome-free/css/all.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="../code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
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
  
    <!-- DataTables -->
  <link rel="stylesheet" href="plugins/datatables-bs4/css/dataTables.bootstrap4.min.css">
  <link rel="stylesheet" href="plugins/datatables-responsive/css/responsive.bootstrap4.min.css">
  <link rel="stylesheet" href="plugins/datatables-buttons/css/buttons.bootstrap4.min.css">
  <!-- Theme style -->
  
<script data-cfasync="false" nonce="06cb1374-3a81-4a88-aebe-16de25f6e552">try{(function(w,d){!function(j,k,l,m){if(j.zaraz)console.error("zaraz is loaded twice");else{j[l]=j[l]||{};j[l].executed=[];j.zaraz={deferred:[],listeners:[]};j.zaraz._v="5870";j.zaraz._n="06cb1374-3a81-4a88-aebe-16de25f6e552";j.zaraz.q=[];j.zaraz._f=function(n){return async function(){var o=Array.prototype.slice.call(arguments);j.zaraz.q.push({m:n,a:o})}};for(const p of["track","set","debug"])j.zaraz[p]=j.zaraz._f(p);j.zaraz.init=()=>{var q=k.getElementsByTagName(m)[0],r=k.createElement(m),s=k.getElementsByTagName("title")[0];s&&(j[l].t=k.getElementsByTagName("title")[0].text);j[l].x=Math.random();j[l].w=j.screen.width;j[l].h=j.screen.height;j[l].j=j.innerHeight;j[l].e=j.innerWidth;j[l].l=j.location.href;j[l].r=k.referrer;j[l].k=j.screen.colorDepth;j[l].n=k.characterSet;j[l].o=(new Date).getTimezoneOffset();if(j.dataLayer)for(const t of Object.entries(Object.entries(dataLayer).reduce((u,v)=>({...u[1],...v[1]}),{})))zaraz.set(t[0],t[1],{scope:"page"});j[l].q=[];for(;j.zaraz.q.length;){const w=j.zaraz.q.shift();j[l].q.push(w)}r.defer=!0;for(const x of[localStorage,sessionStorage])Object.keys(x||{}).filter(z=>z.startsWith("_zaraz_")).forEach(y=>{try{j[l]["z_"+y.slice(7)]=JSON.parse(x.getItem(y))}catch{j[l]["z_"+y.slice(7)]=x.getItem(y)}});r.referrerPolicy="origin";r.src="cdn-cgi/zaraz/sd0d9.js?z="+btoa(encodeURIComponent(JSON.stringify(j[l])));q.parentNode.insertBefore(r,q)};["complete","interactive"].includes(k.readyState)?zaraz.init():j.addEventListener("DOMContentLoaded",zaraz.init)}}(w,d,"zarazData","script");window.zaraz._p=async bs=>new Promise(bt=>{if(bs){bs.e&&bs.e.forEach(bu=>{try{const bv=d.querySelector("script[nonce]"),bw=bv?.nonce||bv?.getAttribute("nonce"),bx=d.createElement("script");bw&&(bx.nonce=bw);bx.innerHTML=bu;bx.onload=()=>{d.head.removeChild(bx)};d.head.appendChild(bx)}catch(by){console.error(`Error executing script: ${bu}\n`,by)}});Promise.allSettled((bs.f||[]).map(bz=>fetch(bz[0],bz[1])))}bt()});zaraz._p({"e":["(function(w,d){})(window,document)"]});})(window,document)}catch(e){throw fetch("/cdn-cgi/zaraz/t"),e;};</script>


<style>
  /* Custom Styles for Department Management */
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
  
  /* Card Styling */
  .card {
    box-shadow: 0 4px 12px rgba(0,0,0,0.1);
    border: none;
    border-radius: 12px;
    margin-bottom: 25px;
  }
  
  .card-header {
    background: linear-gradient(135deg, var(--primary-color), #2d7ca9);
    color: white;
    border-radius: 12px 12px 0 0 !important;
    padding: 20px 25px;
    border-bottom: none;
  }
  
  .card-title {
    font-weight: 600;
    margin: 0;
    font-size: 1.5rem;
  }
  
  /* Table Styling */
  .table {
    border-collapse: separate;
    border-spacing: 0;
    width: 100%;
    margin: 0;
  }
  
  .table th {
    background: linear-gradient(135deg, #f8f9fa, #e9ecef);
    color: var(--dark-color);
    font-weight: 600;
    padding: 16px 20px;
    border-bottom: 2px solid #dee2e6;
    font-size: 14px;
    text-transform: uppercase;
    letter-spacing: 0.5px;
  }
  
  .table td {
    padding: 14px 20px;
    vertical-align: middle;
    border-bottom: 1px solid #eee;
    font-size: 14px;
    transition: background-color 0.2s ease;
  }
  
  .table tr:hover td {
    background-color: rgba(60, 141, 188, 0.05);
  }
  
  /* Status Badges */
  .badge {
    font-size: 12px;
    padding: 6px 12px;
    border-radius: 20px;
    font-weight: 500;
  }
  
  .badge-success {
    background: linear-gradient(135deg, var(--success-color), #218838);
  }
  
  .badge-danger {
    background: linear-gradient(135deg, var(--danger-color), #c82333);
  }
  
  .badge-warning {
    background: linear-gradient(135deg, var(--warning-color), #e0a800);
  }
  
  /* Action Buttons */
  .action-buttons {
    display: flex;
    gap: 8px;
    flex-wrap: nowrap;
  }
  
  .action-buttons .btn {
    padding: 6px 12px;
    font-size: 13px;
    border-radius: 6px;
    transition: all 0.3s ease;
  }
  
  .action-buttons .btn-outline-primary {
    border: 1.5px solid var(--primary-color);
    color: var(--primary-color);
  }
  
  .action-buttons .btn-outline-primary:hover {
    background: var(--primary-color);
    color: white;
    transform: translateY(-1px);
    box-shadow: 0 4px 8px rgba(60, 141, 188, 0.3);
  }
  
  .action-buttons .btn-outline-danger {
    border: 1.5px solid var(--danger-color);
    color: var(--danger-color);
  }
  
  .action-buttons .btn-outline-danger:hover {
    background: var(--danger-color);
    color: white;
    transform: translateY(-1px);
    box-shadow: 0 4px 8px rgba(220, 53, 69, 0.3);
  }
  
  /* Modal Styling */
  .modal-content {
    border-radius: 15px;
    border: none;
    box-shadow: 0 10px 40px rgba(0,0,0,0.2);
  }
  
  .modal-header {
    background: linear-gradient(135deg, var(--primary-color), #2d7ca9);
    color: white;
    border-radius: 15px 15px 0 0;
    padding: 20px;
    border-bottom: none;
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
    border-radius: 0 0 15px 15px;
  }
  
  /* Form Styling */
  .form-control {
    border-radius: 8px;
    border: 2px solid #e9ecef;
    padding: 12px 16px;
    transition: all 0.3s ease;
    font-size: 14px;
  }
  
  .form-control:focus {
    border-color: var(--primary-color);
    box-shadow: 0 0 0 0.3rem rgba(60, 141, 188, 0.25);
    transform: translateY(-1px);
  }
  
  .form-label {
    font-weight: 600;
    color: var(--dark-color);
    margin-bottom: 8px;
    font-size: 14px;
  }
  
  .form-select {
    border-radius: 8px;
    border: 2px solid #e9ecef;
    padding: 12px 16px;
    transition: all 0.3s ease;
  }
  
  .form-select:focus {
    border-color: var(--primary-color);
    box-shadow: 0 0 0 0.3rem rgba(60, 141, 188, 0.25);
  }
  
  /* Button Styling */
  .btn {
    border-radius: 8px;
    font-weight: 500;
    padding: 10px 20px;
    transition: all 0.3s ease;
    border: none;
  }
  
  .btn-primary {
    background: linear-gradient(135deg, var(--primary-color), #2d7ca9);
  }
  
  .btn-primary:hover {
    transform: translateY(-2px);
    box-shadow: 0 6px 15px rgba(60, 141, 188, 0.4);
  }
  
  .btn-success {
    background: linear-gradient(135deg, var(--success-color), #218838);
  }
  
  .btn-default.bg-success {
    background: linear-gradient(135deg, var(--success-color), #218838);
    color: white;
    border: none;
    padding: 10px 20px;
    border-radius: 8px;
    font-weight: 500;
  }
  
  .btn-default.bg-success:hover {
    transform: translateY(-2px);
    box-shadow: 0 6px 15px rgba(40, 167, 69, 0.4);
  }
  
  /* DataTable Customization */
  .dataTables_wrapper {
    padding: 0 10px;
  }
  
  .dataTables_filter input {
    border-radius: 20px;
    padding: 8px 15px;
    border: 2px solid #e9ecef;
  }
  
  .dataTables_length select {
    border-radius: 8px;
    padding: 6px 12px;
    border: 2px solid #e9ecef;
  }
  
  .dataTables_paginate .paginate_button {
    border-radius: 8px !important;
    margin: 0 3px;
    border: 1px solid #dee2e6 !important;
  }
  
  .dataTables_paginate .paginate_button.current {
    background: linear-gradient(135deg, var(--primary-color), #2d7ca9) !important;
    border-color: var(--primary-color) !important;
    color: white !important;
  }
  
  /* Responsive Design */
  @media (max-width: 768px) {
    .card-header {
      padding: 15px 20px;
    }
    
    .table th, .table td {
      padding: 12px 15px;
      font-size: 13px;
    }
    
    .action-buttons {
      flex-direction: column;
      gap: 5px;
    }
    
    .modal-body {
      padding: 20px;
    }
    
    .btn {
      padding: 8px 16px;
      font-size: 13px;
    }
  }
  
  @media (max-width: 576px) {
    .card {
      margin-bottom: 15px;
    }
    
    .table th, .table td {
      padding: 10px 12px;
      font-size: 12px;
    }
    
    .modal-content {
      margin: 10px;
    }
    
    .form-control, .form-select {
      padding: 10px 14px;
      font-size: 13px;
    }
  }
  
  /* Animation for modal appearance */
  @keyframes fadeIn {
    from { opacity: 0; transform: translateY(-20px); }
    to { opacity: 1; transform: translateY(0); }
  }
  
  .modal-content {
    animation: fadeIn 0.3s ease-out;
  }
  
  /* Hover effects */
  .btn, .card, .table tr {
    transition: all 0.3s ease;
  }
  
  .btn:hover {
    transform: translateY(-1px);
  }
  
  .card:hover {
    box-shadow: 0 6px 20px rgba(0,0,0,0.15);
  }
  
  /* Custom scrollbar for table */
  .table-responsive::-webkit-scrollbar {
    height: 8px;
  }
  
  .table-responsive::-webkit-scrollbar-track {
    background: #f1f1f1;
    border-radius: 10px;
  }
  
  .table-responsive::-webkit-scrollbar-thumb {
    background: var(--primary-color);
    border-radius: 10px;
  }
  
  .table-responsive::-webkit-scrollbar-thumb:hover {
    background: #2d7ca9;
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

<div class="card-body">
          <button type="button" class="btn btn-default bg-success" data-toggle="modal" data-target="#modal-default">
                  + Add Departmemnt
                </button>
          </div>

            <div class="card">
              <div class="card-header">
                <h3 class="card-title">Departments Details</h3>
              </div>
              <!-- /.card-header -->
              <div class="card-body">
                <table id="example1" class="table table-bordered table-hover">
                  <thead>
                  <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Status</th>
                    <th>Employees</th>
                    <th>Created By</th>
                    <th>Created At</th>
                    <th>Modified By</th>
                    <th>Modified At</th>
                    <th>Actions</th>
                  </tr>
                  </thead>
                                   <tbody>
                   <c:forEach var="dept" items="${departments}">
                    <tr>
                        <td>${dept.departmentId}</td>
                        <td>${dept.departmentName}</td>
                         <td>${dept.status}</td> 
                        <td>${dept.numberOfEmployee}</td>
                        <td>${dept.createdBy}</td>
                        <td>${dept.createdAt}</td>
                        <td>${dept.modifiedBy}</td>
                        <td>${dept.modifiedAt}</td>
<td>
  <div class="action-buttons">
    <a href="DepartmentServlet?action=edit&departmentId=${dept.departmentId}" class="btn btn-sm btn-outline-primary">
      <i class="fas fa-edit"></i>
    </a>

    <form method="post" action="DepartmentServlet" onsubmit="return confirm('Are you sure you want to delete this department?');" style="display:inline;">
      <input type="hidden" name="action" value="delete">
      <input type="hidden" name="departmentId" value="${dept.departmentId}">
      <button type="submit" class="btn btn-sm btn-outline-danger">
        <i class="fas fa-trash-alt"></i>
      </button>
    </form>
  </div>
</td>


                    </tr>
                </c:forEach>
                  </tbody>
                  <tfoot>
                  <tr>
                    <th>${dept.departmentId}</th>
                    <th>${dept.departmentName}</th>
                    <th>${dept.departmentName}</th>
                    <th>${dept.numberOfEmployee}</th>
                    <th>${dept.createdBy}</th>
                    <th>${dept.createdAt}</th>
                    <th>${dept.modifiedBy}</th>
                    <th>${dept.modifiedAt}	</th>
                  </tr>
                  </tfoot>
                </table>
              </div>
              <!-- /.card-body -->
            </div>
            <!-- /.card -->

            
            <!-- /.card -->
          </div>
          <!-- /.col -->
        </div>






		<div class="modal fade" id="modal-default">
        <div class="modal-dialog">
          <div class="modal-content">
           <form method="post" action="DepartmentServlet">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="addDepartmentModalLabel">Add Department</h5>
          <button type="button" class="btn btn-default" data-dismiss="modal" id="minimize"></button>
          
        </div>
        <div class="modal-body">
          <input type="hidden" name="action" value="add">

          <div class="mb-3">
            <label for="departmentName" class="form-label">Department Name</label>
            <input type="text" class="form-control" id="departmentName" name="departmentName" required>
          </div>

          <div class="mb-3">
            <label for="status" class="form-label">Status</label>
            <select class="form-select" id="status" name="status">
              <option value="ACTIVE">ACTIVE</option>
              <option value="INACTIVE">INACTIVE</option>
            </select>
          </div>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
          <button type="submit" class="btn btn-primary">Add Department</button>
        </div>
      </div>
    </form>
          </div>
          <!-- /.modal-content -->
        </div>
        <!-- /.modal-dialog -->
      </div>






		<div class="modal fade" id="updateModal" aria-hidden="true">
        <div class="modal-dialog">
          <div class="modal-content">
          
    <form method="post" action="DepartmentServlet">
     
        <div class="modal-header">
          <h5 class="modal-title" id="updateDepartmentModalLabel">Update Department</h5>
           <button type="button" class="btn btn-default" data-dismiss="modal" id="minimize"></button>
        </div>
        <div class="modal-body">
          <input type="hidden" name="action" value="update">
          <input type="hidden" name="departmentId" value="${department.departmentId}">

          <div class="mb-3">
            <label for="editDepartmentName" class="form-label">Department Name</label>
            <input type="text" class="form-control" id="editDepartmentName" name="departmentName" value="${department.departmentName}" required>
          </div>

          <div class="mb-3">
            <label for="editStatus" class="form-label">Status</label>
            <select class="form-select" id="editStatus" name="status">
              <option value="ACTIVE" ${department.status == 'ACTIVE' ? 'selected' : ''}>ACTIVE</option>
              <option value="INACTIVE" ${department.status == 'INACTIVE' ? 'selected' : ''}>INACTIVE</option>
            </select>
          </div>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
          <button type="submit" class="btn btn-primary">Update Department</button>
        </div>
      
    </form>
          
          </div>
          <!-- /.modal-content -->
        </div>
        <!-- /.modal-dialog -->
      </div>

        <!-- /.row -->
      </div>
      <!-- /.container-fluid -->

<c:if test="${showUpdateModal}">
<script>
  document.addEventListener("DOMContentLoaded", function () {
    const updateModal = new bootstrap.Modal(document.getElementById('updateModal'));
    updateModal.show();
  });
</script>
</c:if>


    </section>
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
      "responsive": true,
    });
  });
</script>	
	
</body>
</html>