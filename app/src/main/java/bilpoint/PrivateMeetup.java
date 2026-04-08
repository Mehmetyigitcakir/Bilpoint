package bilpoint;

import java.util.ArrayList;
import java.util.List;

public class PrivateMeetup extends Event{
    protected int quota;
    protected List<User> invitedUsers;
    public PrivateMeetup(User host, String title, String location, String date, int x, int y, int quota) {
        super(host, title, location, date, x ,y);
        this.quota = quota;
        invitedUsers = new ArrayList<>();
    }

    public boolean checkQuota(){
        if(this.quota >= this.invitedUsers.size()){
            return true;
        }
        else
        return false;
        //
    }
    public boolean kickMember(User user){
        if (!userList.contains(user)){
            return false;
        }
        user.getNotifications().add(new Notification("You are kicked from a meetup named " + title));
        super.userList.remove(user);
        return true;
        //
    }
    public boolean inviteUsers(User user){
        if (this.invitedUsers.size() < quota){
        user.getNotifications().add(new Notification(host.getName() + " invited you a meetup named " + title));
        invitedUsers.add(user);
        return true;
    }
        else{
         return false;
        }
    }

    public int getQuota() {
        return quota;
    }

    public List<User> getInvitedUsers() {
        return invitedUsers;
    }
    
    
}
