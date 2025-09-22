<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.Ticket" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>My Tickets</title>

  <!-- Google Font -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="plugins/fontawesome-free/css/all.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="dist/css/adminlte.min2167.css?v=3.2.0">
  <!-- Bootstrap 4 -->
  <link rel="stylesheet" href="plugins/bootstrap/css/bootstrap.min.css">
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
            <h1 class="m-0">My Tickets</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="home.jsp">Home</a></li>
              <li class="breadcrumb-item active">My Tickets</li>
            </ol>
          </div>
        </div>
      </div>
    </div>

    <!-- Main Content -->
    <section class="content">
      <div class="container-fluid">

        <div class="card">
          <div class="card-header bg-primary text-white">
            <h3 class="card-title"><i class="fas fa-ticket-alt"></i> Your Submitted Tickets</h3>
          </div>
          <div class="card-body table-responsive">
            <table class="table table-striped table-bordered table-hover">
              <thead class="table-dark">
                <tr>
                  <th>ID</th>
                  <th>Ticket</th>
                  <th>Description</th>
                  <th>Attachment</th>
                  <th>Created At</th>
                  <th>Assign To</th>
                  <th>Resolve Date</th>
                  <th>Status</th>
                  <th>Action</th>
                </tr>
              </thead>
              <tbody>
              <%
                List<Ticket> tickets = (List<Ticket>) request.getAttribute("tickets");  
                if (tickets != null && !tickets.isEmpty()) {
                    for (Ticket t : tickets) {
              %>
                <tr>
                  <td><%= t.getTicketId() %></td>
                  <td><%= t.getTitle() %></td>
                  <td><%= t.getDescription() %></td>
                  <td>
                    <% if (t.getAttachment() != null && !t.getAttachment().isEmpty()) { %>
                      <a href="uploads/<%= t.getAttachment() %>" target="_blank" class="btn btn-outline-info btn-sm">
                        <i class="fas fa-download"></i> Download
                      </a>
                    <% } else { %>
                      <span class="text-muted">N/A</span>
                    <% } %>
                  </td>
                  <td><%= t.getCreatedAt() %></td>
                  <td><%= t.getAssignToName() %></td>
                  <td><%= (t.getResolveDate() != null ? t.getResolveDate() : "-") %></td>
                  <td>
                    <span class="badge 
                      <%= "Closed".equalsIgnoreCase(t.getStatus()) ? "badge-success" :
                          "In Progress".equalsIgnoreCase(t.getStatus()) ? "badge-warning" :
                          "badge-secondary" %>">
                      <%= t.getStatus() %>
                    </span>
                  </td>
                  <td>
                    <a href="<%= request.getContextPath() %>/ViewTicketDetails?ticketId=<%= t.getTicketId() %>"
                       class="btn btn-success btn-sm">
                      <i class="fas fa-eye"></i> View
                    </a>
                  </td>
                </tr>
              <%
                    }
                } else {
              %>
                <tr>
                  <td colspan="9" class="text-center text-muted">No tickets found.</td>
                </tr>
              <% } %>
              </tbody>
            </table>
          </div>
        </div>

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
