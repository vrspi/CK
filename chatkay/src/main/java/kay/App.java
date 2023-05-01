package kay;

import java.util.Scanner;

import CodePackage.CodeWhiz;
import Users.Session;
import Users.User;

public class App 
{
     private static int choix=0;
    
    public static void main( String[] args )
    {   
        Session session = new Session(new User("Khaireddine", "null"));
        Scanner sc = new Scanner(System.in);
        System.out.println( "Chat Kay! Bienvenue");
        while(App.choix>7 || App.choix<1){
            System.out.println( "#############################");
            System.out.println("1- KAY MathMaven");
            System.out.println("2- KAY CodeWhiz");
            System.out.println("3- KAY Linguatron");
            System.out.println("4- KAY Assistify");
            System.out.println("5- KAY Assitant");
            System.out.println("6- ChatKAY");
            System.out.println("7- Quitter");
            System.out.println( "#############################");
            System.out.print( "Votre choix:");
            App.choix = sc.nextInt();
        }

        switch (App.choix) {
            case 1:
                
                break;
            case 2:
                CodeWhiz CodeChat = new CodeWhiz(session.GetUser());
                CodeChat.Start();
                break;
            
            case 3:
                
                break;
            
            case 4:
                
                break;
            
            case 5:
                
                break;
            
            case 6:
                
                break;
            
            case 7:
                
                break;
            
        }
        
       



    }
}
