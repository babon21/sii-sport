package sii;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import sii.controller.RecommendListViewController;
import sii.controller.SelectedSportListViewController;
import sii.controller.SportListViewController;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    private SportListViewController sportListViewController;
    private SelectedSportListViewController selectedSportListViewController;
    private RecommendListViewController recommendListViewController;

    @FXML
    private ListView<String> sportListView;

    @FXML
    private ListView<String> selectedSportsListView;

    @FXML
    private ListView<String> recommendListView;

    public MainController() {
        selectedSportListViewController = new SelectedSportListViewController();
        sportListViewController = new SportListViewController();
        recommendListViewController = new RecommendListViewController();
    }

    @FXML
    private void submit() {
        recommendListViewController.recommend(selectedSportListViewController.getSelectedList());
    }

    @FXML
    private void dislike() {
        recommendListViewController.dislike();
    }

    @FXML
    private void clear() {
        recommendListViewController.clear();
        selectedSportListViewController.clear();
    }

    @FXML
    private void remove() {
        selectedSportListViewController.remove();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        recommendListViewController.init(recommendListView);
        selectedSportListViewController.init(selectedSportsListView);
        sportListViewController.init(sportListView, selectedSportListViewController);
    }
}
