package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import kagoyume.UserProductData;
import java.util.ArrayList;
import kagoyume.KagoyumeHelper;
import kagoyume.UserDataDTO;
import java.util.Map;
import java.util.HashMap;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("    \n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

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

      out.write('\n');
      out.write('\n');

    HttpSession hs = request.getSession();
    UserDataDTO udd = (UserDataDTO)hs.getAttribute("loginData");
    KagoyumeHelper kh = KagoyumeHelper.getInstance();
    //urlをセッションに入れる
    hs.setAttribute("url", "index.jsp");

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"./css/prototype.css\"/>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"./css/style.css\"/>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Kagoyume/TOP</title>\n");
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
      out.write("            <!--　ログインチェック　-->\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/loginchk.jsp", out, true);
      out.write("\n");
      out.write("        </div>\n");
      out.write("        <!--\n");
      out.write("            ここからメイン\n");
      out.write("        -->\n");
      out.write("        <div id=\"main-box\">            \n");
      out.write("            <!--\n");
      out.write("                ここから検索フォーム\n");
      out.write("            -->\n");
      out.write("            <form action=\"Search\" method=\"get\">\n");
      out.write("                表示順序\n");
      out.write("                <select name=\"sort\">\n");
      out.write("                    <option value=\"-score\">");
      out.print( sortOrder.get("-score"));
      out.write("</option>\n");
      out.write("                    ");

                        for (Map.Entry<String, String> val : sortOrder.entrySet()) {
                            String i = val.getValue();
                            String a = val.getKey();
                    
      out.write("\n");
      out.write("                    <option value=\"");
      out.print( a);
      out.write('"');
      out.write('>');
      out.print( i);
      out.write("</option>\n");
      out.write("                    ");
 }
      out.write("\n");
      out.write("                </select>\n");
      out.write("                キーワード検索\n");
      out.write("                <select name=\"category_id\">\n");
      out.write("                    <option value=\"1\">");
      out.print( categories.get("1"));
      out.write("</option>\n");
      out.write("                    ");

                        for (Map.Entry<String, String> val : categories.entrySet()) {
                            String i = val.getValue();
                            String a = val.getKey();
                    
      out.write("\n");
      out.write("                    <option value=\"");
      out.print( a);
      out.write('"');
      out.write('>');
      out.print( i);
      out.write("</option>\n");
      out.write("                    ");
 }
      out.write("\n");
      out.write("                </select>\n");
      out.write("                <input type=\"text\" name=\"query\"> \n");
      out.write("                <input type=\"submit\" value=\"Yahooショッピングで検索\"/>               \n");
      out.write("            </form>\n");
      out.write("                <!--　yahooロゴ　Begin Yahoo! JAPAN Web Services Attribution Snippet -->\n");
      out.write("                <a href=\"http://developer.yahoo.co.jp/about\">\n");
      out.write("                <img src=\"http://i.yimg.jp/images/yjdn/yjdn_attbtn2_105_17.gif\" width=\"105\" height=\"17\" title=\"Webサービス by Yahoo! JAPAN\" alt=\"Webサービス by Yahoo! JAPAN\" border=\"0\" style=\"margin:15px 15px 15px 15px\"></a>\n");
      out.write("                <!-- End Yahoo! JAPAN Web Services Attribution Snippet -->\n");
      out.write("        </div>                \n");
      out.write("    </body>\n");
      out.write("</html>");
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
