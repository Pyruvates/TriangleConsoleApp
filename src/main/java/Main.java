import java.io.*;

class Main {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Неправильно указаны параметры запуска.");
            return;
        }
        String inputFileString = args[0];
        String outputFileString = args[1];
        File inputFile = new File(inputFileString);
        if (!inputFile.exists()) {
            System.out.println("Файл не найден. Выполнение программы невозможно.");
            return;
        }
        Solution solution = new Solution();
        solution.main(inputFileString, outputFileString);
    }
}
