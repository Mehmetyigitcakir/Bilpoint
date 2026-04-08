package bilpoint;


import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import javax.swing.*;

import java.util.ArrayList;
import java.util.List;
import javax.swing.border.LineBorder;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
//import org.w3c.dom.events.MouseEvent;

public class SideBarPanel extends JPanel {
    private MainFrame parent;
    private User currentUser;
    private List<JButton> navButtons;  
    JLabel nameLabel;

    public SideBarPanel(MainFrame parent, User currentUser) {
        this.parent = parent;
        this.currentUser = currentUser;
        navButtons = new ArrayList<>();

        setBackground(new Color(245, 247, 250)); 
        setPreferredSize(new Dimension(260, 800));
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, new Color(220, 225, 230)));

        JPanel profileContainer = new JPanel();
        profileContainer.setOpaque(false);
        profileContainer.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 25));
        profileContainer.setCursor(new Cursor(Cursor.HAND_CURSOR)); 

        ImageIcon avatarIcon =  new ImageIcon("assets_bilpoint/avatar.png");
        JLabel avatarLabel;
        if (avatarIcon != null) {
            Image scaledAvatar = avatarIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            avatarLabel = new JLabel(new ImageIcon(scaledAvatar));
        } else {
            avatarLabel = new JLabel("👤");
            avatarLabel.setFont(new Font("SansSerif", Font.PLAIN, 40));
        }

        JPanel textInfo = new JPanel(new GridLayout(2, 1));
        textInfo.setOpaque(false);
        
        nameLabel = new JLabel(currentUser.getName());
        nameLabel.setFont(new Font("SansSerif", Font.BOLD, 15));
        
        JLabel deptLabel = new JLabel( currentUser.getDepartment() + " Dept");
        deptLabel.setFont(new Font("SansSerif", Font.PLAIN, 12));
        deptLabel.setForeground(Color.GRAY);

        textInfo.add(nameLabel);
        textInfo.add(deptLabel);

        profileContainer.add(avatarLabel);
        profileContainer.add(textInfo);

        profileContainer.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                parent.switchView("PROFILE_VIEW");
                parent.switchToAccount();
            }
        });

        JPanel navPanel = new JPanel();
        navPanel.setOpaque(false);
        navPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));

        JButton mapBtn = createNavButton("📍 Map Interface", true);
        JButton friendsBtn = createNavButton("👥 Friends & Groups", false);
        JButton inboxBtn = createNavButton("📥 Inbox (Pool)", false);

        mapBtn.addActionListener(e -> {
            updateActiveButton(mapBtn); 
            parent.switchView("MAP_VIEW");
        });
        friendsBtn.addActionListener(e -> {
            updateActiveButton(friendsBtn);
            parent.switchView("FRIENDS_GROUPS_VIEW");
        });
        inboxBtn.addActionListener(e -> {
            updateActiveButton(inboxBtn);
            parent.switchView("NOTIFICATION_POOL_VIEW");
        });

        navPanel.add(mapBtn);
        navPanel.add(friendsBtn);
        navPanel.add(inboxBtn);

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 20));
        bottomPanel.setOpaque(false);
        
        JButton createBtn = new JButton("+ Create Meetup");
        createBtn.setPreferredSize(new Dimension(210, 45));
        createBtn.setBackground(new Color(25, 42, 86)); 
        createBtn.setForeground(Color.WHITE);
        createBtn.setFocusPainted(false);
        createBtn.setFont(new Font("SansSerif", Font.BOLD, 14));
        createBtn.setBorder(BorderFactory.createEmptyBorder());

        bottomPanel.add(createBtn);

        add(profileContainer, BorderLayout.NORTH);
        add(navPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
    }


    private void updateActiveButton(JButton clickedBtn) {
        for (JButton btn : navButtons) {
            btn.setBackground(Color.WHITE); 
            btn.setForeground(new Color(100, 110, 130));
        }
        clickedBtn.setBackground(new Color(230, 240, 255));
        clickedBtn.setForeground(new Color(25, 42, 86));
    }

    
    private JButton createNavButton(String text, boolean isActive) {
        JButton btn = new JButton(text);
        btn.setPreferredSize(new Dimension(230, 45));
        btn.setHorizontalAlignment(SwingConstants.LEFT);
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setFont(new Font("SansSerif", Font.BOLD, 14));
        
        navButtons.add(btn);

        if (isActive) {
            btn.setBackground(new Color(230, 240, 255)); 
            btn.setForeground(new Color(25, 42, 86));
        } else {
            btn.setBackground(Color.WHITE);
            btn.setForeground(new Color(100, 110, 130));
        }
        
        return btn;
    }
    public void setNameLabel(String name) {
        nameLabel = new JLabel(currentUser.getName());
    }
    
}
