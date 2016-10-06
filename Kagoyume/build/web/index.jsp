    <%@page import="kagoyume.UserProductData"%>
<%@page import="java.util.ArrayList"%>
<%-- 
    Document   : top
    Created on : 2016/09/23, 10:43:40
    Author     : uezuchiharu

    ＜トップページ＞
    トップページ。ルートはここである
    このシステムの簡単な説明が記載されている。テキストは自由
    キーワード検索フォームが設置されている。
    検索の遷移先はsearchで、GETメソッド。未入力ならエラーを表示
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="kagoyume.KagoyumeHelper"%>
<%@page import="kagoyume.UserDataDTO"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>

<%
                //フォームタグプルダウン
                //カテゴリー　HashMap
                HashMap<String, String> categories = new HashMap();

                categories.put("1", "すべてのカテゴリから");
                categories.put("13457", "ファッション");
                categories.put("2498", "食品");
                categories.put("2500", "ダイエット、健康");
                categories.put("2501", "コスメ、香水");
                categories.put("2502", "パソコン、周辺機器");
                categories.put("2504", "AV機器、カメラ");
                categories.put("2505", "家電");
                categories.put("2506", "家具、インテリア");
                categories.put("2507", "花、ガーデニング");
                categories.put("2508", "キッチン、生活雑貨、日用品");
                categories.put("2503", "DIY、工具、文具");
                categories.put("2509", "ペット用品、生き物");
                categories.put("2510", "楽器、趣味、学習");
                categories.put("2511", "ゲーム、おもちゃ");
                categories.put("2497", "ベビー、キッズ、マタニティ");
                categories.put("2512", "スポーツ");
                categories.put("2513", "レジャー、アウトドア");
                categories.put("2514", "自転車、車、バイク用品");
                categories.put("2516", "CD、音楽ソフト");
                categories.put("2517", "DVD、映像ソフト");
                categories.put("10002", "本、雑誌、コミック");

                //ソート　HashMap
                HashMap<String, String> sortOrder = new HashMap();

                sortOrder.put("-score", "おすすめ順");
                sortOrder.put("+price", "商品価格が安い順");
                sortOrder.put("-price", "商品価格が高い順");
                sortOrder.put("+name", "ストア名昇順");
                sortOrder.put("-name", "ストア名降順");
                sortOrder.put("-sold", "売れ筋順");
%>

<%
    HttpSession hs = request.getSession();
    UserDataDTO udd = (UserDataDTO)hs.getAttribute("loginData");
    KagoyumeHelper kh = KagoyumeHelper.getInstance();
    //urlをセッションに入れる
    hs.setAttribute("url", "index.jsp");
%>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="./css/prototype.css"/>
        <link rel="stylesheet" type="text/css" href="./css/style.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Kagoyume/TOP</title>
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
            <a href="Mydata"><%= udd.getName() %></a>さん&nbsp;ようこそ！           
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
            <!--
                ここから検索フォーム
            -->
            <form action="Search" method="get">
                表示順序
                <select name="sort">
                    <option value="-score"><%= sortOrder.get("-score")%></option>
                    <%
                        for (Map.Entry<String, String> val : sortOrder.entrySet()) {
                            String i = val.getValue();
                            String a = val.getKey();
                    %>
                    <option value="<%= a%>"><%= i%></option>
                    <% }%>
                </select>
                キーワード検索
                <select name="category_id">
                    <option value="1"><%= categories.get("1")%></option>
                    <%
                        for (Map.Entry<String, String> val : categories.entrySet()) {
                            String i = val.getValue();
                            String a = val.getKey();
                    %>
                    <option value="<%= a%>"><%= i%></option>
                    <% }%>
                </select>
                <input type="text" name="query"> 
                <input type="submit" value="Yahooショッピングで検索"/>               
            </form>
                <!--　yahooロゴ　Begin Yahoo! JAPAN Web Services Attribution Snippet -->
                <a href="http://developer.yahoo.co.jp/about">
                <img src="http://i.yimg.jp/images/yjdn/yjdn_attbtn2_105_17.gif" width="105" height="17" title="Webサービス by Yahoo! JAPAN" alt="Webサービス by Yahoo! JAPAN" border="0" style="margin:15px 15px 15px 15px"></a>
                <!-- End Yahoo! JAPAN Web Services Attribution Snippet -->
        </div>                
    </body>
</html>