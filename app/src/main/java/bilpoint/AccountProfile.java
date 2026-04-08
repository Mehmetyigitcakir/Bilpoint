package bilpoint;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import javax.swing.*;
import javax.swing.border.*;

public class AccountProfile extends JPanel {
    
    private User currentUser;
    private MainFrame parent; 

    private JTextField nameField;
    private JTextField surnameField;
    private JTextField deptField;
    private JLabel bannerAvatarLabel;

    public AccountProfile(MainFrame parent, User user) {
        this.parent = parent;
        this.currentUser = user;
        setLayout(new BorderLayout());
        setBackground(new Color(248, 250, 252));
        
        add(createBannerPanel(), BorderLayout.NORTH);
        add(createContentPanel(), BorderLayout.CENTER);
    }

    private JPanel createBannerPanel() {
        JPanel banner = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                GradientPaint gp = new GradientPaint(0, 0, new Color(134, 185, 230), getWidth(), 0, new Color(77, 124, 170));
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
                g2d.dispose();
            }
        };
        banner.setPreferredSize(new Dimension(800, 180)); 
        banner.setLayout(new BorderLayout());

        JButton backBtn = new JButton("← Back to Campus Map");
        backBtn.setContentAreaFilled(false);
        backBtn.setBorderPainted(false);
        backBtn.setForeground(Color.WHITE);
        backBtn.setFont(new Font("SansSerif", Font.BOLD, 14));
        backBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        backBtn.addActionListener(e -> parent.switchView("MAP_VIEW"));
        
        JPanel topBar = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 10));
        topBar.setOpaque(false);
        topBar.add(backBtn);
        banner.add(topBar, BorderLayout.NORTH);

        return banner;
    }

    private JPanel createContentPanel() {
        JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        content.setOpaque(false);
        content.setBorder(BorderFactory.createEmptyBorder(0, 40, 20, 40));

        JPanel headerInfo = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 0));
        headerInfo.setOpaque(false);
        headerInfo.setBorder(BorderFactory.createEmptyBorder(-60, 0, 25, 0)); 

        Image avatarImg = loadImageSafe("assets_bilpoint/avatar.png");
        if (avatarImg != null) {
            Image scaledAvatar = avatarImg.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
            bannerAvatarLabel = new JLabel(new ImageIcon(scaledAvatar));
        } else {
            bannerAvatarLabel = new JLabel("👤", SwingConstants.CENTER); 
            bannerAvatarLabel.setFont(new Font("SansSerif", Font.PLAIN, 60));
            bannerAvatarLabel.setOpaque(true);
            bannerAvatarLabel.setBackground(new Color(243, 232, 204));
        }
        
        bannerAvatarLabel.setPreferredSize(new Dimension(120, 120));
        bannerAvatarLabel.setBorder(new LineBorder(Color.WHITE, 4, true));

        JPanel textInfo = new JPanel();
        textInfo.setLayout(new BoxLayout(textInfo, BoxLayout.Y_AXIS));
        textInfo.setOpaque(false);
        textInfo.setBorder(BorderFactory.createEmptyBorder(65, 0, 0, 0));

        JLabel nameLabel = new JLabel(currentUser.getName());
        nameLabel.setFont(new Font("SansSerif", Font.BOLD, 30));
        nameLabel.setForeground(new Color(30, 41, 59));

        JLabel deptLabel = new JLabel(currentUser.getDepartment() + " • Bilkent University");
        deptLabel.setFont(new Font("SansSerif", Font.PLAIN, 15));
        deptLabel.setForeground(new Color(100, 116, 139));

        textInfo.add(nameLabel);
        textInfo.add(Box.createVerticalStrut(5));
        textInfo.add(deptLabel);

        headerInfo.add(bannerAvatarLabel);
        headerInfo.add(textInfo);

        JPanel cardsPanel = new JPanel(new GridLayout(1, 3, 20, 0)); // 3 cards
        cardsPanel.setOpaque(false);
        cardsPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 220));

        cardsPanel.add(createStatsCard("👥 Social Network", ""+currentUser.getFriends().size(), "0 Mutual Friends", ""));
        cardsPanel.add(createStatsCard("⚡ Official Memberships", "IEEE Bilkent Branch", "CS102 Study Buddy", "Theater Club"));
        cardsPanel.add(createSettingsCard());

        content.add(headerInfo);
        content.add(Box.createVerticalStrut(10));
        content.add(cardsPanel);

        return content;
    }

    private JPanel createStatsCard(String title, String mainStat, String subStat1, String subStat2) {
        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBackground(Color.WHITE);
        card.setBorder(new CompoundBorder(
                new LineBorder(new Color(226, 232, 240), 1, true),
                new EmptyBorder(20, 20, 20, 20)
        ));

        JLabel titleLbl = new JLabel(title);
        titleLbl.setFont(new Font("SansSerif", Font.BOLD, 16));
        
        JLabel mainLbl = new JLabel(mainStat);
        mainLbl.setFont(new Font("SansSerif", Font.BOLD, 14));
        mainLbl.setForeground(new Color(59, 130, 246));

        JLabel sub1Lbl = new JLabel(subStat1);
        sub1Lbl.setFont(new Font("SansSerif", Font.PLAIN, 13));
        
        JLabel sub2Lbl = new JLabel(subStat2);
        sub2Lbl.setFont(new Font("SansSerif", Font.PLAIN, 12));
        sub2Lbl.setForeground(Color.GRAY);

        card.add(titleLbl);
        card.add(Box.createVerticalStrut(15));
        card.add(mainLbl);
        card.add(Box.createVerticalStrut(10));
        card.add(sub1Lbl);
        card.add(Box.createVerticalStrut(5));
        card.add(sub2Lbl);

        return card;
    }

    private JPanel createSettingsCard() {
        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBackground(Color.WHITE);
        card.setBorder(new CompoundBorder(
                new LineBorder(new Color(226, 232, 240), 1, true),
                new EmptyBorder(15, 15, 15, 15)
        ));

        JLabel titleLbl = new JLabel("⚙️ Account Settings");
        titleLbl.setFont(new Font("SansSerif", Font.BOLD, 16));
        
        JPanel formPanel = new JPanel(new GridLayout(3, 2, 10, 8));
        formPanel.setOpaque(false);

        nameField = new JTextField(currentUser.getName());
        surnameField = new JTextField("");
        deptField = new JTextField("CS Dept");
        
        formPanel.add(new JLabel("Name:")); formPanel.add(nameField);
        formPanel.add(new JLabel("Department:")); formPanel.add(deptField);

        JButton saveBtn = new JButton("Save Changes");
        saveBtn.setBackground(new Color(16, 185, 129)); 
        saveBtn.setForeground(Color.WHITE);
        saveBtn.setFocusPainted(false);
        saveBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        saveBtn.addActionListener(e -> {
            String newName = nameField.getText() + " " + surnameField.getText();
            String newDept = deptField.getText();
            JOptionPane.showMessageDialog(this, 
                "Profile updated: " + newName + " (" + newDept + ")", 
                "Settings Saved", JOptionPane.INFORMATION_MESSAGE);
                currentUser.setName(newName);
                
        });
        
        saveBtn.setAlignmentX(CENTER_ALIGNMENT);

        JPanel photoPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        photoPanel.setOpaque(false);
        Image avatarImg = loadImageSafe("assets_bilpoint/avatar.png");
        JLabel currentPhoto;
        if (avatarImg != null) {
            Image scaledAvatar = avatarImg.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
            currentPhoto = new JLabel(new ImageIcon(scaledAvatar));
        } else {
            currentPhoto = new JLabel("👤");
            currentPhoto.setFont(new Font("SansSerif", Font.PLAIN, 40));
        }
        currentPhoto.setBorder(new LineBorder(Color.GRAY, 1, true));
        currentPhoto.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        currentPhoto.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
                int result = fileChooser.showOpenDialog(AccountProfile.this);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    JOptionPane.showMessageDialog(AccountProfile.this, 
                        "New profile photo selected: " + selectedFile.getName() + "\n(Updating 'assets_bilpoint/avatar.png' simulated...)",
                        "Photo Updated", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        photoPanel.add(currentPhoto);
        photoPanel.add(new JLabel("<html><p style='width: 120px; font-size: 10px; color: gray;'>Click photo to update from computer</p></html>"));

        card.add(titleLbl);
        card.add(Box.createVerticalStrut(10));
        card.add(photoPanel);
        card.add(Box.createVerticalStrut(5));
        card.add(formPanel);
        card.add(Box.createVerticalStrut(10));
        card.add(saveBtn);

        return card;
    }

    private Image loadImageSafe(String path) {
        File file = new File(path);
        if (file.exists()) {
            return new ImageIcon(file.getAbsolutePath()).getImage();
        }
        return null;
    }
}
