import users.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class App extends JFrame implements ActionListener {
    App() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.GRAY);
        panel.setBounds(0, 0, 300, 300);
        panel.setLayout(null);
        add(panel);

        JLabel label = new JLabel("Start Users");
        label.setBounds(75, 20, 200, 30);
        label.setFont(new Font("SANS_SERIF", Font.BOLD, 24));
        label.setForeground(new Color(7, 94, 84));
        panel.add(label);

        JButton user1 = new JButton("User 1");
        user1.setBounds(100, 80, 80, 30);
        user1.setFont(new Font("SANS_SERIF", Font.PLAIN, 14));
        user1.setBackground(new Color(7, 94, 84));
        user1.setForeground(Color.WHITE);
        user1.addActionListener(this);
        panel.add(user1);

        JButton user2 = new JButton("User 2");
        user2.setBounds(20, 150, 80, 30);
        user2.setFont(new Font("SANS_SERIF", Font.PLAIN, 14));
        user2.setBackground(new Color(7, 94, 84));
        user2.setForeground(Color.WHITE);
        user2.addActionListener(this);
        panel.add(user2);

        JButton user3 = new JButton("User 3");
        user3.setBounds(180, 150, 80, 30);
        user3.setFont(new Font("SANS_SERIF", Font.PLAIN, 14));
        user3.setBackground(new Color(7, 94, 84));
        user3.setForeground(Color.WHITE);
        user3.addActionListener(this);
        panel.add(user3);

        setTitle("Start Menu");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(null);
        setSize(300, 300);
        setLocation(500, 300);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String user = e.getActionCommand();

        switch (user) {
            case "User 1":
                UserOne user1 = new UserOne();
                Thread t1 = new Thread(user1);
                t1.start();
                break;

            case "User 2":
                UserSecond user2 = new UserSecond();
                Thread t2 = new Thread(user2);
                t2.start();
                break;

            case "User 3":
                UserThird user3 = new UserThird();
                Thread t3 = new Thread(user3);
                t3.start();
                break;
        }
    }

    public static void main(String[] args) throws Exception {
        JOptionPane.showMessageDialog(null,
                "Sagar Pratim Baruah: 190310007039\nSazzadur Rahman: 190310007043\nVicky Baishya: 190310007051",
                "Made BY", 1);
        new App();
    }

}
