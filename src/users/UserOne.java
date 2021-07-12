package users;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.io.*;
import java.net.*;

public class UserOne extends JFrame implements Runnable {
    JPanel topPanel;
    JTextField t1;
    JButton sendButton;
    static JTextArea a1;

    BufferedWriter writer;
    BufferedReader reader;

    Socket socketClient;

    public UserOne() {

        topPanel = new JPanel();
        topPanel.setLayout(null);
        topPanel.setBackground(new Color(7, 94, 84));
        topPanel.setBounds(0, 0, 450, 70);
        add(topPanel);

        ImageIcon back = new ImageIcon(new ImageIcon(ClassLoader.getSystemResource("images/back.png")).getImage()
                .getScaledInstance(30, 30, Image.SCALE_DEFAULT));
        JLabel backLabel = new JLabel(back);
        backLabel.setBounds(5, 17, 30, 30);
        topPanel.add(backLabel);
        backLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent ae) {
                dispose();
            }
        });

        ImageIcon dp = new ImageIcon(new ImageIcon(ClassLoader.getSystemResource("images/dp.png")).getImage()
                .getScaledInstance(60, 60, Image.SCALE_DEFAULT));
        JLabel dpLabel = new JLabel(dp);
        dpLabel.setBounds(40, 5, 60, 60);
        topPanel.add(dpLabel);

        ImageIcon video = new ImageIcon(new ImageIcon(ClassLoader.getSystemResource("images/video.png")).getImage()
                .getScaledInstance(50, 30, Image.SCALE_DEFAULT));
        JLabel videoLabel = new JLabel(video);
        videoLabel.setBounds(270, 20, 50, 30);
        topPanel.add(videoLabel);

        ImageIcon phone = new ImageIcon(new ImageIcon(ClassLoader.getSystemResource("images/call.png")).getImage()
                .getScaledInstance(35, 30, Image.SCALE_DEFAULT));
        JLabel phoneLabel = new JLabel(phone);
        phoneLabel.setBounds(350, 20, 35, 30);
        topPanel.add(phoneLabel);

        ImageIcon dots = new ImageIcon(new ImageIcon(ClassLoader.getSystemResource("images/dot.png")).getImage()
                .getScaledInstance(13, 25, Image.SCALE_DEFAULT));
        JLabel dotsLabel = new JLabel(dots);
        dotsLabel.setBounds(410, 20, 13, 25);
        topPanel.add(dotsLabel);

        JLabel groupName = new JLabel("Avengers-HQ");
        groupName.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
        groupName.setForeground(Color.WHITE);
        groupName.setBounds(110, 15, 130, 18);
        topPanel.add(groupName);

        JLabel members = new JLabel("Tony, Steve, Thor");
        members.setFont(new Font("SAN_SERIF", Font.PLAIN, 14));
        members.setForeground(Color.WHITE);
        members.setBounds(110, 35, 160, 20);
        topPanel.add(members);

        a1 = new JTextArea();
        a1.setBounds(5, 75, 440, 570);
        a1.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
        a1.setEditable(false);
        a1.setLineWrap(true);
        a1.setWrapStyleWord(true);
        add(a1);

        t1 = new JTextField();
        t1.setBounds(5, 655, 380, 40);
        t1.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
        add(t1);

        ImageIcon send = new ImageIcon(new ImageIcon(ClassLoader.getSystemResource("images/send.png")).getImage()
                .getScaledInstance(40, 40, Image.SCALE_DEFAULT));
        JLabel sendLabel = new JLabel(send);
        sendLabel.setBounds(390, 655, 50, 40);
        sendLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent ae) {
                String str = "Tony Stark\n" + t1.getText();
                try {
                    writer.write(str);
                    writer.write("\r\n");
                    writer.flush();
                } catch (Exception e) {
                }
                t1.setText("");
            }
        });
        add(sendLabel);

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setSize(450, 700);
        setLocation(20, 50);
        setUndecorated(true);
        setVisible(true);

        try {
            socketClient = new Socket("localhost", 3003);
            writer = new BufferedWriter(new OutputStreamWriter(socketClient.getOutputStream()));
            reader = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));
        } catch (Exception e) {
        }

    }

    public void run() {
        try {
            String msg = "";
            while ((msg = reader.readLine()) != null) {
                a1.append(msg + "\n");
            }
        } catch (Exception e) {
        }
    }
}
