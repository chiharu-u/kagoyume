<%-- 
    Document   : mydeleteresult
    Created on : 2016/09/26, 11:45:27
    Author     : uezuchiharu

    ここにアクセスした段階で、IDによる削除が実行される
    (外部キー制約により直接DELETEは出来ないので、削除フラグを0から1に変更する)
    「削除しました｝という一文が表示される
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
            <h4>ユーザー情報削除</h4>
            削除しました
            <br>
            <br>
            <!--　ホームへのリンク　-->
            <%= kh.home() %>
        </div>
    </body>
</html>
