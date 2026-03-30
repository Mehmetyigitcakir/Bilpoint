package bilpoint.ui;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private CardLayout cardLayout; // Ekranlar arası geçişi sağlar
    private JPanel contentArea;
    private SidebarPanel sidebar;
    private MapViewPanel mapView;

    public MainFrame() {
        // 1. Pencere Temel Ayarları
        setTitle("BilPoint - Campus Network");
        setSize(1280, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Ekranın ortasında açılır
        setLayout(new BorderLayout());

        // 2. İçerik Alanı (Harita, Arkadaşlar vb. buraya gelecek)
        cardLayout = new CardLayout();
        contentArea = new JPanel(cardLayout);
        
        // Panelleri Başlat
        sidebar = new SidebarPanel(this);
        mapView = new MapViewPanel();

        // Harita görünümünü içerik alanına "MAP_VIEW" ismiyle ekle
        contentArea.add(mapView, "MAP_VIEW");

        // 3. Ana Yerleşim: Sol Sidebar, Orta İçerik
        add(sidebar, BorderLayout.WEST);
        add(contentArea, BorderLayout.CENTER);
    }

    // Sidebar'daki butonlara basınca ekran değiştirmek için kullanacağız
    public void switchView(String viewName) {
        cardLayout.show(contentArea, viewName);
    }

    public static void main(String[] args) {
        // Uygulamayı "Swiss Spec" temizliğinde başlatalım
        SwingUtilities.invokeLater(() -> {
            new MainFrame().setVisible(true);
        });
    }
}
