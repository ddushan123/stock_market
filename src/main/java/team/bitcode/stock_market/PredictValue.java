/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team.bitcode.stock_market;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

/**
 *
 * @author DUSH
 */
public class PredictValue {
    public static HashMap<String,Double> buyMap= new HashMap<String,Double>();
    
    public String findBuyRecomendation(String symbol){
        String action="hold";
            try {
                double predictVal=getPredictValFromHistory(symbol);
                buyMap.put(symbol, predictVal);
                double currentVal=Frame.priceMap.get(symbol);
                double buyVal=currentVal+(currentVal*0.01);
                if(predictVal>=buyVal){
                    action="buy";
                }
                
            } catch (Exception ex) {
                Logger.getLogger(PredictValue.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        return action;
    }
    public String findSellRecomendation(String symbol,double buyVal){
        String action="hold";
            try {
                double predictVal=getPredictValFromHistory(symbol);
                double currentVal;
                double sellVal;
                if(Frame.priceMap.containsKey(symbol)){
                    currentVal=Frame.priceMap.get(symbol);
                    sellVal=Frame.bidMap.get(symbol);
                }else{
                    Stock s= YahooFinance.get(symbol);
                    currentVal=s.getQuote().getPrice().doubleValue();
                    sellVal=s.getQuote().getBid().doubleValue();
                }
                double val=currentVal-(currentVal*0.001);
                if(predictVal<=val){
                        if(sellVal>buyVal){
                         action="sell"; 
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(PredictValue.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        return action;
    }
    
    public double getPredictValFromHistory(String symbol){
         double predictVal = 0;
        try{
                String[] values =new String[30];
                String[] lastValues =new String[5];
                Document doc =  Jsoup.parse(readURL("https://finance.yahoo.com/quote/"+symbol+"/history?p="+symbol));
                Elements p_tags = doc.select("tbody");
                int i=0;
                    for (Element p : p_tags) {
                        if(i==0){
                            Elements q_tags = p.select("tr");
                             int j=0;
                             int b=0;
                             for (Element q : q_tags) {
                                if(j<30){
                                   Elements w_tags = q.select("td");
                                   int k=0;
                                    for (Element w : w_tags) {
                                        if(k==4){
                                            values[j]=w.text().replace(",", "");
                                            if(b<5){
                                                if(!values[j].equals("null")){
                                                    lastValues[b]=values[j];
                                                    b++;
                                                }
                                            }
                                        }
                                        else if(k>4){
                                            break;
                                        }
                                        k++;
                                    }
                                }
                               j++;
                            }
                       }
                       i++;
                    }
                    PrintWriter pw = new PrintWriter(new File("data/"+symbol+".csv"));
                    StringBuilder sb = new StringBuilder();
                    for (int a = 0; a < 30; a++) {
                        sb.append(values[29-a]);
                        sb.append("\n");
                    }
                    pw.write(sb.toString());
                    pw.close();
                    
                    NeuralNetworkStockPredictor predictor = new NeuralNetworkStockPredictor(5,symbol,lastValues);
                    predictor.prepareData();
                    predictor.trainNetwork();
                    predictVal=predictor.testNetwork();
                   
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return predictVal;
    }
    
    public static String readURL(String url) {

        String fileContents = "";
        String currentLine = "";

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new URL(url).openStream()));
            fileContents = reader.readLine();
            while (currentLine != null) {
                currentLine = reader.readLine();
                fileContents += "\n" + currentLine;
            }
            reader.close();
            reader = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileContents;
    }
    
    
}
