<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="img/favicon-pepsi.png" rel="shortcut icon" type="image/x-icon" />
        <title>Что-то пошло не так</title>
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
        <link href="css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="css/AdminLTE.min.css" rel="stylesheet" type="text/css">
        <link href="css/blue.css" rel="stylesheet" type="text/css">
    </head>
    <body style="background-color: #f8f8f6;">
        <div class="row" style="margin-top: 15%;">
            <div class="col-md-4"></div>
            <div class="col-md-4">
                <div class="info-box">
                    <span class="info-box-icon bg-yellow">500</span>
                    <div class="info-box-content">
                        <span class="info-box-number">Ой, что-то пошло не так!</span>
                        <span class="">Вы можете вернуться <a onclick="history.back(); return false;" href="#">на предыдущую страницу</a></span>
                    </div>
                </div>
            </div>
            <div class="col-md-4"></div>
        </div>
    </body>
</html>
