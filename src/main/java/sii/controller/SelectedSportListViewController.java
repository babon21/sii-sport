package sii.controller;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

import java.util.ArrayList;
import java.util.List;

public class SelectedSportListViewController {

    private ObservableList<String> observableSportList = FXCollections.observableArrayList();
    private ListView<String> selectedSportsListView;

    public void init(ListView<String> selectedSportsListView) {
        this.selectedSportsListView = selectedSportsListView;
        selectedSportsListView.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
            selectedSportsListView.setItems(FXCollections.observableArrayList());
            observableSportList.remove(newValue);
            selectedSportsListView.setItems(observableSportList);
        });
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
}
