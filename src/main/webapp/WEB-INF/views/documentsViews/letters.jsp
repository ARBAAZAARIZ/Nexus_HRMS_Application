<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Generated Letter List</title>

    <!-- Google Font: Source Sans Pro -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&amp;display=fallback">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="plugins/fontawesome-free/css/all.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="../code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
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

    <!-- DataTables -->
    <link rel="stylesheet" href="plugins/datatables-bs4/css/dataTables.bootstrap4.min.css">
    <link rel="stylesheet" href="plugins/datatables-responsive/css/responsive.bootstrap4.min.css">
    <link rel="stylesheet" href="plugins/datatables-buttons/css/buttons.bootstrap4.min.css">

    <style>
        body { background-color: #f7f9fc; font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif; }
        .content > div { width: 100% !important; padding-left: 0 !important; padding-right: 0 !important; max-width: 100% !important; }
        .card-white { background: #ffffff; border: 1px solid #e3e6f0; border-radius: 6px; padding: 1rem 1.5rem 2rem 1.5rem; box-shadow: 0 0.15rem 1.75rem rgba(58,59,69,0.1); margin-top: 15px; }
        .card-header-custom { font-weight: 600; font-size: 1.1rem; padding-bottom: 10px; border-bottom: 1px solid #dee2e6; margin-bottom: 1rem; color: #000; }
        .page-title { font-weight: 700; font-size: 1.6rem; margin-bottom: 10px; color: #212529; }
        table.dataTable thead th { background-color: #f8f9fc; font-weight: 600; border-bottom: 2px solid #dee2e6; color: #000; text-align: center; }
        table.dataTable tbody td { text-align: center; }
 
        .breadcrumb { background: transparent; padding-left: 0; margin-bottom: 0px; }
        .breadcrumb-item + .breadcrumb-item::before { content: ">"; color: #6c757d; }
    </style>
</head>
<body class="hold-transition sidebar-mini layout-fixed">
<div class="wrapper">

    <!-- Navbar -->
    <jsp:include page="/navbar.jsp" />

    <!-- Sidebar -->
    <jsp:include page="/sidebar.jsp" />

    <!-- Content Wrapper -->
    <div class="content-wrapper">

        <!-- Content Header -->
        <section class="content-header">
            <div class="container-fluid">
                <nav aria-label="breadcrumb" style="padding-left: 0;">
                    <h1 class="page-title">Generated Letter List</h1>
                   
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="#">Employee</a></li>
                        <li class="breadcrumb-item active" aria-current="page">Generated Letter List</li>
                    </ol>
                </nav>
            </div>
        </section>

        <!-- Main content -->
        <section class="content">
            <div>
                <!-- White card -->
                <div class="card-white">
                    <div class="card-header-custom">
                        Generated Letter List
                    </div>

                    <table id="docTable" class="table table-striped table-bordered" style="width:100%">
                        <thead>
                        <tr>
                            <th>Upload ID</th>
                            <th>Document Name</th>
                            <th>Attachment</th>
                            <th>Action</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="li"  items="${adminList}">
                            <tr>
                                <td>${li.uploadId}</td>
                                <td>${li.documentName}</td>
                                <td>${li.uploadFile}</td>
                                <td class="action-icons">
    <!-- View -->
    <a href="viewAdminDoc?uploadId=${li.uploadId}" target="_blank">
        <button class="btn btn-sm btn-info">
            <i class="fas fa-eye"></i> View
        </button>
    </a>

    <!-- Download -->
    <a href="downloadAdminDoc?uploadId=${li.uploadId}">
        <button class="btn btn-sm btn-success">
            <i class="fas fa-download"></i> Download
        </button>
    </a>


</td>

                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </section>
    </div>

    <!-- Footer -->
    <jsp:include page="/footer.jsp" />

</div>

<!-- jQuery -->
<script src="plugins/jquery/jquery.min.js"></script>
<script src="plugins/jquery-ui/jquery-ui.min.js"></script>
<script>
  $.widget.bridge('uibutton', $.ui.button)
</script>
<script src="plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="plugins/datatables/jquery.dataTables.min.js"></script>
<script src="plugins/datatables-bs4/js/dataTables.bootstrap4.min.js"></script>
<script src="plugins/datatables-responsive/js/dataTables.responsive.min.js"></script>
<script src="plugins/datatables-responsive/js/responsive.bootstrap4.min.js"></script>
<script src="plugins/datatables-buttons/js/dataTables.buttons.min.js"></script>
<script src="plugins/datatables-buttons/js/buttons.bootstrap4.min.js"></script>
<script src="plugins/jszip/jszip.min.js"></script>
<script src="plugins/pdfmake/pdfmake.min.js"></script>
<script src="plugins/pdfmake/vfs_fonts.js"></script>
<script src="plugins/datatables-buttons/js/buttons.html5.min.js"></script>
<script src="plugins/datatables-buttons/js/buttons.print.min.js"></script>
<script src="plugins/datatables-buttons/js/buttons.colVis.min.js"></script>
<script src="dist/js/adminlte2167.js?v=3.2.0"></script>
<script src="dist/js/demo.js"></script>

<script>
  $(function () {
    $('#docTable').DataTable({
      "paging": true,
      "lengthChange": true,
      "searching": true,
      "ordering": true,
      "info": true,
      "autoWidth": false,
      "responsive": true,
      "pageLength": 5
    });
  });
</script>
</body>
</html>
