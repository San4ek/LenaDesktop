package com.example.lenadesktop.controllers;

import com.example.lenadesktop.exceptions.RequestException;
import com.example.lenadesktop.configs.FxmlConfig;
import com.example.lenadesktop.configs.HttpConfig;
import com.example.lenadesktop.models.ActionForSaveModel;
import com.example.lenadesktop.models.ActionStateModel;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

import java.net.URL;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;

public class AddActionController implements Initializable {

    @FXML
    private ChoiceBox<ActionStateModel> actionChoice;

    @FXML
    private Button backBtn;

    @FXML
    private DatePicker datePicker;

    @FXML
    private Label errorLabel;

    @FXML
    private Button saveBtn;

    private static long activeId;

    public static void setActiveId(long activeId) {
        AddActionController.activeId = activeId;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        backBtn.setOnAction(event -> {
            FxmlConfig.setScene("Active.fxml");
        });

        try {
            actionChoice.setItems(FXCollections.observableArrayList(HttpConfig.sendGetRequest("/state/all", ActionStateModel[].class)));
        } catch (RequestException e) {
            errorLabel.setText(e.getMessage());
        }

        saveBtn.setOnAction(event -> {
            try {
                if (actionChoice.getValue()==null || datePicker.getValue()==null) throw new RequestException("Fill all fields");

                HttpConfig.sendPostRequest("/action", Long.class, new ActionForSaveModel(activeId,
                        Date.from(datePicker.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()),
                        actionChoice.getValue().getId()));

                FxmlConfig.setScene("Active.fxml");
            } catch (RequestException e) {
                errorLabel.setText(e.getMessage());
            }
        });
    }
}
