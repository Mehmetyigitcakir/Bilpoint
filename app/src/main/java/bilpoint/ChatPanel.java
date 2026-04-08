package bilpoint;

import javax.swing.*;
import java.awt.*;
import java.util.List;

    public class ChatPanel extends JPanel {
    private ChatSession session;
    private User currentUser;
    private Event event; 
    private JPanel messageContainer;
    private JScrollPane scrollPane;
    private JTextField inputField;
    private MainFrame mainFrame; 

    public ChatPanel(ChatSession session, User currentUser, Event event, MainFrame mainFrame) {
        this.session = session;
        this.currentUser = currentUser;
        this.event = event;
        this.mainFrame = mainFrame;
        
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

    
        setupHeader();
        messageContainer = new JPanel();
        messageContainer.setLayout(new BoxLayout(messageContainer, BoxLayout.Y_AXIS));
        messageContainer.setBackground(new Color(245, 246, 250));

        scrollPane = new JScrollPane(messageContainer);
        scrollPane.setBorder(null);
        add(scrollPane, BorderLayout.CENTER);
        setupInputArea();

        refreshMessages();
    }

    private void setupHeader() {
        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(new Color(25, 42, 86));
        header.setPreferredSize(new Dimension(0, 60));
        header.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));

        JPanel leftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        leftPanel.setOpaque(false);
        
        JButton backBtn = new JButton("←");
        backBtn.addActionListener(e -> mainFrame.switchToMap());
        
        JLabel titleLabel = new JLabel(event.getTitle());
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        
        leftPanel.add(backBtn);
        leftPanel.add(titleLabel);

        JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        rightPanel.setOpaque(false);
        
        int personCount = event.getUserList().size();
        JButton personBtn = new JButton("👥 " + personCount);
        personBtn.addActionListener(e -> showParticipants());

        rightPanel.add(personBtn);

        header.add(leftPanel, BorderLayout.WEST);
        header.add(rightPanel, BorderLayout.EAST);
        add(header, BorderLayout.NORTH);
    }

    private void setupInputArea() {
        JPanel inputPanel = new JPanel(new BorderLayout(10, 0));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        inputPanel.setBackground(Color.WHITE);
        
        inputField = new JTextField();
        inputField.setFont(new Font("SansSerif", Font.PLAIN, 14));
        
        JButton sendBtn = new JButton("Send");
        sendBtn.setBackground(new Color(46, 204, 113));
        sendBtn.setForeground(Color.WHITE);
        sendBtn.setFocusPainted(false);

        inputPanel.add(inputField, BorderLayout.CENTER);
        inputPanel.add(sendBtn, BorderLayout.EAST);
        add(inputPanel, BorderLayout.SOUTH);

        sendBtn.addActionListener(e -> sendMessage());
        inputField.addActionListener(e -> sendMessage());
    }

    private void showParticipants() {
        StringBuilder sb = new StringBuilder("Participants In This Event:\n\n");
        for (User u : event.getUserList()) {
            sb.append("• ").append(u.getName()).append(u.equals(event.getHost()) ? " (Host)" : "").append("\n");
        }
        JOptionPane.showMessageDialog(this, sb.toString(), "Group Members", JOptionPane.PLAIN_MESSAGE);
    }

    private void sendMessage() {
        String text = inputField.getText().trim();
        if (!text.isEmpty()) {
            session.addMessage(text, currentUser);
            inputField.setText("");
            refreshMessages();
        }
    }

    public void refreshMessages() {
        messageContainer.removeAll();
        List<Message> messages = session.getMessages();

        for (Message m : messages) {
            boolean isMine = m.getSenderID().equals(currentUser.getID());
            addMessageBubble(m.getContent(), isMine);
        }

        messageContainer.revalidate();
        messageContainer.repaint();
        SwingUtilities.invokeLater(() -> {
            JScrollBar vertical = scrollPane.getVerticalScrollBar();
            vertical.setValue(vertical.getMaximum());
        });
    }

private void addMessageBubble(String text, boolean isMine) {
    JPanel line = new JPanel();
    line.setLayout(new BoxLayout(line, BoxLayout.X_AXIS));
    line.setOpaque(false);
    
    line.setMaximumSize(new Dimension(Integer.MAX_VALUE, 60)); 

    JLabel label = new JLabel("<html><body style='width: 200px; padding: 5px;'>" + text + "</body></html>");
    label.setOpaque(true);
    label.setBorder(BorderFactory.createEmptyBorder(8, 12, 8, 12));
    
    label.setMaximumSize(label.getPreferredSize());

    if (isMine) {
        line.add(Box.createHorizontalGlue()); 
        label.setBackground(new Color(46, 204, 113)); 
        label.setForeground(Color.WHITE);
        line.add(label);
        line.add(Box.createRigidArea(new Dimension(15, 0))); 
    } else {
        line.add(Box.createRigidArea(new Dimension(15, 0)));
        label.setBackground(new Color(220, 221, 225)); 
        label.setForeground(Color.BLACK);
        line.add(label);
        line.add(Box.createHorizontalGlue()); 
    }

    messageContainer.add(line);
    messageContainer.add(Box.createVerticalStrut(10)); 
}
}