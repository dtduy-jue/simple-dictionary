import java.io.FileNotFoundException;

public class DictionaryCommandline {

    DictionaryManagement dictionary_manager = new DictionaryManagement();

    /**
     *  Phương thức xuất tất cả dữ liệu trong từ điển ra màn hình.
     */
    public void showAllWords() {
        System.out.println("No  | English           | Vietnamese");
        for (int i = 0; i < dictionary_manager.dictionary.words.size(); i++) {
            System.out.println((i + 1) + "  | " + dictionary_manager.dictionary.words.get(i).getWord_target() + "           " + "| " + dictionary_manager.dictionary.words.get(i).getWord_explain());
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
    public void dictionaryAdvanced() throws FileNotFoundException {
        dictionary_manager.insertFromFile();
        showAllWords();
        dictionary_manager.dictionaryLookup();
    }

    /**
     * Hàm main.
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        DictionaryCommandline dictionary_commandline = new DictionaryCommandline();
        dictionary_commandline.dictionaryAdvanced();
    }
}
