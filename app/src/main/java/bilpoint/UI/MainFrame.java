

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

    public MainFrame() {
        
        setTitle("BilPoint - Campus Network");
        setSize(1280, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 
        setLayout(new BorderLayout());

        
        cardLayout = new CardLayout();
        contentArea = new JPanel(cardLayout);
        
        
        sidebar = new SideBarPanel(this);
        mapView = new MapViewPanel();
        friendsGroupsPanel = new FriendsGroupsPanel();
        notificationPoolPanel = new NotificationPoolPanel();

        
        contentArea.add(mapView, "MAP_VIEW");
        contentArea.add(friendsGroupsPanel, "FRIENDS_GROUPS_VIEW");
        contentArea.add(notificationPoolPanel, "NOTIFICATION_POOL_VIEW");

        
        add(sidebar, BorderLayout.WEST);
        add(contentArea, BorderLayout.CENTER);
    }

    
    public void switchView(String viewName) {
        cardLayout.show(contentArea, viewName);
    }

    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(() -> {
            new MainFrame().setVisible(true);
        });
    }
}
