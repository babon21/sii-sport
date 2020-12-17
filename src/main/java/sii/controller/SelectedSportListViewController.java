package sii.controller;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import sii.utils.DetailedSportInfoUpdater;
import sii.utils.ListHelper;

import java.util.ArrayList;
import java.util.List;

public class SelectedSportListViewController {

    private ObservableList<String> observableSportList = FXCollections.observableArrayList();
    private ListView<String> selectedSportsListView;

    public void init(ListView<String> selectedSportsListView, DetailedSportInfoUpdater detailedSportInfoUpdater) {
        this.selectedSportsListView = selectedSportsListView;

        selectedSportsListView.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
                    detailedSportInfoUpdater.updateInfo(newValue);
                }
        );
    }

    public void updateSelectedList(String sport) {
        if (observableSportList.contains(sport)) {
            return;
        }

        observableSportList.add(sport);
        selectedSportsListView.setItems(observableSportList);
    }

    public List<String> getSelectedList() {
        return new ArrayList<>(observableSportList);
    }

    public void remove() {
        ListHelper.removeItemIfSelected(selectedSportsListView);
    }

    public void clear() {
        selectedSportsListView.getItems().clear();
    }
}
