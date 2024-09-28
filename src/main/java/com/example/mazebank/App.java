package com.example.mazebank;

import com.example.mazebank.Models.Model;
import javafx.application.Application;
import javafx.stage.Stage;
import com.example.mazebank.Views.ViewFactory;
import java.io.IOException;


public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        Model.getInstance().getViewFactory().showLoginWindow();
    }
}
