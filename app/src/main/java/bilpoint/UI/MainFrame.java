package bilpoint.ui;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private CardLayout cardLayout; 
    private JPanel contentArea;
    private SideBarPanel sidebar;
    private MapViewPanel mapView;

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

        
        contentArea.add(mapView, "MAP_VIEW");

        
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
