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

//トップページへのリンク
public class KagoyumeHelper {
    
    //トップへのリンクを定数として設定
    private final String homeURL = "index.jsp";
    //ログインへのリンク
    private final String loginURL = "login.jsp";
    //ログアウトへのリンク
    private final String logoutURL = "Login?login=logout";
    
    
    public static KagoyumeHelper getInstance(){
        return new KagoyumeHelper();
    }
    
    //タイトル
    public String title(){
        return "<h2><a href=\"" + homeURL + "\">Kagoyume</a></h2>";
    }
    
    //説明
    public String subTitle(){
        return "<h4>「金銭取引が絶対に発生しない」どんなものでも購入できる気分になれるサイトです！</h4>";
    }
    
    //トップへのリンクを返却
    public String home(){
        return "<a href=\"" + homeURL + "\">TOP</a>";
    }
    
    //ログインページへのリンクを返却
    public String login(){
        return "<a href=\"" + loginURL + "\">ログイン</a>";
    }
   
    
    //ログアウト処理
    public String logout(){
         return "<a href=\"" + logoutURL + "\">ログアウト</a>";
    }
    
    //フォームのラジオボタン
    public String type(int i){
        switch(i){
            case 1:
                return "クロネコヤマト";
            case 2:
                return "佐川急便";
            case 3:
                return "ゆうぱっく";
        }
        return "";
    }
}
