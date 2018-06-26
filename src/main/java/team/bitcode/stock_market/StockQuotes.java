/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team.bitcode.stock_market;

import java.math.BigDecimal;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

/**
 *
 * @author DUSH
 * 
 */
public class StockQuotes {
    private String stockName;
    private String stockExchange;
    private double askPrice;
    private double bidPrice;
    private double price;
    private double prevPrice;
    
    private Stock stock;
    
    
    public void setStock(String symbol){
        try{
           stock = YahooFinance.get(symbol);
           stockName=stock.getName();
           stockExchange=stock.getStockExchange();
           askPrice=stock.getQuote().getAsk().setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
           bidPrice=stock.getQuote().getBid().setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
           prevPrice=stock.getQuote().getPreviousClose().setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
           price=stock.getQuote().getPrice().setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                   
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        
    }
    
    
    public String getStockName(){
        return stockName;
    }
    
    public String getStockExchange(){
        return stockExchange;
    }
    
    public double getASKPrice(){
        return askPrice;
    }
    
    public double getBIDPrice(){
        return bidPrice;
    }
    
    public double getPrice(){
        return price;
    }
    
    public double getPrevPrice(){
        return prevPrice;
    }
}
