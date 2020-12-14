package sii.controller;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import sii.model.Sport;
import sii.utils.LoadHelper;

import java.util.List;


public class SportListViewController {

    private ObservableList<String> observableSportList = FXCollections.observableArrayList();

    public void init(ListView<String> sportListView, SelectedSportListViewController selectedSportListViewController) {
        List<Sport> sportList = new LoadHelper().loadSportList();

        sportList.stream().map((Sport::getName)).forEach(name-> {
            observableSportList.add(name);
        });

        sportListView.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) ->
                selectedSportListViewController.updateSelectedList(newValue)
        );

        sportListView.setItems(observableSportList);
    }
}
