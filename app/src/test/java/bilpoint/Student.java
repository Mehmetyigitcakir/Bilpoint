package bilpoint;

import java.util.ArrayList;
import java.util.List;

public class Student extends User {

    private String department;
    private List<Student> friends;

    public Student(String name, String mail, String password, String department) {
        super(name, mail, password);
        this.ID = "STD-" + java.util.UUID.randomUUID().toString().substring(0, 8);
        this.department = department;
        friends = new ArrayList<Student>();
    }

    public void sendFriendRequest(Student s) {
        if (s == null|| s.equals(this))
            return;
        String message = this.getName() + " sent you a friend request.";
        s.getNotifications().add(new Notification(message));
    }

    public void acceptFriend(Student friend){
       if (!friends.contains(friend)) {
         friend.getNotifications().add(new Notification(this.name + " has accepted your friend request."))
            this.friends.add(friend);
            friend.getFriends().add(this); 
        } 
    }

    public String getDepartment() {
        return department;
    }
    public List<Student> getFriends() {
        return friends;
    }
}