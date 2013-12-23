package Painter;
import javax.swing.*;

public class Label extends JPanel{
    
    JLabel label;
    MainWindows parent;
    
    Label(MainWindows p)
    {
        parent = p;
        label = new JLabel();
        add(label);
    }
    
}
