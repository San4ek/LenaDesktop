package com.example.lenadesktop;

import com.example.lenadesktop.configs.FxmlConfig;
import com.example.lenadesktop.configs.HttpConfig;
import com.example.lenadesktop.configs.UserConfig;
import com.example.lenadesktop.models.ActivesRequestModel;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class ActivesListController implements Initializable {

    @FXML
    private Button backBtn;

    @FXML
    private Label errorLabel;

    @FXML
    private TableView<ActivesRequestModel> activesTable;

    @FXML
    private TableColumn<ActivesRequestModel, String> nameColumn;

    @FXML
    private TableColumn<ActivesRequestModel, Long> numberColumn;

    private List<ActivesRequestModel> activesList=new ArrayList<>();

    private final ObservableList<ActivesRequestModel> data = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        backBtn.setOnAction(event -> {
            UserConfig.clearUser();

            FxmlConfig.setScene("Auth.fxml");
        });

        try {
            activesList.addAll(List.of(HttpConfig.sendGetRequest("/active", ActivesRequestModel[].class)));
        } catch (RequestException e) {
            errorLabel.setText(e.getMessage());
        }

        data.addAll(activesList);

        numberColumn.setCellValueFactory(new PropertyValueFactory<>("number"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        FilteredList<ActivesRequestModel> filteredData = new FilteredList<>(data, b -> true);

        SortedList<ActivesRequestModel> sortedData = new SortedList<>(filteredData);

        sortedData.comparatorProperty().bind(activesTable.comparatorProperty());
        activesTable.setItems(sortedData);

        activesTable.setRowFactory(param -> {
            TableRow<ActivesRequestModel> row = new TableRow<>();

            row.setOnMouseClicked(mouseEvent -> Optional.ofNullable(row.getItem()).ifPresent(rowData -> {
                if (mouseEvent.getClickCount() == 2 && mouseEvent.getButton().name().equals(MouseButton.PRIMARY.name()) && rowData.equals(activesTable.getSelectionModel().getSelectedItem())) {
                    System.out.println("Work");
                }
            }));

            return row;
        });
    }
}
