package MediatorPatteren;

public class main {
  public static void main(String[] args) {
    User userSpanish = new User("Senorita",Language.es);
    User userEnglish = new User("Madam",Language.en);

    System.out.println(userEnglish.chat("Hello, World!",userSpanish));
  }
}
