<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link href="img/favicon-pepsi.png" rel="shortcut icon" type="image/x-icon" >        
        <title>Учет продаж ювелирных товаров</title>
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
        <link href="css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="css/ionicons.min.css" rel="stylesheet" type="text/css">
        <link href="css/AdminLTE.min.css" rel="stylesheet" type="text/css">
        <link href="css/_all-skins.min.css" rel="stylesheet" type="text/css">
        <link href="css/bootstrap-timepicker.min.css" rel="stylesheet">
        <link href="css/_all-skins.min.css" rel="stylesheet" type="text/css">
        <style type="text/css">
            th {
              text-align: center;
             }
        </style>
    </head>
    <body class="skin-yellow-light sidebar-mini" style="background-color: #f8f8f6;">
        <%
            if(session.getAttribute("login") == null) {
                response.sendRedirect(request.getContextPath());
            }
        %>
        <div class="wrapper">
            <header class="main-header">
                <a href="#" class="logo">
                  <span class="logo-mini"><b>JST</b></span>
                  <span class="logo-lg">JewelSalesTracking</span>
                </a>
                <nav class="navbar navbar-static-top" role="navigation">
                  <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
                    <span class="sr-only">Toggle navigation</span>
                  </a>
                  <div class="navbar-custom-menu">
                    <ul class="nav navbar-nav">
                        <li><a href="#">RPC-ориентированное взаимодействие</a></li>
                    </ul>
                  </div>
                </nav>
            </header>
            <aside class="main-sidebar">
                <section class="sidebar">
                    <div class="user-panel">
                        <div class="pull-left image">
                          <img src="img/user2-160x160.jpg" class="img-circle" alt="User Image">
                        </div>
                        <div class="pull-left info">
                          <p><c:out value="${sessionScope.login}"></c:out></p>
                          <a href="#"><i class="fa fa-circle text-success"></i>Онлайн</a>
                        </div>
                    </div>
                    <ul class="sidebar-menu">
                        <li><a href="RPCController?action=logout"><i class="fa fa-sign-out"></i><span>Выйти</span></a></li>
                        <li class="treeview">
                            <a href="#">
                              <i class="fa fa-home"></i><span>Магазины</span>
                              <i class="fa fa-angle-left pull-right"></i>
                            </a>
                            <ul class="treeview-menu">
                                <li><a href="#" id="get_all_shops_content"><i class="fa fa-circle-o"></i>Все</a></li>
                                <li><a href="#" id="add_new_shop_content"><i class="fa fa-circle-o"></i>Добавить</a></li>
                            </ul>
                        </li>
                        <li class="treeview">
                            <a href="#">
                              <i class="fa fa-shopping-cart"></i><span>Товары</span>
                              <i class="fa fa-angle-left pull-right"></i>
                            </a>
                            <ul class="treeview-menu">
                                <li><a href="#" id="get_all_goods_content"><i class="fa fa-circle-o"></i>Все</a></li>
                                <li><a href="#" id="add_new_good_content"><i class="fa fa-circle-o"></i>Добавить</a></li>
                            </ul>
                        </li>
                        <li class="treeview">
                            <a href="#">
                              <i class="fa fa-list"></i><span>Категории товаров</span>
                              <i class="fa fa-angle-left pull-right"></i>
                            </a>
                            <ul class="treeview-menu">
                                <li><a href="#" id="get_all_categories_content"><i class="fa fa-circle-o"></i>Все</a></li>
                                <li><a href="#" id="add_new_category_content"><i class="fa fa-circle-o"></i>Добавить</a></li>
                            </ul>
                        </li>
                        <li class="treeview">
                            <a href="#">
                              <i class="fa fa-users"></i><span>Пользователи</span>
                              <i class="fa fa-angle-left pull-right"></i>
                            </a>
                            <ul class="treeview-menu">
                                <li><a href="#" id="get_all_users_content"><i class="fa fa-circle-o"></i>Все</a></li>
                                <li><a href="#" id="add_new_user_content"><i class="fa fa-circle-o"></i>Добавить</a></li>
                            </ul>
                        </li>
                        <li class="treeview">
                            <a href="#">
                              <i class="fa fa-area-chart"></i><span>Продажи</span>
                              <i class="fa fa-angle-left pull-right"></i>
                            </a>
                            <ul class="treeview-menu">
                                <li><a href="#" id="get_all_sales_content"><i class="fa fa-circle-o"></i>Все</a></li>
                                <li><a href="#" id="add_new_sale_content"><i class="fa fa-circle-o"></i>Добавить</a></li>
                                <li><a href="#" id="get_sales_statistic_content"><i class="fa fa-circle-o"></i>Статистика</a></li>
                            </ul>
                        </li>
                    </ul>
                </section>
            </aside>
            <div class="content-wrapper">
                <section class="content">
                    <div class="box box-warning">
                        <div id="content">
                            <div class="box-header"><h3 class='box-title'>Добро пожаловать!</h3></div>
                            <div class="box-body">
                                <p style="text-indent: 20px;">Вы находитесь на главной странице клиентского приложения для использования веб-сервиса по учету и регистрации продаж ювелирных товаров.</p>
                                <p style="text-indent: 20px;">Данная страница построена на взаимодействии с веб-сервисом в RPC-ориентированном стиле. Пункты меню слева позволят Вам получить доступ к
                                    функционалу, необходимому для работы с веб-сервисом.</p>
                                <p style="text-indent: 20px;">Здесь вы можете управлять данными о: 
                                    <ul>
                                        <li>пользователях сервиса</li>
                                        <li>магазинах</li>
                                        <li>категориях товаров</li>
                                        <li>товарах</li>
                                        <li>продажах</li>
                                    </ul>
                                </p> 
                                <p style="text-indent: 20px;">Также Вам доступны несколько статистических операций, позволяющих проводить анализ продаж по различным критериям.</p>
                                <p style="text-indent: 20px;">Приятного пользования!</p>
                                <p style="font-style: italic;" class="pull-right">С уважением, автор проекта Андриянец Дмитрий.</p>
                            </div>
                        </div>
                    </div>
                </section>
            </div>
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
        <script type="text/javascript" src="js/md5-min.js"></script>
        <script type="text/javascript" src="js/moment-with-locales.js"></script>
        <script type="text/javascript" src="js/bootstrap-timepicker.min.js"></script>
        <script type="text/javascript" src="js/icheck.min.js"></script>
        <script type="text/javascript" src="js/Chart.min.js"></script>
        <script type="text/javascript" src="js/rpc_logic.js"></script>
    </body>
</html>
