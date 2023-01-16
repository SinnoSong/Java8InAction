package lambdasinaction.chatper3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ExecuteAround {
    public static void main(String[] args) throws IOException {
        // method we want to refactor to make more flexible
        String result = processFileLimited();
        System.out.println(result);

        System.out.println("---");

        String oneLine = processFile(b -> b.readLine());
        System.out.println(oneLine);

        String twoLines = processFile(b -> b.readLine() + b.readLine());
        System.out.println(twoLines);
    }

    // #region methodes

    public static String processFileLimited() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("lambdasinaction/chapter3/data.txt"))) {
            return br.readLine();
        }
    }

    public static String processFile(BufferedReaderProcessor processor) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("lambdasinaction/chapter3/data.txt"))) {
            return processor.process(br);
        }
    }

    // #endregion

    // #region interface
    public interface BufferedReaderProcessor {
        String process(BufferedReader b) throws IOException;
    }
    // #endregion
}
