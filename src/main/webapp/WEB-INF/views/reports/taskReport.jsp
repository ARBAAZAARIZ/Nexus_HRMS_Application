<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <title>Task Report Dashboard</title>

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

  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" />
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css" />

  <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

  <style>
    body, html {
      margin:0; padding:0; background: #f1f3f6; height: 100%;
    }

    aside.main-sidebar {
      position: fixed;
      top: 0; left: 0;
      width: 250px; height: 100vh;
      background: #212529;
      border-right: 1px solid #e0e4ea;
      box-shadow: 2px 0 8px rgba(0,0,0,0.03);
      color: #fff;
      z-index: 2000;
    }

    .content-wrapper {
      margin-left: 250px;
      padding: 20px 40px;
      min-height: 100vh;
      background: #f1f3f6;
      box-sizing: border-box;
    }

    .info-card {
      border-radius: 20px;
      color: #fff;
      padding: 20px;
      height: 150px;
      display: flex;
      align-items: center;
      justify-content: space-between;
      box-shadow: 0 10px 25px rgba(0,0,0,0.3);
      position: relative;
      overflow: hidden;
      transition: transform 0.3s, box-shadow 0.3s;
    }

    .info-card::before {
      content: "";
      position: absolute;
      width: 200%;
      height: 200%;
      top: -50%;
      left: -50%;
      background: rgba(255,255,255,0.05);
      transform: rotate(45deg);
      animation: shine 5s linear infinite;
    }

    @keyframes shine {
      0% { transform: rotate(45deg) translate(-200%, -200%); }
      100% { transform: rotate(45deg) translate(200%, 200%); }
    }

    .info-card:hover {
      transform: scale(1.07);
      box-shadow: 0 15px 35px rgba(0,0,0,0.4);
    }

    .info-card h3 {
      font-size: 38px;
      font-weight: 700;
      margin: 0;
      text-shadow: 1px 1px 5px rgba(0,0,0,0.3);
    }
    .info-card p {
      font-size: 18px;
      margin: 0;
    }

    .info-icon {
      font-size: 50px;
      opacity: 0.85;
      text-shadow: 2px 2px 10px rgba(0,0,0,0.2);
    }

    .bg-gradient-success {
      background: linear-gradient(135deg, #28a745, #1db954);
    }

    .bg-gradient-warning {
      background: linear-gradient(135deg, #ffc107, #ffb347);
      color: #333;
    }

    .bg-gradient-primary {
      background: linear-gradient(135deg, #007bff, #00c6ff);
    }

    .bg-gradient-purple {
      background: linear-gradient(135deg, #6f42c1, #a855f7);
    }

    @media (max-width: 767px) {
      aside.main-sidebar {
        position: relative; width: 100%; height: auto;
        box-shadow: none; border-right: none;
      }
      .content-wrapper {
        margin-left: 0; padding: 15px;
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
          <div class="col-sm-6"><h1 class="m-0">Dashboard</h1></div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="<%=request.getContextPath()%>/bbHomeReportController">Home</a></li>
              <li class="breadcrumb-item active">Dashboard v1</li>
            </ol>
          </div>
        </div>
      </div>
    </div>

    <section class="content">
      <!-- Page Title and Export -->
      <div class="d-flex justify-content-between align-items-center mb-4">
        <h2 class="fw-bold text-dark">
          <i class="bi bi-clock-history me-2 text-primary"></i> Task Report
        </h2>
        <div>
          <div class="btn-group">
            <button type="button" class="btn btn-info btn-sm dropdown-toggle" data-bs-toggle="dropdown">
              <i class="bi bi-download"></i> Export
            </button>
            <ul class="dropdown-menu">
              <li><a class="dropdown-item" href="BbTaskReportController?type=excel&filter=${selectedFilter}&recordsPerPage=${recordsPerPage}&page=${pagination.currentPage}">Excel</a></li>
              <li><a class="dropdown-item" href="BbTaskReportController?type=pdf&filter=${selectedFilter}&recordsPerPage=${recordsPerPage}&page=${pagination.currentPage}">PDF</a></li>
            </ul>
          </div>
        </div>
      </div>

      <!-- Task Cards -->
      <div class="row">
        <div class="col-md-8">
          <div class="row">
            <div class="col-sm-6 mb-3">
              <div class="info-card bg-gradient-success">
                <div>
                  <h3>${taskSummary.completed}</h3>
                  <p>Completed Tasks</p>
                </div>
                <i class="bi bi-check-circle info-icon"></i>
              </div>
            </div>
            <div class="col-sm-6 mb-3">
              <div class="info-card bg-gradient-warning">
                <div>
                  <h3>${taskSummary.overdue}</h3>
                  <p>Overdue Tasks</p>
                </div>
                <i class="bi bi-hourglass-split info-icon"></i>
              </div>
            </div>
            <div class="col-sm-6 mb-3">
              <div class="info-card bg-gradient-primary">
                <div>
                  <h3>${taskSummary.total - taskSummary.completed - taskSummary.onhold - taskSummary.overdue}</h3>
                  <p>In Progress Tasks</p>
                </div>
                <i class="bi bi-arrow-repeat info-icon"></i>
              </div>
            </div>
            <div class="col-sm-6 mb-3">
              <div class="info-card bg-gradient-purple">
                <div>
                  <h3>${taskSummary.onhold}</h3>
                  <p>On Hold Tasks</p>
                </div>
                <i class="bi bi-pause-circle info-icon"></i>
              </div>
            </div>
          </div>
        </div>

        <!-- Donut Chart -->
        <div class="col-md-4">
          <div class="card">
            <div class="card-body text-center">
              <canvas id="donutChart" height="250"></canvas>
            </div>
          </div>
        </div>
      </div>

      <!-- Tasks Table -->
      <div class="card mt-3">
        <div class="card-header bg-light d-flex justify-content-between align-items-center">
          <h3 class="card-title">📌 Task List</h3>
          <div class="d-flex align-items-center">
            <input id="searchInput" type="text" class="form-control form-control-sm me-2" placeholder="Search tasks..." />
            <form id="filterForm" method="get" action="BbTaskReportController" class="d-flex align-items-center me-2">
              <label class="me-2">Filter</label>
              <select name="filter" class="form-select form-select-sm" onchange="document.getElementById('filterForm').submit()">
                <option value="" ${empty selectedFilter ? 'selected' : ''}>All</option>
                <option value="daily" ${selectedFilter == 'daily' ? 'selected' : ''}>Daily</option>
                <option value="weekly" ${selectedFilter == 'weekly' ? 'selected' : ''}>Weekly</option>
                <option value="monthly" ${selectedFilter == 'monthly' ? 'selected' : ''}>Monthly</option>
              </select>
              <input type="hidden" name="recordsPerPage" value="${recordsPerPage}" />
            </form>

            <form id="recordsForm" method="get" action="BbTaskReportController" class="d-flex align-items-center">
              <label class="me-2">Show</label>
              <select name="recordsPerPage" class="form-select form-select-sm me-2" onchange="document.getElementById('recordsForm').submit()">
                <option value="10" ${recordsPerPage == 10 ? 'selected' : ''}>10</option>
                <option value="20" ${recordsPerPage == 20 ? 'selected' : ''}>20</option>
                <option value="50" ${recordsPerPage == 50 ? 'selected' : ''}>50</option>
              </select>
              entries
              <input type="hidden" name="filter" value="${selectedFilter}" />
            </form>
          </div>
        </div>

        <div class="card-body table-responsive">
          <table class="table table-bordered table-hover table-striped">
            <thead class="table-light">
              <tr>
                <th>ID</th>
                <th>Task Name</th>
                <th>Project</th>
                <th>Due Date</th>
                <th>Priority</th>
                <th>Status</th>
              </tr>
            </thead>
            <tbody id="taskTableBody">
              <c:choose>
                <c:when test="${not empty pagination and not empty pagination.data}">
                  <c:forEach var="task" items="${pagination.data}">
                    <tr>
                      <td>${task.taskId}</td>
                      <td>${task.taskName}</td>
                      <td>${task.projectName}</td>
                      <td>${task.dueDate}</td>
                      <td>${task.priority}</td>
                      <td>
                        <c:choose>
                          <c:when test="${task.status eq 'Completed'}">
                            <span class="badge bg-success">${task.status}</span>
                          </c:when>
                          <c:when test="${task.status eq 'In Progress'}">
                            <span class="badge bg-primary">${task.status}</span>
                          </c:when>
                          <c:when test="${task.status eq 'Pending'}">
                            <span class="badge bg-warning">${task.status}</span>
                          </c:when>
                          <c:otherwise>
                            <span class="badge bg-secondary">${task.status}</span>
                          </c:otherwise>
                        </c:choose>
                      </td>
                    </tr>
                  </c:forEach>
                </c:when>
                <c:otherwise>
                  <tr>
                    <td colspan="6" class="text-center text-muted">No tasks available</td>
                  </tr>
                </c:otherwise>
              </c:choose>
            </tbody>
          </table>
        </div>

        <!-- Pagination -->
        <div class="card-footer d-flex justify-content-between align-items-center">
          <div>
            <c:if test="${not empty pagination}">
              <c:if test="${pagination.currentPage > 1}">
                <a href="BbTaskReportController?page=${pagination.currentPage - 1}&recordsPerPage=${recordsPerPage}&filter=${selectedFilter}" class="btn btn-outline-secondary btn-sm">Previous</a>
              </c:if>
              <c:if test="${pagination.currentPage < pagination.totalPages}">
                <a href="BbTaskReportController?page=${pagination.currentPage + 1}&recordsPerPage=${recordsPerPage}&filter=${selectedFilter}" class="btn btn-outline-secondary btn-sm">Next</a>
              </c:if>
            </c:if>
          </div>
          <span>
            <c:if test="${not empty pagination}">
              Page ${pagination.currentPage} of ${pagination.totalPages}
            </c:if>
          </span>
        </div>
      </div>
    </section>
  </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/admin-lte@3.2/dist/js/adminlte.min.js"></script>

<script>
  // Donut chart with hover tooltips and gradient
  const ctx = document.getElementById("donutChart").getContext("2d");
  const completed = ${taskSummary.completed};
  const onHold = ${taskSummary.onhold};
  const overdue = ${taskSummary.overdue};
  const inProgress = ${taskSummary.total - completed - onHold - overdue};

  const donutChart = new Chart(ctx, {
    type: "doughnut",
    data: {
      labels: ["Completed", "Overdue", "In Progress", "On Hold"],
      datasets: [
        {
          data: [completed, overdue, inProgress, onHold],
          backgroundColor: [
            "rgba(40, 167, 69, 0.8)",
            "rgba(255, 193, 7, 0.8)",
            "rgba(0, 123, 255, 0.8)",
            "rgba(111, 66, 193, 0.8)",
          ],
          borderColor: ["#28a745", "#ffc107", "#007bff", "#6f42c1"],
          borderWidth: 2,
          hoverOffset: 20,
        },
      ],
    },
    options: {
      plugins: { legend: { display: true, position: "bottom" } },
      cutout: "70%",
    },
  });

  // Search functionality
  document.getElementById("searchInput").addEventListener("keyup", function () {
    const filter = this.value.toLowerCase();
    const rows = document.querySelectorAll("#taskTableBody tr");
    rows.forEach((row) => {
      const text = row.innerText.toLowerCase();
      row.style.display = text.includes(filter) ? "" : "none";
    });
  });
</script>
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
