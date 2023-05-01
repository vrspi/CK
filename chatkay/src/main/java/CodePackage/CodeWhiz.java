package CodePackage;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Users.User;
import kay.App;

public class CodeWhiz {
    private String Username;
    private String UserAnswer;
    private List<String> programmingKeywords;
    private List<String> wellbeingKeywords;
    private List<String> GreetingsKeywords;
    private String programmingPattern;
    private String greetingsPattern;
    private String wellbeingPattern;
    private Matcher wellbeingMatcher;
    private Pattern wellbeingRegex;
    private String Request;
    private Scanner sc = new Scanner(System.in);
    public String getRequest() {
        return Request;
    }
    public void setWellbeingPattern(String wellbeingPattern) {
        this.wellbeingPattern = wellbeingPattern;
    }
    public void setGreetingsPattern(String greetingsPattern) {
        this.greetingsPattern = greetingsPattern;
    }
    private Matcher greetingsMatcher;
    private Pattern greetingsRegex;
    private Matcher programmingMatcher;
    private Matcher stepsMatcher;
    private Pattern programmingRegex;
    private Pattern stepsRegex;
    private String stepsPattern;
    private boolean IsItCode = false;
    private boolean IsItRequest = false;
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
        wellbeingKeywords = getWellBeingKeywords();
        GreetingsKeywords = getGreetingsKeywords();
        setProgrammingPattern(".*\\b(cod(e|ing)|program(s|ming)?|algorithm(s)?|function(s)?|variable(s)?|class(es)?|method(s)?|object(s)?|library|interface(s)?|package(s)?|syntax|debug(ging)?|compile(r|d)?|build(ing)?|script(s)?|statement(s)?|loop(s)?|condition(s)?|expression(s)?|module(s)?|codebase(s)?|implementation(s)?|inheritance|polymorphism|encapsulation)\\b.*");
        setStepsPattern(".*\\b(step(s)?|process(es)?|procedure(s)?|guide(s)?|instruction(s)?|manual(s)?|walkthrough(s)?|tutorial(s)?|how\\s(to)?|setup(s)?|configuration(s)?|installation(s)?|operation(s)?|workflow(s)?|task(s)?|flowchart(s)?|map(s)?|checklist(s)?)\\b.*");
        this.programmingRegex = Pattern.compile(programmingPattern, Pattern.CASE_INSENSITIVE);
        this.stepsRegex = Pattern.compile(stepsPattern, Pattern.CASE_INSENSITIVE);
        setGreetingsPattern("\\b(hi|hello|hey|hey\\sthere|hey\\sguys|hey\\sfolks|hi\\sthere|hi\\sguys|hi\\sfolks|hey\\sho|hey\\syou|hey\\sall|hey\\s[^\\n]+\\b|hi\\sho|hi\\sy'all|hi\\syou|hi\\s[^\\n]+\\b|good\\s(morning|afternoon|evening|night)|greetings|what's\\sup)\\b([^\\n]+)?$");
        this.greetingsRegex = Pattern.compile(greetingsPattern, Pattern.CASE_INSENSITIVE);
        setWellbeingPattern(".*\\b(how\\sare\\syou|how's\\sit\\sgoing|how\\sare\\syou\\sdoing|how\\sdo\\syou\\sfeel|how\\sare\\sthings|how\\sis\\severything|what's\\snew|what's\\sup|what's\\sgoing\\son|what's\\shappening|what\\sare\\syou\\supto|what\\sare\\syou\\sworking\\son|how\\sare\\syou\\stoday|how\\sdo\\syou\\sfind\\severything|what\\sis\\sgoing\\son|how\\syou\\sbeen|how\\shave\\syou\\sbeen)\\b(\\s.+)?");
        this.wellbeingRegex = Pattern.compile(wellbeingPattern, Pattern.CASE_INSENSITIVE);
    }
    public void Start(){
        
      
        System.out.println("CodeWhiz : Welcome to KAY CodeWhiz Mr/Mme : "+Username);
        System.out.println("CodeWhiz : How can I assist you?");
        Giveword();
        switch (RecheckQuery(UserAnswer)) {
            case 1:
               
                break;
            case 2:
                
                break;
            case -1:

                IsItCode = false;
                IsItRequest = false;            
                Giveword();
                break;
            
            default:
                break;
        } ;
      
        
    }
    private boolean CheckIfGreetings(String Query) {
        this.greetingsMatcher = greetingsRegex.matcher(Query);
        this.wellbeingMatcher = wellbeingRegex.matcher(Query);
        int x=0;
            if(greetingsMatcher.matches()){
                Random random = new Random();
                // System.out.println(wellbeingKeywords.size()); 
                int index = random.nextInt(GreetingsKeywords.size());
                
                String randomString = GreetingsKeywords.get(index);
                System.out.println("CodeWhiz : "+randomString);
                
                x=1;
                
                
            }
            if(wellbeingMatcher.matches()){
                Random random = new Random();
                // System.out.println(wellbeingKeywords.size()); 
                int index = random.nextInt(wellbeingKeywords.size());
                
                String randomString = wellbeingKeywords.get(index);
                if(x==1){
                    
                   
                    System.out.println(randomString);
                }
                

                else{
                    x=1;
                    System.out.println("CodeWhiz : "+randomString);
                }
                
            }
            if(x==1)
            {
                System.out.println("CodeWhiz : How can I assist you?");
                return true;
            }
            return false;
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
        if(Query.startsWith("/exit/")){
            Request ="/exit/";
           return true; 
        }
        if(Query.startsWith("/list/")){
            Request ="/list/";
           return true; 
        }
       
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
    public List<String> getWellBeingKeywords() {
        List<String> wellbeing = new ArrayList<>();
        String filename = "chatkay\\src\\main\\java\\CodePackage\\wellbeing.txt";
        try {
            List<String> lines = Files.readAllLines(Paths.get(filename));
            for (String line : lines) {
                // Do something with each keyword
                wellbeing.add(line.trim().toLowerCase());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        

        return wellbeing;
    }
    public List<String> getGreetingsKeywords() {
        List<String> Greetings = new ArrayList<>();
        String filename = "chatkay\\src\\main\\java\\CodePackage\\greetings.txt";
        try {
            List<String> lines = Files.readAllLines(Paths.get(filename));
            for (String line : lines) {
                // Do something with each keyword
                Greetings.add(line.trim().toLowerCase());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        

        return Greetings;
    }
    private int RecheckQuery(String Query){
        this.programmingMatcher = programmingRegex.matcher(Query);
        this.stepsMatcher = stepsRegex.matcher(Query);
        if (programmingMatcher.matches()){
            CodeScrapper Cs = new CodeScrapper(UserAnswer);
            System.err.println(Cs.Start());
            ReInisialise();
            Giveword();
            return 1;

        } else if (stepsMatcher.matches()) {
             System.out.println("The user is asking about step-by-step processes.");
            return 2;
        } else {
             System.out.println("The query is not related to programming or steps.");
            return -1;
        }
    }
    private void Giveword(){
        
       
        while(!IsItCode && !IsItRequest){  
            System.out.print(Username+" : ");
            UserAnswer = sc.nextLine();
            if(CheckIfGreetings(UserAnswer)){
                continue;
            }
            IsItCode = CheckIfCode(UserAnswer);
            IsItRequest = CheckIfRequest(UserAnswer);
            if(!IsItCode && !IsItRequest){
                System.out.println("CodeWhiz : Your questiion is not about any programming topic!");
                System.out.println("CodeWhiz : please try again!");
            }
            if(IsItRequest){
                if(Request=="/exit/"){
                     ReInisialise();
                App.setChoix(0);
                App.main(null);
                }
                if(Request=="/list/"){
                    ReInisialise();
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

                         } catch (Exception e) {
                            e.printStackTrace();
                            }
                 }
               
            }
            
        }
        // sc.close();
    }

    public void ReInisialise(){
        IsItCode = false;
        IsItRequest = false;
        Request = "";
    }

}
