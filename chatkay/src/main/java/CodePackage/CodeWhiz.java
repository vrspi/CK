package CodePackage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Users.User;

public class CodeWhiz {
    private String Username;
    private String UserAnswer;
    private List<String> programmingKeywords;
    private String programmingPattern;
    private Matcher programmingMatcher;
    private Matcher stepsMatcher;
    private Pattern programmingRegex;
    private Pattern stepsRegex;
    private String stepsPattern;
    public String getProgrammingPattern() {
        return programmingPattern;
    }

    public void setProgrammingPattern(String programmingPattern) {
        this.programmingPattern = programmingPattern;
    }
    

    public String getStepsPattern() {
        return stepsPattern;
    }

    public void setStepsPattern(String stepsPattern) {
        this.stepsPattern = stepsPattern;
    }

    public void setProgrammingKeywords(List<String> programmingKeywords) {
        this.programmingKeywords = programmingKeywords;
    }

    public CodeWhiz(User u){
        Username = u.GetUsername();
        programmingKeywords = getProgrammingKeywords();
        setProgrammingPattern(".*\\b(cod(e|ing)|program(s|ming)?|algorithm(s)?|function(s)?|variable(s)?|class(es)?|method(s)?|object(s)?|library|interface(s)?|package(s)?|syntax|debug(ging)?|compile(r|d)?|build(ing)?|script(s)?|statement(s)?|loop(s)?|condition(s)?|expression(s)?|module(s)?|codebase(s)?|implementation(s)?|inheritance|polymorphism|encapsulation)\\b.*");
        setStepsPattern(".*\\b(step(s)?|process(es)?|procedure(s)?|guide(s)?|instruction(s)?|manual(s)?|walkthrough(s)?|tutorial(s)?|how\\s(to)?|setup(s)?|configuration(s)?|installation(s)?|operation(s)?|workflow(s)?|task(s)?|flowchart(s)?|map(s)?|checklist(s)?)\\b.*");
        this.programmingRegex = Pattern.compile(programmingPattern, Pattern.CASE_INSENSITIVE);
        this.stepsRegex = Pattern.compile(stepsPattern, Pattern.CASE_INSENSITIVE);
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
        RecheckQuery(UserAnswer);
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
    private void RecheckQuery(String Query){
        this.programmingMatcher = programmingRegex.matcher(Query);
        this.stepsMatcher = stepsRegex.matcher(Query);
        if (programmingMatcher.matches()) {
            System.out.println("The user is asking about programming.");
        } else if (stepsMatcher.matches()) {
            System.out.println("The user is asking about step-by-step processes.");
        } else {
            System.out.println("The query is not related to programming or steps.");
        }
    }


}
