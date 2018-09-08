package GUI;

import javax.swing.*;
import java.awt.*;

public class MyButton extends JButton {
MyButton(String name, int width, int height) {
    super.setText(name);
    super.setSize(width, height);
}

MyButton(String name) {
    super.setText(name);
    super.setFont(new Font("Times new Roman", Font.ROMAN_BASELINE, 20));

}
}
