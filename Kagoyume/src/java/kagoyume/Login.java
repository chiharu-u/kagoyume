/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kagoyume;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author uezuchiharu
 * 
 * ログイン管理ページ　どのページからも遷移できる。
 * ログインしているかいないかで処理が分岐する
 * ログインに成功すると、その情報をログイン状態を管理できるセッションに書き込み、
 * そのまま直前まで閲覧していたページに遷移する
 * 
 * ログインしている状態で(各ページの「ログアウト」というリンクから)遷移してきた場合は、
 * ログアウト処理を行う(セッションの破棄、クッキーに保存されたセッションIDを破棄)その後topへ
 * 
 * ユーザーデータの削除フラグが1の場合は削除されたユーザーとして処理すること
 * 
 */

public class Login extends HttpServlet {

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
        
        //セッション開始
        HttpSession hs = request.getSession();
        
        try {
        
        //エンコード
        request.setCharacterEncoding("UTF-8");
        
        String login = request.getParameter("login");
        
        ArrayList<UserProductData> cartList = (ArrayList)hs.getAttribute("cartList");
                
        
        //フォームのログインorログアウトによって処理を分岐
        if(login.equals("login")){

        //ユーザー名とパスワードを取得
        String name = request.getParameter("name");
        String password = request.getParameter("password");
                  
        //UserDataへ格納
        UserData ud = new UserData();
        ud.setName(name);
        ud.setPassword(password);
        
        //DTOへマッピング
        UserDataDTO userData  = new UserDataDTO();
        ud.DTOMapping(userData);
        
        UserDataDTO loginData = UserDataDAO.getInstance().selectUser(userData);
        
        if(loginData != null && loginData.getDeleteFlg() == 0){
                               
        //ユーザーデータをセッションに格納
        hs.setAttribute("loginData", loginData);
        
        //ログイン状態をセッションに格納
        hs.setAttribute("loginchk", "login");
       
        //直前まで閲覧していたページへフォワード
        //カートを見るを押してからログインの時はカートページへ
        if(cartList.size() != 0){
            response.sendRedirect("cart.jsp");
        }
        else{
           response.sendRedirect(new URI(request.getHeader("referer")).getPath());  
        }                
        }        
        else if(loginData.getDeleteFlg() == 1){
        //検索結果の値が空だった場合はエラーページへ遷移
        String error = "存在しないユーザーです";
        request.setAttribute("error", error);
        request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
        }
        
        //ログアウトを押された時はセッションをクリアしてホームへ戻る
        else{           
        hs.removeAttribute("loginData");
        hs.removeAttribute("loginchk");
        //ホームへリダイレクト
        response.sendRedirect("index.jsp");
        }   
        
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
