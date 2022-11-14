package application;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class ProcessingAgentController implements Initializable {

    @FXML
    private ListView<String> myListview;

    @FXML
    private Label mylabel;

    @FXML
    private Button processorder;

    public String[] orderslist;

    String currorder;

    public void buttonpress(){
        Controller.processElement(mylabel.getText());
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        orderslist = Controller.getList();
        myListview.getItems().addAll(orderslist);

        myListview.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {

                currorder = myListview.getSelectionModel().getSelectedItem();

                mylabel.setText(currorder);


            }
        });
    }
}
