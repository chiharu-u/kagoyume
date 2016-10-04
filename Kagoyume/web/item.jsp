<%-- 
    Document   : item
    Created on : 2016/09/26, 11:36:19
    Author     : uezuchiharu

    商品詳細ページ
    serchまたはcartから遷移できる。商品IDをGETメソッドにより受け渡す
    YahooショッピングAPIから取得したデータで、より詳細な情報(概要や評価値)、が表示される
    「カートに追加する」ボタンがあり、クリックするとaddに遷移する
--%>

<%@page import="kagoyume.UserProductData"%>
<%@page import="java.util.ArrayList"%>
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
        <title>aiuie</title>
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
            <h4>商品詳細</h4>
            <table>
                <tr>
                    <td rowspan="4"><IMG src ="<%= upd.getImgURLs() %>"></td>
                    <td colspan="2"><%= upd.getName() %></td>
                </tr>
                <tr>
                    <td colspan="2"><%= upd.getDescription() %></td>
                </tr>
                <tr>
                    <td><%= upd.getPrice() %></td>
                    <td><%= upd.getRate() %></td>
                </tr>
                <tr>
                    <td><%= upd.getReviewURL() %></td>
                </tr>
                <tr>
                    <td>
                        <form action="Add" method="get">
                            <input type="submit" name="cart" value="カートに入れる">
                        </form>
                    </td>
                </tr>
            </table>
         </div>
    </body>
</html>
