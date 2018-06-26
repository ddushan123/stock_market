/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team.bitcode.stock_market;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Enumeration;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DUSH
 */
public class ComputerPlayer extends Player{
    public static String computerPlayer="";
    double balance;
    public static Date date;
    public static int myturn=0;
    void play(){
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                myturn--;
                if(myturn>0){
                    runPlayer();
                }
                else{
                    this.cancel();
                }
                
            }
        }, 0, 60000);
    }
    
    void runPlayer(){
        try {
            if(balance>0){
            if(!PredictValue.buyMap.isEmpty()){
                for (Map.Entry<String, Double> entry : PredictValue.buyMap.entrySet()) {
                    double currentVal=Frame.priceMap.get(entry.getKey());
                    double buyVal=currentVal+(currentVal*0.02);
                    if(entry.getValue()>=buyVal){
                        double buyPrice=Frame.askMap.get(entry.getKey());
                        if(balance>buyPrice){
                            int quant=0;
                            if(buyPrice<=20){
                                quant=(int)(balance*0.01);
                            }
                            else if(buyPrice<=50){
                                quant=(int)(balance*0.004);
                            }
                            else if(buyPrice<=150){
                                quant=(int)(balance*0.0025);
                            }
                            if(buyPrice>150){
                                quant=(int)(balance*0.001);
                            }
                            if(balance>0){
                            Clock c= new Clock();
                            c.setDate(date);
                            Broker b= new Broker();
                            b.buy(computerPlayer, entry.getKey(),quant,buyPrice);
                            balance=new Bank().getBalance(computerPlayer);
                            }
                            else{
                                break;
                            }
                        }
                    }
                }
            }
        }
            
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://65.19.141.67:3306/piyumald_stock","piyumald_piyumal","c19940603c");
            Statement stmnt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet rs=stmnt.executeQuery("SELECT * FROM Buy where name=(select broker_name from Broker where player_name = '"+computerPlayer+"') AND status='active'");
            while (rs.next()) {
                double currentVal=Frame.priceMap.get(rs.getString(3));
                double sellVal=Frame.bidMap.get(rs.getString(3));
                double predictVal;
                if(PredictValue.buyMap.containsKey(rs.getString(3))){
                    predictVal=PredictValue.buyMap.get(rs.getString(3));
                }
                else{
                    predictVal=new PredictValue().getPredictValFromHistory(rs.getString(3));
                }
                double val=currentVal-(currentVal*0.02);
                if(predictVal<=val){
                    if(sellVal>rs.getDouble(5)){
                        Clock c= new Clock();
                        c.setDate(date);
                        Broker b= new Broker();
                        b.sell(computerPlayer,rs.getString(3), rs.getInt(4), sellVal);
                        b.update(rs.getInt(1));
                        balance=new Bank().getBalance(computerPlayer);
                    }
                }
            }
            
            con.close();
            
           
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ComputerPlayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ComputerPlayer.class.getName()).log(Level.SEVERE, null, ex);
        }catch (Exception ex) {
            Logger.getLogger(ComputerPlayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    public void setComputerPlayerName(){
        try {
            Enumeration<NetworkInterface> networks = NetworkInterface.getNetworkInterfaces();
            NetworkInterface inter;
            while (networks.hasMoreElements()) {
                inter = networks.nextElement();
                byte[] mac = inter.getHardwareAddress();
                if (mac != null) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < mac.length; i++) {
                        sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
                        
                    }
                    computerPlayer=sb.toString();
                    break;
                }
            }
        } catch (SocketException ex) {
            Logger.getLogger(ComputerPlayer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void setDate(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://65.19.141.67:3306/piyumald_stock","piyumald_piyumal","c19940603c");
            Statement stmnt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet rs=stmnt.executeQuery("SELECT * FROM Bank where player_name='"+computerPlayer+"'");
            rs.next();
            date= rs.getDate(3);
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ComputerPlayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ComputerPlayer.class.getName()).log(Level.SEVERE, null, ex);
        }catch (Exception ex) {
            Logger.getLogger(ComputerPlayer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setBalance(){
        balance=new Bank().getBalance(computerPlayer);
    }
    
    public void setComputerPlayerNameFromFile() throws IOException{
        BufferedReader b = null;
        try {
            File f = new File("players/computer_player_name.plyr");
            b = new BufferedReader(new FileReader(f));
            String readLine = "";
            while ((readLine = b.readLine()) != null) {
                computerPlayer=readLine;
                break;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ComputerPlayer.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                b.close();
            } catch (Exception ex) {
                Logger.getLogger(ComputerPlayer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
         
    }
}
