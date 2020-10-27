package Model;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.Duration;

public class Controller_Delete {

    @FXML
    TextField textField_deleteWord_target;

    @FXML
    Button button_delete;

    @FXML
    Label label_deleteSuccessfully;

    @FXML
    Label label_pleaseTypeSomething;

    @FXML
    Label label_notExisted;


    public void deleteWord() {
        if (!textField_deleteWord_target.getText().trim().equals("")) {
            boolean status = false;
            for (int i = 0; i < Dictionary.words.size(); ++i) {
                if (Dictionary.words.get(i).getWord_target().equals(textField_deleteWord_target.getText().trim())) {
                    status = true;
                    Dictionary.words.remove(i);
                    label_deleteSuccessfully.setVisible(true);
                    PauseTransition visiblePause1 = new PauseTransition(Duration.seconds(3));
                    visiblePause1.setOnFinished(
                            event -> label_deleteSuccessfully.setVisible(false)
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
