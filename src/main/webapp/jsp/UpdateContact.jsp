<%@ page import="com.domain.Contact" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="us" class="com.services.ContactService"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">

</head>
<body>
<%
    Contact currentContact = (Contact) request.getAttribute("current-contact");
%>


<div class="modal-dialog">
    <div class="modal-content">

        <form action="../update-contact" method="post">

            <div class="modal-header">
                <h4 class="modal-title">Edit Contact</h4>
                <button type="button" class="btn-close" aria-hidden="true"></button>
            </div>
            <div class="modal-body">

                <input type="number" name="contact_id" value="<%=currentContact.getId()%>"
                       class="form-control" hidden="hidden">
                <input type="number" name="address_id" value="<%=currentContact.getAddress().getId()%>"
                       class="form-control" hidden="hidden">

                <div class="form-group">
                    <label> First Name</label>
                    <input type="text" name="first_name" value="<%=currentContact.getFirst_name()%>"
                           class="form-control"
                           required>
                </div>
                <div class="form-group">
                    <label>Second Name</label>
                    <input type="text" name="second_name" value="<%=currentContact.getSecond_name()%>"
                           class="form-control" required>
                </div>
                <div class="form-group">
                    <label> Phone</label>
                    <input type="text" name="phone" value="<%=currentContact.getPhone()%>"
                           class="form-control"
                           required>
                </div>
                <div class="form-group">
                    <label>Name Company</label>
                    <input type="text" name="name_company"
                           value="<%=currentContact.getName_company()%>"
                           class="form-control" required>
                </div>
                <div class="form-group">
                    <label>Site</label>
                    <input type="text" name="site" value="<%=currentContact.getSite()%>"
                           class="form-control"
                           required>
                </div>
                <div class="form-group">
                    <label>Country</label>
                    <input type="text" name="country"
                           value="<%=currentContact.getAddress().getCountry()%>"
                           class="form-control" required>
                </div>
                <div class="form-group">
                    <label>City</label>
                    <input type="text" name="city" value="<%=currentContact.getAddress().getCity()%>"
                           class="form-control" required>
                </div>
                <div class="form-group">
                    <label>Street</label>
                    <input type="text" name="street"
                           value="<%=currentContact.getAddress().getStreet()%>"
                           class="form-control" required>
                </div>
                <div class="form-group">
                    <label>House Number</label>
                    <input type="text" name="house_number"
                           value="<%=currentContact.getAddress().getHouse_number()%>"
                           class="form-control" required>
                </div>
                <div class="form-group">
                    <label>Role</label>
                    <input type="text" name="role_type" value="<%=currentContact.getRole_type()%>"
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
