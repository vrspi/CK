package kay;

import java.util.Scanner;

import CHATKAY.KAYV1;
import CodePackage.CodeWhiz;
import Tools.tokenizer;
import Users.Session;
import Users.User;
import transpackage.Translator;

public class App 
{


    private static int choix=0;
    private static Scanner sc = new Scanner(System.in);
    public static int getChoix() {
        return choix;
    }

    public static void setChoix(int choix) {
        App.choix = choix;
    }
    public static tokenizer Tokenizer;
    public static void main( String[] args )
    {
        Tokenizer = new tokenizer("");
        Session session = new Session(new User("Khaireddine", "null"));
        
        System.out.println( "Chat Kay! Bienvenue");
        System.out.println("Veuillez choisir un option : ");
        int CheckNonString=0;
        while (CheckNonString == 0) {
            try {
                System.out.println("#############################");
                System.out.println("1- KAY MathMaven");
                System.out.println("2- KAY CodeWhiz");
                System.out.println("3- KAY Linguatron");
                System.out.println("4- KAY Assistify");
                System.out.println("5- KAY Assitant");
                System.out.println("6- ChatKAY");
                System.out.println("7- Quitter");
                System.out.println("#############################");
                System.out.print("Votre choix:");
                App.choix = Integer.parseInt(sc.nextLine());
        
                if (App.choix > 7 || App.choix < 1) {
                    CheckNonString = 0;
                } else {
                    CheckNonString = 1;
                }
            } catch (Exception e) {
                CheckNonString = 0;
                e = null;
            }
            
        switch (App.choix) {
            case 1:
                
                break;
            case 2:
                CodeWhiz CodeChat = new CodeWhiz(session.GetUser());
                CodeChat.Start();
                App.choix = 0;
                break;
            
            case 3:
                Translator Linguatron = new Translator(session.GetUser());
                Linguatron.Start();
                App.choix=0;
                break;
            
            case 4:
                
                break;
            
            case 5:
                
                break;
            
            case 6:
                
                break;
            
            case 7:
                KAYversions();
                break;
            
        }
        
        }
        sc.close();



    }

    private static void KAYversions(){
        int CheckNonString=0;
        int localchoix=0;
        while (CheckNonString == 0) {
            try {
                System.out.println("#############################");
                System.out.println("1- KAY V1");
                System.out.println("2- KAY V2");            
                System.out.println("3- Quitter");
                System.out.println("#############################");
                System.out.print("Votre choix:");
                localchoix = Integer.parseInt(sc.nextLine());
        
                if (localchoix > 3 || localchoix < 1) {
                    CheckNonString = 0;
                } else {
                    CheckNonString = 1;
                }
            } catch (Exception e) {
                CheckNonString = 0;
                e = null;
            }
            switch (localchoix) {
                case 1:
                        Session session = new Session(new User("Khaireddine", "null"));
                        KAYV1 KV1 = new KAYV1(session.GetUser());
                        KV1.Start();
                        localchoix=0;
                    break;
                case 2:
                  
                  break;
                
                case 3:  

                    break;
                
            }
        }
    }
}
