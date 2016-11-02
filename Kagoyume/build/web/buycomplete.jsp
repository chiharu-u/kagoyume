<%-- 
    Document   : buycomplete
    Created on : 2016/09/26, 11:40:58
    Author     : uezuchiharu

    購入完了ページ
    総購入金額を更新
    購入データを保存
    「購入が完了しました」と表示
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="kagoyume.UserProductData"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="kagoyume.KagoyumeHelper"%>
<%@page import="kagoyume.UserDataDTO"%>

<%
    HttpSession hs = request.getSession();
    UserDataDTO udd = (UserDataDTO)hs.getAttribute("loginData");
    KagoyumeHelper kh = KagoyumeHelper.getInstance();
%>    
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="./css/style.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <!--        
            ここからヘッダー
        -->
        <div id="header">
            <!--　サイトタイトル・説明　-->
            <%= kh.title() %>
            <%= kh.subTitle() %>
            
            <!--　ログインチェック　-->
            <jsp:include page="/loginchk.jsp" flush="true" />
            
            <!--　ホームへのリンク　-->
            <%= kh.home() %>
        </div>
        <!--
            ここからメイン
        -->
        <div id="main-box">
            <h4>お買い上げありがとうございます！</h4>
        </div>
    </body>
</html>
