
package Painter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*; //滑鼠事件監聽器


public class ToolBar extends JPanel{
    
    Color c ;
    MainWindows parent = null;
    JButton stopDrawBtn;
    JButton drawLineBtn;
    JButton exitBtn;
    JButton drawPen;
    final JButton setColor;
   
    ToolBar(MainWindows p)
    {   
        parent = p;
        this.setBackground(Color.red);
        //設定工具欄背景顏色 : 紅
       
        exitBtn = new JButton("EXIT");
        drawLineBtn = new JButton("Draw Lines");
        stopDrawBtn = new JButton("Stop Draw");
        drawPen = new JButton("pen");
        //新增按鈕
        
        setColor = new JButton("  ");
        
        stopDrawBtn.setEnabled(false);
        
        this.add(exitBtn,BorderLayout.WEST);
        //在ToolBar介面上加入 按鈕-->""exitBtn""  並且讓按鈕設定在西邊
        this.add(drawLineBtn);
        this.add(stopDrawBtn);
        this.add(drawPen);
        this.add(setColor);
       
        
        drawLineBtn.addMouseListener(
            new MouseAdapter()
            {
                public void mouseClicked(MouseEvent e)
                {
                    parent.parent.status = Status.drawLine;

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
        
    }
         
}
