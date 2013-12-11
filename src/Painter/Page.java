
package Painter;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList; 



public class Page extends JPanel {
    
   // ToolBar color ; 
    MainWindows parent = null;
    Point lp ;
    ArrayList<Line> lines = null;
    
    Page(MainWindows p/*, ToolBar c*/)
	{
            parent = p;
           // color = c;
            lp = new Point(-1,-1);
            lines =new ArrayList<Line>();
            
            this.setBackground(Color.yellow);
		 //設定畫布顏色為黃色
            this.setLayout(null);
            
            this.addMouseListener(
                new MouseAdapter()
                {
                    public void mousePressed (MouseEvent e)
                    {
                        if(parent.parent.status == Status.drawPen)
                        {
                               lp = new Point(-1,-1);
                        }
                    }
                }
            );
            
            this.addMouseListener(
                new MouseAdapter()
                {
                    public void mouseReleased (MouseEvent e)
                    {
                        if(parent.parent.status == Status.drawPen)
                        {
                          
                        }
                    }
                }
            );
            
            
            this.addMouseListener(
                new MouseAdapter()
                {
                    public void mouseClicked (MouseEvent e)
                    {
                        if(parent.parent.status == Status.drawLine)
                        {
                            if (lp.x != -1){
                                java.awt.Graphics g = Page.this.getGraphics();
                                //取畫筆
                                g.setPaintMode();  
                                g.setColor(parent.tbar.c);
                                g.drawLine(lp.x,lp.y,e.getX(),e.getY());
                                lines.add(new Line(lp , e.getPoint()));
                            }
                            lp = e.getPoint();
                            
                        }
                    }
                }
            );
            
            this.addMouseMotionListener(
            new MouseAdapter()
            {
                public void mouseDragged(MouseEvent e)
                {
                    if(parent.parent.status == Status.drawPen)
                    {
                        if (lp.x != -1){
                             
                             java.awt.Graphics g = Page.this.getGraphics();
                             //取畫筆
                             g.setPaintMode();  
                             g.setColor(parent.tbar.c);
                             g.drawLine(lp.x,lp.y,e.getX(),e.getY());
                             
                             lines.add(new Line(lp , e.getPoint()));
                        }
                        lp = e.getPoint();
                    }
                }
            }
         );
            
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Line temp;
        
        for(int i =0 ; i < lines.size() ; i++){
            temp = lines.get(i);
            g.drawLine(temp.start.x, temp.start.y, temp.end.x, temp.end.y);
        }
    }
}
