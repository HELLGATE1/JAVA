package GUI;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
MyFrame(String name, int width, int height) {//create construction with title and size
    super(name);//change title
    super.setSize(width, height);//change size
    super.setLocationRelativeTo(null);//set in the middle
    super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//if the window have closed,close program
    super.setMinimumSize(new Dimension(550, 200));//Minimum size

}
}
