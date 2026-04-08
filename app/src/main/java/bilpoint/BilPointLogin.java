package bilpoint;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import javax.swing.*;
import javax.swing.border.*;

public class BilPointLogin extends JFrame {


private static final Color NAVY      = new Color(10, 22, 40);
private static final Color BLUE      = new Color(26, 58, 107);
private static final Color ACCENT    = new Color(30, 77, 183);
private static final Color WHITE     = Color.WHITE;
private static final Color MUTED     = new Color(107, 114, 128);
private static final Color BG        = new Color(248, 249, 252);
private static final Color BORDER_C  = new Color(229, 231, 235);
private static final Color INPUT_BG  = new Color(255, 255, 255);


private static final Font FONT_BOLD  = new Font("SansSerif", Font.BOLD, 13);
private static final Font FONT_REG   = new Font("SansSerif", Font.PLAIN, 12);
private static final Font FONT_TITLE = new Font("SansSerif", Font.BOLD, 20);
private static final Font FONT_LOGO  = new Font("SansSerif", Font.BOLD, 22);


private JTextField     emailField;
private JPasswordField passField;
private JToggleButton  adminToggle;
private JButton        signInBtn;

private JButton signInTab;    
private JButton registerTab; 

private JTextField     regNameField;
private JTextField     regEmailField;
private JPasswordField regPassField;
private JPasswordField regConfirmField;

private CardLayout cardLayout;
private JPanel     cardPanel;

public BilPointLogin() {
    setTitle("BilPoint – Login");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setResizable(false);
    setLayout(new BorderLayout());

    add(buildLeftPanel(),  BorderLayout.WEST);
    add(buildRightPanel(), BorderLayout.CENTER);

    pack();
    setLocationRelativeTo(null);
    setVisible(true);
}


private JPanel buildLeftPanel() {
    JPanel panel = new JPanel() {
        @Override protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            GradientPaint gp = new GradientPaint(0, 0, BLUE, 0, getHeight(), NAVY);
            g2.setPaint(gp);
            g2.fillRect(0, 0, getWidth(), getHeight());
            g2.setColor(new Color(255, 255, 255, 15));
            g2.fillOval(getWidth() - 160, getHeight() - 160, 240, 240);
            g2.dispose();
        }
    };
    panel.setPreferredSize(new Dimension(300, 600));
    panel.setLayout(new BorderLayout());
    panel.setBorder(new EmptyBorder(44, 30, 28, 30));

    JLabel logo = new JLabel("◧  BilPoint");
    logo.setFont(FONT_LOGO);
    logo.setForeground(WHITE);

    JTextArea desc = new JTextArea(
        "A location-based and secure campus social coordination " +
        "platform designed exclusively for Bilkent University students and clubs.");
    desc.setFont(FONT_REG);
    desc.setForeground(new Color(255, 255, 255, 160));
    desc.setOpaque(false);
    desc.setEditable(false);
    desc.setLineWrap(true);
    desc.setWrapStyleWord(true);
    desc.setBorder(new EmptyBorder(14, 0, 0, 0));

    JPanel top = new JPanel(new BorderLayout());
    top.setOpaque(false);
    top.add(logo, BorderLayout.NORTH);
    top.add(desc, BorderLayout.CENTER);

    JLabel footer = new JLabel("© 2026 BilPoint Team. All rights reserved.");
    footer.setFont(new Font("SansSerif", Font.PLAIN, 10));
    footer.setForeground(new Color(255, 255, 255, 80));

    panel.add(top,    BorderLayout.NORTH);
    panel.add(footer, BorderLayout.SOUTH);
    return panel;
}


private JPanel buildRightPanel() {
    JPanel panel = new JPanel(new BorderLayout());
    panel.setBackground(WHITE);
    panel.setPreferredSize(new Dimension(490, 500));
    panel.setBorder(new EmptyBorder(32, 42, 32, 42));

  
     signInTab   = new JButton("Sign In");
     registerTab = new JButton("Create Account");
    styleTab(signInTab, true);
    styleTab(registerTab, false);

    JPanel tabBar = new JPanel(new GridLayout(1, 2));
    tabBar.setBorder(new LineBorder(BORDER_C, 1, true));
    tabBar.setPreferredSize(new Dimension(0, 38));
    tabBar.setBackground(WHITE);
    tabBar.add(signInTab);
    tabBar.add(registerTab);


    cardLayout = new CardLayout();
    cardPanel  = new JPanel(cardLayout);
    cardPanel.setBackground(WHITE);
    cardPanel.add(buildSignInPanel(),   "signin");
    cardPanel.add(buildRegisterPanel(), "register");

    signInTab.addActionListener(e -> {
        styleTab(signInTab, true);
        styleTab(registerTab, false);
        cardLayout.show(cardPanel, "signin");
    });
    registerTab.addActionListener(e -> {
        styleTab(registerTab, true);
        styleTab(signInTab, false);
        cardLayout.show(cardPanel, "register");
    });

    panel.add(tabBar,     BorderLayout.NORTH);
    panel.add(cardPanel,  BorderLayout.CENTER);
    return panel;
}

private void styleTab(JButton btn, boolean active) {
    btn.setFont(FONT_BOLD);
    btn.setFocusPainted(false);
    btn.setBorderPainted(false);
    btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    btn.setBackground(active ? ACCENT : WHITE);
    btn.setForeground(active ? WHITE  : MUTED);
}

private JPanel buildSignInPanel() {
    JPanel panel = new JPanel();
    panel.setBackground(WHITE);
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    panel.setBorder(new EmptyBorder(20, 0, 0, 0));

    JLabel heading = new JLabel("Welcome Back! 👋");
    heading.setFont(FONT_TITLE);
    heading.setAlignmentX(LEFT_ALIGNMENT);

    JLabel sub = new JLabel("Enter your details to connect to the BilPoint network.");
    sub.setFont(FONT_REG);
    sub.setForeground(MUTED);
    sub.setAlignmentX(LEFT_ALIGNMENT);


    JLabel emailLbl = makeLabel("Bilkent Email");
    emailField = new JTextField();
    emailField.setFont(FONT_REG);
    styleInput(emailField);

    JLabel domainLbl = new JLabel("@ug.bilkent.edu.tr");
    domainLbl.setFont(new Font("Monospaced", Font.PLAIN, 12));
    domainLbl.setForeground(MUTED);
    domainLbl.setBorder(new CompoundBorder(
        new LineBorder(BORDER_C, 1, true),
        new EmptyBorder(0, 10, 0, 10)));
    domainLbl.setOpaque(true);
    domainLbl.setBackground(new Color(243, 244, 246));

    JPanel emailRow = new JPanel(new BorderLayout(6, 0));
    emailRow.setBackground(WHITE);
    emailRow.setMaximumSize(new Dimension(Integer.MAX_VALUE, 36));
    emailRow.setAlignmentX(LEFT_ALIGNMENT);
    emailRow.add(emailField, BorderLayout.CENTER);
    emailRow.add(domainLbl, BorderLayout.EAST);

    JLabel passLbl = makeLabel("Password");
    passField = new JPasswordField();
    passField.setFont(FONT_REG);
    styleInput(passField);

    JButton forgotBtn = new JButton("Forgot Password?");
    forgotBtn.setFont(new Font("SansSerif", Font.PLAIN, 12));
    forgotBtn.setForeground(ACCENT);
    forgotBtn.setContentAreaFilled(false);
    forgotBtn.setBorderPainted(false);
    forgotBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    forgotBtn.setAlignmentX(LEFT_ALIGNMENT); // Sola hizalarsan daha düzenli durur

    signInBtn = makeButton("Sign In");
signInBtn.addActionListener(e -> {
    String emailPrefix = emailField.getText().trim(); 
    String fullEmail = emailPrefix + "@ug.bilkent.edu.tr"; 
    String password = new String(passField.getPassword());
    User authenticatedUser = SystemController.getInstance().loginUser(fullEmail, password);
    if (authenticatedUser != null) {
        this.dispose();
        new MainFrame(authenticatedUser).setVisible(true);
    } else {
        JOptionPane.showMessageDialog(this, "Invalid email or password!", "Login Error", JOptionPane.ERROR_MESSAGE);
    }
});
    panel.add(heading);
    panel.add(Box.createVerticalStrut(4));
    panel.add(sub);
    panel.add(Box.createVerticalStrut(20));
    panel.add(emailLbl);
    panel.add(Box.createVerticalStrut(5));
    panel.add(emailRow);
    panel.add(Box.createVerticalStrut(12));
    panel.add(passLbl);
    panel.add(Box.createVerticalStrut(5));
    panel.add(passField);
    panel.add(forgotBtn);
    panel.add(Box.createVerticalStrut(15));
    panel.add(signInBtn);

    return panel;
}

private JPanel buildRegisterPanel() {
    JPanel panel = new JPanel();
    panel.setBackground(WHITE);
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    panel.setBorder(new EmptyBorder(20, 0, 0, 0));

    JLabel heading = new JLabel("Create Account 🎓");
    heading.setFont(FONT_TITLE);
    heading.setAlignmentX(LEFT_ALIGNMENT);

    JLabel sub = new JLabel("Join the BilPoint network with your Bilkent email.");
    sub.setFont(FONT_REG);
    sub.setForeground(MUTED);
    sub.setAlignmentX(LEFT_ALIGNMENT);

    JLabel nameLbl = makeLabel("Full Name");
    regNameField = new JTextField();
    regNameField.setFont(FONT_REG);
    styleInput(regNameField);

    JLabel emailLbl = makeLabel("Bilkent Email");
    regEmailField = new JTextField();
    regEmailField.setFont(FONT_REG);
    styleInput(regEmailField);

    String[] departments = {"CS", "EE", "ME", "IE", "LAW", "ECON", "BA", "ARCH"};
    JComboBox<String> deptCombo = new JComboBox<>(departments);
    styleInput(deptCombo);

    JLabel domainLbl = new JLabel("@ug.bilkent.edu.tr");
    domainLbl.setFont(new Font("Monospaced", Font.PLAIN, 12));
    domainLbl.setForeground(MUTED);
    domainLbl.setBorder(new CompoundBorder(
        new LineBorder(BORDER_C, 1, true),
        new EmptyBorder(0, 10, 0, 10)));
    domainLbl.setOpaque(true);
    domainLbl.setBackground(new Color(243, 244, 246));

    JPanel emailRow = new JPanel(new BorderLayout(6, 0));
    emailRow.setBackground(WHITE);
    emailRow.setMaximumSize(new Dimension(Integer.MAX_VALUE, 36));
    emailRow.setAlignmentX(LEFT_ALIGNMENT);
    emailRow.add(regEmailField, BorderLayout.CENTER);
    emailRow.add(domainLbl,     BorderLayout.EAST);

    JLabel passLbl = makeLabel("Password");
    regPassField = new JPasswordField();
    regPassField.setFont(FONT_REG);
    styleInput(regPassField);

    JLabel confirmLbl = makeLabel("Confirm Password");
    regConfirmField = new JPasswordField();
    regConfirmField.setFont(FONT_REG);
    styleInput(regConfirmField);

    String[] userTypes = {"Student", "Club Admin"};
    JComboBox<String> typeCombo = new JComboBox<>(userTypes);
    styleInput(typeCombo);

    JButton regBtn = makeButton("Create Account");
regBtn.addActionListener(e -> {
    String name = regNameField.getText().trim();
    String emailPrefix = regEmailField.getText().trim();
    String fullEmail = emailPrefix + "@ug.bilkent.edu.tr"; 
    String selectedDept = (String) deptCombo.getSelectedItem();

    String password = new String(regPassField.getPassword());
    String confirmPass = new String(regConfirmField.getPassword());
    int selectedType = typeCombo.getSelectedIndex(); // 0: Student, 1: Club Admin

    if (name.isEmpty() || emailPrefix.isEmpty() || password.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please fill in all fields!", "Error", JOptionPane.WARNING_MESSAGE);
        return;
    }

    if (!password.equals(confirmPass)) {
        JOptionPane.showMessageDialog(this, "Passwords do not match!", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    boolean isRegistered = SystemController.getInstance().register(name, fullEmail, password, selectedDept, selectedType);

    if (isRegistered) {
        JOptionPane.showMessageDialog(this, "Registration Successful! You can now login.");
        switchToSignIn();
    } else {
        JOptionPane.showMessageDialog(this, "Registration Failed! This email might be taken.");
    }
});

    panel.add(heading);
    panel.add(Box.createVerticalStrut(4));
    panel.add(sub);
    panel.add(Box.createVerticalStrut(14));
    panel.add(nameLbl);
    panel.add(Box.createVerticalStrut(5));
    panel.add(regNameField);
    panel.add(Box.createVerticalStrut(10));
    panel.add(emailLbl);
    panel.add(Box.createVerticalStrut(5));
    panel.add(emailRow);
    panel.add(Box.createVerticalStrut(10));
    panel.add(passLbl);
    panel.add(Box.createVerticalStrut(5));
    panel.add(regPassField);
    panel.add(Box.createVerticalStrut(10));
    panel.add(confirmLbl);
    panel.add(Box.createVerticalStrut(5));
    panel.add(regConfirmField);
    panel.add(Box.createVerticalStrut(10));
    panel.add(makeLabel("Account Type"));
    panel.add(typeCombo);
    panel.add(Box.createVerticalStrut(5));
    panel.add(deptCombo); 
    panel.add(Box.createVerticalStrut(14));
    panel.add(regBtn); 
    return panel;
}


private JLabel makeLabel(String text) {
    JLabel lbl = new JLabel(text);
    lbl.setFont(FONT_BOLD);
    lbl.setAlignmentX(LEFT_ALIGNMENT);
    return lbl;
}

private void styleInput(JComponent field) {
    field.setBorder(new CompoundBorder(
        new LineBorder(BORDER_C, 1, true),
        new EmptyBorder(6, 10, 6, 10)));
    field.setBackground(INPUT_BG);
    field.setMaximumSize(new Dimension(Integer.MAX_VALUE, 36));
    field.setAlignmentX(LEFT_ALIGNMENT);
}

private JButton makeButton(String text) {
    JButton btn = new JButton(text) {
        @Override protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(getModel().isRollover() ? new Color(20, 64, 160) : ACCENT);
            g2.fill(new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), 10, 10));
            g2.dispose();
            super.paintComponent(g);
        }
    };
    btn.setFont(new Font("SansSerif", Font.BOLD, 14));
    btn.setForeground(WHITE);
    btn.setContentAreaFilled(false);
    btn.setBorderPainted(false);
    btn.setFocusPainted(false);
    btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    btn.setMaximumSize(new Dimension(Integer.MAX_VALUE, 42));
    btn.setAlignmentX(LEFT_ALIGNMENT);
    return btn;
}

private void showMsg(String title, String msg) {
    JOptionPane.showMessageDialog(this, msg, title, JOptionPane.INFORMATION_MESSAGE);
}
private void switchToSignIn() {
    
    styleTab(signInTab, true);
    styleTab(registerTab, false);
    cardLayout.show(cardPanel, "signin");
}

private void switchToRegister() {
    styleTab(registerTab, true);
    styleTab(signInTab, false);
    cardLayout.show(cardPanel, "register");
}

// ── MAIN ─────────────────────────────────────────────────────
public static void main(String[] args) {
    SwingUtilities.invokeLater(BilPointLogin::new);
}
}