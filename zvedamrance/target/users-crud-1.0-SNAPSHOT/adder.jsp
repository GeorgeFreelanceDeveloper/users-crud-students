<%@ include file="/header.jsp" %>
            <!-- Begin Page Content -->

                <!-- Content Row -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <div class="d-sm-flex align-items-center justify-content-between mb-4">
                        <h1 class="h3 mb-0 text-gray-800">UserCRUD</h1>

                        <a href="/user/list" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i class="fas fa-download fa-sm text-white-50"></i>User list
                        </a>
                    </div>
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">Add user</h6>
                        </div>
                        <div class="card-body">
                            <form method="post">
                                <div class="form-group">
                                    <label for="userName">Username</label>
                                    <input name="userName" type="text" class="form-control" id="userName" placeholder="Username">
                                </div>
                                <div class="form-group">
                                    <label for="userEmail">Email</label>
                                    <input name="userEmail" type="email" class="form-control" id="userEmail" placeholder="Email">
                                </div>
                                <div class="form-group">
                                    <label for="userPassword">Password</label>
                                    <input name="userPassword" type="password" class="form-control" id="userPassword" placeholder="Password">
                                </div>

                                <button type="submit" class="btn btn-primary">Save</button>
                            </form>

                        </div>
                    </div>
                </div>
                <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->
<%@ include file="/footer.jsp" %>