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
<script data-cfasync="false" nonce="06cb1374-3a81-4a88-aebe-16de25f6e552">try{(function(w,d){!function(j,k,l,m){if(j.zaraz)console.error("zaraz is loaded twice");else{j[l]=j[l]||{};j[l].executed=[];j.zaraz={deferred:[],listeners:[]};j.zaraz._v="5870";j.zaraz._n="06cb1374-3a81-4a88-aebe-16de25f6e552";j.zaraz.q=[];j.zaraz._f=function(n){return async function(){var o=Array.prototype.slice.call(arguments);j.zaraz.q.push({m:n,a:o})}};for(const p of["track","set","debug"])j.zaraz[p]=j.zaraz._f(p);j.zaraz.init=()=>{var q=k.getElementsByTagName(m)[0],r=k.createElement(m),s=k.getElementsByTagName("title")[0];s&&(j[l].t=k.getElementsByTagName("title")[0].text);j[l].x=Math.random();j[l].w=j.screen.width;j[l].h=j.screen.height;j[l].j=j.innerHeight;j[l].e=j.innerWidth;j[l].l=j.location.href;j[l].r=k.referrer;j[l].k=j.screen.colorDepth;j[l].n=k.characterSet;j[l].o=(new Date).getTimezoneOffset();if(j.dataLayer)for(const t of Object.entries(Object.entries(dataLayer).reduce((u,v)=>({...u[1],...v[1]}),{})))zaraz.set(t[0],t[1],{scope:"page"});j[l].q=[];for(;j.zaraz.q.length;){const w=j.zaraz.q.shift();j[l].q.push(w)}r.defer=!0;for(const x of[localStorage,sessionStorage])Object.keys(x||{}).filter(z=>z.startsWith("_zaraz_")).forEach(y=>{try{j[l]["z_"+y.slice(7)]=JSON.parse(x.getItem(y))}catch{j[l]["z_"+y.slice(7)]=x.getItem(y)}});r.referrerPolicy="origin";r.src="../../cdn-cgi/zaraz/sd0d9.js?z="+btoa(encodeURIComponent(JSON.stringify(j[l])));q.parentNode.insertBefore(r,q)};["complete","interactive"].includes(k.readyState)?zaraz.init():j.addEventListener("DOMContentLoaded",zaraz.init)}}(w,d,"zarazData","script");window.zaraz._p=async bs=>new Promise(bt=>{if(bs){bs.e&&bs.e.forEach(bu=>{try{const bv=d.querySelector("script[nonce]"),bw=bv?.nonce||bv?.getAttribute("nonce"),bx=d.createElement("script");bw&&(bx.nonce=bw);bx.innerHTML=bu;bx.onload=()=>{d.head.removeChild(bx)};d.head.appendChild(bx)}catch(by){console.error(`Error executing script: ${bu}\n`,by)}});Promise.allSettled((bs.f||[]).map(bz=>fetch(bz[0],bz[1])))}bt()});zaraz._p({"e":["(function(w,d){})(window,document)"]});})(window,document)}catch(e){throw fetch("/cdn-cgi/zaraz/t"),e;};

</script>
<title>Project Report</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css">
    <style>
        body { background-color: #f8f9fa; }
        h2.page-title {
            font-weight: 1000;
            margin-bottom: 20px;
            color: #343a40;
        }

        .summary-card {
            border-radius: 15px;
            color: #fff;
            transition: transform 0.2s, box-shadow 0.2s;
        }
        .summary-card:hover {
            transform: translateY(-4px);
            box-shadow: 0 6px 15px rgba(0,0,0,0.15);
        }
        .summary-card .icon-box {
            width: 55px;
            height: 120px;
            border-radius: 50%;
            display: flex;
            align-items: center;
            justify-content: center;
            font-size: 1.8rem;
            margin-right: 12px;
            background: rgba(255,255,255,0.25);
        }

        /* Gradient backgrounds */
        .card-total    { background: linear-gradient(135deg, #4facfe, #00f2fe); }
        .card-complete { background: linear-gradient(135deg, #43e97b, #38f9d7); }
        .card-hold     { background: linear-gradient(135deg, #f7971e, #ffd200); }
        .card-overdue  { background: linear-gradient(135deg, #f953c6, #b91d73); }

        .team-member img { border-radius: 50%; width: 40px; height: 40px; object-fit: cover; }
        .priority-high { color: #dc3545; font-weight: bold; }
        .priority-medium { color: #ffc107; font-weight: bold; }
        .priority-low { color: #28a745; font-weight: bold; }
        .status-badge { padding: 2px 8px; border-radius: 5px; font-size: 0.75rem; }
        .status-active { background-color: #28a745; color: #fff; }
        .status-onhold { background-color: #6c757d; color: #fff; }
        .status-overdue { background-color: #dc3545; color: #fff; }
        .status-completed { background-color: #007bff; color: #fff; }
        table td, table th { padding: 8px !important; vertical-align: middle !important; }

        .table-controls .form-select, 
        .table-controls .form-control {
            height: calc(1.5em + .5rem + 2px);
            padding: .25rem .5rem;
            font-size: 0.85rem;
        }
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
              <li class="breadcrumb-item"><a href="<%= request.getContextPath() %>/bbHomeReportController">Home</a></li>
              <li class="breadcrumb-item active">Dashboard v1</li>
            </ol>
          </div><!-- /.col -->
        </div><!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>
		<section class="content">

		 <h2 class="page-title">Project Report</h2>

    <!-- Top Section: Cards + Chart -->
    <div class="row mb-4">
        <!-- Summary Cards (Left) -->
        <div class="col-md-6">
            <div class="row g-3">
                <div class="col-md-6">
                    <div class="card shadow summary-card card-total">
                        <div class="card-body d-flex align-items-center">
                            <div class="icon-box"><i class="bi bi-kanban"></i></div>
                            <div>
                                <h6 class="mb-1">Total Projects</h6>
                                <h3 class="mb-0 fw-bold">${summary.total}</h3>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="card shadow summary-card card-complete">
                        <div class="card-body d-flex align-items-center">
                            <div class="icon-box"><i class="bi bi-check-circle-fill"></i></div>
                            <div>
                                <h6 class="mb-1">Completed Projects</h6>
                                <h3 class="mb-0 fw-bold">${summary.completed}</h3>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="card shadow summary-card card-hold">
                        <div class="card-body d-flex align-items-center">
                            <div class="icon-box"><i class="bi bi-pause-circle-fill"></i></div>
                            <div>
                                <h6 class="mb-1">On Hold Projects</h6>
                                <h3 class="mb-0 fw-bold">${summary.onhold}</h3>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="card shadow summary-card card-overdue">
                        <div class="card-body d-flex align-items-center">
                            <div class="icon-box"><i class="bi bi-exclamation-octagon-fill"></i></div>
                            <div>
                                <h6 class="mb-1">Overdue Projects</h6>
                                <h3 class="mb-0 fw-bold">${summary.overdue}</h3>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Pie Chart (Right) -->
        <div class="col-md-6">
            <div class="card shadow border-0">
                <div class="card-header d-flex justify-content-between align-items-center">
                    <h5 class="mb-0">Projects By Status</h5>
                    <!-- Export Dropdown -->
                    <div class="dropdown">
                        <button class="btn btn-outline-secondary btn-sm dropdown-toggle" data-bs-toggle="dropdown">
                            <i class="bi bi-download"></i> Export
                        </button>
                        <ul class="dropdown-menu dropdown-menu-end">
                            <li><a class="dropdown-item" href="BbProjectReportController?action=exportExcel">Excel</a></li>
                            <li><a class="dropdown-item" href="BbProjectReportController?action=exportPDF">PDF</a></li>
                        </ul>
                    </div>
                </div>
                <div class="card-body">
                    <canvas id="pieChart" style="max-height:250px;"></canvas>
                </div>
            </div>
        </div>
    </div>

    <!-- Project List -->
    <div class="card shadow border-0">
        <div class="card-header d-flex justify-content-between align-items-center table-controls">
            <h5 class="mb-0">Project List</h5>
            <div class="d-flex align-items-center gap-3">
                <input type="text" id="searchInput" class="form-control form-control-sm w-auto" placeholder="Search...">
                <div class="d-flex align-items-center gap-2">
                    Show 
                    <select id="entriesSelect" class="form-select form-select-sm w-auto">
                        <option value="10">10</option>
                        <option value="20">20</option>
                        <option value="50">50</option>
                    </select> 
                    entries
                </div>
            </div>
        </div>
        <div class="card-body table-responsive">
            <table class="table table-sm table-striped align-middle" id="projectTable">
                <thead class="table-dark">
                    <tr>
                        <th>Project ID</th>
                        <th>Project Name</th>
                        <th>Leader</th>
                        <th>Team Members</th>
                        <th>Deadline</th>
                        <th>Priority</th>
                        <th>Status</th>
                  
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="row" items="${pagination.data}">
                        <tr>
                            <td>${row.projectId}</td>
                            <td>${row.projectName}</td>
                            <td>${row.leaderName}</td>
                             <td>
                                <c:forEach var="m" items="${row.members}">
                                    <div class="team-member d-inline-block me-2" title="${m.name}">
                                        <img src="images/${m.profilePicture}" alt="${m.name}" />
                                        <div style="font-size:0.7rem;">${m.name}</div>
                                    </div>
                                </c:forEach>
                            </td>
                            <td>${row.deadline}</td>
                            <td>
                                <c:choose>
                                    <c:when test="${row.priority eq 'High'}"><span class="priority-high">High</span></c:when>
                                    <c:when test="${row.priority eq 'Medium'}"><span class="priority-medium">Medium</span></c:when>
                                    <c:otherwise><span class="priority-low">Low</span></c:otherwise>
                                </c:choose>
                            </td>
                            <td>
                                <c:choose>
                                    <c:when test="${row.status eq 'Active'}"><span class="status-badge status-active">Active</span></c:when>
                                    <c:when test="${row.status eq 'OnHold'}"><span class="status-badge status-onhold">On Hold</span></c:when>
                                    <c:when test="${row.status eq 'Overdue'}"><span class="status-badge status-overdue">Overdue</span></c:when>
                                    <c:when test="${row.status eq 'Completed'}"><span class="status-badge status-completed">Completed</span></c:when>
                                    <c:otherwise><span>${row.status}</span></c:otherwise>
                                </c:choose>
                            </td>
                           
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <!-- Table Footer Controls -->
        <div class="card-footer d-flex justify-content-between align-items-center">
            <div>
                <button class="btn btn-outline-secondary btn-sm" id="prevPage">Previous</button>
                <button class="btn btn-outline-secondary btn-sm" id="nextPage">Next</button>
            </div>
        </div>
    </div>
    </section>
</div>


<script>
    // ===== Pie Chart =====
    const ctx = document.getElementById('pieChart').getContext('2d');
    const gradient1 = ctx.createLinearGradient(0, 0, 0, 200); gradient1.addColorStop(0, "#4facfe"); gradient1.addColorStop(1, "#00f2fe");
    const gradient2 = ctx.createLinearGradient(0, 0, 0, 200); gradient2.addColorStop(0, "#43e97b"); gradient2.addColorStop(1, "#38f9d7");
    const gradient3 = ctx.createLinearGradient(0, 0, 0, 200); gradient3.addColorStop(0, "#f7971e"); gradient3.addColorStop(1, "#ffd200");
    const gradient4 = ctx.createLinearGradient(0, 0, 0, 200); gradient4.addColorStop(0, "#f953c6"); gradient4.addColorStop(1, "#b91d73");

    new Chart(ctx, {
        type: 'pie',
        data: {
            labels: ['Total', 'Completed', 'On Hold', 'Overdue'],
            datasets: [{
                data: [${summary.total}, ${summary.completed}, ${summary.onhold}, ${summary.overdue}],
                backgroundColor: [gradient1, gradient2, gradient3, gradient4]
            }]
        },
        options: { 
            responsive: true, 
            plugins: { legend: { position: 'right' } } 
        }
    });

    // ===== Table Search & Pagination =====
    const table = document.getElementById("projectTable").getElementsByTagName("tbody")[0];
    const searchInput = document.getElementById("searchInput");
    const entriesSelect = document.getElementById("entriesSelect");
    let currentPage = 1, rowsPerPage = parseInt(entriesSelect.value);

    function renderTable() {
        const rows = table.querySelectorAll("tr");
        const filter = searchInput.value.toLowerCase();
        let visibleRows = Array.from(rows).filter(r => r.innerText.toLowerCase().includes(filter));
        rows.forEach(r => r.style.display = "none");
        let start = (currentPage - 1) * rowsPerPage;
        let end = start + rowsPerPage;
        visibleRows.slice(start, end).forEach(r => r.style.display = "");
    }

    searchInput.addEventListener("keyup", () => { currentPage=1; renderTable(); });
    entriesSelect.addEventListener("change", () => { rowsPerPage=parseInt(entriesSelect.value); currentPage=1; renderTable(); });
    document.getElementById("prevPage").addEventListener("click", () => { if(currentPage>1){currentPage--;renderTable();} });
    document.getElementById("nextPage").addEventListener("click", () => { currentPage++;renderTable(); });

    renderTable();
</script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
		
		
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
