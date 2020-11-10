package sii;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import sii.controller.SubmitButtonController;
import sii.controller.RecommendListViewController;
import sii.controller.SelectedSportListViewController;
import sii.controller.SportListViewController;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

//    private SubmitButtonController submitButtonController;
    private SportListViewController sportListViewController;
    private SelectedSportListViewController selectedSportListViewController;
    private RecommendListViewController recommendListViewController;

    @FXML
    private ListView<String> sportListView;

    @FXML
    private ListView<String> selectedSportsListView;

    @FXML
    private ListView<String> recommendListView;

//    @FXML
//    private Button submitButton;

    public MainController() {
//        submitButtonController = new SubmitButtonController();
        selectedSportListViewController = new SelectedSportListViewController();
        sportListViewController = new SportListViewController();
        recommendListViewController = new RecommendListViewController();
    }

    @FXML
    private void submit() {
        recommendListViewController.recommend(selectedSportListViewController.getSelectedList());
//        submitButtonController.submit(selectedSportListViewController.getSelectedList(), recommendListViewController);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        recommendListViewController.init(recommendListView);
        selectedSportListViewController.init(selectedSportsListView);
        sportListViewController.init(sportListView, selectedSportListViewController);
//        submitButtonController.init(submitButton);
    }
}
