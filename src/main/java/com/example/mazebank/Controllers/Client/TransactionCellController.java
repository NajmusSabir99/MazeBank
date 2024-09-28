package com.example.mazebank.Controllers.Client;

import com.example.mazebank.Models.Transaction;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class TransactionCellController implements Initializable {
    public ImageView in_icon;
    public ImageView out_icon;
    public Label trans_date_lbl;
    public Label receiver_lbl;
    public Label amount_lbl;

    private Transaction transaction;
    public TransactionCellController(Transaction transaction){
        this.transaction = transaction;
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
