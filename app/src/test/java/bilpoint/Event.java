package bilpoint;

import java.util.ArrayList;
import java.util.List;

public abstract class Event{
    protected String eventId;
    protected User host;
    protected String title;
    protected String location;
    protected String date;
    protected ChatSession chatSession;
    protected List<User> userList;
    protected boolean isCancelled;
    
    public Event(User host, String title, String location, String date){
        this.eventId = "EVNT-" + java.util.UUID.randomUUID().toString().substring(0, 8);
        this.host = host;
        this.title = title;
        this.date = date;
        this.location = location;
    }

    public ArrayList<String> getDetails(){
        ArrayList<String> details = new ArrayList<>();
        details.add(title);
        details.add(location);
        details.add(date);
        return details;
    }
    public void cancelEvent(){
        this.isCancelled = true;
        this.userList.clear();
        for(User user : userList){
            user.getNotifications().add(new Notification("Event named " + title +" has been cancelled."));
        }
    }
    public List<User> getUserList() {
        return userList;
    }
    public User getHost() {
        return host;
    }
    public String getTitle() {
        return title;
    }
    public String getEventId() {
        return eventId;
    }

    public String getLocation() {
        return location;
    }

    public String getDate() {
        return date;
    }

    public ChatSession getChatSession() {
        return chatSession;
    }

    public boolean isCancelled() {
        return isCancelled;
    }
}