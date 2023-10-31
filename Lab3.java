/*
1131 - zalikova
1131 % 3 = 0 => C3 = StringBuilder
1131 % 17 = 9 => C13 = Задано текст та масив слів. Підрахувати у скількох реченнях зустрічається кожне слово масиву.
*/

public class Lab3 {
  private StringBuilder text;
  private String[] words;

  public void setWords(String[] words) {
    this.words = words;
  }
  public void setText(StringBuilder text) {
    this.text = text;
  }

  Lab3(StringBuilder text, String[] words) {
    setText(text);
    setWords(words);
  }

  public void countWords() {
    for (String word : words) {
      int counter = 0;
      String[] sentences = text.toString().split("[.!?]\\s+");
      for (String sentence : sentences) {
        if (sentence.contains(word)) counter++;
      }
      System.out.printf("The word '%s' appeared in %d sentences\n", word, counter);
    }
  }

  public static void main(String[] args) {
    try {
      Lab3 test = new Lab3(new StringBuilder("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."),
              new String[]{"Lorem", "has"});
      test.countWords();
    } catch (Exception error) {
      System.out.printf("Error: %s\n" + error.getMessage());
    }
  }
}
