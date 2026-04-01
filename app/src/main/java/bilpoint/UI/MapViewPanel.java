package bilpoint.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MapViewPanel extends JPanel {
    private Image mapImage;
    private Image redPin;
    private Image greenPin;
    private ArrayList<MapPin> activePins; 

    public MapViewPanel() {
        
        mapImage = new ImageIcon("assets_bilpoint/map.png").getImage();
        redPin = new ImageIcon("assets_bilpoint/red-pin.png").getImage();
        greenPin = new ImageIcon("assets_bilpoint/green-pin.png").getImage();
        
        activePins = new ArrayList<>();

        
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
                for (MapPin pin : activePins) {
                    if (pin.isClicked(e.getX(), e.getY())) {
                        showEventDetails(pin);
                        return;
                    }
                }

                
                int x = e.getX();
                int y = e.getY();
                createNewMeetup(x, y);
            }
        });
    }

    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        
        g2d.drawImage(mapImage, 0, 0, getWidth(), getHeight(), this);

        
        for (MapPin pin : activePins) {
            Image icon = pin.isPrivate() ? redPin : greenPin;
            
            g2d.drawImage(icon, pin.getX() - 15, pin.getY() - 30, 30, 30, this);
            
            
            g2d.setColor(Color.BLACK);
            g2d.setFont(new Font("SansSerif", Font.BOLD, 12));
            g2d.drawString(pin.getTitle(), pin.getX() + 18, pin.getY() - 15);
        }
    }

    
    private void createNewMeetup(int x, int y) {
        CreateEventForm form = new CreateEventForm(x, y, this);
        form.setVisible(true);
    }

    private void showEventDetails(MapPin pin) {
        JOptionPane.showMessageDialog(this, 
            "Konum: " + pin.getTitle() + "\nKatman: " + (pin.isPrivate() ? "Private" : "Public"),
            "Event Details", JOptionPane.INFORMATION_MESSAGE);
    }
}
