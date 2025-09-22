<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.Ticket" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Ticket Details</title>

  <!-- Google Font -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="plugins/fontawesome-free/css/all.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="dist/css/adminlte.min2167.css?v=3.2.0">
  <!-- Bootstrap 4 -->
  <link rel="stylesheet" href="plugins/bootstrap/css/bootstrap.min.css">

  <style>
    .detail-label { font-weight: bold; width: 150px; display: inline-block; }
    .detail-value { color: #333; }
    .btn-back { margin-top: 15px; }
  </style>
</head>
<body class="hold-transition sidebar-mini layout-fixed">

<div class="wrapper">

  <!-- Navbar -->
  <jsp:include page="../../../navbar.jsp"></jsp:include>

  <!-- Sidebar -->
  <jsp:include page="../../../sidebar.jsp"></jsp:include>

  <!-- Content Wrapper -->
  <div class="content-wrapper">
    <!-- Page Header -->
    <div class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1 class="m-0">Ticket Details</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="home.jsp">Home</a></li>
              <li class="breadcrumb-item"><a href="<%= request.getContextPath() %>/MyTickets">My Tickets</a></li>
              <li class="breadcrumb-item active">Details</li>
            </ol>
          </div>
        </div>
      </div>
    </div>

    <!-- Main Content -->
    <section class="content">
      <div class="container-fluid">
        <%
          Ticket t = (Ticket) request.getAttribute("ticket");
          if (t != null) {
        %>
        <div class="card card-primary">
          <div class="card-header">
            <h3 class="card-title"><i class="fas fa-ticket-alt"></i> Ticket #<%= t.getTicketId() %></h3>
          </div>
          <div class="card-body">
            <p><span class="detail-label">Title:</span> <span class="detail-value"><%= t.getTitle() %></span></p>
            <p><span class="detail-label">Description:</span> <span class="detail-value"><%= t.getDescription() %></span></p>
            <p><span class="detail-label">Attachment:</span> 
              <span class="detail-value">
                <% if (t.getAttachment() != null && !t.getAttachment().isEmpty()) { %>
                  <a href="<%= request.getContextPath() %>/uploads/<%= t.getAttachment() %>" target="_blank" class="btn btn-outline-info btn-sm">
                    <i class="fas fa-download"></i> Download
                  </a>
                <% } else { %>
                  N/A
                <% } %>
              </span>
            </p>
            <p><span class="detail-label">Created At:</span> <span class="detail-value"><%= t.getCreatedAt() %></span></p>
            <p><span class="detail-label">Assigned To:</span> <span class="detail-value"><%= t.getAssignToName() %></span></p>
            <p><span class="detail-label">Resolve Date:</span> <span class="detail-value"><%= (t.getResolveDate() != null ? t.getResolveDate() : "-") %></span></p>
            <p><span class="detail-label">Status:</span> 
              <span class="badge <%= "Closed".equalsIgnoreCase(t.getStatus()) ? "badge-success" : "badge-warning" %>">
                <%= t.getStatus() %>
              </span>
            </p>

            <a href="<%= request.getContextPath() %>/MyTickets" class="btn btn-primary btn-back">
              <i class="fas fa-arrow-left"></i> Back to My Tickets
            </a>
          </div>
        </div>
        <% } else { %>
        <div class="alert alert-warning">
          ❌ No ticket details available.
        </div>
        <% } %>
      </div>
    </section>
  </div>

  <!-- Footer -->
  <jsp:include page="../../../footer.jsp"></jsp:include>

</div>

<!-- Scripts -->
<script src="plugins/jquery/jquery.min.js"></script>
<script src="plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="dist/js/adminlte.min2167.js?v=3.2.0"></script>
</body>
</html>
