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

    <title>Login</title>

    <!-- Custom fonts for this template-->
    <link href="/theme/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="/theme/css/sb-admin-2.min.css" rel="stylesheet">

</head>

<body class="bg-gradient-primary">

<div class="container">

    <!-- Outer Row -->
    <div class="row justify-content-center ">

        <div class="col-xl-6 col-lg-8 col-md-10">

            <div class="card o-hidden border-0 shadow-lg my-5 mx-auto" style=" max-width: 500px;">
                <div class="card-body p-0 ">
                    <!-- Nested Row within Card Body -->
                    <div class="row d-flex justify-content-center ">

                        <div class="col-lg-12 ">
                            <div class="p-5 ">
                                <div class="text-center">
                                    <h1 class="h4 text-gray-900 mb-4">Welcome Back!</h1>
                                </div>
                                <form class="user" method="POST" action="/login">
                                    <div class="form-group">
                                        <input type="text" class="form-control form-control-user"
                                               id="userName"
                                               placeholder="User Name" name="userName">
                                    </div>
                                    <div class="form-group">
                                        <input type="password" class="form-control form-control-user"
                                               id="password" placeholder="Password" name='password'>
                                    </div>
                                    <button type="submit" class="btn btn-primary btn-user btn-block  font-weight-bold"
                                            style="font-size: 1rem !important;">
                                        Login
                                    </button>
                                </form>
                                <hr>

                                <c:if test="${not empty loginError}">
                                    <p class="text-danger"><strong>${loginError}</strong></p>
                                </c:if>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>

    </div>

</div>

<!-- Bootstrap core JavaScript-->
<script src="/theme/vendor/jquery/jquery.min.js"></script>
<script src="/theme/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script src="/theme/vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Custom scripts for all pages-->
<script src="/theme/js/sb-admin-2.min.js"></script>

</body>

</html>