/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kagoyume;

import java.sql.Timestamp;

/**
 *
 * @author uezuchiharu
 * 
 * ユーザー情報を格納するBeansオブジェクト。型やフィールド名がＤＢと連携している
 * データベースからの格納、取り出しで取得されたデータを最初に格納する
 * 
 */
public class UserDataDTO {
    
    //変数を定義
    //user_t
    private int userID; //変数名書く
    private String name;
    private String password;
    private String mail;
    private String address;
    private int total;
    private Timestamp newDate;
    private int deleteFlg;
    
    //buy_t
    private int buyID;
    private String itemCode;
    private int type;
    private Timestamp buyDate;   
    
    //get,setメソッド
    //uset_t
    public int getUserID(){
        return userID;
    }
    public void setUserID(int userID){
        this.userID = userID;
    }
    
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }
    
    public String getMail(){
        return mail;
    }
    public void setMail(String mail){
        this.mail = mail;
    }
    
    public String getAddress(){
        return address;
    }
    public void setAddress(String address){
        this.address = address;
    }
    
    public int getTotal(){
        return total;
    }
    public void setTotal(int total){
        this.total = total;
    }
    
    public Timestamp getNewDate(){
        return newDate;
    }
    public void setNewDate(Timestamp newDate){
        this.newDate = newDate;
    }
    
    public int getDeleteFlg(){
        return deleteFlg;
    }
    public void setDeleteFlg(int deleteFlg){
        this.deleteFlg = deleteFlg;
    }
    
    //buy_t
    public int getBuyID(){
        return buyID;
    }
    public void setBuyID(int buyID){
        this.buyID = buyID;
    }
    
    public String getItemCode(){
        return itemCode;
    }
    public void setItemCode(String itemCode){
        this.itemCode = itemCode;
    }
    
    public int getType(){
        return type;
    }
    public void setType(int type){
        this.type = type;
    }
    
    public Timestamp getBuyDate(){
        return buyDate;
    }
    public void setBuyID(Timestamp buyDate){
        this.buyDate = buyDate;
    }
    
}
