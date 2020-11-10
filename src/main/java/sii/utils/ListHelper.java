package sii.utils;

import javafx.scene.control.ListView;

public class ListHelper {
    public static String removeItemIfSelected(ListView<String> listView) {
        int selectedId = listView.getSelectionModel().getSelectedIndex();
        if (selectedId == -1) {
            return null;
        }

        String selectedItem = listView.getSelectionModel().getSelectedItem();

        listView.getItems().remove(selectedItem);
        return selectedItem;
    }
}
