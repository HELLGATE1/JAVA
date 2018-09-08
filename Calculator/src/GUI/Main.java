package GUI;

import GUI.Listner.BatListener;
import GUI.Listner.Focus;
import javax.swing.*;
import java.awt.*;

public class Main {
public static final String s1 = "Введите число";

public static void main(String[] args) {
    MyFrame my = new MyFrame("Калькулятор", 550, 200);//create Container with title and size
    my.setLayout(new BorderLayout(2, 2));
    //Create button

    MyButton bplus = new MyButton("Сложение");
    MyButton bminus = new MyButton("Вычитание");
    MyButton bmul = new MyButton("Умножение");
    MyButton bdel = new MyButton("Деление");

    //Add panel and set in need place
    MyPanel pan1 = new MyPanel("Панель 1", 100, 100);
    pan1.setPreferredSize(new Dimension(200, 50));
    pan1.setLayout(new FlowLayout(FlowLayout.LEFT));
    my.add(pan1, BorderLayout.NORTH);
    MyPanel pan2 = new MyPanel("Панель 2", 100, 100);
    pan2.setPreferredSize(new Dimension(200, 50));
    pan2.setLayout(new FlowLayout(FlowLayout.LEFT));
    my.add(pan2, BorderLayout.CENTER);
    MyPanel pan3 = new MyPanel("Панель 3", 100, 100);
    pan3.setPreferredSize(new Dimension(200, 50));
    pan3.setLayout(new FlowLayout(FlowLayout.LEFT));
    my.add(pan3, BorderLayout.SOUTH);
    //Create Label
    JLabel l1 = new JLabel("Число 1");
    l1.setFont(new Font("Times new Roman", Font.ROMAN_BASELINE, 20));
    JLabel l2 = new JLabel("Число 2");
    l2.setFont(new Font("Times new Roman", Font.ROMAN_BASELINE, 20));
    JLabel lrez = new JLabel("Результат");
    lrez.setFont(new Font("Times new Roman", Font.ROMAN_BASELINE, 20));
    //Create Text Field
    MyText t1 = new MyText(s1, 10);
    t1.addFocusListener(new Focus(t1) {});
    MyText t2 = new MyText(s1, 10);
    t2.addFocusListener(new Focus(t2) {});
    MyText trez = new MyText(15);
    trez.setEditable(false);
    trez.setFocusable(false);
    //Add components on panel1
    pan1.add(l1);
    pan1.add(t1);
    pan1.add(l2);
    pan1.add(t2);
//Add components on panel2
    pan2.add(bplus);
    pan2.add(bminus);
    pan2.add(bmul);
    pan2.add(bdel);
    //Add components on panel3
    pan3.add(lrez);
    pan3.add(trez);
    BatListener bat = new BatListener(t1, t2, trez);
    bplus.addActionListener(bat);
    bminus.addActionListener(bat);
    bmul.addActionListener(bat);
    bdel.addActionListener(bat);
    my.setVisible(true);//do the window visible
}
}
