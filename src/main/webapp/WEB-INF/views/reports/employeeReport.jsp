<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1" />

  <!-- Fonts and Stylesheets -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&amp;display=fallback" />
  <link rel="stylesheet" href="plugins/fontawesome-free/css/all.min.css" />
  <link rel="stylesheet" href="../../../code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css" />
  <link rel="stylesheet" href="plugins/tempusdominus-bootstrap-4/css/tempusdominus-bootstrap-4.min.css" />
  <link rel="stylesheet" href="plugins/icheck-bootstrap/icheck-bootstrap.min.css" />
  <link rel="stylesheet" href="plugins/jqvmap/jqvmap.min.css" />
  <link rel="stylesheet" href="dist/css/adminlte.min2167.css?v=3.2.0" />
  <link rel="stylesheet" href="plugins/overlayScrollbars/css/OverlayScrollbars.min.css" />
  <link rel="stylesheet" href="plugins/daterangepicker/daterangepicker.css" />
  <link rel="stylesheet" href="plugins/summernote/summernote-bs4.min.css" />

  <title>Employee Dashboard</title>

  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" />
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" />
  <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

  <style>
    body,
    html {
      margin: 0;
      padding: 0;
      background: #f1f3f6;
      height: 100%;
    }

    /* Sidebar fixed width and position */
    aside.main-sidebar {
      width: 250px;
      min-width: 250px;
      max-width: 250px;
      background: #212529;
      color: #fff;
      position: fixed;
      top: 0;
      left: 0;
      height: 100vh;
      border-right: 1px solid #e0e4ea;
      box-shadow: 2px 0 8px rgba(0, 0, 0, 0.03);
      z-index: 2000;
    }

    /* Content wrapper shifted right after sidebar */
    .content-wrapper {
      margin-left: 250px;
      padding: 20px 40px;
      min-height: 100vh;
      background: #f1f3f6;
      box-sizing: border-box;
    }

    /* Dashboard cards grid */
    .cards-container {
      display: grid;
      grid-template-columns: 1fr 1fr;
      gap: 15px;
      margin-bottom: 10px;
    }

    .card {
      border-radius: 12px;
      transition: 0.3s;
      overflow: hidden;
    }

    .card:hover {
      transform: translateY(-5px);
      box-shadow: 0 8px 20px rgba(0, 0, 0, 0.15);
    }

    .dashboard-card {
      padding: 20px;
      position: relative;
      display: flex;
      flex-direction: column;
      justify-content: center;
      align-items: center;
      min-height: 140px;
      color: #333;
    }

    .dashboard-card .icon {
      font-size: 2.8rem;
      opacity: 0.15;
      position: absolute;
      top: 15px;
      right: 15px;
    }

    .dashboard-card .count {
      font-size: 2rem;
      font-weight: bold;
      margin-top: 10px;
    }

    .dashboard-card .title {
      font-size: 1rem;
      font-weight: 500;
    }

    .dashboard-card .trend {
      font-size: 0.85rem;
      margin-top: 8px;
    }

    .trend.positive {
      color: #198754;
    }

    .trend.negative {
      color: #dc3545;
    }

    .chart-card {
      min-height: 260px;
    }

    .table-search {
      max-width: 250px;
      margin-right: 10px;
    }

    .export-dropdown {
      margin-left: auto;
    }

    table tbody tr:hover {
      background: #e9f5ff;
    }

    @media (max-width: 767px) {
      aside.main-sidebar {
        position: relative;
        width: 100%;
        height: auto;
        box-shadow: none;
        border-right: none;
      }
      .content-wrapper {
        margin-left: 0;
        padding: 15px;
      }
      .cards-container {
        grid-template-columns: 1fr;
      }
    }
  </style>
</head>
<body class="hold-transition sidebar-mini layout-fixed">

  <jsp:include page="../../../navbar.jsp" />

  <jsp:include page="../../../sidebar.jsp" />

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
                <li class="breadcrumb-item">
                  <a href="<%= request.getContextPath() %>/bbHomeReportController">Home</a>
                </li>
                <li class="breadcrumb-item active">Dashboard v1</li>
              </ol>
            </div>
          </div>
        </div>
      </div>

      <section class="content">
        <div>
          <!-- Page Title -->
          <div class="d-flex justify-content-between align-items-center mb-4">
            <h2 class="fw-bold text-dark">
              <i class="bi bi-people-fill me-2 text-primary"></i> Employee Report
            </h2>
            <div>
              <div class="dropdown">
                <button class="btn btn-outline-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown">
                  Export
                </button>
                <ul class="dropdown-menu">
                  <li>
                    <form method="post" action="${pageContext.request.contextPath}/BbEmployeeReportController">
                      <input type="hidden" name="action" value="exportPdf" />
                      <button type="submit" class="dropdown-item">PDF</button>
                    </form>
                  </li>
                  <li>
                    <form method="post" action="${pageContext.request.contextPath}/BbEmployeeReportController">
                      <input type="hidden" name="action" value="exportExcel" />
                      <button type="submit" class="dropdown-item">Excel</button>
                    </form>
                  </li>
                </ul>
              </div>
            </div>
          </div>

          <!-- Cards and Chart Row -->
          <div class="row mb-4">
            <div class="col-md-6">
              <div class="cards-container">
                <div class="card dashboard-card" style="background:#e3f2fd;">
                  <i class="bi bi-people-fill icon"></i>
                  <div class="title">Total Employees</div>
                  <div class="count">${totalEmployee}</div>
                  <div class="trend positive">+20.01% from last week</div>
                </div>
                <div class="card dashboard-card" style="background:#d1e7dd;">
                  <i class="bi bi-person-check-fill icon"></i>
                  <div class="title">Active Employees</div>
                  <div class="count">${activeCount}</div>
                  <div class="trend positive">+5.12% from last week</div>
                </div>
                <div class="card dashboard-card" style="background:#fff3cd;">
                  <i class="bi bi-building icon"></i>
                  <div class="title">Total Departments</div>
                  <div class="count">${deptCount}</div>
                  <div class="trend positive">+1.5% from last week</div>
                </div>
                <div class="card dashboard-card" style="background:#f8d7da;">
                  <i class="bi bi-diagram-3-fill icon"></i>
                  <div class="title">Total Roles</div>
                  <div class="count">${roleCount}</div>
                  <div class="trend negative">-0.50% from last week</div>
                </div>
              </div>
            </div>
            <div class="col-md-6">
              <div class="card chart-card shadow-sm">
                <div class="card-header d-flex justify-content-between align-items-center">
                  <span>Active vs Inactive Employees (${selectedYear})</span>
                  <form method="get" action="BbEmployeeReportController">
                    <select name="year" class="form-select form-select-sm" onchange="this.form.submit()">
                      <c:forEach var="y" begin="2020" end="2025">
                        <option value="${y}" ${y == selectedYear ? 'selected' : ''}>${y}</option>
                      </c:forEach>
                    </select>
                  </form>
                </div>
                <div class="card-body">
                  <canvas id="employeeChart" height="240"></canvas>
                </div>
              </div>
            </div>
          </div>

          <!-- Employee Table -->
          <div class="card shadow-sm">
            <div class="card-header d-flex align-items-center">
              <span>Employee List</span>
              <input
                type="text"
                id="searchInput"
                class="form-control table-search ms-3"
                placeholder="Search Employees..."
              />
              <form method="get" action="BbEmployeeReportController" class="ms-3">
                <label class="me-2 mb-0 small text-muted">Show</label>
                <select
                  name="pageSize"
                  class="form-select form-select-sm d-inline-block w-auto"
                  onchange="this.form.submit()"
                >
                  <option value="10" ${pageSize == 10 ? 'selected' : ''}>10</option>
                  <option value="20" ${pageSize == 20 ? 'selected' : ''}>20</option>
                  <option value="50" ${pageSize == 50 ? 'selected' : ''}>50</option>
                </select>
                <label class="ms-2 mb-0 small text-muted">entries</label>
              </form>
            </div>
            <div class="card-body table-responsive">
              <table class="table table-striped align-middle" id="employeeTable">
                <thead class="table-dark">
                  <tr>
                    <th>ID</th>
                    <th>Profile</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Department</th>
                    <th>Phone No</th>
                    <th>Date of Joining</th>
                    <th>Status</th>
                  </tr>
                </thead>
                <tbody>
                  <c:forEach var="emp" items="${pagination.data}">
                    <tr>
                      <td>${emp.userId}</td>
                      <td>
                        <img
                          src="images/${emp.profilePicture}"
                          class="rounded-circle"
                          width="45"
                          height="45"
                        />
                      </td>
                      <td>${emp.name}</td>
                      <td>${emp.email}</td>
                      <td>${emp.department}</td>
                      <td>${emp.contactNumber}</td>
                      <td>${emp.dateOfJoining}</td>
                      <td>
                        <c:choose>
                          <c:when test="${emp.status eq 'ACTIVE'}">
                            <span class="badge bg-success">Active</span>
                          </c:when>
                          <c:otherwise>
                            <span class="badge bg-danger">Inactive</span>
                          </c:otherwise>
                        </c:choose>
                      </td>
                    </tr>
                  </c:forEach>
                </tbody>
              </table>
              <nav>
                <ul class="pagination justify-content-center">
                  <c:forEach var="i" begin="1" end="${pagination.totalPages}">
                    <li class="page-item ${i == pagination.currentPage ? 'active' : ''}">
                      <a
                        class="page-link"
                        href="BbEmployeeReportController?page=${i}&pageSize=${pageSize}&year=${selectedYear}"
                        >${i}</a
                      >
                    </li>
                  </c:forEach>
                </ul>
              </nav>
            </div>
          </div>
        </div>
      </section>
    </div>
  </div>

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
  <script>
    const months = [
      "Jan",
      "Feb",
      "Mar",
      "Apr",
      "May",
      "Jun",
      "Jul",
      "Aug",
      "Sep",
      "Oct",
      "Nov",
      "Dec",
    ];
    const activeData = [
      <c:forEach var="val" items="${activeByMonth}" varStatus="s">
        ${val}<c:if test="${!s.last}">,</c:if>
      </c:forEach>,
    ];
    const inactiveData = [
      <c:forEach var="val" items="${inactiveByMonth}" varStatus="s">
        ${val}<c:if test="${!s.last}">,</c:if>
      </c:forEach>,
    ];

    new Chart(document.getElementById("employeeChart"), {
      type: "bar",
      data: {
        labels: months,
        datasets: [
          { label: "Active", data: activeData, backgroundColor: "#198754" },
          { label: "Inactive", data: inactiveData, backgroundColor: "#dc3545" },
        ],
      },
      options: {
        responsive: true,
        maintainAspectRatio: false,
        plugins: { legend: { position: "top" } },
        scales: { y: { beginAtZero: true } },
      },
    });

    const searchInput = document.getElementById("searchInput");
    searchInput.addEventListener("keyup", function () {
      const filter = this.value.toLowerCase();
      const rows = document.querySelectorAll("#employeeTable tbody tr");
      rows.forEach(
        (row) => (row.style.display = row.textContent.toLowerCase().includes(filter) ? "" : "none")
      );
    });
  </script>

  <jsp:include page="../../../footer.jsp" />
  
  
  
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
	
  
  
</body>
</html>
