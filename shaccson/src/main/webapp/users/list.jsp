<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ include file="/header.jsp" %>

<!-- Page Heading -->
<div class="d-sm-flex align-items-center justify-content-between mb-4">
  <h1 class="h3 mb-0 text-gray-800">User List</h1>
  <a href="/user/form" class="btn btn-sm btn-primary shadow-sm">
    <i class="fas fa-user-plus fa-sm text-white-50"></i> Add User
  </a>
</div>

<!-- User List Table -->
<table class="table table-bordered bg-white shadow-sm">
  <thead class="thead-dark">
  <tr>
    <th>ID</th>
    <th>Username</th>
    <th>Email</th>
    <th>Actions</th>
  </tr>
  </thead>
  <tbody>
  <c:choose>
    <c:when test="${not empty users}">
      <c:forEach var="user" items="${users}">
        <tr>
          <td>${user.id}</td>
          <td>${user.username}</td>
          <td>${user.email}</td>
          <td>
            <a href="/user/show?id=${user.id}" class="btn btn-info btn-sm">Show</a>
            <a href="/user/form?id=${user.id}" class="btn btn-warning btn-sm">Edit</a>
            <a href="/user/delete?id=${user.id}" class="btn btn-danger btn-sm"
               onclick="return confirm('Are you sure you want to delete ${user.username}?');">
              Delete
            </a>
          </td>
        </tr>
      </c:forEach>
    </c:when>
    <c:otherwise>
      <tr>
        <td colspan="4" class="text-center">No users found.</td>
      </tr>
    </c:otherwise>
  </c:choose>
  </tbody>
</table>

<%@ include file="/footer.jsp" %>
