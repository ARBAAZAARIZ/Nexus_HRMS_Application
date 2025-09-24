<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Calendar</title>

  <!-- Google Font: Source Sans Pro -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="<c:url value='/plugins/fontawesome-free/css/all.min.css'/>">
  <!-- fullCalendar -->
  <link rel="stylesheet" href="<c:url value='/plugins/fullcalendar/main.css'/>">
  <!-- Bootstrap CSS for Modal -->
  <link rel="stylesheet" href="<c:url value='/plugins/bootstrap/css/bootstrap.min.css'/>">
  <!-- Theme style -->
  <link rel="stylesheet" href="<c:url value='/dist/css/adminlte.min2167.css?v=3.2.0'/>">
</head>
<body class="hold-transition">

<div class="wrapper">

  <!-- Content Wrapper -->
  <div class="content-wrapper">
    <!-- Content Header -->
    <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <!-- Headline aligned with calendar block -->
          <div class="col-md-8 text-center">
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
                <button id="openModalBtn" class="btn btn-primary w-100" style="height: 50px; font-size: 18px;">
                  Add New Event
                </button>
              </div>
              <div class="card-body">
                <!-- Loop through events for cards -->
                <c:forEach var="event" items="${events}">
                  <div style="background-color:white; border:1px solid #ddd; padding:12px; margin-bottom:12px; border-radius:6px; cursor:pointer; text-align:center; box-shadow:0 2px 5px rgba(0,0,0,0.1);">
                    <div style="font-weight:bold; font-size:16px; margin-bottom:4px;">${event.title}</div>
                    <div style="color:${event.color}; font-size:14px;">${event.date}</div>
                  </div>
                </c:forEach>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
  </div>
</div>

<!-- Scripts -->
<script src="<c:url value='/plugins/jquery/jquery.min.js'/>"></script>
<script src="<c:url value='/plugins/bootstrap/js/bootstrap.bundle.min.js'/>"></script>
<script src="<c:url value='/plugins/jquery-ui/jquery-ui.min.js'/>"></script>
<script src="<c:url value='/dist/js/adminlte.min2167.js?v=3.2.0'/>"></script>
<script src="<c:url value='/plugins/moment/moment.min.js'/>"></script>
<script src="<c:url value='/plugins/fullcalendar/main.js'/>"></script>

<script>
$(function () {
  var calendarEl = document.getElementById('calendar');

  var calendar = new FullCalendar.Calendar(calendarEl, {
    headerToolbar: {
      left: 'prev,next today',
      center: 'title',
      right: 'dayGridMonth,timeGridWeek,timeGridDay'
    },
    themeSystem: 'bootstrap',
    events: [
      <c:forEach var="event" items="${events}">
        {
          title: '${event.title}',
          start: '${event.date}',
          color: '${event.color}'
        },
      </c:forEach>
    ]
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
    