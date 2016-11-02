<%-- 
    Document   : mydata
    Created on : 2016/09/26, 11:41:44
    Author     : uezuchiharu

    登録したユーザー情報が閲覧できる(ユーザーID以外全て)
    購入履歴へのリンクあり
    登録情報を更新する、削除するボタン
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="kagoyume.UserDataDTO"%>
<%@page import="kagoyume.KagoyumeHelper"%>

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
        <title>Kagoyume/ユーザー情報</title>
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
            <h4>登録情報</h4>
            名前：<%= udd.getName() %><br>
            パスワード：<%= udd.getPassword() %><br>
            メールアドレス：<%= udd.getMail() %><br>
            住所：<%= udd.getAddress() %><br>
            購入金額：<%= udd.getTotal() %>円<br>
            登録日：<%= udd.getNewDate() %><br>
            <br>
            <!--　購入履歴一覧画面へのリンク　-->
            <a href="Myhistory?userid=<%= udd.getUserID() %>">購入履歴</a>
            <br>
            <br>
            <!-- 登録情報の変更画面へ　-->
            <form action="Myupdate" method="post">
                <%-- アクセスチェッック　--%>
                <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
                <input type="submit" name="update" value="変更" style="width: 100px">
            </form>
            <!--　ユーザーデータ削除　確認画面へ　-->
            <form action="mydelete" method="post">
                <%-- アクセスチェッック　--%>
                <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
                <input type="submit" name="delete" value="削除" style="width: 100px">
            </form>
        </div>
    </body>
</html>
