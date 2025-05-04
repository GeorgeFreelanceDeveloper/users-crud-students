<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/user/header.jsp" %>
<div class="container-fluid">

    <!-- Page Heading -->
    <a class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">UsersCRUD</h1>
        <a href="list" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i class="fas fa-download fa-sm text-white-50"></i> User list</a>
        <i class="fas fa-download fa-sm text-white-50"></i> User list</a>
</div>
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">User Information</h6>
        </div>
        <div class="card-body">
            <table class="table table-borderless">
                <tr>
                    <td><strong>ID</strong></td>
                    <td>${user.id}</td>
                </tr>
                <tr>
                    <td><strong>Username</strong></td>
                    <td>${user.userName}</td>
                </tr>
                <tr>
                    <td><strong>Email</strong></td>
                    <td>${user.email}</td>
                </tr>
            </table>
        </div>
    </div>
</div>
<%@ include file="/user/footer.jsp" %>
