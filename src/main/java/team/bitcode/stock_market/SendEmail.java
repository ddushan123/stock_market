
package team.bitcode.stock_market;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author DUSH
 */
public class SendEmail {
    public static String user="";
    public static String pass="";
    
    public int sendVerifyCode(String to){
        int code = 100000;
        try {
            String host = "smtp.gmail.com";
            String user = "cchamika123@gmail.com";
            String pss = "c19940603c";
            String from = user;
            String subject = "Reset Code";
            Random r= new Random();
            code=100000+r.nextInt(899999);
            String message = "Recovery Code: "+code;
            boolean sessionDebug = false;
            Properties pros = System.getProperties();
            pros.put("mail.smtp.starttls.enable", "tue");
            pros.put("mail.smtp.ssl.trust", "smtp.gmail.com");
            pros.put("mail.smtp.host", "host");
            pros.put("mail.smtp.auth","true");
            pros.put("mail.smtp.port","587");
            pros.put("mail.smtp.starttls.required","true");
            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            Session mailSession = Session.getDefaultInstance(pros,null);
            mailSession.setDebug(sessionDebug);
            Message msg = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress(from));
            InternetAddress [] address ={new InternetAddress(to)};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject(subject);
            msg.setSentDate(new Date());
            msg.setText(message);
            Transport transport = mailSession.getTransport("smtp");
            transport.connect(host, user, pss);
            transport.sendMessage(msg, msg.getAllRecipients());
            transport.close();
            System.out.println("message send successfully");
        } catch (AddressException ex) {
            Logger.getLogger(SendEmail.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(SendEmail.class.getName()).log(Level.SEVERE, null, ex);
        }
        return code;
    }
    
    public void setAuthernication(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://65.19.141.67:3306/piyumald_Mail","piyumald_piyumal","c19940603c");
            Statement stmnt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet rs=stmnt.executeQuery("SELECT * FROM mail");
            rs.next();
            user=rs.getString(1);
            pass=rs.getString(2);
            con.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SendEmail.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SendEmail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public boolean verifyEmail(String email,int tag){
        boolean flag=false,flag2=false;
        try {
            
            final String EMAIL_PATTERN ="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
            Pattern pattern = Pattern.compile(EMAIL_PATTERN);
            Matcher matcher=pattern.matcher(email);
            flag=matcher.matches();
            int a=0;
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://65.19.141.67:3306/piyumald_stock","piyumald_piyumal","c19940603c");
            Statement stmnt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet rs=stmnt.executeQuery("SELECT * FROM Bank where email='"+email+"'");
                while(rs.next()){
                    a=1;
                    break;
                }
                
              if(tag==0){
                  if(flag==true && a==0){
                      flag2=true;
                  }
              }  
              else{
                  if(flag==true && a==1){
                      flag2=true;
                  }
              }
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SendEmail.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SendEmail.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag2;
    }
}
