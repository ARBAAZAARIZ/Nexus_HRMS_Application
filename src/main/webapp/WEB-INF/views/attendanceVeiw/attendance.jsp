<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Attendance Dashboard</title>

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
  
   <!-- DataTables -->
  <link rel="stylesheet" href="plugins/datatables-bs4/css/dataTables.bootstrap4.min.css">
  <link rel="stylesheet" href="plugins/datatables-responsive/css/responsive.bootstrap4.min.css">
  <link rel="stylesheet" href="plugins/datatables-buttons/css/buttons.bootstrap4.min.css">
  
  <link rel="stylesheet" href="plugins/summernote/summernote-bs4.min.css">
<script data-cfasync="false" nonce="06cb1374-3a81-4a88-aebe-16de25f6e552">try{(function(w,d){!function(j,k,l,m){if(j.zaraz)console.error("zaraz is loaded twice");else{j[l]=j[l]||{};j[l].executed=[];j.zaraz={deferred:[],listeners:[]};j.zaraz._v="5870";j.zaraz._n="06cb1374-3a81-4a88-aebe-16de25f6e552";j.zaraz.q=[];j.zaraz._f=function(n){return async function(){var o=Array.prototype.slice.call(arguments);j.zaraz.q.push({m:n,a:o})}};for(const p of["track","set","debug"])j.zaraz[p]=j.zaraz._f(p);j.zaraz.init=()=>{var q=k.getElementsByTagName(m)[0],r=k.createElement(m),s=k.getElementsByTagName("title")[0];s&&(j[l].t=k.getElementsByTagName("title")[0].text);j[l].x=Math.random();j[l].w=j.screen.width;j[l].h=j.screen.height;j[l].j=j.innerHeight;j[l].e=j.innerWidth;j[l].l=j.location.href;j[l].r=k.referrer;j[l].k=j.screen.colorDepth;j[l].n=k.characterSet;j[l].o=(new Date).getTimezoneOffset();if(j.dataLayer)for(const t of Object.entries(Object.entries(dataLayer).reduce((u,v)=>({...u[1],...v[1]}),{})))zaraz.set(t[0],t[1],{scope:"page"});j[l].q=[];for(;j.zaraz.q.length;){const w=j.zaraz.q.shift();j[l].q.push(w)}r.defer=!0;for(const x of[localStorage,sessionStorage])Object.keys(x||{}).filter(z=>z.startsWith("_zaraz_")).forEach(y=>{try{j[l]["z_"+y.slice(7)]=JSON.parse(x.getItem(y))}catch{j[l]["z_"+y.slice(7)]=x.getItem(y)}});r.referrerPolicy="origin";r.src="../../cdn-cgi/zaraz/sd0d9.js?z="+btoa(encodeURIComponent(JSON.stringify(j[l])));q.parentNode.insertBefore(r,q)};["complete","interactive"].includes(k.readyState)?zaraz.init():j.addEventListener("DOMContentLoaded",zaraz.init)}}(w,d,"zarazData","script");window.zaraz._p=async bs=>new Promise(bt=>{if(bs){bs.e&&bs.e.forEach(bu=>{try{const bv=d.querySelector("script[nonce]"),bw=bv?.nonce||bv?.getAttribute("nonce"),bx=d.createElement("script");bw&&(bx.nonce=bw);bx.innerHTML=bu;bx.onload=()=>{d.head.removeChild(bx)};d.head.appendChild(bx)}catch(by){console.error(`Error executing script: ${bu}\n`,by)}});Promise.allSettled((bs.f||[]).map(bz=>fetch(bz[0],bz[1])))}bt()});zaraz._p({"e":["(function(w,d){})(window,document)"]});})(window,document)}catch(e){throw fetch("/cdn-cgi/zaraz/t"),e;};</script>





</head>
<body class="hold-transition sidebar-mini layout-fixed">

<jsp:include page="../../../navbar.jsp"></jsp:include>

<jsp:include page="../../../sidebar.jsp"></jsp:include>



<div class="wrapper">
  <div class="content-wrapper">
    <section class="content pt-3">
      <div class="container-fluid">
        <div class="row">

\
          <div class="col-md-3 mb-3 left-column">
           <div class="card text-center"> 
           <div class="card-body"> 
           <h6 class="text-muted"><c:out value="${greeting }"/> <c:out value="${username}"/></h6>
            <h4><c:out value="${currentTime}"/></h4> 
            <div class="my-3"> 

            <img src="images/${profile}" alt="Profile Image" class="rounded-circle img-fluid" width="140"> 

            </div> 
            <span class="badge badge-primary mb-2">Production: <c:out value="${production}"/></span>
             <p>Punch In at <c:out value="${punch_in}"/></p> <form action="attendanceServlet" method="post">
              <input type="hidden" value="${nextAction}" name="nextAction"> 
              <button type="submit" class="btn btn-dark btn-block"> <c:out value="${nextAction}"/> </button>
               </form> 
               </div> 
               </div> 
               </div>


          
          <div class="col-md-9">

       

            <div class="row mb-3">
              <div class="col-md-4">
                <div class="card stat-card p-3 text-center">
                  <i class="fas fa-calendar-day fa-2x text-primary mb-2"></i>
                  <h6>Total Hours Today</h6>
                  <h4 class="fw-bold"><c:out value ="${todayWorkingHour }"/>/ 9</h4>
                  
                  
                </div>
              </div>
              <div class="col-md-4">
                <div class="card stat-card p-3 text-center">
                  <i class="fas fa-calendar-week fa-2x text-success mb-2"></i>
                  <h6>Total Hours Week</h6>
                  <h4 class="fw-bold"> <c:out value ="${weeklyWorkingHour}"/>/ 40</h4>
                 
                </div>
              </div>
              <div class="col-md-4">
                <div class="card stat-card p-3 text-center">
                  <i class="fas fa-calendar-alt fa-2x text-warning mb-2"></i>
                  <h6>Total Hours Month</h6>

                  <h4 class="fw-bold"><c:out value ="${monthlyWorkingHours}"/>/ <c:out value ="${standardHour}"/></h4>

                  
                </div>
              </div>
            </div>

          
            <div class="card mb-3 p-3">
              <div class="row text-center mb-3">
                <div class="col-md-4">
                  <strong>Total Working Hours</strong><br>09h 00m
                </div>
                <div class="col-md-4">
                  <strong>Productive Hours</strong><br><c:out value ="${todayWorkingHour }"/>
                </div>
                <div class="col-md-4">

                  <strong>Break Hours</strong><br><c:out value="${todayBreak} "/>

                </div>
              </div>
              <div class="progress">
                <div class="progress-bar bg-success" style="width:${productionPre}">Productive</div>
                
                <div class="progress-bar bg-warning" style="width:${breakPre}%">Break</div>
              </div>
            </div>

           
            <div class="card p-3">
	             <div class="d-flex justify-content-between align-items-center mb-2">
    <h5 class="mb-0">Timesheet</h5>

    <form action="sendToManagerServlet" method="post">
        <input type="hidden" name="userId" value="${userId}">
        <input type="hidden" name="workingHours" value="${todayWorkingHour}">
        <input type="hidden" name="date" value="${todayDate}">
        <button type="submit" class="btn btn-primary btn-sm approval-btn">
            <i class="fas fa-paper-plane"></i> Send to Manager
        </button>
    </form>

</div>
              <table class="table table-striped table-bordered" id="attendanceTable">
                <thead>
               <tr>
            <th>Date</th>
            <th>Punch In</th>
            <th>Lunch Out</th>
            <th>Lunch In</th>
            <th>Punch Out</th>


         
        </tr>
    </thead>
    <tbody>

      
            <tr>
                <td><c:out value="${todayAttendance.date}"/></td>
                <td><c:out value="${todayAttendance.check_in}"/></td>
                <td><c:out value="${todayAttendance.lunch_out}"/></td>
                <td><c:out value="${todayAttendance.lunch_in}"/></td>
                <td><c:out value="${todayAttendance.check_out}"/></td>
                
                
            </tr>
        

    </tbody>
              </table>
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
<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
<script src="dist/js/pages/dashboard.js"></script>
<script defer src="https://static.cloudflareinsights.com/beacon.min.js/vcd15cbe7772f49c399c6a5babf22c1241717689176015" integrity="sha512-ZpsOmlRQV6y907TI0dKBHq9Md29nnaEIPlkf84rnaERnq6zvWvPUqr2ft8M1aS28oN72PdrCzSjY4U6VaAw1EQ==" data-cf-beacon='{"rayId":"97edd8cbed143e57","version":"2025.8.0","serverTiming":{"name":{"cfExtPri":true,"cfEdge":true,"cfOrigin":true,"cfL4":true,"cfSpeedBrain":true,"cfCacheStatus":true}},"token":"2437d112162f4ec4b63c3ca0eb38fb20","b":1}' crossorigin="anonymous"></script>


<!-- DataTables  & Plugins -->
<script src="plugins/datatables/jquery.dataTables.min.js"></script>
<script src="plugins/datatables-bs4/js/dataTables.bootstrap4.min.js"></script>
<script src="plugins/datatables-responsive/js/dataTables.responsive.min.js"></script>
<script src="plugins/datatables-responsive/js/responsive.bootstrap4.min.js"></script>
<script src="plugins/datatables-buttons/js/dataTables.buttons.min.js"></script>
<script src="plugins/datatables-buttons/js/buttons.bootstrap4.min.js"></script>
<script src="plugins/jszip/jszip.min.js"></script>
<script src="plugins/pdfmake/pdfmake.min.js"></script>
<script src="plugins/pdfmake/vfs_fonts.js"></script>
<script src="plugins/datatables-buttons/js/buttons.html5.min.js"></script>
<script src="plugins/datatables-buttons/js/buttons.print.min.js"></script>
<script src="plugins/datatables-buttons/js/buttons.colVis.min.js"></script>


<!-- Page specific script -->
<script>
  $(function () {
    $("#attendanceTable").DataTable({
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
	
</body>
</html>