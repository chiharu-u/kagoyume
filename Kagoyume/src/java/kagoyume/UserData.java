/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kagoyume;

import java.io.Serializable;

/**
 *
 * @author uezuchiharu
 * 
 * フォームからの入出力されるデータを格納するBeansオブジェクト
 * DTOからの変換、逆に、ＤＴＯへの変換を行うメソッドを保持する
 * 
 */

public class UserData implements Serializable{    
    
    //変数を定義
    private int userID;
    private String name;
    private String password;
    private String mail;
    private String address;
    private int total;
    
    //コンストラクタで初期値を設定しておく
    public UserData(){
        this.userID = 0;
        this.name = "";
        this.password = "";
        this.mail = "";
        this.address = "";  
        this.total = 0;
    }
    
    //get,setメソッド
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
    public void  setMail(String mail){
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

    /**
     * DAOからDBへ値を入れるためにDTOへ変換
     * udb > DTO (udb > DTO > DAO)
     * 
     * @param udd
     */
    public void DTOMapping(UserDataDTO udd) {
        udd.setUserID(this.userID);
        udd.setName(this.name);
        udd.setPassword(this.password);
        udd.setMail(this.mail);
        udd.setAddress(this.address);
        udd.setTotal(this.total);
    }    
    
    /**
     * DBから出した値をUDBへ入れるために変換
     * DTO > udb (DAO > DTO > udb)
     * 
     * @param udd
     */
    public void UDBMapping(UserDataDTO udd){
        
        //値を入れるudインタンスを生成
        UserData ud = new UserData();
        //値をセットしていく
        ud.setUserID(userID);
        ud.setName(udd.getName());
        ud.setPassword(udd.getPassword());
        ud.setMail(udd.getMail());
        ud.setAddress(udd.getAddress());
        ud.setTotal(total);
    }
}