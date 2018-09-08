package GUI.Listner;

import GUI.Mathematics.Mathem;
import GUI.MyText;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BatListener implements ActionListener {
    private MyText t1;
    private MyText t2;
    private MyText trez;
   public BatListener(MyText a, MyText b, MyText c){
        t1=a;
        t2=b;
        trez=c;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
if (!(e.getSource() instanceof JButton)){return;}
JButton jb=(JButton) e.getSource();
double a=Double.valueOf(t1.getText());
double b=Double.valueOf(t2.getText());
if (jb.getActionCommand().equals("Сложение")){trez.setText(String.valueOf(Mathem.summ(a,b)));}
else if (jb.getActionCommand().equals("Вычитание")){trez.setText(String.valueOf(Mathem.dif(a,b)));}
else if (jb.getActionCommand().equals("Умножение")){trez.setText(String.valueOf(Mathem.mul(a,b)));}
else if (jb.getActionCommand().equals("Деление")){trez.setText(String.valueOf(Mathem.del(a,b)));}
    }
}
