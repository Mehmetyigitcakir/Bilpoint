package bilpoint;

import java.util.ArrayList;
import java.util.List;

public class PublicEvent extends Event {
    protected int participantCount;
    protected List<String> adminCount;

    public PublicEvent(User host, String title, String location, String date, int x, int y, int participantCount) {
        super(host, title, location, date, x, y);
        this.participantCount = participantCount;
        adminCount = new ArrayList<>();
    }

    public void incrementParticipantCount(){
        this.participantCount++;
    }

    public int getParticipantCount() {
        return participantCount;
    }

    public List<String> getAdminCount() {
        return adminCount;
    }

    
}
