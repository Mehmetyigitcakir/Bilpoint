package bilpoint.ui;

import javax.swing.*;
import java.awt.*;

public class SidebarPanel extends JPanel {
    private MainFrame parent;

    public SidebarPanel(MainFrame parent) {
        this.parent = parent;
        
        // 1. Sidebar Genel Tasarımı (Koyu Lacivert/Gri Tonu)
        setBackground(new Color(245, 247, 250)); // Taslaklardaki açık tema veya koyu istersen Color(30, 45, 65)
        setPreferredSize(new Dimension(260, 800));
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, new Color(220, 225, 230)));

        // 2. Üst Kısım: Profil Paneli (Avatar + İsim + Bölüm)
        JPanel profileContainer = new JPanel();
        profileContainer.setOpaque(false);
        profileContainer.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 25));

        // Avatar yükleme (assets_bilpoint klasöründen)
        ImageIcon avatarIcon = new ImageIcon("assets_bilpoint/avatar.png");
        Image scaledAvatar = avatarIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        JLabel avatarLabel = new JLabel(new ImageIcon(scaledAvatar));

        // İsim ve Bölüm Yazıları
        JPanel textInfo = new JPanel();
        textInfo.setOpaque(false);
        textInfo.setLayout(new GridLayout(2, 1));
        
        JLabel nameLabel = new JLabel("Efe Öksüz");
        nameLabel.setFont(new Font("SansSerif", Font.BOLD, 15));
        
        JLabel deptLabel = new JLabel("CS Dept");
        deptLabel.setFont(new Font("SansSerif", Font.PLAIN, 12));
        deptLabel.setForeground(Color.GRAY);

        textInfo.add(nameLabel);
        textInfo.add(deptLabel);

        profileContainer.add(avatarLabel);
        profileContainer.add(textInfo);

        // 3. Orta Kısım: Navigasyon Butonları
        JPanel navPanel = new JPanel();
        navPanel.setOpaque(false);
        navPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));

        // Raporundaki 3 ana buton [cite: 275]
        JButton mapBtn = createNavButton("📍 Map Interface", true);
        JButton friendsBtn = createNavButton("👥 Friends & Groups", false);
        JButton inboxBtn = createNavButton("📥 Inbox (Pool)", false);

        // Harita butonuna basınca MainFrame'deki görünümü değiştir
        mapBtn.addActionListener(e -> parent.switchView("MAP_VIEW"));

        navPanel.add(mapBtn);
        navPanel.add(friendsBtn);
        navPanel.add(inboxBtn);

        // 4. Alt Kısım: Create Meetup Butonu 
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 20));
        bottomPanel.setOpaque(false);
        
        JButton createBtn = new JButton("+ Create Meetup");
        createBtn.setPreferredSize(new Dimension(210, 45));
        createBtn.setBackground(new Color(25, 42, 86)); // Koyu mavi
        createBtn.setForeground(Color.WHITE);
        createBtn.setFocusPainted(false);
        createBtn.setFont(new Font("SansSerif", Font.BOLD, 14));
        createBtn.setBorder(BorderFactory.createEmptyBorder());

        bottomPanel.add(createBtn);

        // Elemanları Sidebar'a yerleştir
        add(profileContainer, BorderLayout.NORTH);
        add(navPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    // Modern görünümlü buton oluşturma yardımcısı
    private JButton createNavButton(String text, boolean isActive) {
        JButton btn = new JButton(text);
        btn.setPreferredSize(new Dimension(230, 45));
        btn.setHorizontalAlignment(SwingConstants.LEFT);
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setFont(new Font("SansSerif", Font.MEDIUM, 14));

        if (isActive) {
            btn.setBackground(new Color(230, 240, 255)); // Aktif buton rengi
            btn.setForeground(new Color(25, 42, 86));
        } else {
            btn.setBackground(Color.WHITE);
            btn.setForeground(new Color(100, 110, 130));
        }
        
        return btn;
    }
}
