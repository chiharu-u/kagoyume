package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import kagoyume.UserDataDTO;
import kagoyume.KagoyumeHelper;

public final class mydata_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

    HttpSession hs = request.getSession();  
    UserDataDTO udd = (UserDataDTO)hs.getAttribute("loginData");
    KagoyumeHelper kh = KagoyumeHelper.getInstance();

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <link rel=\"stylesheet\" href=\"./css/style.css\"/>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <!--        \n");
      out.write("            ここからヘッダー\n");
      out.write("        -->\n");
      out.write("        <div id=\"header\">\n");
      out.write("            <!--　サイトタイトル・説明　-->\n");
      out.write("            <h2>Kagoyume</h2>\n");
      out.write("            <h4>「金銭取引が絶対に発生しない」どんなもので購入できる気分になれるサイトです！</h4>\n");
      out.write("             \n");
      out.write("            <!--　\n");
      out.write("                セッションに入れたloginchkを取り出して、\n");
      out.write("                ログイン中であればユーザー名・ログアウト・買い物かごを表示する\n");
      out.write("            -->\n");
      out.write("            ");
 if("login".equals(hs.getAttribute("loginchk"))){ 
      out.write("\n");
      out.write("            <a href=\"mydata.jsp\">");
      out.print( udd.getName() );
      out.write("</a>さんようこそ！           \n");
      out.write("            <a href=\"Cart\">買い物かご</a>\n");
      out.write("            <!--　ログアウトする時は、クエリストリングで値を送ってLogin.javaで分岐させる　-->\n");
      out.write("            <a href=\"Login?login=logout\">ログアウト</a>            \n");
      out.write("            ");
 } else{ 
      out.write("\n");
      out.write("            <!--　ログインリンク　-->\n");
      out.write("            ");
      out.print( kh.login() );
      out.write("\n");
      out.write("            ");
 } 
      out.write("\n");
      out.write("            ");
      out.print( kh.home() );
      out.write("\n");
      out.write("        </div>\n");
      out.write("        <!--\n");
      out.write("            ここからメイン\n");
      out.write("        -->\n");
      out.write("        <div id=\"main-box\">            \n");
      out.write("            <h4>登録情報</h4>\n");
      out.write("            名前：");
      out.print( udd.getName() );
      out.write("<br>\n");
      out.write("            パスワード：");
      out.print( udd.getPassword() );
      out.write("<br>\n");
      out.write("            メールアドレス：");
      out.print( udd.getMail() );
      out.write("<br>\n");
      out.write("            住所：");
      out.print( udd.getAddress() );
      out.write("<br>\n");
      out.write("            購入金額：");
      out.print( udd.getTotal() );
      out.write("円<br>\n");
      out.write("            登録日：");
      out.print( udd.getNewDate() );
      out.write("<br>\n");
      out.write("            <br>\n");
      out.write("            <!--　購入履歴一覧画面へのリンク　-->\n");
      out.write("            <a href=\"Myhistory\">購入履歴</a>\n");
      out.write("            <br>\n");
      out.write("            <br>\n");
      out.write("            <!-- 登録情報の変更画面へ　-->\n");
      out.write("            <form action=\"myupdate\" method=\"post\">\n");
      out.write("                <input type=\"hidden\" name=\"ac\" value=\"ac\">\n");
      out.write("                <input type=\"submit\" name=\"update\" value=\"変更\" style=\"width: 100px\">\n");
      out.write("            </form>\n");
      out.write("            <!--　ユーザーデータ削除　確認画面へ　-->\n");
      out.write("            <form action=\"mydelete\" method=\"post\">\n");
      out.write("                <input type=\"hidden\" name=\"ac\" value=\"ac\">\n");
      out.write("                <input type=\"submit\" name=\"delete\" value=\"削除\" style=\"width: 100px\">\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
