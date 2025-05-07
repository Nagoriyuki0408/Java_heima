package com.itshiokou.gui2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame implements ActionListener {
    public LoginFrame() {
        this.setTitle("登录界面");
        this.setSize(400, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        init();
    }
    private void init() {
        //需要一个登录按钮
        JButton loginButton = new JButton("登录");
       loginButton.addActionListener(this);
        JPanel pannel = new JPanel();
        this.add(pannel);
        pannel.add(loginButton);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(this, "我被点击了");
    }
}
