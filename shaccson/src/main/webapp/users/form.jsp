<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ include file="/header.jsp" %>

<!-- Page Heading -->
<h1 class="h3 mb-3 text-gray-800">
    <c:choose>
        <c:when test="${user != null}">Edit User</c:when>
        <c:otherwise>Add New User</c:otherwise>
    </c:choose>
</h1>

<!-- User Form -->
<form method="post" action="/user/form">
    <c:if test="${user != null}">
        <input type="hidden" name="id" value="${user.id}" />
    </c:if>

    <table class="table table-bordered bg-white shadow-sm w-50">
        <thead class="thead-dark">
        <tr>
            <th colspan="2" class="text-center">User Information</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <th class="text-left" style="width: 30%;">Username:</th>
            <td><input value="${user.username}" name="username" type="text" class="form-control" required/></td>
        </tr>
        <tr>
            <th class="text-left">Email:</th>
            <td><input value="${user.email}" name="email" type="email" class="form-control" required/></td>
        </tr>

        <c:if test="${user != null}">
            <tr>
                <th class="text-left">Change Password?</th>
                <td>
                    <div class="d-flex align-items-center" style="margin-left: 20px;">
                        <input type="checkbox" class="form-check-input mr-2" id="changePasswordCheckbox" style="margin-top: -0.2rem;">
                        <label class="form-check-label" for="changePasswordCheckbox">Enable Password Change</label>
                    </div>
                </td>
            </tr>
        </c:if>

        <tr id="passwordField" <c:if test="${user != null}">style="display: none;"</c:if>>
            <th class="text-left">
                <c:choose>
                    <c:when test="${user != null}">New Password:</c:when>
                    <c:otherwise>Password:</c:otherwise>
                </c:choose>
            </th>
            <td><input name="password" type="password" class="form-control"
                       <c:if test="${user == null}">required</c:if>/></td>
        </tr>
        </tbody>
    </table>

    <div class="mt-3">
        <button type="submit" class="btn btn-success px-4">
            <c:choose>
                <c:when test="${user != null}">Update User</c:when>
                <c:otherwise>Add User</c:otherwise>
            </c:choose>
        </button>
        <a href="/user/list" class="btn btn-secondary px-4">Cancel</a>
    </div>
</form>

<script>
    document.getElementById("changePasswordCheckbox")?.addEventListener("change", function() {
        var passwordField = document.getElementById("passwordField");
        passwordField.style.display = this.checked ? "table-row" : "none";
    });
</script>

<%@ include file="/footer.jsp" %>
