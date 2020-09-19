import java.util.Scanner;

public class DictionaryManagement {
    public int current_word = 0;

    Scanner input = new Scanner(System.in);

    Dictionary dictionary = new Dictionary();

    public void insertFromCommandline() {
        System.out.print("Bạn cần nhập vô nhiêu từ?:  ");
        int words_need_to_add = input.nextInt();
        current_word += words_need_to_add;
        input.nextLine();
        System.out.println("Bắt đầu thêm từ mới nào!");
        dictionary.words = new Word[words_need_to_add];

        for (int i = 0; i < words_need_to_add; i++) {
            dictionary.words[i] = new Word();
            System.out.print("Từ muốn thêm:  ");
            dictionary.words[i].setWord_target(input.nextLine());
            System.out.print("Dịch ra là:  ");
            dictionary.words[i].setWord_explain(input.nextLine());
        }
    }

}
