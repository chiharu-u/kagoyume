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
    
    boolean reinput = false;
    //登録確認画面から登録画面へ戻ったとき
    if(request.getParameter("mode") != null && request.getParameter("mode").equals("reinput")){
        reinput = true;
        udb = (UserDataBeans)hs.getAttribute("udb");
    }

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
            
            <!--　
                セッションに入れたloginchkを取り出して、
                ログイン中であればユーザー名・ログアウト・買い物かごを表示する
            -->
            <% if("login".equals(hs.getAttribute("loginchk"))){ %>
            <a href="/mydata.jsp"><%= udd.getName() %></a>さん&nbsp;ようこそ！           
            <a href="Cart">買い物かご</a>
            <!--　ログアウトする時は、クエリストリングで値を送ってLogin.javaで分岐させる　-->
            <a href="Login?login=logout">ログアウト</a>            
            <% } else{ %>
            <!--　ログインへのリンク　-->
            <%= kh.login() %>
            <% } %>
            <!--　ホームへのリンク　-->
            <%= kh.home() %>
        </div>
        <!--
            ここからメイン
        -->
        <div id="main-box">
            <form action="registrationconfirm" method="post">
                <p>新規会員登録<br><br>
                    氏名：<input type="text" name="name"><br>
                    パスワード：<input type="password" name="password"><br>
                    メールアドレス：<input type="email" name="email"><br>
                    住所：<input type="text" name="address"><br>
                    <!--　アクセスチェックの値を送る　-->
                    <input type="hidden" name="ac" value="ac">
                    <input type="submit" name="btnSubmit" value="確認画面へ">
                </p>
            </form>
        </div>        
    </body>
</html>
