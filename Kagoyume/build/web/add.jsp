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
            
            <!--　ログインチェック　-->
            <jsp:include page="/loginchk.jsp" flush="true" />
            
            <!--　ホームへのリンク　-->
            <%= kh.home() %>
        </div>
        <!--
            ここからメイン
        -->
        <div id="main-box">
            <h4>買い物かご</h4>
            こちらの商品をカートに追加しました！
            <br>
            <br>
            <table>
                <tr>
                    <td rowspan="2"><img src="<%= upd.getImgURLm() %>"></td>
                    <td colspan="2">商品名：<%= upd.getName() %></td>
                </tr>
                <tr>
                    <td colspan="2">価格：<%= upd.getPrice() %>円</td>
                </tr>
                <tr>
                    <td>
                        <br>
                        <!--　カートへのリンク　-->
                        <a href ="./Cart">カートを見る</a>                         
                    </td>
                </tr>
            </table>
        </div>
    </body>
</html>
