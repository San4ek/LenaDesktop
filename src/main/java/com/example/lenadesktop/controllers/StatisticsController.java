package com.example.lenadesktop.controllers;

import com.example.lenadesktop.exceptions.RequestException;
import com.example.lenadesktop.configs.FxmlConfig;
import com.example.lenadesktop.configs.HttpConfig;
import com.example.lenadesktop.models.StatisticsModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class StatisticsController implements Initializable {

    @FXML
    private Button backBtn;

    @FXML
    private Label errorLabel;

    @FXML
    private NumberAxis numberAxis;

    @FXML
    private StackedBarChart<String, Number> statisticsChart;

    @FXML
    private CategoryAxis typeAxis;

    private final List<StatisticsModel> statisticsModels=new ArrayList<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        backBtn.setOnAction(event -> {
            FxmlConfig.setScene("ActivesList.fxml");
        });

        try {
            statisticsModels.addAll(List.of(HttpConfig.sendGetRequest("/statistics", StatisticsModel[].class)));
        } catch (RequestException e) {
            errorLabel.setText(e.getMessage());
        }

        ObservableList<String> categories=FXCollections.observableArrayList();

        XYChart.Series<String, Number> inUsingSeries = new XYChart.Series<>();
        inUsingSeries.setName("In using");

        for (StatisticsModel statisticsModel : statisticsModels) {
            categories.add(statisticsModel.getType());
            inUsingSeries.getData().add(new XYChart.Data<>(statisticsModel.getType(), statisticsModel.getInUsingValue()));
        }

        XYChart.Series<String, Number> writeOffSeries = new XYChart.Series<>();
        writeOffSeries.setName("Write off");

        for (StatisticsModel statisticsModel : statisticsModels) {
            writeOffSeries.getData().add(new XYChart.Data<>(statisticsModel.getType(), statisticsModel.getWriteOffValue()));
        }

        typeAxis.setCategories(categories);

        statisticsChart.getData().addAll(inUsingSeries,writeOffSeries);


    }
}
