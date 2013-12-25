package Painter;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList; 

public class Line {
    Point start;
    Point end;
    Color color;
    
    Line(Point s , Point e , Color c){
        start = s;
        end =e;
        color =c;
    }
}
