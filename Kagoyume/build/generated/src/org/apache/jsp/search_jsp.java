package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.net.URL;
import kagoyume.UserProductData;
import java.util.ArrayList;
import kagoyume.KagoyumeHelper;
import kagoyume.UserDataDTO;

public final class search_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");

    HttpSession hs = request.getSession();
    UserDataDTO udd = (UserDataDTO)hs.getAttribute("loginData");
    KagoyumeHelper kh = KagoyumeHelper.getInstance();
    ArrayList <UserProductData> list = (ArrayList <UserProductData> )hs.getAttribute("list");

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"./css/style.css\"/>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Kagoyume/検索結果ページ</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <!--        \n");
      out.write("            ここからヘッダー\n");
      out.write("        -->\n");
      out.write("        <div id=\"header\">\n");
      out.write("            <!--　サイトタイトル・説明　-->\n");
      out.write("            ");
      out.print( kh.title() );
      out.write("\n");
      out.write("            ");
      out.print( kh.subTitle() );
      out.write("\n");
      out.write("            \n");
      out.write("            <!--　\n");
      out.write("                セッションに入れたloginchkを取り出して、\n");
      out.write("                ログイン中であればユーザー名・ログアウト・買い物かごを表示する\n");
      out.write("            -->\n");
      out.write("            ");
 if("login".equals(hs.getAttribute("loginchk"))){ 
      out.write("\n");
      out.write("            <a href=\"mydata.jsp\">");
      out.print( udd.getName() );
      out.write("</a>さん&nbsp;ようこそ！           \n");
      out.write("            <a href=\"Cart\">買い物かご</a>\n");
      out.write("            <!--　ログアウトする時は、クエリストリングで値を送ってLogin.javaで分岐させる　-->\n");
      out.write("            <a href=\"Login?login=logout\">ログアウト</a>            \n");
      out.write("            ");
 } else{ 
      out.write("\n");
      out.write("            <!--　ログインへのリンク　-->\n");
      out.write("            ");
      out.print( kh.login() );
      out.write("\n");
      out.write("            ");
 } 
      out.write("\n");
      out.write("        </div>\n");
      out.write("        <!--\n");
      out.write("            ここからメイン\n");
      out.write("        -->\n");
      out.write("        <div id=\"main-box\">\n");
      out.write("            ");

                if(list.size() != 0){
                    for(int i = 0; i < list.size(); i++){                        
                    UserProductData upd = list.get(i); 
      out.write("                   \n");
      out.write("                    <table>\n");
      out.write("                        <tr>\n");
      out.write("                            <td rowspan = 3><IMG src=\"");
      out.print( upd.getImgURLm() );
      out.write("\"></td>\n");
      out.write("                            <td colspan = 2>");
      out.print( upd.getName() );
      out.write("</td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td colspan = 2>");
      out.print( upd.getDescription() );
      out.write("</td>    \n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>");
      out.print( upd.getPrice() );
      out.write("円</td>\n");
      out.write("                            <td>評価：");
      out.print( upd.getRate() );
      out.print( upd.getCode() );
      out.write("</td>\n");
      out.write("                            <td>\n");
      out.write("                                <form action=\"Item?itemCode=");
      out.print( upd.getCode() );
      out.write("\" method=\"get\">\n");
      out.write("                                    <input type=\"submit\" name=\"item\" value=\"商品詳細\">\n");
      out.write("                                </form>\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                    </table>\n");
      out.write("                    ");
 } 
      out.write("\n");
      out.write("               ");
 }else{ 
      out.write("\n");
      out.write("検索結果はありません\n");
}               
      out.write("\n");
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
