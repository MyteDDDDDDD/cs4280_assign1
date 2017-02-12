package cs4280_assign1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author YUANEL
 */
public class Assignment1 extends JApplet {


    /**
     * Initialization method that will be called after the applet is loaded into
     * the browser.
     */
    public void init() {
        // TODO start asynchronous download of heavy resources
        JPanel inputBar=new JPanel();
        
        JLabel ChartType= new JLabel("Chart Type： ");
        inputBar.add(ChartType);
        
        JMenuBar chartMenuBar=new JMenuBar();//create chart type menu
        JMenu chartMenu=new JMenu("Line Chart");
        JMenuItem lineC=new JMenuItem("Line Chart");
        JMenuItem barC1=new JMenuItem("Bar Chart (Horizontal)");  
        JMenuItem barC2=new JMenuItem("Bar Chart (Vertical)");  
        chartMenu.add(lineC);
        chartMenu.add(barC1);
        chartMenu.add(barC2);
        chartMenuBar.add(chartMenu);
        inputBar.add(chartMenuBar);
        
        JLabel ColorScheme=new JLabel("Color Scheme： ");
        inputBar.add(ColorScheme);
       
        JMenuBar colorMenuBar=new JMenuBar();//create color type menu
        JMenu colorMenu=new JMenu("Rainbow");
        JMenuItem grayScale=new JMenuItem("Gray Scale");
        JMenuItem highContrast = new JMenuItem("High Contrast");
        JMenuItem rainbow=new JMenuItem("Rainbow");
        JMenuItem winter=new JMenuItem("Winter");
        colorMenu.add(grayScale);
        colorMenu.add(highContrast);
        colorMenu.add(rainbow);
        colorMenu.add(winter);
        colorMenuBar.add(colorMenu);
        inputBar.add(colorMenuBar);
        
        JLabel dataL=new JLabel("Data Label");
        inputBar.add(dataL);
        
        JCheckBox dataCB=new JCheckBox("Show");
        inputBar.add(dataCB);
       
        JLabel chartTitle=new JLabel("Chart Title");
        inputBar.add(chartTitle);
        
        JCheckBox chartCB=new JCheckBox("Show");
        inputBar.add(chartCB);
        
        JLabel axisTitle=new JLabel("Axis Title");
        inputBar.add(axisTitle);
        
        JCheckBox axisCB=new JCheckBox("Show");
        inputBar.add(axisCB);
        
        inputBar.setSize(30, 8);
        
        setLayout(new BorderLayout());        
        add(inputBar,BorderLayout.NORTH); 

    }

    // TODO overwrite start(), stop() and destroy() methods
}                                                                                                
