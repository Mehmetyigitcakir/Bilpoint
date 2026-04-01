package bilpoint;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.time.ZoneId;


<<<<<<< HEAD
public class ChatSession extends Event{

    protected String sessionId;
    protected String eventId;
    protected int expirationTime;

    public ChatSession(String eventId, String hostId, String title, String location) {
        super(eventId, hostId, title, location);
        //TODO Auto-generated constructor stub
    }

    public void clearHistory(){
        
    }
    
=======
public class ChatSession {
  
  String sessionID;
  String eventID;
  int expirationTime; // hour

    public ChatSession(String sessionID, String eventID, int expirationTime){
        this.sessionID = sessionID;
        this.eventID = eventID;
        this.expirationTime = expirationTime;

    }
    public void clearHistory(){
        Duration duration = Duration.ofHours(expirationTime);
        Instant issued = Instant.now();
        Instant endTime = issued.plus(duration);

        Instant current = Instant.now();
        boolean isExpired = current.isAfter(endTime); 

        if (isExpired == false){
            
        }


    }

>>>>>>> origin/main
}
