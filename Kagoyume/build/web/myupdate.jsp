<%-- 
    Document   : myupdate
    Created on : 2016/09/26, 11:42:36
    Author     : uezuchiharu

    フォームから入力するデータで既にあるデータを更新できる
    画面構成はregistrationと同じ。フォーム内に直接記入された状態である。
    このフォームの内容を書き換えていくことでデータの更新ができる
    送信ボタン付き
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
        </div>
        <!--
            ここからメイン
        -->
        <div id="main-box">
            <form action="MyupdateResultConfirm?id=<%= udd.getUserID() %>" method="post">
                氏名：<input type="text" name="name" value="<%= udd.getName() %>"><br>
                パスワード：<input type="password" name="password" value="<%= udd.getPassword() %>"><br>
                メールアドレス：<input type="email" name="email" value="<%= udd.getMail() %>"><br>
                住所：<input type="text" name="address" value="<%= udd.getAddress() %>"><br>
                <input type="submit" name="update" value="確認画面へ">
            </form>            
        </div>
    </body>
</html>
