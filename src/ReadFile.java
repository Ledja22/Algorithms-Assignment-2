import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ReadFile {
    private final Set<String> set = new HashSet<>();
    private String sentence = "";
    private final File path = new File("C:\\Users\\asus\\Desktop\\example.txt");
    private int dictionarySize;

    public ReadFile() {
        readContent();
    }

    private void readContent() {
        try {
            Scanner sc = new Scanner(path);
            int lineIndex = 0;
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (lineIndex == 0) {
                    dictionarySize = Integer.parseInt(line);
                }
                if (lineIndex == 1) {
                    sentence = line.toLowerCase();
                }
                if (sentence.length() > Math.pow(10,3) || dictionarySize > 5 * Math.pow(10, 4)){
                    throw new RuntimeException("Input out of range!");
                }
                if (++lineIndex > 2) {
                    set.add(line.toLowerCase());
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Set getSet() {
        return set;
    }

    public String getSentence() {
        return sentence;
    }
}
