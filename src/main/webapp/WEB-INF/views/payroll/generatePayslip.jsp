<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Payslip Generator</title>

<!-- Google Font: Source Sans Pro -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
<!-- Font Awesome -->
<link rel="stylesheet" href="plugins/fontawesome-free/css/all.min.css">
<!-- Theme style -->
<link rel="stylesheet" href="dist/css/adminlte.min2167.css?v=3.2.0">
</head>
<body class="hold-transition sidebar-mini layout-fixed">

	<jsp:include page="../../../navbar.jsp"></jsp:include>
	<jsp:include page="../../../sidebar.jsp"></jsp:include>

	<div class="wrapper">
		<div class="content-wrapper">
			<!-- Page Header -->
			<div class="content-header">
				<div class="container-fluid">
					<div class="row mb-2">
						<div class="col-sm-6">
							<h1 class="m-0">Generate Payslip</h1>
						</div>
						<div class="col-sm-6">
							<ol class="breadcrumb float-sm-right">
								<li class="breadcrumb-item"><a href="#">Home</a></li>
								<li class="breadcrumb-item active">Payslip</li>
							</ol>
						</div>
					</div>
				</div>
			</div>

			<!-- Main Content -->
			<section class="content">
				<div class="container-fluid">
					<div class="row justify-content-center">
						<div class="col-md-8">

							<!-- Card -->
							<div class="card card-primary shadow-sm">
								<div class="card-header">
									<h3 class="card-title">
										<i class="fas fa-file-invoice-dollar"></i> Generate Payslip
									</h3>
								</div>

								<!-- Form -->
								<form
									action="${pageContext.request.contextPath}/GeneratePayslipPDFMonthly"
									method="post">
									<div class="card-body">

										<!-- Employee -->
										<div class="form-group">
											<label>Select Employee</label> <select name="employeeId"
												class="form-control" required
												onchange="window.location='${pageContext.request.contextPath}/GeneratePayslipPDFMonthly?employeeId=' + this.value;">
												<option value="">-- Select Employee --</option>
												<c:forEach var="emp" items="${employeeList}">
													<option value="${emp.userId}"
														<c:if test="${param.employeeId != null && param.employeeId == emp.userId}">selected</c:if>>
														${emp.firstName} ${emp.lastName}</option>
												</c:forEach>
											</select>
										</div>

										<!-- Month -->
										<div class="form-group">
											<label>Month</label> <select name="month"
												class="form-control" required>
												<option value="">-- Select Month --</option>
												<option value="1">January</option>
												<option value="2">February</option>
												<option value="3">March</option>
												<option value="4">April</option>
												<option value="5">May</option>
												<option value="6">June</option>
												<option value="7">July</option>
												<option value="8">August</option>
												<option value="9">September</option>
												<option value="10">October</option>
												<option value="11">November</option>
												<option value="12">December</option>
											</select>
										</div>

										<!-- Year -->
										<div class="form-group">
											<label>Year</label> <select name="year" class="form-control"
												required>
												<option value="">-- Select Year --</option>
												<%
												int currentYear = java.time.Year.now().getValue();
												for (int i = currentYear - 5; i <= currentYear + 5; i++) {
												%>
												<option value="<%=i%>"><%=i%></option>
												<%
												}
												%>
											</select>
										</div>

										<!-- Format -->
										

									</div>

									<!-- Footer -->
									<div class="card-footer text-right">
										<button type="submit" class="btn btn-primary">
											<i class="fas fa-file-download"></i> Generate Payslip
										</button>
									</div>
								</form>
							</div>

						</div>
					</div>
				</div>
			</section>
		</div>
	</div>

	<jsp:include page="../../../footer.jsp"></jsp:include>

	<!-- jQuery -->
	<script src="plugins/jquery/jquery.min.js"></script>
	<script src="plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="dist/js/adminlte2167.js?v=3.2.0"></script>
</body>
</html>
