package sii;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import sii.utils.DetailedSportInfoUpdater;
import sii.controller.RecommendListViewController;
import sii.controller.SelectedSportListViewController;
import sii.controller.SportListViewController;
import sii.utils.SportSearch;

import java.net.URL;
import java.util.List;
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

    @FXML
    private Slider countSlider;

    @FXML
    private Label countValue;

    @FXML
    private Slider ageSlider;

    @FXML
    private Label ageValue;

    private DetailedSportInfoUpdater detailedSportInfoUpdater;


    @FXML
    private Label sportNameInfo;

    @FXML
    private Label isOlympicInfo;

    @FXML
    private Label popularityInfo;

    @FXML
    private Label countInfo;

    @FXML
    private Label ageInfo;

    @FXML
    private CheckBox olympicCheckBox;

    SportSearch sportSearch;


    public MainController() {
        selectedSportListViewController = new SelectedSportListViewController();
        sportListViewController = new SportListViewController();
        recommendListViewController = new RecommendListViewController();
        sportSearch = new SportSearch();
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
    private void search() {
        List<String> sportNames = sportSearch.search(Integer.valueOf(countValue.getText()), Integer.valueOf(ageValue.getText()), olympicCheckBox.isSelected());
        sportListViewController.update(sportNames);
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
        initCountSlider();
        initAgeSlider();
        countValue.setText(String.format("%.0f", countSlider.getValue()));
        ageValue.setText(String.format("%.0f", ageSlider.getValue()));

        detailedSportInfoUpdater = new DetailedSportInfoUpdater(sportNameInfo, isOlympicInfo, popularityInfo, countInfo, ageInfo);

        recommendListViewController.init(recommendListView, detailedSportInfoUpdater);
        selectedSportListViewController.init(selectedSportsListView, detailedSportInfoUpdater);
        sportListViewController.init(sportListView, selectedSportListViewController, detailedSportInfoUpdater);
    }

    private void initAgeSlider() {
        ageSlider.setMin(6);
        ageSlider.setMax(11);
        ageSlider.setShowTickLabels(true);
        ageSlider.setShowTickMarks(true);
        ageSlider.setBlockIncrement(1);

        ageSlider.valueProperty().addListener((ov, old_val, new_val) -> {
            ageValue.setText(String.format("%.0f", new_val));
        });
    }

    private void initCountSlider() {
        countSlider.setMin(1);
        countSlider.setMax(15);
        countSlider.setShowTickLabels(true);
        countSlider.setShowTickMarks(true);
        countSlider.setBlockIncrement(1);

        countSlider.valueProperty().addListener((ov, old_val, new_val) -> {
            countValue.setText(String.format("%.0f", new_val));
        });
    }
}
