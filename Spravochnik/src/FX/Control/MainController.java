package FX.Control;

import FX.Object.Collection;
import FX.Object.Lang;
import FX.Object.Person;
import FX.Utils.Dialog1;
import FX.Utils.Local1;
import javafx.beans.property.ObjectProperty;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.controlsfx.control.textfield.CustomTextField;
import org.controlsfx.control.textfield.TextFields;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Observable;
import java.util.ResourceBundle;

public class MainController extends Observable implements Initializable {
private Collection ob = new Collection();
private Stage st;
private EditControl ed;
private FXMLLoader fxmlLoader = new FXMLLoader();
private Parent parent;
private Stage Mainst;
private ResourceBundle bund;
private static ObservableList<Person> backuplist = Collection.list2;
private Dialog1 dia;
@FXML
private Button butadd;
@FXML
private Button butedit;
@FXML
private Button butdel;
@FXML
private Button butfind;
@FXML
private CustomTextField text;
@FXML
private TableView table;
@FXML
private Label number;
@FXML
private TableColumn<Person, String> cfio;
@FXML
private TableColumn<Person, String> cnum;
@FXML
private ComboBox combo;

@Override
public void initialize(URL location, ResourceBundle resources) {
    bund = resources;
    setupClearButtonField(text);
    cfio.setCellValueFactory(new PropertyValueFactory<Person, String>("fio"));
    cnum.setCellValueFactory(new PropertyValueFactory<Person, String>("num"));
    ob.list.addListener(new ListChangeListener<Person>() {//создём слушатель удаления/добавления к коллекции
        @Override
        public void onChanged(Change<? extends Person> c) {//этот метод вызывается когда коллекция лист изменяется
            settexxt();//обновляем кол-во записей в label
        }
    });
    if (ob.list.size() == 0) {
        ob.addData();
    }
    table.setItems(ob.list);
    settexxt();
    combo.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            Lang select = (Lang) combo.getSelectionModel().getSelectedItem();
            Local1.currentLang = select;
            setChanged();
            notifyObservers(select);
        }
    });
    combobox();

    try {
        fxmlLoader.setLocation(getClass().getResource("../fxml/edit.fxml"));
        fxmlLoader.setResources(ResourceBundle.getBundle("FX.bundle.Locale", Local1.currentLang.getLocale()));
        parent = fxmlLoader.load();
        ed = fxmlLoader.getController();
    } catch (IOException e) {
        e.printStackTrace();
    }

    table.setOnMouseClicked(new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {
            if (event.getClickCount() >= 2) {
                Person select = (Person) table.getSelectionModel().getSelectedItem();
                if (select == null)
                    return;
                showwindow();
                st.setTitle(bund.getString("editentry"));
                ed.person((Person) table.getSelectionModel().getSelectedItem());
            }
        }
    });
}

public void Action(ActionEvent actionEvent) {
    Object ob = actionEvent.getSource();
    if (!(ob instanceof Button))
        return;
    Button but = (Button) ob;
    switch (but.getId()) {
        case "butadd":
            ed.cleartext();
            showwindow();
            st.setTitle(bund.getString("addentry"));
            break;
        case "butedit":
            Person select = (Person) table.getSelectionModel().getSelectedItem();
            if (select == null) {
                dia = new Dialog1();
                dia.showInfoDialog(bund.getString("error"), bund.getString("choose"));
                return;
            }
            ed.person(select);
            showwindow();
            st.setTitle(bund.getString("editentry"));
            break;
    }
}

public void settexxt() {
    number.setText(bund.getString("count") + ": " + ob.list.size());
}

public void Actiondel(ActionEvent actionEvent) {
    Person pers = (Person) table.getSelectionModel().getSelectedItem();
    if (pers == null) {
        dia = new Dialog1();
        dia.showInfoDialog(bund.getString("error"), bund.getString("choose"));
        return;
    }
    ob.del(pers);
}

public void Actionfind(ActionEvent actionEvent) {
    if (Local1.Count == 0) {
        backuplist.clear();
        backuplist.addAll(ob.list);
    }
    if (text.getText().trim().equals("")) {
        Local1.Count = 0;
        ob.list.clear();
        ob.list.addAll(backuplist);
        return;
    }
    ob.list.clear();
    for (Person p : backuplist) {//tolowerCase-привести к нижнему регистру
        if (p.getFio().toLowerCase().contains(text.getText().toLowerCase()) || p.getNum().toLowerCase().contains(text.getText().toLowerCase())) {
            ob.list.add(p);
        }
    }
    Local1.Count++;
}

public void showwindow() {
    if (st == null) {
        st = new Stage();
        st.setMinWidth(408);
        st.setMinHeight(160);
        st.setResizable(false);
        st.setScene(new Scene(parent));
        st.initModality(Modality.WINDOW_MODAL);
        st.initOwner(Mainst);
    }//определяем родительское окно
    st.show();
}

public void setstage(Stage stage) {Mainst = stage;}


public void setupClearButtonField(CustomTextField customTextField) {
    try {
        Method m = TextFields.class.getDeclaredMethod("setupClearButtonField", TextField.class, ObjectProperty.class);
        m.setAccessible(true);
        m.invoke(null, customTextField, customTextField.rightProperty());
    } catch (Exception e) {
        e.printStackTrace();
    }
}

private void combobox() {
    Lang LangRu = new Lang(0, bund.getString("ru"), Local1.RU);
    Lang LangEn = new Lang(1, bund.getString("en"), Local1.EN);
    combo.getItems().add(LangRu);
    combo.getItems().add(LangEn);
    if (Local1.currentLang == null) {
        combo.getSelectionModel().select(0);
        Local1.currentLang = LangRu;
    } else
        combo.getSelectionModel().select(Local1.currentLang.getIndex());
}


}
