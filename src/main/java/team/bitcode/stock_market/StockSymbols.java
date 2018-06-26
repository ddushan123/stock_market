/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team.bitcode.stock_market;

/**
 *
 * @author DUSH
 */
public class StockSymbols {
    
    public static String[] nyse;
    public static String[] lse;
    public static String[] nms;
    public static String[] otherSymbols;
    
    
    public void setNYSESymbol(String[] symbol){
        nyse=symbol;
    }
    public void setLSESymbol(String[] symbol){
        lse=symbol;
    }
    public void setNSMSymbol(String[] symbol){
        nms=symbol;
    }
    public void setOtherSymbols(String[] symbol){
        otherSymbols=symbol;
    }
    
}
