<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 04.05.2021
  Time: 22:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="../add-contact" method="post">
    <div class="modal-header">
        <h4 class="modal-title">Add Contact</h4>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-hidden="true">

        </button>
    </div>
    <div class="modal-body">
        <div class="modal-body">
            <div class="form-group">
                <label> First Name</label>
                <input type="text" name="first_name" class="form-control" required>
            </div>
            <div class="form-group">
                <label>Second Name</label>
                <input type="text" name="second_name" class="form-control" required>
            </div>
            <div class="form-group">
                <label> Phone</label>
                <input type="text" name="phone" class="form-control" required>
            </div>
            <div class="form-group">
                <label>Name Company</label>
                <input type="text" name="name_company" class="form-control" required>
            </div>
            <div class="form-group">
                <label>Site</label>
                <input type="text" name="site" class="form-control" required>
            </div>
            <div class="form-group">
                <label>Country</label>
                <input type="text" name="country" class="form-control" required>
            </div>
            <div class="form-group">
                <label>City</label>
                <input type="text" name="city" class="form-control" required>
            </div>
            <div class="form-group">
                <label>Street</label>
                <input type="text" name="street" class="form-control" required>
            </div>
            <div class="form-group">
                <label>House Number</label>
                <input type="number" name="house_number" class="form-control" required>
            </div>
            <div class="form-group">
                <label>Role</label>
                <input type="text" name="role" class="form-control" required>
            </div>

        </div>
    </div>
    <div class="modal-footer">
        <input type="button" class="btn btn-danger" data-bs-dismiss="modal" value="close">
        <button type="submit" class="btn btn-success" data-bs-dismiss="modal" >Add</button>
    </div>
</form>

</body>
</html>
