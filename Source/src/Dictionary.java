import java.util.ArrayList;
import java.util.List;

/**
 *  Class Dictionary cung cấp dữ liệu như 1 từ điển gồm các Word và được biểu diễn bằng ArrayList.
 */
public class Dictionary {

    public List<Word> words = new ArrayList<>();

    public List<Word> getWords() {
        return words;
    }

}
