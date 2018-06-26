/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team.bitcode.stock_market;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.converter.LocalDateTimeStringConverter;

/**
 *
 * @author DUSH
 */

public class Clock {
    
    static Date date;
    
    public int now(){
        int turn=0;
        Instant instant = Instant.ofEpochMilli(date.getTime());
        LocalDateTime startDate = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        LocalDateTime endDate = LocalDateTime.now();
        long t=1440;
         System.out.println("date :"+date);
        long minutes = Duration.between(startDate, endDate).toMinutes();
        System.out.println("turn0 :"+minutes);
        if(minutes>=t){
            turn=1440;
        }
        else{
            turn=Math.toIntExact(minutes);
        }
        System.out.println("turn:"+turn);
        return turn; 
    }
    
    public void setDate(Date date){
       this.date=date;
    }
    
}

