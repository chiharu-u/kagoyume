/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kagoyume;

import java.io.*;
import java.util.*;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author uezuchiharu
 * 
 * topから検索により遷移できる。
 * YahooショッピングAPIに直接検索キーワードを渡し、その結果を受け取り＆表示している
 * 検索キーワード、検索結果数を表示
 * 縦のリスト型に表示。サムネイルと、その横に商品名、金額が載っている。クリックでitemへ
 * 結果は上位20件まで
 * 
 */

public class Search extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession hs = request.getSession();
        
        try {
            
            //エンコード
            request.setCharacterEncoding("UTF-8");
        
            //フォームの値を取得
            String y_Query = request.getParameter("query");
            int y_category = Integer.parseInt(request.getParameter("category_id"));
            String y_sort = request.getParameter("sort");
        
            String result = "";
            
            //APIへのアクセス
            String baceurl = "http://shopping.yahooapis.jp/ShoppingWebService/V1/json/itemSearch?appid=dj0zaiZpPWYyM3NlUWxwVU1TTCZzPWNvbnN1bWVyc2VjcmV0Jng9NGY-&query=" + y_Query + "&category_id=" + y_category + "&sort=" + y_sort;
            
            //URLオブジェクトを作成
            URL url = new URL(baceurl);
            
            //HTTPサーバーへのネットワーク接続
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            
            con.connect();
            
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

            String tmp = "";
            
            //１行ずつ読み込む
            while ((tmp = in.readLine()) != null) {
                result += tmp;
            }

            in.close();
            
            con.disconnect();
            
            JsonNode head = null;
            
            JsonFactory jfactory = new JsonFactory();
            
            JsonParser parser;
            
            parser = jfactory.createJsonParser(result);

            ObjectMapper mapper = new ObjectMapper();
            
            head = mapper.readTree(parser);
            
            
            //取り出すとき途中まで一緒なので変数に入れる
            JsonNode node = head.get("ResultSet").get("0").get("Result");          
            
            //Arraylistに入れてsearch.jspで表示
            ArrayList<UserProductData>list = new ArrayList<>();                      
           
            if(list != null){
                for (int i =0; i < node.size()-3; i++){
                UserProductData itemResult = new UserProductData();
                itemResult.setName(node.get(String.valueOf(i)).get("Name").asText());
                itemResult.setCode(node.get(String.valueOf(i)).get("Code").asText());
                itemResult.setDescription(node.get(String.valueOf(i)).get("Description").asText());
                itemResult.setPrice(node.get(String.valueOf(i)).get("Price").get("_value").asInt());
                itemResult.setImgURLm(node.get(String.valueOf(i)).get("Image").get("Medium").asText());
                itemResult.setImgURLs(node.get(String.valueOf(i)).get("Image").get("Small").asText());
                itemResult.setRate(node.get(String.valueOf(i)).get("Review").get("Rate").asText());
                list.add(itemResult);
                hs.setAttribute("list", list);
            }
            }
            
            //検索数と検索ワードを取り出す
            int totalsearch = head.get("ResultSet").get("totalResultsAvailable").asInt();
            String query = node.get("Request").get("Query").asText();
            
            //セッションに入れる
            hs.setAttribute("totalsearch", totalsearch);
            hs.setAttribute("query", query);
            
            //ログ
            Log.getInstance().logfile("検索結果画面へ遷移");
            
            //アクセスチェックのための乱数を作る
            hs.setAttribute("ac", (int)(Math.random() * 1000));

            //検索結果ページへ遷移
            request.getRequestDispatcher("/search.jsp").forward(request, response);
            
        }catch(Exception e){
        request.setAttribute("error", e.getMessage());
        request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
