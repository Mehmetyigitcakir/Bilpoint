package bilpoint.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MapViewPanel extends JPanel {
    private Image mapImage;
    private Image redPin;
    private Image greenPin;
    private ArrayList<MapPin> activePins; // Haritadaki mevcut iğneler

    public MapViewPanel() {
        // 1. Görselleri Yükle (Senin assets_bilpoint klasöründen)
        mapImage = new ImageIcon("assets_bilpoint/map.png").getImage();
        redPin = new ImageIcon("assets_bilpoint/red-pin.png").getImage();
        greenPin = new ImageIcon("assets_bilpoint/green-pin.png").getImage();
        
        activePins = new ArrayList<>();

        // 2. Haritaya Tıklama Olayı (Manuel Pinleme)
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Önce tıklanan yerde zaten bir pin var mı kontrol et (Detay göstermek için)
                for (MapPin pin : activePins) {
                    if (pin.isClicked(e.getX(), e.getY())) {
                        showEventDetails(pin);
                        return;
                    }
                }

                // Eğer boş yere tıklandıysa yeni pin oluşturma formunu aç
                int x = e.getX();
                int y = e.getY();
                createNewMeetup(x, y);
            }
        });
    }

    // 3. Haritayı ve Pinleri Çiz (Render)
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Arka plan harita fotoğrafını çiz
        g2d.drawImage(mapImage, 0, 0, getWidth(), getHeight(), this);

        // Kayıtlı tüm pinleri harita üzerine bas
        for (MapPin pin : activePins) {
            Image icon = pin.isPrivate() ? redPin : greenPin;
            // İğnenin ucunu tam tıklanan noktaya getirmek için (x-15, y-30) gibi ofset veriyoruz
            g2d.drawImage(icon, pin.getX() - 15, pin.getY() - 30, 30, 30, this);
            
            // Pin üzerine konumu/etkinliği yaz
            g2d.setColor(Color.BLACK);
            g2d.setFont(new Font("SansSerif", Font.BOLD, 12));
            g2d.drawString(pin.getTitle(), pin.getX() + 18, pin.getY() - 15);
        }
    }

    // 4. Yeni Etkinlik Oluşturma Formu (Koordinatları Otomatik Gönderir)
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
