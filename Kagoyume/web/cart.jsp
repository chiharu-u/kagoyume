<%-- 
    Document   : cart
    Created on : 2016/09/26, 11:38:52
    Author     : uezuchiharu

    カートに追加でクッキーやセッションに保存された登録情報が登録古い順に表示される
    商品の写真と名前(リンクつき)、金額を表示。
    画面下部に全額の合計金額を表示する
    「購入する」ボタンあり
    各商品には「削除」のリンクあり。このリンクをクリックすることで、カートから商品を削除する
    カートの中身はユーザー毎に切り替えられる
    ログインしていない状態ならばログインページに遷移、そこでログインに成功した場合、非ログイン状態で「カートに追加」
    操作をしていた商品はそのユーザー用のカートに移る
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="kagoyume.UserProductData"%>
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
        <link rel="stylesheet" href="./css/style.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
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
            <h4>買い物かご</h4>
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
                            <td>
                                <form action="Buyconfirm" method="post">
                                   <input type="hidden" name="price" value="<%= upd.getPrice() %>">
                                   <input type="submit" name="buy" value="購入">
                            </form>
                            </td>
                            <td>
                                <a href ="Cart?delete=<%= i %>">削除</a>
                            </td>
                        </tr>
                    </table>
                        <% } %>
            <% } %>                       
        </div>
    </body>
</html>
