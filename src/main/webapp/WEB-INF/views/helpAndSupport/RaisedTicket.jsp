<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Dashboard - Raise Ticket</title>

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
            <h1 class="m-0">Help & Support</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="home.jsp">Home</a></li>
              <li class="breadcrumb-item active">Raise Ticket</li>
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
            <h3 class="card-title">Raise New Ticket</h3>
          </div>
          <div class="card-body">
            <p>
              Welcome to the Help & Support portal. Here you can raise tickets related 
              to IT issues or any other work-related queries. Our support team will respond 
              as soon as possible.
            </p>

            <button type="button" class="btn btn-success" data-toggle="modal" data-target="#raiseTicketModal">
              Raise Ticket
            </button>
          </div>
        </div>

        <!-- Modal -->
        <div class="modal fade" id="raiseTicketModal" tabindex="-1" aria-labelledby="raiseTicketLabel" aria-hidden="true">
          <div class="modal-dialog modal-lg">
            <div class="modal-content">
              <form action="RaisedTicket" method="post">
                <div class="modal-header bg-primary text-white">
                  <h5 class="modal-title" id="raiseTicketLabel">Ticket Raising Form</h5>
                  <button type="button" class="btn-close" data-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">

                  <div class="mb-3">
                    <label>First Name:</label>
                    <input type="text" name="first_name" class="form-control" required>
                  </div>

                  <div class="mb-3">
                    <label>Email ID:</label>
                    <input type="email" name="email" class="form-control" required>
                  </div>

                  <div class="mb-3">
                    <label>Contact Number:</label>
                    <input type="text" name="contact_number" class="form-control" required>
                  </div>

                  <div class="mb-3">
                    <label>Department:</label>
                    <select name="department" class="form-select form-control" required>
                      <option value="">--Select Department--</option>
                      <option value="HR">HR</option>
                      <option value="IT">IT</option>
                      <option value="Sales">Sales</option>
                    </select>
                  </div>

                  <div class="mb-3">
                    <label>Ticket Title:</label>
                    <input type="text" name="ticket_title" class="form-control" required>
                  </div>

                  <div class="mb-3">
                    <label>Issue Type:</label>
                    <select name="issue_type" class="form-select form-control" required>
                      <option value="">--Select Issue Type--</option>
                      <option value="Technical Issue">Technical Issue</option>
                      <option value="Leave Request">Leave Request</option>
                      <option value="Payroll Query">Payroll Query</option>
                      <option value="Benefits Request">Benefits Request</option>
                      <option value="Other">Other</option>
                    </select>
                  </div>

                  <div class="mb-3">
                    <label>Description:</label>
                    <textarea name="ticket_description" class="form-control" rows="4" required></textarea>
                  </div>

                  <div class="mb-3">
                    <label>Priority:</label>
                    <select name="priority" class="form-select form-control" required>
                      <option value="">--Select Priority--</option>
                      <option value="Low">Low</option>
                      <option value="Medium">Medium</option>
                      <option value="High">High</option>
                    </select>
                  </div>

                  <div class="mb-3">
                    <label>Attachment (filename):</label>
                    <input type="file" name="attachment" class="form-control">
                  </div>

                  <div class="mb-3">
                    <label>Issue Date:</label>
                    <input type="date" name="issue_date" class="form-control" required>
                  </div>

                </div>
                <div class="modal-footer">
                  <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                  <button type="submit" class="btn btn-success">Raise Ticket</button>
                </div>
              </form>
            </div>
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
