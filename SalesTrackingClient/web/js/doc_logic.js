$(document).ready(function() {
    
    function getBaseUrl() {
        var re = new RegExp(/^.*\//);
        return re.exec(window.location.href);
    }
    
    jQuery.expr[':'].regex = function(elem, index, match) {
        var matchParams = match[3].split(','),
        validLabels = /^(data|css):/,
        attr = {
            method: matchParams[0].match(validLabels) ? 
                        matchParams[0].split(':')[0] : 'attr',
            property: matchParams.shift().replace(validLabels,'')
        },
        regexFlags = 'ig',
        regex = new RegExp(matchParams.join('').replace(/^\s+|\s+$/g,''), regexFlags);
        return regex.test(jQuery(elem)[attr.method](attr.property));
    };
    
    $(document).on('click', '#get_all_users_content', function() {
         $.ajax({
            url: getBaseUrl() + 'DocController',
            type: 'POST',
            data: {action: 'get_all_users'},
            success: function (content) {
                $('#content').hide(1000, function(){
                    $('#content').html(content);
                    $('#content').show(1000);
                });
            }
        });
    });

    $(document).on('click', '#get_all_goods_content', function() {
         $.ajax({
            url: getBaseUrl() + 'DocController',
            type: 'POST',
            data: {action: 'get_all_goods'},
            success: function (content) {
                $('#content').hide(1000, function(){
                    $('#content').html(content);
                    $('#content').show(1000);
                });
            }
        });
    });

    $(document).on('click', '#get_all_shops_content', function() {
         $.ajax({
            url: getBaseUrl() + 'DocController',
            type: 'POST',
            data: {action: 'get_all_shops'},
            success: function (content) {
                $('#content').hide(1000, function(){
                    $('#content').html(content);
                    $('#content').show(1000);
                });
            }
        });
    });

    $(document).on('click', '#get_all_categories_content', function() {
         $.ajax({
            url: getBaseUrl() + 'DocController',
            type: 'POST',
            data: {action: 'get_all_categories'},
            success: function (content) {
                $('#content').hide(1000, function(){
                    $('#content').html(content);
                    $('#content').show(1000);
                });
            }
        });
    });

    $(document).on('click', '#get_all_sales_content', function() {
         $.ajax({
            url: getBaseUrl() + 'DocController',
            type: 'POST',
            data: {action: 'get_all_sales'},
            success: function (content) {
                $('#content').hide(1000, function(){
                    $('#content').html(content);
                    $('#content').show(1000);
                });
            }
        });
    });

    $(document).on('click', '#add_new_user_content', function() {
        var content = "<div class='row'>" +
                        "<div class='col-md-4'></div>" +
                        "<div class='col-md-4'>" +
                                "<form method='post'>" +
                                    "<div class='box-header'><h3 class='box-title'>Новый пользователь</h3></div>" +
                                    "<div class='box-body'>" +
                                        "<div class='form-group has-feedback'>" +
                                           "<input id='new_user_fio' type='text' class='form-control' placeholder='Ф.И.О.' required='true'>" +
                                           "<span class='glyphicon glyphicon-user form-control-feedback'></span>" +
                                        "</div>" +
                                        "<div class='form-group has-feedback'>" +
                                           "<input id='new_user_login' type='text' class='form-control' placeholder='Логин' required='true'>" +
                                           "<span class='glyphicon glyphicon-user form-control-feedback'></span>" +
                                        "</div>" +
                                        "<div class='form-group has-feedback'>" +
                                           "<input id='new_user_password' type='password' class='form-control' placeholder='Пароль' required='true'>" +
                                           "<span class='glyphicon glyphicon-lock form-control-feedback'></span>" +
                                        "</div>" + 
                                        "<div class='form-group has-feedback'>" +
                                           "<input id='new_user_password_repeat' type='password' class='form-control' placeholder='Повторите пароль' required='true'>" +
                                           "<span class='glyphicon glyphicon-lock form-control-feedback'></span>" +
                                        "</div>" + 
                                        "<div id='new_user_password_repeat_info'></div>" +
                                        "<div class='row'>" +
                                           "<div class='col-xs-1'></div>" +    
                                           "<div class='col-xs-5'>" +
                                               "<button type='submit' id='btn_add_new_user' class='btn btn-success btn-block btn-flat' disabled>Добавить</button>" +
                                           "</div>" +
                                           "<div class='col-xs-5'>" +
                                               "<button type='submit' id='btn_cancel_new_user_content' class='btn btn-warning btn-block btn-flat'>Отмена</button>" +
                                           "</div>" +
                                           "<div class='col-xs-1'></div>" +    
                                        "</div>" +
                                    "</div>" +
                                "</form>" +
                        "</div>" +      
                        "<div class='col-md-4'></div>" +
                       "</div>";
                $('#content').hide(1000, function(){
                    $('#content').html(content);
                    $('#content').show(1000);
                });
    });

    $(document).on('click', '#add_new_shop_content', function() {
        var content = "<div class='row'>" +
                        "<div class='col-md-4'></div>" +
                        "<div class='col-md-4'>" +
                                "<form method='post'>" +
                                    "<div class='box-header'><h3 class='box-title'>Новый магазин</h3></div>" +
                                    "<div class='box-body'>" +
                                        "<div class='form-group has-feedback'>" +
                                           "<input id='new_shop_name' type='text' class='form-control' placeholder='Название' required='true'>" +
                                        "</div>" +
                                        "<div class='form-group has-feedback'>" +
                                           "<input id='new_shop_address' type='text' class='form-control' placeholder='Адрес' required='true'>" +
                                        "</div>" +
                                        "<div class='row'>" +
                                           "<div class='col-xs-1'></div>" +    
                                           "<div class='col-xs-5'>" +
                                               "<button type='submit' id='btn_add_new_shop' class='btn btn-success btn-block btn-flat' disabled>Добавить</button>" +
                                           "</div>" +
                                           "<div class='col-xs-5'>" +
                                               "<button type='submit' id='btn_cancel_new_shop_content' class='btn btn-warning btn-block btn-flat'>Отмена</button>" +
                                           "</div>" +
                                           "<div class='col-xs-1'></div>" +    
                                        "</div>" +
                                    "</div>" +
                                "</form>" +
                        "</div>" +      
                        "<div class='col-md-4'></div>" +
                       "</div>";
                $('#content').hide(1000, function(){
                    $('#content').html(content);
                    $('#content').show(1000);
                });
    });

    $(document).on('click', '#add_new_sale_content', function() {
        $.ajax({
            url: getBaseUrl() + 'RPCController',
            type: 'POST',
            data: {action: 'get_all_goods_content'},
            success: function (data1) {
                var content = "";
                var goods = jQuery.parseJSON(data1);
                if(Object.keys(goods).length > 0) {
                    $.ajax({
                        url: getBaseUrl() + 'RPCController',
                        type: 'POST',
                        data: {action: 'get_all_shops_content'},
                        success: function (data2) {
                            var shops = jQuery.parseJSON(data2);
                            if(Object.keys(shops).length > 0) {
                                content = "<div class='row'>" +
                                            "<div class='col-md-3'></div>" +
                                            "<div class='col-md-6'>" +
                                                "<form method='post'>" +
                                                    "<div class='box-header'><h3 class='box-title'>Новая запись о продажах</h3></div>" +
                                                    "<div class='box-body'>" +
                                                        "<div class='form-group has-feedback'>" +
                                                           "<select id='new_sale_good' class='form-control'>" +
                                                                "<option value='0'>Товар</option>" +
                                                                "<option disabled/>";
                                                            $.each(goods, function(i) {
                                                                content += "<option value='" + goods[i].id + "'>" + goods[i].name + "</option>";
                                                            });
                                                content += "</select>" +
                                                        "</div>" + 
                                                        "<div class='form-group has-feedback'>" +
                                                           "<select id='new_sale_shop' class='form-control'>" +
                                                                "<option value='0'>Магазин</option>" +
                                                                "<option disabled/>";
                                                            $.each(shops, function(i) {
                                                                content += "<option value='" + shops[i].id + "'>" + shops[i].name + "&nbsp;&nbsp;(" + shops[i].address +")" + "</option>";
                                                            });
                                                content += "</select>" +
                                                        "</div>" + 
                                                        "<div class='form-group has-feedback'>" +
                                                            "<input type='number' id='new_sale_count' class='form-control' placeholder='Количество' required='true'>" +
                                                            "<span class='glyphicon glyphicon-flag form-control-feedback'></span>" +
                                                        "</div>" +
                                                        "<div class='form-group has-feedback'>" +
                                                                            "<div class='input-group date' id='datetimepicker1'>" +
                                                                                "<input type='text' class='form-control' id='new_sale_date' />" +
                                                                                "<span class='input-group-addon'>" +
                                                                                    "<span class='glyphicon glyphicon-calendar'></span>" +
                                                                                "</span>" +
                                                                            "</div>" +
                                                                    "<script type='text/javascript'>" +
                                                                        "$(function () {" +
                                                                            "$('#datetimepicker1').datetimepicker({locale: 'ru',  defaultDate: '"+new Date($.now())+"'});" +
                                                                        "});" +
                                                                    "</script>" +
                                                        "</div>" +
                                                        "<div class='row'>" +
                                                            "<div class='col-xs-1'></div>" +    
                                                            "<div class='col-xs-5'>" +
                                                                "<button type='submit' id='btn_add_new_sale' class='btn btn-success btn-block btn-flat' disabled>Добавить</button>" +
                                                            "</div>" +
                                                            "<div class='col-xs-5'>" +
                                                                "<button type='submit' id='btn_cancel_new_sale_content' class='btn btn-warning btn-block btn-flat'>Отмена</button>" +
                                                            "</div>" +
                                                            "<div class='col-xs-1'></div>" +    
                                                        "</div>" +
                                                    "</div>" +
                                                "</form>" +
                                            "</div>" + 
                                            "<div class='col-md-3'></div>" +
                                          "</div>";
                            } else {
                                content = "<div class='box-header'>" +
                                            "<h3 class='box-title'>Не найдено ни одного магазина для добавления записи</h3>"+
                                         "</div>"; 
                            }
                        }
                    });
                } else {
                    content = "<div class='box-header'>" +
                                "<h3 class='box-title'>Не найдено ни одного товара для добавления записи</h3>"+
                             "</div>"; 
                }
                $('#content').hide(1000, function(){
                    $('#content').html(content);
                    $('#content').show(1000);
                });
            }
        });
    });

    $(document).on('click', '#add_new_good_content', function() {
        $.ajax({
            url: getBaseUrl() + 'RPCController',
            type: 'POST',
            data: {action: 'get_all_categories_content'},
            success: function (data) {
                var obj = jQuery.parseJSON(data);
                if(Object.keys(obj).length > 0) {
                    var content = "<div class='row'>" +
                                    "<div class='col-md-4'></div>" +
                                    "<div class='col-md-4'>" +
                                            "<form method='post'>" +
                                                "<div class='box-header'><h3 class='box-title'>Новый товар</h3></div>" +
                                                "<div class='box-body'>" +
                                                    "<div class='form-group has-feedback'>" +
                                                       "<input id='new_good_name' type='text' class='form-control' placeholder='Название' required='true'>" +
                                                    "</div>" +
                                                    "<div class='form-group has-feedback'>" +
                                                       "<input id='new_good_description' type='text' class='form-control' placeholder='Описание' required='true'>" +
                                                    "</div>" +
                                                    "<div class='form-group has-feedback'>" +
                                                       "<select id='new_good_category' type='text' class='form-control' required='true'>" + 
                                                        "<option value='0'>Категория</option>" +
                                                        "<option disabled/>";
                                                    $.each(obj, function(i) {
                                                        content += "<option value='" + obj[i].id + "'>" + obj[i].name + "</option>";
                                                    });   
                                        content += "</select>" +
                                                 "</div>" +
                                                 "<div class='form-group has-feedback'>" +
                                                       "<input maxlength='7' minvalue='0' id='new_good_price' type='text' class='form-control' placeholder='Цена за единицу' required='true'>" +
                                                 "</div>" +
                                                 "<div id='new_good_price_info'></div>" +
                                                 "<div class='row'>" +
                                                    "<div class='col-xs-1'></div>" +    
                                                    "<div class='col-xs-5'>" +
                                                        "<button type='submit' id='btn_add_new_good' class='btn btn-success btn-block btn-flat' disabled>Добавить</button>" +
                                                    "</div>" +
                                                    "<div class='col-xs-5'>" +
                                                        "<button type='submit' id='btn_cancel_new_good_content' class='btn btn-warning btn-block btn-flat'>Отмена</button>" +
                                                    "</div>" +
                                                    "<div class='col-xs-1'></div>" +    
                                                 "</div>" +
                                             "</div>" +
                                         "</form>" +
                                 "</div>" +      
                                 "<div class='col-md-4'></div>" +
                                "</div>";
                } else {
                    content = "<div class='box-header'>" +
                                "<h3 class='box-title'>Не найдено ни одной категории для добавления товара</h3>"+
                             "</div>"; 
                }
                $('#content').hide(1000, function(){
                    $('#content').html(content);
                    $('#content').show(1000);
                });
            }
        });
    });

    $(document).on('click', '#add_new_category_content', function() {
        var content = "<div class='row'>" +
                        "<div class='col-md-4'></div>" +
                        "<div class='col-md-4'>" +
                                "<form method='post'>" +
                                    "<div class='box-header'><h3 class='box-title'>Новая категория товаров</h3></div>" +
                                    "<div class='box-body'>" +
                                        "<div class='form-group has-feedback'>" +
                                           "<input id='new_category_name' type='text' class='form-control' placeholder='Название' required='true'>" +
                                        "</div>" +
                                        "<div class='form-group has-feedback'>" +
                                           "<input id='new_category_description' type='text' class='form-control' placeholder='Описание' required='true'>" +
                                        "</div>" +
                                        "<div class='row'>" +
                                            "<div class='col-xs-1'></div>" +    
                                            "<div class='col-xs-5'>" +
                                                "<button type='submit' id='btn_add_new_category' class='btn btn-success btn-block btn-flat' disabled>Добавить</button>" +
                                            "</div>" +
                                            "<div class='col-xs-5'>" +
                                                "<button type='submit' id='btn_cancel_new_category_content' class='btn btn-warning btn-block btn-flat'>Отмена</button>" +
                                            "</div>" +
                                            "<div class='col-xs-1'></div>" +    
                                         "</div>" +
                                     "</div>" +
                                 "</form>" +
                         "</div>" +      
                         "<div class='col-md-4'></div>" +
                        "</div>";
        $('#content').hide(1000, function(){
            $('#content').html(content);
            $('#content').show(1000);
        });
    });

    $(document).on('click', '#btn_cancel_new_user_content', function(e){
        e.preventDefault();
        $('#get_all_users_content').trigger('click');
    });
    
    $(document).on('click', '#btn_cancel_new_good_content', function(e){
        e.preventDefault();
        $('#get_all_goods_content').trigger('click');
    });

    $(document).on('click', '#btn_cancel_new_category_content', function(e){
        e.preventDefault();
        $('#get_all_categories_content').trigger('click');
    });
 
    $(document).on('click', '#btn_cancel_new_shop_content', function(e){
        e.preventDefault();
        $('#get_all_shops_content').trigger('click');
    });
    
    $(document).on('click', '#btn_cancel_new_sale_content', function(e){
        e.preventDefault();
        $('#get_all_sales_content').trigger('click');
    });

    $(document).on('mouseleave', '#new_user_password_repeat, #new_user_password, #new_user_login, #new_user_fio', function() {
        $('#new_user_password_repeat_info').html("");
        var flag = false;
        if($('#new_user_password').val() && $('#new_user_password_repeat').val() && $('#new_user_login').val() && $('#new_user_fio').val()) {
            if($('#new_user_password').val() === $('#new_user_password_repeat').val()) {
                flag = true;
            } else {
                $('#new_user_password_repeat_info').html("<p><font style='color: red;'>Пароли не совпадают!</font></p>");
            }
        }
        if(flag) {
            $("#btn_add_new_user").attr("disabled",false);
        } else {
            $("#btn_add_new_user").attr("disabled",true);
        }
    });

    $(document).on('mouseleave', '#new_category_name, #new_category_description', function() {
        if($('#new_category_name').val() && $('#new_category_description').val()) {
            $("#btn_add_new_category").attr("disabled",false);
        } else {
            $("#btn_add_new_category").attr("disabled",true);
        }
    });

    $(document).on('mouseleave', '#new_good_name, #new_good_description, #new_good_price', function() {
        $("#new_good_price_info").html("");
        if($('#new_good_name').val() && $('#new_good_description').val() && $('#new_good_price').val() && $('#new_good_category').val() !== '0') {
            if($('#new_good_price').val().match(/^[0-9]+$/) !== null) {
                $("#btn_add_new_good").attr("disabled",false);
            } else {
                $("#new_good_price_info").html("<p><font style='color: red;'>Допускаются только целочисленные значения!</font></p>");
            }
        } else {
            $("#btn_add_new_good").attr("disabled",true);
        }
    });

    $(document).on('mouseleave', '#new_shop_name, #new_shop_address', function() {
        if($('#new_shop_name').val() && $('#new_shop_address').val()) {
            $("#btn_add_new_shop").attr("disabled",false);
        } else {
            $("#btn_add_new_shop").attr("disabled",true);
        }
    });
    
    $(document).on('mouseleave', '#new_sale_good, #new_sale_count, #new_sale_count, #new_sale_date', function() {
        if(parseInt($('#new_sale_shop').val()) > 0 && parseInt($('#new_sale_good').val()) > 0
                && parseInt($('#new_sale_count').val()) > 0 && $('#new_sale_date').val()) {
            $("#btn_add_new_sale").attr("disabled",false);
        } else {
            $("#btn_add_new_sale").attr("disabled",true);
        }
    });
    
    $(document).on('click', '#btn_add_new_user', function(event) {
        event.preventDefault();
        var login = $('#new_user_login').val();
        var fio = $('#new_user_fio').val();
        var password = hex_md5($('#new_user_password').val());
        $.ajax({
            url: getBaseUrl() + 'DocController',
            type: 'POST',
            data: {action: 'add_new_user', new_user_fio: fio, new_user_login: login, new_user_password: password},
            success: function (msg) {
                if(msg === 'busy') {
                    $('#new_user_password_repeat_info').html("<p><font style='color: red;'>Этот логин уже используется</font></p>");
                } else if (msg === 'success') {
                    content = "<div class='box-header'>" +
                                "<h3 class='box-title'>Пользователь " + fio + " (" + login + ") успешно добавлен</h3>"+
                              "</div>"; 
                    $('#content').hide(1000, function(){
                        $('#content').html(content);
                        $('#content').show(1000);
                    });
                }
            }
        });
        return false;
    });

    $(document).on('click', '#btn_add_new_sale', function(event) {
        event.preventDefault();
        var good = $('#new_sale_good').val();
        var shop = $('#new_sale_shop').val();
        var count = $('#new_sale_count').val();
        var date = $('#new_sale_date').val();
        $.ajax({
            url: getBaseUrl() + 'DocController',
            type: 'POST',
            data: {action: 'add_new_sale', new_sale_good: good, new_sale_shop: shop, new_sale_count: count, new_sale_date: date},
            success: function (msg) {
                if (msg === 'success') {
                    content = "<div class='box-header'>" +
                                "<h3 class='box-title'>Запись о продаже успешно добавлена</h3>"+
                              "</div>"; 
                    $('#content').hide(1000, function(){
                        $('#content').html(content);
                        $('#content').show(1000);
                    });
                }
            }
        });
        return false;
    });

    $(document).on('click', '#btn_add_new_category', function(event) {
        event.preventDefault();
        var name = $('#new_category_name').val();
        var description = $('#new_category_description').val();
        $.ajax({
            url: getBaseUrl() + 'DocController',
            type: 'POST',
            data: {action: 'add_new_category', new_category_name: name, new_category_description: description},
            success: function (msg) {
                if (msg === 'success') {
                    content = "<div class='box-header'>" +
                                "<h3 class='box-title'>Категория товаров '" + name + "' успешно добавлена</h3>"+
                              "</div>"; 
                    $('#content').hide(1000, function(){
                        $('#content').html(content);
                        $('#content').show(1000);
                    });
                }
            }
        });
        return false;
    });

    $(document).on('click', '#btn_add_new_good', function(event) {
        event.preventDefault();
        var name = $('#new_good_name').val();
        var price = $('#new_good_price').val();
        var category = $('#new_good_category').val();
        var description = $('#new_good_description').val();
        $.ajax({
            url: getBaseUrl() + 'DocController',
            type: 'POST',
            data: {action: 'add_new_good', new_good_name: name, new_good_category: category, new_good_price: price, new_good_description: description},
            success: function (msg) {
                if (msg === 'success') {
                    content = "<div class='box-header'>" +
                                "<h3 class='box-title'>Товар '" + name + "' успешно добавлен</h3>"+
                              "</div>"; 
                    $('#content').hide(1000, function(){
                        $('#content').html(content);
                        $('#content').show(1000);
                    });
                }
            }
        });
        return false;
    });

    $(document).on('click', '#btn_add_new_shop', function(event) {
        event.preventDefault();
        var name = $('#new_shop_name').val();
        var address = $('#new_shop_address').val();
        $.ajax({
            url: getBaseUrl() + 'DocController',
            type: 'POST',
            data: {action: 'add_new_shop', new_shop_name: name, new_shop_address: address},
            success: function (msg) {
                if (msg === 'success') {
                    content = "<div class='box-header'>" +
                                "<h3 class='box-title'>Магазин '" + name + "' успешно добавлен</h3>"+
                              "</div>"; 
                    $('#content').hide(1000, function(){
                        $('#content').html(content);
                        $('#content').show(1000);
                    });
                }
            }
        });
        return false;
    });

    $(document).on('click', '#get_sales_statistic_content', function() {
        $.ajax({
            url: getBaseUrl() + 'RPCController',
            type: 'POST',
            data: {action: 'get_sales_statistic_content'},
            success: function (msg) {
                var res = jQuery.parseJSON(msg);
                var goodsCountData = res["count"];
                var goodsSumData = res["sum"];
                var shopsSumData = res["shop_sum"];
                var dateSumData = res["date_sum"];
                $.each(goodsCountData, function(i) {
                    goodsCountData[i].color = 'rgb(' + (Math.floor(Math.random() * 256)) + ',' + (Math.floor(Math.random() * 256)) + ',' + (Math.floor(Math.random() * 256)) + ')';
	        });
                $.each(goodsSumData, function(i) {
                    goodsSumData[i].color = 'rgb(' + (Math.floor(Math.random() * 256)) + ',' + (Math.floor(Math.random() * 256)) + ',' + (Math.floor(Math.random() * 256)) + ')';
	        });
                $.each(shopsSumData, function(i) {
                    shopsSumData[i].color = 'rgb(' + (Math.floor(Math.random() * 256)) + ',' + (Math.floor(Math.random() * 256)) + ',' + (Math.floor(Math.random() * 256)) + ')';
	        });
                var content = "<div class='box-header with-border'>" +
                                "<h3 class='box-title'>Статистика продаж</h3>" +
                              "</div>" + 
                              "<div class='box-body'>" +
                                "<div class='row'>" +
                                    "<div class='col-md-6'>" +
                                        "<div class='box box-success'>" +
                                            "<div class='box-header with-border'>" +
                                                "<h5 class='box-title'>Продано экземпляров по каждому товару</h5>" +
                                            "</div>" +
                                            "<div class='box-body'>" +
                                                "<canvas id='chartGoodsCount' height='150'></canvas>" + 
                                            "</div>" +
                                        "</div>" +
                                    "</div>" +
                                    "<div class='col-md-6'>" +
                                        "<div class='box box-success'>" +
                                            "<div class='box-header with-border'>" +
                                                "<h5 class='box-title'>Общая выручка по каждому товару</h5>" +
                                            "</div>" +
                                            "<div class='box-body'>" +
                                                "<canvas id='chartGoodsSum' height='150'></canvas>" + 
                                            "</div>" +
                                        "</div>" +
                                    "</div>" +
                                "</div>" +
                                "<div class='row'>" +
                                    "<div class='col-md-6'>" +
                                        "<div class='box box-success'>" +
                                            "<div class='box-header with-border'>" +
                                                "<h5 class='box-title'>Общая выручка по каждому магазину</h5>" +
                                            "</div>" +
                                            "<div class='box-body'>" +
                                                "<canvas id='chartShopsSum' height='150'></canvas>" + 
                                            "</div>" +
                                        "</div>" +
                                    "</div>" +
                                    "<div class='col-md-6'>" +
                                        "<div class='box box-success'>" +
                                            "<div class='box-header with-border'>" +
                                                "<h5 class='box-title'>Общая выручка по месяцам (2015 г.)</h5>" +
                                            "</div>" +
                                            "<div class='box-body'>" +
                                                "<div calss='chart'>" +
                                                    "<canvas id='chartDateSum' height='173'></canvas>" + 
                                                "</div>" +
                                            "</div>" +
                                        "</div>" +
                                    "</div>" +
                                "</div>" +
                              "</div>";
                $('#content').hide(1000, function() {
                    $('#content').html(content);
                    $('#content').show(1000, function() {
                        var pieChartGoodsCountCanvas = $('#chartGoodsCount').get(-1).getContext("2d");
                        var pieChartGoodsCount = new Chart(pieChartGoodsCountCanvas);
                        var PieDataGoodsCount = goodsCountData;
                        var pieChartGoodsSumCanvas = $('#chartGoodsSum').get(-1).getContext("2d");
                        var pieChartGoodsSum = new Chart(pieChartGoodsSumCanvas);
                        var PieDataGoodsSum = goodsSumData;
                        var pieChartShopsSumCanvas = $('#chartShopsSum').get(-1).getContext("2d");
                        var pieChartShopsSum = new Chart(pieChartShopsSumCanvas);
                        var PieDataShopsSum = shopsSumData;
                        var pieOptions = {
                            segmentShowStroke: true,
                            segmentStrokeColor: "#fff",
                            segmentStrokeWidth: 1,
                            percentageInnerCutout: 0, // This is 0 for Pie charts
                            animationSteps: 100,
                            animationEasing: "easeOutBounce",
                            animateRotate: true,
                            animateScale: false,
                            responsive: true,
                            maintainAspectRatio: false,
                            legendTemplate: "<ul class=\"<%=name.toLowerCase()%>-legend\"><% for (var i=0; i<segments.length; i++){%><li><span style=\"background-color:<%=segments[i].fillColor%>\"></span><%if(segments[i].label){%><%=segments[i].label%><%}%></li><%}%></ul>"
                        };
                        pieChartGoodsCount.Doughnut(PieDataGoodsCount, pieOptions);
                        pieChartGoodsSum.Doughnut(PieDataGoodsSum, pieOptions);
                        pieChartShopsSum.Doughnut(PieDataShopsSum, pieOptions);
                        //////////////////////////////////////////////////////////
                        var areaChartData = {
                            labels: ["Январь", "Февраль", "Март", "Апрель", "Май"],
                            datasets: [
                              {
                                label: "Electronics",
                                fillColor: "rgba(210, 214, 222, 1)",
                                strokeColor: "rgba(210, 214, 222, 1)",
                                pointColor: "rgba(210, 214, 222, 1)",
                                pointStrokeColor: "#c1c7d1",
                                pointHighlightFill: "#fff",
                                pointHighlightStroke: "rgba(220,220,220,1)",
                                data: dateSumData
                              }
                            ]
                          };
                        var barChartDateSumCanvas = $("#chartDateSum").get(0).getContext("2d");
                        var barChartDateSum = new Chart(barChartDateSumCanvas);
                        var barChartData = areaChartData;
                        barChartData.datasets[0].fillColor = "#00a65a";
                        barChartData.datasets[0].strokeColor = "#00a65a";
                        barChartData.datasets[0].pointColor = "#00a65a";
                        var barChartOptions = {
                            scaleBeginAtZero: true,
                            scaleShowGridLines: true,
                            scaleGridLineColor: "rgba(0,0,0,.05)",
                            scaleGridLineWidth: 1,
                            scaleShowHorizontalLines: true,
                            scaleShowVerticalLines: true,
                            barShowStroke: true,
                            barStrokeWidth: 2,
                            barValueSpacing: 5,
                            barDatasetSpacing: 1,
                            legendTemplate: "<ul class=\"<%=name.toLowerCase()%>-legend\"><% for (var i=0; i<datasets.length; i++){%><li><span style=\"background-color:<%=datasets[i].fillColor%>\"></span><%if(datasets[i].label){%><%=datasets[i].label%><%}%></li><%}%></ul>",
                            responsive: true,
                            maintainAspectRatio: false
                        };
                        barChartOptions.datasetFill = false;
                        barChartDateSum.Bar(barChartData, barChartOptions);
                    });
                });
            }
        });
    });

});