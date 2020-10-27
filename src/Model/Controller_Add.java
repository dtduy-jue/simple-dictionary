package Model;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.Duration;

public class Controller_Add {

    @FXML
    TextField textField_addWord_target;

    @FXML
    TextField textField_addWord_explain;

    @FXML
    Button button_add;

    @FXML
    Label label_existed;

    @FXML
    Label label_addSuccessfully;

    @FXML
    Label label_pleaseTypeSomething;

    public void addWord() {
        if (!textField_addWord_target.getText().trim().equals("") && !textField_addWord_explain.getText().trim().equals("")) {
            if (!DictionaryManagement.hasWordYouSearch(textField_addWord_target.getText())) {
                Dictionary.words.add(new Word(textField_addWord_target.getText().trim(), textField_addWord_explain.getText().trim()));
                DictionaryManagement.refreshData();
                label_addSuccessfully.setVisible(true);
                PauseTransition visiblePause = new PauseTransition(Duration.seconds(3));
                visiblePause.setOnFinished(
                        event -> label_addSuccessfully.setVisible(false)
                );
                visiblePause.play();
            } else {
                label_existed.setVisible(true);
                PauseTransition visiblePause = new PauseTransition(Duration.seconds(3));
                visiblePause.setOnFinished(
                        event -> label_existed.setVisible(false)
                );
                visiblePause.play();
            }
        } else {
            label_pleaseTypeSomething.setVisible(true);
            PauseTransition visiblePause = new PauseTransition(Duration.seconds(3));
            visiblePause.setOnFinished(event -> label_pleaseTypeSomething.setVisible(false));
            visiblePause.play();
        }
    }
}
