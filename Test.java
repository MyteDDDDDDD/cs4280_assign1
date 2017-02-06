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
public class Test extends JApplet implements ActionListener {
    JLabel xLabel=new JLabel("x");
    JLabel yLabel=new JLabel("y");
    JTextField xValue=new JTextField(5);
    JTextField yValue=new JTextField(5);
    JButton addButton=new JButton("Add");
    JButton resetButton=new JButton("Reset");
    final int maxPoint=50;
    int pointCount;
    int xData[]=new int[maxPoint];
    int yData[]=new int[maxPoint];
    
    public void init() {        // TODO start asynchronous download of heavy resources        
        JPanel inputBar=new JPanel();        
        inputBar.setLayout(new FlowLayout());  // use flow layout to arrangement GUI objects        
        inputBar.add(xLabel);        
        inputBar.add(xValue);        
        inputBar.add(yLabel);        
        inputBar.add(yValue);       
        inputBar.add(addButton);        
        inputBar.add(resetButton);        
        setLayout(new BorderLayout());        
        add(inputBar,BorderLayout.NORTH);        
        addButton.addActionListener(this);       
        resetButton.addActionListener(this);        
        pointCount=0;
    }
    @Override
    public void actionPerformed(ActionEvent e){        
        if (e.getSource()==addButton){            
            if (pointCount>= maxPoint)               
                pointCount=0;                
        xData[pointCount]=Integer.parseInt(xValue.getText());                
        yData[pointCount]=Integer.parseInt(yValue.getText());                
        xValue.setText("");                
        yValue.setText("");                
        pointCount++;        
        }
        else if (e.getSource()==resetButton)           
            pointCount=0;        
        repaint();    
    }
        
    public void paint(Graphics g){        
        super.paint(g); // call the super class to draw other GUI objects        
        for (int i=1;i<pointCount;i++){            
            g.drawLine(xData[i-1],yData[i-1],xData[i],yData[i]);        
        }    
    }
    
}
