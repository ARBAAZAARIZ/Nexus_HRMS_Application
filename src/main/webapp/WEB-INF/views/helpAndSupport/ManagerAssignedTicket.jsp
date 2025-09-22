<%@ page import="model.Ticket, model.Users, java.util.List, java.sql.*"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Manager - Assign Tickets</title>
<!-- Google Font -->

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

</head>
<body class="hold-transition sidebar-mini layout-fixed">

<jsp:include page="../../../navbar.jsp" />
		<jsp:include page="../../../sidebar.jsp" />

	<div class="wrapper">

		
		<div class="content-wrapper">
			<section class="content-header">
				<div class="container-fluid">
					<h1>Manager - Assign Tickets</h1>
				</div>
			</section>

			<section class="content">
				<div class="container-fluid">
					<%
					List<Ticket> tickets = (List<Ticket>) request.getAttribute("tickets");
					if (tickets != null && !tickets.isEmpty()) {
					%>
					<div class="card card-primary">
						<div class="card-body table-responsive">
							<table class="table table-bordered table-hover">
								<thead class="table-dark">
									<tr>
										<th>ID</th>
										<th>Title</th>
										<th>Status</th>
										<th>Assign To</th>
										<th>Action</th>
									</tr>
								</thead>
								<tbody>
									<%
									try (Connection conn = util.DatabaseConnection.getConnection();
											PreparedStatement ps = conn
											.prepareStatement("SELECT user_id, first_name, last_name FROM users WHERE role_id != 0");
											ResultSet rs = ps.executeQuery()) {

										List<Users> employees = new java.util.ArrayList<>();
										while (rs.next()) {
											Users u = new Users();
											u.setUserId(rs.getInt("user_id"));
											u.setFirstName(rs.getString("first_name"));
											u.setLastName(rs.getString("last_name"));
											employees.add(u);
										}

										for (Ticket t : tickets) {
									%>
									<tr>
										<td><%=t.getTicketId()%></td>
										<td><%=t.getTitle()%></td>
										<td><span
											class="badge <%="Closed".equalsIgnoreCase(t.getStatus()) ? "bg-success" : "bg-warning"%>">
												<%=t.getStatus()%>
										</span></td>
										<td>
											<%
											if (!"Closed".equalsIgnoreCase(t.getStatus())) {
											%>
											<form method="post"
												action="<%=request.getContextPath()%>/Manager_AssignTicket"
												class="d-flex gap-1">
												<input type="hidden" name="ticketId"
													value="<%=t.getTicketId()%>"> <select
													name="staffUserId" class="form-select form-select-sm"
													required>
													<option value="">--Select Employee--</option>
													<%
													for (Users u : employees) {
													%>
													<option value="<%=u.getUserId()%>"
														<%=(t.getAssignTo() == u.getUserId() ? "selected" : "")%>>
														<%=u.getFirstName() + " " + u.getLastName()%>
													</option>
													<%
													}
													%>
												</select>
												<button class="btn btn-warning btn-sm">Assign</button>
											</form> <%
 } else {
 %> <span>-</span> <%
 }
 %>
										</td>
										<td><a
											href="<%=request.getContextPath()%>/ViewTicketDetails?ticketId=<%=t.getTicketId()%>"
											class="btn btn-success btn-sm"> <i class="fas fa-eye"></i>
												View
										</a></td>
									</tr>
									<%
									}
									} catch (Exception e) {
									e.printStackTrace();
									}
									%>
								</tbody>
							</table>
						</div>
					</div>
					<%
					} else {
					%>
					<div class="alert alert-warning">No tickets found.</div>
					<%
					}
					%>
				</div>
			</section>
		</div>

	</div>
		<jsp:include page="../../../footer.jsp" />

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
	
</body>
</html>
