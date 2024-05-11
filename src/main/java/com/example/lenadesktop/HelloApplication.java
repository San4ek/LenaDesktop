package com.example.lenadesktop;

import com.example.lenadesktop.configs.StageConfig;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        StageConfig.setStage(stage);
        StageConfig.setScene("Auth.fxml");
        StageConfig.getStage().show();
    }

    public static void main(String[] args) {
        launch();
    }
}