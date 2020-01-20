<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>

<html lang="en">
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1, maximum-scale=1" name="viewport">
    <title>List</title>

    <link href="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css" rel="stylesheet">
    <link href="http://netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="bootstrap.css" rel="stylesheet">
</head>
<body>
<div class="wrap">
    <section>
        <div class="container">
            <h2>Addresses</h2>
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>
                        #
                    </th>
                    <th>
                        Address's Name
                    </th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${addresses}" var="address">
                    <tr>
                        <td>
                            <c:out value="${address.addressId}"/>
                        </td>
                        <td>
                            <c:out value="${address.addressName}"/>
                        </td>
                        <td><a href="AddressController?action=edit&addressId=<c:out value="${address.addressId}"/>">Update</a></td>
                        <td><a href="AddressController?action=delete&addressId=<c:out value="${address.addressId}"/>">Delete</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <a href="AddressController?action=insert" role="button" class="btn btn-info btn-lg" data-toggle="modal">Add new address</a>
        </div>
    </section>
    <section>
        <div class="container">
            <h2>Carshowroom</h2>
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>
                        #
                    </th>
                    <th>
                        Address's Id
                    </th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${showrooms}" var="showroom">
                    <tr>
                        <td>
                            <c:out value="${showroom.showroomId}"/>
                        </td>
                        <td>
                            <c:out value="${showroom.addressId}"/>
                        </td>
                        <td><a href="ShowroomController?action=edit&showroomId=<c:out value="${showroom.showroomId}"/>">Update</a></td>
                        <td><a href="ShowroomController?action=delete&showroomId=<c:out value="${showroom.showroomId}"/>">Delete</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <a href="ShowroomController?action=insert" role="button" class="btn btn-info btn-lg" data-toggle="modal">Add new showroom</a>
        </div>
    </section>
    <section>
        <div class="container">
            <h2>Sellers</h2>
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>
                        #
                    </th>
                    <th>
                        Seller's first name
                    </th>
                    <th>
                        Seller's last name
                    </th>
                    <th>
                        Showroom'id
                    </th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${sellers}" var="seller">
                    <tr>
                        <td>
                            <c:out value="${seller.sellerId}"/>
                        </td>
                        <td>
                            <c:out value="${seller.firstName}"/>
                        </td>
                        <td>
                            <c:out value="${seller.lastName}"/>
                        </td>
                        <td>
                            <c:out value="${seller.showroomId}"/>
                        </td>
                        <td><a href="SellerController?action=edit&sellerId=<c:out value="${seller.sellerId}"/>">Update</a></td>
                        <td><a href="SellerController?action=delete&sellerId=<c:out value="${seller.sellerId}"/>">Delete</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <a href="SellerController?action=insert" role="button" class="btn btn-info btn-lg" data-toggle="modal">Add new seller</a>
        </div>
    </section>
    <section>
        <div class="container">
            <h2>Customers</h2>
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>
                        #
                    </th>
                    <th>
                        Customers's first name
                    </th>
                    <th>
                        Customers's last name
                    </th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${customers}" var="customer">
                    <tr>
                        <td>
                            <c:out value="${customer.customerId}"/>
                        </td>
                        <td>
                            <c:out value="${customer.firstName}"/>
                        </td>
                        <td>
                            <c:out value="${customer.lastName}"/>
                        </td>
                        <td><a href="CustomerController?action=edit&customerId=<c:out value="${customer.customerId}"/>">Update</a></td>
                        <td><a href="CustomerController?action=delete&customerId=<c:out value="${customer.customerId}"/>">Delete</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <a href="CustomerController?action=insert" role="button" class="btn btn-info btn-lg" data-toggle="modal">Add new customer</a>
        </div>
    </section>
    <section>
        <div class="container">
            <h2>Cars</h2>
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>
                        #
                    </th>
                    <th>
                        Manufacturer's name
                    </th>
                    <th>
                        Model's name
                    </th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${cars}" var="car">
                    <tr>
                        <td>
                            <c:out value="${car.carId}"/>
                        </td>
                        <td>
                            <c:out value="${car.manufacturerName}"/>
                        </td>
                        <td>
                            <c:out value="${car.modelName}"/>
                        </td>
                        <td><a href="CarController?action=edit&carId=<c:out value="${car.carId}"/>">Update</a></td>
                        <td><a href="CarController?action=delete&carId=<c:out value="${car.carId}"/>">Delete</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <a href="CarController?action=insert" role="button" class="btn btn-info btn-lg" data-toggle="modal">Add new car</a>
        </div>
    </section>
    <section>
        <div class="container">
            <h2>Sells</h2>
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>
                        #
                    </th>
                    <th>
                        Seller's Id
                    </th>
                    <th>
                        Showroom's Id
                    </th>
                    <th>
                        Car's Id
                    </th>
                    <th>
                        Customer's Id
                    </th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${sells}" var="sell">
                    <tr>
                        <td>
                            <c:out value="${sell.sellId}"/>
                        </td>
                        <td>
                            <c:out value="${sell.sellerId}"/>
                        </td>
                        <td>
                            <c:out value="${sell.showroomId}"/>
                        </td>
                        <td>
                            <c:out value="${sell.carId}"/>
                        </td>
                        <td>
                            <c:out value="${sell.customerId}"/>
                        </td>
                        <td><a href="SellController?action=edit&sellId=<c:out value="${sell.sellId}"/>">Update</a></td>
                        <td><a href="SellController?action=delete&sellId=<c:out value="${sell.sellId}"/>">Delete</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <a href="SellController?action=insert" role="button" class="btn btn-info btn-lg" data-toggle="modal">Add new car</a>
        </div>
    </section>
</div>

<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>

</body>
</html>