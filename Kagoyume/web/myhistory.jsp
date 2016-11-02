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
    String noitem = String.valueOf(hs.getAttribute("noitem"));
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
             
            <!--　ログインチェック　-->
            <jsp:include page="/loginchk.jsp" flush="true" />
            
            <!--　ホームへのリンク　-->
            <%= kh.home() %>
        </div>
        <!--
            ここからメイン
        -->
        <div id="main-box">
            <h4><%= udd.getName() %>さんの購入履歴です！</h4>
            
            <%--　＜修正＞　ArrayListの要素数分を表示する　--%>
            <% if(buylist != null){
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
            <% }else{ %>
                    <%= noitem %>            
            <% } %>
        </div>
    </body>
</html>
