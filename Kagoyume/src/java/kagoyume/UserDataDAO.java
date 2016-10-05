/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kagoyume;

import base.DBManager;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author uezuchiharu
 * 
 * データベース処理系全般をつかさどるオブジェクト
 * 基本的にデータはUserDataDTO経由
 * 
 * DAO > データベース
 * 
 */
public class UserDataDAO {
    
    //インスタンスオブジェクトを返却させてコードの簡略化
    public static UserDataDAO getInstance(){
        return new UserDataDAO();
    }
    
    /**
     * DBへのデータの挿入
     * @param ud
     * @throws java.sql.SQLException
    */
   
    public void insert(UserDataDTO ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection()
                    ;
            String sql = "INSERT INTO user_t(name,password,mail,address,newDate) VALUES(?,?,?,?,?)";
            
            st = con.prepareStatement(sql);
            
            st.setString(1, ud.getName());
            st.setString(2, ud.getPassword());
            st.setString(3, ud.getMail());
            st.setString(4, ud.getAddress());
            st.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
    
            st.executeUpdate();
            System.out.println("insert completed");
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }
    }
    
    /**
     * 
     * ログイン
     * userIDとpasswordを使ってユーザーを検索をする
     * @param ud
     * @return 
     * @throws java.sql.SQLException
     */
    
    public UserDataDTO selectUser (UserDataDTO ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        
        try{
            con = DBManager.getConnection();
            
            String sql = "SELECT * FROM user_t WHERE name = ? and password = ?";
            
            st = con.prepareStatement(sql);
            
            st.setString(1, ud.getName());
            st.setString(2, ud.getPassword());
            
            ResultSet rs = st.executeQuery();
            
            rs.next();
            UserDataDTO resultUD = new UserDataDTO();
            
            resultUD.setUserID(rs.getInt(1));
            resultUD.setName(rs.getString(2));
            resultUD.setPassword(rs.getString(3));
            resultUD.setMail(rs.getString(4));
            resultUD.setAddress(rs.getString(5));
            resultUD.setTotal(rs.getInt(6));
            resultUD.setNewDate(rs.getTimestamp(7));
            resultUD.setDeleteFlg(rs.getInt(8));
            
            System.out.println("select user completed"); 
            
            return resultUD;
        
        } catch (SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally {
            if(con != null){
                con.close();
            }
        }
    }
       
    /**
     * 登録情報の更新
     * @param ud
     * @throws java.sql.SQLException
     */
    
    public void update (UserDataDTO ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        
        try{
            con = DBManager.getConnection();
            
            String sql = "UPDATE user_t SET name = ?, password = ?, mail = ?, address = ? WHERE userID = ?";
            
            st = con.prepareStatement(sql);
            
            st.setString(1, ud.getName());
            st.setString(2, ud.getPassword());
            st.setString(3, ud.getMail());
            st.setString(4, ud.getAddress());
            st.setInt(5, ud.getUserID());
            
            st.executeUpdate();
            
            System.out.println("update completed");
        
        }catch (SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }
    }
    
    /**
     * 削除
     * 外部キー制約により直接DELETEは出来ないので、削除フラグを0から1に変更する)
     * 「削除しました｝という一文が表示される
     * @param ud
     * @throws java.sql.SQLException
     */
    
    public void delete (UserDataDTO ud) throws SQLException{
        
        Connection con = null;
        PreparedStatement st = null;
        
        try{
            con= DBManager.getConnection();
            
            String sql = "UPDATE user_t SET deleteFlg = ? WHERE userID = ?";                    
            
            st = con.prepareStatement(sql);
           
            st.setInt(1, 1);
            st.setInt(2, ud.getUserID());
            
            st.executeUpdate();
            
            System.out.println("delete completed");
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
                   
        }finally{
            if (con != null){
                con.close();
            }
        }
    } 
    /**
     * 購入商品データの挿入
     * @param ud
     * @throws java.sql.SQLException
     */
    
    public void BuyInsert(UserDataDTO ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = DBManager.getConnection();
            
            String sql = "INSERT INTO buy_t(userID,itemCode,type,buyDate) VALUES(?,?,?,?)";
            
            st = con.prepareStatement(sql);
            
            st.setInt(1, ud.getUserID());
            st.setString(2, ud.getItemCode());
            st.setInt(3, ud.getType());
            st.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
    
            st.executeUpdate();
            System.out.println("insert completed");
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }
    }
    
    /**
     * 購入履歴の検索（history） 
     * @param ud
     * @return 
     * @throws java.sql.SQLException 
     */
    
    public ArrayList<UserDataDTO> SearchItem(UserDataDTO ud) throws SQLException{
        
        Connection con = null;
        PreparedStatement st = null;
        
        try {
            con = DBManager.getConnection()
                    ;
            String sql = "SELECT * FROM buy_t WHERE userID = ?";
            
            st = con.prepareStatement(sql);
            
            st.setInt(1, ud.getUserID());
            
            ResultSet rs = st.executeQuery();
            
            //リストを作成
            ArrayList<UserDataDTO> udlist = new ArrayList<UserDataDTO>();
            
            while(rs.next()){
                UserDataDTO udd = new UserDataDTO();
                udd.setBuyID(rs.getInt(1));
                udd.setUserID(rs.getInt(2));
                udd.setItemCode(rs.getString(3));
                udd.setType(rs.getInt(4));
                udd.setNewDate(rs.getTimestamp(5));
                
                //リストに追加
                udlist.add(udd);
            }
            
            System.out.println("SearchItem completed!");
            
            return udlist;
            
            }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }

    }
    
    /**
     * 合計金額をuser_tへセットする
     * @param ud
     * @throws java.sql.SQLException
     */
    
    public void Total(UserDataDTO ud) throws SQLException{
        
        Connection con = null;
        PreparedStatement st = null;
        
        try{
            con = DBManager.getConnection();
            
            //totalに加算して更新する　（total = ? + total）
            String sql = "UPDATE user_t SET total = ? + total WHERE userID= ?" ;
            
            st =  con.prepareStatement(sql);        
            st.setInt(1, ud.getTotal());
            st.setInt(2, ud.getUserID());
            st.executeUpdate();
            
            System.out.println("totalupdate completed");

        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }
    }
}