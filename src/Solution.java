import java.util.*;

public class Solution {

    HashMap<Integer, List<String>> hashMap;

    public List<String> corruptedSentence(String str, Set<String> dictionary) {
        hashMap = new HashMap<>();
        return sentenceReconstructor(str, str.length(), dictionary);
    }

    private List<String> sentenceReconstructor(String str, int endStr, Set<String> dictionary) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (endStr == 0) {
            return new ArrayList<>(Collections.singletonList(""));
        }
        if (hashMap.containsKey(endStr)) {
            return hashMap.get(endStr);
        }
        for (int i = 0; i < endStr; i++) {
            String substring = str.substring(i, endStr);
            if (dictionary.contains(substring)) {
                List<String> stringList = sentenceReconstructor(str, i, dictionary);
                for (String s : stringList) {
                    arrayList.add(s.length() == 0 ? substring : s + " " + substring);
                }
            }
        }
        hashMap.put(endStr, arrayList);
        return arrayList;
    }
}
