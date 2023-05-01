package Users;

public class User {
    
    private String Username;
    private String Password;
    private String Email;

    public User(String Username,String Password){
        this.Username = Username;
        this.Password = Password;
        this.Email = "new_Email";

    }
    public String GetUsername(){
        
        return Username;
    }
    public String GetPassword(){
        
        return Password;
    }
    public String GetEmail(){
        
        return Email;
    }
    public void Ban(){
        System.out.println("User "+GetUsername()+" Banned!");
    }
}
