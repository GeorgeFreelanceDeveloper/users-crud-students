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
    <!-- Javascript Table Plugin-->
    <%--        <link rel="stylesheet" href="https://cdn.datatables.net/2.2.2/css/dataTables.dataTables.css"/>--%>

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
            <div class="container-fluid d-flex justify-content-center align-items-center">

                <!-- Page Heading -->

                <!-- User Table -->
                <div class="card border-left-primary shadow rounded" style="width: 50%;">
                    <div class="card-header  py-3">
                        <h5 class="m-0 font-weight-bold text-primary">Edit User</h5>
                    </div>
                    <div class="card-body">
                        <div class="text-center">
                            <div class="h4 text-gray-900 mb-4"> User Details</div>
                        </div>

                        <c:url value="/user/edit" var="actionUrl"/>
                        <form method="POST" action="${actionUrl}" class="user">
                            <input type="hidden" name="id" value="${user.id}">
                            <div class="form-group ">
                                <input type="text" name="userName" value="${user.userName}"
                                       class="form-control form-control-user" required="required">
                            </div>
                            <div class="form-group ">
                                <input type="email" name="email" value="${user.email}"
                                       class="form-control form-control-user" required>
                            </div>
                            <div class="form-group ">
                                <input type="password" name="password"  placeholder="Omit if you don't want to change."
                                       class="form-control form-control-user">
                            </div>
                            <div class="row">
                                <div class="col">
                                    <button type="submit" class="btn btn-success btn-circle btn-lg">
                                        <i class="fas fa-check"></i>
                                    </button>
                                </div>
                                <div class="col d-flex justify-content-end">
                                    <a href="<c:url value="/main" />" class="btn btn-danger   btn-circle btn-lg">
                                        <i class="fas fa-share"></i>
                                    </a>
                                </div>
                            </div>
                        </form>
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

<%@include file="partials/modal/modalLogOut.jspf" %>

<!-- Bootstrap core JavaScript-->
<script src="/theme/vendor/jquery/jquery.min.js "></script>
<script src="/theme/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script src="/theme/vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Custom scripts for all pages-->
<script src="/theme/js/sb-admin-2.min.js"></script>


</body>

</html>

