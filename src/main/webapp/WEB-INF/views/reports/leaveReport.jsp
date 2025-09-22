<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1" />

  <title>Leave Reports</title>

  <!-- Google Font: Source Sans Pro -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&amp;display=fallback" />
  <!-- Font Awesome -->
  <link rel="stylesheet" href="plugins/fontawesome-free/css/all.min.css" />
  <!-- Ionicons -->
  <link rel="stylesheet" href="../../../code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css" />
  <!-- Tempusdominus Bootstrap 4 -->
  <link rel="stylesheet" href="plugins/tempusdominus-bootstrap-4/css/tempusdominus-bootstrap-4.min.css" />
  <!-- iCheck -->
  <link rel="stylesheet" href="plugins/icheck-bootstrap/icheck-bootstrap.min.css" />
  <!-- JQVMap -->
  <link rel="stylesheet" href="plugins/jqvmap/jqvmap.min.css" />
  <!-- Theme style -->
  <link rel="stylesheet" href="dist/css/adminlte.min2167.css?v=3.2.0" />
  <!-- overlayScrollbars -->
  <link rel="stylesheet" href="plugins/overlayScrollbars/css/OverlayScrollbars.min.css" />
  <!-- Daterange picker -->
  <link rel="stylesheet" href="plugins/daterangepicker/daterangepicker.css" />
  <!-- summernote -->
  <link rel="stylesheet" href="plugins/summernote/summernote-bs4.min.css" />

  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" />
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.css" />

  <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

  <style>
    body, html {
      margin: 0;
      padding: 0;
      background: #f1f3f6;
      height: 100%;
    }

    /* Sidebar fixed width and positioning */
    aside.main-sidebar {
      position: fixed;
      top: 0;
      left: 0;
      width: 250px;
      height: 100vh;
      background: #212529;
      color: #fff;
      border-right: 1px solid #e0e4ea;
      box-shadow: 2px 0 8px rgba(0,0,0,0.03);
      z-index: 2000;
    }

    /* Content wrapper with left margin to avoid sidebar overlap */
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
      box-shadow: 0 8px 20px rgba(0,0,0,0.15);
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

  <jsp:include page="/navbar.jsp" />

  <jsp:include page="/sidebar.jsp" />

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
                <li class="breadcrumb-item"><a href="<%=request.getContextPath() %>/bbHomeReportController">Home</a></li>
                <li class="breadcrumb-item active">Dashboard v1</li>
              </ol>
            </div>
          </div>
        </div>
      </div>

      <section class="content">

        <!-- Page Title -->
        <div class="d-flex justify-content-between align-items-center mb-4">
          <h2 class="fw-bold text-dark">
            <i class="bi bi-calendar-week me-2 text-primary"></i> Leave Reports
          </h2>
          <div>
            <div class="dropdown">
              <button class="btn btn-outline-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown">
                Export
              </button>
              <ul class="dropdown-menu">
                <li><a class="dropdown-item" href="BbLeaveReportController?action=exportPDF&year=${year}">PDF</a></li>
                <li><a class="dropdown-item" href="BbLeaveReportController?action=exportExcel&year=${year}">Excel</a></li>
              </ul>
            </div>
          </div>
        </div>

        <!-- Cards + Chart Side-by-Side -->
        <div class="row mb-4">
          <div class="col-md-6">
            <div class="cards-container">
              <div class="card dashboard-card" style="background:#e3f2fd;">
                <i class="bi bi-calendar-check icon"></i>
                <div class="title">Total Leaves</div>
                <div class="count">${totalLeaves}</div>
                <div class="trend positive">+17.02% from last month</div>
              </div>
              <div class="card dashboard-card" style="background:#d1e7dd;">
                <i class="bi bi-check-circle-fill icon"></i>
                <div class="title">Approved Leaves</div>
                <div class="count">${approvedLeaves}</div>
                <div class="trend positive">+12.50% from last month</div>
              </div>
              <div class="card dashboard-card" style="background:#fff3cd;">
                <i class="bi bi-hourglass-split icon"></i>
                <div class="title">Pending Leaves</div>
                <div class="count">${pendingLeaves}</div>
                <div class="trend negative">-3.20% from last month</div>
              </div>
              <div class="card dashboard-card" style="background:#f8d7da;">
                <i class="bi bi-x-circle-fill icon"></i>
                <div class="title">Rejected Leaves</div>
                <div class="count">${rejectedLeaves}</div>
                <div class="trend positive">+1.75% from last month</div>
              </div>
            </div>
          </div>
          <div class="col-md-6">
            <div class="card chart-card shadow-sm">
              <div class="card-header d-flex justify-content-between align-items-center">
                <span>Monthly Leave Trends (${year})</span>
                <form method="get" action="BbLeaveReportController">
                  <select name="year" class="form-select form-select-sm" onchange="this.form.submit()">
                    <c:forEach var="y" begin="2023" end="2026">
                      <option value="${y}" ${y == year ? 'selected' : ''}>${y}</option>
                    </c:forEach>
                  </select>
                </form>
              </div>
              <div class="card-body">
                <canvas id="leaveChart" height="240"></canvas>
              </div>
            </div>
          </div>
        </div>

        <!-- Leave Requests Table -->
        <div class="card shadow-sm mt-4">
          <div class="card-header d-flex flex-column flex-md-row justify-content-between align-items-md-center gap-2">
            <div><strong>Leave Requests</strong></div>

            <div class="d-flex align-items-center gap-2">

              <!-- Show Entries Dropdown -->
              <form method="get" action="BbLeaveReportController" class="d-flex align-items-center gap-2 mb-0">
                <label class="me-1 mb-0 small text-muted">Show</label>
                <select name="pageSize" class="form-select form-select-sm d-inline-block w-auto" onchange="this.form.submit()">
                  <option value="10" ${pageSize==10?'selected':''}>10</option>
                  <option value="20" ${pageSize==20?'selected':''}>20</option>
                  <option value="50" ${pageSize==50?'selected':''}>50</option>
                </select>
                <label class="ms-1 mb-0 small text-muted">entries</label>
              </form>

              <!-- Search Box -->
              <input type="text" id="searchInput" class="form-control form-control-sm table-search" placeholder="Search..." />
            </div>
          </div>

          <div class="card-body table-responsive">
            <table class="table table-striped align-middle" id="leaveTable">
              <thead class="table-dark">
                <tr>
                  <th>ID</th>
                  <th>Photo</th>
                  <th>User</th>
                  <th>Leave Type</th>
                  <th>Start Date</th>
                  <th>End Date</th>
                  <th>Days</th>
                  <th>Reason</th>
                  <th>Approved By</th>
                  <th>Status</th>
                </tr>
              </thead>
              <tbody>
                <c:forEach var="row" items="${pagination.data}">
                  <tr>
                    <td>${row.leaveRequestId}</td>
                    <td>
                      <img src="images/${row.profilePicture}" class="rounded-circle" width="40" height="40" alt="User" />
                    </td>
                    <td>${row.userName}</td>
                    <td>${row.leaveType}</td>
                    <td>${row.startDate}</td>
                    <td>${row.endDate}</td>
                    <td>${row.numberOfDays}</td>
                    <td>${row.reason}</td>
                    <td>${row.approvedBy}</td>
                    <td>
                      <span class="badge ${row.status == 'Approved' ? 'bg-success' : row.status == 'Pending' ? 'bg-warning text-dark' : 'bg-danger'}">
                        ${row.status}
                      </span>
                    </td>
                  </tr>
                </c:forEach>
              </tbody>
            </table>
            <nav>
              <ul class="pagination justify-content-center">
                <c:forEach var="i" begin="1" end="${pagination.totalPages}">
                  <li class="page-item ${i == pagination.currentPage ? 'active' : ''}">
                    <a class="page-link" href="BbLeaveReportController?page=${i}&pageSize=${pageSize}&year=${year}">${i}</a>
                  </li>
                </c:forEach>
              </ul>
            </nav>
          </div>
        </div>
      </section>
    </div>
  </div>

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
  <script>
    const monthlyData = ${trends};
    new Chart(document.getElementById("leaveChart"), {
      type: "line",
      data: {
        labels: ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"],
        datasets: [
          {
            label: "Leave Requests",
            data: monthlyData,
            borderColor: "#0d6efd",
            backgroundColor: "rgba(13, 110, 253, 0.2)",
            tension: 0.3,
            fill: true,
            pointRadius: 5,
            pointBackgroundColor: "#0d6efd",
          },
        ],
      },
      options: {
        responsive: true,
        maintainAspectRatio: false,
        plugins: { legend: { display: false } },
      },
    });

    document.getElementById("searchInput").addEventListener("keyup", function () {
      const filter = this.value.toLowerCase();
      const rows = document.querySelectorAll("#leaveTable tbody tr");
      rows.forEach((row) => (row.style.display = row.textContent.toLowerCase().includes(filter) ? "" : "none"));
    });
  </script>

  <jsp:include page="/footer.jsp" />
  
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
