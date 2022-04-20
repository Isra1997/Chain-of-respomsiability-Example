package MediatorPatteren;

public interface ITranslateMediator {
  public String translate(Language sourceLanguage, String message,Language targetLanguage);
}
