
package Painter;

import java.awt.*;
import javax.swing.*;

public class MainWindows extends JFrame{
    
    Dimension size; 
    ToolBar tbar;
    Page page;
    Painter parent = null;
    
    MainWindows(Painter p,String s,Dimension size)
    {
        super(s);
        //呼叫Painter所設定的標頭檔
        
        parent = p;
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //使用JFrame裡面的EXIT_ON_CLOSE讓視窗關閉時不再執行
        
        this.size = size;
        //把Painter所設定的大小 傳到MainWindows
        
        this.setSize(size);
        //設定視窗的大小
        
        Dimension scrsize = Toolkit.getDefaultToolkit().getScreenSize(); 
        //使用Toolkit 裡面的 getDefaultToolkit() 裡面的 getScreenSize()抓取當前螢幕的大小 傳到scrsize
       
        this.setLocation(scrsize.width/2-size.width/2,scrsize.height/2-size.height/2);
        //使用setLocation設定視窗剛剛好在螢幕正中間
       
        tbar = new ToolBar(this);  //載入ToolBar物件
        page = new Page(this);     //載入Page物件
        
        this.getContentPane().setLayout(new BorderLayout());
        //在內容介面裡面的設計新增  ""BorderLayout()""<--介面管理員
        
        this.getContentPane().add(tbar, BorderLayout.NORTH);
        //在內容介面裡面加入 BorderLayout() 並且讓 tbar在上方
           
        this.getContentPane().add(page, BorderLayout.CENTER);
        //在內容介面裡面加入 BorderLayout() 並且讓 page在中間
         
        setVisible(true); //顯示
    }
}
