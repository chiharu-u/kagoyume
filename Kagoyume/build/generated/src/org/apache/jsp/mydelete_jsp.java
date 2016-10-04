package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import kagoyume.UserDataDTO;

public final class mydelete_jsp extends org.apache.jasper.runtime.HttpJspBase
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

HttpSession hs = request.getSession();
UserDataDTO udd = (UserDataDTO)hs.getAttribute("loginData");

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("         <!--        \n");
      out.write("            ここからヘッダー\n");
      out.write("        -->\n");
      out.write("        <div id=\"header\">\n");
      out.write("            <!--　サイトタイトル・説明　-->\n");
      out.write("            <h2>Kagoyume</h2>\n");
      out.write("            <h4>「金銭取引が絶対に発生しない」どんなもので購入できる気分になれるサイトです！</h4>            \n");
      out.write("        </div>\n");
      out.write("        <!--\n");
      out.write("            ここからメイン\n");
      out.write("        -->\n");
      out.write("        <div id=\"main-box\">\n");
      out.write("            <h4>削除確認</h4>\n");
      out.write("            以下の内容を削除します。よろしいですか？\n");
      out.write("            <br>\n");
      out.write("            ユーザーID：");
      out.print( udd.getUserID() );
      out.write("\n");
      out.write("            氏名：");
      out.print( udd.getName() );
      out.write("\n");
      out.write("            パスワード：");
      out.print( udd.getPassword() );
      out.write("\n");
      out.write("            メールアドレス：");
      out.print( udd.getMail() );
      out.write("\n");
      out.write("            住所：");
      out.print( udd.getAddress() );
      out.write("\n");
      out.write("            購入金額：");
      out.print( udd.getTotal() );
      out.write("\n");
      out.write("            登録日：");
      out.print( udd.getNewDate() );
      out.write("\n");
      out.write("            <br>\n");
      out.write("            <form action=\"mydeleteResult?id=");
      out.print( udd.getUserID() );
      out.write("\" method=\"post\">\n");
      out.write("                <input type=\"hidden\" name=\"ac\" value=\"ac\">\n");
      out.write("                <input type=\"submit\" name=\"yes\" value=\"はい\" style=\"width: 100px\">\n");
      out.write("            </form>\n");
      out.write("            <form>\n");
      out.write("                <input type=\"hidden\" name=\"ac\" value=\"ac\">\n");
      out.write("                <input type=\"submit\" name=\"no\" value=\"TOPへ戻る\" style=\"width: 130px\">\n");
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
