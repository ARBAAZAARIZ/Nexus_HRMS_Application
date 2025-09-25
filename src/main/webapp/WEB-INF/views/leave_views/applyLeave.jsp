<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Apply Leave - Dashboard</title>

<!-- Bootstrap CSS & dependencies -->
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet" />
<link
	href="https://cdn.datatables.net/1.10.21/css/dataTables.bootstrap4.min.css"
	rel="stylesheet" />
<link
	href="https://cdn.datatables.net/buttons/1.7.1/css/buttons.bootstrap4.min.css"
	rel="stylesheet" />
<link
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback"
	rel="stylesheet" />

<!-- Font Awesome -->
<link rel="stylesheet" href="plugins/fontawesome-free/css/all.min.css">

<!-- Ionicons -->
<link rel="stylesheet"
	href="../../../code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">

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

 <!-- DataTables -->
  <link rel="stylesheet" href="plugins/datatables-bs4/css/dataTables.bootstrap4.min.css">
  <link rel="stylesheet" href="plugins/datatables-responsive/css/responsive.bootstrap4.min.css">
  <link rel="stylesheet" href="plugins/datatables-buttons/css/buttons.bootstrap4.min.css">

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
						</div>
						<div class="col-sm-6">
							<ol class="breadcrumb float-sm-right">
								<li class="breadcrumb-item"><a href="#">Home</a></li>
								<li class="breadcrumb-item active">Apply Leave</li>
							</ol>
						</div>
					</div>
				</div>
			</div>

			<section class="content">
			
			<div class="container-fluid">
		
		<div class="row">
		
          <div class="col-12">
				<div class="container mt-4">

					<h3>Leave Balances</h3>
					<div class="row mb-4">
						<c:forEach var="leave" items="${leaveBalances}">
							<div class="col-md-3">
								<div class="card p-3">
									<h5>${leave.leaveTypeName}</h5>
									<h2>${leave.totalLeaves}</h2>
									<p>
										Remaining Leaves:
										<c:choose>
											<c:when test="${leave.remainingLeaves lt 1}">
												<span class="text-danger font-weight-bold">${leave.remainingLeaves}</span>
											</c:when>
											<c:otherwise>
												<span>${leave.remainingLeaves}</span>
											</c:otherwise>
										</c:choose>
									</p>
									<c:if test="${leave.remainingLeaves lt 1}">
										<p class="text-danger font-weight-bold">Insufficient
											leaves available!</p>
									</c:if>
								</div>
							</div>
						</c:forEach>
					</div>

					<button type="button" class="btn btn-primary mb-3"
						data-toggle="modal" data-target="#applyLeaveModal">Apply
						Leave</button>

					<!-- Apply Leave Modal -->
					<div class="modal fade" id="applyLeaveModal" tabindex="-1"
						role="dialog" aria-labelledby="applyLeaveLabel" aria-hidden="true">
						<div class="modal-dialog" role="document">
							<form method="post" action="ApplyLeaveServlet">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title" id="applyLeaveLabel">Apply for
											Leave</h5>
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
									</div>
									<div class="modal-body">

										<c:if test="${not empty leaveErrorMsg}">
											<div class="alert alert-danger">${leaveErrorMsg}</div>
										</c:if>

										<div class="form-group">
											<label>Leave Type</label> <select name="leaveTypeId"
												class="form-control" required>
												<option value="">Select</option>
												<c:forEach var="type" items="${leaveTypes}">
													<option value="${type.leaveTypeId}">${type.leaveTypeName}</option>
												</c:forEach>
											</select>
										</div>

										<div class="form-group">
											<label>Start Date</label> <input type="date" id="startDate"
												name="startDate" class="form-control" required />
										</div>
										<div class="form-group">
											<label>End Date</label> <input type="date" id="endDate"
												name="endDate" class="form-control" required />
										</div>
										<div class="form-group">
											<label>Number of Days</label> <input type="number"
												id="numDays" name="numberOfDays" class="form-control"
												readonly />
										</div>
										<div class="form-group">
											<label>Reason</label>
											<textarea name="reason" class="form-control"></textarea>
										</div>
									</div>
									<div class="modal-footer">
										<button type="submit" class="btn btn-success">Apply</button>
										<button type="button" class="btn btn-secondary"
											data-dismiss="modal">Close</button>
									</div>
								</div>
							</form>
						</div>
					</div>

					<h4>My Leave Requests</h4>
					<table  id="example1"
						class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>Leave ID</th>
								<th>Leave Type</th>
								<th>Start Date</th>
								<th>End Date</th>
								<th>Reason</th>
								<th>No. Of Days</th>
								<th>Status</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="req" items="${leaveRequests}">
								<tr>
									<td>${req.leaveRequestId}</td>
									<td>${req.leaveTypeName}</td>
									<td>${req.startDate}</td>
									<td>${req.endDate}</td>
									<td>${req.reason}</td>
									<td>${req.numberOfDays}</td>
									<td>${req.status}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>

				</div>
				
				</div>
	</div>
	</div>
				
			</section>
		</div>
	</div>

	<!-- Include Footer -->
	<jsp:include page="../../../footer.jsp"></jsp:include>

	<!-- Scripts -->
	<script src="plugins/jquery/jquery.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

	<script
		src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>
	<script
		src="https://cdn.datatables.net/1.10.21/js/dataTables.bootstrap4.min.js"></script>
		
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

	<script>
  let holidays = [
    <c:forEach var="h" items="${holidays}" varStatus="loop">
      '${h}'<c:if test="${!loop.last}">, </c:if>
    </c:forEach>
  ];

  function countWorkingDays(start, end) {
    if (!start || !end) return 0;
    let startDate = new Date(start);
    let endDate = new Date(end);
    let count = 0;
    for (let d = startDate; d <= endDate; d.setDate(d.getDate() + 1)) {
      let dStr = d.toISOString().slice(0, 10);
      if (!holidays.includes(dStr)) {
        count++;
      }
    }
    return count;
  }

  $('#startDate, #endDate').change(function () {
    let start = $('#startDate').val();
    let end = $('#endDate').val();
    if (start && end) {
      let days = countWorkingDays(start, end);
      $('#numDays').val(days);
    }
  });

  $(document).ready(function () {
    $('#myLeaveRequestsTable').DataTable({
      dom: 'Bfrtip',
      buttons: [
        'copyHtml5',
        'excelHtml5',
        'pdfHtml5',
        'print',
      ],
      lengthMenu: [5, 10, 25, 50, 100],
      pageLength: 10,
      order: [],
      columnDefs: [{ orderable: false, targets: 6 }],
    });
  });

  <c:if test="${not empty leaveErrorMsg}">
    $(document).ready(function () {
      $('#applyLeaveModal').modal('show');
    });
  </c:if>
</script>

</body>
</html>
