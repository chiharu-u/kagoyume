/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kagoyume;

import java.io.*;
import java.io.IOException;
import java.util.Date;

/**
 *
 * @author uezuchiharu
 * 
 * 画面遷移、ユーザー登録、購入を時間とともに記録。
 * 引数を、ログに残すテキストとするようなクラスを作成しておき、
 * 画面遷移などの処理のタイミングで「searchに遷移」といったテキストで追記保存。
 */
public class Log {
    
    public static Log getInstance(){
        return new Log();
    }
    
    public void logfile(String log){
        File filepath = null;
        FileWriter fw = null;
        Date date = new Date();    
        
        try{
            //フィイルをセット
            filepath = new File("log.text");
            
            //書き込む
            fw = new FileWriter(filepath, true);    
            
            //日時
            fw.write((" +date+ ") + log);
            
            fw.flush();

    //例外処理
    }catch(IOException e){
            System.out.print(e.getMessage());    
        }    
    }
}