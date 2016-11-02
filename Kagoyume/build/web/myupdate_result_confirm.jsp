<%-- 
    Document   : myupdate_result_confirm
    Created on : 2016/09/28, 16:10:26
    Author     : uezuchiharu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="kagoyume.KagoyumeHelper"%>
<%@page import="kagoyume.UserDataDTO"%>
<%@page import="kagoyume.UserData"%>

<%
    HttpSession hs = request.getSession();
    UserDataDTO udd = (UserDataDTO)hs.getAttribute("loginData");
    UserData ud = (UserData)session.getAttribute("updateData");
    KagoyumeHelper kh = KagoyumeHelper.getInstance();   
%>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="./css/style.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Kagoyume/更新データ確認画面</title>
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
            <h4>ユーザーデータ　更新確認画面</h4>
            以下の情報で更新します。
            <br>
            <br>
            名前：<%= ud.getName() %><br>
            パスワード：<%= ud.getPassword() %><br>
            メール：<%= ud.getMail() %><br>
            住所：<%= ud.getAddress() %><br>
            <br>
            <form action="MyupdateResult" method="post">
                <%-- アクセスチェッック　--%>
                <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
                <input type="submit" name="" value="更新">
            </form>
            <form action="Myupdate" method="post">
                <input type="submit" name="" value="変更画面へ戻る">
            </form>
        </div>
    </body>
</html>
