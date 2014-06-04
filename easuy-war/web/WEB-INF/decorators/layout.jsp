<%-- 
    Document   : template
    Created on : Jun 3, 2014, 6:45:05 PM
    Author     : Diogo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<html>
    <head>
        <title><decorator:title default="Easuy" /></title>
        <decorator:head />
    </head>
    <body>
        <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <div class="container-fluid">
                    <%@ include file="/WEB-INF/decorators/header.jsp"%>
            </div>
        </div>
        <div class="container-fluid">
            <div class="row">
                <div class="col-sm-3 col-md-2 sidebar">
                    <%@ include file="/WEB-INF/decorators/menu.jsp"%>
                </div>
                <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
                    <h1 class="page-header">Easuy</h1>
                    
                    <div class="row placeholders">
                        <decorator:body />
                    </div>
                </div>
            </div>
        </div>
        
        
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css" />
        <!-- Optional theme -->
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css"/>
        <!-- Latest compiled and minified JavaScript -->
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
            <link href="${pageContext.request.contextPath}/resources/css/dashboard.css" rel="stylesheet"/>
        <link href="${pageContext.request.contextPath}/resources/css/easuy_custom.css" rel="stylesheet"/>
    </body>
</html>
