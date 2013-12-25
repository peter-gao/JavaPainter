package Painter;

import java.awt.Color;
import java.awt.Graphics;

public class PRectangle extends PObject{
     //MainWindows parent = null;
   PRectangle(MainWindows p)
    {
        super(p);
    }
           
    
     public void paintComponent(Graphics g)
     {
           java.awt.Dimension d  = PRectangle.this.getSize();
           java.awt.Point p = PRectangle.this.getLocation();
               g.setColor(parent.tbar.c);
               g.drawRect(0, 0, d.width-1, d.height-1);
              
     }
    
}
