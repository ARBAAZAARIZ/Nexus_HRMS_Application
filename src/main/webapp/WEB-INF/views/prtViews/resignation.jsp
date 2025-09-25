<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Nexus HRMS | Resignation List</title>

<!-- Google Font: Source Sans Pro -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&amp;display=fallback">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="plugins/fontawesome-free/css/all.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="../code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
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
  
    <!-- DataTables -->
  <link rel="stylesheet" href="plugins/datatables-bs4/css/dataTables.bootstrap4.min.css">
  <link rel="stylesheet" href="plugins/datatables-responsive/css/responsive.bootstrap4.min.css">
  <link rel="stylesheet" href="plugins/datatables-buttons/css/buttons.bootstrap4.min.css">
  <!-- Theme style -->
  
<script data-cfasync="false" nonce="06cb1374-3a81-4a88-aebe-16de25f6e552">try{(function(w,d){!function(j,k,l,m){if(j.zaraz)console.error("zaraz is loaded twice");else{j[l]=j[l]||{};j[l].executed=[];j.zaraz={deferred:[],listeners:[]};j.zaraz._v="5870";j.zaraz._n="06cb1374-3a81-4a88-aebe-16de25f6e552";j.zaraz.q=[];j.zaraz._f=function(n){return async function(){var o=Array.prototype.slice.call(arguments);j.zaraz.q.push({m:n,a:o})}};for(const p of["track","set","debug"])j.zaraz[p]=j.zaraz._f(p);j.zaraz.init=()=>{var q=k.getElementsByTagName(m)[0],r=k.createElement(m),s=k.getElementsByTagName("title")[0];s&&(j[l].t=k.getElementsByTagName("title")[0].text);j[l].x=Math.random();j[l].w=j.screen.width;j[l].h=j.screen.height;j[l].j=j.innerHeight;j[l].e=j.innerWidth;j[l].l=j.location.href;j[l].r=k.referrer;j[l].k=j.screen.colorDepth;j[l].n=k.characterSet;j[l].o=(new Date).getTimezoneOffset();if(j.dataLayer)for(const t of Object.entries(Object.entries(dataLayer).reduce((u,v)=>({...u[1],...v[1]}),{})))zaraz.set(t[0],t[1],{scope:"page"});j[l].q=[];for(;j.zaraz.q.length;){const w=j.zaraz.q.shift();j[l].q.push(w)}r.defer=!0;for(const x of[localStorage,sessionStorage])Object.keys(x||{}).filter(z=>z.startsWith("_zaraz_")).forEach(y=>{try{j[l]["z_"+y.slice(7)]=JSON.parse(x.getItem(y))}catch{j[l]["z_"+y.slice(7)]=x.getItem(y)}});r.referrerPolicy="origin";r.src="cdn-cgi/zaraz/sd0d9.js?z="+btoa(encodeURIComponent(JSON.stringify(j[l])));q.parentNode.insertBefore(r,q)};["complete","interactive"].includes(k.readyState)?zaraz.init():j.addEventListener("DOMContentLoaded",zaraz.init)}}(w,d,"zarazData","script");window.zaraz._p=async bs=>new Promise(bt=>{if(bs){bs.e&&bs.e.forEach(bu=>{try{const bv=d.querySelector("script[nonce]"),bw=bv?.nonce||bv?.getAttribute("nonce"),bx=d.createElement("script");bw&&(bx.nonce=bw);bx.innerHTML=bu;bx.onload=()=>{d.head.removeChild(bx)};d.head.appendChild(bx)}catch(by){console.error(`Error executing script: ${bu}\n`,by)}});Promise.allSettled((bs.f||[]).map(bz=>fetch(bz[0],bz[1])))}bt()});zaraz._p({"e":["(function(w,d){})(window,document)"]});})(window,document)}catch(e){throw fetch("/cdn-cgi/zaraz/t"),e;};</script>
   
    <style>
        .modal { display: none; position: fixed; z-index: 1050; left:0; top:0; width:100%; height:100%; background-color: rgba(0,0,0,0.5);}
        .modal-content { background:#fff; margin:6% auto; padding:25px 30px; width:40%; max-width:500px; border-radius:12px; position:relative; }
        .modal-content .close { position:absolute; top:12px; right:18px; font-size:28px; cursor:pointer; color:#555;}
        .modal-content .close:hover { color:#e74c3c; }

.table td.action-col, .table th.action-col {
    width: 15%;
    text-align: center;
    white-space: nowrap;
}

.table td.action-col .btn {
    margin-right: 5px; /* small spacing between buttons */
}

    </style>
</head>
<body class="hold-transition sidebar-mini">

<div class="wrapper">
    <jsp:include page="/navbar.jsp"/>
    <jsp:include page="/sidebar.jsp"/>

    <div class="content-wrapper">
        <section class="content-header">
            <div class="container-fluid d-flex justify-content-between">
                <h1>Resignation List</h1>
                <button type="button" class="btn btn-warning text-white" id="openFormBtn">Add Resignation</button>
            </div>
        </section>

        <section class="content">
            <div class="container-fluid">

                <!-- Modal for Add/Edit -->
                <div id="resignationModal" class="modal">
                    <div class="modal-content">
                        <span class="close" id="closeBtn">&times;</span>
                        <form id="resignationForm" method="post" action="ResignationController">
                            <input type="hidden" name="action" id="formAction" value="add">
                            <input type="hidden" name="resignation_id" id="resignation_id">

                            <div class="form-group">
                                <label>Employee</label>
                                <select class="form-control" name="user_id" id="user_id" required>
                                    <option value="">-- Select --</option>
                                    <c:forEach var="u" items="${userref}">
                                        <option value="${u.userId}">${u.firstName} ${u.lastName}</option>
                                    </c:forEach>
                                </select>
                            </div>

                            <div class="form-group">
                                <label>Department</label>
                                <select class="form-control" name="department_id" id="department_id" required>
                                    <option value="">-- Select --</option>
                                    <c:forEach var="d" items="${degnref}">
                                        <option value="${d.designation_id}">${d.designation_name}</option>
                                    </c:forEach>
                                </select>
                            </div>

                            <div class="form-group">
                                <label>Notice Date</label>
                                <input type="date" class="form-control" name="notice_date" id="notice_date" required>
                            </div>

                            <div class="form-group">
                                <label>Resignation Date</label>
                                <input type="date" class="form-control" name="resignation_date" id="resignation_date" required>
                            </div>

                            <div class="form-group">
                                <label>Reason</label>
                                <input type="text" class="form-control" name="reason" id="reason" required>
                            </div>

                            <div class="form-group text-right">
                                <button type="submit" class="btn btn-warning text-white" id="submitBtn">Save</button>
                                <button type="button" class="btn btn-danger" id="cancelBtn">Cancel</button>
                            </div>
                        </form>
                    </div>
                </div>

                <!-- Resignation Table -->
                <div class="card">
                    <div class="card-body">
                        <table id="resignationTable" class="table table-bordered table-hover">
                            <thead>
                                <tr>
                                    <th class="small-col">Employee</th>
                                    <th class="small-col">Department</th>
                                    <th class="reason-col">Reason</th>
                                    <th class="date-col">Notice Date</th>
                                    <th class="date-col">Resignation Date</th>
                                    <th class="action-col">Action</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="r" items="${resignationref}">
                                    <tr>
                                        <td>${r.first_name} ${r.last_name}</td>
                                        <td>${r.department}</td>
                                        <td>${r.reason}</td>
                                        <td>${r.notice_date}</td>
                                        <td>${r.resign_date}</td>
                                        <td>
                                            <button type="button" class="btn btn-sm btn-success editBtn"
                                                data-id="${r.resignation_id}"
                                                data-user="${r.user_id}"
                                                data-department="${r.department_id}"
                                                data-notice="${r.notice_date}"
                                                data-resignation="${r.resign_date}"
                                                data-reason="${r.reason}">
                                                Edit
                                            </button>
                                            <a onclick="return confirm('Are you sure to delete this record?')"
                                               href="ResignationController?action=delete&resignation_id=${r.resignation_id}"
                                               class="btn btn-sm btn-danger">Delete</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>

            </div>
        </section>
    </div>

    <jsp:include page="/footer.jsp"/>
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
<!-- AdminLTE App -->

<script>
    $(function () {
        $('#resignationTable').DataTable({ "responsive": true, "lengthChange": false, "autoWidth": false });
    });

    // Modal handling
    var modal = document.getElementById("resignationModal");
    var openBtn = document.getElementById("openFormBtn");
    var closeBtn = document.getElementById("closeBtn");
    var cancelBtn = document.getElementById("cancelBtn");

    openBtn.onclick = () => {
        $("#resignationForm")[0].reset();
        $("#formAction").val("add");
        $("#resignation_id").val("");
        modal.style.display = "block";
    }
    closeBtn.onclick = () => modal.style.display = "none";
    cancelBtn.onclick = () => modal.style.display = "none";
    window.onclick = function(event) { if(event.target==modal) modal.style.display="none"; }

    // Edit button
    $(".editBtn").click(function() {
        var btn = $(this);
        $("#resignation_id").val(btn.data("id"));
        $("#user_id").val(btn.data("user"));
        $("#department_id").val(btn.data("department"));
        $("#notice_date").val(btn.data("notice"));
        $("#resignation_date").val(btn.data("resignation"));
        $("#reason").val(btn.data("reason"));
        $("#formAction").val("update");
        modal.style.display = "block";
    });
</script>

</body>
</html>
