<%@ include file="/header.jsp" %>
<!-- Begin Page Content -->
<div class="container-fluid">

    <!-- Page Heading -->
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">UserCRUD</h1>
        <a href="/user/add" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i class="fas fa-download fa-sm text-white-50"></i>Add user</a>
    </div>

    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">User details</h6>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table">
                    <tbody>
                    <tr>
                        <th scope="col">Id</th>
                        <td>${user.id}</td>
                    </tr>
                    <tr>
                        <th scope="col">User name</th>
                        <td>${user.userName}</td>
                    </tr>
                    <tr>
                        <th scope="col">Email</th>
                        <td>${user.email}</td>
                    </tr>
                    </tbody>
                </table>
                </div>
        </div>
    </div>
</div>
<%@ include file="/footer.jsp" %>

