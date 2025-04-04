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
    <div id="content-wrapper" class="d-flex flex-column ">
        <!-- Main Content -->
        <div id="content">
            <!-- Topbar -->
            <%@ include file="partials/topbar.jspf" %>
            <!-- End of Topbar -->

            <!-- Begin Page Content -->
            <div class="container-fluid d-flex  justify-content-center align-items-center">

                <!-- Page Heading -->

                <!-- User Card -->
                <div class="card border-left-primary shadow rounded">
                    <div class="card-header  py-3">
                        <h5 class="m-0 font-weight-bold text-primary">User</h5>
                    </div>
                    <div class="card-body">
                        <div class="text-center">
                            <div class="h4 text-gray-900 mb-4"> User Details</div>
                        </div>

                        <div class="table-responsive">
                            <table class="table table-bordered d-flex justify-content-center align-items-center ">
                                <tr>
                                    <th scope="row" class="text-primary">
                                        id
                                    </th>
                                    <td>
                                        ${user.id}
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row" class="text-primary">User name</th>
                                    <td>
                                        ${user.userName}
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row" class="text-primary">
                                        email
                                    </th>
                                    <td>
                                        ${user.email}
                                    </td>
                                </tr>
                            </table>
                        </div>
                        <div class="row">
                            <div class="col text-center">
                                <div class="">
                                    <a href="<c:url value="/main" />" class="btn btn-success btn-circle btn-lg">
                                        <i class="fas fa-check"></i>
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <%--       end of card body             --%>
                </div>
                <%--end of user card--%>
            </div>
            <!-- /.container-fluid -->
        </div>
        <!-- End of Main Content -->
        <!-- Footer -->
        <%@ include file="partials/footer.jspf" %>
        <!-- End of Footer -->
    </div>
    <%--end of content wrapper--%>
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