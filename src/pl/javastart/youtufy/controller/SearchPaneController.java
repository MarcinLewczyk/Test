package pl.javastart.youtufy.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class SearchPaneController implements Initializable{

    @FXML
    private TextField searchTextField;

    @FXML
    private ListView<String> historyListView;

	public TextField getSearchTextField() {
		return searchTextField;
	}

	public void setSearchTextField(TextField searchTextField) {
		this.searchTextField = searchTextField;
	}

	public ListView<String> getHistoryListView() {
		return historyListView;
	}

	public void setHistoryListView(ListView<String> historyListView) {
		this.historyListView = historyListView;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		searchTextField.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>(){

			@Override
			public void handle(KeyEvent event) {
				String searchQuery = searchTextField.getText();
				ObservableList<String> historyList = historyListView.getItems();

				if(event.getCode().equals(KeyCode.ENTER)){
					if(historyList.isEmpty() || !historyList.get(0).equals(searchQuery)) {
						historyList.add(0, searchQuery);
					}
				}
			}

		});
	}
}