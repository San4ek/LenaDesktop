package com.example.lenadesktop.controllers;

import com.example.lenadesktop.exceptions.RequestException;
import com.example.lenadesktop.configs.FxmlConfig;
import com.example.lenadesktop.configs.HttpConfig;
import com.example.lenadesktop.models.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class AddActiveController implements Initializable {

    @FXML
    private Button backBtn;

    @FXML
    private Label errorLabel;

    @FXML
    private TextField nameField;

    @FXML
    private Button saveBtn;

    @FXML
    private ChoiceBox<ActiveTypeModel> typeBox;

    @FXML
    private ChoiceBox<WorkerForSendModel> workerBox;

    private final ObservableList<ActiveTypeModel> activeTypeModels = FXCollections.observableArrayList();
    private final ObservableList<WorkerForSendModel> workerForSendModels = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        backBtn.setOnAction(event -> FxmlConfig.setScene("ActivesList.fxml"));

        saveBtn.setOnAction(event -> {
            try {
                if (typeBox.getValue()==null || workerBox.getValue()==null) throw new RequestException("Fill all fields");

                ActiveForSaveModel activeForSaveModel =new ActiveForSaveModel();
                activeForSaveModel.setName(nameField.getText());
                activeForSaveModel.setType(typeBox.getValue().getId());
                activeForSaveModel.setWorker(workerBox.getValue().getId());

                HttpConfig.sendPostRequest("/active", Long.class, activeForSaveModel);

                FxmlConfig.setScene("ActivesList.fxml");
            } catch (RequestException e) {
                errorLabel.setText(e.getMessage());
            }
        });

        try {
            activeTypeModels.addAll(HttpConfig.sendGetRequest("/types/all", ActiveTypeModel[].class));
            typeBox.setItems(activeTypeModels);

            workerForSendModels.addAll(HttpConfig.sendGetRequest("/workers/all", WorkerForSendModel[].class));
            workerBox.setItems(workerForSendModels);
        } catch (RequestException e) {
            saveBtn.setDisable(true);
            errorLabel.setText(e.getMessage());
        }

    }
}
