package com.example.lenadesktop.controllers;

import com.example.lenadesktop.exceptions.RequestException;
import com.example.lenadesktop.configs.FxmlConfig;
import com.example.lenadesktop.configs.HttpConfig;
import com.example.lenadesktop.models.CredentialsModel;
import com.example.lenadesktop.models.User;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ChangeUserController implements Initializable {

    @FXML
    private Button backBtn;

    @FXML
    private Label errorLabel;

    @FXML
    private TextField loginField;

    @FXML
    private TextField passwordField;

    @FXML
    private ChoiceBox<Boolean> blockedChoise;

    @FXML
    private Button saveBtn;

    private static User user;

    public static void setUser(User user) {
        ChangeUserController.user=user;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loginField.setText(user.getLogin());
        passwordField.setText(user.getPassword());

        backBtn.setOnAction(event -> {
            FxmlConfig.setScene("UsersList.fxml");
        });

        blockedChoise.setItems(FXCollections.observableArrayList(true, false));
        blockedChoise.setValue(user.isBlocked());

        saveBtn.setOnAction(event -> {

            System.out.println(blockedChoise.getValue());
            try {
                HttpConfig.sendPostRequest("/user/change?id="+user.getId(), Long.class, new CredentialsModel(loginField.getText(), passwordField.getText(), blockedChoise.getValue()));

                FxmlConfig.setScene("UsersList.fxml");
            } catch (RequestException e) {
                errorLabel.setText(e.getMessage());
            }
        });
    }
}
