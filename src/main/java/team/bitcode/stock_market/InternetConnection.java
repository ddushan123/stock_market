/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team.bitcode.stock_market;

import java.net.HttpURLConnection;
import java.net.URL;
import javax.swing.JOptionPane;

/**
 *
 * @author DUSH
 */
public class InternetConnection {
    public static void main(String[] args) {
        System.out.println(getInternetStatus());
    }
    
    public static boolean getInternetStatus(){
        boolean check=false;
        try{
            int timeOutInMilliSec=5000;
            URL url = new URL("http://www.google.com/");
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("HEAD");
            conn.setConnectTimeout(timeOutInMilliSec);
            conn.setReadTimeout(timeOutInMilliSec);
            int responseCode = conn.getResponseCode();
            if(200 <= responseCode && responseCode <= 399){
                check=true;
            }
            
        }
        catch(Exception ex){
            check=false;
            JOptionPane.showMessageDialog(FxMediaExample2.frame,"Can't connect to internet. Check your connectivity.", "No Internet Connection", JOptionPane.WARNING_MESSAGE);
        }
        return check;
    }
    
}
