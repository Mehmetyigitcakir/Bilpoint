package bilpoint;

import java.util.ArrayList;
import java.util.List;

public abstract class User {

    protected String name;
    protected String ID;
    protected String mail;
    protected String location;
    protected boolean isLoggedIn;
    protected String password;
    protected List<Notification> notifications;
    protected List<Event> joinedEvents;

    public User(String name, String mail, String password) {
        this.name = name;
        this.location = "";
        this.ID = "USR-" + java.util.UUID.randomUUID().toString().substring(0, 8);
        this.mail = mail;
        this.password = password;
        isLoggedIn = false;
        this.notifications = new ArrayList<>();
        this.joinedEvents = new ArrayList<>();
    }

    public boolean login(String m, String p) {
        if (m.equals(mail) && p.equals(password)) {
            this.isLoggedIn = true;
            return true;
        }
        return false;
    }

    public void joinEvent(Event event) {
        joinedEvents.add(event);
        event.getUserList().add(this);
    }

    public void logout() {
        this.isLoggedIn = false;
    }
    public boolean isLoggedIn() {
        return isLoggedIn;
    }
    public String getID() {
        return ID;
    }

    public String getMail() {
        return mail;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public String getLocation() {
        return location;
    }
    public List<Notification> getNotifications() {
        return notifications;
    }
}