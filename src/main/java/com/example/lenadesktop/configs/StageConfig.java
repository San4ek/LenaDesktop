package com.example.lenadesktop.configs;

import com.example.lenadesktop.HelloApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class StageConfig {

    private static Stage stage;

    public static void setStage(Stage stage) {
        StageConfig.stage=stage;
    }

    public static Stage getStage() {
        return StageConfig.stage;
    }

    public static void setScene(String scene) throws IOException {
        stage.setScene(new Scene(new FXMLLoader(HelloApplication.class.getResource(scene)).load()));
    }

}
