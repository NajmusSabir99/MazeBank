package com.example.mazebank.Controllers;

import com.example.mazebank.Models.Model;
import com.example.mazebank.Views.AccountType;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    public ChoiceBox<AccountType> acc_selector;
    @FXML
    public Label payee_address_lbl;
    @FXML
    public TextField payee_address_fld;
    @FXML
    public TextField password_fld;
    @FXML
    public Button login_btn;
    @FXML
    public Label error_lbl;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        acc_selector.setItems(FXCollections.observableArrayList(AccountType.CLIENT, AccountType.ADMIN));
        acc_selector.setValue(Model.getInstance().getViewFactory().getLoginAccountType());
        acc_selector.valueProperty().addListener(observable -> setAcc_selector());
        login_btn.setOnAction(event -> onLogin());
    }

    private void onLogin() {
        Stage stage = (Stage) error_lbl.getScene().getWindow();

        if (Model.getInstance().getViewFactory().getLoginAccountType() == AccountType.CLIENT) {
            Model.getInstance().evaluateClientCred(payee_address_fld.getText(), password_fld.getText());
            if (Model.getInstance().getClientLoginSuccessFlag()) {
                Model.getInstance().getViewFactory().showClientWindow();
                Model.getInstance().getViewFactory().closeStage(stage);
            } else {
                payee_address_fld.setText("");
                password_fld.setText("");
                error_lbl.setText("No Such Login Credentials");
            }
        } else {
            // Evaluate Admin Login credentials
            Model.getInstance().evaluateAdminCred(payee_address_fld.getText(), password_fld.getText());
            if (Model.getInstance().getAdminLoginSuccessFlag()) {  // Fix: check admin login flag
                Model.getInstance().getViewFactory().showAdminWindow();
                Model.getInstance().getViewFactory().closeStage(stage);
            } else {
                payee_address_fld.setText("");
                password_fld.setText("");
                error_lbl.setText("No Such Login Credentials");
            }
        }
    }

    private void setAcc_selector() {
        Model.getInstance().getViewFactory().setLoginAccountType(acc_selector.getValue());
        if (acc_selector.getValue() == AccountType.ADMIN) {
            payee_address_lbl.setText("Username:");
        } else {
            payee_address_lbl.setText("Payee Address:");
        }
    }
}
