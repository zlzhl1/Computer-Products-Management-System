import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login_of_system extends JDialog {

    JPanel jp = new JPanel(new FlowLayout());
    JPanel jp1 = new JPanel();
    JPanel jp2 = new JPanel(new FlowLayout());
    JPanel jp3 = new JPanel(new BorderLayout());
    private JFrame a;

    Login_of_system(JFrame a) {
        this.setTitle("Sales Person Login");
        this.setVisible(true);
        this.setBounds(500, 350, 200, 500);
        this.setLayout(new BorderLayout());
        //add one label
        JLabel jb1 = new JLabel("Username:");
        JTextField jNameField = new JTextField(20);
        jp.add(jb1);
        jp.add(jNameField);
        JLabel jb2 = new JLabel("Password:");
        jp2.add(jb2);
        JPasswordField jPasswordField = new JPasswordField(20);
        jp2.add(jPasswordField);
        jp3.add(jp, BorderLayout.NORTH);
        jp3.add(jp2, BorderLayout.SOUTH);
        add(jp3, BorderLayout.CENTER);
        JButton a1 = new JButton("Login");
        //a1.setSize(10,10);
        JButton a2 = new JButton("Cancel");
        //a2.setPreferredSize(new Dimension(10,10));

        jp1.add(a1);
        jp1.add(a2);

        add(jp1, BorderLayout.SOUTH);
        this.pack();

        //monitor for login
        a1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String username = jNameField.getText();
                String password = new String(jPasswordField.getPassword());
                User_mess user = null;
                if (User.COMMON_USERS.get(username) != null) {
                    user = User.COMMON_USERS.get(username);
                    if (user.getPassword().equals(password)) {
                        dispose();
                        a.dispose();
                        new Common_Face();
                    }
                }
                if (User.ADMIN_USERS.get(username) != null) {
                    user = User.ADMIN_USERS.get(username);
                    if (user.getPassword().equals(password)) {
                        dispose();
                        a.dispose();
                        new Admin_Face();
                    }
                }

                if (user == null || !user.getPassword().equals(password)) {
                    JOptionPane.showMessageDialog(jp, "Username Or Password Error!","ERROR", 0);
                }
            }
        });

        //monitor for cancel
        a2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
            }
        });
    }
}
