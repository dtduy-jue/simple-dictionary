import java.io.FileNotFoundException;
import java.util.Scanner;

public class DictionaryCommandline {

    DictionaryManagement dictionary_manager = new DictionaryManagement();

    /**
     *  Phương thức xuất tất cả dữ liệu trong từ điển ra màn hình.
     */
    public void showAllWords() {
        System.out.println("No  | English           | Vietnamese");
        for (int i = 0; i < dictionary_manager.dictionary.words.size(); i++) {
            dictionary_manager.showWord(i, i);
        }
    }

    /**
     *  Phương thức thao tác với từ điển cơ bản gồm nhập dữ liệu từ command line rồi xuất tất cả ra màn hình.
     */
    public void dictionaryBasic() {
        dictionary_manager.insertFromCommandline();
        showAllWords();
    }

    /**
     * Phương thức thao tác nâng cao gồm nhập dữ liệu bằng file rồi xuất tất cả ra màn hình.
     * @throws FileNotFoundException
     */
    public void dictionaryAdvanced() {
        dictionary_manager.insertFromFile();
        showAllWords();
        dictionary_manager.dictionaryLookup();
        dictionarySearcher();
    }

    void dictionarySearcher() {
        Scanner input = new Scanner(System.in);
        System.out.print("Bạn muốn tìm:  ");
        String keyword = input.nextLine();
        boolean has_keyword_you_search = false;
        int results = 0;

        for (int i = 0; i < Dictionary.words.size(); i++) {
            if (Dictionary.words.get(i).getWord_target().contains(keyword)) {
                dictionary_manager.showWord(results, i);
                results++;
                has_keyword_you_search = true;
            }
        }
        if(!has_keyword_you_search) {
            System.out.println("Xin lỗi, không có từ này!");
        }
    }
}
