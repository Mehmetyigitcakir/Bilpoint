package bilpoint;

import java.util.ArrayList;

public class PublicEvent extends Event {
    protected int participantCount;
    protected ArrayList<String> adminCount;

    public PublicEvent(String eventId, String hostId, String title, String location, int participantCount) {
        super(eventId, hostId, title, location);
        this.participantCount = participantCount;
        //TODO Auto-generated constructor stub
    }

    public void incrementParticipantCount(){
        this.participantCount++;
    }

    
}
