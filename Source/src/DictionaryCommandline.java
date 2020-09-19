public class DictionaryCommandline {

    DictionaryManagement dictionary_manager = new DictionaryManagement();

    public void showAllWords() {
        System.out.println("No  | English           | Vietnamese");
        for (int i = 0; i < dictionary_manager.current_word; i++) {
            System.out.println((i + 1) + "  | " + dictionary_manager.dictionary.words[i].getWord_target() + "           " + "| " + dictionary_manager.dictionary.words[i].getWord_explain());
        }
    }

    public void dictionaryBasic() {
        dictionary_manager.insertFromCommandline();
        showAllWords();
    }
    public static void main(String[] args) {
        DictionaryCommandline a = new DictionaryCommandline();
        a.dictionaryBasic();
    }
}
