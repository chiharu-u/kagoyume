<%-- 
    Document   : registrationconfirm
    Created on : 2016/09/23, 16:12:04
    Author     : uezuchiharu
    
    登録確認画面    
    フォームで入力された文字や選択を表示し、「上記の内容で登録いたします。よろしいですか？」と表示。
    「はい」でregistrationcomplete
    「いいえ」でregistrationに値を保持したまま(戻った時にフォーム入力済みになっている)遷移
    もし不足していた場合はどの項目のデータが不足しているのかを表示。
    registrationに値を保持したまま遷移するリンクを表示
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="kagoyume.KagoyumeHelper"%>
<%@page import="kagoyume.UserDataDTO"%>
<%@page import="kagoyume.UserData"%>

<%    
    HttpSession hs = request.getSession();
    UserData ud = (UserData)hs.getAttribute("ud");
    UserDataDTO udd = (UserDataDTO)hs.getAttribute("loginData");
    KagoyumeHelper kh = KagoyumeHelper.getInstance();  
%>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="./css/style.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Kagoyume/登録確認画面</title>
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
            <h4>登録確認</h4>
            <p>
                氏名：<%= ud.getName() %><br>
                パスワード：<%= ud.getPassword() %><br>
                メールアドレス：<%= ud.getMail() %><br>
                住所：<%= ud.getAddress() %><br>
                上記の内容で登録します。よろしいですか？
            </p>
            <form action="Registrationcomplete" method="post">
                <%-- アクセスチェッック　--%>
                <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
                <input type="submit" name="yes" value="はい">
            </form>
            <form action="Registration" method="post">
                <input type="hidden" name="mode" value="reinput">
                <input type="submit" name="back" value="登録画面に戻る">
            </form>
        </div>
    </body>
</html>
