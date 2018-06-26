/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team.bitcode.stock_market;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DUSH
 */
public class Player {
    
    public void createFile(String name,String path) throws IOException{
        File folder = new File("players");
          if(!folder.exists()){
              folder.mkdir();
          }
          
        File f = new File(path);
        
            if(!f.exists()){
                f.createNewFile();
                BufferedWriter out = new BufferedWriter(new FileWriter(path));
                out.write(name);
                out.close();
            }
            else{
                FileReader fr = new FileReader(path);
 
                int i;
                String s="";
                while ((i=fr.read()) != -1){
                    s=s+(char)i;
                }
                
                BufferedWriter out = new BufferedWriter(new FileWriter(path));
                out.write(s);
                out.newLine();
                out.write(name);
                out.close();
                //System.out.println(s);
            }
            
            
            
    }
        
    
}
