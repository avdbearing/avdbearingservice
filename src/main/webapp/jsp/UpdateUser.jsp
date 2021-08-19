<%@ page import="com.domain.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="us" class="com.services.UserService"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">

</head>
<body>
<%
    User currentUser = (User) request.getAttribute("current-user");
%>


<div class="modal-dialog">
    <div class="modal-content">

        <form action="../update-user" method="post">

            <div class="modal-header">
                <h4 class="modal-title">Edit User</h4>
                <button type="button" class="btn-close" aria-hidden="true"></button>
            </div>
            <div class="modal-body">

                <input type="number" name="id" value="<%=currentUser.getId()%>" class="form-control" hidden="hidden">
                <input type="number" name="contact_id" value="<%=currentUser.getContact_id().getId()%>"
                       class="form-control" hidden="hidden">
                <input type="number" name="address_id" value="<%=currentUser.getContact_id().getAddress().getId()%>"
                       class="form-control" hidden="hidden">

                <div class="form-group">
                    <label> Email</label>
                    <input type="text" name="email" value="<%=currentUser.getEmail()%>" class="form-control"
                           required>
                </div>
                <div class="form-group">
                    <label> Role</label>
                    <input type="text" name="role" value="<%=currentUser.getRole()%>" class="form-control" required>
                </div>
                <div class="form-group">
                    <label> Password</label>
                    <input type="text" name="password" value="<%=currentUser.getPassword()%>" class="form-control"
                           required>
                </div>
                <div class="form-group">
                    <label> First Name</label>
                    <input type="text" name="first_name" value="<%=currentUser.getContact_id().getFirst_name()%>"
                           class="form-control"
                           required>
                </div>
                <div class="form-group">
                    <label>Second Name</label>
                    <input type="text" name="second_name" value="<%=currentUser.getContact_id().getSecond_name()%>"
                           class="form-control" required>
                </div>
                <div class="form-group">
                    <label> Phone</label>
                    <input type="text" name="phone" value="<%=currentUser.getContact_id().getPhone()%>"
                           class="form-control"
                           required>
                </div>
                <div class="form-group">
                    <label>Name Company</label>
                    <input type="text" name="name_company"
                           value="<%=currentUser.getContact_id().getName_company()%>"
                           class="form-control" required>
                </div>
                <div class="form-group">
                    <label>Site</label>
                    <input type="text" name="site" value="<%=currentUser.getContact_id().getSite()%>"
                           class="form-control"
                           required>
                </div>
                <div class="form-group">
                    <label>Country</label>
                    <input type="text" name="country"
                           value="<%=currentUser.getContact_id().getAddress().getCountry()%>"
                           class="form-control" required>
                </div>
                <div class="form-group">
                    <label>City</label>
                    <input type="text" name="city" value="<%=currentUser.getContact_id().getAddress().getCity()%>"
                           class="form-control" required>
                </div>
                <div class="form-group">
                    <label>Street</label>
                    <input type="text" name="street"
                           value="<%=currentUser.getContact_id().getAddress().getStreet()%>"
                           class="form-control" required>
                </div>
                <div class="form-group">
                    <label>House Number</label>
                    <input type="text" name="house_number"
                           value="<%=currentUser.getContact_id().getAddress().getHouse_number()%>"
                           class="form-control" required>
                </div>
                <div class="form-group">
                    <label>Role</label>
                    <input type="text" name="role_type" value="<%=currentUser.getContact_id().getRole_type()%>"
                           class="form-control"
                           required>
                </div>
            </div>
            <div class="modal-footer">
                <input type="button" class="btn btn-danger" value="Cancel">
                <button type="submit" class="btn btn-success"> save
                </button>
            </div>

        </form>
    </div>
</div>

</body>
</html>
