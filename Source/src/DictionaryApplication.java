import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;

import java.net.URL;
import java.util.ResourceBundle;

public class DictionaryApplication implements Initializable{

    DictionaryManagement dictionary_management = new DictionaryManagement();

    @FXML
    public Button button_search;

    @FXML
    public TextField textField_searchWord;

    @FXML
    public ListView<String> listView_wordsList;

    @FXML
    public TextArea textArea_meaning;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        textField_searchWord.setStyle("-fx-text-inner-color: green;");
        dictionary_management.insertFromFile();
        initializeWordsList();
        button_search.setOnMouseClicked(event -> {
            System.out.println("Search!!!");
            String searchedWord = textField_searchWord.getText();
            if (searchedWord != null && searchedWord.trim().length() > 0) {
                clearListViewAndAddWordsYouSearchFor(searchedWord);
            } else {
                initializeWordsList();
            }
        });
        textField_searchWord.setOnKeyReleased(key -> {
            if (key.getCode() == KeyCode.ENTER) {
                System.out.println("Search!!!");
                String searchedWord = textField_searchWord.getText();
                if (searchedWord != null && searchedWord.trim().length() > 0) {
                    clearListViewAndAddWordsYouSearchFor(searchedWord);
                } else {
                    initializeWordsList();
                }
            }
        });
        listView_wordsList.setOnMouseClicked(event -> {
            String searchedWord = listView_wordsList.getSelectionModel().getSelectedItem();
            if (searchedWord != null && !searchedWord.equals("")) {
                textArea_meaning.setText(dictionary_management.dictionary.getMeaning(searchedWord));
            }
        });
    }

    public void initializeWordsList() {
        listView_wordsList.getItems().clear();
        for (Word current_target : Dictionary.words) {
            listView_wordsList.getItems().add(current_target.getWord_target());
        }
    }

    public void clearListViewAndAddWordsYouSearchFor(String word_you_searched) {
        listView_wordsList.getItems().clear();
        for (Word current_target : Dictionary.words) {
            if (current_target.getWord_target().contains(word_you_searched)) {
                listView_wordsList.getItems().add(current_target.getWord_target());
            }
        }
    }
}
