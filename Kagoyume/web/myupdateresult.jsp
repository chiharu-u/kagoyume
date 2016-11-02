<%-- 
    Document   : myupdateresult
    Created on : 2016/09/26, 11:43:18
    Author     : uezuchiharu

    IDなどを受け取り、DBを更新。
    「以上の内容で更新しました。」と、フォームで入力された値を表示
--%>

<%@page import="kagoyume.UserData"%>
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
        <link rel="stylesheet" href="./css/style.css"/>
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
            <h4>更新できました！</h4>
           
        </div>
    </body>
</html>
