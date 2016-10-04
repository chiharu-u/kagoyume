/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kagoyume;

import java.io.*;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author uezuchiharu
 */
public class Registrationcomplete extends HttpServlet {

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
        HttpSession session = request.getSession();
       
        try {
            
            //エンコード
            request.setCharacterEncoding("UTF-8");
            
            //アクセスチェック
//            String accesschk = request.getParameter("ac");
//            if(accesschk == null || (Integer)session.getAttribute("ac") != Integer.parseInt(accesschk)){
//                throw new Exception("不正なアクセスです");
//            }
            
            
            UserData ud  = (UserData)session.getAttribute("ud");
            
            //DTOに変換する　DTO→DAO→データベース挿入
            UserDataDTO userdata = new UserDataDTO();
            ud.DTOMapping(userdata);
            
            //DBへデータを挿入する
            UserDataDAO.getInstance().insert(userdata);
            
            //ログ処理
            File log = new File("log.txt");
            FileWriter fw = new FileWriter(log);
            BufferedWriter bw = new BufferedWriter(fw);
            Date time = new Date();
            //bw.write(time);
            bw.write("新規登録完了");
            bw.close();
            
            //成功した時はセッションの値を削除する
            session.invalidate();
            
            //登録結果画面で表示をするのでリクエストスコープに格納
            request.setAttribute("ud", ud);
            
            //ログに記録する
            Log.getInstance().logfile("登録完了画面へ遷移");
            
            //登録結果画面jspにフォワード
            request.getRequestDispatcher("/registrationcomplete.jsp").forward(request, response);
        
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
