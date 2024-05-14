package com.example.lenadesktop.controllers;

import com.example.lenadesktop.exceptions.RequestException;
import com.example.lenadesktop.configs.FxmlConfig;
import com.example.lenadesktop.configs.HttpConfig;
import com.example.lenadesktop.configs.UserConfig;
import com.example.lenadesktop.models.ActivesForSendSmallModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;

import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class ActivesListController implements Initializable {

    @FXML
    private Button backBtn;

    @FXML
    private Button addBtn;

    @FXML
    private Label errorLabel;

    @FXML
    private Button usersBtn;

    @FXML
    private Button statisticsBtn;

    @FXML
    private TableView<ActivesForSendSmallModel> activesTable;

    @FXML
    private TableColumn<ActivesForSendSmallModel, String> nameColumn;

    @FXML
    private TableColumn<ActivesForSendSmallModel, Long> numberColumn;

    private final ObservableList<ActivesForSendSmallModel> data = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        usersBtn.setOnAction(event -> {
            FxmlConfig.setScene("UsersList.fxml");
        });

        backBtn.setOnAction(event -> {
            UserConfig.clearUser();

            FxmlConfig.setScene("Auth.fxml");
        });

        statisticsBtn.setOnAction(event -> {
            FxmlConfig.setScene("Statistics.fxml");
        });

        addBtn.setOnAction(event -> {
            FxmlConfig.setScene("AddActive.fxml");
        });

        try {
           data.addAll(List.of(HttpConfig.sendGetRequest("/active/all", ActivesForSendSmallModel[].class)));
        } catch (RequestException e) {
            errorLabel.setText(e.getMessage());
        }

        numberColumn.setCellValueFactory(new PropertyValueFactory<>("number"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        FilteredList<ActivesForSendSmallModel> filteredData = new FilteredList<>(data, b -> true);

        SortedList<ActivesForSendSmallModel> sortedData = new SortedList<>(filteredData);

        sortedData.comparatorProperty().bind(activesTable.comparatorProperty());
        activesTable.setItems(sortedData);

        activesTable.setRowFactory(param -> {
            TableRow<ActivesForSendSmallModel> row = new TableRow<>();

            row.setOnMouseClicked(mouseEvent -> Optional.ofNullable(row.getItem()).ifPresent(rowData -> {
                if (mouseEvent.getClickCount() == 2 && mouseEvent.getButton().name().equals(MouseButton.PRIMARY.name()) && rowData.equals(activesTable.getSelectionModel().getSelectedItem())) {
                    ActiveController.setActiveId(row.getItem().getNumber());
                    FxmlConfig.setScene("Active.fxml");
                }
            }));

            return row;
        });
    }
}
