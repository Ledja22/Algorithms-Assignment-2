import java.util.*;

public class Main {
    public static void main(String[] args) {
        ReadFile readFile = new ReadFile();
        Solution solution = new Solution();
        Set set = readFile.getSet();
        String sentence = readFile.getSentence();

        for (Object output : solution.corruptedSentence(sentence, set)) {
            System.out.println(output);
        }

        System.out.println("The total number of solutions: " + solution.corruptedSentence(sentence, set).size());
    }
}
