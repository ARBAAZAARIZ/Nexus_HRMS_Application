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

<style>
  /* General layout */
  .container-fluid {
    padding: 20px;
  }

  .card {
    border-radius: 12px;
    box-shadow: 0 4px 12px rgba(0,0,0,0.1);
    border: none;
  }

  .card-header {
    background: linear-gradient(to right, #1976d2, #42a5f5);
    color: #fff;
    border-top-left-radius: 12px;
    border-top-right-radius: 12px;
    padding: 16px;
  }

  .card-title {
    font-size: 1.2rem;
    font-weight: 600;
    margin: 0;
  }

  .card-body {
    background-color: #f9f9f9;
    border-bottom-left-radius: 12px;
    border-bottom-right-radius: 12px;
    padding: 20px;
  }

  /* Table styling */
  .table th, .table td {
    vertical-align: middle;
    text-align: center;
    font-size: 0.95rem;
  }

  .table thead {
    background-color: #e3f2fd;
  }

  .table-striped tbody tr:nth-of-type(odd) {
    background-color: #f5f5f5;
  }

  /* Action buttons */
  .action-buttons {
    display: flex;
    gap: 8px;
    justify-content: center;
    flex-wrap: wrap;
  }

  .btn-sm {
    font-size: 0.85rem;
    padding: 6px 12px;
    border-radius: 6px;
    font-weight: 500;
    transition: all 0.2s ease-in-out;
  }

  .btn-outline-primary {
    color: #1976d2;
    border: 1px solid #1976d2;
    background-color: transparent;
  }

  .btn-outline-primary:hover {
    background-color: #1976d2;
    color: #fff;
  }

  .btn-outline-danger {
    color: #d32f2f;
    border: 1px solid #d32f2f;
    background-color: transparent;
  }

  .btn-outline-danger:hover {
    background-color: #d32f2f;
    color: #fff;
  }

  /* Modal styling */
  .modal-content {
    border-radius: 16px;
    background: linear-gradient(to bottom right, #ffffff, #f0f4f8);
    box-shadow: 0 8px 24px rgba(0, 0, 0, 0.2);
    border: none;
  }

  .modal-header {
    background: linear-gradient(to right, #1976d2, #42a5f5);
    color: #fff;
    border-top-left-radius: 16px;
    border-top-right-radius: 16px;
    padding: 1rem 1.5rem;
  }

  .modal-title {
    font-size: 1.25rem;
    font-weight: 600;
    letter-spacing: 0.5px;
  }

  .modal-body {
    padding: 1.5rem;
    font-size: 0.95rem;
    color: #333;
  }

  .form-label {
    font-weight: 500;
    color: #444;
  }

  .form-control, .form-select {
    border-radius: 8px;
    border: 1px solid #ccc;
    transition: border-color 0.3s ease;
  }

  .form-control:focus, .form-select:focus {
    border-color: #1976d2;
    box-shadow: none;
  }

  .modal-footer {
    background-color: #f1f8e9;
    border-top: none;
    border-bottom-left-radius: 16px;
    border-bottom-right-radius: 16px;
    padding: 1rem 1.5rem;
    justify-content: flex-end;
  }

  .btn-primary {
    background-color: #1976d2;
    border-color: #1976d2;
    border-radius: 8px;
    padding: 6px 16px;
    font-weight: 500;
  }

  .btn-primary:hover {
    background-color: #1565c0;
    border-color: #1565c0;
  }

  .btn-default {
    background-color: #9e9e9e;
    border-color: #9e9e9e;
    border-radius: 8px;
    padding: 6px 16px;
    font-weight: 500;
    color: #fff;
  }

  .btn-default:hover {
    background-color: #757575;
    border-color: #757575;
  }

  /* Minimize button */
  #minimize {
    width: 32px;
    height: 32px;
    border: none;
    background-color: transparent;
    position: absolute;
    top: 12px;
    right: 48px;
    cursor: pointer;
    display: flex;
    align-items: center;
    justify-content: center;
    transition: background-color 0.3s ease;
  }

  #minimize::before {
    content: "\f2d1";
    font-family: "Font Awesome 6 Free";
    font-weight: 900;
    font-size: 18px;
    color: #fff;
  }

  #minimize:hover {
    background-color: rgba(255, 255, 255, 0.1);
    border-radius: 50%;
  }

  /* Modal backdrop blur */
  body.modal-open {
    overflow: hidden;
  }

  .modal-backdrop.show {
    backdrop-filter: blur(6px);
    background-color: rgba(0, 0, 0, 0.4);
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
            <h1 class="m-0">Role's</h1>
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
                  + Add Roles
                </button>
          </div>
		<div class="card">
              <div class="card-header">
                <h3 class="card-title">DataTable with default features</h3>
              </div>
              <!-- /.card-header -->
              <div class="card-body">
                <table id="example1" class="table table-bordered table-striped">
                  <thead>
                  <tr>
                     <th>ID</th>
                    <th>Name</th>
                    <th>Status</th>
                    <th>Created By</th>
                    <th>Created At</th>
                    <th>Modified By</th>
                    <th>Modified At</th>
                    <th>Actions</th>
                  </tr>
                  </thead>
                  <tbody>
                   <c:forEach var="role" items="${roles}">
                    <tr>
                        
                        <td>${role.roleId}</td>
                        <td>${role.roleName}</td>
                        <td>${role.status}</td>
                        <td>${role.createdBy}</td>
                        <td>${role.createdAt}</td>
                        <td>${role.modifiedBy}</td>
                        <td>${role.modifiedAt}</td>
<td>
  <div class="action-buttons">
    <a href="RoleServlet?action=edit&roleId=${role.roleId}" class="btn btn-sm btn-outline-primary">
      <i class="fas fa-edit"></i> Update
    </a>

    <form method="post" action="DepartmentServlet" onsubmit="return confirm('Are you sure you want to delete this department?');" style="display:inline;">
      <input type="hidden" name="action" value="delete">
      <input type="hidden" name="departmentId" value="${dept.departmentId}">
      <button type="submit" class="btn btn-sm btn-outline-danger">
        <i class="fas fa-trash-alt"></i> Delete
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
            
         
            
		
		</div>
		
		</div>
		
		
		<div class="modal fade" id="modal-default">
        <div class="modal-dialog">
          <div class="modal-content">
    <form method="post" action="RoleServlet">
      
        <div class="modal-header">
          <h5 class="modal-title" id="addRoleModalLabel">Add Role</h5>
          <button type="button" class="btn btn-default" data-dismiss="modal" id="minimize"></button>
        </div>
        <div class="modal-body">
          <input type="hidden" name="action" value="add">

          <div class="mb-3">
            <label for="roleName" class="form-label">Role Name</label>
            <input type="text" class="form-control" id="roleName" name="roleName" required>
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
          <button type="button" class="btn btn-default" data-dismiss="modal" id="minimize">Close</button>
          <button type="submit" class="btn btn-primary">Add Role</button>
        </div>
      
    </form>
          </div>
          <!-- /.modal-content -->
        </div>
        <!-- /.modal-dialog -->
      </div>
      
      
      
		
		<div class="modal fade" id="updateModal">
        <div class="modal-dialog">
          <div class="modal-content">
          
    <form method="post" action="RoleServlet">
      
        <div class="modal-header">
          <h5 class="modal-title" id="updateRoleModalLabel">Update Role</h5>
          <button type="button" class="btn btn-default" data-dismiss="modal" id="minimize"></button>
        </div>
        <div class="modal-body">
          <input type="hidden" name="action" value="update">
          <input type="hidden" name="roleId" value="${role.roleId}">

          <div class="mb-3">
            <label for="editRoleName" class="form-label">Role Name</label>
            <input type="text" class="form-control" id="editRoleName" name="roleName" value="${role.roleName}" required>
          </div>

          <div class="mb-3">
            <label for="editStatus" class="form-label">Status</label>
            <select class="form-select" id="editStatus" name="status">
              <option value="ACTIVE" ${role.status == 'ACTIVE' ? 'selected' : ''}>ACTIVE</option>
              <option value="INACTIVE" ${role.status == 'INACTIVE' ? 'selected' : ''}>INACTIVE</option>
            </select>
          </div>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal" id="minimize">Close</button>
          <button type="submit" class="btn btn-primary">Update Role</button>
        </div>
      
    </form>
          </div>
          <!-- /.modal-content -->
        </div>
        <!-- /.modal-dialog -->
      </div>
		
		
		
		</div>
		

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
<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
<script src="dist/js/pages/dashboard.js"></script>
<script defer src="https://static.cloudflareinsights.com/beacon.min.js/vcd15cbe7772f49c399c6a5babf22c1241717689176015" integrity="sha512-ZpsOmlRQV6y907TI0dKBHq9Md29nnaEIPlkf84rnaERnq6zvWvPUqr2ft8M1aS28oN72PdrCzSjY4U6VaAw1EQ==" data-cf-beacon='{"rayId":"97edd8cbed143e57","version":"2025.8.0","serverTiming":{"name":{"cfExtPri":true,"cfEdge":true,"cfOrigin":true,"cfL4":true,"cfSpeedBrain":true,"cfCacheStatus":true}},"token":"2437d112162f4ec4b63c3ca0eb38fb20","b":1}' crossorigin="anonymous"></script>
	
</body>
</html>