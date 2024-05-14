package com.example.lenadesktop.controllers;

import com.example.lenadesktop.exceptions.RequestException;
import com.example.lenadesktop.configs.FxmlConfig;
import com.example.lenadesktop.configs.HttpConfig;
import com.example.lenadesktop.models.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class UsersListController implements Initializable {

    @FXML
    private Button addBtn;

    @FXML
    private Button backBtn;

    @FXML
    private Label errorLabel;

    @FXML
    private TableColumn<User, String> loginColumn;

    @FXML
    private TableColumn<User, String> passwordColumn;

    @FXML
    private TableColumn<User, Boolean> statusColumn;

    @FXML
    private TableView<User> usersTable;

    private final ObservableList<User> users= FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        backBtn.setOnAction(event -> {
            FxmlConfig.setScene("ActivesList.fxml");
        });

        try {
            users.addAll(HttpConfig.sendGetRequest("/user/all", User[].class));
            System.out.println(users);
        } catch (RequestException e) {
            errorLabel.setText(e.getMessage());
        }

        loginColumn.setCellValueFactory(new PropertyValueFactory<>("login"));
        passwordColumn.setCellValueFactory(new PropertyValueFactory<>("password"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("blocked"));

        usersTable.setItems(users);

        usersTable.setRowFactory(param -> {
            TableRow<User> row = new TableRow<>();

            row.setOnMouseClicked(mouseEvent -> Optional.ofNullable(row.getItem()).ifPresent(rowData -> {
                if (mouseEvent.getClickCount() == 2 && mouseEvent.getButton().name().equals(MouseButton.PRIMARY.name()) && rowData.equals(usersTable.getSelectionModel().getSelectedItem())) {
                    ChangeUserController.setUser(row.getItem());
                    FxmlConfig.setScene("ChangeUser.fxml");
                }
            }));

            return row;
        });

        addBtn.setOnAction(event -> {
            FxmlConfig.setScene("AddUser.fxml");
        });
    }
}
