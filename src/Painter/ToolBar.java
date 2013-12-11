
package Painter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*; //滑鼠事件監聽器


public class ToolBar extends JPanel {
    
    MainWindows parent = null;
    JButton stopDrawBtn;
    JButton drawLineBtn;
    JButton exitBtn;
    JButton drawPen;
    
    
    ToolBar(MainWindows p)
    {
        parent = p;
        this.setBackground(Color.red);
        //設定工具欄背景顏色 : 紅
        
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        //在ToolBar介面上新增  ""FlowLayout()""<--介面管理員
        
        exitBtn = new JButton("EXIT");
        drawLineBtn = new JButton("Draw Lines");
        stopDrawBtn = new JButton("Stop Draw");
        drawPen = new JButton("pen");
        
        //新增按鈕
        stopDrawBtn.setEnabled(false);
        
      /*  this.setLayout(new BorderLayout());
        //在ToolBar介面上新增  ""BorderLayout()""<--介面管理員
      */
        
        this.add(exitBtn,BorderLayout.WEST);
        //在ToolBar介面上加入 按鈕-->""exitBtn""  並且讓按鈕設定在西邊
        this.add(drawLineBtn);
        this.add(stopDrawBtn);
        this.add(drawPen);
        
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
    }
}
