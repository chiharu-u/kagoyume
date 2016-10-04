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
            
            UserData ud = new UserData();
            ud.setUserID(request.getParameter("buyid"));
            
            //DTOにマッピング
            UserDataDTO total = new UserDataDTO();
            ud.DTOMapping(total);
            
            UserDataDAO.getInstance().Total(total);
            
            //ArrayListで受け取る
            ArrayList<UserProductData> buyList = (ArrayList)hs.getAttribute("cartList");
            
            //商品分データベースへ挿入する
            for(int i = 0; i<buyList.size(); i++) {
                 UserDataDTO udd = new UserDataDTO();
                 
                 udd.setUserID(ud.getUserID());
                 
                 udd.setItemCode(buyList.get(i).getCode());
                 
                 udd.setType(Integer.parseInt(request.getParameter("type")));
                 
                 UserDataDAO.getInstance().BuyInsert(udd);
             }
             
            Log.getInstance().logfile("購入完了画面へ遷移");
             
            request.getRequestDispatcher("/buycomplete.jsp").forward(request, response);
            
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
