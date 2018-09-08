package GUI;

import javax.swing.*;
import java.awt.*;
public class MyText extends JTextField {
MyText(String s, int size) {
    super.setText(s);
    super.setColumns(size);
    super.setFont(new Font("Times new Roman", Font.PLAIN, 20));
    super.setForeground(Color.GRAY);
}

MyText(int size) {
    super.setColumns(size);
    super.setFont(new Font("Times new Roman", Font.PLAIN, 20));
    super.setForeground(Color.GRAY);
}
}