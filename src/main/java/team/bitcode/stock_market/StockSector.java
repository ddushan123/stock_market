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
public class StockSector {
    public static String[] nyse;
    public static String[] lse;
    public static String[] nms;
    public static String[] otherSector;
    
    
    public void setNYSESector(String[] sector){
        nyse=sector;
    }
    public void setLSESector(String[] sector){
        lse=sector;
    }
    public void setNSMSector(String[] sector){
        nms=sector;
    }
    public void setOtherSector(String[] sector){
        otherSector=sector;
    }
    
}
