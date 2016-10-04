<%-- 
    Document   : add
    Created on : 2016/09/26, 11:37:26
    Author     : uezuchiharu

    カートに追加ページ
    商品の情報を受け取り、クッキーやセッションに追加する
    画面には「カートに追加しました」という文言が出てくる。

--%>

<%@page import="kagoyume.UserProductData"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="kagoyume.KagoyumeHelper"%>
<%@page import="kagoyume.UserDataDTO"%>

<%
    HttpSession hs = request.getSession();
    UserDataDTO udd = (UserDataDTO)hs.getAttribute("loginData");
    KagoyumeHelper kh = KagoyumeHelper.getInstance();
    UserProductData upd = (UserProductData)hs.getAttribute("upd");
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
            <a href="mydata.jsp"><%= udd.getName() %></a>さん&nbsp;ようこそ！           
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
            <h4>買い物かご</h4>
            こちらの商品をカートに追加しました！
            <table>
                <tr>
                    <td rowspan="2"><img src="<%= upd.getImgURLs() %>"></td>
                    <td colspan="2"><%= upd.getName() %></td>
                </tr>
            </table>
                <a href ="./Cart">カートを見る</a> 
        </div>
    </body>
</html>
