package com.example.lenadesktop.configs;

import com.example.lenadesktop.HelloApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FxmlConfig {

    private static Stage stage;

    public static void setStage(Stage stage) {
        FxmlConfig.stage=stage;
    }

    public static Stage getStage() {
        return FxmlConfig.stage;
    }

    public static void setScene(String scene) {
        try {
            stage.setScene(new Scene(new FXMLLoader(HelloApplication.class.getResource(scene)).load()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
