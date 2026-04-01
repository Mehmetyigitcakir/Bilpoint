package bilpoint;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.time.ZoneId;


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

}
