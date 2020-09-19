public class Word {

    private String word_target;
    private String word_explain;

    public Word() {
        word_explain = "";
        word_target = "";
    }

    public Word(String target, String explain) {
        word_target = target;
        word_explain = explain;
    }

    public void setWord_target (String s) {
        this.word_target = s;
    }

    public void setWord_explain (String s) {
        this.word_explain = s;
    }

    public String getWord_target() {
        return word_target;
    }

    public String getWord_explain() {
        return word_explain;
    }

}
