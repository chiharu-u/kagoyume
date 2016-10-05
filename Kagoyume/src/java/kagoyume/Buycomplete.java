/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kagoyume;

import java.io.IOException;
import java.io.PrintWriter;
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
public class Buycomplete extends HttpServlet {

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
        
        try{
            
            //エンコード
            request.setCharacterEncoding("UTF-8");
            
            //アクセスチェック
            String accesschk = request.getParameter("ac");
            if(accesschk == null || (Integer)hs.getAttribute("ac") != Integer.parseInt(accesschk)){
                throw new Exception("不正なアクセスです");
            } 
                     
            //ユーザーIDとtotal金額を取り出す
            int userID = Integer.parseInt(request.getParameter("buyid"));
            int totalprice = Integer.parseInt(request.getParameter("totalprice"));
            
            //購入者のユーザーIDとtotal金額をUserDataにセット
            UserData ud = new UserData();            
            ud.setUserID(userID);
            ud.setTotal(totalprice);
            
            //user_tテーブルのtotal
            UserDataDTO total = new UserDataDTO();                        
            //データベースへ挿入するためにDTOにマッピングする
            ud.DTOMapping(total);            
            //total金額を挿入する
            UserDataDAO.getInstance().Total(total);
            
            //セッションの中のcartlistを受け取る
            ArrayList <UserProductData> cartList = (ArrayList <UserProductData>)hs.getAttribute("cartList");
            
            //購入商品をデータベースへ入れる
            //リストに入っている数だけfor文で回す
            for(int i = 0; i < cartList.size(); i++) {
                
                //uddインスタンスを生成
                UserDataDTO udd = new UserDataDTO();
                 
                //ID,itemcode,発送種別をセットする（buyDateは挿入するときに作る）
                udd.setUserID(ud.getUserID());
                udd.setItemCode(cartList.get(i).getCode());
                udd.setType(Integer.parseInt(request.getParameter("type")));
                 
                //DAOからデータ挿入
                UserDataDAO.getInstance().BuyInsert(udd);
            }
            
            //ログファイル
            Log.getInstance().logfile("購入完了画面へ遷移");
             
            //購入後にカートの中身を消す
            cartList.clear();

            //購入完了画面へ遷移
            request.getRequestDispatcher("/buycomplete.jsp").forward(request, response);
            
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
