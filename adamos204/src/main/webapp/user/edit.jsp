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
            <h6 class="m-0 font-weight-bold text-primary">Edit user</h6>
        </div>
        <div class="card-body">
            <form method="post" action="edit">
                <input type="hidden" name="id" value="${user.id}"/>
                <div class="form-group">
                    <label for="userName">Username</label>
                    <input value="${user.userName}" type="text" name="userName" id="userName" class="form-control" placeholder="Username" required>
                </div>
                <div class="form-group">
                    <label for="userEmail">Email</label>
                    <input value="${user.email}" type="email" name="userEmail" id="userEmail" class="form-control" placeholder="Email" required>
                </div>
                <div class="form-group">
                    <label for="userPassword">Password</label>
                    <input type="password" name="userPassword" id="userPassword" class="form-control" placeholder="Password">
                </div>

                <button type="submit" class="btn btn-primary">Edit user</button>
            </form>

        </div>
    </div>
</div>
<%@ include file="/user/footer.jsp" %>
