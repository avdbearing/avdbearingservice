<%@ page import="com.domain.Part" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="us" class="com.services.ContactService"/>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">

</head>
<body>
<%
    Part currentPart = (Part) request.getAttribute("current-part");
%>


<div class="modal-dialog">
    <div class="modal-content">

        <form action="../update-part" method="post">

            <div class="modal-header">
                <h4 class="modal-title">Edit Part</h4>
                <button type="button" class="btn-close" aria-hidden="true"></button>
            </div>
            <div class="modal-body">

                <input type="number" name="part_id" value="<%=currentPart.getId()%>"
                       class="form-control" hidden="hidden">
                <input type="number" name="supplier_id" value="<%=currentPart.getSupplier().getId()%>"
                       class="form-control" hidden="hidden">
                <input type="number" name="size_id" value="<%=currentPart.getSize().getId()%>"
                       class="form-control" hidden="hidden">

                <div class="form-group">
                    <label> Article</label>
                    <input type="text" name="article" value="<%=currentPart.getArticle()%>"
                           class="form-control"
                           required>
                </div>
                <div class="form-group">
                    <label>Brand</label>
                    <input type="text" name="brand" value="<%=currentPart.getBrand()%>"
                           class="form-control" required>
                </div>
                <div class="form-group">
                    <label> Amount</label>
                    <input type="number" name="quantity" value="<%=currentPart.getQuantity()%>"
                           class="form-control"
                           required>
                </div>
                <div class="form-group">
                    <label>Description</label>
                    <input type="text" name="description"
                           value="<%=currentPart.getDescription()%>"
                           class="form-control" required>
                </div>
                <div class="form-group">
                    <label>Price</label>
                    <input type="text" name="price" value="<%=currentPart.getPrice()%>"
                           class="form-control"
                           required>
                </div>
                <div class="form-group">
                    <label>Type</label>
                    <input type="text" name="type" value="<%=currentPart.getType()%>"
                           class="form-control"
                           required>
                </div>
                <div class="form-group">
                    <label>Iner</label>
                    <input type="text" name="iner"
                           value="<%=currentPart.getSize().getIner()%>"
                           class="form-control" required>
                </div>
                <div class="form-group">
                    <label>Outer</label>
                    <input type="text" name="outer" value="<%=currentPart.getSize().getOuter()%>"
                           class="form-control" required>
                </div>
                <div class="form-group">
                    <label>Width</label>
                    <input type="text" name="width"
                           value="<%=currentPart.getSize().getWidth()%>"
                           class="form-control" required>
                </div>
                <div class="form-group">
                    <label>Supplier</label>
                    <input type="text" name="name_company"
                           value="<%=currentPart.getSupplier().getContact().getName_company()%>"
                           class="form-control" required>
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
