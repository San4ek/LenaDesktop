package com.example.lenadesktop;

import com.example.lenadesktop.configs.HttpConfig;
import com.example.lenadesktop.configs.UserConfig;
import com.example.lenadesktop.models.CredentialsModel;
import com.example.lenadesktop.models.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;

import java.util.ResourceBundle;

public class AuthController implements Initializable {

    @FXML
    private Button authBtn;

    @FXML
    private Label errorLabel;

    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        authBtn.setOnAction(event -> {
            try {
                User user = HttpConfig.sendPostRequest("/user/auth",
                        User.class,
                        new CredentialsModel(loginField.getText(), passField.getText()));

                UserConfig.setUser(user);

                System.out.println(UserConfig.getUser());
            } catch (RequestException e) {
                errorLabel.setText(e.getMessage());
            }
        });

    }
}
