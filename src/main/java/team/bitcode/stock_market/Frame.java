/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team.bitcode.stock_market;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.List;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.LayoutStyle;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.formula.atp.AnalysisToolPak;
import org.jfree.data.time.Minute;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import static team.bitcode.stock_market.PredictValue.readURL;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;

/**
 *
 * @author DUSH
 */
public class Frame extends javax.swing.JFrame {
    int x=5;
    int y=10;
    private int myTurn=0;
    private static String symbolForGraph="";
    private static String stockName="";
    public static LineChart_AWT chart;
    public static int turn=0;
    Timer graphTimer= new Timer();
    private static JPanel jp;
    private static JPanel jpanel5;
    private static JPanel jpanel8;
    public static JPanel jpanel10;
    public static JPanel jpanel1;
    private static JPanel jp15;
    private static JPanel jpanel7;
     private static JPanel jpanel9;
    public static  Date date;
    public static JLabel lblRemain;
    public static JTabbedPane jtab;
    public static panelPortfolios panelPortfolios2;
    public static panelPlayer panelPlayer2;
    public static panelNewsForm panelNewsForm2;
    public static panelBuyRecomendation panelbuyRecomendation ;
    public static panelLeaderBoard panelBoard ;
    public static int log=0;
    public static double balance=0.00;
    public static  int remainTurn=0;
    public static  int suspend=0;
    public static Timer timerRecommendation= new Timer();
    public static HashMap<String,Double> priceMap= new HashMap<String,Double>();
    public static HashMap<String,Double> bidMap= new HashMap<String,Double>();
    public static HashMap<String,Double> askMap= new HashMap<String,Double>();
    
    /**
     * Creates new form Frame
     */
    
    public Frame() {
        initComponents();
        jPanel7.setVisible(false);
        jp=jPanel2;
        jp15=jPanel15;
        jpanel5=jPanel5;
        jpanel10=jPanel10;
        jpanel8=jPanel8;
        jpanel7=jPanel7;
        jpanel9=jPanel9;
        jtab=jTabbedPane1;
        lblRemain=lblRemaning;
        jpanel1=jPanel1;
        /*  jPanel2.setVisible(false);
        panelPlayer p= new panelPlayer();
        p.setBounds(0, 90, 1368, 644);
        p.setVisible(true);
        this.add(p);*/
        //ReadExcel n=new ReadExcel();
        //setNYSETab();
        panelShowRecommendation.setVisible(false);
        lblAnalyst.setVisible(false);
        lblRemaning.setVisible(false);
        
        
        
        
        
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        System.out.printf("aaa"+dim.getHeight());
        System.out.printf("aaa"+dim.height);
        pack();
        this.setSize((int)dim.getWidth(),(int)dim.getHeight());
        System.out.println("H"+this.getHeight());
        jpanel1.setSize(dim.width, (int)(dim.getHeight()*0.1171875));
        int w=(int)(jPanel1.getWidth()*0.54824561);
        int h=(int)(jPanel1.getHeight()*0.66666667);
        jPanel3.setBounds(0, jPanel1.getHeight()-h,w,h);
        btnSettings.setBounds(jPanel1.getWidth()-58, jPanel1.getHeight()-60, 50, 50);
        btnInfo.setBounds(btnSettings.getX()-55, jPanel1.getHeight()-60, 50, 50);
        lblAnalyst.setBounds(btnInfo.getX()-85, jPanel1.getHeight()-70, 82, 60);
        panelShowRecommendation.setBounds(lblAnalyst.getX()-405, jPanel1.getHeight()-85, 400, 80);
        
        System.out.println(this.getWidth());
        this.repaint();
        this.revalidate();
        
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem3 = new javax.swing.JMenuItem();
        jDialog2 = new javax.swing.JDialog();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        lblStockname2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        lblStockName = new javax.swing.JLabel();
        jDialog3 = new javax.swing.JDialog();
        jPanel44 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jDialog4 = new javax.swing.JDialog();
        jPanel45 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnTradingCenter = new javax.swing.JButton();
        btnPortfolios = new javax.swing.JButton();
        btnNews = new javax.swing.JButton();
        btnLeaderBoard = new javax.swing.JButton();
        btnSettings = new javax.swing.JButton();
        btnInfo = new javax.swing.JButton();
        lblAnalyst = new javax.swing.JLabel();
        panelShowRecommendation = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        btnSellRecommend = new javax.swing.JButton();
        btnBuyRecommend = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        panelNYSE = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        panelNYSEContainer = new javax.swing.JPanel();
        panelLSE = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        panelLSEContainer = new javax.swing.JPanel();
        panelNMS = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        panelNMSContainer = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel11 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        lblStock = new javax.swing.JLabel();
        jPanel32 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanel16 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jPanel26 = new javax.swing.JPanel();
        lblPrvP = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel27 = new javax.swing.JPanel();
        lblOpenP = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel28 = new javax.swing.JPanel();
        lblAskP = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel29 = new javax.swing.JPanel();
        lblBidP = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jPanel30 = new javax.swing.JPanel();
        lblChangeInP = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        lblChangeInPrecentage = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        lblSector = new javax.swing.JLabel();
        jPanel43 = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel33 = new javax.swing.JPanel();
        lblTicker2 = new javax.swing.JLabel();
        lblTicker = new javax.swing.JLabel();
        lblMPrice2 = new javax.swing.JLabel();
        lblMPrice = new javax.swing.JLabel();
        jPanel34 = new javax.swing.JPanel();
        jPanel35 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel36 = new javax.swing.JPanel();
        txtQuant = new javax.swing.JTextField();
        lblAmount2 = new javax.swing.JLabel();
        lblAmount = new javax.swing.JLabel();
        jPanel37 = new javax.swing.JPanel();
        jPanel38 = new javax.swing.JPanel();
        lblMaxQuant = new javax.swing.JLabel();
        jPanel39 = new javax.swing.JPanel();
        jPanel40 = new javax.swing.JPanel();
        jPanel41 = new javax.swing.JPanel();
        btnBuyOrder = new javax.swing.JButton();
        jPanel42 = new javax.swing.JPanel();
        lblRemaning = new javax.swing.JLabel();

        jDialog1.setAlwaysOnTop(true);
        jDialog1.setBackground(new java.awt.Color(102, 102, 102));

        jPanel13.setBackground(new java.awt.Color(51, 51, 51));
        jPanel13.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(51, 51, 51)));

        jPanel14.setBackground(new java.awt.Color(233, 233, 233));
        jPanel14.setLayout(null);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/10.gif"))); // NOI18N
        jLabel7.setText("Processing");
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel7.setIconTextGap(10);
        jLabel7.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jPanel14.add(jLabel7);
        jLabel7.setBounds(151, 34, 74, 58);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/jdialog_back.jpg"))); // NOI18N
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel14.add(jLabel2);
        jLabel2.setBounds(-12, -15, 390, 150);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                .addContainerGap())
        );

        jDialog1.getContentPane().add(jPanel13, java.awt.BorderLayout.CENTER);

        jPopupMenu1.setBackground(new java.awt.Color(0, 0, 0));
        jPopupMenu1.setOpaque(false);

        jMenuItem1.setBackground(new java.awt.Color(0, 0, 0));
        jMenuItem1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItem1.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem1.setText("jMenuItem1");
        jMenuItem1.setOpaque(true);
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jPopupMenu1.add(jSeparator1);

        jMenuItem3.setBackground(new java.awt.Color(0, 0, 0));
        jMenuItem3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItem3.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem3.setText("jMenuItem3");
        jMenuItem3.setOpaque(true);
        jPopupMenu1.add(jMenuItem3);

        jDialog2.setAlwaysOnTop(true);
        jDialog2.setBackground(new java.awt.Color(204, 0, 0));
        jDialog2.setUndecorated(true);
        jDialog2.setResizable(false);

        jPanel12.setBackground(new java.awt.Color(204, 51, 0));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "Date", "Open", "High", "Low", "Close"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        lblStockname2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblStockname2.setForeground(new java.awt.Color(255, 255, 255));
        lblStockname2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStockname2.setText("(MA)");

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton2.setText("Close");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        lblStockName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblStockName.setForeground(new java.awt.Color(255, 255, 255));
        lblStockName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStockName.setText("jLabel12");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblStockName, javax.swing.GroupLayout.DEFAULT_SIZE, 903, Short.MAX_VALUE)
                    .addComponent(lblStockname2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jScrollPane1)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(lblStockName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblStockname2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap())
        );

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog2Layout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jDialog3.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jDialog3.setAlwaysOnTop(true);
        jDialog3.setBackground(new java.awt.Color(0, 0, 0));
        jDialog3.setUndecorated(true);
        jDialog3.setResizable(false);

        jPanel44.setBackground(new java.awt.Color(0, 12, 14));
        jPanel44.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(204, 204, 204)));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/loading.gif"))); // NOI18N

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Loading Data");

        jLabel15.setForeground(new java.awt.Color(0, 204, 204));
        jLabel15.setText("it may take few seconds");

        javax.swing.GroupLayout jPanel44Layout = new javax.swing.GroupLayout(jPanel44);
        jPanel44.setLayout(jPanel44Layout);
        jPanel44Layout.setHorizontalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel44Layout.createSequentialGroup()
                .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel44Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addGroup(jPanel44Layout.createSequentialGroup()
                                .addGap(103, 103, 103)
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 116, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel44Layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(jLabel15)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel44Layout.setVerticalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel44Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jDialog3.getContentPane().add(jPanel44, java.awt.BorderLayout.CENTER);

        jDialog4.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jDialog4.setAlwaysOnTop(true);
        jDialog4.setUndecorated(true);
        jDialog4.setResizable(false);

        jPanel45.setBackground(new java.awt.Color(51, 51, 51));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("ABOUT DEVELOPERS");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(204, 204, 204));
        jLabel12.setText("DUSHAN CHAMIKA DEWASURENDRA");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(204, 204, 204));
        jLabel17.setText("RADAMPALA GAMAGE HASITHA WARUNA");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(204, 204, 204));
        jLabel19.setText("DIYOGUBADUGE ISHARA LAKSHAN");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(204, 204, 204));
        jLabel20.setText("DILLIMUNI SHASHILA PIYUMAL ");

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(204, 204, 204));
        jLabel22.setText("DULMINI RAJAPAKSHA");

        jLabel24.setBackground(new java.awt.Color(255, 255, 255));
        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("ABOUT SOFTWARE");

        jButton3.setBackground(new java.awt.Color(204, 204, 204));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setText("SEE USER MANUAL");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(204, 204, 204));
        jLabel25.setText("This project is carried out as the Software Engineering project two in a group of five members. Decent ");

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(204, 204, 204));
        jLabel26.setText("ideas and skills of all the team members are used to get the maximum outcome. The project was carried throughout");

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(204, 204, 204));
        jLabel27.setText("The goal of the project is to develop a detailed and user friendly market simulator to meet the");

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(204, 204, 204));
        jLabel28.setText(" requirements of an of an online stock market simulator. The project has mostly aimed the users who have interest");

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(204, 204, 204));
        jLabel29.setText(" in stock marketing, and it is designed for to improve their stock handling knowledge and skills in this competitive ");

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(204, 204, 204));
        jLabel30.setText("stock market");

        jButton4.setBackground(new java.awt.Color(204, 204, 204));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setText("CLOSE");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel45Layout = new javax.swing.GroupLayout(jPanel45);
        jPanel45.setLayout(jPanel45Layout);
        jPanel45Layout.setHorizontalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel45Layout.createSequentialGroup()
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel45Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, 803, Short.MAX_VALUE))
                    .addGroup(jPanel45Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel25)
                            .addGroup(jPanel45Layout.createSequentialGroup()
                                .addComponent(jButton4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3)))))
                .addGap(21, 21, 21))
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 703, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel45Layout.createSequentialGroup()
                            .addGap(27, 27, 27)
                            .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel24)
                                .addComponent(jLabel8)))
                        .addGroup(jPanel45Layout.createSequentialGroup()
                            .addGap(124, 124, 124)
                            .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel17)
                                .addComponent(jLabel12)
                                .addComponent(jLabel19)
                                .addComponent(jLabel20)
                                .addComponent(jLabel22)))
                        .addGroup(jPanel45Layout.createSequentialGroup()
                            .addGap(27, 27, 27)
                            .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 801, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 801, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 801, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel45Layout.setVerticalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel22)
                .addGap(42, 42, 42)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addGap(23, 23, 23))
        );

        jDialog4.getContentPane().add(jPanel45, java.awt.BorderLayout.CENTER);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("STOCK MARKET SIMULATOR");
        setAlwaysOnTop(true);
        setLocation(new java.awt.Point(-1, 0));
        setMaximumSize(null);
        setMinimumSize(null);
        setResizable(false);
        setSize(new java.awt.Dimension(1366, 768));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowDeactivated(java.awt.event.WindowEvent evt) {
                formWindowDeactivated(evt);
            }
        });
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(0, 102, 0));
        jPanel1.setLayout(null);

        jPanel3.setOpaque(false);
        jPanel3.setLayout(new java.awt.GridLayout(1, 0));

        btnTradingCenter.setBackground(new java.awt.Color(0, 102, 0));
        btnTradingCenter.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnTradingCenter.setForeground(new java.awt.Color(255, 255, 255));
        btnTradingCenter.setText("TRADING CENTER");
        btnTradingCenter.setPreferredSize(new java.awt.Dimension(180, 50));
        btnTradingCenter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTradingCenterActionPerformed(evt);
            }
        });
        jPanel3.add(btnTradingCenter);

        btnPortfolios.setBackground(new java.awt.Color(0, 102, 0));
        btnPortfolios.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnPortfolios.setForeground(new java.awt.Color(255, 255, 255));
        btnPortfolios.setText("PORTFOLIOS");
        btnPortfolios.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnPortfolios.setPreferredSize(new java.awt.Dimension(180, 50));
        btnPortfolios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPortfoliosActionPerformed(evt);
            }
        });
        jPanel3.add(btnPortfolios);

        btnNews.setBackground(new java.awt.Color(0, 102, 0));
        btnNews.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnNews.setForeground(new java.awt.Color(255, 255, 255));
        btnNews.setText("NEWS");
        btnNews.setPreferredSize(new java.awt.Dimension(180, 50));
        btnNews.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewsActionPerformed(evt);
            }
        });
        jPanel3.add(btnNews);

        btnLeaderBoard.setBackground(new java.awt.Color(0, 102, 0));
        btnLeaderBoard.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnLeaderBoard.setForeground(new java.awt.Color(255, 255, 255));
        btnLeaderBoard.setText("LEADERBOARD");
        btnLeaderBoard.setPreferredSize(new java.awt.Dimension(180, 50));
        btnLeaderBoard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLeaderBoardActionPerformed(evt);
            }
        });
        jPanel3.add(btnLeaderBoard);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(0, 30, 750, 60);

        btnSettings.setBackground(new java.awt.Color(0, 153, 0));
        btnSettings.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSettings.setForeground(new java.awt.Color(255, 255, 255));
        btnSettings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/settings-icon.png"))); // NOI18N
        btnSettings.setPreferredSize(new java.awt.Dimension(180, 50));
        btnSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSettingsActionPerformed(evt);
            }
        });
        jPanel1.add(btnSettings);
        btnSettings.setBounds(1310, 30, 50, 50);

        btnInfo.setBackground(new java.awt.Color(0, 153, 0));
        btnInfo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnInfo.setForeground(new java.awt.Color(255, 255, 255));
        btnInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/white-about-32.png"))); // NOI18N
        btnInfo.setPreferredSize(new java.awt.Dimension(180, 50));
        btnInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInfoActionPerformed(evt);
            }
        });
        jPanel1.add(btnInfo);
        btnInfo.setBounds(1260, 30, 50, 50);

        lblAnalyst.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAnalyst.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/assistant.png"))); // NOI18N
        lblAnalyst.setToolTipText("Assitant");
        lblAnalyst.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(lblAnalyst);
        lblAnalyst.setBounds(1175, 20, 82, 60);

        panelShowRecommendation.setOpaque(false);
        panelShowRecommendation.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                panelShowRecommendationComponentShown(evt);
            }
        });
        panelShowRecommendation.setLayout(null);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 0));
        jLabel6.setText("You have new recomendation.");
        panelShowRecommendation.add(jLabel6);
        jLabel6.setBounds(40, 15, 230, 20);

        btnSellRecommend.setBackground(new java.awt.Color(255, 255, 255));
        btnSellRecommend.setForeground(new java.awt.Color(0, 102, 102));
        btnSellRecommend.setText("Sell Recommendation");
        btnSellRecommend.setToolTipText("Sell Recommendation show in BLACK color in portfolios ");
        btnSellRecommend.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSellRecommend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSellRecommendActionPerformed(evt);
            }
        });
        panelShowRecommendation.add(btnSellRecommend);
        btnSellRecommend.setBounds(200, 40, 160, 20);

        btnBuyRecommend.setBackground(new java.awt.Color(255, 255, 255));
        btnBuyRecommend.setForeground(new java.awt.Color(0, 102, 102));
        btnBuyRecommend.setText("Buy Recommendation");
        btnBuyRecommend.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuyRecommend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuyRecommendActionPerformed(evt);
            }
        });
        panelShowRecommendation.add(btnBuyRecommend);
        btnBuyRecommend.setBounds(40, 40, 160, 20);

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/imageedit_7_5474529758.png"))); // NOI18N
        jLabel10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        panelShowRecommendation.add(jLabel10);
        jLabel10.setBounds(0, 0, 400, 80);

        jPanel1.add(panelShowRecommendation);
        panelShowRecommendation.setBounds(770, 5, 400, 80);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1368, 90);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(null);

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setPreferredSize(new java.awt.Dimension(761, 474));
        jPanel15.setLayout(new java.awt.BorderLayout());

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setFocusCycleRoot(true);
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        panelNYSE.setBackground(new java.awt.Color(255, 255, 255));
        panelNYSE.setLayout(new java.awt.BorderLayout());

        panelNYSEContainer.setBackground(new java.awt.Color(255, 255, 255));
        panelNYSEContainer.setAutoscrolls(true);
        panelNYSEContainer.setPreferredSize(new java.awt.Dimension(0, 0));

        javax.swing.GroupLayout panelNYSEContainerLayout = new javax.swing.GroupLayout(panelNYSEContainer);
        panelNYSEContainer.setLayout(panelNYSEContainerLayout);
        panelNYSEContainerLayout.setHorizontalGroup(
            panelNYSEContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 754, Short.MAX_VALUE)
        );
        panelNYSEContainerLayout.setVerticalGroup(
            panelNYSEContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 443, Short.MAX_VALUE)
        );

        jScrollPane4.setViewportView(panelNYSEContainer);

        panelNYSE.add(jScrollPane4, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("  NEW YORK STOCK EXCHANGE  ", panelNYSE);

        panelLSE.setLayout(new java.awt.BorderLayout());

        panelLSEContainer.setBackground(new java.awt.Color(255, 255, 255));
        panelLSEContainer.setAutoscrolls(true);
        panelLSEContainer.setPreferredSize(new java.awt.Dimension(200, 200));

        javax.swing.GroupLayout panelLSEContainerLayout = new javax.swing.GroupLayout(panelLSEContainer);
        panelLSEContainer.setLayout(panelLSEContainerLayout);
        panelLSEContainerLayout.setHorizontalGroup(
            panelLSEContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 754, Short.MAX_VALUE)
        );
        panelLSEContainerLayout.setVerticalGroup(
            panelLSEContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 443, Short.MAX_VALUE)
        );

        jScrollPane5.setViewportView(panelLSEContainer);

        panelLSE.add(jScrollPane5, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("  LONDON STOCK EXCHANGE  ", panelLSE);

        panelNMS.setLayout(new java.awt.BorderLayout());

        panelNMSContainer.setBackground(new java.awt.Color(255, 255, 255));
        panelNMSContainer.setAutoscrolls(true);
        panelNMSContainer.setPreferredSize(new java.awt.Dimension(200, 200));

        javax.swing.GroupLayout panelNMSContainerLayout = new javax.swing.GroupLayout(panelNMSContainer);
        panelNMSContainer.setLayout(panelNMSContainerLayout);
        panelNMSContainerLayout.setHorizontalGroup(
            panelNMSContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 754, Short.MAX_VALUE)
        );
        panelNMSContainerLayout.setVerticalGroup(
            panelNMSContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 443, Short.MAX_VALUE)
        );

        jScrollPane6.setViewportView(panelNMSContainer);

        panelNMS.add(jScrollPane6, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("  NASDAQ STOCK MARKET  ", panelNMS);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(null);

        jTextField1.setBackground(new java.awt.Color(235, 235, 255));
        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });
        jPanel6.add(jTextField1);
        jTextField1.setBounds(164, 53, 220, 23);

        jLabel1.setBackground(new java.awt.Color(0, 102, 153));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 153));
        jLabel1.setText("Stock Name");
        jPanel6.add(jLabel1);
        jLabel1.setBounds(63, 56, 83, 17);

        jButton9.setBackground(new java.awt.Color(0, 102, 153));
        jButton9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setText("Search Stock");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton9);
        jButton9.setBounds(402, 52, 113, 25);

        jPanel9.setLayout(new java.awt.BorderLayout());

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setPreferredSize(new java.awt.Dimension(200, 200));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 754, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 331, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(jPanel11);

        jPanel9.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jPanel6.add(jPanel9);
        jPanel9.setBounds(0, 112, 756, 333);

        jTabbedPane1.addTab("  SEARCH TICKER  ", jPanel6);

        jPanel15.add(jTabbedPane1, java.awt.BorderLayout.CENTER);

        jPanel4.add(jPanel15);
        jPanel15.setBounds(0, 0, 761, 474);

        jPanel5.setBackground(new java.awt.Color(236, 235, 235));
        jPanel5.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        jPanel5.setLayout(null);

        jPanel10.setBackground(new java.awt.Color(236, 235, 235));
        jPanel10.setToolTipText("");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 589, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 440, Short.MAX_VALUE)
        );

        jPanel5.add(jPanel10);
        jPanel10.setBounds(1, 1, 589, 440);

        jPanel7.setBackground(new java.awt.Color(236, 235, 235));
        jPanel7.setLayout(new java.awt.GridLayout(10, 0));

        jPanel17.setBackground(new java.awt.Color(236, 235, 235));
        jPanel17.setLayout(new java.awt.GridLayout(1, 3));

        lblStock.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblStock.setText("    A");
        jPanel17.add(lblStock);

        jPanel32.setBackground(new java.awt.Color(236, 235, 235));

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 196, Short.MAX_VALUE)
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );

        jPanel17.add(jPanel32);

        jButton1.setBackground(new java.awt.Color(204, 51, 0));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("See Historical Data");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel17.add(jButton1);

        jPanel7.add(jPanel17);

        jPanel16.setBackground(new java.awt.Color(236, 235, 235));

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 589, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );

        jPanel7.add(jPanel16);

        jPanel18.setBackground(new java.awt.Color(236, 235, 235));
        jPanel18.setLayout(new java.awt.GridLayout(1, 4));

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setText("     Previous Price");
        jPanel18.add(jLabel23);

        jPanel26.setBackground(new java.awt.Color(236, 235, 235));
        jPanel26.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        lblPrvP.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblPrvP.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblPrvP.setText("0.00");
        lblPrvP.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lblPrvP.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jPanel26.add(lblPrvP);

        jPanel18.add(jPanel26);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Open Price");
        jPanel18.add(jLabel9);

        jPanel27.setBackground(new java.awt.Color(236, 235, 235));
        jPanel27.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        lblOpenP.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblOpenP.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblOpenP.setText("0.00");
        jPanel27.add(lblOpenP);

        jPanel18.add(jPanel27);

        jPanel7.add(jPanel18);

        jPanel19.setBackground(new java.awt.Color(236, 235, 235));
        jPanel19.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(0, 0, 0)));
        jPanel19.setLayout(new java.awt.GridLayout(1, 3));
        jPanel7.add(jPanel19);

        jPanel20.setBackground(new java.awt.Color(236, 235, 235));
        jPanel20.setLayout(new java.awt.GridLayout(1, 4));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("     Ask Price");
        jPanel20.add(jLabel11);

        jPanel28.setBackground(new java.awt.Color(236, 235, 235));
        jPanel28.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        lblAskP.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblAskP.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblAskP.setText("0.00");
        jPanel28.add(lblAskP);

        jPanel20.add(jPanel28);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Bid Price");
        jPanel20.add(jLabel3);

        jPanel29.setBackground(new java.awt.Color(236, 235, 235));
        jPanel29.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        lblBidP.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblBidP.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblBidP.setText("0.00");
        jPanel29.add(lblBidP);

        jPanel20.add(jPanel29);

        jPanel7.add(jPanel20);

        jPanel21.setBackground(new java.awt.Color(236, 235, 235));
        jPanel21.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(0, 0, 0)));
        jPanel21.setLayout(new java.awt.GridLayout(1, 2));
        jPanel7.add(jPanel21);

        jPanel22.setBackground(new java.awt.Color(236, 235, 235));
        jPanel22.setLayout(new java.awt.GridLayout(1, 4));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("     Change In Price");
        jPanel22.add(jLabel16);

        jPanel30.setBackground(new java.awt.Color(236, 235, 235));
        jPanel30.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        lblChangeInP.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblChangeInP.setForeground(new java.awt.Color(0, 204, 0));
        lblChangeInP.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblChangeInP.setText("0.00");
        lblChangeInP.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                lblChangeInPInputMethodTextChanged(evt);
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        jPanel30.add(lblChangeInP);

        jPanel22.add(jPanel30);

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("Change In Precentage");
        jPanel22.add(jLabel18);

        jPanel31.setBackground(new java.awt.Color(236, 235, 235));
        jPanel31.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        lblChangeInPrecentage.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblChangeInPrecentage.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblChangeInPrecentage.setText("0%");
        jPanel31.add(lblChangeInPrecentage);

        jPanel22.add(jPanel31);

        jPanel7.add(jPanel22);

        jPanel23.setBackground(new java.awt.Color(236, 235, 235));
        jPanel23.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(0, 0, 0)));
        jPanel23.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));
        jPanel7.add(jPanel23);

        jPanel24.setBackground(new java.awt.Color(236, 235, 235));
        jPanel24.setLayout(new java.awt.GridLayout(1, 4));

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setText("     Sector");
        jPanel24.add(jLabel21);

        lblSector.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblSector.setText("   ");
        lblSector.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                lblSectorInputMethodTextChanged(evt);
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        jPanel24.add(lblSector);

        jPanel43.setBackground(new java.awt.Color(236, 235, 235));

        javax.swing.GroupLayout jPanel43Layout = new javax.swing.GroupLayout(jPanel43);
        jPanel43.setLayout(jPanel43Layout);
        jPanel43Layout.setHorizontalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 196, Short.MAX_VALUE)
        );
        jPanel43Layout.setVerticalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );

        jPanel24.add(jPanel43);

        jPanel7.add(jPanel24);

        jPanel25.setBackground(new java.awt.Color(236, 235, 235));
        jPanel25.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(0, 0, 0)));
        jPanel25.setLayout(new java.awt.GridLayout(1, 1));
        jPanel7.add(jPanel25);

        jPanel5.add(jPanel7);
        jPanel7.setBounds(1, 450, 589, 180);

        jPanel4.add(jPanel5);
        jPanel5.setBounds(768, 32, 591, 630);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        jPanel8.setLayout(new java.awt.GridLayout(5, 0));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("       Buy Order");
        jPanel8.add(jLabel5);

        jPanel33.setBackground(new java.awt.Color(255, 255, 255));
        jPanel33.setLayout(new java.awt.GridLayout(1, 5));

        lblTicker2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTicker2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblTicker2.setText("Ticker :     ");
        jPanel33.add(lblTicker2);

        lblTicker.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTicker.setText("000");
        jPanel33.add(lblTicker);

        lblMPrice2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblMPrice2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblMPrice2.setText("Market Price :    ");
        jPanel33.add(lblMPrice2);

        lblMPrice.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblMPrice.setText("0.00");
        jPanel33.add(lblMPrice);

        jPanel34.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 151, Short.MAX_VALUE)
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
        );

        jPanel33.add(jPanel34);

        jPanel8.add(jPanel33);

        jPanel35.setBackground(new java.awt.Color(255, 255, 255));
        jPanel35.setLayout(new java.awt.GridLayout(1, 5));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel4.setText("Quantity     ");
        jPanel35.add(jLabel4);

        jPanel36.setBackground(new java.awt.Color(255, 255, 255));
        jPanel36.setLayout(null);

        txtQuant.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtQuant.setText("0");
        txtQuant.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtQuantFocusGained(evt);
            }
        });
        txtQuant.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtQuantKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtQuantKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtQuantKeyTyped(evt);
            }
        });
        jPanel36.add(txtQuant);
        txtQuant.setBounds(10, 10, 60, 23);

        jPanel35.add(jPanel36);

        lblAmount2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblAmount2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblAmount2.setText("Amount :    ");
        jPanel35.add(lblAmount2);

        lblAmount.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblAmount.setText("0.00");
        jPanel35.add(lblAmount);

        jPanel37.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 151, Short.MAX_VALUE)
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
        );

        jPanel35.add(jPanel37);

        jPanel8.add(jPanel35);

        jPanel38.setBackground(new java.awt.Color(255, 255, 255));
        jPanel38.setLayout(new java.awt.GridLayout(1, 3));

        lblMaxQuant.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMaxQuant.setText("Maximum quantity you can by ");
        jPanel38.add(lblMaxQuant);

        jPanel39.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel39Layout = new javax.swing.GroupLayout(jPanel39);
        jPanel39.setLayout(jPanel39Layout);
        jPanel39Layout.setHorizontalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 253, Short.MAX_VALUE)
        );
        jPanel39Layout.setVerticalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
        );

        jPanel38.add(jPanel39);

        jPanel40.setBackground(new java.awt.Color(255, 255, 255));
        jPanel40.setLayout(new javax.swing.BoxLayout(jPanel40, javax.swing.BoxLayout.LINE_AXIS));

        jPanel41.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel41Layout = new javax.swing.GroupLayout(jPanel41);
        jPanel41.setLayout(jPanel41Layout);
        jPanel41Layout.setHorizontalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 83, Short.MAX_VALUE)
        );
        jPanel41Layout.setVerticalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
        );

        jPanel40.add(jPanel41);

        btnBuyOrder.setBackground(new java.awt.Color(204, 0, 0));
        btnBuyOrder.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnBuyOrder.setForeground(new java.awt.Color(255, 255, 255));
        btnBuyOrder.setText("Place Order");
        btnBuyOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuyOrderActionPerformed(evt);
            }
        });
        jPanel40.add(btnBuyOrder);

        jPanel42.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel42Layout = new javax.swing.GroupLayout(jPanel42);
        jPanel42.setLayout(jPanel42Layout);
        jPanel42Layout.setHorizontalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 58, Short.MAX_VALUE)
        );
        jPanel42Layout.setVerticalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
        );

        jPanel40.add(jPanel42);

        jPanel38.add(jPanel40);

        jPanel8.add(jPanel38);

        jPanel4.add(jPanel8);
        jPanel8.setBounds(0, 481, 761, 180);

        lblRemaning.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblRemaning.setForeground(new java.awt.Color(0, 102, 153));
        lblRemaning.setText("Remaining Turns : ");
        lblRemaning.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                lblRemaningComponentShown(evt);
            }
        });
        jPanel4.add(lblRemaning);
        lblRemaning.setBounds(1191, 11, 168, 14);

        jPanel2.add(jPanel4);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 96, 1360, 660);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPortfoliosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPortfoliosActionPerformed
        if(log==0){
            panelPortfolios.show=0;
            showPortfolios();
        }   
    }//GEN-LAST:event_btnPortfoliosActionPerformed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
       int pos = jTextField1.getCaretPosition();
        jTextField1.setText(jTextField1.getText().toUpperCase());
        jTextField1.setCaretPosition(pos);
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        
    }//GEN-LAST:event_jTextField1KeyPressed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        if(jTextField1.getText().equals("") || jTextField1.getText().equals(" ")){
            JOptionPane.showMessageDialog(this, "Please enter symbol search", "Invalid Symbol", JOptionPane.WARNING_MESSAGE);
        }
        else{
            String serchStock=jTextField1.getText().toUpperCase();
            jPanel11.removeAll(); 
            List l=new List();
            List sec=new List();
            int i=0;
            for (String nyse : StockSymbols.nyse) {
                nyse=nyse.toUpperCase();
                if(serchStock.length()>2){
                    if (nyse.contains(serchStock)) {
                        l.add(nyse);
                        sec.add(StockSector.nyse[i]);
                    }
                }
                else{
                    if (nyse.equals(serchStock)) {
                        l.add(nyse);
                        sec.add(StockSector.nyse[i]);
                    }
                }
                i++;
            }
            i=0;
            for (String lse : StockSymbols.lse) {
                lse=lse.toUpperCase();
                if(serchStock.length()>2){
                    if (lse.contains(serchStock)) {
                        l.add(lse);
                        sec.add(StockSector.lse[i]);
                    }
                }
                else{
                    if (lse.equals(serchStock)) {
                        l.add(lse);
                        sec.add(StockSector.lse[i]);
                    }
                }
                i++;
            }
            i=0;
            for (String nms : StockSymbols.nms) {
                nms=nms.toUpperCase();
                if(serchStock.length()>2){
                    if (nms.contains(serchStock)) {
                        l.add(nms);
                        sec.add(StockSector.nms[i]);
                    }
                }
                else{
                    if (nms.equals(serchStock)) {
                        l.add(nms);
                        sec.add(StockSector.nms[i]);
                    }
                }
                i++;
            }
            i=0;
            for (String otherSymbols : StockSymbols.otherSymbols) {
                otherSymbols=otherSymbols.toUpperCase();
                if(serchStock.length()>2){
                    if (otherSymbols.contains(serchStock)) {
                        l.add(otherSymbols);
                        sec.add(StockSector.otherSector[i]);
                    }
                }
                else{
                    if (otherSymbols.equals(serchStock)) {
                        l.add(otherSymbols);
                        sec.add(StockSector.otherSector[i]);
                    }
                }
                i++;
            }
            String[] containStock=l.getItems();
            String[] containSector=sec.getItems();
            y=10;
            if(containStock.length==0){
                JOptionPane.showMessageDialog(this, "No results.", "Search Result", JOptionPane.INFORMATION_MESSAGE);
            }else{
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        openDialog();
                        for(int j=0;j<containStock.length;j++){
                            jPanel11.add(setTab(containStock[j],containSector[j]));
                            y=y+75;
                        }
                        jPanel11.setPreferredSize(new Dimension(740, y+20));
                    jScrollPane2.repaint();
                    jPanel9.validate();
                    jPanel9.repaint();
                    closeDialog();
                    }
                }, 0);
                
            }
        }
        
    }//GEN-LAST:event_jButton9ActionPerformed

    private void btnBuyOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuyOrderActionPerformed
           if(balance>=Double.parseDouble(lblAmount.getText())){
               int quant=Integer.parseInt(txtQuant.getText());
               double price=Double.parseDouble(lblMPrice.getText());
               int maxQuant=(int)(balance/price);
               if(quant>0){
                   new Timer().schedule(new TimerTask() {
                       @Override
                       public void run() {
                            Clock c= new Clock();
                            c.setDate(date);
                            buyOrder();
                       }
                   }, 0);
               }
               else{
                   JOptionPane.showMessageDialog(this, "Please buy more quntity. you can buy upto "+maxQuant+" quntity.", "Insufficient Quantity", JOptionPane.WARNING_MESSAGE);
                }
            }
            else{
               JOptionPane.showMessageDialog(this, "Your don't have sufficient balance to buy this quantity. Try less quantity to buy stocks.", "Account Balance", JOptionPane.WARNING_MESSAGE);
            }
    }//GEN-LAST:event_btnBuyOrderActionPerformed

    private void btnTradingCenterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTradingCenterActionPerformed
        if(log==0){
            showTradingCenter();
        }
    }//GEN-LAST:event_btnTradingCenterActionPerformed

    private void formWindowDeactivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowDeactivated
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowDeactivated

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        
    }//GEN-LAST:event_formWindowActivated

    private void txtQuantKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQuantKeyTyped
        char v=evt.getKeyChar();
        if (!(Character.isDigit(v)) || (v==KeyEvent.VK_BACK_SPACE) || (v==KeyEvent.VK_DELETE)) {
           evt.consume();
           
        }
        
    }//GEN-LAST:event_txtQuantKeyTyped

    private void txtQuantKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQuantKeyReleased
       if(!(txtQuant.getText().equals(""))){
            double price=Double.parseDouble(lblMPrice.getText());
            int maxQuant=(int)(balance/price);
            int quant=Integer.parseInt(txtQuant.getText());
            if(quant>maxQuant){
                quant=maxQuant;
                txtQuant.setText(quant+"");
            }
            double amount=price*quant;
            lblAmount.setText(amount+"");
       }
       else{
           lblAmount.setText("0.00");
           txtQuant.setText("0");
       }
      
    }//GEN-LAST:event_txtQuantKeyReleased

    private void txtQuantKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQuantKeyPressed
        
    }//GEN-LAST:event_txtQuantKeyPressed

    private void txtQuantFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtQuantFocusGained
       txtQuant.selectAll();
    }//GEN-LAST:event_txtQuantFocusGained

    private void lblChangeInPInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_lblChangeInPInputMethodTextChanged
        
    }//GEN-LAST:event_lblChangeInPInputMethodTextChanged

    private void lblSectorInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_lblSectorInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_lblSectorInputMethodTextChanged

    private void btnNewsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewsActionPerformed
        if(log==0){
            showPanelNewsForm();
        }
    }//GEN-LAST:event_btnNewsActionPerformed

    private void btnLeaderBoardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLeaderBoardActionPerformed
          if(log==0){
            showLeaderBoard();
        }
    }//GEN-LAST:event_btnLeaderBoardActionPerformed

    private void btnBuyRecommendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuyRecommendActionPerformed
       showPanelbuyRecomendation();
    }//GEN-LAST:event_btnBuyRecommendActionPerformed

    private void btnSellRecommendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSellRecommendActionPerformed
        panelPortfolios.show=1;
        showPortfolios();
    }//GEN-LAST:event_btnSellRecommendActionPerformed

    private void panelShowRecommendationComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_panelShowRecommendationComponentShown
                
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                panelShowRecommendation.setVisible(false);
                lblAnalyst.setVisible(false);
            }
        }, 30000);
        if(suspend==0){
            timerRecommendation=new Timer();
            timerRecommendation.schedule(new TimerTask() {
                @Override
                public void run() {
                    if(suspend==0){
                        showRecommendation();
                    }
                    else{
                        this.cancel();
                    }
                }
            }, 420000);
        }
        
    }//GEN-LAST:event_panelShowRecommendationComponentShown

    private void lblRemaningComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_lblRemaningComponentShown
        if(remainTurn<=0){
            remainTurn=0;
            suspend=1;
            FxMediaExample2.frame.lblRemaning.setText("Remaning Turns: "+remainTurn);
            suspendPlayer();
            
            JOptionPane.showMessageDialog(this, "You have reached maximum turn in the game.", "Game End",JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                remainTurn--;
                if(remainTurn<=0){
                    remainTurn=0;
                    FxMediaExample2.frame.lblRemaning.setText("Remaning Turns: "+remainTurn);
                    suspend=1;
                    suspendPlayer();
                    
                    JOptionPane.showMessageDialog(FxMediaExample2.frame, "You have reached maximum turn in the game.", "Game End",JOptionPane.INFORMATION_MESSAGE);
                    this.cancel();
                }
                else{
                    FxMediaExample2.frame.lblRemaning.setText("Remaning Turns: "+remainTurn);
                    if(panelPortfolios2!=null){
                        panelPortfolios.remainingTurns.setText("Remaning Turns: "+remainTurn);
                    }
                }
                 
            }
        }, 0, 60000);
        }
        
    }//GEN-LAST:event_lblRemaningComponentShown

    private void btnSettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSettingsActionPerformed
        jPopupMenu1= new JPopupMenu(){
            @Override
            protected void paintComponent(Graphics g) {
                //super.paintComponent(g);
                g.setColor(Color.black);
                g.fillRect(0,0,getWidth(), getHeight());
            }
            
        };
        JMenuItem menuCreatePlayer= new JMenuItem("Create New Player");
        menuCreatePlayer.setForeground(Color.white);
        menuCreatePlayer.setFont(new Font("Tahoma", 0, 14));
        menuCreatePlayer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        
        menuCreatePlayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showPanelNewPlayer();
                panelPlayer2.signupFromAfterLogin();
            }
        });
        
        JMenuItem menuChangePlayer= new JMenuItem("Change Player");
        menuChangePlayer.setForeground(Color.white);
        menuChangePlayer.setFont(new Font("Tahoma", 0, 14));
        menuChangePlayer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        
        menuChangePlayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SelectPlayer f= new SelectPlayer();
                    f.show();
                    f.addWindowListener(new WindowListener() {
                        @Override
                        public void windowOpened(WindowEvent e) {
                           FxMediaExample2.frame.setEnabled(false); 
                        }
 
                        @Override
                        public void windowClosing(WindowEvent e) {}

                        @Override
                        public void windowClosed(WindowEvent e) {
                            FxMediaExample2.frame.setEnabled(true); 
                            
                        }
                        
                        @Override
                        public void windowIconified(WindowEvent e) {}

                        @Override
                        public void windowDeiconified(WindowEvent e) {}

                        @Override
                        public void windowActivated(WindowEvent e) {}

                        @Override
                        public void windowDeactivated(WindowEvent e) {}
                    });
            }
        });
        
        JMenuItem menuResetPlayer= new JMenuItem("Reset Player");
        menuResetPlayer.setForeground(Color.white);
        menuResetPlayer.setFont(new Font("Tahoma", 0, 14));
        menuResetPlayer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        
        menuResetPlayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        int r=JOptionPane.showConfirmDialog(FxMediaExample2.frame,"Are you sure? Do you want to reset player "+ panelPortfolios.player+". All the transaction of player will be deleted.","Reset Player",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                        if(r==JOptionPane.YES_OPTION){
                            openDialog();
                            resetPlayer();
                            closeDialog();
                            JOptionPane.showMessageDialog(FxMediaExample2.frame, "Player Successfully Reset", "Player Reset", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                }, 0);
            }
        });
        
        JMenuItem menuResetComputerPlayer= new JMenuItem("Reset Computer Player");
        menuResetComputerPlayer.setForeground(Color.white);
        menuResetComputerPlayer.setFont(new Font("Tahoma", 0, 14));
        menuResetComputerPlayer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        
        menuResetComputerPlayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        int r=JOptionPane.showConfirmDialog(FxMediaExample2.frame,"Are you sure? Do you want to reset computer player. All the transaction of player will be deleted.","Reset Player",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                        if(r==JOptionPane.YES_OPTION){
                            openDialog();
                            resetComputerPlayer();
                            closeDialog();
                            JOptionPane.showMessageDialog(FxMediaExample2.frame, "Player Successfully Reset", "Player Reset", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                }, 0);
            }
        });
        
        JMenuItem menuLogout= new JMenuItem("Logout");
        menuLogout.setForeground(Color.white);
        menuLogout.setFont(new Font("Tahoma", 0, 14));
        menuLogout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        
        menuLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelPortfolios.player="";
                log=2;
                balance=0.00;
                suspend=1;
                lblRemain.setVisible(false);
                suspendPlayer();
                if(timerRecommendation!=null){
                    timerRecommendation.cancel();
                }
                
                showPanelNewPlayer();
                                    
            }
        });
        
        jPopupMenu1.add(menuCreatePlayer);
        jPopupMenu1.add(menuChangePlayer);
        jPopupMenu1.add(menuResetPlayer);
        jPopupMenu1.add(menuResetComputerPlayer);
        if(log==0){
             jPopupMenu1.add(menuCreatePlayer);
            jPopupMenu1.add(menuChangePlayer);
            jPopupMenu1.add(menuResetPlayer);
            jPopupMenu1.add(menuResetComputerPlayer);
            jPopupMenu1.add(menuLogout);
        }
        
        jPopupMenu1.show(btnSettings, 0, 50);
      
    }//GEN-LAST:event_btnSettingsActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        openTableData();
        showHistory();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        closeTableData();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
      if (Desktop.isDesktopSupported()) {
            try {
                File myFile = new File(getClass().getResource("/user_manual.pdf").toURI());
                 Desktop.getDesktop().open(myFile);
                  this.setState(Frame.ICONIFIED);
            } catch (IOException ex) {
        
            } catch (URISyntaxException ex) {
              Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
          }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        closeAboutDialog();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInfoActionPerformed
        openAboutDialog();
    }//GEN-LAST:event_btnInfoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
       
    }
    
    public JPanel setTab(String symbol, String sector){
       
        StockQuotes q= new StockQuotes();
            
            q.setStock(symbol);
            final String name=q.getStockName();
             
            JPanel p= new JPanel();
            p.setLayout(null);
            System.out.println("panel width"+panelNYSEContainer.getWidth());
            p.setSize(new Dimension(panelNYSEContainer.getWidth()-10, 70));
            p.setBounds(x, y, panelNYSEContainer.getWidth()-20, 70);
            p.setToolTipText("Click for get statistic.");
            p.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            p.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 102, 153)));
            p.setVisible(true);
            p.setBackground(new Color(242,242,255));
            
            int xx=0;
            JLabel lblSymbol = new JLabel();
            lblSymbol.setFont(new Font("Tahoma", 1, 14));
            lblSymbol.setBounds((int)(panelNYSEContainer.getWidth()*(0.01643836)), 13, 90, 17);
            
            
            xx=(int)(lblSymbol.getX()+90+( panelNYSEContainer.getWidth()*(0.01780822)));
            JLabel lblName = new JLabel();
            lblName.setFont(new Font("Tahoma", 0, 14));
            lblName.setBounds(xx, 13, 570, 17);
            
            
            JLabel lblStockExchange = new JLabel();
            lblStockExchange.setFont(new Font("Tahoma", 0, 12));
            lblStockExchange.setBounds((int)(p.getWidth()*(0.01643836)), 41, 200,15);
            
            xx=(int)(lblStockExchange.getX()+200+( panelNYSEContainer.getWidth()*(0.02876712)));
            JLabel lblAsk = new JLabel();
            lblAsk.setFont(new Font("Tahoma", 0, 12));
            lblAsk.setBounds(xx, 41, 100,15);
            
            xx=(int)(lblAsk.getX()+100+( panelNYSEContainer.getWidth()*(0.02876712)));
            JLabel lblBid = new JLabel();
            lblBid.setFont(new Font("Tahoma", 0, 12));
            lblBid.setBounds(xx, 41, 100,15);
            
            xx=(int)(lblBid.getX()+100+( panelNYSEContainer.getWidth()*(0.02876712)));
            JLabel lblPrice = new JLabel();
            lblPrice.setFont(new Font("Tahoma", 0, 12));
            lblPrice.setBounds(xx, 41, 100,15);
            
            xx=(int)(lblPrice.getX()+100+( panelNYSEContainer.getWidth()*(0.02876712)));
            JLabel lblPrevPrice = new JLabel();
            lblPrevPrice.setFont(new Font("Tahoma", 0, 12));
            lblPrevPrice.setBounds(xx, 41, 130,15);
            
            lblSymbol.setText(symbol);
            lblSymbol.setName(symbol);
            lblName.setText(q.getStockName());
            lblName.setName(q.getStockName());
            lblStockExchange.setText("stockExchange: "+q.getStockExchange());
            lblAsk.setText("Ask: "+q.getASKPrice());
            lblBid.setText("Bid: "+q.getBIDPrice());
            lblPrice.setText("Price: "+q.getPrice());
            lblPrevPrice.setText("Prev close: "+q.getPrevPrice());
            
            priceMap.put(symbol, q.getPrice());
            bidMap.put(symbol, q.getBIDPrice());
            askMap.put(symbol, q.getASKPrice());
            
            lblSymbol.setVisible(true);
            lblName.setVisible(true);
            lblStockExchange.setVisible(true);
            lblAsk.setVisible(true);
            lblBid.setVisible(true);
            lblPrice.setVisible(true);
            lblPrevPrice.setVisible(true);
            
            Timer t = new Timer();
            t.schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    
                    Stock s= YahooFinance.get(lblSymbol.getText());
                    lblAsk.setText("Ask: "+s.getQuote().getAsk().setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
                    lblBid.setText("Bid: "+s.getQuote().getBid().setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
                    lblPrice.setText("Price: "+s.getQuote().getPrice().setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
                    lblPrevPrice.setText("Prev close: "+s.getQuote().getPreviousClose().setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
                    
                    priceMap.put(symbol, Double.parseDouble(lblPrice.getText().substring(7)));
                    bidMap.put(symbol, Double.parseDouble(lblBid.getText().substring(5)));
                    askMap.put(symbol, Double.parseDouble(lblAsk.getText().substring(5)));
                    
                    if(symbolForGraph.equals(lblSymbol.getText())){
                        double bid=Double.parseDouble(lblAsk.getText().substring(5));
                        lblMPrice.setText(""+bid);
                        int maxQuant=(int)(balance/bid);
                        lblMaxQuant.setText("Maximum quantity you can by : "+maxQuant);
                        int quant=Integer.parseInt(txtQuant.getText());
                        if(quant>maxQuant){
                            quant=maxQuant;
                            txtQuant.setText(quant+"");
                        }
                        double amount=bid*quant;
                        lblAmount.setText(amount+"");
                        
                        lblPrvP.setText(lblPrevPrice.getText().substring(12));
                        lblOpenP.setText(s.getQuote().getOpen().setScale(2, BigDecimal.ROUND_HALF_UP)+"");
                        lblAskP.setText(lblAsk.getText().substring(5));
                        lblBidP.setText(lblBid.getText().substring(5));
                        double change=s.getQuote().getChange().setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                        double changePercent=s.getQuote().getChangeInPercent().setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                        lblChangeInP.setText(change+"");
                        lblChangeInPrecentage.setText(changePercent+"%");
                        
                        if(change>=0){
                            lblChangeInP.setForeground(new Color(0, 204, 0));
                        }
                        else{
                            lblChangeInP.setForeground(Color.red);
                        }
                                   
                        if(changePercent>=0){
                            lblChangeInPrecentage.setForeground(new Color(0, 204, 0));
                        }
                        else{
                            lblChangeInPrecentage.setForeground(Color.red);
                        }
                        jPanel7.setVisible(true);
                    }
                
                } catch (IOException ex) {
                    Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }, 0, 60000);
            
            
            p.addMouseListener(new MouseAdapter() {
                 @Override
                 public void mouseClicked(MouseEvent e) {
                     if(InternetConnection.getInternetStatus()){
                        super.mouseClicked(e);
                         symbolForGraph=p.getComponent(0).getName();
                         stockName=p.getComponent(1).getName();
                         graphTimer.cancel();
                         
                         jPanel10.removeAll();
                         chart= new LineChart_AWT(name);
                         jPanel10.add(chart,BorderLayout.CENTER);
                         setGraph();
                         
                         lblTicker.setText(symbol);
                         double ask=Double.parseDouble(lblAsk.getText().substring(5));
                         lblMPrice.setText(""+ask);
                         int maxQuant=(int)(balance/ask);
                         if(ask==0){
                             maxQuant=0;
                         }
                         lblMaxQuant.setText("Maximum quantity you can by : "+maxQuant);
                         
                         
                         new Timer().schedule(new TimerTask() {
                            @Override
                            public void run() {
                                try {
                                    Stock s= YahooFinance.get(symbol);
                                    lblStock.setText("    "+symbol);
                                    lblPrvP.setText(s.getQuote().getPreviousClose().setScale(2, BigDecimal.ROUND_HALF_UP)+"");
                                    lblOpenP.setText(s.getQuote().getOpen().setScale(2, BigDecimal.ROUND_HALF_UP)+"");
                                    lblAskP.setText(s.getQuote().getAsk().setScale(2, BigDecimal.ROUND_HALF_UP)+"");
                                    lblBidP.setText(s.getQuote().getBid().setScale(2, BigDecimal.ROUND_HALF_UP)+"");
                                    double change=s.getQuote().getChange().setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                                    double changePercent=s.getQuote().getChangeInPercent().setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                                    lblChangeInP.setText(""+change);
                                    lblChangeInPrecentage.setText(changePercent+"%");
                                    if(change>=0){
                                        lblChangeInP.setForeground(new Color(0, 204, 0));
                                    }
                                    else{
                                        lblChangeInP.setForeground(Color.red);
                                    }
                                    
                                    if(changePercent>=0){
                                        lblChangeInPrecentage.setForeground(new Color(0, 204, 0));
                                    }
                                    else{
                                        lblChangeInPrecentage.setForeground(Color.red);
                                    }
                                    lblSector.setText(sector);
                                    jPanel7.setVisible(true);
                                } catch (IOException ex) {
                                    Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        }, 0);
                 }
                 }
               
           });
            
            p.add(lblSymbol);
            p.add(lblName);
            p.add(lblStockExchange);
            p.add(lblAsk);
            p.add(lblBid);
            p.add(lblPrice);
            p.add(lblPrevPrice);
            
        return p;
        
    }
    
    private void setGraph(){
                        graphTimer=new Timer();
                        graphTimer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            try {
                                double d=priceMap.get(symbolForGraph);
                                chart.setDataset(d, turn);
                                turn++;
                            } catch (Exception ex) {
                               ex.printStackTrace();
                            }
                            
                            }
                        },0, 60000);
                        
                                chart.initChart();
                                
                                jPanel10.validate();
                                
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuyOrder;
    private javax.swing.JButton btnBuyRecommend;
    private javax.swing.JButton btnInfo;
    private javax.swing.JButton btnLeaderBoard;
    private javax.swing.JButton btnNews;
    private javax.swing.JButton btnPortfolios;
    private javax.swing.JButton btnSellRecommend;
    private javax.swing.JButton btnSettings;
    private javax.swing.JButton btnTradingCenter;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton9;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JDialog jDialog3;
    private javax.swing.JDialog jDialog4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblAmount;
    private javax.swing.JLabel lblAmount2;
    private javax.swing.JLabel lblAnalyst;
    private javax.swing.JLabel lblAskP;
    private javax.swing.JLabel lblBidP;
    private javax.swing.JLabel lblChangeInP;
    private javax.swing.JLabel lblChangeInPrecentage;
    private javax.swing.JLabel lblMPrice;
    private javax.swing.JLabel lblMPrice2;
    private javax.swing.JLabel lblMaxQuant;
    private javax.swing.JLabel lblOpenP;
    private javax.swing.JLabel lblPrvP;
    private javax.swing.JLabel lblRemaning;
    private javax.swing.JLabel lblSector;
    private javax.swing.JLabel lblStock;
    private javax.swing.JLabel lblStockName;
    private javax.swing.JLabel lblStockname2;
    private javax.swing.JLabel lblTicker;
    private javax.swing.JLabel lblTicker2;
    private javax.swing.JPanel panelLSE;
    private javax.swing.JPanel panelLSEContainer;
    private javax.swing.JPanel panelNMS;
    private javax.swing.JPanel panelNMSContainer;
    private javax.swing.JPanel panelNYSE;
    private javax.swing.JPanel panelNYSEContainer;
    private javax.swing.JPanel panelShowRecommendation;
    private javax.swing.JTextField txtQuant;
    // End of variables declaration//GEN-END:variables

    public void setNYSETab() {
        panelNYSEContainer.removeAll();
        y=10;
        for(int i=0;i<20;i++){
            panelNYSEContainer.add(setTab(StockSymbols.nyse[i],StockSector.nyse[i]));
           y=y+75;
        }
        panelNYSEContainer.setPreferredSize(new Dimension(740, y+20));
        
        jScrollPane4.repaint();
        panelNYSE.validate();
        panelNYSE.repaint();
        
    }
    public void setLSETab() {
        panelLSEContainer.removeAll();
        y=10;
        for(int i=0;i<20;i++){
           panelLSEContainer.add(setTab(StockSymbols.lse[i],StockSector.lse[i]));
           y=y+75;
        }
        panelLSEContainer.setPreferredSize(new Dimension(740, y+20));
        
        jScrollPane5.repaint();
        panelLSE.validate();
        panelLSE.repaint();
    }
    public void setNSMTab() {
        panelNMSContainer.removeAll();
       y=10;
        for(int i=0;i<20;i++){
           panelNMSContainer.add(setTab(StockSymbols.nms[i],StockSector.nms[i]));
           y=y+75;
        }
        panelNMSContainer.setPreferredSize(new Dimension(740, y+20));
        
        jScrollPane6.repaint();
        panelNMS.validate();
        panelNMS.repaint();
    }

    public static void showPortfolios() {
        panelSetting();
        panelPortfolios2= new panelPortfolios();
       
        panelPortfolios2.setVisible(true);
        panelPortfolios2.setBounds(0, jpanel1.getHeight()+5,FxMediaExample2.frame.getWidth(), (int)(FxMediaExample2.frame.getHeight()*0.859375));
        panelPortfolios.tabpane.setBounds((int)(panelPortfolios2.getWidth()*0.03074671), (int)(panelPortfolios2.getHeight()*0.39285714), (int)(panelPortfolios2.getWidth()*0.91508053), (int)(panelPortfolios2.getHeight()*0.57763975));
        panelPortfolios.btnStats.setBounds((int)(panelPortfolios2.getWidth()*0.83455344), 10, 210,23);
        panelPortfolios.remainingTurns.setBounds((int)(panelPortfolios2.getWidth()*0.83455344), 133, 210,23);
        
        jp.getParent().add(panelPortfolios2);
        jp.getParent().revalidate();
        jp.getParent().repaint();
    }
    public static void showPanelbuyRecomendation() {
        panelSetting();
        jp.setVisible(true);
        jtab.setVisible(false);
        panelbuyRecomendation= new panelBuyRecomendation();
       
        panelbuyRecomendation.setVisible(true);
        panelbuyRecomendation.setBounds(0, 0, jp15.getWidth(), jp15.getHeight());
        jp15.add(panelbuyRecomendation);
        jp.getParent().revalidate();
        jp.getParent().repaint();
        
    }
    public static void showPanelNewPlayer() {
        panelSetting();
        panelPlayer2= new panelPlayer();
       
        
        panelPlayer2.setVisible(true);
        panelPlayer2.setBounds(0, jpanel1.getHeight()+5,FxMediaExample2.frame.getWidth(), (int)(FxMediaExample2.frame.getHeight()*0.859375));
        panelPlayer.lblImage.setBounds((int)(panelPlayer2.getWidth()*0.43923865),(int)(panelPlayer2.getHeight()*0.0310559),100,100);
        panelPlayer.panel.setBounds((int)(panelPlayer2.getWidth()*0.29282577),(int)(panelPlayer2.getHeight()*0.1863354),553,482);
        
        jp.getParent().add(panelPlayer2);
        jp.getParent().revalidate();
        jp.getParent().repaint();
        
    }
    public static void showPanelNewsForm() {
        panelSetting();
        panelNewsForm2= new panelNewsForm();
       
        panelNewsForm2.setVisible(true);
        panelNewsForm2.setBounds(0, jpanel1.getHeight()+5,FxMediaExample2.frame.getWidth(), (int)(FxMediaExample2.frame.getHeight()*0.859375));
        panelNewsForm.scroll.setBounds((int)(panelNewsForm2.getWidth()*0.0534407),(int)(panelNewsForm2.getHeight()*0.12732919) ,(int)(panelNewsForm2.getWidth()*0.88726208), (int)(panelNewsForm2.getHeight()*0.77639752));
        
        jp.getParent().add(panelNewsForm2);
        jp.getParent().revalidate();
        jp.getParent().repaint();
    }
    
    public static void showLeaderBoard() {
        panelSetting();
        panelBoard= new panelLeaderBoard();
       
        panelBoard.setVisible(true);
        panelBoard.setBounds(0, jpanel1.getHeight()+5,FxMediaExample2.frame.getWidth(), (int)(FxMediaExample2.frame.getHeight()*0.859375));
        panelLeaderBoard.panel.setBounds((int)(panelBoard.getWidth()*0.16471449),(int)(panelBoard.getHeight()*0.19099379) ,(int)(panelBoard.getWidth()*0.63762811), (int)(panelBoard.getHeight()*0.75465839));
        System.out.println("JKL"+(int)(panelBoard.getWidth()*0.63762811));
        jp.getParent().add(panelBoard);
        jp.getParent().revalidate();
        jp.getParent().repaint();
    }
    
    public static void showTradingCenter() {
        panelSetting();
        jp.setBounds(0, jpanel1.getHeight()+5,FxMediaExample2.frame.getWidth(), (int)(FxMediaExample2.frame.getHeight()*0.859375));
        jp15.setSize((int)(jp.getWidth()*0.55506929), (int)(jp.getHeight()*0.71257485));
        //lblRemain.setBounds(jp.getWidth()-170, 11, 168, 14);
        jpanel5.setBounds(((int)(jp.getWidth()*0.55506929)+5),32,(int)(jp.getWidth()*0.43107221), (int)(jp.getHeight()*0.94311377));
        jpanel8.setBounds(0,jp15.getHeight()+2,jp15.getWidth(), (int)(jp.getHeight()*0.27272727));
        jpanel10.setSize(jpanel5.getWidth(), (int)(jpanel5.getHeight()*0.71428571));
        jpanel7.setBounds(0,jpanel10.getHeight(),jpanel10.getWidth(),(int)(jp.getHeight()*0.27272727));
        jpanel9.setBounds(0,112,(int)(jp15.getWidth()*0.9934297),(int)(jp.getHeight()*0.70253165));
        jp.setVisible(true);
        jtab.setVisible(true);
        jp.getParent().revalidate();
        jp.getParent().repaint();
    }
    
   private static void panelSetting(){
       jp.setVisible(false);
       if(panelPlayer2!=null){
           panelPlayer2.setVisible(false);
       }
       if(panelPortfolios2!=null){
           panelPortfolios2.setVisible(false);
       } 
       if(panelNewsForm2!=null){
           panelNewsForm2.setVisible(false);
       } 
       if(panelbuyRecomendation!=null){
           panelbuyRecomendation.setVisible(false);
       }
       if(panelBoard!=null){
           panelBoard.setVisible(false);
       }
   }
    
   private void buyOrder(){
       int response = JOptionPane.showConfirmDialog(this,
               "Do you want to buy "+ txtQuant.getText()+" shares from "+lblTicker.getText()+" ?\n\nPrice : "+lblMPrice.getText()+"\nAmount : "+lblAmount.getText(),
               "Confirm Buy Order",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
       if(response==JOptionPane.YES_OPTION){
           if(InternetConnection.getInternetStatus()){
            openDialog();
            Broker b= new Broker();
            b.buy(panelPortfolios.player, lblTicker.getText(), Integer.parseInt(txtQuant.getText()),Double.parseDouble(lblMPrice.getText()));
            balance=new Bank().getBalance(panelPortfolios.player);
            lblTicker.setText("");
            lblMPrice.setText("0.00");
            lblMaxQuant.setText("Maximum quantity you can by ");
            txtQuant.setText("0");
            lblAmount.setText("0.00");
            closeDialog();
           }
           
       }
       
   }
   
   public void openDialog(){
            jDialog1.setUndecorated(true);
            jDialog1.setSize(392, 151);
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            jDialog1.setLocation(dim.width/2-jDialog1.getSize().width/2, dim.height/2-jDialog1.getSize().height/2);
            jDialog1.setVisible(true);
            FxMediaExample2.frame.setEnabled(false);
            
    }
    
    public void closeDialog(){
            FxMediaExample2.frame.setEnabled(true);
            jDialog1.dispose();
    }
    
     public void openAboutDialog(){
            jDialog4.setUndecorated(true);
            jDialog4.setSize(851, 503);
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            jDialog4.setLocation(dim.width/2-jDialog4.getSize().width/2, dim.height/2-jDialog4.getSize().height/2);
            jDialog4.setVisible(true);
            FxMediaExample2.frame.setEnabled(false);
            
    }
    
    public void closeAboutDialog(){
            FxMediaExample2.frame.setEnabled(true);
            jDialog4.dispose();
    }
    
    public void openStartupDilog(){
            jDialog3.setUndecorated(true);
            jDialog3.setSize(347, 130);
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            jDialog3.setLocation(dim.width/2-jDialog3.getSize().width/2, dim.height/2-jDialog3.getSize().height/2);
            jDialog3.setVisible(true);
            FxMediaExample2.frame.setEnabled(false);
            
    }
    
    public void closeStartupDilog(){
            FxMediaExample2.frame.setEnabled(true);
            jDialog3.dispose();
    }
    
    public void openTableData(){
            jDialog2.setUndecorated(true);
            jDialog2.setSize(923, 454);
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            jDialog2.setLocation(dim.width/2-jDialog2.getSize().width/2, dim.height/2-jDialog2.getSize().height/2);
            jDialog2.setVisible(true);
            FxMediaExample2.frame.setEnabled(false);
            
    }
    
    public void closeTableData(){
            FxMediaExample2.frame.setEnabled(true);
            jDialog2.dispose();
    }
    
    public  void showRecommendation(){
        Analyst analyst= new Analyst();
        System.out.println("Start Time:"+new Date().toString());
        analyst.getRecommendation();
        panelShowRecommendation.setVisible(true);
        lblAnalyst.setVisible(true);
        int i=0;
        if(Analyst.buy.getItemCount()>0){
            btnBuyRecommend.setEnabled(true);
            i=1;
        }
        else{
            btnBuyRecommend.setEnabled(false);
            i=0;
        }
        int j=0;
        if(Analyst.sell.getItemCount()>0){
            btnSellRecommend.setEnabled(true);
            j=1;
        }
        else{
            btnSellRecommend.setEnabled(false);
            j=0;
        }
        if(i==1 || j==1){
             playSound("/voice.wav");
        }
        else{
            playSound("/no_recommendation.wav");
        }
       System.out.println("End Time:"+new Date().toString());
        
    }
    
    public void playSound(String path){
        
        try {
            InputStream test=getClass().getResourceAsStream(path);
            AudioStream BGM = new AudioStream(test);
            AudioPlayer.player.start(BGM);
            AudioPlayer.player.run();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void startRecommendation(){
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                if(suspend==0){
                    showRecommendation();
                }
                
            }
        }, 0);
    }
    
    public static void showRemaningTurns(){
        
                Clock c= new Clock();
                c.setDate(date);
                remainTurn=1441-c.now();
                FxMediaExample2.frame.lblRemaning.setVisible(true);
                if(remainTurn<=0){
                    remainTurn=0;
                    suspend=1;
                    
                }
    }
    
    public void suspendPlayer(){
        btnBuyOrder.setEnabled(false);
        txtQuant.setEnabled(false);
        txtQuant.setText("0");
         
    }
    public void activePlayer(){
        btnBuyOrder.setEnabled(true);
        txtQuant.setEnabled(true);
        txtQuant.setText("0");
    }
    
    public void showHistory(){
                lblStockName.setText(stockName);
                lblStockname2.setText(symbolForGraph);
                DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                centerRenderer.setHorizontalAlignment( JLabel.CENTER );
                jTable1.setDefaultRenderer(String.class, centerRenderer);
                Object[] obj= new Object[5];
                DefaultTableModel model =(DefaultTableModel)jTable1.getModel();
                
                Document doc =  Jsoup.parse(readURL("https://finance.yahoo.com/quote/"+symbolForGraph+"/history?p="+symbolForGraph));
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
                                        if(k==0){
                                            obj[k]=w.text().replace(",", "");
                                        }
                                        if(k==1){
                                            obj[k]=w.text().replace(",", "");
                                        }
                                        if(k==2){
                                            obj[k]=w.text().replace(",", "");
                                        }
                                        if(k==3){
                                            obj[k]=w.text().replace(",", "");
                                         }
                                        if(k==4){
                                            obj[k]=w.text().replace(",", "");
                                        }
                                        else if(k>4){
                                            break;
                                        }
                                        k++;
                                    }
                                    model.addRow(obj);
                                }
                               j++;
                            }
                       }
                       i++;
                    }
                    
                     
    }
    
    public void resetPlayer(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://65.19.141.67:3306/piyumald_stock","piyumald_piyumal","c19940603c");
            Statement stmnt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            stmnt.execute("delete  from Buy where name=(select broker_name from Broker where player_name = '"+panelPortfolios.player+"')");
            stmnt.execute("delete  from Sell where name=(select broker_name from Broker where player_name = '"+panelPortfolios.player+"')");
            stmnt.execute("delete  from Withdraw where player_name='"+panelPortfolios.player+"'");
            stmnt.execute("delete  from Deposit where player_name='"+panelPortfolios.player+"'");
            Date d= new Date();
            SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd HH:mm");
            String date=format.format(d);
            stmnt.execute("update Bank set balance=1000, date='"+date+"' where player_name='"+panelPortfolios.player+"'");
            con.close();
            balance=new Bank().getBalance(panelPortfolios.player);
            suspend=0;
            lblRemain.setVisible(false);
            activePlayer();
            SelectPlayer.setPlayerDate(panelPortfolios.player);
            showRemaningTurns();
            if(Frame.timerRecommendation!=null){
                Frame.timerRecommendation.cancel();
            }
            startRecommendation();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void resetComputerPlayer(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://65.19.141.67:3306/piyumald_stock","piyumald_piyumal","c19940603c");
            Statement stmnt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            stmnt.execute("delete  from Buy where name=(select broker_name from Broker where player_name = '"+ComputerPlayer.computerPlayer+"')");
            stmnt.execute("delete  from Sell where name=(select broker_name from Broker where player_name = '"+ComputerPlayer.computerPlayer+"')");
            stmnt.execute("delete  from Withdraw where player_name='"+ComputerPlayer.computerPlayer+"'");
            stmnt.execute("delete  from Deposit where player_name='"+ComputerPlayer.computerPlayer+"'");
            Date d= new Date();
            SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd HH:mm");
            String date=format.format(d);
            stmnt.execute("update Bank set balance=1000, date='"+date+"' where player_name='"+ComputerPlayer.computerPlayer+"'");
            con.close();
            ComputerPlayer c=new ComputerPlayer();
            c.setDate();
            c.setBalance();
            Clock cl= new Clock();
            cl.setDate(ComputerPlayer.date);
            ComputerPlayer.myturn=1441-cl.now();
            c.play();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }



}
