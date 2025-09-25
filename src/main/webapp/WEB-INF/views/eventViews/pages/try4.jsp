<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Event List</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container-fluid mt-4">
  <div class="row">
    <div class="col-md-2">
      <!-- Sidebar -->
    </div>
    <div class="col-md-10">
      <div class="card shadow-sm">
        <div class="card-header d-flex align-items-center">
          <h3 class="card-title mb-0 text-center flex-grow-1">Event List</h3>
          <button type="button"
                  class="btn text-white d-flex align-items-center"
                  style="background-color:#0d6efd; border:none; transition:all 0.2s ease-in-out; padding:6px 12px; gap:6px;"
                  data-bs-toggle="modal"
                  data-bs-target="#addEventModal">
            <i class="fas fa-plus"></i> Add New Event
          </button>
        </div>
        <div class="card-body">
          <table class="table table-bordered table-hover text-center">
            <thead style="background-color:#e0e0e0; color:#0d6efd; font-weight:bold;">
              <tr>
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
                    <c:choose>
                      <c:when test="${event.status == 'ACTIVE'}">
                        <span class="badge bg-success">Active</span>
                      </c:when>
                      <c:otherwise>
                        <span class="badge bg-danger">Inactive</span>
                      </c:otherwise>
                    </c:choose>
                  </td>
                  <td>${event.eventDate}</td>
                  <td>
                    <!-- Edit button targeting event-specific modal -->
                    <button class="btn btn-sm btn-info" data-bs-toggle="modal" data-bs-target="#editEventModal${event.id}">
                      <i class="fas fa-edit"></i>
                    </button>
                    <a href="EventServlet?action=delete&id=${event.id}" class="btn btn-sm btn-danger"
                       onclick="return confirm('Are you sure you want to delete this event?');">
                      <i class="fas fa-trash"></i>
                    </a>
                  </td>
                </tr>

                <!-- Edit Modal for this event -->
                <div class="modal fade" id="editEventModal${event.id}" tabindex="-1" aria-labelledby="editEventModalLabel${event.id}" aria-hidden="true">
                  <div class="modal-dialog modal-dialog-centered">
                    <div class="modal-content">
                      <div class="modal-header">
                        <h5 class="modal-title w-100 text-center" id="editEventModalLabel${event.id}">Edit Event</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                      </div>
                      <div class="modal-body">
                        <form action="EventServlet?action=update" method="post">
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
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <form action="EventServlet?action=insert" method="post">
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

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
