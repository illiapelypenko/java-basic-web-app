<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Seller</title>
    <link href="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css" rel="stylesheet">
    <link href="http://netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="../bootstrap.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <form method="POST" action='SellerController?action=insert' name="frmAddSeller" role="form">
        <div class="form-group">
            <label for="sellerId">
                id: <input class="form-control" type="number" id="sellerId" name="sellerId" value="<c:out value="${seller.sellerId}"/>"/>
            </label>
        </div>
        <div class="form-group">
            <label for="firstName">
                First Name:<input class="form-control" type="text" id="firstName" name="firstName" value="<c:out value="${seller.firstName}"/>"/>
            </label>
        </div>
        <div class="form-group">
            <label for="lastName">
                Last Name:<input class="form-control" type="text" id="lastName" name="lastName" value="<c:out value="${seller.lastName}"/>"/>
            </label>
        </div>
        <div class="form-group">
            <label for="showroomId">
                id: <input class="form-control" type="number" id="showroomId" name="showroomId" value="<c:out value="${seller.showroomId}"/>"/>
            </label>
        </div>
        <input type="submit" value="Submit" class="btn btn-info" />
    </form>
</div>
<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
</body>
</html>