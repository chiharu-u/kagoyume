/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kagoyume;

/**
 *
 * @author uezuchiharu
 */
public class UserProductData {
    
    //変数設定
    private String name; //商品の名前
    private int price; //商品金額
    private String code;
    private String imgURLm; //画像URL
    private String imgURLs;
    private String description; //説明
    private String rate; //評価
    private String reviewURL;
    
    public UserProductData(){
        this.name = "";
        this.code = "";
        this.price = 0;
        this.imgURLm = "";
        this.imgURLs = "";
        this.description = "";
        this.rate = "";
        this.reviewURL = "";
    }
    
    
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    
    public int getPrice(){
        return price;
    }
    public void setPrice(int price){
        this.price = price;
    }
    
    public String getCode (){
        return code;
    }
    public void setCode(String code){
        this.code = code;
    }
    
    public String getImgURLm(){
        return imgURLm;
    }
    public void setImgURLm(String imgURLm){
        this.imgURLm = imgURLm;
    }
    
    public String getImgURLs(){
        return imgURLs;
    }
    public void setImgURLs(String imgURLs){
        this.imgURLs = imgURLs;
    }
    
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    
    public String getRate(){
        return rate;
    }
    public void setRate(String rate){
        this.rate = rate;
    }
    
    public String getReviewURL(){
        return reviewURL;
    }
    public void setReviewURL(String reviewURL){
        this.reviewURL = reviewURL;
    }
   
}
