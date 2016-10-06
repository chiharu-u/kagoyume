/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kagoyume;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author uezuchiharu
 */
public class Myhistory extends HttpServlet {

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
        
        HttpSession hs = request.getSession();
        
        try {
            
            //エンコード
            request.setCharacterEncoding("UTF-8");
            
            //検索するidを取り出す
            int userID = Integer.parseInt(request.getParameter("userid"));
            
            //UserDataにセット
            UserData ud = new UserData();
            ud.setUserID(userID);
            
            //DTOにマッピング
            UserDataDTO buylist = new UserDataDTO();
            ud.DTOMapping(buylist);
            
            //ArrayListで受け取る
            ArrayList <UserDataDTO> resultdata = UserDataDAO.getInstance().SearchItem(buylist);
            
            String itemcode = "";
            
            //商品コードで検索した値を入れる
            ArrayList <UserProductData> updlist = new ArrayList();            
                      
            if(!resultdata.isEmpty()){
                for(int i = 0; i < resultdata.size(); i++){
                   itemcode = resultdata.get(i).getItemCode();                          
                   
                   String baceURL = "http://shopping.yahooapis.jp/ShoppingWebService/V1/json/itemLookup?appid=dj0zaiZpPWYyM3NlUWxwVU1TTCZzPWNvbnN1bWVyc2VjcmV0Jng9NGY-&itemcode=" + itemcode;
            
                   //URLオブジェクトを作成
                   URL url = new URL(baceURL);
            
                   //HTTPサーバーへのネットワーク接続
                   HttpURLConnection con = (HttpURLConnection) url.openConnection();
            
                   con.connect();
            
                   BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

                   String tmp = "";
            
                   String result = "";
            
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
                   JsonNode node = head.get("ResultSet").get("0").get("Result").get("0");
            
                   UserProductData itemResult = new UserProductData();
                   
                   itemResult.setName(node.get("Name").asText());
                   itemResult.setPrice(node.get("Price").get("_value").asInt());
                   itemResult.setImgURLs(node.get("Image").get("Small").asText());
                   updlist.add(itemResult);
                   hs.setAttribute("buylist", updlist);
                }
            }else{
                hs.setAttribute("noitem", "購入商品はありません！");
            }
            
            //フォワード
            request.getRequestDispatcher("/myhistory.jsp").forward(request, response);
        
        //例外処理
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
