package com.example.mazebank.Controllers.Admin;

import com.example.mazebank.Models.Client;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class ClientCellController implements Initializable {
    public Label date_lbl;
    public Label fName_lbl;
    public Label lName_lbl;
    public Label pAddress_lbl;
    public Label ch_acc_lbl;
    public Label sv_acc_lbl;
    public Button delete_btn;
    private final  Client client;
    public  ClientCellController(Client client){
        this.client =client;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
