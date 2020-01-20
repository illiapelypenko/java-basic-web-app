<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Car</title>
    <link href="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css" rel="stylesheet">
    <link href="http://netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="../bootstrap.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <form method="POST" action='CarController?action=insert' name="frmAddCar" role="form">
        <div class="form-group">
            <label for="carId">
                id: <input class="form-control" type="number" id="carId" name="carId" value="<c:out value="${car.carId}"/>"/>
            </label>
        </div>
        <div class="form-group">
            <label for="manufacturerName">
                Manufacturer Name:<input class="form-control" type="text" id="manufacturerName" name="manufacturerName" value="<c:out value="${car.manufacturerName}"/>"/>
            </label>
        </div>
        <div class="form-group">
            <label for="modelName">
                Model Name:<input class="form-control" type="text" id="modelName" name="modelName" value="<c:out value="${car.modelName}"/>"/>
            </label>
        </div>
        <input type="submit" value="Submit" class="btn btn-info" />
    </form>
</div>
<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
</body>
</html>