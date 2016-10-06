<%-- 
    Document   : myhistory
    Created on : 2016/10/04, 11:51:33
    Author     : uezuchiharu
--%>

<%@page import="kagoyume.UserProductData"%>
<%@page import="kagoyume.UserDataDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="kagoyume.KagoyumeHelper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    HttpSession hs = request.getSession();
    KagoyumeHelper kh = KagoyumeHelper.getInstance();
    UserDataDTO udd = (UserDataDTO)hs.getAttribute("loginData");
    ArrayList <UserProductData> buylist = (ArrayList <UserProductData>)hs.getAttribute("buylist");  
%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="./css/style.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Kagoyume/購入履歴</title>
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
            <a href="./mydata.jsp"><%= udd.getName() %></a>さん&nbsp;ようこそ！           
            <a href="Cart">買い物かご</a>
            <!--　ログアウトする時は、クエリストリングで値を送ってLogin.javaで分岐させる　-->
            <%= kh.logout() %>
            <% } else{ %>
            <!--　ログインリンク　-->
            <%= kh.login() %>
            <% } %>
        </div>
        <!--
            ここからメイン
        -->
        <div id="main-box">
            <h4><%= udd.getName() %>さんの購入履歴です！</h4>
            
            <%--　＜修正＞　ArrayListの要素数分を表示する　--%>
            <% if(buylist.size() != 0){
                for(int i = 0; i < buylist.size(); i++){
                    UserProductData upd = buylist.get(i); %>
                    <table>
                        <tr>
                            <td rowspan="2"><IMG src="<%= upd.getImgURLs() %>"></td>
                            <td>商品名：<%= upd.getName() %></td>
                        </tr>
                        <tr>
                            <td>価格：<%= upd.getPrice() %>円</td>
                        </tr>
                    </table>
                <% } %>
            <% } %>
        </div>
    </body>
</html>
