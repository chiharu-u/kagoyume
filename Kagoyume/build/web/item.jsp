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
            
            <!--　ログインチェック　-->
            <jsp:include page="/loginchk.jsp" flush="true" />
            
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
                    <td rowspan="3"><IMG src ="<%= upd.getImgURLm() %>"></td>
                    <td colspan="2">商品名：<%= upd.getName() %></td>
                </tr>
                <tr>
                    <td colspan="2">商品詳細：<%= upd.getDescription() %></td>
                </tr>
                <tr>
                    <td>価格：<%= upd.getPrice() %>円</td>
                    <td>評価：<%= upd.getRate() %></td>
                </tr>               
                <tr>
                    <td>
                        <br>
                        <form action="Add" method="get">
                            <%-- アクセスチェッック　--%>
                            <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
                            <input type="submit" name="cart" value="カートに入れる">
                        </form>
                    </td>
                </tr>
            </table>
         </div>
    </body>
</html>
