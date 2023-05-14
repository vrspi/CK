package CHATKAY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;
import java.util.Scanner;

import Users.User;

public class KAYV1 {

    private String Question;
    String url;
    private String Username;
    private String UserAnswer;
    private boolean IsItCode;
    private boolean IsItRequest;
    private String Request;
    private Scanner sc = new Scanner(System.in);
    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        Question = question;
    }
    private String Answer;

    public String getAnswer() {
        return Answer;
    }

    public void setAnswer(String answer) {
        Answer = answer;
    }
    // Constructor
    public KAYV1(User u){
       url = "http://127.0.0.1:5000/api/ask";
       Username = u.GetUsername();

    }
    public static String encodeUrl(String originalString) {
        StringBuilder encodedString = new StringBuilder();
        for (char c : originalString.toCharArray()) {
            if (c == ' ') {
                encodedString.append("%20");
            } else {
                encodedString.append(c);
            }
        }
        return encodedString.toString();
    }
    public void Ask(String queString) throws IOException{
        
        String encodedString = encodeUrl(queString);

        url += "/"+encodedString;
        URL obj = new URL(url);
         // Open a connection to the API URL
         HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
         connection.setRequestMethod("GET");

         // Get the API response
         int responseCode = connection.getResponseCode();
         if (responseCode == HttpURLConnection.HTTP_OK) {
             // Read the response from the API
             BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
             String line;
             StringBuilder response = new StringBuilder();
             while ((line = reader.readLine()) != null) {
                 response.append(line);
             }
             reader.close();

             // Process the API response
             System.out.println("API Response: " + response.toString());
         } else {
             System.out.println("API Request failed. Response Code: " + responseCode);
         }

         // Close the connection
         connection.disconnect();
    }

    public void Start(){

        System.out.println("CHATKAY V1: Nice to see you again");
        //System.out.print(Username+": ");
        try {
            Giveword();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    private void Giveword() throws IOException{
        
       
        
        while(!IsItCode && !IsItRequest){  
          
            System.out.print(Username+" : ");
            UserAnswer = sc.nextLine();
            Ask(UserAnswer);
            ReInisialise();
        }
        // sc.close();
    }
    public void ReInisialise(){
        IsItCode = false;
        IsItRequest = false;
        url = "http://127.0.0.1:5000/api/ask";
    }

}


//432 last save