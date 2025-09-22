<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*" %>
<%@ page import="helper.reportHelper.BbPayslipReportHelper" %>
    
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
<title>Payroll Report</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css"/>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

    <style>
        .card-icon { font-size: 45px; opacity: 0.9; }
        .card-title-small { font-size: 14px; }
        .table-wrapper { max-height: 400px; overflow-y: auto; }
        .entries-select { width: 80px; display: inline-block; }
        .year-select { width: 120px; display: inline-block; }
        .graph-header { display: flex; justify-content: flex-end; align-items: center; margin-bottom: 20px; }
        .graph-header select, .graph-header .btn { margin-left: 10px; }
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
              <li class="breadcrumb-item"> <a href="<%= request.getContextPath() %>/bbHomeReportController">Home</a></li>
              <li class="breadcrumb-item active">Dashboard v1</li>
            </ol>
          </div><!-- /.col -->
        </div><!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>
		<section class="content">
		
		<h2 class="mb-4">Payroll Report</h2>

<div class="row">
    <!-- Left: Cards -->
    <div class="col-lg-6">
        <div class="row">
            <div class="col-6 mb-3">
                <div class="card bg-primary text-white shadow">
                    <div class="card-body text-center">
                        <i class="fas fa-money-bill-wave card-icon"></i>
                        <div class="card-title-small">Total Payroll</div>
                        <h4>₹ <%= ((Map<String,Double>)request.getAttribute("cardStats")).get("totalPayroll") %></h4>
                    </div>
                </div>
            </div>
            <div class="col-6 mb-3">
                <div class="card bg-danger text-white shadow">
                    <div class="card-body text-center">
                        <i class="fas fa-minus-circle card-icon"></i>
                        <div class="card-title-small">Total Deduction</div>
                        <h4>₹ <%= ((Map<String,Double>)request.getAttribute("cardStats")).get("totalDeduction") %></h4>
                    </div>
                </div>
            </div>
            <div class="col-6 mb-3">
                <div class="card bg-success text-white shadow">
                    <div class="card-body text-center">
                        <i class="fas fa-coins card-icon"></i>
                        <div class="card-title-small">Total Earning</div>
                        <h4>₹ <%= ((Map<String,Double>)request.getAttribute("cardStats")).get("totalEarning") %></h4>
                    </div>
                </div>
            </div>
            <div class="col-6 mb-3">
                <div class="card bg-warning text-white shadow">
                    <div class="card-body text-center">
                        <i class="fas fa-wallet card-icon"></i>
                        <div class="card-title-small">Total Net Pay</div>
                        <h4>₹ <%= ((Map<String,Double>)request.getAttribute("cardStats")).get("totalNetPay") %></h4>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Right: Graph & Controls -->
    <div class="col-lg-6">
        <div class="graph-header">
            <!-- Year Dropdown -->
            <select id="yearSelect" class="year-select form-control form-control-sm">
                <% 
                    int currentYear = Calendar.getInstance().get(Calendar.YEAR);
                    int selectedYear = request.getAttribute("selectedYear") != null ? (Integer)request.getAttribute("selectedYear") : currentYear;
                    for(int y = currentYear; y >= currentYear - 5; y--) {
                %>
                    <option value="<%=y%>" <%= (y == selectedYear) ? "selected" : "" %>><%=y%></option>
                <% } %>
            </select>

            <!-- Export Button Dropdown -->
            <div class="dropdown">
                <button class="btn btn-success dropdown-toggle" type="button" id="exportDropdown" data-toggle="dropdown">
                    Export
                </button>
                <div class="dropdown-menu">
                    <a class="dropdown-item" href="BbPayslipReportServlet?action=exportExcel&year=<%=selectedYear%>">Excel</a>
                    <a class="dropdown-item" href="BbPayslipReportServlet?action=exportPDF&year=<%=selectedYear%>">PDF</a>
                </div>
            </div>
        </div>

        <div class="card shadow">
            <div class="card-body">
                <canvas id="payrollChart" style="height: 250px; width:100%"></canvas>
            </div>
        </div>
    </div>
</div>

<!-- Payroll List -->
<div class="card shadow mt-4">
    <div class="card-header d-flex justify-content-between align-items-center">
        <h5 class="mb-0">Payroll List</h5>
        <div>
            Show
            <select id="entriesSelect" class="entries-select form-control form-control-sm">
                <option value="10" <%= ("10".equals(request.getParameter("entries")) ? "selected" : "") %>>10</option>
                <option value="20" <%= ("20".equals(request.getParameter("entries")) ? "selected" : "") %>>20</option>
                <option value="30" <%= ("30".equals(request.getParameter("entries")) ? "selected" : "") %>>30</option>
            </select>
            entries
            <input type="text" id="searchInput" class="form-control form-control-sm d-inline-block ml-2" placeholder="Search" style="width: 200px;">
        </div>
    </div>

    <div class="card-body table-wrapper">
        <table class="table table-bordered table-striped table-hover" id="payrollTable">
            <thead class="thead-dark">
                <tr>
                    <th>Payslip ID</th>
                    <th>Profile</th>
                    <th>Employee Name</th>
                    <th>Paid Amount</th>
                    <th>Month</th>
                    <th>Year</th>
                </tr>
            </thead>
            <tbody>
            <%
                List<BbPayslipReportHelper> payslipData = (List<BbPayslipReportHelper>) request.getAttribute("payslipData");
                if (payslipData != null && !payslipData.isEmpty()) {
                    for (BbPayslipReportHelper p : payslipData) {
            %>
                <tr>
                    <td><%= p.getPayslipId() %></td>
                    <td><img src="images/<%=p.getProfilePhoto()%>" class="rounded-circle" width="45" height="45"/></td>
                    <td><%= p.getEmpName() %></td>
                    <td>₹ <%= p.getPaidAmount() %></td>
                    <td><%= new java.text.DateFormatSymbols().getMonths()[p.getPayMonth()-1] %></td>
                    <td><%= p.getPayYear() %></td>
                </tr>
            <% } } else { %>
                <tr><td colspan="6" class="text-center text-muted">No records found</td></tr>
            <% } %>
            </tbody>
        </table>
    </div>

    <div class="card-footer d-flex justify-content-between">
        <button class="btn btn-primary" id="prevBtn">Previous</button>
        <button class="btn btn-primary" id="nextBtn">Next</button>
    </div>
</div>

<!-- Scripts -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

<script>
    // ===== Chart =====
    document.addEventListener("DOMContentLoaded", function () {
        const monthlyStats = {
            <% Map<String, Double> monthlyStats = (Map<String, Double>) request.getAttribute("monthlyStats");
               if (monthlyStats != null) {
                   for (Map.Entry<String, Double> entry : monthlyStats.entrySet()) { %>
            "<%= entry.getKey() %>": <%= entry.getValue() %>,
            <% } } %>
        };
        const labels = Object.keys(monthlyStats);
        const values = Object.values(monthlyStats);

        new Chart(document.getElementById("payrollChart"), {
            type: "line",
            data: {
                labels: labels,
                datasets: [{
                    label: "Total Payroll",
                    data: values,
                    backgroundColor: "rgba(60,141,188,0.3)",
                    borderColor: "rgba(60,141,188,1)",
                    pointRadius: 4,
                    fill: true,
                    tension: 0.3
                }]
            },
            options: { responsive: true, maintainAspectRatio: false }
        });
    });

    // ===== Search Table =====
    $("#searchInput").on("keyup", function() {
        var value = $(this).val().toLowerCase();
        $("#payrollTable tbody tr").filter(function() {
            $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
        });
    });

    // ===== Entries Selector =====
    $("#entriesSelect").on("change", function() {
        var entries = $(this).val();
        var year = $("#yearSelect").val();
        window.location.href = "BbPayslipReportServlet?page=1&entries=" + entries + "&year=" + year;
    });

    // ===== Year Selector =====
    $("#yearSelect").on("change", function() {
        var year = $(this).val();
        var entries = $("#entriesSelect").val();
        window.location.href = "BbPayslipReportServlet?page=1&year=" + year + "&entries=" + entries;
    });

    // ===== Pagination =====
    $("#prevBtn").on("click", function() {
        var currentPage = parseInt("<%= request.getAttribute("currentPage") %>");
        var entries = $("#entriesSelect").val();
        var year = $("#yearSelect").val();
        if (currentPage > 1) {
            window.location.href = "BbPayslipReportServlet?page=" + (currentPage-1) + "&entries=" + entries + "&year=" + year;
        }
    });
    $("#nextBtn").on("click", function() {
        var currentPage = parseInt("<%= request.getAttribute("currentPage") %>");
        var totalPages = parseInt("<%= request.getAttribute("totalPages") %>");
        var entries = $("#entriesSelect").val();
        var year = $("#yearSelect").val();
        if (currentPage < totalPages) {
            window.location.href = "BbPayslipReportServlet?page=" + (currentPage+1) + "&entries=" + entries + "&year=" + year;
        }
    });
</script>		
		</section>
	</div>
</div>
</body>
</html>
<jsp:include page="/footer.jsp"></jsp:include>