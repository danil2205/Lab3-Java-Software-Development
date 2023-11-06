/*
1131 - zalikova
1131 % 3 = 0 => C3 = StringBuilder
1131 % 17 = 9 => C13 = Задано текст та масив слів. Підрахувати у скількох реченнях зустрічається кожне слово масиву.
*/

import java.util.ArrayList;

public class Lab3 {
  private StringBuilder text;
  private StringBuilder[] words;

  public void setWords(StringBuilder[] words) {
    this.words = words;
  }
  public void setText(StringBuilder text) {
    this.text = text;
  }

  Lab3(StringBuilder text, StringBuilder[] words) {
    setText(text);
    setWords(words);
  }

  public void countWords() {
    for (StringBuilder word : words) {
      int counter = 0;
      ArrayList<StringBuilder> sentences = Lab3.splitSentences(text);
      for (StringBuilder sentence : sentences) {
        ArrayList<StringBuilder> wordsInSentence = Lab3.splitWords(sentence);
        for (StringBuilder wordInSentence : wordsInSentence) {
          if (Lab3.equals(wordInSentence, word)) {
            counter++;
            break;
          }
        }
      }
      System.out.printf("The word '%s' appeared in %d sentences\n", word, counter);
    }
  }

  public static ArrayList<StringBuilder> splitSentences(StringBuilder text) {
    ArrayList<StringBuilder> sentences = new ArrayList<>();
    int start = 0;

    for (int end = 0; end < text.length(); end++) {
      char currentChar = text.charAt(end);

      if (currentChar == '.' || currentChar == '!' || currentChar == '?') {
        sentences.add(new StringBuilder(text.substring(start, end + 1)));
        start = end + 1;
      }
    }

    if (start < text.length()) {
      sentences.add(new StringBuilder(text.substring(start)));
    }

    return sentences;
  }

  public static ArrayList<StringBuilder> splitWords(StringBuilder sentence) {
    ArrayList<StringBuilder> words = new ArrayList<>();
    StringBuilder word = new StringBuilder();
    boolean inWord = false;

    for (int i = 0; i < sentence.length() - 1; i++) {
      char currentChar = sentence.charAt(i);

      if (Character.isWhitespace(currentChar)) {
        if (inWord) {
          words.add(word);
          word = new StringBuilder();
          inWord = false;
        }
      } else {
        word.append(Character.toLowerCase(currentChar));
        inWord = true;
      }
    }

    if (inWord) {
      words.add(word);
    }

    return words;
  }

  public static boolean equals(StringBuilder word1, StringBuilder word2) {
    if (word1.length() != word2.length()) {
      return false;
    }

    for (int i = 0; i < word1.length(); i++) {
      if (word1.charAt(i) != word2.charAt(i)) {
        return false;
      }
    }

    return true;
  }


  public static void main(String[] args) {
    try {
      Lab3 test = new Lab3(new StringBuilder("Book war and peace is overrated russian bullshit. Dwarfs is different race. Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."),
              new StringBuilder[]{new StringBuilder("war"), new StringBuilder("Lorem"), new StringBuilder("has")});
      test.countWords();
    } catch (Exception error) {
      System.out.printf("Error: %s\n" + error.getMessage());
    }
  }
}
