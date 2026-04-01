package bilpoint;

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
    
}
