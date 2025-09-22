<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
     
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
<script data-cfasync="false" nonce="06cb1374-3a81-4a88-aebe-16de25f6e552">try{(function(w,d){!function(j,k,l,m){if(j.zaraz)console.error("zaraz is loaded twice");else{j[l]=j[l]||{};j[l].executed=[];j.zaraz={deferred:[],listeners:[]};j.zaraz._v="5870";j.zaraz._n="06cb1374-3a81-4a88-aebe-16de25f6e552";j.zaraz.q=[];j.zaraz._f=function(n){return async function(){var o=Array.prototype.slice.call(arguments);j.zaraz.q.push({m:n,a:o})}};for(const p of["track","set","debug"])j.zaraz[p]=j.zaraz._f(p);j.zaraz.init=()=>{var q=k.getElementsByTagName(m)[0],r=k.createElement(m),s=k.getElementsByTagName("title")[0];s&&(j[l].t=k.getElementsByTagName("title")[0].text);j[l].x=Math.random();j[l].w=j.screen.width;j[l].h=j.screen.height;j[l].j=j.innerHeight;j[l].e=j.innerWidth;j[l].l=j.location.href;j[l].r=k.referrer;j[l].k=j.screen.colorDepth;j[l].n=k.characterSet;j[l].o=(new Date).getTimezoneOffset();if(j.dataLayer)for(const t of Object.entries(Object.entries(dataLayer).reduce((u,v)=>({...u[1],...v[1]}),{})))zaraz.set(t[0],t[1],{scope:"page"});j[l].q=[];for(;j.zaraz.q.length;){const w=j.zaraz.q.shift();j[l].q.push(w)}r.defer=!0;for(const x of[localStorage,sessionStorage])Object.keys(x||{}).filter(z=>z.startsWith("_zaraz_")).forEach(y=>{try{j[l]["z_"+y.slice(7)]=JSON.parse(x.getItem(y))}catch{j[l]["z_"+y.slice(7)]=x.getItem(y)}});r.referrerPolicy="origin";r.src="../../cdn-cgi/zaraz/sd0d9.js?z="+btoa(encodeURIComponent(JSON.stringify(j[l])));q.parentNode.insertBefore(r,q)};["complete","interactive"].includes(k.readyState)?zaraz.init():j.addEventListener("DOMContentLoaded",zaraz.init)}}(w,d,"zarazData","script");window.zaraz._p=async bs=>new Promise(bt=>{if(bs){bs.e&&bs.e.forEach(bu=>{try{const bv=d.querySelector("script[nonce]"),bw=bv?.nonce||bv?.getAttribute("nonce"),bx=d.createElement("script");bw&&(bx.nonce=bw);bx.innerHTML=bu;bx.onload=()=>{d.head.removeChild(bx)};d.head.appendChild(bx)}catch(by){console.error(`Error executing script: ${bu}\n`,by)}});Promise.allSettled((bs.f||[]).map(bz=>fetch(bz[0],bz[1])))}bt()});zaraz._p({"e":["(function(w,d){})(window,document)"]});})(window,document)}catch(e){throw fetch("/cdn-cgi/zaraz/t"),e;};
</script>

 <title>Attendance Report</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css">
    <style>
        body { background-color: #f8f9fa; }
        h2.page-title { font-weight: 700; margin-bottom: 20px; color: #343a40; }
        .summary-card { border-radius: 15px; color: #fff; transition: transform 0.2s, box-shadow 0.2s; }
        .summary-card:hover { transform: translateY(-4px); box-shadow: 0 6px 15px rgba(0,0,0,0.15); }
        .summary-card .icon-box {
            width: 55px; height: 130px; border-radius: 50%;
            display: flex; align-items: center; justify-content: center;
            font-size: 1.5rem; margin-right: 12px; background: rgba(255,255,255,0.25);
        }
        .card-total    { background: linear-gradient(135deg, #4facfe, #00f2fe); }
        .card-leave    { background: linear-gradient(135deg, #f7971e, #ffd200); }
        .card-holiday  { background: linear-gradient(135deg, #43e97b, #38f9d7); }
        .card-halfday  { background: linear-gradient(135deg, #f953c6, #b91d73); }
        table td, table th { padding: 8px !important; vertical-align: middle !important; }
        .employee-pic { border-radius: 50%; width: 40px; height: 40px; object-fit: cover; margin-right: 8px; }
        .data-controls { margin-bottom: 10px; }
    </style>

</head>

<body class="hold-transition sidebar-mini layout-fixed">

<jsp:include page="/navbar.jsp"></jsp:include>

<jsp:include page="/sidebar.jsp"></jsp:include>

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
              <li class="breadcrumb-item">
		 <a href="<%= request.getContextPath() %>/bbHomeReportController">Home</a>
		</li>
              <li class="breadcrumb-item active">Dashboard v1</li>
            </ol>
          </div><!-- /.col -->
        </div><!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>
		<section class="content">
		
		<body class="p-3 bg-light">

<div class="container-fluid">

    <h2 class="page-title">Attendance Report</h2>

    <!-- Summary + Chart -->
    <div class="row mb-4">
        <div class="col-md-6">
            <div class="row g-3">
                <div class="col-md-6">
                    <div class="card shadow summary-card card-total">
                        <div class="card-body d-flex align-items-center">
                            <div class="icon-box"><i class="bi bi-people-fill"></i></div>
                            <div>
                                <h6>Total Employees</h6>
                                <h3 class="fw-bold">
                                    <c:out value="${attendanceSummary.totalEmployees}" default="0"/>
                                </h3>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="card shadow summary-card card-leave">
                        <div class="card-body d-flex align-items-center">
                            <div class="icon-box"><i class="bi bi-calendar-x"></i></div>
                            <div>
                                <h6>Total Leaves</h6>
                                <h3 class="fw-bold" id="leaveCount">
                                    <c:out value="${attendanceSummary.totalLeaves}" default="0"/>
                                </h3>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="card shadow summary-card card-holiday">
                        <div class="card-body d-flex align-items-center">
                            <div class="icon-box"><i class="bi bi-tree-fill"></i></div>
                            <div>
                                <h6>Total Holidays</h6>
                                <h3 class="fw-bold">8</h3> <!-- Hardcoded -->
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="card shadow summary-card card-halfday">
                        <div class="card-body d-flex align-items-center">
                            <div class="icon-box"><i class="bi bi-hourglass-split"></i></div>
                            <div>
                                <h6>Total Half Days</h6>
                                <h3 class="fw-bold" id="halfdayCount">
                                    <c:out value="${attendanceSummary.totalHalfdays}" default="0"/>
                                </h3>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Chart -->
        <div class="col-md-6">
            <div class="card shadow border-0">
                <div class="card-header d-flex justify-content-between align-items-center">
                    <h5 class="mb-0">Attendance Overview</h5>
                    <div class="dropdown">
                        <button class="btn btn-outline-secondary btn-sm dropdown-toggle" data-bs-toggle="dropdown">
                            <i class="bi bi-download"></i> Export
                        </button>
                        <ul class="dropdown-menu dropdown-menu-end">
                            <li><a class="dropdown-item" href="BbAttendanceReportController?type=excel">Excel</a></li>
                            <li><a class="dropdown-item" href="BbAttendanceReportController?type=pdf">PDF</a></li>
                        </ul>
                    </div>
                </div>
                <div class="card-body">
                    <canvas id="stackedBarChart" style="min-height: 250px; height: 250px;"></canvas>
                </div>
            </div>
        </div>
    </div>

    <!-- Filters -->
    <div class="row mb-3">
        <div class="col-md-4">
            <input type="date" id="dateFilter" class="form-control" />
        </div>
        <div class="col-md-4">
            <input type="month" id="monthFilter" class="form-control" />
        </div>
        <div class="col-md-4">
            <select id="yearFilter" class="form-select">
                <option value="">Select Year</option>
            </select>
        </div>

        <script>
            // Populate year dropdown properly
            const yearFilter = document.getElementById("yearFilter");
            const currentYear = new Date().getFullYear();
            for (let y = currentYear; y >= 2020; y--) {
                const opt = document.createElement("option");
                opt.value = y;
                opt.textContent = y;
                yearFilter.appendChild(opt);
            }
        </script>
    </div>

    <!-- Attendance Table -->
    <div class="card shadow border-0">
        <div class="card-header"><h5 class="mb-0">Attendance List</h5></div>
        <div class="card-body">

            <!-- Controls -->
            <div class="d-flex justify-content-between data-controls">
                <div>
                    Show 
                    <select id="entriesSelect" class="form-select d-inline-block w-auto">
                        <option value="10" selected>10</option>
                        <option value="20">20</option>
                        <option value="50">50</option>
                    </select> entries
                </div>
                <div><input type="text" id="searchBox" class="form-control" placeholder="Search..."></div>
            </div>

            <div class="table-responsive">
                <table class="table table-sm table-striped align-middle" id="attendanceTable">
                    <thead class="table-dark">
                        <tr>
                            <th>ID</th>
                            <th>Employee</th>
                            <th>Date</th>
                            <th>Check In</th>
                            <th>Check Out</th>
                            <th>Lunch In</th>
                            <th>Lunch Out</th>
                            <th>Status</th>
                            <th>Working Hrs</th>
                            <th>Production Hrs</th>
                            <th>Break Hrs</th>
                        </tr>
                    </thead>
                    <tbody id="attendanceBody">
                        <c:forEach var="row" items="${pagination.data}">
                            <tr>
                                <td>${row.attendanceId}</td>
                                <td>
                                    <img src="images/${row.profilePicture}" class="rounded-circle" width="40" height="40" alt="${row.employeeName}" />
                                    ${row.employeeName}
                                </td>
                                <td>${row.date}</td>
                                <td>${row.checkIn}</td>
                                <td>${row.checkOut}</td>
                                <td>${row.lunchIn}</td>
                                <td>${row.lunchOut}</td>
                                <td>${row.status}</td>
                                <td>${row.workingHours}</td>
                                <td>${row.productionHours}</td>
                                <td>${row.breakHour}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>

            <!-- Pagination -->
            <div class="d-flex justify-content-between align-items-center mt-2">
                <div>
                    Showing <span id="startEntry">1</span> to 
                    <span id="endEntry">10</span> of 
                    <span id="totalEntries">${fn:length(pagination.data)}</span> entries
                </div>
                <div>
                    <button id="prevBtn" class="btn btn-sm btn-outline-secondary">Previous</button>
                    <button id="nextBtn" class="btn btn-sm btn-outline-secondary">Next</button>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- JS -->
<script>
    const rows = Array.from(document.querySelectorAll("#attendanceBody tr"));
    const searchBox = document.getElementById("searchBox");
    const entriesSelect = document.getElementById("entriesSelect");
    const prevBtn = document.getElementById("prevBtn");
    const nextBtn = document.getElementById("nextBtn");
    const startEntry = document.getElementById("startEntry");
    const endEntry = document.getElementById("endEntry");
    const totalEntries = document.getElementById("totalEntries");
    const leaveCount = document.getElementById("leaveCount");
    const halfdayCount = document.getElementById("halfdayCount");

    // Filters
    const dateFilter = document.getElementById("dateFilter");
    const monthFilter = document.getElementById("monthFilter");
    const yearFilterDropdown = document.getElementById("yearFilter");

    let currentPage = 1;
    let rowsPerPage = parseInt(entriesSelect.value);

    function filterRows() {
        const search = searchBox.value.toLowerCase();
        const dateVal = dateFilter.value;
        const monthVal = monthFilter.value;
        const yearVal = yearFilterDropdown.value;

        return rows.filter(row => {
            const text = row.innerText.toLowerCase();
            const dateCell = row.cells[2].innerText; // Date column

            let match = text.includes(search);

            if (dateVal) match = match && dateCell === dateVal;
            if (monthVal) match = match && dateCell.startsWith(monthVal);
            if (yearVal) match = match && dateCell.startsWith(yearVal);

            return match;
        });
    }

    function renderTable() {
        const filtered = filterRows();
        const total = filtered.length;
        const start = (currentPage - 1) * rowsPerPage;
        const end = Math.min(start + rowsPerPage, total);

        rows.forEach(r => r.style.display = "none");
        filtered.slice(start, end).forEach(r => r.style.display = "");

        startEntry.textContent = total === 0 ? 0 : start + 1;
        endEntry.textContent = end;
        totalEntries.textContent = total;

        // Count present/absent
        let present = 0, absent = 0;
        filtered.forEach(r => {
            const status = r.cells[7].innerText.toLowerCase();
            if (status.includes("present")) present++;
            if (status.includes("absent") || status.includes("leave")) absent++;
        });

        updateChart(present, absent);
    }


    // Chart
    const ctxBar = document.getElementById('stackedBarChart').getContext('2d');
    let chart = new Chart(ctxBar, {
        type: 'bar',
        data: {
            labels: ['Employees'],
            datasets: [
                { label: 'Present', data: [0], backgroundColor: '#43e97b' },
                { label: 'Absent', data: [0], backgroundColor: '#f953c6' }
            ]
        },
        options: { 
            responsive: true, 
            scales: { 
                x: { stacked: true }, 
                y: { stacked: true, beginAtZero: true } 
            } 
        }
    });


    function updateChart(present, absent) {
        chart.data.datasets[0].data = [present];
        chart.data.datasets[1].data = [absent];
        chart.update();
    }

    // Events
    searchBox.addEventListener("input", () => { currentPage = 1; renderTable(); });
    entriesSelect.addEventListener("change", () => { rowsPerPage = parseInt(entriesSelect.value); currentPage = 1; renderTable(); });
    prevBtn.addEventListener("click", () => { if (currentPage > 1) { currentPage--; renderTable(); } });
    nextBtn.addEventListener("click", () => { if ((currentPage * rowsPerPage) < filterRows().length) { currentPage++; renderTable(); } });
    dateFilter.addEventListener("change", () => { currentPage = 1; renderTable(); });
    monthFilter.addEventListener("change", () => { currentPage = 1; renderTable(); });
    yearFilterDropdown.addEventListener("change", () => { currentPage = 1; renderTable(); });

    renderTable();
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
	
		</section>
	</div>
</div>


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
	

<jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>

