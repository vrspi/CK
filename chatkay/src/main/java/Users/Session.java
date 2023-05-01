package Users;

import org.joda.time.DateTime;

public class Session {
    private boolean IsOpen;
    public boolean isIsOpen() {
        return IsOpen;
    }

    public void setIsOpen(boolean isOpen) {
        IsOpen = isOpen;
    }

    private User user;
    private DateTime SessionStart;
    public DateTime getSessionStart() {
        return SessionStart;
    }

    public void setSessionStart(DateTime sessionStart) {
        SessionStart = sessionStart;
    }

    private DateTime SessionEnd;

    public DateTime getSessionEnd() {
        return SessionEnd;
    }

    public void setSessionEnd(DateTime sessionEnd) {
        SessionEnd = sessionEnd;
    }

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
