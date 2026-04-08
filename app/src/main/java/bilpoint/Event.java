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
    protected int x;
    protected int y;
    
    public Event(User host, String title, String location, String date, int x, int y){
        this.eventId = "EVNT-" + java.util.UUID.randomUUID().toString().substring(0, 8);
        this.host = host;
        this.x = x;
        this.y = y;
        this.title = title;
        this.date = date;
        this.location = location;
        chatSession = new ChatSession(eventId, 24);
        userList = new ArrayList<>();
        this.userList.add(host);
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
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
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