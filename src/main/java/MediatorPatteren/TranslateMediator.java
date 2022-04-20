package MediatorPatteren;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.DefaultAsyncHttpClient;
import org.asynchttpclient.ListenableFuture;
import org.asynchttpclient.Response;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

public class TranslateMediator implements ITranslateMediator {
  @Override
  public String translate(Language sourceLanguage, String message,Language targetLanguage) {
    AsyncHttpClient client = new DefaultAsyncHttpClient();

    message = message.replaceAll(" ","%2C%20");

    ListenableFuture<Response> response = client.prepare("POST", "https://google-translate1.p.rapidapi.com/language/translate/v2")
      .setHeader("content-type", "application/x-www-form-urlencoded")
      .setHeader("Accept-Encoding", "application/gzip")
      .setHeader("X-RapidAPI-Host", System.getenv("X-RapidAPI-Host"))
      .setHeader("X-RapidAPI-Key", System.getenv("X-RapidAPI-Key"))
      .setBody("q="+message+"&target="+targetLanguage+"&source="+sourceLanguage)
      .execute();

    JSONParser jsonParser = new JSONParser();
    JSONObject result = null;
    try {
      result = (JSONObject) jsonParser.parse(response.get().getResponseBody());
    } catch (ParseException | InterruptedException | ExecutionException e) {
      e.printStackTrace();
    }

    try {
      client.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    if (result.get("error") !=null){
      return "Opps.. Something went wrong !";
    }
    return (String) ((JSONObject)((JSONArray)((JSONObject)result.get("data")).get("translations")).get(0)).get("translatedText");
  }
}
