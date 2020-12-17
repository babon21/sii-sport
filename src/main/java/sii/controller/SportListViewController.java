package sii.controller;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import sii.model.Sport;
import sii.utils.DetailedSportInfoUpdater;
import sii.utils.LoadHelper;

import java.util.List;


public class SportListViewController {

    private ObservableList<String> observableSportList = FXCollections.observableArrayList();

    private ListView<String> sportListView;

    public void init(ListView<String> sportListView, SelectedSportListViewController selectedSportListViewController, DetailedSportInfoUpdater detailedSportInfoUpdater) {
        this.sportListView = sportListView;
        List<Sport> sportList = new LoadHelper().loadSportList();

        sportList.stream().map((Sport::getName)).forEach(name -> {
            observableSportList.add(name);
        });

        sportListView.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
                    selectedSportListViewController.updateSelectedList(newValue);
                    detailedSportInfoUpdater.updateInfo(newValue);
                }
        );

        sportListView.setItems(observableSportList);
    }

    public void update(List<String> sportNames) {
        sportListView.setItems(FXCollections.observableArrayList(sportNames));
    }
}
