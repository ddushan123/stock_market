/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team.bitcode.stock_market;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DUSH
 */
public class Broker {
    public boolean createAccount(String name){
        boolean flag=false;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://65.19.141.67:3306/piyumald_stock","piyumald_piyumal","c19940603c");
            Statement stmnt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            String b_name="broker_"+name;
            stmnt.execute("insert into Broker values('"+b_name+"','"+name+"')");
                flag=true;
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(panelPlayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(panelPlayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }
    
    public boolean buy(String name, String stock, int quantity, double price){
        boolean flag=false;
        
        try {
            Bank b=new Bank();
            String sender="broker_"+name;
                b.withdraw(new Clock().now(), name, sender, (price*quantity));
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://65.19.141.67:3306/piyumald_stock","piyumald_piyumal","c19940603c");
                Statement stmnt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                ResultSet rs=stmnt.executeQuery("SELECT * FROM Buy ORDER BY id DESC LIMIT 1");
                int id=1;
                while(rs.next()){
                    id=1+rs.getInt(1);
                }
                stmnt.execute("insert into Buy values("+id+",'"+sender+"','"+stock+"',"+quantity+","+price+",'active')");
                flag=true;
                con.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(panelPlayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(panelPlayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }
    
    public boolean sell(String name, String stock, int quantity, double price){
        boolean flag=false;
        
        try {
            String receiver="broker_"+name;
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://65.19.141.67:3306/piyumald_stock","piyumald_piyumal","c19940603c");
            Statement stmnt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet rs=stmnt.executeQuery("SELECT * FROM Sell ORDER BY id DESC LIMIT 1");
            int id=1;
            while(rs.next()){
                id=1+rs.getInt(1);
            }
            stmnt.execute("insert into Sell values("+id+",'"+receiver+"','"+stock+"',"+quantity+","+price+")");
            Bank b= new Bank();
            b.deposit(new Clock().now(), name, receiver, (price*quantity));
            flag=true;
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(panelPlayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(panelPlayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }
    
    public JTable[] portfolio(String name){
            JTable[] table = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://65.19.141.67:3306/piyumald_stock","piyumald_piyumal","c19940603c");
            Statement stmnt1 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            Statement stmnt2 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet rs1=stmnt1.executeQuery("SELECT * FROM Buy where name=(select broker_name from Broker where player_name = '"+name+"')");
            JTable tableBuy = new JTable(buildTableModel(rs1));
            ResultSet rs2=stmnt2.executeQuery("SELECT * FROM Sell where name=(select broker_name from Broker where player_name = '"+name+"')");
            JTable tableSell = new JTable(buildTableModel(rs2));
            con.close();
            table=new JTable[]{tableBuy,tableSell};
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(panelPlayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(panelPlayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return table;
    }
    
        
   public static DefaultTableModel buildTableModel(ResultSet rs)
        throws SQLException {

        ResultSetMetaData metaData = rs.getMetaData();

    // names of columns
        Vector<String> columnNames = new Vector<String>();
        int columnCount = metaData.getColumnCount();
        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnName(column));
        }

    // data of the table
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        while (rs.next()) {
            Vector<Object> vector = new Vector<Object>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                vector.add(rs.getObject(columnIndex));
            }
            data.add(vector);
        }

        return new DefaultTableModel(data, columnNames);
    }
   
   public boolean update(int id){
        boolean flag=false;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://65.19.141.67:3306/piyumald_stock","piyumald_piyumal","c19940603c");
            Statement stmnt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            stmnt.execute("update Buy set status='close' where id="+id);
            flag=true;
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(panelPlayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(panelPlayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }
   
}
