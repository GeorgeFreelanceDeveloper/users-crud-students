<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/header.jsp" %>
<!-- Page Heading -->
<h1 class="h3 mb-3 text-gray-800">User Details</h1>
<!-- User Details -->
<table class="table table-bordered bg-white shadow-sm w-50">
    <thead class="thead-light">
    <tr>
        <th colspan="2" class="text-center">User Information</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <th class="text-left" style="width: 30%;">ID:</th>
        <td>${user.id}</td>
    </tr>
    <tr>
        <th class="text-left">Username:</th>
        <td>${user.userName}</td>
    </tr>
    <tr>
        <th class="text-left">Email:</th>
        <td>${user.email}</td>
    </tr>
    </tbody>
</table>
<div class="mt-3">
    <a href="/user/list" class="btn btn-secondary px-4">Back to User List</a>
</div>
<%@ include file="/footer.jsp" %>