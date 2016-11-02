<%-- 
    Document   : buyconfirm
    Created on : 2016/09/26, 11:40:12
    Author     : uezuchiharu

    購入確認ページ
    カートに追加順で商品の名前(リンクなし)、金額が表示される
    合計金額が表示され、その下に発送方法を選択するラジオボタンがある。
    「上記の内容で購入する」ボタンと「カートに戻る」ボタンがある。
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
    ArrayList<UserProductData> cartList = (ArrayList)hs.getAttribute("cartList");
    //total金額を取り出す
    int total = Integer.parseInt(request.getParameter("totalprice")); 
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
            <h4>購入確認画面</h4>
            <%
                if(cartList.size() != 0){
                    for(int i = 0; i < cartList.size(); i++){
            UserProductData upd = cartList.get(i); %>                   
            <table>
                <tr>
                    <td rowspan = 2><IMG src="<%= upd.getImgURLs() %>"></td>
                    <td>商品名：<%= upd.getName() %></td>
                </tr>
                <tr>
                    <td>価格：<%= upd.getPrice() %>円</td>
                </tr>
            </table>
                    <% } %>
                <% } %>
                <h4>合計金額：<%= total %>円</h4>
                <br>
            <h4>発送方法</h4> 
            発送方法を指定して下さい。
            <br>
            <br>
            <!--　購入　-->
            <form action="Buycomplete" method="post">
                <% for(int i = 1; i <= 3; i++ ){ %>
                <input type="radio" name="type" value="<%= i %>"><%= kh.type(i) %>
                <% } %>
                <br>
                <%-- アクセスチェッック　--%>
                <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
                <input type="hidden" name="buyid" value="<%= udd.getUserID() %>">
                <input type="hidden" name="totalprice" value="<%= total %>">
                <br>
                <input type="submit" name="" value="上記の内容で購入する">
            </form>      
            <br>
            <!--　カートに戻る　-->
            <form action="Cart" method="post">
                <input type="submit" value="カートに戻る">
            </form>
        </div>        
    </body>
</html>
