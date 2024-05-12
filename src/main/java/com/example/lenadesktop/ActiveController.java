package com.example.lenadesktop;

import com.example.lenadesktop.configs.HttpConfig;
import com.example.lenadesktop.models.ActionModel;
import com.example.lenadesktop.models.ActiveResponseModel;
import com.example.lenadesktop.models.ActivesRequestModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class ActiveController implements Initializable {

    @FXML
    private TableColumn<ActionModel, String> actionColumn;

    @FXML
    private TableView<ActionModel> actionsTable;

    @FXML
    private Label auditoryLabel;

    @FXML
    private Button backBtn;

    @FXML
    private Label customerLabel;

    @FXML
    private TableColumn<ActionModel, String> dateTimeColumn;

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
        System.out.println(activeId);

        ActiveResponseModel active = null;
        try {
            active = HttpConfig.sendGetRequest("/active?id="+activeId, ActiveResponseModel.class);

            System.out.println(active);

        } catch (RequestException e) {
            errorLabel.setText("Bad connection!");
        }

        nameLabel.setText(active.getName());
        numberLabel.setText(String.valueOf(active.getId()));
        customerLabel.setText(active.getWorker());
        auditoryLabel.setText(active.getAuditoryNumber());
    }
}
