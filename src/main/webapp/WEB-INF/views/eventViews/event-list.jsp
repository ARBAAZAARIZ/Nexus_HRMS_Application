<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>AdminLTE 3 | Dashboard</title>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" />

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
  <link rel="stylesheet" href="plugins/summernote/summernote-bs4.min.css">

  <style>
    body, .content-wrapper, .container-fluid:first-child {
      margin-top: 0 !important;
      padding-top: 0 !important;
    }
    /* Optional: Adjust table and controls spacing */
    .table-controls {
      display: flex;
      justify-content: space-between;
      margin-bottom: 10px;
      align-items: center;
    }
    .pagination-container button.active {
      background-color: #0d6efd;
      color: white;
    }
    .pagination-container button {
      font-size: 0.85rem;
      margin-right: 2px;
      padding: 3px 8px;
    }
  </style>
</head>

<body class="hold-transition sidebar-mini layout-fixed" style="margin:0; padding:0;">
<jsp:include page="../../../navbar.jsp"></jsp:include>
<jsp:include page="../../../sidebar.jsp"></jsp:include>

<div class="container-fluid mt-0">
  <div class="row">
    <div class="col-md-2"></div>
    <div class="col-md-10">
      <div class="card shadow-sm">

        <!-- Card Header -->
        <div class="card-header d-flex align-items-center">
          <h5 class="mb-0 text-center flex-grow-1" 
              style="font-weight:700; font-size:1.25rem; color:#444; margin:0;">
            Event List
          </h5>
          <button type="button"
                  class="btn text-white d-flex align-items-center"
                  style="background-color:#0d6efd; border:none; transition:all 0.2s ease-in-out; padding:6px 12px; gap:6px;"
                  data-toggle="modal"
                  data-target="#addEventModal">
            <i class="fas fa-plus mr-1"></i> Add New Event
          </button>
        </div>

        <!-- Table Controls (Search + Records per page) -->
        <div class="card-body">
          <div class="table-controls">
            <input type="text" id="searchInput" class="form-control" placeholder="Search..." style="width: 200px;">
            <select id="recordsPerPage" class="form-control" style="width: 80px;">
              <option value="5">5</option>
              <option value="10" selected>10</option>
              <option value="20">20</option>
            </select>
          </div>

          <table class="table table-bordered table-hover text-center" id="eventTable">
            <thead>
              <tr style="background-color:#0d6efd; color:white; font-weight:bold;">
                <th>ID</th>
                <th>Title</th>
                <th>Status</th>
                <th>Date</th>
                <th>Action</th>
              </tr>
            </thead>
            <tbody>
              <c:forEach var="event" items="${listEvents}">
                <tr>
                  <td>${event.id}</td>
                  <td class="text-center">${event.title}</td>
                  <td>
                    <form action="EventServlets_1?action=toggleStatus" method="post"  style="display:inline;">
<!--                       <input type="hidden" name="action" value="toggleStatus">
 -->                      <input type="hidden" name="id" value="${event.id}">
                      <input type="hidden" name="currentStatus" value="${event.status}">
                      <button type="submit"
                              class="badge ${event.status == 'ACTIVE' ? 'bg-success' : 'bg-danger'} border-0"
                              style="cursor:pointer; font-size:0.75rem; padding:0.25em 0.5em; line-height:1; border-radius:0.25rem;">
                        ${event.status}
                      </button>
                    </form>
                  </td>
                  <td>${event.eventDate}</td>
                  <td>
                    <button class="btn btn-sm btn-info" data-toggle="modal" data-target="#editEventModal${event.id}">
                      <i class="fas fa-edit"></i>
                    </button>
                    <a href="EventServlets_1?action=delete&id=${event.id}" class="btn btn-sm btn-danger"
                       onclick="return confirm('Are you sure you want to delete this event?');">
                      <i class="fas fa-trash"></i>
                    </a>
                  </td>
                </tr>

                <!-- Edit Modal -->
                <div class="modal fade" id="editEventModal${event.id}" tabindex="-1" aria-labelledby="editEventModalLabel${event.id}" aria-hidden="true">
                  <div class="modal-dialog modal-dialog-centered">
                    <div class="modal-content">
                      <div class="modal-header">
                        <h5 class="modal-title w-100 text-center" id="editEventModalLabel${event.id}">Edit Event</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                          <span aria-hidden="true">&times;</span>
                        </button>
                      </div>
                      <div class="modal-body">
                        <form action="EventServlets_1?action=update" method="post">
                          <input type="hidden" name="eventId" value="${event.id}">
                          <div class="mb-3">
                            <label class="form-label">Event Title</label>
                            <input type="text" name="eventTitle" class="form-control" value="${event.title}" required>
                          </div>
                          <div class="mb-3">
                            <label class="form-label">Event Date</label>
                            <input type="date" name="eventDate" class="form-control" value="${event.eventDate}" required>
                          </div>
                          <div class="mb-3">
                            <label class="form-label">Event Type</label>
                            <select name="eventType" class="form-control" required>
                              <c:forEach var="type" items="${eventTypes}">
                                <option value="${type.id}" style="color:${type.color};"
                                  <c:if test="${type.id == event.eventTypeId}">selected</c:if>>
                                  ${type.name}
                                </option>
                              </c:forEach>
                            </select>
                          </div>
                          <div class="mb-3">
                            <label class="form-label">Status</label>
                            <select name="status" class="form-control" required>
                              <option value="ACTIVE" <c:if test="${event.status == 'ACTIVE'}">selected</c:if>>Active</option>
                              <option value="INACTIVE" <c:if test="${event.status == 'INACTIVE'}">selected</c:if>>Inactive</option>
                            </select>
                          </div>
                          <div class="text-center mt-3">
                            <button type="submit" class="btn btn-primary">Update Event</button>
                          </div>
                        </form>
                      </div>
                    </div>
                  </div>
                </div>
              </c:forEach>
            </tbody>
          </table>

          <!-- Pagination -->
          <div class="pagination-container mt-2"></div>

        </div>
      </div>
    </div>
  </div>
</div>

<!-- Add Event Modal -->
<div class="modal fade" id="addEventModal" tabindex="-1" aria-labelledby="addEventModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title w-100 text-center" id="addEventModalLabel">Add New Event</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form action="EventServlets_1?action=insert" method="post">
          <div class="mb-3">
            <label class="form-label">Event Title</label>
            <input type="text" name="eventTitle" class="form-control" placeholder="Enter Event Title" required>
          </div>
          <div class="mb-3">
            <label class="form-label">Event Date</label>
            <input type="date" name="eventDate" class="form-control" required>
          </div>
          <div class="mb-3">
            <label class="form-label">Event Type</label>
            <select name="eventType" class="form-control" required>
              <c:forEach var="type" items="${eventTypes}">
                <option value="${type.id}" style="color:${type.color};">${type.name}</option>
              </c:forEach>
            </select>
          </div>
          <div class="text-center mt-3">
            <button type="submit" class="btn btn-primary">Add New Event</button>
          </div>
        </form>
      </div>
    </div>
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
	

<script>
  // Frontend Pagination + Search
  $(document).ready(function(){
    const table = $('#eventTable tbody tr');
    const searchInput = $('#searchInput');
    const recordsPerPage = $('#recordsPerPage');
    const paginationContainer = $('.pagination-container');

    function renderTable(page=1) {
      const perPage = parseInt(recordsPerPage.val());
      const search = searchInput.val().toLowerCase();
      let filteredRows = table.filter(function(){
        return $(this).text().toLowerCase().includes(search);
      });

      const totalRows = filteredRows.length;
      const totalPages = Math.ceil(totalRows / perPage);
      const start = (page-1)*perPage;
      const end = start + perPage;

      table.hide();
      filteredRows.slice(start,end).show();

      // Pagination buttons
      paginationContainer.empty();
      if(totalPages > 1){
        for(let i=1;i<=totalPages;i++){
          paginationContainer.append(
            '<button class="btn btn-sm btn-outline-primary ' + (i===page ? 'active' : '') + '" data-page="' + i + '">' + i + '</button>'
          );
        }
      }
    }

    // Initial render
    renderTable();

    // Events
    searchInput.on('input', function(){ renderTable(1); });
    recordsPerPage.on('change', function(){ renderTable(1); });
    paginationContainer.on('click','button', function(){
      const page = parseInt($(this).data('page'));
      renderTable(page);
    });
  });
</script>

</body>
</html>
