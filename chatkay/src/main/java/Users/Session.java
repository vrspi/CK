package Users;

import org.joda.time.DateTime;

public class Session {
    private boolean IsOpen;
    private User user;
    private DateTime SessionStart;
    private DateTime SessionEnd;

    public Session(User user){
        this.user = user;
        SessionStart = DateTime.now();
        IsOpen = true;
        
    }

    public void EndSession(){
        IsOpen = false;
        SessionEnd = DateTime.now();        
    }

    public User GetUser() {
        return user;
        
    }
    
}
