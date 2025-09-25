<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Calendar</title>

  <!-- Google Font -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="../plugins/fontawesome-free/css/all.min.css">
  <!-- fullCalendar -->
  <link rel="stylesheet" href="../plugins/fullcalendar/main.css">
  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="../plugins/bootstrap/css/bootstrap.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="../dist/css/adminlte.min2167.css?v=3.2.0">
</head>
<body class="hold-transition">

<div class="wrapper">

  <!-- Content Wrapper -->
  <div class="content-wrapper">
    <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-md-8">
            <h1 class="text-center m-0 fw-bold">Calendar</h1>
          </div>
          <div class="col-md-4"></div>
        </div>
      </div>
    </section>

    <!-- Main content -->
    <section class="content">
      <div class="container-fluid">
        <div class="row">
          <!-- Calendar -->
          <div class="col-md-8">
            <div class="card card-primary">
              <div class="card-body p-0">
                <div id="calendar"></div>
              </div>
            </div>
          </div>

          <!-- Side Cards -->
          <div class="col-md-4">
            <div class="card">
              <div class="card-header text-center p-0">
                <button id="openModalBtn" class="btn btn-primary w-100" style="height:50px; font-size:18px;">
                  Add New Event
                </button>
              </div>
              <div class="card-body" id="eventsCardContainer">
                <!-- Dynamic event cards will appear here -->
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
        <form id="addEventForm">
          <div class="form-group">
            <label for="eventTitle">Event Title</label>
            <input type="text" class="form-control" id="eventTitle" name="eventTitle" placeholder="Enter Event Title" required>
          </div>
          <div class="form-group">
            <label for="eventDate">Event Date</label>
            <input type="date" class="form-control" id="eventDate" name="eventDate" required>
          </div>
          <div class="form-group">
            <label for="eventType">Event Type</label>
            <select class="form-control" id="eventType" name="eventType" required>
              <option value="">-- Select Event Type --</option>
              <option value="1">Meeting</option>
              <option value="2">Holiday</option>
              <option value="3">Birthday</option>
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
  var Calendar = FullCalendar.Calendar;
  var calendarEl = document.getElementById('calendar');
  var eventsCardContainer = $('#eventsCardContainer');

  // Initialize FullCalendar
  var calendar = new Calendar(calendarEl, {
    headerToolbar: {
      left: 'prev,next today',
      center: 'title',
      right: 'dayGridMonth,timeGridWeek,timeGridDay'
    },
    themeSystem: 'bootstrap',
    editable: true,
    events: '/Events/EventJsonServlet'
  });
  calendar.render();

  // Function to load side cards dynamically
  function loadEventCards() {
    $.ajax({
      url: '/Events/EventJsonServlet',
      method: 'GET',
      dataType: 'json',
      success: function(events) {
        eventsCardContainer.empty();
        events.forEach(function(event) {
          // Use event.start instead of event.date
          var card = `<div style="background-color:${event.color || 'white'}; border:1px solid #ddd; padding:12px; margin-bottom:12px; border-radius:6px; cursor:pointer; text-align:center; box-shadow:0 2px 5px rgba(0,0,0,0.1); transition:0.3s;"
                        onmouseover="this.style.backgroundColor='whitesmoke'" 
                        onmouseout="this.style.backgroundColor='${event.color || 'white'}'">
                        <div style="font-weight:bold; font-size:16px;">${event.title}</div>
                        <div style="color:#007bff; font-size:14px;">${event.start}</div>
                      </div>`;
          eventsCardContainer.append(card);
        });
      },
      error: function() {
        alert('Failed to load events for cards.');
      }
    });
  }

  loadEventCards(); // Initial load

  // Open modal
  $('#openModalBtn').click(function() {
    $('#addEventModal').modal('show');
  });

  // Add new event
  $('#addEventForm').submit(function(e){
    e.preventDefault();
    $.ajax({
      url: '/Events/EventServlet?action=insert',
      method: 'POST',
      data: $(this).serialize(),
      success: function(){
        $('#addEventModal').modal('hide');
        calendar.refetchEvents(); // refresh calendar
        loadEventCards(); // refresh side cards
      },
      error: function(){
        alert('Error adding event');
      }
    });
  });
});
</script>

</body>
</html>
