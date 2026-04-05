
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class FriendsGroupsPanel extends JPanel {

    public FriendsGroupsPanel() {
        setLayout(new BorderLayout());
        setBackground(new Color(248, 250, 252));
        setBorder(BorderFactory.createEmptyBorder(25, 30, 25, 30));

        add(createHeaderPanel(), BorderLayout.NORTH);
        add(createContentPanel(), BorderLayout.CENTER);
    }

    private JPanel createHeaderPanel() {
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setOpaque(false);
        headerPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));

        JPanel titlePanel = new JPanel();
        titlePanel.setOpaque(false);
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("My Social Network");
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 30));
        titleLabel.setForeground(new Color(30, 41, 59));

        JLabel subLabel = new JLabel("Manage your friends, groups, and discover public clubs.");
        subLabel.setFont(new Font("SansSerif", Font.PLAIN, 15));
        subLabel.setForeground(new Color(100, 116, 139));

        titlePanel.add(titleLabel);
        titlePanel.add(Box.createVerticalStrut(5));
        titlePanel.add(subLabel);

        JTextField searchField = new JTextField("Search friends, groups or clubs...");
        searchField.setPreferredSize(new Dimension(260, 38));
        searchField.setFont(new Font("SansSerif", Font.PLAIN, 14));

        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 10));
        searchPanel.setOpaque(false);
        searchPanel.add(searchField);

        headerPanel.add(titlePanel, BorderLayout.WEST);
        headerPanel.add(searchPanel, BorderLayout.EAST);

        return headerPanel;
    }

    private JPanel createContentPanel() {
        JPanel content = new JPanel();
        content.setOpaque(false);
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));

        content.add(createSectionTitle("Suggested Friends"));
        content.add(Box.createVerticalStrut(12));

        JPanel friendsPanel = new JPanel(new GridLayout(1, 2, 15, 0));
        friendsPanel.setOpaque(false);
        friendsPanel.add(createFriendCard("Efe Öksüz", "CS Department", "5 mutual friends"));
        friendsPanel.add(createFriendCard("Arda Kaya", "IE Department", "3 mutual friends"));

        content.add(friendsPanel);
        content.add(Box.createVerticalStrut(30));

        content.add(createSectionTitle("Public Clubs & Organizations"));
        content.add(Box.createVerticalStrut(12));

        JPanel clubsPanel = new JPanel(new GridLayout(2, 2, 15, 15));
        clubsPanel.setOpaque(false);

        clubsPanel.add(createClubCard("Bilkent Computer Society", "Official Public Org • 240 Members"));
        clubsPanel.add(createClubCard("IEEE Bilkent", "Official Public Org • 310 Members"));
        clubsPanel.add(createClubCard("Theater Club", "Official Public Org • 120 Members"));
        clubsPanel.add(createClubCard("Music Society", "Official Public Org • 180 Members"));

        content.add(clubsPanel);

        return content;
    }

    private JLabel createSectionTitle(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("SansSerif", Font.BOLD, 22));
        label.setForeground(new Color(30, 41, 59));
        return label;
    }

    private JPanel createFriendCard(String name, String dept, String mutual) {
        JPanel card = new JPanel(new BorderLayout(15, 10));
        card.setBackground(Color.WHITE);
        card.setBorder(new CompoundBorder(
                new LineBorder(new Color(226, 232, 240), 1, true),
                new EmptyBorder(18, 18, 18, 18)
        ));
        card.setPreferredSize(new Dimension(320, 120));

        JLabel avatar = new JLabel("👤", SwingConstants.CENTER);
        avatar.setPreferredSize(new Dimension(55, 55));
        avatar.setFont(new Font("SansSerif", Font.PLAIN, 22));
        avatar.setOpaque(true);
        avatar.setBackground(new Color(219, 234, 254));
        avatar.setBorder(new LineBorder(new Color(191, 219, 254), 1, true));

        JPanel leftPanel = new JPanel(new BorderLayout(12, 0));
        leftPanel.setOpaque(false);
        leftPanel.add(avatar, BorderLayout.WEST);

        JPanel infoPanel = new JPanel();
        infoPanel.setOpaque(false);
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));

        JLabel nameLabel = new JLabel(name);
        nameLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        nameLabel.setForeground(new Color(30, 41, 59));

        JLabel deptLabel = new JLabel(dept);
        deptLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
        deptLabel.setForeground(new Color(100, 116, 139));

        JLabel mutualLabel = new JLabel(mutual);
        mutualLabel.setFont(new Font("SansSerif", Font.PLAIN, 13));
        mutualLabel.setForeground(new Color(34, 197, 94));

        infoPanel.add(nameLabel);
        infoPanel.add(Box.createVerticalStrut(4));
        infoPanel.add(deptLabel);
        infoPanel.add(Box.createVerticalStrut(6));
        infoPanel.add(mutualLabel);

        leftPanel.add(infoPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

        JButton profileBtn = new JButton("View Profile");
        styleLightButton(profileBtn);

        JButton requestBtn = new JButton("Send Request");
        styleDarkButton(requestBtn);

        buttonPanel.add(profileBtn);
        buttonPanel.add(Box.createVerticalStrut(8));
        buttonPanel.add(requestBtn);

        card.add(leftPanel, BorderLayout.CENTER);
        card.add(buttonPanel, BorderLayout.EAST);

        return card;
    }

    private JPanel createClubCard(String title, String details) {
        JPanel card = new JPanel(new BorderLayout(15, 10));
        card.setBackground(Color.WHITE);
        card.setBorder(new CompoundBorder(
                new LineBorder(new Color(220, 252, 231), 1, true),
                new EmptyBorder(18, 18, 18, 18)
        ));

        JLabel icon = new JLabel("◎", SwingConstants.CENTER);
        icon.setPreferredSize(new Dimension(45, 45));
        icon.setFont(new Font("SansSerif", Font.BOLD, 20));
        icon.setForeground(new Color(16, 185, 129));

        JPanel infoPanel = new JPanel();
        infoPanel.setOpaque(false);
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        titleLabel.setForeground(new Color(30, 41, 59));

        JLabel detailsLabel = new JLabel(details);
        detailsLabel.setFont(new Font("SansSerif", Font.PLAIN, 13));
        detailsLabel.setForeground(new Color(100, 116, 139));

        infoPanel.add(titleLabel);
        infoPanel.add(Box.createVerticalStrut(6));
        infoPanel.add(detailsLabel);

        JButton joinBtn = new JButton("Join Club");
        joinBtn.setBackground(new Color(16, 185, 129));
        joinBtn.setForeground(Color.WHITE);
        joinBtn.setFocusPainted(false);
        joinBtn.setFont(new Font("SansSerif", Font.BOLD, 13));
        joinBtn.setBorder(BorderFactory.createEmptyBorder(8, 14, 8, 14));

        JPanel leftPanel = new JPanel(new BorderLayout(12, 0));
        leftPanel.setOpaque(false);
        leftPanel.add(icon, BorderLayout.WEST);
        leftPanel.add(infoPanel, BorderLayout.CENTER);

        card.add(leftPanel, BorderLayout.CENTER);
        card.add(joinBtn, BorderLayout.EAST);

        return card;
    }

    private void styleLightButton(JButton button) {
        button.setFocusPainted(false);
        button.setBackground(new Color(241, 245, 249));
        button.setForeground(new Color(30, 41, 59));
        button.setFont(new Font("SansSerif", Font.BOLD, 13));
        button.setBorder(BorderFactory.createEmptyBorder(8, 12, 8, 12));
    }

    private void styleDarkButton(JButton button) {
        button.setFocusPainted(false);
        button.setBackground(new Color(30, 64, 175));
        button.setForeground(Color.WHITE);
        button.setFont(new Font("SansSerif", Font.BOLD, 13));
        button.setBorder(BorderFactory.createEmptyBorder(8, 12, 8, 12));
    }
}