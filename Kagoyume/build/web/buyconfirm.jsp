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
            
            <!--　
                セッションに入れたloginchkを取り出して、
                ログイン中であればユーザー名・ログアウト・買い物かごを表示する
            -->
            <% if("login".equals(hs.getAttribute("loginchk"))){ %>
            <a href="/mydata.jsp"><%= udd.getName() %></a>さん&nbsp;ようこそ！           
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
            <h4>購入確認画面</h4>
            <%
                if(cartList.size() != 0){
                    for(int i = 0; i < cartList.size(); i++){                        
                    UserProductData upd = cartList.get(i); %>                   
                    <table>
                        <tr>
                            <td rowspan = 2><IMG src="<%= upd.getImgURLm() %>"></td>
                            <td><%= upd.getName() %></td>
                        </tr>
                        <tr>
                            <td><%= upd.getPrice() %>円</td>
                        </tr>
                        <tr>
                            <td>合計金額：円です</td>                               
                        </tr>
                    </table>
                        <% } %>
                             <% } %>
            <h4>発送方法</h4> 
            <br>
            <form action="Buycomplete" method="post">
                <% for(int i = 1; i <= 3; i++ ){ %>
                <input type="radio" name="type" value="<%= i %>"><%= kh.type(i) %>>
            <% } %>
                <input type="hidden" name="buyid" value="<%= udd.getUserID() %>">
                <input type="submit" name="" value="上記の内容で購入する">
            </form>      
            <form action="" method="post">
                <input type="submit" value="カートに戻る">
            </form>
        </div>        
    </body>
</html>
