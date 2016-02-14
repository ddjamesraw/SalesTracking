<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <link href="img/favicon-pepsi.png" rel="shortcut icon" type="image/x-icon" />
        <meta charset="UTF-8">
        <title>Учет продаж ювелирных товаров</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
        <link href="css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="css/ionicons.min.css" rel="stylesheet" type="text/css">
        <link href="css/AdminLTE.min.css" rel="stylesheet" type="text/css">
        <link href="css/skin-blue.min.css" rel="stylesheet" type="text/css">
        <link href="css/_all-skins.min.css" rel="stylesheet" type="text/css">
        <link href="css/style.css" rel="stylesheet" type="text/css">
    </head>
    <body class="skin-yellow-light" style="background-color: #f8f8f6;">

        <div class="wrapper">
            <header class="main-header">
                <a href="#" class="logo">
                  <span class="logo-mini"><b>JST</b></span>
                  <span class="logo-lg">JewelSalesTracking</span>
                </a>
                <nav class="navbar navbar-static-top">
                    <a href="#" class="sidebar-toggle">
                        Сервис учета и регистрации продаж ювелирных товаров
                    </a>
                    <div class="navbar-custom-menu">
                        <ul class="nav navbar-nav">
                            <li><a href="#">Авторизация</a></li>
                        </ul>
                  </div>
                </nav>
            </header>
            <aside class="main-sidebar">
                <section class="sidebar">
                    <ul class="sidebar-menu">
                        <li><a href="#"><i class="fa fa-circle-o text-red"></i> <span>Войдите в систему</span></a></li>
                    </ul>
                </section>
            </aside>
            <div class="content-wrapper">
                <section class="content">
                    <div class="box box-warning">
                        <div class="row">
                            <div class="col-md-3"></div>
                            <div class="col-md-6">
                                <form action="MainController" method="post">
                                    <%
                                    if(session.getAttribute("login") == null) {
                                    %>
                                        <div class="box-header">
                                            <p style="font-style: italic; text-align: center; font-size: smaller;">Введите учетные данные для начала работы</p>
                                        </div>
                                        <div class="box-body">
                                            <div class="form-group has-feedback">
                                              <input name="login" type="text" class="form-control" placeholder="Логин" required="true"/>
                                              <span class="glyphicon glyphicon-user form-control-feedback"></span>
                                            </div>
                                            <div class="form-group has-feedback">
                                              <input name="password" type="password" class="form-control" placeholder="Пароль" required="true"/>
                                              <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                                            </div> 
                                            <div class="form-group has-feedback">
                                                <input name="captcha" type="text" class="form-control" placeholder="Введите символы на картинке" required="true"/>
                                                <span class="glyphicon glyphicon-refresh form-control-feedback"></span><br>
                                                <center><img src="CaptchaServlet"></center>
                                            </div> 
                                            <c:if test="${not empty auth_error}">       
                                                <p style="font-style: italic; text-align: center; font-size: smaller; color: red;">
                                                    <c:out value="${auth_error}" /><br />
                                                </p>
                                            </c:if>
                                            <hr>
                                            <p style="font-style: italic; text-align: center; font-size: smaller;">Выберите тип используемого веб-сервиса</p>
                                            <div class="form-group has-feedback">
                                                <select class="form-control" name="serviceType">
                                                    <option value="rpc">RPC</option>
                                                    <option value="doc">Document</option>
                                                </select>
                                            </div>
                                            <div class="row">
                                              <div class="col-xs-3"></div>    
                                              <div class="col-xs-6">
                                                <button type="submit" class="btn btn-warning btn-block btn-flat">Войти</button>
                                              </div>
                                              <div class="col-xs-3"></div>    
                                            </div>
                                        </div>
                                    <% 
                                        } else {
                                            String serviceType = session.getAttribute("service_type").toString();
                                            response.sendRedirect(serviceType + ".jsp");
                                        } 
                                    %>
                                </form>
                            </div>
                            <div class="col-md-3"></div>
                        </div>      
                    </div>
            </section></div>
            <footer class="main-footer">
                <div class="pull-right hidden-xs">
                    Автор: Андриянец Дмитрий, гр.002321, 
                    <a href="http://distant.bsuir.by" target="_blanc">ФНиДО</a>,
                    <a href="http://bsuir.by" target="_blanc">БГУИР</a>, 
                    Минск, 2015
                </div>
                Использован шаблон <a href="https://almsaeedstudio.com/AdminLTE" target="_blanc">AdminLTE ©</a>
            </footer>
        </div>
        <script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <script type="text/javascript" src="js/fastclick.min.js"></script>
        <script type="text/javascript" src="js/app.min.js" ></script>
        <script type="text/javascript" src="js/demo.js"></script>
        <script src="js/icheck.min.js" type="text/javascript"></script>
        <script>
          $(function () {
            $('input').iCheck({
              checkboxClass: 'icheckbox_square-blue',
              radioClass: 'iradio_square-blue',
              increaseArea: '20%'
            });
          });
        </script>    
    </body>
</html>
