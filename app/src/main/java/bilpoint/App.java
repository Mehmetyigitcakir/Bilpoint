package bilpoint;

import javax.swing.SwingUtilities;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> { 
            User testUser = new Student("abc", "Tester", "test@ug.bilkent.edu.tr", "CS");
            MainFrame frame = new MainFrame(testUser);
            frame.setVisible(true);
        });
    }
}