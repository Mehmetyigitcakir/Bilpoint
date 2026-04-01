package bilpoint;

import java.util.ArrayList;

public class PublicEvent extends Event {
    protected int rsvpCount;
    protected ArrayList<String> adminCount;

    public PublicEvent(String eventId, String hostId, String title, String location, int rsvpCount) {
        super(eventId, hostId, title, location);
        this.rsvpCount = rsvpCount;
        //TODO Auto-generated constructor stub
    }

    public void incrementRSVP(){
        
    }

    
}
