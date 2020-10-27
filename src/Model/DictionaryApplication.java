package Model;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.MenuItem;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import java.io.*;
import com.sun.speech.freetts.*;

public class DictionaryApplication implements Initializable {

    private static final String VOICENAME = "kevin16";

    @FXML
    MenuItem menuItem_add;
    @FXML
    MenuItem menuItem_update;
    @FXML
    MenuItem menuItem_delete;

    @FXML
    MenuButton menuButton_Modify;

    @FXML
    Button button_Speak;

    @FXML
    TextField textField_searchWord;


    @FXML
    ListView<String> listView_wordsList;

    @FXML
    TextArea textArea_meaning;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        textField_searchWord.setStyle("-fx-text-inner-color: green;");
        DictionaryManagement.insertFromFile(false);
        initializeWordsList();

        Voice voice;
        VoiceManager vm = VoiceManager.getInstance();
        voice = vm.getVoice(VOICENAME);
        voice.allocate();
        textField_searchWord.setOnKeyTyped(key -> {
                System.out.println("Search!!!");
                String searchedWord = textField_searchWord.getText();
                if (searchedWord != null) {
                    clearListViewAndAddWordsYouSearchFor(searchedWord.trim());
                }
        });
        listView_wordsList.setOnMouseClicked(event -> {
            String searchedWord = listView_wordsList.getSelectionModel().getSelectedItem();
            if (searchedWord != null && !searchedWord.equals("")) {
                textArea_meaning.setText(Dictionary.getMeaning(searchedWord));
            }
        });
        menuItem_add.setOnAction(event -> {
            try {
                Stage stage_addWord = new Stage();
                Pane root = FXMLLoader.load(getClass().getResource("AddWord.fxml"));
                stage_addWord.setScene(new Scene(root, 500, 200));
                stage_addWord.setTitle("Thêm từ mới...");
                stage_addWord.showAndWait();
                stage_addWord.setOnCloseRequest(event1 -> initializeWordsList());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        menuItem_update.setOnAction(event -> {
            try {
                Stage stage_updateWord = new Stage();
                Pane root = FXMLLoader.load(getClass().getResource("UpdateWord.fxml"));
                stage_updateWord.setScene(new Scene(root, 500, 200));
                stage_updateWord.setTitle("Thêm từ mới...");
                stage_updateWord.showAndWait();
                stage_updateWord.setOnCloseRequest(event1 -> initializeWordsList());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        menuItem_delete.setOnAction(event -> {
            try {
                Stage stage_deleteWord = new Stage();
                Pane root = FXMLLoader.load(getClass().getResource("DeleteWord.fxml"));
                stage_deleteWord.setScene(new Scene(root, 500, 200));
                stage_deleteWord.setTitle("Thêm từ mới...");
                stage_deleteWord.showAndWait();
                stage_deleteWord.setOnCloseRequest(event1 -> initializeWordsList());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        button_Speak.setOnAction(event -> {
            voice.speak(listView_wordsList.getSelectionModel().getSelectedItem());
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
