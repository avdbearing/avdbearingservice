<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="as" class="com.services.AddressService"/>
<!doctype html>
<html lang="en">
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">


    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">

    <title>Client information</title>
</head>
<body>
<div class="container-xl  ">
    <div class="table-responsive">
        <div class="table bg-light   justify-content-center mt-5">
            <div class=" card-title p-3 mb-2 bg-secondary text-white rounded-2 border-3 ">
                <div class="row">
                    <div class="col-sm-6">
                        <h2> Client Information</h2>

                    </div>

                    <div class="col-sm-6  text-md-end  ">


                        <a href="#addModal" class="add" data-bs-tittle="modal">
                            <i class="icon" data-bs-toggle="tooltip" title data-original-tittle="add">
                                <button type="button" class="btn btn-success " data-bs-toggle="modal"
                                        data-bs-target="#addModal">Add
                                    Client
                                </button>
                            </i>
                        </a>

                        <a href="#deleteModal" class="delete" data-bs-toggle="modal">
                            <i class="icon" data-bs-toggle="tooltip" title data-original-tittle="delete">
                                <button type="button" class="btn btn-danger " data-bs-toggle="modal"
                                        data-bs-target="#deleteModal"
                                >Delete Client
                                </button>
                            </i>
                        </a>


                    </div>
                </div>
            </div>
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Country</th>
                    <th scope="col">City</th>
                    <th scope="col">Street</th>
                    <th scope="col">House Number</th>
                    <th scope="col">Create</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${as.all}" var="address">
                    <tr>
                        <th scope="row">${address.id}</th>
                        <td>${address.country}</td>
                        <td>${address.city}</td>
                        <td>${address.street}</td>
                        <td>${address.house_number}</td>
                        <td>${address.created}</td>
                    </tr>
                </c:forEach>


                </tbody>
            </table>


            <div class="page-link bg-secondary text-white  rounded-2  ">
                <div class="row">
                    <div class="col-sm-6">
                        <div class="clearfix text-md-start mt-1">
                            show <b>1</b> page <b>out of 25</b>
                        </div>
                    </div>
                    <div class="col-sm-6">
                        <nav aria-label="Page navigation example">
                            <ul class="pagination justify-content-end">
                                <li class="page-item ">
                                    <a class="page-link text-dark" href="#" tabindex="-1"
                                       aria-disabled="true">Previous</a>
                                </li>
                                <li class="page-item text-dark"><a class="page-link text-dark" href="#">1</a></li>
                                <li class="page-item text-dark"><a class="page-link text-dark" href="#">2</a></li>
                                <li class="page-item text-dark"><a class="page-link text-dark" href="#">3</a></li>
                                <li class="page-item text-dark">
                                    <a class="page-link text-dark" href="#">Next</a>
                                </li>
                            </ul>
                        </nav>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div id="editModal" class="modal fade" style="display: none" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <form>

                <div class="modal-header">
                    <h4 class="modal-title">Edit Client</h4>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-hidden="true"></button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label>New Name</label>
                        <input type="text" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label>New Email</label>
                        <input type="email" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label>New Phone</label>
                        <input type="text" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label>New Address</label>
                        <textarea class="form-control" required></textarea>
                    </div>
                    <div class="form-group">
                        <label>New Password</label>
                        <input type="text" class="form-control" required>
                    </div>

                </div>
                <div class="modal-footer">
                    <input type="button" class="btn btn-danger" data-bs-dismiss="modal" value="Cancel">
                    <input type="submit" class="btn btn-success" value="save">
                </div>
            </form>
        </div>
    </div>
</div>
<div id="deleteModal" class="modal fade" style="display: none" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <form>
                <div class="modal-header">
                    <h4 class="modal-title">Delete Client</h4>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-hidden="true">

                    </button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label>Enter Email</label>
                        <input type="text" class="form-control" required>
                    </div>

                </div>
                <div class="modal-footer">
                    <input type="button" class="btn btn-secondary" data-bs-dismiss="modal" value="close">
                    <input type="button" class="btn btn-danger" data-bs-dismiss="modal" value="delete client">
                </div>
            </form>

        </div>

    </div>
</div>
<div id="addModal" class="modal fade" style="display:none" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <form>
                <div class="modal-header">
                    <h4 class="modal-title">Add Client</h4>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-hidden="true">

                    </button>
                </div>
                <div class="modal-body">
                    <div class="modal-body">
                        <div class="form-group">
                            <label> Email</label>
                            <input type="text" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <label>Password</label>
                            <input type="text" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <label> Password</label>
                            <input type="text" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <label>Name</label>
                            <input type="text" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <label>Phone</label>
                            <input type="text" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <label>Address</label>
                            <input type="text" class="form-control" required>
                        </div>

                    </div>
                </div>
                <div class="modal-footer">
                    <input type="button" class="btn btn-danger" data-bs-dismiss="modal" value="close">
                    <input type="button" class="btn btn-success" data-bs-dismiss="modal" value="add client">
                </div>
            </form>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf"
        crossorigin="anonymous"></script>


</body>
</html>