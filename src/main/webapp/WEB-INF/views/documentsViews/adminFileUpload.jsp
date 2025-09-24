<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Admin FileUpload</title>
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
        body { background-color: #f8f9fc; font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif; min-height:100vh; margin:0; }
        .upload-form { background: white; border-radius: 8px; padding: 0; margin-top: 20px; }
        .form-header { font-weight: 600; padding: 15px 20px; border-bottom: 1px solid #dee2e6; }
        .form-body { padding: 20px 30px 30px 30px; }
        .form-group { margin-bottom: 16px; }
        .form-row-wrap { display:flex; align-items:center; gap:10px; flex-wrap:nowrap; justify-content:flex-start; margin-bottom:10px; }
        .form-row-wrap select[name="documentName"] { width:40%; min-width:180px; }
        .form-row-wrap input[type="file"] { width:40%; min-width:200px; }
        .btn-icon { width:36px; height:36px; display:flex; align-items:center; justify-content:center; padding:0; font-size:14px; border-radius:6px; }
        .btn-orange { background-color:#fd7e14; border-color:#fd7e14; color:white; }
        .btn-orange:hover { background-color:#e66900; border-color:#e66900; }
        .btn-delete { background-color:#dee2e6; color:#495057; }
        .btn-delete:hover { background-color:#ced4da; color:#212529; }
        .btn-save { font-weight:600; font-size:1rem; padding:6px 18px; }
        .success-msg { background-color: #d4edda; color: #155724; padding: 10px 15px; border-radius: 5px; margin-bottom: 10px; display:none; }
    </style>
</head>
<body class="hold-transition sidebar-mini layout-fixed">
<div class="wrapper">

    <jsp:include page="/navbar.jsp" />
    <jsp:include page="/sidebar.jsp" />

    <div class="content-wrapper">
        <section class="content-header">
            <div class="container-fluid">
                <h1 class="page-title">Admin FileUpload</h1>
            </div>
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="admin.jsp">Admin</a></li>
                <li class="breadcrumb-item active">Admin FileUpload</li>
            </ol>
        </section>

        <section class="content">
            <div class="container-fluid">
                <div class="upload-form">
                    <div class="form-header">Add FileUpload</div>
                    <div class="form-body">
                        <div id="successMessage" class="success-msg">Added successfully!</div>
                        <form method="post" action="UploadDocumentsAdmin" enctype="multipart/form-data">

                            <!-- Email Field -->
                            <div class="form-group">
                                <label for="userEmail">User</label>
                                <select class="form-control" id="userEmail" name="userEmail">
                                    <option value="">-- Select User --</option>
                                    <c:forEach var="email" items="${emails}">
                                        <option value="${email}">${email}</option>
                                    </c:forEach>
                                </select>
                            </div>

                            <!-- Dynamic File Upload Rows -->
                            <div class="form-group" id="fileUploadContainer">
                                <div class="form-row-wrap">
                                    <select class="form-control" name="documentName" required>
                                        <option value="">-- Select Document --</option>
                                        <c:forEach var="docname" items="${doc}">
                                            <option value="${docname.documentName}">${docname.documentName}</option>
                                        </c:forEach>
                                    </select>
                                    <input type="file" class="form-control" name="uploadFile" required>
                                    <button type="button" class="btn btn-orange btn-icon" title="Add" onclick="addRow(this)">
                                        <i class="fas fa-plus"></i>
                                    </button>
                                    <button type="button" class="btn btn-delete btn-icon" title="Delete" onclick="deleteRow(this)">
                                        <i class="fas fa-trash"></i>
                                    </button>
                                </div>
                            </div>

                            <button type="submit" class="btn btn-orange btn-save">Save</button>
                        </form>
                    </div>
                </div>
            </div>
        </section>
    </div>

    <jsp:include page="/footer.jsp" />
</div>

<!-- Scripts unchanged -->
<script src="plugins/jquery/jquery.min.js"></script>
<script src="plugins/jquery-ui/jquery-ui.min.js"></script>
<script>$.widget.bridge('uibutton', $.ui.button)</script>
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
function addRow(button) {
    let row = button.closest('.form-row-wrap');
    let clone = row.cloneNode(true);
    clone.querySelector('select').selectedIndex = 0;
    clone.querySelector('input[type="file"]').value = "";
    document.getElementById("fileUploadContainer").appendChild(clone);
}
function deleteRow(button) {
    let container = document.getElementById("fileUploadContainer");
    let row = button.closest('.form-row-wrap');
    if (container.querySelectorAll('.form-row-wrap').length > 1) row.remove();
    else alert("At least one row must remain!");
}

// Show success message if redirected after save
window.onload = function() {
    if (window.location.search.indexOf('success') > -1) {
        document.getElementById('successMessage').style.display = 'block';
        setTimeout(()=>{document.getElementById('successMessage').style.display='none';}, 3000);
    }
}
</script>

</body>
</html>
