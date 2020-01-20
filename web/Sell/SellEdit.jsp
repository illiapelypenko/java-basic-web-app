<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Sell</title>
    <link href="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css" rel="stylesheet">
    <link href="http://netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="../bootstrap.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <form method="POST" action='SellController?action=edit' name="frmAddSell" role="form">
        <div class="form-group" style="display: none">
            <label for="sellId">
                Sell id: <input class="form-control" type="number" id="sellId" name="sellId" value="<c:out value="${sell.sellId}"/>" />
            </label>
        </div>
        <div class="form-group">
            <label for="sellerId">
                Seller id:<input class="form-control" type="text" id="sellerId" name="sellerId" value="<c:out value="${sell.sellerId}" />" />
            </label>
        </div>
        <div class="form-group">
            <label for="showroomId">
                Showroom id:<input class="form-control" type="text" id="showroomId" name="showroomId" value="<c:out value="${sell.showroomId}" />" />
            </label>
        </div>
        <div class="form-group">
            <label for="carId">
                Car id:<input class="form-control" type="text" id="carId" name="carId" value="<c:out value="${sell.carId}" />" />
            </label>
        </div>
        <div class="form-group">
            <label for="customerId">
                Customer id:<input class="form-control" type="text" id="customerId" name="customerId" value="<c:out value="${sell.customerId}" />" />
            </label>
        </div>
        <input type="submit" value="Submit" class="btn btn-info" />
    </form>
</div>
<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
</body>
</html>