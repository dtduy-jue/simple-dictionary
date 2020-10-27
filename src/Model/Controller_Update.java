package Model;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.Duration;

public class Controller_Update {

    @FXML
    TextField textField_updateWord_target;

    @FXML
    TextField textField_updateWord_explain;

    @FXML
    Button button_update;

    @FXML
    Label label_updateSuccessfully;

    @FXML
    Label label_pleaseTypeSomething;

    @FXML
    Label label_notExisted;


    public void updateWord() {
        if (!textField_updateWord_target.getText().trim().equals("") && !textField_updateWord_explain.getText().trim().equals("")) {
            boolean status = false;
            for (int i = 0; i < Dictionary.words.size(); ++i) {
                if (Dictionary.words.get(i).getWord_target().equals(textField_updateWord_target.getText().trim())) {
                    status = true;
                    Dictionary.words.get(i).setWord_explain(textField_updateWord_explain.getText().trim());
                    label_updateSuccessfully.setVisible(true);
                    PauseTransition visiblePause1 = new PauseTransition(Duration.seconds(3));
                    visiblePause1.setOnFinished(
                            event -> label_updateSuccessfully.setVisible(false)
                    );
                    visiblePause1.play();
                    DictionaryManagement.refreshData();
                    break;
                }
                if (!status) {
                    label_notExisted.setVisible(true);
                    PauseTransition visiblePause2 = new PauseTransition(Duration.seconds(3));
                    visiblePause2.setOnFinished(
                            event -> label_notExisted.setVisible(false)
                    );
                    visiblePause2.play();
                }
            }
        } else {
            label_pleaseTypeSomething.setVisible(true);
            PauseTransition visiblePause3 = new PauseTransition(Duration.seconds(3));
            visiblePause3.setOnFinished(event -> label_pleaseTypeSomething.setVisible(false));
            visiblePause3.play();
        }
    }
}
