package com.example.mazebank.Views;

import com.example.mazebank.Controllers.Admin.AdminController;
import com.example.mazebank.Controllers.Client.ClientController;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;


public class ViewFactory {
    private AccountType loginAccountType;
    //client view
    private final ObjectProperty<ClientMenuOptions> clientSelectedMenuItem;
    private AnchorPane dashboardView;
    private AnchorPane transactionsView;
    private AnchorPane accountsView;


    private final ObjectProperty<AdminMenuOptions> adminSelectedMenuItem;
    private AnchorPane createClientView;
    private AnchorPane clientsView;
    private  AnchorPane depositView;

    public ViewFactory(){
        this.loginAccountType = AccountType.CLIENT;
        this.clientSelectedMenuItem = new SimpleObjectProperty<>();
        this.adminSelectedMenuItem = new SimpleObjectProperty<>();
    }

    public AccountType getLoginAccountType() {
        return loginAccountType;
    }

    public void setLoginAccountType(AccountType loginAccountType) {
        this.loginAccountType = loginAccountType;
    }

    public ObjectProperty<ClientMenuOptions> getClientSelectedMenuItem(){
        return clientSelectedMenuItem;
    }
    public AnchorPane getDashboardView(){
        if(dashboardView == null){
            try {
                dashboardView = new FXMLLoader(getClass().getResource("/Fxml/Client/Dashboard.fxml")).load();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        return dashboardView;
    }
    public void showLoginWindow(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Login.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(loader.load());
        }catch (Exception e){
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Uni Bank");
        stage.show();
    }

    public AnchorPane getTransactionsView() {
        if(transactionsView== null){
            try {
                transactionsView = new FXMLLoader(getClass().getResource("/Fxml/Client/Transactions.fxml")).load();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return transactionsView;
    }
    public AnchorPane getAccountsView(){
        if(accountsView == null){
            try{
                accountsView = new FXMLLoader(getClass().getResource("/Fxml/Client/Accounts.fxml")).load();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return accountsView;
    }
    public void showClientWindow() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Client/Client.fxml"));
        ClientController clientController = new ClientController();
        loader.setController(clientController);
        createStage(loader);
    }
    public ObjectProperty<AdminMenuOptions> getAdminSelectedMenuItem(){
        return adminSelectedMenuItem;
    }
    public AnchorPane getCreateClientView() {
        if(createClientView==null){
            try {
                createClientView = new FXMLLoader(getClass().getResource("/Fxml/Admin/CreateClient.fxml")).load();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return  createClientView;
    }
    public AnchorPane getClientsView(){
        if(clientsView == null){
            try{
                clientsView = new FXMLLoader(getClass().getResource("Fxml/Admin/Clients.fxml")).load();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return clientsView;
    }
    public AnchorPane getDepositView(){
        if(depositView==null){
            try{
                depositView = new FXMLLoader(getClass().getResource("/Fxml/Admin/Deposit.fxml")).load();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return depositView;
    }
    public void showAdminWindow(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Admin/Admin.fxml"));
        AdminController controller = new AdminController();
        loader.setController(controller);
        createStage(loader);
    }

    private void createStage(FXMLLoader loader){

        Scene scene = null;
        try {
            scene = new Scene(loader.load());
        } catch (Exception e){
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.getIcons().add(new Image(String.valueOf(getClass().getResource("/Images/bank.png"))));
        stage.setResizable(false);
        stage.setTitle("Uni Bank");
        stage.show();
    }

    public void closeStage(Stage stage){
        stage.close();
    }


}
