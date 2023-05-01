package CodePackage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import Users.User;

public class CodeWhiz {
    private String Username;
    private String UserAnswer;
    private List<String> programmingKeywords;


    public void setProgrammingKeywords(List<String> programmingKeywords) {
        this.programmingKeywords = programmingKeywords;
    }

    public CodeWhiz(User u){
        Username = u.GetUsername();
        programmingKeywords = getProgrammingKeywords();
    }
    public void Start(){
        boolean IsItCode = false;
        boolean IsItRequest = false;
        Scanner sc = new Scanner(System.in);
        System.out.println("CodeWhiz : Welcome to KAY CodeWhiz Mr/Mme."+Username);
        System.out.println("CodeWhiz : How can I assist you?");
        while(!IsItCode && !IsItRequest){
           
            System.out.print(Username+" : ");
            UserAnswer = sc.nextLine();
            IsItCode = CheckIfCode(UserAnswer);
            IsItRequest = CheckIfRequest(UserAnswer);
            if(!IsItCode){
                System.out.println("CodeWhiz : Query not about programming topic!");
                System.out.println("CodeWhiz : Try again!");

            }
        }
        System.out.println("CodeWhiz : You are asking about code!");
        sc.close();
        
    }
    private boolean CheckIfCode(String Query){
        List<String> programmingKeywords = getProgrammingKeywords();
        Query = Query.toLowerCase();

        for (String Word : Query.split(" ")) {
            for (String keyword : programmingKeywords) {
                if (Word.equals(keyword)) {                
                    return true;
                }
            }
        }

        return false;
    }
    private boolean CheckIfRequest(String Query){

        return false;
    }
    public List<String> getProgrammingKeywords() {
        List<String> programmingKeywords = new ArrayList<>();
        String filename = "chatkay\\src\\main\\java\\CodePackage\\programming_keywords.txt";
        try {
            List<String> lines = Files.readAllLines(Paths.get(filename));
            for (String line : lines) {
                // Do something with each keyword
                programmingKeywords.add(line.trim().toLowerCase());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        

        return programmingKeywords;
    }

}
