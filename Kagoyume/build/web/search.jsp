<%--
    Document   : search
    Created on : 2016/09/26, 11:33:44
    Author     : uezuchiharu
    
    ＜検索結果ページ＞  
    topから検索により遷移できる。
    YahooショッピングAPIに直接検索キーワードを渡し、その結果を受け取り＆表示している
    検索キーワード、検索結果数を表示
    縦のリスト型に表示。
    サムネイルと、その横に商品名、金額が載っている。クリックでitemへ　結果は上位20件まで
--%>

<%@page import="java.net.URL"%>
<%@page import="kagoyume.UserProductData"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="kagoyume.KagoyumeHelper"%>
<%@page import="kagoyume.UserDataDTO"%>

<%
    HttpSession hs = request.getSession();
    UserDataDTO udd = (UserDataDTO)hs.getAttribute("loginData");
    KagoyumeHelper kh = KagoyumeHelper.getInstance();
    ArrayList <UserProductData> list = (ArrayList <UserProductData>)hs.getAttribute("list");   
%>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="./css/style.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Kagoyume/検索結果ページ</title>
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
        </div>
        <!--
            ここからメイン
        -->
        <div id="main-box">
            <%
                if(list.size() != 0){
                    for(int i = 0; i < list.size(); i++){                        
                    UserProductData upd = list.get(i); %>                   
                    <table>
                        <tr>
                            <td rowspan = 3><IMG src="<%= upd.getImgURLm() %>"></td>
                            <td colspan = 2><%= upd.getName() %></td>
                        </tr>
                        <tr>
                            <td colspan = 2><%= upd.getDescription() %></td>    
                        </tr>
                        <tr>
                            <td><%= upd.getPrice() %>円</td>
                            <td>評価：<%= upd.getRate() %></td>
                            <td>
                                <form action="Item" method="get">
                                    <input type="hidden" name="id" value="<%= i %>">
                                    <input type="submit" name="item" value="商品詳細">
                                </form>
                            </td>
                        </tr>
                    </table>
                    <% } %>
               <% }else{ %>
               検索結果はありません
               <% } %>
        </div>
    </body>
</html>
