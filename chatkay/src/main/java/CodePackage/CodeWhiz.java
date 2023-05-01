package CodePackage;

import java.util.Scanner;

import Users.User;

public class CodeWhiz {
    private String Username;
    private String UserAnswer;
    public CodeWhiz(User u){
        Username = u.GetUsername();
    }
    public void Start(){
        boolean IsItCode = false;
        boolean IsItRequest = false;
        Scanner sc = new Scanner(System.in);
        while(!IsItCode || !IsItRequest){
            System.out.println("CodeWhiz : Welcome to KAY CodeWhiz Mr/Mme."+Username);
            System.out.println("CodeWhiz : How can I assist you?");
            System.out.print(Username+" : ");
            UserAnswer = sc.nextLine();
            IsItCode = CheckIfCode(UserAnswer);
            IsItRequest = CheckIfRequest(UserAnswer);
        }
        
    }
    private boolean CheckIfCode(String Query){

        return false;
    }
    private boolean CheckIfRequest(String Query){

        return false;
    }

}
