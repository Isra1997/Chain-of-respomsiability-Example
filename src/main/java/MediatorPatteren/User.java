package MediatorPatteren;

public class User {
  private String name;
  private Language language;
  private TranslateMediator translator;

  public User(String name, MediatorPatteren.Language language) {
    this.name = name;
    this.language = language;
    this.translator = new TranslateMediator();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public MediatorPatteren.Language getLanguage() {
    return language;
  }

  public void setLanguage(MediatorPatteren.Language language) {
    this.language = language;
  }



  public String chat(String message, User friend){
    return translator.translate(language,message,friend.getLanguage());
  }
}
