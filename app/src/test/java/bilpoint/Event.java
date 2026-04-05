package bilpoint;

import java.util.ArrayList;
import java.util.List;



public abstract class Event{
    protected String eventId;
    protected String hostId;
    protected String title;
    protected String location;
    protected ChatSession chatSession;
    protected List<User> userList;
    protected boolean isCancelled;
    
    public Event(String eventId, String hostId, String title, String location){
        this.eventId = eventId;
        this.hostId = hostId;
        this.title = title;
        this.location = location;
    }

    public ArrayList<String> getDetails(){
        ArrayList<String> details = new ArrayList<>();
        details.add(title);
        details.add(location);
        return details;
    }
    public void cancelEvent(){
        this.isCancelled = true;
        this.userList.clear();
        for(User user : userList){
            user.getNotifications().add(new Notification("Event named " + title +" has been cancelled."));
        }
    }
}