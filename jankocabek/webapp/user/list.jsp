<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Dashboard Main Page</title>
    <!-- Custom fonts for this template-->
    <link href="/theme/vendor/fontawesome-free/css/all.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
          rel="stylesheet">
    <!-- Custom styles for this template-->
    <link href="/theme/css/sb-admin-2.min.css" rel="stylesheet">
    <link href="/theme/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">


</head>

<body id="page-top">

<!-- Page Wrapper -->
<div id="wrapper">

    <!-- Sidebar -->
    <%@ include file="partials/sidebar.jspf" %>
    <!-- End of Sidebar -->

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">
        <!-- Main Content -->
        <div id="content">
            <!-- Topbar -->
            <%@ include file="partials/topbar.jspf" %>
            <!-- End of Topbar -->

            <!-- Begin Page Content -->
            <div class="container-fluid">

                <!-- Page Heading -->
                <div class="d-sm-flex align-items-center justify-content-between mb-4">
                    <h1 class="h3 mb-0 text-gray-800">UserCRUD</h1>
                </div>
                <!-- User Table -->
                <div class="card border-left-primary shadow rounded ">
                    <div class="card-header  py-3">
                        <h6 class="m-0 font-weight-bold text-primary">Users Data</h6>
                    </div>
                    <div class="card-body">
                        <div class="table-responsive  ">
                            <table id="dataTable" class="table table-bordered ">
                                <thead>
                                <tr>
                                    <th>id</th>
                                    <th>userName</th>
                                    <th>email</th>
                                    <th>Tools</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="user" items="${listOfUsers}">
                                    <tr>
                                        <td>${user.id}</td>
                                        <td>${user.userName}</td>
                                        <td>${user.email}</td>
                                        <td>
                                            <a href="/user/edit?userId=${user.id}">edit</a>
                                            <a href="#" data-toggle="modal" data-target="#deleteUserModal" data-id="${user.id}" data-name="${user.userName}">delete</a>
                                            <a href="/user/show?userId=${user.id}">show</a>

                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>

                        </div>
                    </div>
                </div>
            </div>
            <!-- /.container-fluid -->
        </div>
        <!-- End of Main Content -->
        <!-- Footer -->
        <%@ include file="partials/footer.jspf" %>
        <!-- End of Footer -->
    </div>
    <!-- End of Content Wrapper -->
</div>
<!-- End of Page Wrapper -->

<!-- Scroll to Top Button-->
<a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
</a>

<!-- Logout Modal-->
<%@include file="partials/modal/modalLogOut.jspf" %>
<%-- delete user confirmation modal--%>
<jsp:include page="partials/modal/deleteUserConfirmModal.jspf" flush="true"/>


<!-- Bootstrap core JavaScript-->
<script src="/theme/vendor/jquery/jquery.min.js "></script>
<script src="/theme/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script src="/theme/vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Custom scripts for all pages-->
<script src="/theme/js/sb-admin-2.min.js"></script>

<!-- Page level plugins -->
<script src="/theme/vendor/datatables/jquery.dataTables.min.js"></script>
<script src="/theme/vendor/datatables/dataTables.bootstrap4.min.js"></script>

<!-- Page level custom scripts -->
<!-- javascript table plugin -->
<script>
    $(document).ready(function () {
        $('#dataTable').DataTable();
    });
</script>

<%--script for confirmation of delete of user --%>
<%-- script created with help of AI --%>
<script>
    $('#deleteUserModal').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget); // Button that triggered the modal
        var userId = button.data('id'); // Get data-id value
        var userName = button.data('name'); // Get data-name value
        var modal = $(this);
        modal.find('#modalUserId').text(userId);
        modal.find('#modalUserName').text(userName);
        modal.find('#modalIntId').val(userId);
    });
</script>
<%--end of custom scripts--%>
</body>

</html>