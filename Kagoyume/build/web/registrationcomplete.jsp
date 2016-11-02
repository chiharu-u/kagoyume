<%-- 
    Document   : registrationcomplete
    Created on : 2016/09/23, 17:54:39
    Author     : uezuchiharu
    
    登録結果画面
    プロフィール用のDBに値を挿入。この際、現在時(年日時分)を組み込み関数で取得し、追加。
    「以上の内容で登録しました。」とregistrationconfirmのようにフォームで入力された値を表示
    「トップページへ戻る」のリンクが、目立つ場所に設置されている
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="kagoyume.UserData"%>
<%@page import="kagoyume.KagoyumeHelper"%>
<%@page import="kagoyume.UserDataDTO"%>

<%   
    HttpSession hs = request.getSession();
    UserData ud = (UserData)request.getAttribute("ud");
    UserDataDTO udd = (UserDataDTO)hs.getAttribute("loginData");
    KagoyumeHelper kh = KagoyumeHelper.getInstance();
%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="./css/style.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Kafoyume/登録結果画面</title>
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
            <h4>登録結果</h4>
            <p>
                氏名：<%= ud.getName() %><br>
                パスワード：<%= ud.getPassword() %><br>
                メールアドレス：<%= ud.getMail() %><br>
                住所：<%= ud.getAddress() %><br>
                <br>
                以上の内容で登録しました。
                <br>
            </p>
            <!-- ホーム画面へのリンク -->
            <%= kh.home() %>
        </div>
    </body>
</html>
