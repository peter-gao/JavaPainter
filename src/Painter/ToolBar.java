package Painter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*; //滑鼠事件監聽器
import java.io.*;
import javax.imageio.*;


public class ToolBar extends JPanel{
    
    JToolBar toolbarline, toolbarpic , toolbar;
    Color c ;
    MainWindows parent = null;
    JToggleButton stopDrawBtn , drawRectangle ,exitBtn , drawLineBtn , drawPen , eraserBtn;
    JButton setColor;

    ToolBar(MainWindows p)
    {   
        parent = p;
        this.setBackground(Color.black);
        //設定工具欄背景顏色 : 紅
        toolbarline =  new JToolBar("線條");
        toolbarpic = new JToolBar("圖形");
        toolbar = new JToolBar("工具");
        
        exitBtn = new JToggleButton("離開",new ImageIcon("img/tool2.gif"));
        
        eraserBtn = new JToggleButton("橡皮擦",new ImageIcon("img/tool6.gif"));
        
        drawLineBtn= new JToggleButton("直線",new ImageIcon("img/tool1.gif"));
    
        stopDrawBtn = new JToggleButton("停止畫畫",new ImageIcon("img/tool4.gif"));
 
        drawPen = new JToggleButton("畫筆",new ImageIcon("img/tool3.gif"));

        drawRectangle = new JToggleButton("矩形",new ImageIcon("img/tool5.gif"));
        
        setColor = new JButton("顏色選取");
        
        stopDrawBtn.setEnabled(false);
           
        toolbarline.add(drawLineBtn);
        toolbarline.add(drawPen);
        this.add(toolbarline);

        toolbarpic.add(drawRectangle);
        this.add(toolbarpic);
        
        toolbar.add(stopDrawBtn);
        toolbar.add(setColor);
        toolbar.add(eraserBtn);
        this.add(toolbar);
        
        add(exitBtn,BorderLayout.WEST);
        
        drawLineBtn.addMouseListener(
            new MouseAdapter()
            {
                public void mouseClicked(MouseEvent e)
                {
                    parent.parent.status = Status.drawLine;
                    ToolBar.this.drawRectangle.setEnabled(false);
                    ToolBar.this.drawPen.setEnabled(false);
                    ToolBar.this.drawLineBtn.setEnabled(false);
                    ToolBar.this.stopDrawBtn.setEnabled(true);
                }
            
            }
         );
        
        stopDrawBtn.addMouseListener(
            new MouseAdapter()
            {
                public void mouseClicked(MouseEvent e)
                {
                    parent.parent.status = Status.idle;
                    ToolBar.this.drawRectangle.setEnabled(true);
                    ToolBar.this.drawPen.setEnabled(true);
                    ToolBar.this.drawLineBtn.setEnabled(true);
                    ToolBar.this.stopDrawBtn.setEnabled(false);
                    ToolBar.this.parent.page.lp = new Point(-1,-1);
                }
            
            }
         );
        
        exitBtn.addMouseListener(
            new MouseAdapter()
            {
		public void mouseClicked(MouseEvent e)
		{
                    System.exit(0);
		}
            }
	);
        
        drawPen.addMouseListener(
            new MouseAdapter()
            {
                public void mouseClicked(MouseEvent e)
                {
                    parent.parent.status = Status.drawPen ;
                    ToolBar.this.drawRectangle.setEnabled(false);
                    ToolBar.this.drawPen.setEnabled(false);
                    ToolBar.this.drawLineBtn.setEnabled(false);
                    ToolBar.this.stopDrawBtn.setEnabled(true);
                }
            }
         );
        //在按鈕-->""exitBtn""下 加入滑鼠監聽 設定只要按了 "exitBtn" 就會跳出 
 
          setColor.addMouseListener(
            new MouseAdapter()
            {
                public void mouseClicked(MouseEvent e)
                {
                      c = JColorChooser.showDialog(null,"Choose A Color", setColor.getBackground());
                     if (c != null) 
                     {setColor.setBackground(c);}
                }
            }
         ); 
          
           drawRectangle.addMouseListener(
            new MouseAdapter()
            {
                public void mouseClicked(MouseEvent e)
                {
                    parent.parent.status = Status.drawrectangle ;
                    ToolBar.this.drawRectangle.setEnabled(false);
                    ToolBar.this.drawPen.setEnabled(false);
                    ToolBar.this.drawLineBtn.setEnabled(false);
                    ToolBar.this.stopDrawBtn.setEnabled(true);
                }
            }
         );
 
          eraserBtn.addMouseListener(
            new MouseAdapter()
            {
                public void mouseClicked(MouseEvent e)
                {
                    parent.parent.status = Status.eraser ;
                }
            }
         );
    }
         
}
