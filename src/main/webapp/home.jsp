<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
     <%@ page import="helper.employeeHelper.UserDetails" %>
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
  /* Full width for the calendar container */
  #calendar {
    width: 100% !important;
    max-width: 100% !important;
    margin: 0 auto;
  }

  /* Make the datepicker fill its container's width */
  .ui-datepicker {
    width: 100% !important;
    min-width: 0;
    max-width: 100% !important;
    box-sizing: border-box;
  }

  /* Make header and footer span full width */
  .ui-datepicker-header,
  .ui-datepicker-buttonpane {
    width: 100%;
    box-sizing: border-box;
  }

  /* Full-width for the date table */
  .ui-datepicker-calendar {
    width: 100%;
    table-layout: fixed;
  }

  .ui-datepicker-calendar th,
  .ui-datepicker-calendar td {
    width: 14.285% !important; /* 100% / 7 weekdays */
    padding: 0;
    text-align: center;
  }
  .ui-datepicker-calendar td a {
    width: 95%;
    margin: 2px auto;
    display: block;
    box-sizing: border-box;
  }

  /* Optional: reduce outside padding for tighter fit */
  .ui-datepicker {
    padding: 6px;
  }
</style>




<link rel="stylesheet" href="https://code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>


</head>
<body class="hold-transition sidebar-mini layout-fixed">



<%
    HttpSession session1 = request.getSession(false);
    UserDetails employee = (UserDetails) session1.getAttribute("employee");
    
    
%>


<jsp:include page="navbar.jsp"></jsp:include>

<jsp:include page="sidebar.jsp"></jsp:include>



<div class="wrapper">
	<div class="content-wrapper">
		
		<section class="content">
		
		
		<div class="container-fluid">
		
		
		<% if (employee != null && "admin".equalsIgnoreCase(employee.getRoleName())) { %>
		
		
		<div class="mb-3">
  <h3>Welcome, Admin!</h3>
  <p>Here’s a quick overview of your HR management system.</p>
</div>
		
		
		
		<div class="row">
  <!-- Total Employees -->
  <div class="col-lg-3 col-6">
    <a href="#" style="text-decoration:none;">
      <div class="small-box bg-info">
        <div class="inner">
          <h3>${adminMetrics.totalEmployees}</h3>
          <p>Total Employees</p>
        </div>
        <div class="icon"><i class="fas fa-users"></i></div>
      </div>
    </a>
  </div>

  <!-- Active Departments -->
  <div class="col-lg-3 col-6">
    <a href="#" style="text-decoration:none;">
      <div class="small-box bg-success">
        <div class="inner">
          <h3>${adminMetrics.activeDepartments}</h3>
          <p>Active Departments</p>
        </div>
        <div class="icon"><i class="fas fa-building"></i></div>
      </div>
    </a>
  </div>

  <!-- Active Trainers -->
  <div class="col-lg-3 col-6">
    <a href="#" style="text-decoration:none;">
      <div class="small-box bg-warning">
        <div class="inner">
          <h3>${adminMetrics.activeTrainers}</h3>
          <p>Active Trainers</p>
        </div>
        <div class="icon"><i class="fas fa-user-tie"></i></div>
      </div>
    </a>
  </div>

  <!-- Upcoming Trainings -->
  <div class="col-lg-3 col-6">
    <a href="#" style="text-decoration:none;">
      <div class="small-box bg-danger">
        <div class="inner">
          <h3>${adminMetrics.upcomingTrainings}</h3>
          <p>Upcoming Trainings</p>
        </div>
        <div class="icon"><i class="fas fa-chalkboard-teacher"></i></div>
      </div>
    </a>
  </div>

  <!-- Additional Cards -->

  <!-- Training Completion Rate -->
  <div class="col-lg-3 col-6">
    <a href="#" style="text-decoration:none;">
      <div class="small-box bg-primary">
        <div class="inner">
          <h3>
            <c:choose>
              <c:when test="${adminMetrics.totalTrainings > 0}">
                ${ (adminMetrics.completedTrainings * 100) / adminMetrics.totalTrainings }%
              </c:when>
              <c:otherwise>0%</c:otherwise>
            </c:choose>
          </h3>
          <p>Training Completion Rate</p>
        </div>
        <div class="icon"><i class="fas fa-check-circle"></i></div>
      </div>
    </a>
  </div>

  <!-- Active Roles -->
  <div class="col-lg-3 col-6">
    <a href="#" style="text-decoration:none;">
      <div class="small-box bg-secondary">
        <div class="inner">
          <h3>${adminMetrics.activeRoles}</h3>
          <p>Active Roles</p>
        </div>
        <div class="icon"><i class="fas fa-user-tag"></i></div>
      </div>
    </a>
  </div>

  <!-- Active Designations -->
  <div class="col-lg-3 col-6">
    <a href="#" style="text-decoration:none;">
      <div class="small-box bg-danger">
        <div class="inner">
          <h3>${adminMetrics.activeDesignations}</h3>
          <p>Active Designations</p>
        </div>
        <div class="icon"><i class="fas fa-id-badge"></i></div>
      </div>
    </a>
  </div>

  <!-- Birthdays This Month (Placeholder) -->
  <div class="col-lg-3 col-6">
    <a href="#" style="text-decoration:none;">
      <div class="small-box bg-info">
        <div class="inner">
          <h3>5</h3>
          <p>Birthdays This Month</p>
        </div>
        <div class="icon"><i class="fas fa-birthday-cake"></i></div>
      </div>
    </a>
  </div>

</div>


<div class="row">
  <!-- Graph Card -->
  <div class="col-lg-6">
    <div class="card">
      <div class="card-header">
        <h3 class="card-title">Employees by Department</h3>
      </div>
      <div class="card-body">
        <canvas id="deptEmployeeChart" style="height: 300px;"></canvas>
      </div>
    </div>
  </div>

  <!-- Calendar Card -->
  <div class="col-lg-6">
    
    <!-- Calendar -->
            <div class="card bg-gradient-success">
              <div class="card-header border-0">

                <h3 class="card-title">
                  <i class="far fa-calendar-alt"></i>
                  Calendar
                </h3>
                <!-- tools card -->
                <div class="card-tools">
                  <!-- button with a dropdown -->
                  <div class="btn-group">
                    <button type="button" class="btn btn-success btn-sm dropdown-toggle" data-toggle="dropdown" data-offset="-52">
                      <i class="fas fa-bars"></i>
                    </button>
                    <div class="dropdown-menu" role="menu">
                      <a href="#" class="dropdown-item">Add new event</a>
                      <a href="#" class="dropdown-item">Clear events</a>
                      <div class="dropdown-divider"></div>
                      <a href="#" class="dropdown-item">View calendar</a>
                    </div>
                  </div>
                  <button type="button" class="btn btn-success btn-sm" data-card-widget="collapse">
                    <i class="fas fa-minus"></i>
                  </button>
                  <button type="button" class="btn btn-success btn-sm" data-card-widget="remove">
                    <i class="fas fa-times"></i>
                  </button>
                </div>
                <!-- /. tools -->
              </div>
              <!-- /.card-header -->
              <div class="card-body pt-0">
                <!--The calendar -->
                <div id="calendar" style="width: 100%"></div>
              </div>
              <!-- /.card-body -->
            </div>
    
  </div>
</div>


		
		
		
		<% } else if (employee != null && "manager".equalsIgnoreCase(employee.getRoleName())) { %>
		
		
		
		<h1>manager</h1>
		
		
		
		 <% } else if (employee != null) { %>
			
		
		
		<<div class="mb-3">
    <h3>Welcome, <%= employee.getFirstName() %>!</h3>
    <p>Your personalized dashboard overview.</p>
</div>

<div class="row">

  <div class="col-lg-4 col-12">
    <div class="small-box bg-info">
      <div class="inner">
        <h4>Role</h4>
        <p>${employeeMetrics.roleName}</p>
      </div>
      <div class="icon"><i class="fas fa-user-tag"></i></div>
    </div>
  </div>

  <div class="col-lg-4 col-12">
    <div class="small-box bg-success">
      <div class="inner">
        <h4>Department</h4>
        <p>${employeeMetrics.departmentName}</p>
      </div>
      <div class="icon"><i class="fas fa-building"></i></div>
    </div>
  </div>

  <div class="col-lg-4 col-12">
    <div class="small-box bg-warning">
      <div class="inner">
        <h4>Designation</h4>
        <p>${employeeMetrics.designationName}</p>
      </div>
      <div class="icon"><i class="fas fa-id-badge"></i></div>
    </div>
  </div>

</div>

<div class="row mt-3">

  <div class="col-lg-3 col-6">
    <a href="EmployeeTrainingProgress" style="text-decoration:none;">
        <div class="small-box bg-primary">
            <div class="inner">
                <h3>${employeeMetrics.upcomingTrainings}</h3>
                <p>My Trainings</p>
            </div>
            <div class="icon"><i class="fas fa-chalkboard-teacher"></i></div>
        </div>
    </a>
</div>


  <div class="col-lg-3 col-6">
    <div class="small-box bg-success">
      <div class="inner">
        <h3>${employeeMetrics.completedTrainings}</h3>
        <p>Completed Trainings</p>
      </div>
      <div class="icon"><i class="fas fa-check-circle"></i></div>
    </div>
  </div>

  <div class="col-lg-3 col-6">
    <div class="small-box bg-info">
      <div class="inner">
        <h4>Date of Joining</h4>
       <%--  <p><fmt:formatDate value="${employeeMetrics.dateOfJoining}" pattern="dd MMM yyyy"/> --%>
       <p>
       ${ employeeMetrics.dateOfJoining}
        </p>
      </div>
      <div class="icon"><i class="fas fa-calendar-alt"></i></div>
    </div>
  </div>

  <div class="col-lg-3 col-6">
    <div class="small-box bg-secondary">
      <div class="inner">
        <h4>Manager</h4>
        <p>${employeeMetrics.reportingManagerName}</p>
      </div>
      <div class="icon"><i class="fas fa-user-tie"></i></div>
    </div>
  </div>

</div>

		
		
		
		<% } %>
		
		</div>
		</section>
	</div>
</div>







<jsp:include page="footer.jsp"></jsp:include>


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
	
	<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script>
  document.addEventListener('DOMContentLoaded', function () {
    const ctx = document.getElementById('deptEmployeeChart').getContext('2d');

    // Fetch labels and data from request attribute
    const labels = [
      <c:forEach var="entry" items="${empCountByDept.keySet()}" varStatus="loop">
        '${entry}'<c:if test="${!loop.last}">,</c:if>
      </c:forEach>
    ];
    const data = [
      <c:forEach var="entry" items="${empCountByDept.values()}" varStatus="loop">
        ${entry}<c:if test="${!loop.last}">,</c:if>
      </c:forEach>
    ];

    const deptEmployeeChart = new Chart(ctx, {
      type: 'bar',
      data: {
        labels: labels,
        datasets: [{
          label: 'Employees',
          data: data,
          backgroundColor: 'rgba(54, 162, 235, 0.8)',
          borderColor: 'rgba(54, 162, 235, 1)',
          borderWidth: 1
        }]
      },
      options: {
        responsive: true,
        scales: {
          y: { 
             beginAtZero: true,
             stepSize: 1
          }
        }
      }
    });
  });
</script>
	
	
	<script>
  $(function() {
    $("#calendar").datepicker({
      showOtherMonths: true,
      selectOtherMonths: true,
      showButtonPanel: true
    });
  });
</script>
	
	
</body>
</html>