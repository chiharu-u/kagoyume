<%-- 
    Document   : registration
    Created on : 2016/09/23, 15:08:53
    Author     : uezuchiharu

    ＜新規会員登録ページ＞
    ユーザー名,パスワード,メールアドレス,住所を入力
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="javax.servlet.http.HttpSession" %>
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
        <title>Kagoyume/新規会員登録</title>
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
            <form action="registrationconfirm" method="post">
                <p>新規会員登録<br><br>
                    <!--　requiredで入力必須にする（ただ、safariでは動作・・　-->
                    氏名：<input type="text" name="name" required><br>
                    パスワード：<input type="password" name="password" required><br>
                    メールアドレス：<input type="email" name="email" required><br>
                    住所：<input type="text" name="address" required><br>
                    <!--　アクセスチェックの値を送る　-->
                    <input type="hidden" name="ac" value="ac">
                    <input type="submit" name="btnSubmit" value="確認画面へ">
                </p>
            </form>
        </div>        
    </body>
</html>
