package cs4280_assign1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.*;
import java.awt.*;
import static java.awt.Color.black;
import static java.awt.Color.blue;
import static java.awt.Color.green;
import static java.awt.Color.pink;
import static java.awt.Color.red;
import static java.awt.Color.yellow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author YUANEL
 */
public class Assignment1 extends JApplet implements ActionListener {
   
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
    
    int data1[]={289,363,423,578,680,61,431,796};
    int data2[]={158,773,776,202,536,531,913,646};
    int data3[]={726,661,86,54,394,236,738,906};
    int data4[]={725,883,951,865,504,851,382,193};
    int data5[]={480,625,767,711,359,703,524,841};
    int half=(int)size.getWidth()/2;
    int series[]={half-400,half-300,half-200,half-100,half,half+100,half+200,half+300};
    
     int paintPoint=0;
     int type=0;

     
    /**
     * Initialization method that will be called after the applet is loaded into
     * the browser.
     */
    public void init() {
        // TODO start asynchronous download of heavy resources
        JPanel inputBar=new JPanel();
        inputBar.setLayout(new FlowLayout());
        inputBar.add(ChartType);
        lineC.addActionListener(this);
        chartMenu.add(lineC);
        chartMenu.add(barC1);
        chartMenu.add(barC2);
        chartMenuBar.add(chartMenu);
        inputBar.add(chartMenuBar);
        inputBar.add(ColorScheme);
        colorMenu.add(grayScale);
        colorMenu.add(highContrast);
        colorMenu.add(rainbow);
        colorMenu.add(winter);
        colorMenuBar.add(colorMenu);
        inputBar.add(colorMenuBar);
        inputBar.add(dataL);
        inputBar.add(dataCB);
        dataCB.addActionListener(this);
        inputBar.add(chartTitle);
        inputBar.add(chartCB);
        inputBar.add(axisTitle);
        inputBar.add(axisCB);
        inputBar.setSize(30, 8);

        setLayout(new BorderLayout());        
        add(inputBar,BorderLayout.NORTH); 
        
        

    }
    
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g1=(Graphics2D)g;
        int w=(int)size.getWidth();
        int h=(int)size.getHeight();
        int f=(int)size.getHeight()/5;
        Font f1=new Font("Verdana",Font.BOLD,25);
        if(type==1){
            
            g1.setColor(black);
            g1.setFont(f1);
            g1.drawString("A Random Chart Over Some Noise Data",w/2-250,h/2-450);
            g1.drawString("Series",w/2-100,h*3/4+20);
    
            g1.drawLine(half-400,h*3/4-10,half+300,h*3/4-10);
//            for(int i=0;i<series.length;i++){
//                g1.drawString("Series"+, TOP_ALIGNMENT, TOP_ALIGNMENT);
//            }
            g1.setStroke(new BasicStroke(5.0f));
            g1.setColor(red);
         
            for (int i=1;i<8;i++){            
            g1.drawLine(series[i-1],h*2/3-data1[i-1]/2,series[i],h*2/3-data1[i]/2);
            String num=Integer.toString(data1[i]);
            g1.drawString(num,series[i-1], h*2/3-data1[i-1]/2);
            } 
            g1.setColor(yellow);
            for (int i=1;i<8;i++){            
            g1.drawLine(series[i-1],h*2/3-data2[i-1]/2,series[i],h*2/3-data2[i]/2);        
            String num=Integer.toString(data2[i]);
            g1.drawString(num,series[i-1], h*2/3-data2[i-1]/2);
            } 
            g1.setColor(blue);
            for (int i=1;i<8;i++){            
            g1.drawLine(series[i-1],h*2/3-data3[i-1]/2,series[i],h*2/3-data3[i]/2);        
            String num=Integer.toString(data3[i]);
            g1.drawString(num,series[i-1], h*2/3-data3[i-1]/2);
            } 
            g1.setColor(green);
            for (int i=1;i<8;i++){            
            g1.drawLine(series[i-1],h*2/3-data4[i-1]/2,series[i],h*2/3-data4[i]/2);        
            String num=Integer.toString(data4[i]);
            g1.drawString(num,series[i-1], h*2/3-data4[i-1]/2);
            } 
            g1.setColor(pink);
            for (int i=1;i<8;i++){            
            g1.drawLine(series[i-1],h*2/3-data5[i-1]/2,series[i],h*2/3-data5[i]/2);        
            String num=Integer.toString(data5[i]);
            g1.drawString(num,series[i-1], h*2/3-data5[i-1]/2);
            } 
            
           
//            g.drawLine()
        }
        else if(type==2){
            
        }
        else if(type==3){
            
        };
         
           
    }

    // TODO overwrite start(), stop() and destroy() methods

    @Override
    public void actionPerformed(ActionEvent e) {

    if(e.getSource()==lineC)
        type=1;
   
        repaint();
    }
}                                                                                                
