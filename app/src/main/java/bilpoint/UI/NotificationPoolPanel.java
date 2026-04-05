

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

public class NotificationPoolPanel extends JPanel {

    public NotificationPoolPanel() {
        setLayout(new BorderLayout());
        setBackground(new Color(245, 247, 250));
        setBorder(BorderFactory.createEmptyBorder(25, 30, 25, 30));

        add(createHeaderPanel(), BorderLayout.NORTH);
        add(createNotificationList(), BorderLayout.CENTER);
    }

    private JPanel createHeaderPanel() {
        JPanel header = new JPanel(new BorderLayout());
        header.setOpaque(false);
        header.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));

        JPanel left = new JPanel();
        left.setOpaque(false);
        left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("Notification Center");
        title.setFont(new Font("SansSerif", Font.BOLD, 34));
        title.setForeground(new Color(30, 41, 59));

        JLabel subtitle = new JLabel("Your aggregated pending meetup requests, friend requests, and system updates.");
        subtitle.setFont(new Font("SansSerif", Font.PLAIN, 18));
        subtitle.setForeground(new Color(100, 116, 139));

        left.add(title);
        left.add(Box.createVerticalStrut(6));
        left.add(subtitle);

        JButton markAllBtn = new JButton("Mark all as read");
        markAllBtn.setFocusPainted(false);
        markAllBtn.setBorderPainted(false);
        markAllBtn.setContentAreaFilled(false);
        markAllBtn.setFont(new Font("SansSerif", Font.BOLD, 16));
        markAllBtn.setForeground(new Color(51, 65, 85));

        JPanel right = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 20));
        right.setOpaque(false);
        right.add(markAllBtn);

        header.add(left, BorderLayout.WEST);
        header.add(right, BorderLayout.EAST);

        return header;
    }

    private JPanel createNotificationList() {
        JPanel listPanel = new JPanel();
        listPanel.setOpaque(false);
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));

        listPanel.add(createNotificationCard(
                "📍",
                new Color(238, 242, 255),
                "New Meetup Invitation: \"Library Study Session\"",
                "Efe Öksüz invited you to a private meetup at the Main Campus Library.",
                "Quota: 2/4 Joined    •    5 mins ago",
                "Decline",
                "Accept Invite"
        ));

        listPanel.add(Box.createVerticalStrut(16));

        listPanel.add(createNotificationCard(
                "👥",
                new Color(220, 252, 231),
                "Friend Request",
                "Nazım Yavuz sent you a friend request. (Suggested via Pathfinder: 3 Mutual Friends)",
                "1 hour ago",
                "Ignore",
                "Accept"
        ));

        listPanel.add(Box.createVerticalStrut(16));

        listPanel.add(createNotificationCard(
                "📢",
                new Color(254, 249, 195),
                "Public Event Update",
                "Bilkent Computer Society pinned a new global event on the map: \"Spring Tech Seminar\".",
                "Visible to all users    •    2 hours ago",
                "Dismiss",
                "View on Map"
        ));

        return listPanel;
    }

    private JPanel createNotificationCard(String iconText, Color iconBg, String titleText,
                                          String messageText, String metaText,
                                          String leftButtonText, String rightButtonText) {

        JPanel card = new JPanel(new BorderLayout(20, 0));
        card.setBackground(Color.WHITE);
        card.setMaximumSize(new Dimension(Integer.MAX_VALUE, 115));
        card.setPreferredSize(new Dimension(850, 115));
        card.setBorder(new CompoundBorder(
                new MatteBorder(0, 4, 0, 0, new Color(239, 68, 68)),
                new CompoundBorder(
                        new LineBorder(new Color(226, 232, 240), 1, true),
                        new EmptyBorder(16, 16, 16, 16)
                )
        ));

        JPanel leftSection = new JPanel(new BorderLayout(15, 0));
        leftSection.setOpaque(false);

        JLabel iconLabel = new JLabel(iconText, SwingConstants.CENTER);
        iconLabel.setPreferredSize(new Dimension(42, 42));
        iconLabel.setOpaque(true);
        iconLabel.setBackground(iconBg);
        iconLabel.setFont(new Font("SansSerif", Font.PLAIN, 18));

        JPanel textPanel = new JPanel();
        textPanel.setOpaque(false);
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(titleText);
        title.setFont(new Font("SansSerif", Font.BOLD, 16));
        title.setForeground(new Color(30, 41, 59));

        JLabel message = new JLabel("<html><div style='width:430px;'>" + messageText + "</div></html>");
        message.setFont(new Font("SansSerif", Font.PLAIN, 14));
        message.setForeground(new Color(100, 116, 139));

        JLabel meta = new JLabel(metaText);
        meta.setFont(new Font("SansSerif", Font.PLAIN, 13));
        meta.setForeground(new Color(107, 114, 128));

        textPanel.add(title);
        textPanel.add(Box.createVerticalStrut(5));
        textPanel.add(message);
        textPanel.add(Box.createVerticalStrut(8));
        textPanel.add(meta);

        leftSection.add(iconLabel, BorderLayout.WEST);
        leftSection.add(textPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 20));
        buttonPanel.setOpaque(false);

        JButton leftBtn = new JButton(leftButtonText);
        styleLightButton(leftBtn);

        JButton rightBtn = new JButton(rightButtonText);
        styleDarkButton(rightBtn);

        buttonPanel.add(leftBtn);
        buttonPanel.add(rightBtn);

        card.add(leftSection, BorderLayout.CENTER);
        card.add(buttonPanel, BorderLayout.EAST);

        return card;
    }

    private void styleLightButton(JButton button) {
        button.setFocusPainted(false);
        button.setFont(new Font("SansSerif", Font.BOLD, 14));
        button.setBackground(new Color(241, 245, 249));
        button.setForeground(new Color(51, 65, 85));
        button.setBorder(BorderFactory.createEmptyBorder(10, 18, 10, 18));
    }

    private void styleDarkButton(JButton button) {
        button.setFocusPainted(false);
        button.setFont(new Font("SansSerif", Font.BOLD, 14));
        button.setBackground(new Color(30, 64, 175));
        button.setForeground(Color.WHITE);
        button.setBorder(BorderFactory.createEmptyBorder(10, 18, 10, 18));
    }
}
