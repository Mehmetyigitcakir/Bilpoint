package bilpoint;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MapViewPanel extends JPanel {
    private Image mapImage;
    private Image redPin;
    private Image greenPin;
    private ArrayList<Event> activeEvents;
    private User currentUser;
    private MainFrame mainFrame;

    public MapViewPanel(User currentUser, MainFrame mainFrame) {

        mapImage = new ImageIcon("assets_bilpoint/map.png").getImage();
        redPin = new ImageIcon("assets_bilpoint/red-pin.png").getImage();
        greenPin = new ImageIcon("assets_bilpoint/green-pin.png").getImage();
        this.currentUser = currentUser;
        activeEvents = new ArrayList<>();
        this.mainFrame = mainFrame;

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                for (Event event : activeEvents) {
                    if (Math.abs(e.getX() - event.getX()) < 20 && Math.abs(e.getY() - event.getY()) < 30) {
                        showEventDetails(event);
                        return;
                    }
                }
                createNewMeetup(e.getX(), e.getY());
            }
        });
    }
    public void addEvent(Event newEvent) {
        activeEvents.add(newEvent);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.drawImage(mapImage, 0, 0, getWidth(), getHeight(), this);

        for (Event event : activeEvents) {
        Image icon = (event instanceof PrivateMeetup) ? redPin : greenPin;
        g2d.drawImage(icon, event.getX() - 15, event.getY() - 30, 30, 30, this);
        
        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("SansSerif", Font.BOLD, 12));
        g2d.drawString(event.getTitle(), event.getX() + 18, event.getY() - 15);
    }
    }

    private void createNewMeetup(int x, int y) {
        CreateEventForm form = new CreateEventForm(x, y, this);
        form.setVisible(true);
    }

    private void showEventDetails(Event event) {
    String details = "Event: " + event.getTitle() + 
                     "\nLocation: " + event.getLocation() + 
                     "\nHost: " + event.getHost().getName();

    boolean isOwner = event.getHost().equals(currentUser);
    String[] options;
    if (isOwner) {
        options = new String[]{"Close", "Go to Chat", "Delete My Event"};
    } else {
        options = new String[]{"Close", "Join & Chat"};
    }

    int choice = JOptionPane.showOptionDialog(
        this, 
        details, 
        "Event Details",
        JOptionPane.DEFAULT_OPTION, 
        JOptionPane.INFORMATION_MESSAGE, 
        null, 
        options, 
        options[0]
    );

    if (isOwner) {
        if (choice == 1) {
            openChat(event);
        } else if (choice == 2) { 
            int confirm = JOptionPane.showConfirmDialog(this, "Are you sure?");
            if (confirm == JOptionPane.YES_OPTION) {
                activeEvents.remove(event); 
                repaint(); 
            }
        }
    } else {
        if (choice == 1) {
            openChat(event);
        }
    }
}

    public User getCurrentUser() {
        return currentUser;
    }
    private void openChat(Event event) {
    if (event != null && event.getChatSession() != null) {
         mainFrame.switchToChat(event); 
    }
}

}
