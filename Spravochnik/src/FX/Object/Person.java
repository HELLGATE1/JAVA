package FX.Object;

import javafx.beans.property.SimpleStringProperty;
public class Person {
public SimpleStringProperty fio;
public SimpleStringProperty num;

public Person() {
    fio = new SimpleStringProperty("");
    num = new SimpleStringProperty("");
}

public Person(String Fio, String numb) {
    fio = new SimpleStringProperty(Fio);
    num = new SimpleStringProperty(numb);
}

public void setFio(String str) {
    fio.set(str);
}

public void setNum(String str) {num.set(str);}

public String getFio() {return this.fio.get();}

public String getNum() {return this.num.get();}

}