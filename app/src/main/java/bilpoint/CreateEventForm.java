package bilpoint;

import javax.swing.*;
import java.awt.*;

public class CreateEventForm extends JDialog {
    private JTextField titleField;
    private JTextField locationNameField;
    private JSpinner quotaSpinner;
    private JComboBox<String> typeBox;
    private int coordX, coordY;
    private MapViewPanel parentMap;

    public CreateEventForm(int x, int y, MapViewPanel parentMap) {
        this.coordX = x;
        this.coordY = y;
        this.parentMap = parentMap;

        User user = parentMap.getCurrentUser();
        boolean isClubAdmin = user instanceof ClubAdmin;

        setTitle("Create New Meetup");
        setModal(true);
        setSize(400, 450);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JPanel header = new JPanel();
        header.setBackground(new Color(25, 42, 86));
        JLabel headerLabel = new JLabel("Event Details at (" + x + ", " + y + ")");
        headerLabel.setForeground(Color.WHITE);
        headerLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        header.add(headerLabel);

        JPanel inputPanel = new JPanel(new GridLayout(6, 1, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        titleField = new JTextField();
        locationNameField = new JTextField();

        quotaSpinner = new JSpinner(new SpinnerNumberModel(2, 2, 100, 1));

        String[] types = { "Private (Friends Only)", "Public (Global)" };
        typeBox = new JComboBox<>(types);

        if (!isClubAdmin) {
            typeBox.setSelectedItem("Private (Friends Only)");
            typeBox.setEnabled(false);
            quotaSpinner.setEnabled(true);
        } else {
            typeBox.setEnabled(true);
            quotaSpinner.setEnabled(true);
        }

        inputPanel.add(new JLabel("Event Title:"));
        inputPanel.add(titleField);
        inputPanel.add(new JLabel("Location Name:"));
        inputPanel.add(locationNameField);
        inputPanel.add(new JLabel("Quota:"));
        inputPanel.add(quotaSpinner);
        inputPanel.add(new JLabel("Event Type:"));
        inputPanel.add(typeBox);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton cancelBtn = new JButton("Cancel");
        JButton createBtn = new JButton("Create & Pin");
        createBtn.setBackground(new Color(46, 204, 113));
        createBtn.setForeground(Color.WHITE);

        createBtn.addActionListener(e -> handleCreate());
        cancelBtn.addActionListener(e -> dispose());

        buttonPanel.add(cancelBtn);
        buttonPanel.add(createBtn);

        add(header, BorderLayout.NORTH);
        add(inputPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void handleCreate() {
        String title = titleField.getText().trim();
        String location = locationNameField.getText().trim();
        int quota = (int) quotaSpinner.getValue();
        boolean isPrivate = typeBox.getSelectedIndex() == 0;
        String date = "08.04.2026";

        if (title.isEmpty() || location.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields!");
            return;
        }

        User currentUser = parentMap.getCurrentUser();
        Event newEvent;

        if (!isPrivate && currentUser instanceof ClubAdmin) {
            newEvent = new PublicEvent(currentUser, title, location, date, coordX, coordY, quota);
        } else {
            newEvent = new PrivateMeetup(currentUser, title, location, date, coordX, coordY, quota);
        }
        parentMap.addEvent(newEvent);
        dispose();
    }
}