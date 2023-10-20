import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Begin {
    public Begin() {
        // initial interface
        JFrame jf = new JFrame("Computer Products Management System");
        JButton b1 = new JButton("Click to login");
        b1.setPreferredSize(new Dimension(600,200));
        ImageIcon login = new ImageIcon("login.png");
        login.setImage(login.getImage().getScaledInstance(380,180,Image.SCALE_DEFAULT));
        Font font = new Font(Font.SERIF, Font.PLAIN, 24);

        b1.setFont(font);
        b1.setIcon(login);

        //jf.setLayout(new FlowLayout());
        jf.setBounds(400, 300, 600, 250);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.add(b1);

        b1.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Login_of_system(jf);
            }
        });

    }

}
