package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import kagoyume.UserData;

public final class registrationconfirm_jsp extends org.apache.jasper.runtime.HttpJspBase
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

    //セッション開始
    HttpSession hs = request.getSession();
    //セッションの中のudを取り出す
    UserData ud = (UserData)hs.getAttribute("ud");


      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <link rel=\"stylesheet\" href=\"./css/style.css\"/>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Kagoyume/登録確認画面</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <!--        \n");
      out.write("            ここからヘッダー\n");
      out.write("        -->\n");
      out.write("        <div id=\"header\">\n");
      out.write("            <!--　サイトタイトル・説明　-->\n");
      out.write("            <h2>Kagoyume</h2>\n");
      out.write("            <h4>「金銭取引が絶対に発生しない」どんなもので購入できる気分になれるサイトです！</h4>\n");
      out.write("        </div>\n");
      out.write("        <!--\n");
      out.write("            ここからメイン\n");
      out.write("        -->\n");
      out.write("        <div id=\"main-box\">\n");
      out.write("            <h4>登録確認</h4>\n");
      out.write("            <p>\n");
      out.write("                氏名：");
      out.print( ud.getName() );
      out.write("<br>\n");
      out.write("                パスワード：");
      out.print( ud.getPassword() );
      out.write("<br>\n");
      out.write("                メールアドレス：");
      out.print( ud.getMail() );
      out.write("<br>\n");
      out.write("                住所：");
      out.print( ud.getAddress() );
      out.write("<br>\n");
      out.write("                上記の内容で登録します。よろしいですか？\n");
      out.write("            </p>\n");
      out.write("            <form action=\"Registrationcomplete\" method=\"post\">\n");
      out.write("                <input type=\"hidden\" name=\"ac\" value=\"ac\">\n");
      out.write("                <input type=\"submit\" name=\"yes\" value=\"はい\">\n");
      out.write("            </form>\n");
      out.write("            <form action=\"registration\" method=\"post\">\n");
      out.write("                <input type=\"hidden\" name=\"mode\" value=\"REINPUT\">\n");
      out.write("                <input type=\"submit\" name=\"no\" value=\"登録画面に戻る\">\n");
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
