<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Uploaded Document List</title>
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

    <!-- Zaraz Script -->
    <script data-cfasync="false" nonce="06cb1374-3a81-4a88-aebe-16de25f6e552">
      try{(function(w,d){!function(j,k,l,m){if(j.zaraz)console.error("zaraz is loaded twice");else{j[l]=j[l]||{};j[l].executed=[];j.zaraz={deferred:[],listeners:[]};j.zaraz._v="5870";j.zaraz._n="06cb1374-3a81-4a88-aebe-16de25f6e552";j.zaraz.q=[];j.zaraz._f=function(n){return async function(){var o=Array.prototype.slice.call(arguments);j.zaraz.q.push({m:n,a:o})}};for(const p of["track","set","debug"])j.zaraz[p]=j.zaraz._f(p);j.zaraz.init=()=>{var q=k.getElementsByTagName(m)[0],r=k.createElement(m),s=k.getElementsByTagName("title")[0];s&&(j[l].t=k.getElementsByTagName("title")[0].text);j[l].x=Math.random();j[l].w=j.screen.width;j[l].h=j.screen.height;j[l].j=j.innerHeight;j[l].e=j.innerWidth;j[l].l=j.location.href;j[l].r=k.referrer;j[l].k=j.screen.colorDepth;j[l].n=k.characterSet;j[l].o=(new Date).getTimezoneOffset();if(j.dataLayer)for(const t of Object.entries(Object.entries(dataLayer).reduce((u,v)=>({...u[1],...v[1]}),{})))zaraz.set(t[0],t[1],{scope:"page"});j[l].q=[];for(;j.zaraz.q.length;){const w=j.zaraz.q.shift();j[l].q.push(w)}r.defer=!0;for(const x of[localStorage,sessionStorage])Object.keys(x||{}).filter(z=>z.startsWith("_zaraz_")).forEach(y=>{try{j[l]["z_"+y.slice(7)]=JSON.parse(x.getItem(y))}catch{j[l]["z_"+y.slice(7)]=x.getItem(y)}});r.referrerPolicy="origin";r.src="cdn-cgi/zaraz/sd0d9.js?z="+btoa(encodeURIComponent(JSON.stringify(j[l])));q.parentNode.insertBefore(r,q)};["complete","interactive"].includes(k.readyState)?zaraz.init():j.addEventListener("DOMContentLoaded",zaraz.init)}}(w,d,"zarazData","script");window.zaraz._p=async bs=>new Promise(bt=>{if(bs){bs.e&&bs.e.forEach(bu=>{try{const bv=d.querySelector("script[nonce]"),bw=bv?.nonce||bv?.getAttribute("nonce"),bx=d.createElement("script");bw&&(bx.nonce=bw);bx.innerHTML=bu;bx.onload=()=>{d.head.removeChild(bx)};d.head.appendChild(bx)}catch(by){console.error(`Error executing script: ${bu}\n`,by)}});Promise.allSettled((bs.f||[]).map(bz=>fetch(bz[0],bz[1])))}bt()});zaraz._p({"e":["(function(w,d){})(window,document)"]});})(window,document)}catch(e){throw fetch("/cdn-cgi/zaraz/t"),e;};
    </script>

    <style>
        body {
            background-color: #f7f9fc;
            font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
        }
        .card-white {
            background: #ffffff;
            border: 1px solid #e3e6f0;
            border-radius: 6px;
            padding: 1rem 1.5rem 2rem 1.5rem;
            box-shadow: 0 0.15rem 1.75rem rgba(58,59,69,0.1);
            margin-top: 15px;
        }
        .card-header-custom {
            font-weight: 600;
            font-size: 1.1rem;
            padding-bottom: 10px;
            border-bottom: 1px solid #dee2e6;
            margin-bottom: 1rem;
            color: #000;
        }
        .page-title {
            font-weight: 700;
            font-size: 1.6rem;
            margin-bottom: 10px;
            color: #212529;
        }
        table.dataTable thead th {
            background-color: #f8f9fc;
            font-weight: 600;
            border-bottom: 2px solid #dee2e6;
        }
        #docTable td, #docTable th {
            text-align: center;
            vertical-align: middle;
        }
        .breadcrumb {
            background: transparent;
            padding-left: 0;
            margin-bottom: 0px;
        }
        .breadcrumb-item + .breadcrumb-item::before {
            content: ">";
            color: #6c757d;
        }
        .dataTables_wrapper .dataTables_filter {
            float: right !important;
            text-align: right !important;
            margin-bottom: 10px;
        }
        .dataTables_wrapper .dataTables_paginate {
            float: right !important;
            margin-top: 10px;
        }
        .dataTables_wrapper .dataTables_length {
            float: left !important;
            margin-bottom: 10px;
        }
        
        .success-edit {
 display: none;
    background-color: #d4edda; /* light green */
    border-left: 6px solid #28a745; /* darker green accent */
    color: #155724;
    padding: 15px 20px;
    border-radius: 8px;
    margin: 15px 0;
    font-weight: 500;
    box-shadow: 0 3px 6px rgba(0,0,0,0.1);
    position: relative;
    animation: slideDown 0.5s ease;
}

/* Delete success - light red card */
.success-delete {
 display: none;
    background-color: #f8d7da; /* light red */
    border-left: 6px solid #dc3545; /* darker red accent */
    color: #721c24;
    padding: 15px 20px;
    border-radius: 8px;
    margin: 15px 0;
    font-weight: 500;
    box-shadow: 0 3px 6px rgba(0,0,0,0.1);
    position: relative;
    animation: slideDown 0.5s ease;
}

/* Slide down animation */
@keyframes slideDown {
    0% { opacity: 0; transform: translateY(-20px); }
    100% { opacity: 1; transform: translateY(0); }
}

/* Optional fade-out animation */
.fadeOut {
    animation: fadeOutAnim 0.5s forwards;
}

@keyframes fadeOutAnim {
    from { opacity: 1; }
    to { opacity: 0; }
}
        
    </style>
</head>
<body class="hold-transition sidebar-mini layout-fixed">
<div class="wrapper">

    <!-- Navbar -->
    <jsp:include page="/navbar.jsp" />

    <!-- Sidebar -->
    <jsp:include page="/sidebar.jsp" />

    <!-- Content Wrapper -->
    <div class="content-wrapper">

        <!-- Content Header -->
        <section class="content-header">
            <div class="container-fluid">
                <nav aria-label="breadcrumb" style="padding-left: 0;">
                    <h1 class="page-title">Uploaded Document List</h1>
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="#">Admin</a></li>
                        <li class="breadcrumb-item active" aria-current="page">Employee Uploaded Document List</li>
                    </ol>
                </nav>
            </div>
        </section>

        <!-- Main content -->
        <section class="content">
            <div>
                <div class="card-white">
                    <div class="card-header-custom">
                        Uploaded Employee Documents
                    </div>
                       <div id="deleteMessage" class="success-msg success-delete">Deleted Successfully!</div>

                    <table id="docTable" class="table table-striped table-bordered" style="width:100%">
                        <thead>
                        <tr>
                            <th>Upload ID</th>
                            <th>Document Name</th>
                            <th>User Name</th>
                            <th>Action</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="li" items="${employeeList}">
                            <tr id="row-${li.uploadId}">
                                <td>${li.uploadId}</td>
                                <td>${li.documentName}</td>
                                <td>${li.username}</td>
                                    <td class="action-icons">
                                    <a href="viewEmployeeDoc?uploadId=${li.uploadId}" target="_blank">
                                        <button class="btn btn-sm btn-info">
                                            <i class="fas fa-eye"></i> View
                                        </button>
                                    </a>
                                    <a href="downloadEmployeeDoc?uploadId=${li.uploadId}">
                                        <button class="btn btn-sm btn-success">
                                            <i class="fas fa-download"></i> Download
                                        </button>
                                    </a>
                                    <button class="btn btn-sm btn-danger" onclick="deletedocument(${li.uploadId})">
                                        <i class="fas fa-trash"></i> Delete
                                    </button>
                                </td>
                             
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </section>
    </div>

    <!-- Footer -->
    <jsp:include page="/footer.jsp" />

</div>

<!-- Scripts -->
<script src="plugins/jquery/jquery.min.js"></script>
<script src="plugins/jquery-ui/jquery-ui.min.js"></script>
<script> $.widget.bridge('uibutton', $.ui.button) </script>
<script src="plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="plugins/chart.js/Chart.min.js"></script>
<script src="plugins/sparklines/sparkline.js"></script>
<script src="plugins/jqvmap/jquery.vmap.min.js"></script>
<script src="plugins/jqvmap/maps/jquery.vmap.usa.js"></script>
<script src="plugins/jquery-knob/jquery.knob.min.js"></script>
<script src="plugins/moment/moment.min.js"></script>
<script src="plugins/daterangepicker/daterangepicker.js"></script>
<script src="plugins/tempusdominus-bootstrap-4/js/tempusdominus-bootstrap-4.min.js"></script>
<script src="plugins/summernote/summernote-bs4.min.js"></script>
<script src="plugins/overlayScrollbars/js/jquery.overlayScrollbars.min.js"></script>
<script src="dist/js/adminlte2167.js?v=3.2.0"></script>
<script src="dist/js/demo.js"></script>
<script src="dist/js/pages/dashboard.js"></script>
<script defer src="https://static.cloudflareinsights.com/beacon.min.js/vcd15cbe7772f49c399c6a5babf22c1241717689176015" crossorigin="anonymous"></script>

<!-- DataTables -->
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

<script>
  $(function () {
    $("#example1").DataTable({
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

  $(document).ready(function () {
    $('#docTable').DataTable({
      "pageLength": 5,
      "lengthChange": true,
      "searching": true,
      "ordering": true,
      "info": true,
      "autoWidth": false,
      "language": {
        "lengthMenu": "Show _MENU_ entries",
        "search": "Search:"
      }
    });
  });


  function deletedocument(id) {
      if(confirm("Are you sure you want to delete Uplaod ID " + id + "?")) {
          $.ajax({
              url: '<c:url value="/deleteuploadedEmployee"/>',
              type: 'POST',
              data: { uploadId: id },
              success: function(response) {
                  $('#docTable').DataTable().row($('#row-' + id)).remove().draw();

                  // Show success delete message
                  var msg = document.getElementById("deleteMessage");
                  msg.style.display = "block";
                  setTimeout(function() { msg.style.display = "none"; }, 10000);
              },
              error: function() {
                  alert("Delete failed!");
              }
          });
      }
  }
</script>
</body>
</html>
