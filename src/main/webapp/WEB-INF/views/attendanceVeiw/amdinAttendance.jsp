<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Admin Dashboard | Attendance</title>

<link rel="stylesheet" href="plugins/fontawesome-free/css/all.min.css">
<link rel="stylesheet" href="plugins/datatables-bs4/css/dataTables.bootstrap4.min.css">
<link rel="stylesheet" href="plugins/datatables-responsive/css/responsive.bootstrap4.min.css">
<link rel="stylesheet" href="plugins/datatables-buttons/css/buttons.bootstrap4.min.css">
<link rel="stylesheet" href="dist/css/adminlte.min.css">
<!-- Google Font: Source Sans Pro -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&amp;display=fallback">
<!-- Font Awesome -->
<link rel="stylesheet" href="plugins/fontawesome-free/css/all.min.css">
<!-- Ionicons -->
<link rel="stylesheet"
	href="../code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
<!-- Tempusdominus Bootstrap 4 -->
<link rel="stylesheet"
	href="plugins/tempusdominus-bootstrap-4/css/tempusdominus-bootstrap-4.min.css">
<!-- iCheck -->
<link rel="stylesheet"
	href="plugins/icheck-bootstrap/icheck-bootstrap.min.css">
<!-- JQVMap -->
<link rel="stylesheet" href="plugins/jqvmap/jqvmap.min.css">
<!-- Theme style -->
<link rel="stylesheet" href="dist/css/adminlte.min2167.css?v=3.2.0">
<!-- overlayScrollbars -->
<link rel="stylesheet"
	href="plugins/overlayScrollbars/css/OverlayScrollbars.min.css">
<!-- Daterange picker -->
<link rel="stylesheet"
	href="plugins/daterangepicker/daterangepicker.css">
<!-- summernote -->
<link rel="stylesheet" href="plugins/summernote/summernote-bs4.min.css">

<!-- Google Font -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
	
	
	
</head>
<body class="hold-transition sidebar-mini layout-fixed">

<jsp:include page="../../../navbar.jsp"></jsp:include>
<jsp:include page="../../../sidebar.jsp"></jsp:include>

<div class="wrapper">
  <div class="content-wrapper">
    <div class="content-header">
      <div class="container-fluid">
        <h1 class="m-0">Manager - Employee Attendance Dashboard</h1>
      </div>
    </div>

    <section class="content">
      <div class="container-fluid">


        <div class="row">
         
          <div class="col-lg-4 col-6">
            <div class="small-box bg-info">
              <div class="inner">
                <h3>${total_employee}</h3>
                <p>Total Employees</p>
              </div>
              <div class="icon">
                <i class="fas fa-users"></i>
              </div>
            </div>
          </div>


          <div class="col-lg-4 col-6">
            <div class="small-box bg-success">
              <div class="inner">
                <h3>${total_present}</h3>
                <p>Present Today</p>
              </div>
              <div class="icon">
                <i class="fas fa-user-check"></i>
              </div>
            </div>
          </div>

     
          <div class="col-lg-4 col-6">
            <div class="small-box bg-danger">
              <div class="inner">
                <h3>${total_absent}</h3>
                <p>Absent Today</p>
              </div>
              <div class="icon">
                <i class="fas fa-user-times"></i>
              </div>
            </div>
          </div>
        </div>

        
        <div class="card mt-4">
          <div class="card-header bg-success text-white">
            <h3 class="card-title">Present Employees</h3>
          </div>
          <div class="card-body">
            <table id="presentTable" class="table table-bordered table-striped">
              <thead>
                <tr>
                  <th>User ID</th>
                  <th>Check IN </th>
                  <th>Lunch Out</th>
                   <th>Lunch In</th>
                  <th>Check Out</th>
                  <th>Working_hours </th>
                 
                </tr>
              </thead>
              <tbody>
                <c:forEach var="emp" items="${todaysAttendance}">
                  <tr>
                    <td>${emp.user_id}</td>
                    <td>${emp.check_in}</td>
                    <td>${emp.lunch_out}</td>
                     <td>${emp.lunch_in}</td>
                     <td>${emp.check_out }</td>
                      <td>${emp.working_hours}</td>
                       
                  </tr>
                </c:forEach>
              </tbody>
            </table>
          </div>
        </div>

        <div class="card mt-4">
          <div class="card-header bg-danger text-white">
            <h3 class="card-title">Absent Employees</h3>
          </div>
          <div class="card-body">
            <table id="absentTable" class="table table-bordered table-striped">
              <thead>
                <tr>
                  <th>User ID</th>
                  <th>Name</th>
                  <th>Department</th>
                </tr>
              </thead>
              <tbody>
                <c:forEach var="emp" items="${absentEmployees}">
                  <tr>
                    <td>${emp.userId}</td>
                    <td>${emp.firstName} ${emp.lastName}</td>
                    <td>${emp.department}</td>
                  </tr>
                </c:forEach>
              </tbody>
            </table>
          </div>
        </div>

      </div>
    </section>
  </div>
</div>

<jsp:include page="../../../footer.jsp"></jsp:include>

<!-- Scripts -->
<script src="plugins/jquery/jquery.min.js"></script>
<script src="plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="plugins/datatables/jquery.dataTables.min.js"></script>
<script src="plugins/datatables-bs4/js/dataTables.bootstrap4.min.js"></script>
<script src="plugins/datatables-responsive/js/dataTables.responsive.min.js"></script>
<script src="plugins/datatables-buttons/js/dataTables.buttons.min.js"></script>
<script src="plugins/datatables-buttons/js/buttons.bootstrap4.min.js"></script>
<script src="plugins/jszip/jszip.min.js"></script>
<script src="plugins/pdfmake/pdfmake.min.js"></script>
<script src="plugins/pdfmake/vfs_fonts.js"></script>
<script src="plugins/datatables-buttons/js/buttons.html5.min.js"></script>
<script src="plugins/datatables-buttons/js/buttons.print.min.js"></script>
<script src="plugins/datatables-buttons/js/buttons.colVis.min.js"></script>
<script>
  $(function () {
    $("#presentTable, #absentTable").DataTable({
      "responsive": true, "lengthChange": false, "autoWidth": false,
      "buttons": ["excel", "pdf", "print"]
    }).buttons().container().appendTo('.col-md-6:eq(0)');
  });
</script>
</body>
</html>