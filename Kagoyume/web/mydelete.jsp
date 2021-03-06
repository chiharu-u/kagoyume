<%--
    Document   : mydelete
    Created on : 2016/09/26, 11:44:40
    Author     : uezuchiharu

    ユーザー削除確認ページ
    対象のレコードの全データを表示したのちに、「このユーザーをマジで削除しますか？」という質問があり、
    「はい」と「いいえ」が直リンクとして設置してある。「はい」ならmydeleteresultへ、そうでないならトップページへ遷移する
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="kagoyume.KagoyumeHelper"%>
<%@page import="kagoyume.UserDataDTO"%>

<%
    HttpSession hs = request.getSession();
    UserDataDTO udd = (UserDataDTO)hs.getAttribute("loginData");
    KagoyumeHelper kh = KagoyumeHelper.getInstance();   
%>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="./css/style.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Kagoyume/削除確認画面</title>
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
            <h4>削除確認</h4>
            以下の内容を削除します。よろしいですか？
            <br>
            <br>
            ユーザーID：<%= udd.getUserID() %><br>
            氏名：<%= udd.getName() %><br>
            パスワード：<%= udd.getPassword() %><br>
            メールアドレス：<%= udd.getMail() %><br>
            住所：<%= udd.getAddress() %><br>
            購入金額：<%= udd.getTotal() %>円<br>
            登録日：<%= udd.getNewDate() %><br>
            <br>
            <form action="MydeleteResult?id=<%= udd.getUserID() %>" method="post">
                <%-- アクセスチェッック　--%>
                <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
                <input type="submit" name="yes" value="はい" style="width: 100px">
            </form>
            <form>
                <input type="submit" name="no" value="TOPへ戻る" style="width: 100px">
            </form>
        </div>
    </body>
</html>