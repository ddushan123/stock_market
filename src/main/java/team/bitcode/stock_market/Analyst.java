/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team.bitcode.stock_market;

import java.awt.List;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.select.Selector;

/**
 *
 * @author DUSH
 */
public class Analyst {
        
    public static List buy;
    public static List buyListSector;
    
    public static List sell;
    
 
    public void getRecommendation(){
        buy=new List();
        buyListSector=new List();
        sell=new List();
        if(InternetConnection.getInternetStatus()){
        for (int i = 0; i < 20; i++) {
            PredictValue p= new PredictValue();
            switch(p.findBuyRecomendation(StockSymbols.nyse[i])){
                case "buy":
                   buy.add(StockSymbols.nyse[i]);
                   buyListSector.add(StockSector.nyse[i]);
                   break;
                case "hold":
                   break;
            }
        }
        for (int i = 0; i < 20; i++) {
            PredictValue p= new PredictValue();
            switch(p.findBuyRecomendation(StockSymbols.lse[i])){
                case "buy":
                   buy.add(StockSymbols.lse[i]);
                   buyListSector.add(StockSector.lse[i]);
                   break;
                case "hold":
                   break;
            }
        }
        for (int i = 0; i < 20; i++) {
            PredictValue p= new PredictValue();
            switch(p.findBuyRecomendation(StockSymbols.nms[i])){
                case "buy":
                   buy.add(StockSymbols.nms[i]);
                   buyListSector.add(StockSector.nms[i]);
                   break;
                case "hold":
                   break;
            }
        }
        
        try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://65.19.141.67:3306/piyumald_stock","piyumald_piyumal","c19940603c");
        Statement stmnt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        ResultSet rs=stmnt.executeQuery("SELECT * FROM Buy where name=(select broker_name from Broker where player_name = '"+panelPortfolios.player+"') AND status='active'");
        while (rs.next()) {
            PredictValue p= new PredictValue();
            switch(p.findSellRecomendation(rs.getString(3),rs.getDouble(5))){
                case "sell":
                    sell.add(rs.getInt(1)+"");
                    break;
                case "hold":
                    break;
            }
        }
        
        con.close();
        
        } catch (ClassNotFoundException ex) {
        Logger.getLogger(panelPlayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
        Logger.getLogger(panelPlayer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }
   
}
