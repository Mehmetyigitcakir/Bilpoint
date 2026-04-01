package bilpoint;

import java.util.ArrayList;

public class PrivateMeetup extends Event{
    protected int quota;
    protected ArrayList<String> invitedId;
    public PrivateMeetup(String eventId, String hostId, String title, String location, int quota) {
        super(eventId, hostId, title, location);
        this.quota = quota;
        //TODO Auto-generated constructor stub
    }

    public boolean checkQuota(){
        return false;
        //
    }
    public void kickMember(){
        //
    }
    
    
}
