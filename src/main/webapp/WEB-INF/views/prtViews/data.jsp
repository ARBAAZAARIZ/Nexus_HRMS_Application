<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Nexus HRMS | Promotion List</title>

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
     /* Modal Styling */
     #promotionModal, #editPromotionModal {
        display: none;
        position: fixed;
        z-index: 1050;
        left: 0;
        top: 0;
        width: 100%;
        height: 100%;
        overflow: auto;
        background-color: rgba(0,0,0,0.5);
     }
     .modal-content {
        background: #ffffff;
        margin: 6% auto;
        padding: 25px 30px;
        width: 40%;
        max-width: 500px;
        border-radius: 12px;
        box-shadow: 0 8px 25px rgba(0,0,0,0.3);
        animation: scaleIn 0.3s ease-in-out;
        position: relative;
     }
     @keyframes scaleIn {
        from { transform: scale(0.85); opacity: 0; }
        to { transform: scale(1); opacity: 1; }
     }
     .modal-content .close {
        position: absolute;
        top: 12px;
        right: 18px;
        font-size: 28px;
        font-weight: bold;
        color: #555;
        cursor: pointer;
     }
     .modal-content .close:hover { color: #e74c3c; }
  </style>
</head>
<body class="hold-transition sidebar-mini">
<div class="wrapper">

    <jsp:include page="/navbar.jsp" />
    <jsp:include page="/sidebar.jsp" />

  <div class="content-wrapper">
    <section class="content-header">
      <div class="container-fluid d-flex justify-content-between">
        <h1>Promotion List</h1>
        <button type="button" class="btn btn-warning text-white" id="openFormBtn">Add Promotion</button>
      </div>
    </section>

    <section class="content">
      <div class="container-fluid">

        <!-- Add Modal -->
        <div id="promotionModal" class="modal">
          <div class="modal-content">
            <span class="close" id="closeBtn">&times;</span>
            <form action="PromotionController?action=add" method="post">
              <div class="form-group">
                <label>Promotion For</label>
                <select class="form-control" name="user_id" required>
                  <option value="">-- Select --</option>
                  <c:forEach var="u" items="${userref}">
                    <option value="${u.userId}">${u.firstName} ${u.lastName}</option>
                  </c:forEach>
                </select>
              </div>
              <div class="form-group">
                <label>Promotion From</label>
                <select class="form-control" name="designation_from" required>
                  <option value="">-- Select --</option>
                  <c:forEach var="d" items="${degnref}">
                    <option value="${d.designation_name}">${d.designation_name}</option>
                  </c:forEach>
                </select>
              </div>
              <div class="form-group">
                <label>Promotion To</label>
                <select class="form-control" name="designation_to" required>
                  <option value="">-- Select --</option>
                  <c:forEach var="d" items="${degnref}">
                    <option value="${d.designation_name}">${d.designation_name}</option>
                  </c:forEach>
                </select>
              </div>
              <div class="form-group">
                <label>Promotion Date</label>
                <input type="date" class="form-control" name="promotion_date" required />
              </div>
              <div class="form-group text-right">
                <button type="submit" class="btn btn-warning text-white">Add Promotion</button>
                <button type="button" class="btn btn-danger" id="cancelBtn">Cancel</button>
              </div>
            </form>
          </div>
        </div>

        <!-- Edit Modal -->
        <div id="editPromotionModal" class="modal">
          <div class="modal-content">
            <span class="close" id="editCloseBtn">&times;</span>
            <form action="PromotionController?action=update" method="post">
              <input type="hidden" name="promotion_id" id="edit_promotion_id" />
              <div class="form-group">
                <label>Promotion For</label>
                <select class="form-control" name="user_id" id="edit_user_id" required>
                  <option value="">-- Select --</option>
                  <c:forEach var="u" items="${userref}">
                    <option value="${u.userId}">${u.firstName} ${u.lastName}</option>
                  </c:forEach>
                </select>
              </div>
              <div class="form-group">
                <label>Promotion From</label>
                <select class="form-control" name="designation_from" id="edit_designation_from" required>
                  <option value="">-- Select --</option>
                  <c:forEach var="d" items="${degnref}">
                    <option value="${d.designation_name}">${d.designation_name}</option>
                  </c:forEach>
                </select>
              </div>
              <div class="form-group">
                <label>Promotion To</label>
                <select class="form-control" name="designation_to" id="edit_designation_to" required>
                  <option value="">-- Select --</option>
                  <c:forEach var="d" items="${degnref}">
                    <option value="${d.designation_name}">${d.designation_name}</option>
                  </c:forEach>
                </select>
              </div>
              <div class="form-group">
                <label>Promotion Date</label>
                <input type="date" class="form-control" name="promotion_date" id="edit_promotion_date" required />
              </div>
              <div class="form-group text-right">
                <button type="submit" class="btn btn-success">Update Promotion</button>
                <button type="button" class="btn btn-danger" id="editCancelBtn">Cancel</button>
              </div>
            </form>
          </div>
        </div>

        <!-- Promotion Table -->
        <div class="card">
          <div class="card-body">
            <table id="promotionTable" class="table table-bordered table-hover">
              <thead>
                <tr>
                  <th>Employee</th>
                  <th>Designation From</th>
                  <th>Designation To</th>
                  <th>Promotion Date</th>
                  <th>Action</th>
                </tr>
              </thead>
              <tbody>
                <c:forEach var="e" items="${promoref}">
                  <tr>
                    <td>${e.first_name} ${e.last_name}</td>
                    <td>${e.designation_from}</td>
                    <td>${e.designation_to}</td>
                    <td>${e.promotion_date}</td>
                    <td>
                      <button type="button" 
                        class="btn btn-sm btn-success editBtn"
                        data-id="${e.promotion_id}"
                        data-user="${e.user_id}"
                        data-from="${e.designation_from}"
                        data-to="${e.designation_to}"
                        data-date="${e.promotion_date}">
                        Edit
                      </button>
                      <a onclick="return confirm('Are you sure to delete this record?')" 
                         href="PromotionController?action=delete&promotion_id=${e.promotion_id}" 
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

  <jsp:include page="/footer.jsp" />
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
    $('#promotionTable').DataTable({
      "responsive": true,
      "lengthChange": false,
      "autoWidth": false,
      "ordering": true,
      "paging": true,
      "info": true
    });
  });

  // Add Modal
  var modal = document.getElementById("promotionModal");
  var openBtn = document.getElementById("openFormBtn");
  var closeBtn = document.getElementById("closeBtn");
  var cancelBtn = document.getElementById("cancelBtn");

  openBtn.onclick = () => modal.style.display = "block";
  closeBtn.onclick = () => modal.style.display = "none";
  cancelBtn.onclick = () => modal.style.display = "none";

  // Edit Modal
  var editModal = document.getElementById("editPromotionModal");
  var editCloseBtn = document.getElementById("editCloseBtn");
  var editCancelBtn = document.getElementById("editCancelBtn");

  document.querySelectorAll(".editBtn").forEach(btn => {
    btn.addEventListener("click", function() {
      document.getElementById("edit_promotion_id").value = this.dataset.id;
      document.getElementById("edit_user_id").value = this.dataset.user;
      document.getElementById("edit_designation_from").value = this.dataset.from;
      document.getElementById("edit_designation_to").value = this.dataset.to;
      document.getElementById("edit_promotion_date").value = this.dataset.date;
      editModal.style.display = "block";
    });
  });

  editCloseBtn.onclick = () => editModal.style.display = "none";
  editCancelBtn.onclick = () => editModal.style.display = "none";

  window.onclick = function(event) {
    if (event.target == modal) modal.style.display = "none";
    if (event.target == editModal) editModal.style.display = "none";
  }
</script>
</body>
</html>
