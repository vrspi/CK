package CodePackage;

import java.io.BufferedReader;
import java.io.FileReader;
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
        while(!IsItCode || !IsItRequest){
           
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

        for (String keyword : programmingKeywords) {
            if (Query.contains(keyword)) {
                return true;
            }
        }

        return false;
    }
    private boolean CheckIfRequest(String Query){

        return false;
    }
    public static List<String> getProgrammingKeywords() {
        List<String> programmingKeywords = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("programming_keywords.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                programmingKeywords.add(line.trim().toLowerCase());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return programmingKeywords;
    }

}
