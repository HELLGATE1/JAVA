package GUI.Listner;

import GUI.MyText;

import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import GUI.Main;
public class Focus implements FocusListener {
    MyText ob;
public Focus(MyText my){
    ob=my;
}
    @Override
    public void focusGained(FocusEvent e) {
if (ob.getText().trim().equals(Main.s1)){
    ob.setText("");
ob.setForeground(Color.black);
}
    }

    @Override
    public void focusLost(FocusEvent e) {
if (ob.getText().trim().equals("")){
    ob.setText(Main.s1);
    ob.setForeground(Color.gray);
}
    }
}
