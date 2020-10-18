import java.io.*;
import java.util.Scanner;

/**
 *  Class DictionaryManagement cung cắp 1 loạt các phương thức hỗ trợ nhập và tra cứu từ điển Dictionary.
 */
public class DictionaryManagement {

    Dictionary dictionary = new Dictionary();

    /**
     *  Phương thức nhập dữ liệu vào từ điển từ dòng lệnh.
     */
    public void insertFromCommandline() {
        Scanner input = new Scanner(System.in);
        System.out.print("Bạn cần nhập vô nhiêu từ?:  ");
        int words_need_to_add = input.nextInt();
        input.nextLine();
        System.out.println("Bắt đầu thêm từ mới nào!");
        for (int i = 0; i < words_need_to_add; i++) {
            System.out.print("Từ muốn thêm:  ");
            Word word_need_to_add = new Word(input.nextLine(), "");
            System.out.print("Dịch ra là:  ");
            word_need_to_add.setWord_explain(input.nextLine());
        }
        input.close();
    }

    /**
     *  Phương thức nhập dữ liệu vào từ điển bằng file.
     * @throws FileNotFoundException
     */
    public void insertFromFile() {
        try {
            Scanner dic_data_scanner = new Scanner(new File("dictionary.txt"));
            String dic_data_lines;
            while (dic_data_scanner.hasNextLine()) {
                dic_data_lines = dic_data_scanner.nextLine();
                String[] definition = dic_data_lines.split("\t", 2);
                Word word_need_to_add = new Word(definition[0], definition[1]);
                dictionary.words.add(word_need_to_add);
            }
            dic_data_scanner.close();
        } catch (FileNotFoundException file_not_found_e) {
            file_not_found_e.printStackTrace();
        }
    }

    /**
     *  Phương thức tra cứu từ điển và xuất kết quả ra màn hình.
     */
    public void dictionaryLookup() {
        Scanner input = new Scanner(System.in);
        System.out.println("Chức năng tra cứu từ điển");
        System.out.print("Bạn muốn tra cứu từ:  ");
        String word_need_to_lookup = input.nextLine();
        boolean has_lookup_word = false;
        for (Word w : Dictionary.words) {
            if (w.getWord_target().equals(word_need_to_lookup)) {
                System.out.print("Nghĩa của từ đó là:  ");
                System.out.println(w.getWord_explain());
                has_lookup_word = true;
            }
        }
        if (!has_lookup_word) {
            System.out.println("Xin lỗi, từ điển không có từ này!a");
        }
    }

    public void addDictionary() {
        Scanner input = new Scanner(System.in);
        System.out.println("Bạn muốn thêm: ");
        String[] added_definition = new String[2];
        added_definition[0] = input.nextLine();
        System.out.println("Nghĩa của từ đó là: ");
        added_definition[1] = input.nextLine();
        Word word_need_to_add = new Word(added_definition[0], added_definition[1]);
        dictionary.words.add(word_need_to_add);
    }


    public void dictionaryExportToFile() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("Copy of dictionary.txt"));
            String current_line = "";
            for (int i = 0; i < dictionary.words.size(); i++) {
                current_line = dictionary.words.get(i).getWord_target() + "\t" + dictionary.words.get(i).getWord_explain() + "\n";
                writer.write(current_line);
            }
            writer.close();
        } catch (IOException io_e) {
            io_e.printStackTrace();
        }
    }

    public void showWord(int id, int word_index) {
        System.out.println((id + 1) + "  | " + dictionary.words.get(word_index).getWord_target() + "           " + "| " + dictionary.words.get(word_index).getWord_explain());
    }
}
