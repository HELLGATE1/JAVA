package FX.Object;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
public class Collection {
public static ObservableList<Person> list = FXCollections.observableArrayList();
public static ObservableList<Person> list2 = FXCollections.observableArrayList();

public void add(Person person) {list.add(person);}

public void del(Person person) {list.remove(person);}

public void addData() {
    list.add(new Person("Иванов И.О.", "1526854"));
    list.add(new Person("Петров С.С.", "5465465"));
    list.add(new Person("Сидоров Д.Ю.", "6545645"));
    list.add(new Person("Попов К.К.", "6546544"));
    list.add(new Person("Николаев К.Ю.", "5468544"));
    list.add(new Person("Соловьёв А.А.", "8946557"));
    list.add(new Person("Якуб В.В.", "7496544"));
}

}
