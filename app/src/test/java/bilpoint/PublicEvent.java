package bilpoint;

import java.util.ArrayList;
import java.util.List;

public class PublicEvent extends Event {
    protected int participantCount;
    protected List<String> adminCount;

    public PublicEvent(User host, String title, String location, int participantCount, String date) {
        super(host, title, location, date);
        this.participantCount = participantCount;
        adminCount = new ArrayList<>();
    }

    public void incrementParticipantCount(){
        this.participantCount++;
    }

    
}
