package cs4280_assign1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



/**
 *
 * @author YUANEL
 */
public class index extends JApplet implements ActionListener {
   
    Dimension size = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    JLabel ChartType= new JLabel("Chart Type ");
    JMenuBar chartMenuBar=new JMenuBar();//create chart type menu
    JMenu chartMenu=new JMenu("Please Select");
    JMenuItem lineC=new JMenuItem("Line Chart");
    JMenuItem barC1=new JMenuItem("Bar Chart (Horizontal)");  
    JMenuItem barC2=new JMenuItem("Bar Chart (Vertical)");  
    
    JLabel ColorScheme=new JLabel("Color Scheme ");
    JMenuBar colorMenuBar=new JMenuBar();//create color type menu
    JMenu colorMenu=new JMenu("Please Select");
    JMenuItem grayScale=new JMenuItem("Gray Scale");
    JMenuItem highContrast = new JMenuItem("High Contrast");
    JMenuItem rainbow=new JMenuItem("Rainbow");
    JMenuItem winter=new JMenuItem("Winter");
    
    JLabel dataL=new JLabel("Data Label");
    JCheckBox dataCB=new JCheckBox("Show");
    
    JLabel chartTitle=new JLabel("Chart Title");
    JCheckBox chartCB=new JCheckBox("Show");
    
    JLabel axisTitle=new JLabel("Axis Title");
    JCheckBox axisCB=new JCheckBox("Show");
    
    JLabel legend=new JLabel("Legend");
    JCheckBox legendCB=new JCheckBox("Show");

    int type=0;
    Color[] colorS=new Color[16];
    final int dataN=8;
    final int seriesN=5;
    String title="A Random Chart Over Some Noise Data";
    String head="series";
    String value="data";
    int data[][]=new int[dataN][seriesN];
    int half=(int)size.getWidth()/2;
    int series[]=new int [seriesN];
    int showChartTitle=0;
    int showAxisTitle=0;
    int showDataLabel=0;
    int showLegend=0;
    int w=(int)size.getWidth();
    int h=(int)size.getHeight();
     String sshowChartTitle;
    /**
     * Initialization method that will be called after the applet is loaded into
     * the browser.
     */
    public void init() {
        this.setSize(2000,1200);
        sshowChartTitle=getParameter("ShowChartTitle");
        
        colorS[0]= new Color(0, 0, 0); 
        colorS[15]=new Color(255, 255, 255);
        colorS[1]=new Color(0, 0, 255);
        colorS[2]=new Color(0, 255, 0);
        colorS[3]=new Color(0, 255, 255);
        colorS[4]=new Color(255, 0, 0);
        colorS[5]=new Color(255, 0, 255);
        colorS[6]=new Color(255, 255, 0);
        colorS[7]=new Color(192, 192, 192);
        colorS[8]=new Color(128, 128, 255);
        colorS[9]=new Color(128, 255, 128);
        colorS[10]=new Color(128, 255, 255);
        colorS[11]=new Color(255, 128, 128);
        colorS[12]=new Color(255, 128, 255);
        colorS[13]=new Color(255, 255, 128);
        colorS[14]=new Color(128, 128, 128);
        
        for (int i=0;i<seriesN;i++){
               series[i]=w/4+i*half/seriesN;
        }
        
        int data1[]={289,363,423,578,680,61,431,796,158,773,776,202,536,531,913,646,
        726,661,86,54,394,236,738,906,725,883,951,865,504,851,382,193,480,625,767,711,359,703,524,841};
       
        for(int i=0;i<dataN;i++){
            for(int j=0;j<seriesN;j++){
                data[i][j]=data1[(i+1)*(j+1)-1];
            }
        }
        // TODO start asynchronous download of heavy resources
        JPanel inputBar=new JPanel();
        inputBar.setLayout(new FlowLayout());
        inputBar.add(ChartType);
        lineC.addActionListener(this);
        chartMenu.add(lineC);
        barC1.addActionListener(this);
        chartMenu.add(barC1);
        barC2.addActionListener(this);
        chartMenu.add(barC2);
        chartMenuBar.add(chartMenu);
        inputBar.add(chartMenuBar);
        inputBar.add(ColorScheme);
        grayScale.addActionListener(this);
        colorMenu.add(grayScale);
        highContrast.addActionListener(this);
        colorMenu.add(highContrast);
        rainbow.addActionListener(this);
        colorMenu.add(rainbow);
        winter.addActionListener(this);
        colorMenu.add(winter);
        colorMenuBar.add(colorMenu);
        inputBar.add(colorMenuBar);
        inputBar.add(dataL);
        inputBar.add(dataCB);
        dataCB.addActionListener(this);
        inputBar.add(chartTitle);
        inputBar.add(chartCB);
        chartCB.addActionListener(this);
        inputBar.add(axisTitle);
        inputBar.add(axisCB);
        inputBar.add(legend);
        legendCB.addActionListener(this);
        inputBar.add(legendCB);
        axisCB.addActionListener(this);
        inputBar.setSize(2200,1200 );

        setLayout(new BorderLayout());        
        add(inputBar,BorderLayout.NORTH); 

    }
    
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g1=(Graphics2D)g;
       //g1.drawString(sshowChartTitle, w/2, h/2);
        Font f1=new Font("Verdana",Font.BOLD,25);
        if(type==1){// line chart
            
            g1.setColor(colorS[0]);
            g1.setFont(f1);
            if(showChartTitle==1)
                g1.drawString(title,w/2-250,h/2-450);
            if(showAxisTitle==1){
                g1.setFont(new Font("Verdana",Font.BOLD,15));
                g1.drawString(head,w/2-100,h*3/4+40);
                g1.drawString(value,w/4-150,h/2);
            }
            if(showAxisTitle==1){
                    g1.setColor(colorS[0]);
                    g1.setFont(new Font("Verdana",Font.BOLD,15));
                 for(int j=1;j<seriesN+1;j++){
                        g1.drawString("| series"+j,series[j-1]-1, 3*h/4+10);
                        }
                }
            
      
            if(showDataLabel==1){
                for(int i=0;i<dataN;i++){
                    for(int j=1;j<seriesN+1;j++){
                        g1.setFont(new Font("Verdana",Font.BOLD,15));
                        String num=Integer.toString(data[i][j-1]);
                    
                        g1.drawString(num,series[j-1], h*2/3-data[i][j-1]/2);
                    }
                }
                        
            }
            if(showLegend==1){
            for(int i=1;i<dataN+1;i++){
                g1.setColor(colorS[i]);
                    for(int j=1;j<seriesN+1;j++){
                        g1.setFont(new Font("Verdana",Font.BOLD,15));
                        g1.drawLine(3*w/4, h/2+i*h/(2*dataN)-400,3*w/4+50, h/2+i*h/(2*dataN)-400);
                        g1.drawString("data"+i, w*3/4, h/2+i*h/(2*dataN)-405);
                    }
            }
            }
                    
                    
            g1.drawLine(w/4,h*3/4-10,3*w/4,h*3/4-10);

            
            for(int i=1;i<dataN+1;i++){
                 g1.setColor(colorS[i]);
                 g1.setStroke(new BasicStroke(4.0f));
                 
                for(int j=1;j<seriesN;j++){
                    g1.drawLine(series[j-1],h*2/3-data[i-1][j-1]/2,series[j],h*2/3-data[i-1][j]/2);
                    
                   
                    
       
                }
               
                
            }
          

           
        }
        else if(type==2){
            g1.setColor(colorS[0]);
            g1.setFont(f1);
            if(showChartTitle==1)
                g1.drawString(title,w/2-250,h/2-450);
            
            
            if(showLegend==1){
                g1.setFont(new Font("Verdana",Font.BOLD,15));
                for(int i=1;i<dataN+1;i++){
                    g1.setColor(colorS[i]);
                    g1.drawLine(3*w/4, h/2+i*h/(2*dataN)-400,3*w/4+50, h/2+i*h/(2*dataN)-400);
                    g1.drawString("data"+i, w*3/4, h/2+i*h/(2*dataN)-405);
                    }
            
           }
            
            if(showAxisTitle==1){
                g1.setFont(new Font("Verdana",Font.BOLD,15));
                  g1.setColor(colorS[0]);
                g1.drawString(value,w/2-100,h*3/4+20);
                g1.drawString(head,w/4-200,h/2);
              
                
                 for(int j=1;j<seriesN+1;j++){
                        g1.drawString("series"+j+"-",w/4-100,h/4+(j-1)*h/(2*seriesN)+10);
                        }
                }
           
            g1.drawLine(w/4,h*3/4-10,3*w/4,h*3/4-10);

            g1.setStroke(new BasicStroke(4.0f));
// 
            for(int i=0;i<seriesN;i++){

                for(int j=0;j<dataN;j++){
                   g1.setColor(colorS[j+1]);
                   g1.drawRect(w/4,h/4+i*h/(2*seriesN)+50/dataN*j,data[j][i],1);
                   if(showDataLabel==1){
                       g1.setFont(new Font("Verdana",Font.BOLD,10));
                        String num=Integer.toString(data[j][i]);
                        g1.drawString(num,w/4+data[j][i]+3,h/4+i*h/(2*seriesN)+50/dataN*j);
                    }
                   
                }
                }
           }
        else if(type==3){
             g1.setColor(colorS[0]);
            g1.setFont(f1);
            if(showChartTitle==1)
                g1.drawString(title,w/2-250,h/2-450);
            
            
            if(showLegend==1){
                g1.setFont(new Font("Verdana",Font.BOLD,15));
                for(int i=1;i<dataN+1;i++){
                    g1.setColor(colorS[i]);
                    g1.drawLine(3*w/4, h/2+i*h/(2*dataN)-400,3*w/4+50, h/2+i*h/(2*dataN)-400);
                    g1.drawString("data"+i, w*3/4, h/2+i*h/(2*dataN)-405);
                    }
            
           }
            
            if(showAxisTitle==1){
                g1.setFont(new Font("Verdana",Font.BOLD,15));
                  g1.setColor(colorS[0]);
                g1.drawString(head,w/2-100,h*3/4+20);
                g1.drawString(value,w/4-200,h/2);
              
                
                 for(int j=1;j<seriesN+1;j++){
                        g1.drawString("| series"+j,series[j-1]-1, 3*h/4+10);
                        }
                }
           
            g1.drawLine(w/4,h*3/4-10,3*w/4,h*3/4-10);

            g1.setStroke(new BasicStroke(4.0f));
// 
            for(int i=0;i<seriesN;i++){

                for(int j=0;j<dataN;j++){
                   g1.setColor(colorS[j+1]);
                   g1.drawRect(w/4+i*w/(2*seriesN)+80/dataN*j,3*h/4-data[j][i]/2-10,1,data[j][i]/2);
                   if(showDataLabel==1){
                       g1.setFont(new Font("Verdana",Font.BOLD,10));
                        String num=Integer.toString(data[j][i]);
                        g1.drawString(num,w/4+i*w/(2*seriesN)+80/dataN*j,3*h/4-data[j][i]/2-10);
                    }
                   
                }
                }
        }
         
           
    }

    // TODO overwrite start(), stop() and destroy() methods

    @Override
    public void actionPerformed(ActionEvent e) {

    if(e.getSource()==lineC)
        type=1;
    else if (e.getSource()==barC1)
        type=2;
    else if (e.getSource()==barC2)
        type=3;
   
    if(e.getSource()==grayScale){
    colorS[1]=new Color(215, 215, 215);
    colorS[2]=new Color(210, 210, 210);
    colorS[3]=new Color(204, 204, 204);
    colorS[4]=new Color(179, 179, 179);
    colorS[5]=new Color(166, 166, 166);
    colorS[6]=new Color(153, 153, 153);
    colorS[7]=new Color(192, 192, 192);
    colorS[8]=new Color(115, 115, 115);
    colorS[9]=new Color(89, 89, 89);
    colorS[10]=new Color(77, 77, 77);
    colorS[11]=new Color(64, 64, 64);
    colorS[12]=new Color(51, 51, 51);
    colorS[13]=new Color(38, 38, 38);
    colorS[14]=new Color(0, 0, 0); 
    }
    else if(e.getSource()==highContrast){
    colorS[1]=new Color(0, 0, 255);
    colorS[2]=new Color(0, 255, 0);
    colorS[3]=new Color(0, 255, 255);
    colorS[4]=new Color(255, 0, 0);
    colorS[5]=new Color(255, 0, 255);
    colorS[6]=new Color(255, 255, 0);
    colorS[7]=new Color(192, 192, 192);
    colorS[8]=new Color(128, 128, 255);
    colorS[9]=new Color(128, 255, 128);
    colorS[10]=new Color(128, 255, 255);
    colorS[11]=new Color(255, 128, 128);
    colorS[12]=new Color(255, 128, 255);
    colorS[13]=new Color(255, 255, 128);
    colorS[14]=new Color(128, 128, 128);
    }
    else if(e.getSource()==rainbow){
    colorS[1]=new Color(255, 153, 255);
    colorS[2]=new Color(153, 255, 153);
    colorS[3]=new Color(255, 255, 204);
    colorS[4]=new Color(51, 153, 255);
    colorS[5]=new Color(0, 255, 255);
    colorS[6]=new Color(55, 255, 153);
    colorS[7]=new Color(255, 153, 153);
    colorS[8]=new Color(153, 153, 255);
    colorS[9]=new Color(255, 255, 153);
    colorS[10]=new Color(204, 255, 204);
    colorS[11]=new Color(102, 204, 255);
    colorS[12]=new Color(102, 153, 255);
    colorS[13]=new Color(255, 102, 102);
    colorS[14]=new Color(0, 255, 204);
    }
    else if(e.getSource()==winter){
    colorS[1]=new Color(210, 230, 255);
    colorS[2]=new Color(204, 226, 255);
    colorS[3]=new Color(179, 212, 255);
    colorS[4]=new Color(153, 197, 255);
    colorS[5]=new Color(128, 183, 255);
    colorS[6]=new Color(102, 168, 255);
    colorS[7]=new Color(77, 154, 255);
    colorS[8]=new Color(51, 139, 255);
    colorS[9]=new Color(26, 125, 255);
    colorS[10]=new Color(0, 110, 255);
    colorS[11]=new Color(0, 77, 179);
    colorS[12]=new Color(0, 44, 102);
    colorS[13]=new Color(0, 22, 51);
    colorS[14]=new Color(0, 0, 0);
    }
    
    if(e.getSource()==chartCB){
        if(showChartTitle==1)
            showChartTitle=0;
        else if(showChartTitle==0)
            showChartTitle=1;
    }
        
    else if(e.getSource()==axisCB){
        if(showAxisTitle==1)
            showAxisTitle=0;
        else if(showAxisTitle==0)
            showAxisTitle=1;
    }
    else if(e.getSource()==dataCB){
        if(showDataLabel==0)
        showDataLabel=1;
        else if(showDataLabel==1)
        showDataLabel=0;
    }
    else if(e.getSource()==legendCB){
        if(showLegend==1)
            showLegend=0;
        else if(showLegend==0)
            showLegend=1;
    }
        repaint();
    }
}                                                                                                
