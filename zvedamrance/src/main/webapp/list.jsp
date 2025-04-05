<%@ include file="/header.jsp" %>
      <!-- Begin Page Content -->
      <div class="container-fluid">

        <!-- Page Heading -->
        <div class="d-sm-flex align-items-center justify-content-between mb-4">
          <h1 class="h3 mb-0 text-gray-800">UserCRUD</h1>

          <a href="/user/add" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i class="fas fa-download fa-sm text-white-50"></i>Add user
          </a>
        </div>
        <div class="card shadow mb-4">
          <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">User list</h6>
          </div>
          <div class="card-body">
            <div class="table-responsive">
        <table class="table">
          <thead>
          <tr>
            <th scope="col">Id</th>
            <th scope="col">User name</th>
            <th scope="col">Email</th>
            <th scope="col">Action</th>
          </tr>
          </thead>
          <tbody>
          <c:forEach var="user" items="${users}">
            <tr>
              <td>${user.id}</td>
              <td>${user.userName}</td>
              <td>${user.email}</td>
              <td>
                <a href='/user/delete?id=${user.id}'>Delete</a>
                <a href='/user/edit?id=${user.id}'>Edit</a>
                <a href='/user/show?id=${user.id}'>Show</a>
              <td>
            </tr>
          </c:forEach>
          </tbody>
        </table>
            </div>
          </div>
        </div>

        <!-- Content Row -->
        <div class="row">
        </div>
        <!-- /.container-fluid -->

      </div>
      <!-- End of Main Content -->
<%@ include file="/footer.jsp" %>
