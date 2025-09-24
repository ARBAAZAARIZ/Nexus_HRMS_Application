<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Earnings Management</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"/>
    <style>
        body { background: #f8f9fa; }
        .main-content { max-width: 1000px; margin: 36px auto 0 auto; }
        .table th, .table td { vertical-align: middle; }
        .action-icons i { cursor: pointer; margin: 0 6px; color: #1976d2; }
        .fa-trash-alt { color: #EA5A47 !important; }
        .btn-orange { background: #FCB900; color: #222; }
        .btn-orange:hover { background: #e0a800; color: #222; }
        .dropdown-menu .active,
        .dropdown-menu .selected,
        .dropdown-menu .highlight { background: #FFEAE2 !important; color: #FC7100 !important; }
        .dropdown-menu a { color: #545454; }
        .dropdown-menu a:hover { background: #fff4ee; color: #FC7100; }
    </style>
</head>
<body>
<div class="main-content">

    <!-- Navigation Button Group -->
    <div class="d-flex justify-content-between align-items-center mb-4">
        <div>
            <div class="btn-group mr-2">
                <button type="button" class="btn btn-secondary dropdown-toggle" data-toggle="dropdown">
                    Earning
                </button>
                <div class="dropdown-menu">
                    <a class="dropdown-item active" href="${pageContext.request.contextPath}/earningType">Earning type</a>
                    <a class="dropdown-item" href="${pageContext.request.contextPath}/earning">Earning</a>
                </div>
            </div>
            <div class="btn-group">
                <button type="button" class="btn btn-secondary dropdown-toggle" data-toggle="dropdown">
                    Deduction
                </button>
                <div class="dropdown-menu">
                    <a class="dropdown-item" href="${pageContext.request.contextPath}/deductionType">Deduction type</a>
                    <a class="dropdown-item" href="${pageContext.request.contextPath}/deduction">Deduction</a>
                </div>
            </div>
        </div>
        <button class="btn btn-orange" data-toggle="modal" data-target="#addEarningModal">
            <i class="fas fa-plus-circle"></i> Add Earning
        </button>
    </div>

    <c:if test="${not empty error}">
        <div class="alert alert-danger">${error}</div>
    </c:if>
    <table class="table table-striped">
        <thead>
            <tr>
                <th>Id</th>
                <th>Earning Type</th>
                <th>Department</th>
                <th>Designation</th>
                <th>Earning Percentage</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="earning" items="${earningList}">
                <tr>
                    <td>${earning.id}</td>
                    <td>${earning.earningTypeName}</td>
                    <td>${earning.departmentName}</td>
                    <td>${earning.designationName}</td>
                    <td>${earning.earningPercentage}</td>
                    <td class="action-icons">
                        <a href="#" 
                           class="edit-btn" 
                           data-id="${earning.id}" 
                           data-earningtypeid="${earning.earningTypeId}" 
                           data-departmentid="${earning.departmentId}" 
                           data-designationid="${earning.designationId}" 
                           data-earningpercentage="${earning.earningPercentage}"
                           title="Edit">
                           <i class="fas fa-edit"></i>
                        </a>
                        <a href="#" class="delete-btn" data-id="${earning.id}" title="Delete">
                            <i class="fas fa-trash-alt"></i>
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

<!-- Add Earning Modal -->
<div class="modal fade" id="addEarningModal" tabindex="-1" role="dialog" aria-labelledby="addEarningLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <form action="${pageContext.request.contextPath}/earning" method="post" class="modal-content">
      <input type="hidden" name="action" value="add"/>
      <div class="modal-header">
        <h5 class="modal-title" id="addEarningLabel">Add Earning</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span>&times;</span></button>
      </div>
      <div class="modal-body">
        <label>Earning Type</label>
        <select name="earningTypeId" class="form-control" required>
            <option value="">Select Earning Type</option>
            <c:forEach var="type" items="${earningTypeList}">
                <option value="${type.id}">${type.earningTypeName}</option>
            </c:forEach>
        </select>
        <label>Department</label>
        <select name="departmentId" class="form-control" required>
            <option value="">Select Department</option>
            <c:forEach var="dept" items="${departmentList}">
                <option value="${dept.id}">${dept.departmentName}</option>
            </c:forEach>
        </select>
        <label>Designation</label>
        <select name="designationId" class="form-control" required>
            <option value="">Select Designation</option>
            <c:forEach var="des" items="${designationList}">
                <option value="${des.id}">${des.designationName}</option>
            </c:forEach>
        </select>
        <label>Earning Percentage</label>
        <input type="number" step="0.01" name="earningPercentage" class="form-control" required/>
      </div>
      <div class="modal-footer">
        <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
        <button class="btn btn-orange" type="submit">Add</button>
      </div>
    </form>
  </div>
</div>

<!-- Edit Earning Modal -->
<div class="modal fade" id="editEarningModal" tabindex="-1" role="dialog" aria-labelledby="editEarningLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <form action="${pageContext.request.contextPath}/earning" method="post" class="modal-content">
      <input type="hidden" name="action" value="edit"/>
      <input type="hidden" name="id" id="editId"/>
      <div class="modal-header">
        <h5 class="modal-title" id="editEarningLabel">Edit Earning</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span>&times;</span></button>
      </div>
      <div class="modal-body">
        <label>Earning Type</label>
        <select name="earningTypeId" id="editEarningTypeId" class="form-control" required>
            <option value="">Select Earning Type</option>
            <c:forEach var="type" items="${earningTypeList}">
                <option value="${type.id}">${type.earningTypeName}</option>
            </c:forEach>
        </select>
        <label>Department</label>
        <select name="departmentId" id="editDepartmentId" class="form-control" required>
            <option value="">Select Department</option>
            <c:forEach var="dept" items="${departmentList}">
                <option value="${dept.id}">${dept.departmentName}</option>
            </c:forEach>
        </select>
        <label>Designation</label>
        <select name="designationId" id="editDesignationId" class="form-control" required>
            <option value="">Select Designation</option>
            <c:forEach var="des" items="${designationList}">
                <option value="${des.id}">${des.designationName}</option>
            </c:forEach>
        </select>
        <label>Earning Percentage</label>
        <input type="number" step="0.01" name="earningPercentage" id="editEarningPercentage" class="form-control" required/>
      </div>
      <div class="modal-footer">
        <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
        <button class="btn btn-orange" type="submit">Update</button>
      </div>
    </form>
  </div>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>
<script>
    // Fill Edit modal with data on edit button click
    $(document).on('click', '.edit-btn', function(e) {
        e.preventDefault();
        $('#editId').val($(this).data('id'));
        $('#editEarningTypeId').val($(this).data('earningtypeid'));
        $('#editDepartmentId').val($(this).data('departmentid'));
        $('#editDesignationId').val($(this).data('designationid'));
        $('#editEarningPercentage').val($(this).data('earningpercentage'));
        $('#editEarningModal').modal('show');
    });

    // Delete confirmation and form submit
    $(document).on('click', '.delete-btn', function(e) {
        e.preventDefault();
        if(confirm('Are you sure to delete this earning?')) {
            var id = $(this).data('id');
            var form = $('<form action="${pageContext.request.contextPath}/earning" method="post"></form>');
            form.append('<input type="hidden" name="action" value="delete"/>');
            form.append('<input type="hidden" name="id" value="' + id + '"/>');
            $('body').append(form);
            form.submit();
        }
    });
</script>
</body>
</html>