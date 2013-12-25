package Painter;

import java.awt.*;
    
public class Painter {
    
     public Status status = Status.idle;
     
    Painter()
    {
       
        MainWindows mainWin = new MainWindows(this,"Painter  Ver.0.001",new Dimension(800,600));
    }
            
}
