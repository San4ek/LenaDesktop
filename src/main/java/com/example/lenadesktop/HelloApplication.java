package com.example.lenadesktop;

import com.example.lenadesktop.configs.FxmlConfig;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FxmlConfig.setStage(stage);
        FxmlConfig.setScene("Auth.fxml");
        FxmlConfig.getStage().show();
    }

    public static void main(String[] args) {
        launch();
    }
}