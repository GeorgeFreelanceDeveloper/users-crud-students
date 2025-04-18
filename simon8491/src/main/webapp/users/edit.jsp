<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>SB Admin 2 - Dashboard</title>
    <link href="<c:url value="/theme/vendor/fontawesome-free/css/all.min.css"/>" rel="stylesheet" type="text/css">
    <link href="<c:url value="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"/>" rel="stylesheet">
    <link href="<c:url value="/theme/css/sb-admin-2.css"/>" rel="stylesheet">
</head>
<body id="page-top">
<div id="wrapper">
    <!-- Sidebar -->
    <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">
        <!-- Sidebar - Brand -->
        <a class="sidebar-brand d-flex align-items-center justify-content-center" href="edit.jsp">
            <div class="sidebar-brand-icon rotate-n-15">
                <i class="fas fa-laugh-wink"></i>
            </div>
            <div class="sidebar-brand-text mx-3">SB Admin <sup>2</sup></div>
        </a>
        <!-- Divider -->
        <hr class="sidebar-divider my-0">
        <li class="nav-item active">
            <a class="nav-link" href="edit.jsp">
                <i class="fas fa-fw fa-tachometer-alt"></i>
                <span>Dashboard</span>
            </a>
        </li>
        <!-- Sidebar Toggler (Sidebar) -->
        <div class="text-center d-none d-md-inline">
            <button class="rounded-circle border-0" id="sidebarToggle"></button>
        </div>
    </ul>
    <div id="content-wrapper" class="d-flex flex-column">
        <div id="content">
            <%@ include file="header.jsp" %>
            <div class="container-fluid">
                <div class="d-sm-flex align-items-center justify-content-between mb-4">
                    <h1 class="h3 mb-0 text-gray-800">UsersCRUD</h1>
                    <a href="<c:url value="/user/list"/>" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
                        <i class="fas fa-sm text-white-50"></i>User list
                    </a>
                </div>
                <div class="card shadow mb-4">
                    <div class="card-header py-3">
                        <h6 class="m-0 font-weight-bold text-primary">Edit user</h6>
                    </div>
                    <div class="card-body">
                        <form method="post">
                            <input type="hidden" name="id" value="${user.id}"/>
                            <div class="form-group">
                                <label for="userName">Username</label>
                                <input value="${user.userName}" name="userName" type="text" class="form-control" id="userName" placeholder="Username" required>
                            </div>
                            <div class="form-group">
                                <label for="userEmail">Email</label>
                                <input value="${user.email}" type="email" name="email" id="userEmail" class="form-control" placeholder="Email" required>
                            </div>
                            <div class="form-group">
                                <label for="userPassword">Password</label>
                                <input value="${user.password}" type="password" name="password" id="userPassword" class="form-control" placeholder="Password" required>
                            </div>
                            <button type="submit" class="btn btn-primary">Edit</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%@ include file="footer.jsp"%>