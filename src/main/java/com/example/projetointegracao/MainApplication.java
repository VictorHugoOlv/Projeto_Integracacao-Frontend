package com.example.projetointegracao;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.helper.DataBaseHelper;

import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("view/product-page.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 820, 440);
        stage.setTitle("Projeto de Integração");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop() {
        DataBaseHelper.getInstance().shutdown();
    }

    public static void main(String[] args) {
        launch();
    }
}