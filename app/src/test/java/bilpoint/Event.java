package bilpoint;

import java.util.ArrayList;

public abstract class Event{
    protected String eventId;
    protected String hostId;
    protected String title;
    protected String location;
 
    public Event(String eventId, String hostId, String title, String location){
        this.eventId = eventId;
        this.hostId = hostId;
        this.title = title;
        this.location = location;
    }

    public  ArrayList<String> getDetails(){
        ArrayList<String> details = new ArrayList<>();
        details.add(title);
        details.add(eventId);
        details.add(hostId);
        details.add(location);
        return details;
    }
    public void cancelEvent(){
        // TODO
    }
}