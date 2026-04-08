package bilpoint;

import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class MainFrame extends JFrame {
    private CardLayout cardLayout; 
    private JPanel contentArea;
    private SideBarPanel sidebar;
    private MapViewPanel mapView;
    private FriendsGroupsPanel friendsGroupsPanel;
    private NotificationPoolPanel notificationPoolPanel;
    private User currentUser;

    public MainFrame(User user) {
        this.currentUser = user;
        setTitle("BilPoint - Campus Network");
        setSize(1280, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 
        setLayout(new BorderLayout());

        
        cardLayout = new CardLayout();
        contentArea = new JPanel(cardLayout);
        
        
        sidebar = new SideBarPanel(this, user);
        mapView = new MapViewPanel(user, this);
        friendsGroupsPanel = new FriendsGroupsPanel(this);
        notificationPoolPanel = new NotificationPoolPanel();

        
        contentArea.add(mapView, "MAP_VIEW");
        contentArea.add(friendsGroupsPanel, "FRIENDS_GROUPS_VIEW");
        contentArea.add(notificationPoolPanel, "NOTIFICATION_POOL_VIEW");

        
        add(sidebar, BorderLayout.WEST);
        add(contentArea, BorderLayout.CENTER);
        pack();
        setVisible(true);
    }
    public void switchToChat(Event event) {
        ChatPanel chatPanel = new ChatPanel(event.getChatSession(), currentUser, event, this);
        contentArea.add(chatPanel, "CHAT_VIEW");
        cardLayout.show(contentArea, "CHAT_VIEW");
    }

    public void switchToProfile(){
      UserProfilePanel userProfile = new UserProfilePanel(this, currentUser);  
      contentArea.add(userProfile, "PROFILE_VIEW");
      cardLayout.show(contentArea, "PROFILE_VIEW");
      contentArea.revalidate();
      contentArea.repaint();
    }
    public void switchToAccount(){
      AccountProfile userProfile = new AccountProfile(this, currentUser);  
      contentArea.add(userProfile, "PROFILE_VIEW");
      cardLayout.show(contentArea, "PROFILE_VIEW");
      contentArea.revalidate();
      contentArea.repaint();
    }

    public void switchToMap() {
        cardLayout.show(contentArea, "MAP_VIEW");
    }


    public void switchView(String viewName) {
        cardLayout.show(contentArea, viewName);
    }
    public User getCurrentUser() {
        return currentUser;
    }
        
}
