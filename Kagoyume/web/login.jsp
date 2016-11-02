<%-- 
    Document   : login
    Created on : 2016/09/23, 14:11:20
    Author     : uezuchiharu

    ログイン管理ページ　どのページからも遷移できる。
    ログインしているかいないかで処理が分岐する
  
    ログインしていない状態(各ページの「ログイン」というリンクから)で遷移してきた場合は、
    ユーザー名とパスワードを入力するフォームが表示される。 
    また、「新規会員登録」というリンクも表示される。
--%>

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
        <title>Kagoyume/ログイン</title>
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
            <!--　ログインフォーム　-->
            <form action="Login" method="post">
                <p>Kagoyume ログイン<br>
                <br>
                ユーザー名：<input type="text" name="name"><br>
                パスワード：<input type="password" name="password"><br>
                <br>
                <input type="hidden" name="login" value="login">
                <input type="submit" value="ログイン">
                </p>
            </form>
            <!--　新規会員登録ページへ　-->
            <form action = "registration.jsp" method="post">
                <input type="submit" value="新規会員登録">
            </form>
        </div>            
    </body>
</html>
