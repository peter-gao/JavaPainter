package Painter;

import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.util.ArrayList; 


public class Page extends JPanel {
     
    MainWindows parent = null;
    Point lp , r1;
    Rectangle r2;
    ArrayList<Line> lines = null;

     PRectangle f;

   Page(MainWindows p)
	{
            parent = p;
            lp = new Point(-1,-1);
            r2 = new Rectangle(-1,-1,-1,-1);
            lines = new ArrayList<Line>();

            this.setBackground(Color.white);
		 //設定畫布顏色為黃色
            this.setLayout(null);
            
            this.addMouseListener(  //畫直線
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
                                lines.add(new Line(lp , e.getPoint() , g.getColor()));       
                            }
                            lp = e.getPoint();
                        }
                    }
                }
            );
            
          this.addMouseListener(    //畫筆
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
          
          this.addMouseListener(       //畫筆
                new MouseAdapter()
                {
                    public void mouseReleased (MouseEvent e)
                    {
                        if(parent.parent.status == Status.drawPen)
                        {
                            //Do Nothing!
                        }
                    }
                }
            );
          
          this.addMouseMotionListener(  //畫筆+滑鼠位置
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
                             
                             lines.add(new Line(lp , e.getPoint() , g.getColor()));
                        }
                        lp = e.getPoint();
                    parent.statusbar.label.setText(String.format("Mouse At (" + e.getX() +" , "+ e.getY() + ")"));
                    }
                }
            }
         );
          
          this.addMouseListener(    //畫矩形
                new MouseAdapter()
                {
                    public void mousePressed (MouseEvent e)
                    {
                        if(parent.parent.status == Status.drawrectangle)
                        {
                            r1 = e.getPoint();
                        }
                    }
                }
            );
            
           this.addMouseMotionListener(     //畫矩形+滑鼠位置
            new MouseAdapter()
            {
                public void mouseDragged(MouseEvent e)
                {
                        
                        if(parent.parent.status == Status.drawrectangle)
                    {
                             java.awt.Graphics g = Page.this.getGraphics();
                             //取畫筆
                             g.setPaintMode();  
                             paint(g);
                             if(r2.x != -1)
                             {
                                 int x=r2.x<e.getX()?r2.x:e.getX();
                                 int y=r2.y<e.getY()?r2.y:e.getY();
                                 
                                 if(r2.y > e.getY() && e.getX() > r2.x) //一
                                 {
                                   g.drawRect(x, y, e.getX()-r1.x , Math.abs(r1.y-e.getY()));
                                 }
                                else if(r2.x > e.getX() && r2.y > e.getY())//二
                                 {
                                     g.drawRect(x, y,Math.abs(r1.x-e.getX()) , Math.abs(r1.y-e.getY()));
                                 }
                                else if(r2.x > e.getX() && e.getY() > r2.y)//三
                                 {
                                     g.drawRect(x, y, Math.abs(r1.x-e.getX()) , e.getY()-r1.y);
                                 }
                                 else//四
                                 {
                                   g.drawRect(x, y, r2.width, r2.height);
                                 }
                                
                             }
                             r2.x=r1.x;
                             r2.y=r1.y;
                             r2.width = Math.abs(e.getX()-r1.x);
                             r2.height = Math.abs(e.getY()-r1.y);



                       parent.statusbar.label.setText(String.format("Mouse At (" + e.getX() +" , "+ e.getY() + ")"));
                    }
                }
            }
         ); 
           
              this.addMouseListener(    //畫矩形
                new MouseAdapter()
                {
                    public void mouseReleased (MouseEvent e)
                    {
                        if(parent.parent.status == Status.drawrectangle)
                        {
                             f = new PRectangle(Page.this.parent);

                           if(r1.y > e.getY() && r1.x < e.getX() ) //一
                           {
                               r1.y = e.getY();
                           }
                           else if(r1.y > e.getY() && r1.x > e.getX())//二
                           {
                               r1.x = e.getX();
                               r1.y = e.getY();
                           }
                           else if (r1.x>e.getX() && r1.y < e.getY())//三
                           {
                               r1.x=e.getX();
                           }
                            
                            f.setLocation(r1.x,r1.y);
                            f.setSize(r2.getSize());
                            repaint();
                            Page.this.add(f);
                            System.out.println("width:"+(r2.getSize().width)+"height:"+(r2.getSize().height));
                        }
                    }
                }
            );
            
              
          this.addMouseListener(    //橡皮擦
                new MouseAdapter()
                {
                    public void mousePressed (MouseEvent e)
                    {
                        if(parent.parent.status == Status.eraser)
                        {
                               lp = new Point(-1,-1);
                        }
                    }
                }
            );
          
          this.addMouseListener(       //橡皮擦
                new MouseAdapter()
                {
                    public void mouseReleased (MouseEvent e)
                    {
                        if(parent.parent.status == Status.eraser)
                        {
                            //Do Nothing!
                        }
                    }
                }
            );
          
          this.addMouseMotionListener(  //橡皮擦+滑鼠位置
            new MouseAdapter()
            {
                public void mouseDragged(MouseEvent e)
                {
                    if(parent.parent.status == Status.eraser)
                    {
                        if (lp.x != -1){
                             
                             java.awt.Graphics g = Page.this.getGraphics();
                             //取畫筆
                             g.setPaintMode();  
                             g.setColor(Color.WHITE);
                             g.drawLine(lp.x,lp.y,e.getX(),e.getY());
                             
                             lines.add(new Line(lp , e.getPoint() , g.getColor()));
                        }
                        lp = e.getPoint();
                 parent.statusbar.label.setText(String.format("Mouse At (" + e.getX() +" , "+ e.getY() + ")"));
                    }
                }
            }
         );
          
           this.addMouseMotionListener(  //滑鼠位置
            new MouseAdapter()
            {
                public void mouseMoved(MouseEvent e)
                {
                 parent.statusbar.label.setText(String.format("Mouse At (" + e.getX() +" , "+ e.getY() + ")"));
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
            g.setColor(temp.color);
        }
    }
}


