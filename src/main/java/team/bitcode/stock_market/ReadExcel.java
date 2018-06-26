/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team.bitcode.stock_market;


import java.awt.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
 
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
/**
 * This example demonstrates opening a workbook and reading its elements
 */
public class ReadExcel {
    
    int nyqNum=0;
    int lseNum=0;
    int nmsNum=0;
    int otherSymbolNum=0;
    private String[] nyq;
    private  String[] lse;
    private  String[] nms;
    private  String[] otherSymbols;
    private String[] nyqSector;
    private  String[] lseSector;
    private  String[] nmsSector;
    private  String[] otherSymbolsSector;
   
    public static void main(String[] args) {
        try {
            ReadExcel r= new ReadExcel();
            r.initExcel();
        } catch (URISyntaxException ex) {
            Logger.getLogger(ReadExcel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ReadExcel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    public void initExcel() throws URISyntaxException, FileNotFoundException, IOException{
        InputStream io=getClass().getResourceAsStream("/Ticker.xlsx");
        //fileIn = new FileInputStream(new File(getClass().getResource("/Ticker.xlsx").toURI()));
        XSSFWorkbook workbook = new XSSFWorkbook(io);
        XSSFSheet sheet = workbook.getSheetAt(0);
           
        for (Row row : sheet) {
            if(row != null){
                if(row.getCell(2) != null){
                    if(row.getCell(2).toString().equals("NYQ")){
                        nyqNum++;
                    }
                    else if(row.getCell(2).toString().equals("LSE")){
                        lseNum++;
                    }
                    else if(row.getCell(2).toString().equals("NMS")){
                        nmsNum++;
                    }
                    else{
                        otherSymbolNum++;
                    }
                    
                }
            }
            else{
                System.out.println("rows is empty");
            }
         }
        System.out.println(nyqNum+":"+lseNum+":"+nmsNum);
        
        nyq=new String[nyqNum];
        nyqSector=new String[nyqNum];
        
        lse=new String[lseNum];
        lseSector=new String[lseNum];
        
        nms=new String[nmsNum];
        nmsSector=new String[nmsNum];
        
        otherSymbols=new String[otherSymbolNum];
        otherSymbolsSector=new String[otherSymbolNum];
        
        int i=0,j=0,k=0,l=0;
        for (Row row : sheet) {
            if(row != null){
                if(row.getCell(2) != null){
                    if(row.getCell(2).toString().equals("NYQ")){
                       nyq[i]=row.getCell(0).toString();
                       nyqSector[i]=row.getCell(3).toString();
                       i++;
                    }
                    else if(row.getCell(2).toString().equals("LSE")){
                        lse[j]=row.getCell(0).toString();
                        lseSector[j]=row.getCell(3).toString();
                        j++;
                    }
                    else if(row.getCell(2).toString().equals("NMS")){
                        nms[k]=row.getCell(0).toString();
                        nmsSector[k]=row.getCell(3).toString();
                        k++;
                    }
                    else{
                        otherSymbols[l]=row.getCell(0).toString();
                        otherSymbolsSector[l]=row.getCell(3).toString();
                        l++;
                    }
                }
                
            }
            else{
                System.out.println("rows is empty");
            }
        }
        
        StockSymbols s= new StockSymbols();
        s.setNYSESymbol(nyq);
        s.setLSESymbol(lse);
        s.setNSMSymbol(nms);
        s.setOtherSymbols(otherSymbols);
        
        StockSector sec= new StockSector();
        sec.setNYSESector(nyqSector);
        sec.setLSESector(lseSector);
        sec.setNSMSector(nmsSector);
        sec.setOtherSector(otherSymbolsSector);
        
        System.out.println("ready");
    }
    
    
    
}
 
