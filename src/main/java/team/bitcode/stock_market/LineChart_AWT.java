/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team.bitcode.stock_market;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.Minute;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;

public class LineChart_AWT extends JPanel{
     public  TimeSeriesCollection dataset=new TimeSeriesCollection();
     public  TimeSeries se=new TimeSeries("Data",Minute.class);
     private String title="";
     
    
    public LineChart_AWT(String tit){
        this.title=tit;
    }
     
    public void setDataset(double price, int turn) {
        
        se.add(new Minute(), price);
        
        //dataset.addValue( price , "Price" , turn+"" );
        
    }
    
    public void initChart(){
        dataset.addSeries(se); 
        JFreeChart lineChart = ChartFactory.createTimeSeriesChart(
         title,
         "Turn","Stock Price",
         dataset,
         true,true,false);
        
         
      ChartPanel chartPanel = new ChartPanel( lineChart );
      chartPanel.setMouseZoomable(true, false);
      chartPanel.setMouseWheelEnabled(true);
      chartPanel.setToolTipText("Use mouse point zooom and drag mouse point to normal state.");
      /*chartPanel.setHorizontalAxisTrace(true);
      chartPanel.setVerticalAxisTrace(true);*/
      chartPanel.setPreferredSize( new java.awt.Dimension( Frame.jpanel10.getWidth()-10,Frame.jpanel10.getHeight()-10) );
      this.add(chartPanel);
      this.setSize(Frame.jpanel10.getWidth(),Frame.jpanel10.getHeight());
      this.setToolTipText("Use mouse point zooom and drag mouse point to normal state.");
      this.setBackground(Color.white);
      this.setBorder(new MatteBorder(1, 1, 1, 1, new Color(153, 153, 153)));
      this.setVisible(true);
    }
    
   
}