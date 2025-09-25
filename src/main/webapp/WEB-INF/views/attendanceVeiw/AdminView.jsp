<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>AdminLTE 3 | Dashboard</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-multiselect@1.1.0/dist/css/bootstrap-multiselect.css">

<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&amp;display=fallback">
<link rel="stylesheet" href="plugins/fontawesome-free/css/all.min.css">
<link rel="stylesheet"
	href="../code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
<link rel="stylesheet"
	href="plugins/tempusdominus-bootstrap-4/css/tempusdominus-bootstrap-4.min.css">
<link rel="stylesheet"
	href="plugins/icheck-bootstrap/icheck-bootstrap.min.css">
<link rel="stylesheet" href="plugins/jqvmap/jqvmap.min.css">
<link rel="stylesheet" href="dist/css/adminlte.min2167.css?v=3.2.0">
<link rel="stylesheet"
	href="plugins/overlayScrollbars/css/OverlayScrollbars.min.css">
<link rel="stylesheet"
	href="plugins/daterangepicker/daterangepicker.css">
<link rel="stylesheet" href="plugins/summernote/summernote-bs4.min.css">

<link rel="stylesheet"
	href="plugins/datatables-bs4/css/dataTables.bootstrap4.min.css">
<link rel="stylesheet"
	href="plugins/datatables-responsive/css/responsive.bootstrap4.min.css">
<link rel="stylesheet"
	href="plugins/datatables-buttons/css/buttons.bootstrap4.min.css">
<script data-cfasync="false"
	nonce="06cb1374-3a81-4a88-aebe-16de25f6e552">try{(function(w,d){!function(j,k,l,m){if(j.zaraz)console.error("zaraz is loaded twice");else{j[l]=j[l]||{};j[l].executed=[];j.zaraz={deferred:[],listeners:[]};j.zaraz._v="5870";j.zaraz._n="06cb1374-3a81-4a88-aebe-16de25f6e552";j.zaraz.q=[];j.zaraz._f=function(n){return async function(){var o=Array.prototype.slice.call(arguments);j.zaraz.q.push({m:n,a:o})}};for(const p of["track","set","debug"])j.zaraz[p]=j.zaraz._f(p);j.zaraz.init=()=>{var q=k.getElementsByTagName(m)[0],r=k.createElement(m),s=k.getElementsByTagName("title")[0];s&&(j[l].t=k.getElementsByTagName("title")[0].text);j[l].x=Math.random();j[l].w=j.screen.width;j[l].h=j.screen.height;j[l].j=j.innerHeight;j[l].e=j.innerWidth;j[l].l=j.location.href;j[l].r=k.referrer;j[l].k=j.screen.colorDepth;j[l].n=k.characterSet;j[l].o=(new Date).getTimezoneOffset();if(j.dataLayer)for(const t of Object.entries(Object.entries(dataLayer).reduce((u,v)=>({...u[1],...v[1]}),{})))zaraz.set(t[0],t[1],{scope:"page"});j[l].q=[];for(;j.zaraz.q.length;){const w=j.zaraz.q.shift();j[l].q.push(w)}r.defer=!0;for(const x of[localStorage,sessionStorage])Object.keys(x||{}).filter(z=>z.startsWith("_zaraz_")).forEach(y=>{try{j[l]["z_"+y.slice(7)]=JSON.parse(x.getItem(y))}catch{j[l]["z_"+y.slice(7)]=x.getItem(y)}});r.referrerPolicy="origin";r.src="cdn-cgi/zaraz/sd0d9.js?z="+btoa(encodeURIComponent(JSON.stringify(j[l])));q.parentNode.insertBefore(r,q)};["complete","interactive"].includes(k.readyState)?zaraz.init():j.addEventListener("DOMContentLoaded",zaraz.init)}}(w,d,"zarazData","script");window.zaraz._p=async bs=>new Promise(bt=>{if(bs){bs.e&&bs.e.forEach(bu=>{try{const bv=d.querySelector("script[nonce]"),bw=bv?.nonce||bv?.getAttribute("nonce"),bx=d.createElement("script");bw&&(bx.nonce=bw);bx.innerHTML=bu;bx.onload=()=>{d.head.removeChild(bx)};d.head.appendChild(bx)}catch(by){console.error(`Error executing script: ${bu}\n`,by)}});Promise.allSettled((bs.f||[]).map(bz=>fetch(bz[0],bz[1])))}bt()});zaraz._p({"e":["(function(w,d){})(window,document)"]});})(window,document)}catch(e){throw fetch("/cdn-cgi/zaraz/t"),e;};</script>
</head>
<body class="hold-transition sidebar-mini layout-fixed">

	<jsp:include page="../../../navbar.jsp"></jsp:include>

	<jsp:include page="../../../sidebar.jsp"></jsp:include>

	<div class="wrapper">
		<div class="content-wrapper">
			<div class="content-header">
				<div class="container-fluid">
					<div class="row mb-2">
						<div class="col-sm-6">
							<h1 class="m-0">Timesheet</h1>
						</div>
						<div class="col-sm-6">
							<ol class="breadcrumb float-sm-right">
								<li class="breadcrumb-item"><a href="#">Attendance</a></li>
								<li class="breadcrumb-item active">Timesheet</li>
							</ol>
						</div>
					</div>
				</div>
			</div>

			<section class="content">
				<div class="container-fluid">
					<div class="card">
						<div class="card-header">
							<h3 class="card-title">Timesheet</h3>



							<div class="d-flex justify-content-end align-items-center">
								<div class="d-flex align-items-center">
									
										<label for="sort-by">Sort By:</label> <select id="sort-by"
											class="form-control d-inline-block w-auto">
											<option value="none">Default</option>
											<option value="name_asc">Ascending</option>
											<option value="name_desc">Descending</option>
											<option value="end_date_desc">Recently Added</option>
											<option value="end_date_asc">Oldest</option>
										</select>
									</div>
								</div>

							</div>

							
							<div class="card-body">
								
		<form action="managerTimeSheetServlet" method="post">
    <div class="d-flex justify-content-end align-items-center">
        <button type="submit" name="action" value="Approved" class="btn btn-success ml-2">Approve</button>
        <button type="submit" name="action" value="Rejected" class="btn btn-danger ml-2">Reject</button>
    </div>

    <table id="example1" class="table table-bordered table-striped">
        <thead>
            <tr>
                <th><input type="checkbox" id="selectAll"></th>
                <th>Employee</th>
                <th>Created At</th>
              <!--   <th>Project</th> -->
                <th>Worked Hours</th>
                <th>Status</th>
              <th>Approved At </th> 
            </tr>
        </thead>
        <tbody>
            <c:forEach var="t" items="${timesheets}">
                <tr>
                    <td><input type="checkbox" name="selectedIds" value="${t.time_sheet_id}"></td>
                    <td>${t.username}</td>
                    <td>${t.date}</td>
                   <%--  <td>${t.projectName}</td> --%>
                    <td>${t.working_hours}</td>
                    <td>
                        <span class="badge 
                            ${t.status eq 'Approved' ? 'bg-success' : 
                              t.status eq 'Pending' ? 'bg-warning text-dark' : 'bg-secondary'}">
                            ${t.status}
                        </span>
                    </td>
                    <td>${t.approved_at}</td>                
                </tr>
            </c:forEach>
        </tbody>
    </table>
</form>

									</div>		
									
							</div>
						</div>
					</div>
			</section>
		</div>
	</div>

	<jsp:include page="../../../footer.jsp"></jsp:include>


	<script src="plugins/jquery/jquery.min.js"></script>
	<script src="plugins/jquery-ui/jquery-ui.min.js"></script>
	<script>
		$.widget.bridge('uibutton', $.ui.button)
	</script>
	<script src="plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="plugins/chart.js/Chart.min.js"></script>
	<script src="plugins/sparklines/sparkline.js"></script>
	<script src="plugins/jqvmap/jquery.vmap.min.js"></script>
	<script src="plugins/jqvmap/maps/jquery.vmap.usa.js"></script>
	<script src="plugins/jquery-knob/jquery.knob.min.js"></script>
	<script src="plugins/moment/moment.min.js"></script>
	<script src="plugins/daterangepicker/daterangepicker.js"></script>
	<script
		src="plugins/tempusdominus-bootstrap-4/js/tempusdominus-bootstrap-4.min.js"></script>
	<script src="plugins/summernote/summernote-bs4.min.js"></script>
	<script
		src="plugins/overlayScrollbars/js/jquery.overlayScrollbars.min.js"></script>
	<script src="dist/js/adminlte2167.js?v=3.2.0"></script>
	<script src="dist/js/demo.js"></script>
	<script src="dist/js/pages/dashboard.js"></script>
	<script defer
		src="https://static.cloudflareinsights.com/beacon.min.js/vcd15cbe7772f49c399c6a5babf22c1241717689176015"
		integrity="sha512-ZpsOmlRQV6y907TI0dKBHq9Md29nnaEIPlkf84rnaERnq6zvWvPUqr2ft8M1aS28oN72PdrCzSjY4U6VaAw1EQ=="
		data-cf-beacon='{"rayId":"97edd8cbed143e57","version":"2025.8.0","serverTiming":{"name":{"cfExtPri":true,"cfEdge":true,"cfOrigin":true,"cfL4":true,"cfSpeedBrain":true,"cfCacheStatus":true}},"token":"2437d112162f4ec4b63c3ca0eb38fb20","b":1}'
		crossorigin="anonymous"></script>


	<script src="plugins/datatables/jquery.dataTables.min.js"></script>
	<script src="plugins/datatables-bs4/js/dataTables.bootstrap4.min.js"></script>
	<script
		src="plugins/datatables-responsive/js/dataTables.responsive.min.js"></script>
	<script
		src="plugins/datatables-responsive/js/responsive.bootstrap4.min.js"></script>
	<script src="plugins/datatables-buttons/js/dataTables.buttons.min.js"></script>
	<script src="plugins/datatables-buttons/js/buttons.bootstrap4.min.js"></script>
	<script src="plugins/jszip/jszip.min.js"></script>
	<script src="plugins/pdfmake/pdfmake.min.js"></script>
	<script src="plugins/pdfmake/vfs_fonts.js"></script>
	<script src="plugins/datatables-buttons/js/buttons.html5.min.js"></script>
	<script src="plugins/datatables-buttons/js/buttons.print.min.js"></script>
	<script src="plugins/datatables-buttons/js/buttons.colVis.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap-multiselect@1.1.0/dist/js/bootstrap-multiselect.min.js"></script>

	<script>
	   document.getElementById('selectAll').addEventListener('click', function () {
	        const checkboxes = document.querySelectorAll('input[name="selectedIds"]');
	        checkboxes.forEach(cb => cb.checked = this.checked);
	    });
    $(function() {
       
        $("#example1").DataTable({
            "responsive": true, "lengthChange": true, "autoWidth": false,
            "lengthMenu": [[5, 10, 25, 50, -1], [5, 10, 25, 50, "All"]],
            "buttons": [ "excel", "pdf", "print"]
          }).buttons().container().appendTo('#example1_wrapper .col-md-6:eq(0)');
        
        

        // Attach the event listener for the custom sort dropdown
        $('#sort-by').on('change', function() {
            var sortValue = $(this).val();

            // Clear previous sorting and apply the new order
            switch (sortValue) {
                case 'name_asc':
                    // Sort by 'Project Name' (column index 1)
                    table.order([1, 'asc']).draw();
                    break;
                case 'name_desc':
                    // Sort by 'Project Name' (column index 1)
                    table.order([1, 'desc']).draw();
                    break;
                case 'end_date_desc':
                    // Sort by 'End Date' (column index 3) for "Recently Added"
                    table.order([3, 'desc']).draw();
                    break;
                case 'end_date_asc':
                    // Sort by 'End Date' (column index 3) for "Oldest"
                    table.order([3, 'asc']).draw();
                    break;
                default:
                    // Default state, clear sorting
                    table.order([]).draw();
                    break;
            }
        });
        
        // This part is for the other table you have, it remains unchanged
        $('#example2').DataTable({
            "paging": true,
            "lengthChange": true,
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