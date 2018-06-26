/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team.bitcode.stock_market;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DUSH
 */
public class Bank {
    public boolean createAccount(int turn, String name,String email,String pass){
        boolean flag=false;
        boolean f=false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://65.19.141.67:3306/piyumald_stock","piyumald_piyumal","c19940603c");
            Statement stmnt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet rs=stmnt.executeQuery("select * from Bank");
            while(rs.next()){
                if(name.equals(rs.getString(1))){
                   f=true;
                   break;
                }
            }
            if(f==false){
                Date d= new Date();
                SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd HH:mm");
                String date=format.format(d);
                stmnt.execute("insert into Bank values('"+name+"',1000,'"+date+"','"+pass+"','"+email+"')");
                Broker b= new Broker();
                b.createAccount(name);
                flag=true;
            }
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(panelPlayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(panelPlayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Bank.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }
    
    public double getBalance(String name){
        double balance=0.00;
         
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://65.19.141.67:3306/piyumald_stock","piyumald_piyumal","c19940603c");
            Statement stmnt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet rs=stmnt.executeQuery("SELECT * FROM Bank where player_name='"+name+"'");
            rs.next();
            BigDecimal bal=new BigDecimal(rs.getDouble(2));
            balance=bal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Bank.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Bank.class.getName()).log(Level.SEVERE, null, ex);
        }
           return balance;
    }
    
    public boolean deposit(int turn,String name, String sender,double amount){
        boolean flag= false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://65.19.141.67:3306/piyumald_stock","piyumald_piyumal","c19940603c");
            Statement stmnt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet rs= stmnt.executeQuery("SELECT * FROM Deposit ORDER BY id DESC LIMIT 1");
            int id=1;
            while(rs.next()){
                id=1+rs.getInt(1);
            }
            stmnt.execute("insert into Deposit values("+id+",'"+name+"','"+sender+"',"+amount+","+turn+")");
            stmnt.execute("Update Bank set balance=balance+"+amount+" where player_name='"+name+"'");
            flag=true;
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Bank.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Bank.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }
    
    public boolean withdraw(int turn,String name, String receiver,double amount){
        boolean flag= false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://65.19.141.67:3306/piyumald_stock","piyumald_piyumal","c19940603c");
            Statement stmnt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet rs= stmnt.executeQuery("SELECT * FROM Withdraw ORDER BY id DESC LIMIT 1");
            int id=1;
            while(rs.next()){
                id=1+rs.getInt(1);
            }
            stmnt.execute("insert into Withdraw values("+id+",'"+name+"','"+receiver+"',"+amount+","+turn+")");
            stmnt.execute("Update Bank set balance=balance-"+amount+" where player_name='"+name+"'");
            flag=true;
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Bank.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Bank.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }
}
