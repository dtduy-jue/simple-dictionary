package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *  Class Dictionary cung cấp dữ liệu như 1 từ điển gồm các Word và được biểu diễn bằng ArrayList.
 */
public class Dictionary {

    public static List<Word> words = new ArrayList<>();

    public List<Word> getWords() {
        return words;
    }

    public static String getMeaning(String current_word_target) {
        String current_word_explain = null;
        for (Word word : words) {
            if (word.getWord_target().equals(current_word_target)) {
                current_word_explain = word.getWord_explain();
                break;
            }
        }
        return current_word_explain;
    }
}
