package sii.utils;

import sii.model.Sport;

import java.util.ArrayList;
import java.util.List;

public class SportSearch {

    List<Sport> sportList;

    public SportSearch() {
        sportList = new LoadHelper().loadSportList();
    }

    public List<String> search(Integer count, Integer age, boolean isOlympic) {
        List<String> sportNames = new ArrayList<>();

        for (Sport sport : sportList) {
            if (count == sport.getMinParticipants() && age == sport.getMinAge() && isOlympic == sport.isOlympic()) {
                sportNames.add(sport.getName());
            }
        }

        if (!sportNames.isEmpty()) {
            return sportNames;
        }

        // поиск в диапазоне
        for (int offset = 1; sportNames.isEmpty(); offset++) {
            for (Sport sport : sportList) {
                if (inRange(count, offset, sport.getMinParticipants()) && inRange(age, offset, sport.getMinAge())) {
                    sportNames.add(sport.getName());
                }
            }
        }

        return sportNames;
    }

    private boolean inRange(long standard, int offset, long curVal) {
        return standard + offset > curVal && standard - offset < curVal;
    }
}
