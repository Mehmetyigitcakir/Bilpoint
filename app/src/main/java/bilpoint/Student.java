package bilpoint;

import java.util.ArrayList;
import java.util.List;

public class Student extends User {

    public Student(String name, String mail, String password, String department) {
        super(name, mail, password, department);
        this.ID = "STD-" + java.util.UUID.randomUUID().toString().substring(0, 8);
    }

    public void sendFriendRequest(Student s) {
        if (s == null|| s.equals(this))
            return;
        String message = this.getName() + " sent you a friend request.";
        s.getNotifications().add(new Notification(message));
    }

    public void acceptFriend(Student friend){
       if (!friends.contains(friend)) {
         friend.getNotifications().add(new Notification(this.name + " has accepted your friend request."));
            this.friends.add(friend);
            friend.getFriends().add(this); 
        } 
    }
    public void addFriends(Student frnd) {
        friends.add(frnd);
    }

    public String getDepartment() {
        return department;
    }
 
}