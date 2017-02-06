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
    JLabel chartLabel=new JLabel("Chart Type: ");
    JLabel colorLabel=new JLabel("Color Scheme: ");
    JLabel dataLabel=new JLabel("Data Labels: ");
    
   
    
    int data[]={1,2,3};
    String series[]={"a","b","c"};
    /**
     * Initialization method that will be called after the applet is loaded into
     * the browser.
     */
    public void init() {
        // TODO start asynchronous download of heavy resources
        JPanel inputBar=new JPanel();        
        inputBar.add(chartLabel);        
        inputBar.add(colorLabel);   
        inputBar.add(dataLabel);  
        
        List list =new List(3);
        list.add("a");
        list.add("b");
        list.add("c");
        
       
        
        setLayout(new BorderLayout());        
        add(inputBar,BorderLayout.NORTH);      
        add(list);
    }

    // TODO overwrite start(), stop() and destroy() methods
}
