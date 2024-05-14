package com.example.lenadesktop.controllers;

import com.example.lenadesktop.exceptions.RequestException;
import com.example.lenadesktop.configs.FxmlConfig;
import com.example.lenadesktop.configs.HttpConfig;
import com.example.lenadesktop.models.CredentialsModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class AddUserController implements Initializable {

    @FXML
    private Button backBtn;

    @FXML
    private Label errorLabel;

    @FXML
    private TextField loginField;

    @FXML
    private TextField passwordField;

    @FXML
    private Button saveBtn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        backBtn.setOnAction(event -> {
            FxmlConfig.setScene("UsersList.fxml");
        });

        saveBtn.setOnAction(event -> {
            try {
                HttpConfig.sendPostRequest("/user/register", Long.class, new CredentialsModel(loginField.getText(),passwordField.getText()));

                FxmlConfig.setScene("UsersList.fxml");
            } catch (RequestException e) {
                errorLabel.setText(e.getMessage());
            }
        });
    }
}
