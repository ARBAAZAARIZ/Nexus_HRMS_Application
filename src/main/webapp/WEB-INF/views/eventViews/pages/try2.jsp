<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Calendar</title>

  <!-- Google Font: Source Sans Pro -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="../plugins/fontawesome-free/css/all.min.css">
  <!-- fullCalendar -->
  <link rel="stylesheet" href="../plugins/fullcalendar/main.css">
  <!-- Bootstrap CSS for Modal -->
  <link rel="stylesheet" href="../plugins/bootstrap/css/bootstrap.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="../dist/css/adminlte.min2167.css?v=3.2.0">
</head>
<body class="hold-transition">

<div class="wrapper">

  <!-- Content Wrapper -->
  <div class="content-wrapper">
    <!-- Content Header -->
    <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-12 text-center">
            <h1>Calendar</h1>
          </div>
        </div>
      </div>
    </section>

    <!-- Main content -->
    <section class="content">
      <div class="container-fluid">
        <div class="row">
          <!-- Calendar (70%) -->
          <div class="col-md-8">
            <div class="card card-primary">
              <div class="card-body p-0">
                <div id="calendar"></div>
              </div>
            </div>
          </div>

          <!-- Operations (30%) -->
          <div class="col-md-4">
            <div class="card">
              <div class="card-header text-center p-0">
                <!-- Full width Add New Event button -->
                <button id="openModalBtn" class="btn btn-primary w-100" style="height: 50px; font-size: 18px;">
                  Add New Event
                </button>
              </div>
              <div class="card-body">
                <!-- Attractive event cell -->
                <div 
                  style="background-color: white; border: 1px solid #ddd; padding: 12px; margin-bottom: 12px; border-radius: 6px; cursor: pointer; text-align: center; box-shadow: 0 2px 5px rgba(0,0,0,0.1); transition: background-color 0.3s;"
                  onmouseover="this.style.backgroundColor='whitesmoke'" 
                  onmouseout="this.style.backgroundColor='white'">
                  <div style="font-weight: bold; font-size: 16px; margin-bottom: 4px;">Holi</div>
                  <div style="color: #007bff; font-size: 14px;">2025-09-19</div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
  </div>
</div>

<!-- Modal -->
<div class="modal fade" id="addEventModal" tabindex="-1" role="dialog" aria-labelledby="addEventModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title w-100 text-center" id="addEventModalLabel">Add New Event</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
  <span aria-hidden="true">&times;</span>
</button>

      </div>
      <div class="modal-body">
        <form>
          <div class="form-group">
            <label for="eventTitle">Event Title</label>
            <input type="text" class="form-control" id="eventTitle" placeholder="Enter Event Title">
          </div>
          <div class="form-group">
            <label for="eventDate">Event Date</label>
            <input type="date" class="form-control" id="eventDate">
          </div>
          <div class="form-group">
            <label for="eventType">Event Type</label>
            <select class="form-control" id="eventType">
              <option value="">-- Select Event Type --</option>
              <option value="meeting">Meeting</option>
              <option value="holiday">Holiday</option>
              <option value="birthday">Birthday</option>
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

<!-- Scripts -->
<script src="../plugins/jquery/jquery.min.js"></script>
<script src="../plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="../plugins/jquery-ui/jquery-ui.min.js"></script>
<script src="../dist/js/adminlte.min2167.js?v=3.2.0"></script>
<script src="../plugins/moment/moment.min.js"></script>
<script src="../plugins/fullcalendar/main.js"></script>
<script src="../dist/js/demo.js"></script>

<script>
$(function () {
  var date = new Date()
  var d = date.getDate(), m = date.getMonth(), y = date.getFullYear()
  var Calendar = FullCalendar.Calendar;
  var calendarEl = document.getElementById('calendar');

  var calendar = new Calendar(calendarEl, {
    headerToolbar: {
      left: 'prev,next today',
      center: 'title',
      right: 'dayGridMonth,timeGridWeek,timeGridDay'
    },
    themeSystem: 'bootstrap',
    events: [
      { title: 'All Day Event', start: new Date(y, m, 1), backgroundColor: '#f56954', borderColor: '#f56954', allDay: true },
      { title: 'Long Event', start: new Date(y, m, d - 5), end: new Date(y, m, d - 2), backgroundColor: '#f39c12', borderColor: '#f39c12' },
      { title: 'Meeting', start: new Date(y, m, d, 10, 30), allDay: false, backgroundColor: '#0073b7', borderColor: '#0073b7' },
      { title: 'Lunch', start: new Date(y, m, d, 12, 0), end: new Date(y, m, d, 14, 0), allDay: false, backgroundColor: '#00c0ef', borderColor: '#00c0ef' },
      { title: 'Birthday Party', start: new Date(y, m, d + 1, 19, 0), end: new Date(y, m, d + 1, 22, 30), allDay: false, backgroundColor: '#00a65a', borderColor: '#00a65a' },
      { title: 'Click for Google', start: new Date(y, m, 28), end: new Date(y, m, 29), url: 'https://www.google.com/', backgroundColor: '#3c8dbc', borderColor: '#3c8dbc' }
    ],
    editable: true
  });

  calendar.render();

  // Open modal on button click
  $('#openModalBtn').click(function() {
    $('#addEventModal').modal('show');
  });
});
</script>
</body>
</html>
