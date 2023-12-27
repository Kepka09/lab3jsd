package org.example;
import java.util.*;

public class TextAnalyzer {
    private String text;

    public TextAnalyzer(String text) {
        this.text = text;
    }

    public int findMaxSentenceWithSameWords() {
        String[] sentences = this.text.split("[\\.!?]\\s*");
        Map<String, Integer> wordFrequency = new HashMap<>();

        for (String sentence : sentences) {
            Set<String> wordsInSentence = new HashSet<>(Arrays.asList(sentence.toLowerCase().split("\\s+")));
            for (String word : wordsInSentence) {
                wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
            }
        }

        return Collections.max(wordFrequency.values());
    }

    public static void main(String[] args) {
        String text = "Сонце світить яскраво, а небо чисте. Ліс сповнений таємниць, а вітер шепоче серед дерев. " +
                "Кожен день надійний, кожен день новий. " +
                "Ліс мовчить вночі, а вітер легко віє. " +
                "Кожен день приносить щось нове, але кожен день також несе в собі спокій." +
                " Вода у річці прохолодна, а ліс повний життя. " +
                "Люди часто шукають відповіді серед зірок, але іноді вони є прямо перед ними.";

        try {
            TextAnalyzer analyzer = new TextAnalyzer(text);
            int maxSameWordCount = analyzer.findMaxSentenceWithSameWords();
            System.out.println("Максимальна кількість речень з однаковими словами: " + maxSameWordCount);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
