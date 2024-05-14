package com.example.lenadesktop.controllers;

import com.example.lenadesktop.exceptions.RequestException;
import com.example.lenadesktop.configs.FxmlConfig;
import com.example.lenadesktop.configs.HttpConfig;
import com.example.lenadesktop.models.ActionForSendModel;
import com.example.lenadesktop.models.ActiveForSendFullModel;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class ActiveController implements Initializable {

    @FXML
    private TableColumn<ActionForSendModel, String> stateColumn;

    @FXML
    private TableView<ActionForSendModel> actionsTable;

    @FXML
    private Label auditoryLabel;

    @FXML
    private Button backBtn;

    @FXML
    private Label customerLabel;

    @FXML
    private Button addBtn;

    @FXML
    private Label typeLabel;

    @FXML
    private TableColumn<ActionForSendModel, Date> dateTimeColumn;

    @FXML
    private Label errorLabel;

    @FXML
    private Label nameLabel;

    @FXML
    private Label numberLabel;

    private static long activeId;

    public static void setActiveId(long activeId) {
        ActiveController.activeId = activeId;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        backBtn.setOnAction(event -> {
            FxmlConfig.setScene("ActivesList.fxml");
        });

        addBtn.setOnAction(event -> {
            AddActionController.setActiveId(activeId);

            FxmlConfig.setScene("AddAction.fxml");
        });

        ActiveForSendFullModel active = null;
        try {
            active = HttpConfig.sendGetRequest("/active?id="+activeId, ActiveForSendFullModel.class);
        } catch (RequestException e) {
            errorLabel.setText("Bad connection!");
        }

        if (active!=null) {
            nameLabel.setText(active.getName());
            numberLabel.setText(String.valueOf(active.getId()));
            customerLabel.setText(active.getWorker());
            auditoryLabel.setText(active.getAuditoryNumber());
            typeLabel.setText(active.getType());

            stateColumn.setCellValueFactory(new PropertyValueFactory<>("state"));
            dateTimeColumn.setCellValueFactory(new PropertyValueFactory<>("dateTime"));
            dateTimeColumn.setCellFactory(column -> new TableCell<>() {
                @Override
                protected void updateItem(Date item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setText("");
                    } else {
                        setText(new SimpleDateFormat("dd-MM-yyyy").format(item));
                    }
                }
            });

            actionsTable.setItems(FXCollections.observableArrayList(active.getActions()));
        }
    }
}
