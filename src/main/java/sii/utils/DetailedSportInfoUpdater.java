package sii.utils;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import sii.model.Sport;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DetailedSportInfoUpdater {

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

    Map<String, Sport> sports;

    public DetailedSportInfoUpdater(Label sportNameInfo, Label isOlympicInfo, Label popularityInfo, Label countInfo, Label ageInfo) {
        this.sportNameInfo = sportNameInfo;
        this.isOlympicInfo = isOlympicInfo;
        this.popularityInfo = popularityInfo;
        this.countInfo = countInfo;
        this.ageInfo = ageInfo;

        List<Sport> sportList = new LoadHelper().loadSportList();
        sports = sportList.stream().collect(Collectors.toMap(x -> x.getName(), x -> x));
    }

    public void updateInfo(String sportName) {
        Sport sport = sports.get(sportName);
        sportNameInfo.setText(sport.getName());
        isOlympicInfo.setText(sport.isOlympic() ? "Да" : "Нет");
        popularityInfo.setText(Long.toString(sport.getPopularity()));
        countInfo.setText(Long.toString(sport.getMinParticipants()));
        ageInfo.setText(Long.toString(sport.getMinAge()));
    }
}
