package sii.controller;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;


public class SportListViewController {

    private ObservableList<String> observableSportList = FXCollections.observableArrayList();

    public void init(ListView<String> sportListView, SelectedSportListViewController selectedSportListViewController) {
        observableSportList.add("Хоккей");
        observableSportList.add("Бадминтон");
        observableSportList.add("Регби");
        observableSportList.add("Футбол");
        observableSportList.add("Гандбол");
        observableSportList.add("Волейбол");
        observableSportList.add("Водное поло");
        observableSportList.add("Софтбол");
        observableSportList.add("Бейсбол");
        observableSportList.add("Баскетбол");
        observableSportList.add("Дзюдо");
        observableSportList.add("Джиу-джитсу");
        observableSportList.add("Бокс");
        observableSportList.add("Тайский бокс");
        observableSportList.add("Карате");
        observableSportList.add("Тхэквондо");
        observableSportList.add("Шашки");
        observableSportList.add("Гольф");
        observableSportList.add("Бильярд");
        observableSportList.add("Шахматы");
        observableSportList.add("Теннис");
        observableSportList.add("Настольный теннис");
        observableSportList.add("Метание");
        observableSportList.add("Прыжки");
        observableSportList.add("Гребля");
        observableSportList.add("Плавание");
        observableSportList.add("Бег");
        observableSportList.add("Вольная борьба");
        observableSportList.add("Тяжелая атлетика");

        sportListView.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) ->
                selectedSportListViewController.updateSelectedList(newValue)
        );

        sportListView.setItems(observableSportList);
    }
}
