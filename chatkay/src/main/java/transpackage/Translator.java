package transpackage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.reflect.Type;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import CodePackage.CodeWhiz;
import Users.User;
import kay.App;

public class Translator {
  private static final String CLIENT_ID = "FREE_TRIAL_ACCOUNT";
  private static final String CLIENT_SECRET = "PUBLIC_SECRET";
  private static final String ENDPOINT = "http://api.whatsmate.net/v1/translation/translate";
  private boolean IsItRequest = false;
  private String UserAnswer;
  private Scanner sc = new Scanner(System.in);
  // public static void main(String[] args) throws Exception {
  //   String fromLang = "en";
  //   String toLang = "fr";
  //   String text = "This is a common question when a developer says, this code is skipping indexes.You are altering the original array and removing the index. So think about it like a stack of blocks. You remove one, all of the ones above it drop down one.So you are removing an item with splice, so you need to reduce the index by one so you do not skip over the item that fills in the gap.";

  //   Translator.translate(fromLang, toLang, text);
  // }
  private static Map<String, String> languageMap;
  private String Username;
  private User user;

  public Translator(User u){
    user = u;
    Username = u.GetUsername();
  }
  static {
    Gson gson = new Gson();
    Type type = new TypeToken<Map<String, String>>(){}.getType();
    try (FileReader fileReader = new FileReader("chatkay\\supported-codes.json")) {
        languageMap = gson.fromJson(fileReader, type);
    } catch (IOException e) {
        e.printStackTrace();
    }
  }
  private static String getLanguageCode(String languageName) {
    for (Map.Entry<String, String> entry : languageMap.entrySet()) {
        if (entry.getValue().equalsIgnoreCase(languageName)) {
            return entry.getKey();
        }
    }
    return null;
}
  
  public static void translate(String fromLang, String toLang, String text) throws Exception {
    String jsonPayload = new StringBuilder()
      .append("{")
      .append("\"fromLang\":\"")
      .append(fromLang)
      .append("\",")
      .append("\"toLang\":\"")
      .append(toLang)
      .append("\",")
      .append("\"text\":\"")
      .append(text)
      .append("\"")
      .append("}")
      .toString();

    URL url = new URL(ENDPOINT);
    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    conn.setDoOutput(true);
    conn.setRequestMethod("POST");
    conn.setRequestProperty("X-WM-CLIENT-ID", CLIENT_ID);
    conn.setRequestProperty("X-WM-CLIENT-SECRET", CLIENT_SECRET);
    conn.setRequestProperty("Content-Type", "application/json");

    OutputStream os = conn.getOutputStream();
    os.write(jsonPayload.getBytes());
    os.flush();
    os.close();

    int statusCode = conn.getResponseCode();
    BufferedReader br = new BufferedReader(new InputStreamReader(
        (statusCode == 200) ? conn.getInputStream() : conn.getErrorStream()
      ));
    String output;
    while ((output = br.readLine()) != null) {
        System.out.println("Linguatron : "+output);
    }
    conn.disconnect();
  }

  public void Start(){
        WannaTranslate = true;
        System.out.println("Linguatron : Welcome to KAY CodeWhiz Mr/Mme : "+Username);
        System.out.println("Linguatron : How can I assist you?");
        Giveword();
        redirect();
      
  }
  public boolean CheckIfTranslate(String userInput ){
    Pattern pattern = Pattern.compile("(?:translate|convert|change|switch|alter|modify)\\s+'(.*?)'\\s+(?:to|into)\\s+(.+)", Pattern.CASE_INSENSITIVE);
    Matcher matcher = pattern.matcher(userInput);
    if (matcher.find()) {
      
      String inputText = matcher.group(1);
      String targetLanguageName = matcher.group(2).trim();

      String targetLanguageCode = getLanguageCode(targetLanguageName);
      //System.out.println(targetLanguageCode);
      if (targetLanguageCode == null) {
          System.out.println("Linguatron : Target language not found.");
          return true;
      }

      try {
        translate("en", targetLanguageCode, inputText);
        return true;
      } catch (Exception e) {
        System.out.println("Linguatron : "+e.getMessage());
      }
      // Now you have inputText and targetLanguageCode
      // You can use them for translation
      // System.out.println("Input Text: " + inputText);
      // System.out.println("Target Language Code: " + targetLanguageCode);
  }
    return false;
  }
  
  private void Giveword(){
    CodeWhiz checker = new CodeWhiz(user);
    CodeWhiz.ExternSender = "Linguatron";
    while(!IsItRequest && WannaTranslate){  
       // System.out.println("######## Is it code:"+IsItCode+"  Is It request:  "+IsItRequest);
        System.out.print(Username+" : ");
        UserAnswer = sc.nextLine();
        IsItRequest = checker.CheckIfRequest(UserAnswer); 
        if(CheckIfTranslate(UserAnswer)){
          continue;
        }
        if(checker.CheckIfGreetings(UserAnswer)){

            continue;
        }
      

        if(!IsItRequest){
            System.out.println("Linguatron : Your question is not about translation topic!");
            System.out.println("Linguatron : please try again!");
        }
        if(IsItRequest){
          Request = UserAnswer;
          System.out.println(Request);
            if(Request=="/exit/"){
                // ReInisialise();
            App.setChoix(0);
            App.main(null);
            }
            if(Request.contains("/list/")){  
              
              IsItRequest = false;
                String filename = "chatkay\\src\\main\\java\\QueriesList.txt";
                 try {
                      List<String> lines = Files.readAllLines(Paths.get(filename));
                      System.out.println("########################################");
                         for (String line : lines) {
                         // Do something with each keyword
                         String Col[] = line.split("-");
                        System.out.println(Col[0]+"    -    "+Col[1]);

                         }
                     System.out.println("########################################");
                     continue;

                     } catch (Exception e) {
                        e.printStackTrace();
                        }
             }
           
        }
        ReInisialise();

    }
    // sc.close();
}


private String Request;
public void ReInisialise(){
  WannaTranslate = false; 
  Request = "";
  App.main(null);
}

  private int RecheckQuery(String Query){
    
   
    if (WannaTranslate){
    ReInisialise();
    Giveword();
    return 1;

    }  else {
         //System.out.println("Linguatron : The query is not related to Translating.");
        return -1;
    }
}
  private boolean WannaTranslate = false;
  private void redirect() {
    switch (RecheckQuery(UserAnswer)) {
        case 1:
           
            break;
        case 2:
            
            break;
        case -1:

            WannaTranslate = false;
                        
            Giveword();
            break;
        
        default:
            break;
    } ;
}

}


    

