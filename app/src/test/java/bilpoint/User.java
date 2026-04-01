package bilpoint;

import java.util.ArrayList;
import java.util.List;

public abstract class User {

    protected String name;
    protected String ID;
    protected String mail;
    protected boolean isLoggedIn;
    protected String password;
    protected List<Notification> notifications;

    public User(String name, String ID, String mail, String password) {
        this.name = name;
        this.ID = ID;
        this.mail = mail;
        this.password = password;
        isLoggedIn = false;
        this.notifications = new ArrayList<>();
    }

    public boolean login(String m, String p) {
        if (m.equals(mail) && p.equals(password)) {
            this.isLoggedIn = true;
            return true;
        }
        return false;
    }

    public void logout() {
        this.isLoggedIn = false;
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

    public List<Notification> getNotifications() {
        return notifications;
    }
}