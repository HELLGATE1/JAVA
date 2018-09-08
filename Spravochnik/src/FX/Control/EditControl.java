package FX.Control;

import FX.Object.Collection;
import FX.Object.Person;
import FX.Utils.Dialog1;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class EditControl implements Initializable {
private Person select;
private Collection col = new Collection();
private ResourceBundle bundle;
private Dialog1 dial;
private ObservableList<Person> bac;
@FXML
private TextField tfFIO;
@FXML
private TextField tfnumberphone;
@FXML
private Button butok;
@FXML
private Button butcancel;

@Override
public void initialize(URL location, ResourceBundle resources) {
    bundle = resources;
}

public void ActionOK(ActionEvent actionEvent) {
    if (tfFIO.getText().trim().equals("")) {
        dial = new Dialog1();
        dial.showErrorDialog(bundle.getString("error"), bundle.getString("enter_fio"));
        return;
    }
    if (tfnumberphone.getText().trim().equals("")) {
        dial = new Dialog1();
        dial.showErrorDialog(bundle.getString("error"), bundle.getString("enter_num"));
        return;
    }
    Node ob = (Node) actionEvent.getSource();
    Stage st = (Stage) ob.getScene().getWindow();
    if (st.getTitle().equals(bundle.getString("addentry"))) {
        col.list.add(new Person(tfFIO.getText().trim(), tfnumberphone.getText().trim()));
    } else if (st.getTitle().equals(bundle.getString("editentry"))) {
        select.setFio(tfFIO.getText().trim());
        select.setNum(tfnumberphone.getText().trim());
        bac = FXCollections.observableArrayList();
        bac.addAll(col.list);
        col.list.clear();
        col.list.addAll(bac);
    }
    st.close();
}

public void ActionClose(ActionEvent actionEvent) {
    Node ob = (Node) actionEvent.getSource();
    Stage st = (Stage) ob.getScene().getWindow();
    st.close();
}

public void person(Person sel) {
    select = sel;
    tfFIO.setText(select.getFio());
    tfnumberphone.setText(select.getNum());
}

public void cleartext() {
    tfFIO.setText("");
    tfnumberphone.setText("");
}
}
